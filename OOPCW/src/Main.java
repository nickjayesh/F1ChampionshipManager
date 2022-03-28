import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Formula1ChampionshipManager f1Manager = new Formula1ChampionshipManager();
        Scanner scan = new Scanner(System.in);

        System.out.println("F1 CHAMPIONSHIP 2021");
        System.out.println("----------- Menu ----------");

        System.out.println(
                """ 
                Select a number according to the option desired
                1 - Add a new driver
                2 - Add driver's statistics
                3 - Remove a driver
                4 - Change a driver's constructor team
                5 - Display a driver's statistics
                6 - Display the F1 Championship leaderboard
                7 - Add a new race
                8 - Display all races
                9 - Save all data
                10 - Retrieve all saved data
                11 - Launch GUI
                0 - Exit Program
                        """
        );
        System.out.print("Enter your number here:");
        String input = scan.nextLine();
        int userInput;

        try{
            userInput = Integer.parseInt(input);
        }
        catch (NumberFormatException ex){
            userInput = 12;
        }

        while (true){
            if(userInput==0){
                break;
            }
            switch(userInput){
                case 1:{
                    f1Manager.CreateDriver();
                    break;
                }
                case 2:{
                    f1Manager.AssignStat();
                    break;
                }
                case 3:{
                    f1Manager.RemoveDriver();
                    break;
                }
                case 4:{
                    f1Manager.ChangeTeam();
                    break;
                }
                case 5:{
                    f1Manager.PrintStat();
                    break;
                }
                case 6:{
                    f1Manager.PrintDriverTable();
                    break;
                }
                case 7:{
                    f1Manager.AddRace();
                    break;
                }
                case 8:{
                    f1Manager.PrintRaceTable();
                }
                case 9:{
                    f1Manager.SaveData();
                    break;
                }
                case 10:{
                    f1Manager.LoadData();
                    break;
                }
                case 11:{
                    f1Manager.LaunchGUI();
                    break;
                }
                default:{
                    System.out.println("\nEnter valid input please!\n");
                    break;
                }
            }
            System.out.println(
                    """ 
                Select a number according to the option desired
                1 - Add a new driver
                2 - Add driver's statistics
                3 - Remove a driver
                4 - Change a driver's constructor team
                5 - Display a driver's statistics
                6 - Display the F1 Championship leaderboard
                7 - Add a new race
                8 - Display all races
                9 - Save all data
                10 - Retrieve all saved data
                11 - Launch GUI
                0 - Exit Program
                            """
            );
            System.out.print("Enter your number here:");
            input = scan.nextLine();
            try{
                userInput = Integer.parseInt(input);
            }
            catch (NumberFormatException ex){
                userInput = 12;
            }
            if(userInput==0){
                    break;
            }
        }
    }
}
