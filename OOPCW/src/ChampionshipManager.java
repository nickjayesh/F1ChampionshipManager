import java.text.ParseException;
import java.util.Date;

public interface ChampionshipManager {

    //Method to add a driver to Championship
    void CreateDriver();

    //Method to display all drivers in Championship
    void DisplayDrivers();

    //Method to assign stats to drivers in Championship
    void AssignStat();

    //Method to remove a driver from Championship
    void RemoveDriver();

    //Method to change team in Championship
    void ChangeTeam();

    //Method to print all stats of an individual driver in the championship
    void PrintStat();

    //Method to sort and print Championship Driver table
    void PrintDriverTable();

    //Method to add a race to Championship
    void AddRace();

    //Method to print all existing races in Championship
    void PrintRaceTable();

    //Method to save data into a file
    void SaveData();

    //Method to retrieve saved data
    void LoadData();

    //Method to launch the GUI
    void LaunchGUI();

    //Method to sort the drivers in ascending order of their points
    void SortASC();

    //Method to sort drivers in descending order of the number of first positions obtained
    void SortP1();

    //Method to sort the drivers in descending order
    void SortDESC();

    //Method to auto-generate a race
    void GenerateRace();

    //Method to convert string to date format
    Date ConvertToDate(String string) throws ParseException;

    //Method to sort races in ascending order of dates of races
    void SortRaces() throws ParseException;

}
