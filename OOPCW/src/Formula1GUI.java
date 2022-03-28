import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.*;

class Formula1GUI extends JFrame implements ActionListener{
    Formula1ChampionshipManager f1Manager = new Formula1ChampionshipManager();

    JButton Sort_ASC, Sort_P1, Reset, GenRace, GenRaceStart, Sort_Races, Search;
    JTable DTable, RTable, DRTable;
    JTextField DName;
    JScrollPane DScroll, RScroll, DRScroll;
    JLabel Label1,Label2,Label3;
    DefaultTableModel DModel, RModel, DRModel;

    public Formula1GUI(){
        CreateDTable();
        CreateRTable();
        CreateDRTable();

        Sort_ASC = new JButton("Sort (ASC)");
        Sort_P1 = new JButton("Sort (P1)");
        Reset = new JButton("Reset");
        GenRace = new JButton("Generate Race");
        GenRaceStart = new JButton("Generate Race & Starting Positions");
        Sort_Races = new JButton("Sort All Races");
        Search = new JButton("Search");

        Label1 = new JLabel("-----------------------------------------------------------  F1 CHAMPIONSHIP 2021  -----------------------------------------------------------");
        Label2 = new JLabel("Enter Driver name : ");
        Label3 = new JLabel("");

        DName = new JTextField(15);

        add(Label1);
        add(Sort_ASC);
        add(Sort_P1);
        add(Reset);
        add(DScroll);
        add(GenRace);
        add(GenRaceStart);
        add(Sort_Races);
        add(RScroll);
        add(Label2);
        add(DName);
        add(Search);
        add(Label3);
        add(DRScroll);

        Sort_ASC.addActionListener(this);
        Sort_P1.addActionListener(this);
        Reset.addActionListener(this);
        GenRace.addActionListener(this);
        GenRaceStart.addActionListener(this);
        Sort_Races.addActionListener(this);
        Search.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()== Sort_ASC){
            f1Manager.SortASC();
            //System.out.println("Sort (ASC) Clicked!");
            AdjustTable();
        }else if(e.getSource()==Sort_P1){
            f1Manager.SortP1();
            //System.out.println("Sort (P1) Clicked!");
            AdjustTable();
        } else if(e.getSource()== Reset){
            f1Manager.SortDESC();
            //System.out.println("Reset Clicked!");
            AdjustTable();
        } else if(e.getSource()== GenRace){
            f1Manager.GenerateRace();
            //System.out.println("Generate Race Clicked!");
            AdjustTable();
        } else if(e.getSource()== Sort_Races) {
            try {
                f1Manager.SortRaces();
            } catch (ParseException parseException) {
                parseException.printStackTrace();
            }
            //System.out.println("Sort All Races Clicked!");
            AdjustTable();
        } else if(e.getSource()== Search){
            ViewDRTable(DName.getText());
            //System.out.println("Generate Race Clicked!");
            AdjustTable();
        }else if(e.getSource()== GenRaceStart){
            f1Manager.GenerateRace();
            AdjustTable();
        }
    }

    //Method to Create the Drivers Table
    public void CreateDTable(){
        String [] DColumns = {"Driver","Team","Pts","P1"};
        DModel = new DefaultTableModel(DColumns,0){
            public Class getColumnClass(int column){
                if(column==0){
                    return String.class;
                }
                return Integer.class;
            }
        };
        DTable = new JTable(DModel);
        DTable.setPreferredScrollableViewportSize(new Dimension(620, 150));
        DTable.setFillsViewportHeight(true);
        DTable.setEnabled(false);
        DScroll = new JScrollPane(DTable);

        for(int i = 0; i< Formula1ChampionshipManager.DL.size(); i++){
            Object[] DRow = {Formula1ChampionshipManager.DL.get(i).getName(), Formula1ChampionshipManager.DL.get(i).getDTeam(), Formula1ChampionshipManager.DL.get(i).getPoints(), Formula1ChampionshipManager.DL.get(i).getP1()};
            DModel.addRow(DRow);
        }

        TableRowSorter<TableModel> DSorter = new TableRowSorter<>(DModel);
        DTable.setRowSorter(DSorter);

        ArrayList<RowSorter.SortKey> DSortList = new ArrayList<>(25);
        DSortList.add(new RowSorter.SortKey(3,SortOrder.DESCENDING));
        DSortList.add(new RowSorter.SortKey(4,SortOrder.DESCENDING));
    }

    //Method to Create the Races Table
    public void CreateRTable(){
        String [] RColumns = {"Date","Top 10"};
        RModel = new DefaultTableModel(RColumns,0){
            public Class getColumnClass(int column){
                if(column==0){
                    return String.class;
                }
                return Integer.class;
            }
        };
        RTable = new JTable(RModel);
        RTable.setPreferredScrollableViewportSize(new Dimension(675, 150));
        RTable.setFillsViewportHeight(true);
        RTable.setEnabled(false);
        RScroll = new JScrollPane(RTable);

        for(int i = 0; i< Formula1ChampionshipManager.RL.size(); i++){
            Object [] RRow = {Formula1ChampionshipManager.RL.get(i).date, Formula1ChampionshipManager.RL.get(i).NL};
            RModel.addRow(RRow);
        }
    }

    //Method to Create the Races & Drivers Table
    public void CreateDRTable(){
        String [] DRColumns = {"Date","Position"};
        DRModel = new DefaultTableModel(DRColumns,0);
        DRTable = new JTable(DRModel);
        DRTable.setPreferredScrollableViewportSize(new Dimension(620, 150));
        DRTable.setFillsViewportHeight(true);
        DRTable.setEnabled(false);
        DRScroll = new JScrollPane(DRTable);
    }

    //Method to Adjust table after making changes
    public void AdjustTable(){
        DModel.setRowCount(0);
        RModel.setRowCount(0);

        for(int i = 0; i< Formula1ChampionshipManager.DL.size(); i++){
            Object[] DRow = {Formula1ChampionshipManager.DL.get(i).getName(), Formula1ChampionshipManager.DL.get(i).getDTeam(), Formula1ChampionshipManager.DL.get(i).getPoints(), Formula1ChampionshipManager.DL.get(i).getP1()};
            DModel.addRow(DRow);
        }

        for(int i = 0; i< Formula1ChampionshipManager.RL.size(); i++){
            Object [] RRow = {Formula1ChampionshipManager.RL.get(i).date, Formula1ChampionshipManager.RL.get(i).NL};
            RModel.addRow(RRow);
        }
    }

    //Method to add data to Drivers & Races table
    public void ViewDRTable(String string){
        DRModel.setRowCount(0);
        for(Formula1Race race : Formula1ChampionshipManager.RL){
            if(race.NL.contains(string)){
                Object [] row = {race.date, race.getPosition(string)};
                DRModel.addRow(row);
            }
        }
    }

}
