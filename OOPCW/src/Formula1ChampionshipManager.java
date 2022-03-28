import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

public class Formula1ChampionshipManager implements ChampionshipManager {
    private int noOfCars=0;
    private int noOfDrivers=0;
    public static final ArrayList<Formula1Driver> DL = new ArrayList<>();
    public static final ArrayList<Formula1Race> RL = new ArrayList<>();

    //Method to add a driver to the Formula 1 Championship
    public void CreateDriver(){
        Formula1Driver FD = new Formula1Driver();

        System.out.print("Enter driver's name:");
        String dName = new Scanner(System.in).nextLine();

        System.out.print("Enter driver's nationality:");
        String dNationality = new Scanner(System.in).nextLine();

        System.out.print("Enter driver's team:");
        String dTeam = new Scanner(System.in).nextLine();

        FD.setDName(dName);
        FD.setDNationality(dNationality);
        FD.setDTeam(dTeam);

        DL.add(FD);
        noOfDrivers=noOfDrivers+1;
        noOfCars=noOfCars+1;

        System.out.println("\nNew Driver input successful!\n");
    }

    //Method to display all drivers
    public void DisplayDrivers(){
        for(int i=0;i<DL.size();i++){
            System.out.println(i+" : "+DL.get(i).getName());
        }
    }

    //Method to assign stats to drivers
    public void AssignStat(){
        System.out.println("\nSelect the given number for the driver");
        DisplayDrivers();
        System.out.print("Enter number here :");
        int driverNo = new Scanner(System.in).nextInt();

        int [] positions = new int[10];
        for(int j=0;j<10;j++){
            int p=j+1;
            System.out.print("Enter the number of "+p+" positions :");
            int pos = new Scanner(System.in).nextInt();
            positions[j]=pos;
        }
        System.out.print("Enter the total number of races :");
        int nor = new Scanner(System.in).nextInt();
        DL.get(driverNo).setStat(positions[0],positions[1],positions[2],positions[3],positions[4],positions[5],positions[6],positions[7],positions[8],positions[9],nor);

        System.out.println("\nSuccessfully updated driver statistics!\n");
    }

    //Method to remove a driver from a Formula 1 Championship
    public void RemoveDriver(){
        System.out.println("\nSelect the given number for the driver");
        DisplayDrivers();
        System.out.print("Enter number here :");
        int driverNo = new Scanner(System.in).nextInt();

        DL.remove(driverNo);
        noOfDrivers=noOfDrivers-1;
        noOfCars=noOfCars-1;

        System.out.println("\nDriver has been removed successfully!\n");
    }

    //Method to change team
    public void ChangeTeam(){
        System.out.println("\nSelect the given number for the driver");
        DisplayDrivers();
        System.out.print("Enter number here :");
        int driverNo = new Scanner(System.in).nextInt();

        System.out.print("Enter new team here :");
        String team = new Scanner(System.in).nextLine();

        DL.get(driverNo).setDTeam(team);

        System.out.println("\nUpdate completed successfully!\n");
    }

    //Method to print all stats of an individual driver
    public void PrintStat(){
        System.out.println("\nSelect the given number for the driver");
        DisplayDrivers();
        System.out.print("Enter number here :");
        int driverNo = new Scanner(System.in).nextInt();
        DL.get(driverNo).DisplayStatInd();
    }

    //Method to sort and print Formula 1 Driver table
    public void PrintDriverTable(){
        System.out.println("\nF1 CHAMPIONSHIP 2021 LEADERBOARD\n");
        Formula1Driver temp;
        for (int i = 0; i < DL.size(); i++) {
            int m=i;
            for (int j = i+1; j < DL.size(); j++) {
                if(DL.get(i).getPoints() < DL.get(j).getPoints()) {
                    m=j;
                }
            }
            temp = DL.get(i);
            DL.set(i, DL.get(m));
            DL.set(m,temp);
        }
        System.out.format("%5s%32s%32s", "Driver","Team", "Pts\n");
        for (Formula1Driver formula1Driver : DL) {
            formula1Driver.displayTableFormat();
        }
        System.out.println("\n--------------------------------\n");
    }

