abstract class Driver{
    private String DName;
    private String DNationality;
    private String DTeam;

    public Driver (){
    }

    public Driver (String dName, String dNationality, String dTeam){
        this.DName = dName;
        this.DNationality = dNationality;
        this.DTeam = dTeam;
    }
}