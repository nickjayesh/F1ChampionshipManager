import java.io.Serializable;
import java.util.ArrayList;

public class Formula1Race implements Serializable {

    //Used to store the top 10 Drivers
    public ArrayList<Formula1Driver> PL = new ArrayList<>();
    //Used to store the names of the 10 Drivers
    public ArrayList<String> NL = new ArrayList<>();

    public String date;
    public Formula1Driver P1;
    public Formula1Driver P2;
    public Formula1Driver P3;
    public Formula1Driver P4;
    public Formula1Driver P5;
    public Formula1Driver P6;
    public Formula1Driver P7;
    public Formula1Driver P8;
    public Formula1Driver P9;
    public Formula1Driver P10;

    public Formula1Race(){
    }


    public String getP1() {
        return P1.getName();
    }

    //Method to display in table format
    public void displayRaceTable(){
        System.out.format("%8s%30s", date, getP1()+"\n");
    }

    //Method to set the NL arraylist
    public void setDrivers(){
        for (Formula1Driver formula1Driver : PL) {
            NL.add(formula1Driver.getName());
        }
    }

    //Method to get position in a race of a given driver
    public int getPosition(String string){
        int pos=0;
        for(int i=0;i<NL.size();i++){
            if(string.equals(NL.get(i))){
                pos=i+1;
                break;
            }
        }
        return pos;
    }
}