    //Method to add a race
    public void AddRace() {

        Scanner driverNo = new Scanner(System.in);

        Formula1Race race = new Formula1Race();
        RL.add(race);

        System.out.print("\nEnter race date (DD/MM/YYYY) :");
        race.date= new Scanner(System.in).nextLine();

        System.out.println("\nSelect the given number for the driver");
        DisplayDrivers();

        System.out.print("Enter Race Winner :");
        int p1 = driverNo.nextInt();
        DL.get(p1).addP1();
        DL.get(p1).calcPoints();
        race.P1=DL.get(p1);
        race.PL.add(DL.get(p1));

        System.out.print("Enter P2 :");
        int p2 = driverNo.nextInt();
        DL.get(p2).addP2();
        DL.get(p2).calcPoints();
        race.P2=DL.get(p2);
        race.PL.add(DL.get(p2));

        System.out.print("Enter P3 :");
        int p3 = driverNo.nextInt();
        DL.get(p3).addP3();
        DL.get(p3).calcPoints();
        race.P3=DL.get(p3);
        race.PL.add(DL.get(p3));

        System.out.print("Enter P4 :");
        int p4 = driverNo.nextInt();
        DL.get(p4).addP4();
        DL.get(p4).calcPoints();
        race.P4=DL.get(p4);
        race.PL.add(DL.get(p4));

        System.out.print("Enter P5 :");
        int p5 = driverNo.nextInt();
        DL.get(p5).addP5();
        DL.get(p5).calcPoints();
        race.P5=DL.get(p5);
        race.PL.add(DL.get(p5));

        System.out.print("Enter P6 :");
        int p6 = driverNo.nextInt();
        DL.get(p6).addP6();
        DL.get(p6).calcPoints();
        race.P6=DL.get(p6);
        race.PL.add(DL.get(p6));

        System.out.print("Enter P7 :");
        int p7 = driverNo.nextInt();
        DL.get(p7).addP7();
        DL.get(p7).calcPoints();
        race.P7=DL.get(p7);
        race.PL.add(DL.get(p7));

        System.out.print("Enter P8 :");
        int p8 = driverNo.nextInt();
        DL.get(p8).addP8();
        DL.get(p8).calcPoints();
        race.P8=DL.get(p8);
        race.PL.add(DL.get(p8));

        System.out.print("Enter P9 :");
        int p9 = driverNo.nextInt();
        DL.get(p9).addP9();
        DL.get(p9).calcPoints();
        race.P9=DL.get(p9);
        race.PL.add(DL.get(p9));

        System.out.print("Enter P10 :");
        int p10 = driverNo.nextInt();
        DL.get(p10).addP10();
        DL.get(p10).calcPoints();
        race.P10=DL.get(p10);
        race.PL.add(DL.get(p10));


        for (Formula1Driver formula1Driver : DL) {
            formula1Driver.addRace();
        }
        race.setDrivers();

        System.out.println("\nRace successfully updated!\n");
    }

    //Method to print all existing races
    public void PrintRaceTable(){
        System.out.println("\nF1 CHAMPIONSHIP 2021 LEADERBOARD\n");
        System.out.format("%8s%32s","Date", "Winner\n");
        for (Formula1Race formula1Race : RL) {
            formula1Race.displayRaceTable();
        }
        System.out.println("\n--------------------------------\n");
    }

    //Method to save data into a file
    public void SaveData(){
        //Writing driver details into a file
        try{
            FileOutputStream writeData1 = new FileOutputStream("ChampionshipData.ser");
            ObjectOutputStream writeStream1 = new ObjectOutputStream(writeData1);

            writeStream1.writeObject(DL);
            writeStream1.flush();
            writeStream1.close();

        }catch (IOException e) {
            e.printStackTrace();
        }
        //Writing race details into a file
        try{
            FileOutputStream writeData2 = new FileOutputStream("RaceData.ser");
            ObjectOutputStream writeStream2 = new ObjectOutputStream(writeData2);

            writeStream2.writeObject(RL);
            writeStream2.flush();
            writeStream2.close();

        }catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("\nData saved successfully!\n");
    }

    //Method to retrieve saved data
    public void LoadData(){
        try{
            FileInputStream readData1 = new FileInputStream("ChampionshipData.ser");
            ObjectInputStream readStream1 = new ObjectInputStream(readData1);

            DL.addAll((ArrayList<Formula1Driver>) readStream1.readObject());
            readStream1.close();
            //System.out.println(DL);
        }catch (Exception e) {
            e.printStackTrace();
        }

        try{
            FileInputStream readData2 = new FileInputStream("RaceData.ser");
            ObjectInputStream readStream2 = new ObjectInputStream(readData2);

            RL.addAll((ArrayList<Formula1Race>) readStream2.readObject());
            readStream2.close();
            //System.out.println(RL);
        }catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("\nData retrieved successfully!\n");
    }

    //Method to launch the GUI
    public void LaunchGUI(){
        Formula1GUI myFormula1GUI = new Formula1GUI();

        myFormula1GUI.setLayout(new FlowLayout());
        myFormula1GUI.setVisible(true);
        myFormula1GUI.setSize(700, 750);
        //Program ends after closing the window
        myFormula1GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        System.out.println("\nGUI launched successfully!\n");
    }

