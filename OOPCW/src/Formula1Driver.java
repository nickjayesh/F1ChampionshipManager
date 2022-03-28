import java.io.Serializable;


public class Formula1Driver extends Driver implements Serializable{
    private String DName;
    private String DNationality;
    private String DTeam;
    private int p1; //first position finishes
    private int p2; //second position finishes
    private int p3; //third position finishes
    private int p4; //fourth position finishes
    private int p5; //fifth position finishes
    private int p6; //sixth position finishes
    private int p7; //seventh position finishes
    private int p8; //eighth position finishes
    private int p9; //ninth position finishes
    private int p10; //tenth position finishes
    private int points;
    private int noOfRaces;

    //Constructor for Formula1 Driver
    public Formula1Driver(){
        p1=0;
        p2=0;
        p3=0;
        p4=0;
        p5=0;
        p6=0;
        p7=0;
        p8=0;
        p9=0;
        p10=0;
        points=0;
        noOfRaces=0;
    }
    //Setter for driver's name
    public void setDName(String dName){
        DName=dName;
    }
    //Setter for driver's nationality
    public void setDNationality(String dNationality){
        DNationality=dNationality;
    }
    //Setter for driver's team (constructor)
    public void setDTeam(String team){
        DTeam=team;
    }

    //Setter for driver statistics
    public void setStat(int P1,int P2,int P3,int P4,int P5,int P6,int P7,int P8,int P9,int P10,int NOR){
        p1=P1;
        p2=P2;
        p3=P3;
        p4=P4;
        p5=P5;
        p6=P6;
        p7=P7;
        p8=P8;
        p9=P9;
        p10=P10;
        points=P1*25+P2*18+P3*15+P4*12+P5*10+P6*8+P7*6+P8*4+P9*2+P10;
        noOfRaces=NOR;
    }

    //Method to display Individual Information of a driver
    public void DisplayStatInd(){
        System.out.println("Driver Name        :"+DName);
        System.out.println("Driver Nationality :"+DNationality);
        System.out.println("Driver Team        :"+DTeam);
        System.out.println("Position 1s        :"+p1);
        System.out.println("Position 2s        :"+p2);
        System.out.println("Position 3s        :"+p3);
        System.out.println("Points             :"+points);
        System.out.println("Number of Races    :"+noOfRaces+"\n");
    }

    public String getName(){
        return DName;
    }

    public String getDTeam(){
        return DTeam;
    }

    public int getP1(){
        return p1;
    }

    //Getter for driver points
    public int getPoints(){
        return points;
    }

    //Method to display in table format
    public void displayTableFormat(){
        System.out.format("%5s%32s%32s", DName, DTeam, points+"\n");
    }

    //Method to add P1 in a race
    public void addP1(){
        p1=p1+1;
    }
    //Method to add P2 in a race
    public void addP2(){
        p2=p2+1;
    }
    //Method to add P3 in a race
    public void addP3(){
        p3=p3+1;
    }
    //Method to add P4 in a race
    public void addP4(){
        p4=p4+1;
    }
    //Method to add P5 in a race
    public void addP5(){
        p5=p5+1;
    }
    //Method to add P6 in a race
    public void addP6(){
        p6=p6+1;
    }
    //Method to add P7 in a race
    public void addP7(){
        p7=p7+1;
    }
    //Method to add P8 in a race
    public void addP8(){
        p8=p8+1;
    }
    //Method to add P9 in a race
    public void addP9(){
        p9=p9+1;
    }
    //Method to add P10 in a race
    public void addP10(){
        p10=p10+1;
    }
    //Method to add a race
    public void addRace(){
        noOfRaces=noOfRaces+1;
    }
    //Method to calculate points
    public void calcPoints(){
        points=p1*25+p2*18+p3*15+p4*12+p5*10+p6*8+p7*6+p8*4+p9*2+p10;
    }

}