    //Method to sort the drivers in ascending order of their points
    public void SortASC(){
        Formula1Driver temp;
        for (int i = 0; i < DL.size(); i++) {
            int m=i;
            for (int j = i+1; j < DL.size(); j++) {
                if(DL.get(i).getPoints() > DL.get(j).getPoints()) {
                    m=j;
                }
            }
            temp = DL.get(i);
            DL.set(i, DL.get(m));
            DL.set(m,temp);
        }
    }

    //Method to sort drivers in descending order of the number of first positions obtained
    public void SortP1(){
        Formula1Driver temp;
        for (int i = 0; i < DL.size(); i++) {
            int m=i;
            for (int j = i+1; j < DL.size(); j++) {
                if(DL.get(i).getP1() < DL.get(j).getP1()) {
                    m=j;
                }
            }
            temp = DL.get(i);
            DL.set(i, DL.get(m));
            DL.set(m,temp);
        }
    }

    //Method to sort the drivers in descending order
    public void SortDESC(){
        Formula1Driver temp;
        for (int i = 0; i < DL.size(); i++) {
            int m=i;
            for (int j = i+1; j < DL.size(); j++) {
                if(DL.get(i).getPoints() < DL.get(j).getPoints()) {
                    m=j;
                }
            }
            temp = DL.get(i);
            DL.set(i, DL.get(m));
            DL.set(m,temp);
        }
    }

    //Method to auto-generate a race
    public void GenerateRace(){
        Formula1Race race = new Formula1Race();

        int day = (int) (Math.random() * (30 - 1 + 1) + 1);
        int month = (int) (Math.random() * (12 - 1 + 1) + 1);
        int year = (int) (Math.random() * (2021 - 2015 + 1) + 2015);

        String Day = String.valueOf(day);
        String Month = String.valueOf(month);
        String Year = String.valueOf(year);

        race.date= Day + "/" + Month + "/" + Year;

        ArrayList<Integer> temp = new ArrayList<>();
        Formula1Driver [] TopList = new Formula1Driver[10];


        while (temp.size() != 10) {
            for(Formula1Driver Driver:DL){
                //System.out.println(Driver.getName());
                int pos = (int) (Math.random() * (10 - 1 + 1) + 1);
                while (temp.contains(pos)) {
                    pos = (int) (Math.random() * (10 - 1 + 1) + 1);
                }
                temp.add(pos);
                switch (pos) {
                    case 1 -> {
                        Driver.addP1();
                        TopList[0] = Driver;
                    }
                    case 2 -> {
                        Driver.addP2();
                        TopList[1] = Driver;
                    }
                    case 3 -> {
                        Driver.addP3();
                        TopList[2] = Driver;
                    }
                    case 4 -> {
                        Driver.addP4();
                        TopList[3] = Driver;
                    }
                    case 5 -> {
                        Driver.addP5();
                        TopList[4] = Driver;
                    }
                    case 6 -> {
                        Driver.addP6();
                        TopList[5] = Driver;
                    }
                    case 7 -> {
                        Driver.addP7();
                        TopList[6] = Driver;
                    }
                    case 8 -> {
                        Driver.addP8();
                        TopList[7] = Driver;
                    }
                    case 9 -> {
                        Driver.addP9();
                        TopList[8] = Driver;
                    }
                    case 10 -> {
                        Driver.addP10();
                        TopList[9] = Driver;
                    }
                }
                Driver.calcPoints();
                Driver.addRace();
            }
        }
        for(int i=0;i<10;i++){
            race.PL.add(TopList[i]);
            race.NL.add(TopList[i].getName());
        }
        RL.add(race);
        SaveData();
    }

    //Method to convert string to date format
    public Date ConvertToDate(String string) throws ParseException {
        return new SimpleDateFormat("dd/MM/yyyy").parse(string);
    }

    //Method to sort races in ascending order of dates of races
    public void SortRaces() throws ParseException {
        Formula1Race temp;
        for (int i = 0; i < RL.size(); i++) {
            int m = i;
            for (int j = i + 1; j < RL.size(); j++) {
                if (ConvertToDate(RL.get(i).date).after(ConvertToDate(RL.get(j).date))) {
                    m = j;
                }
            }
            temp = RL.get(i);
            RL.set(i, RL.get(m));
            RL.set(m, temp);
        }
    }


    public void getStartingPositions(){
        //The starting list for a race
        Collections.shuffle(DL);
        ArrayList<Formula1Driver> SL = new ArrayList<>(DL);
    }
}

