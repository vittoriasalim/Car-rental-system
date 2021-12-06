// Displayer class. Handles all the displaying 
public class Displayer {
  
  //layout for main menu
  public void MainMenu()
  {
    System.out.println("===================================");
    System.out.println("|       CAR   RENTAL   SYSTEM     |");
    System.out.println("===================================");
    System.out.println("1. Add Cars from File");
    System.out.println("2. Add Single Car");
    System.out.println("3. Display Cars");
    System.out.println("4. Rent Car");
    System.out.println("5. Return Car");
    System.out.println("6. Exit");
    System.out.print("Choose an option:");
  }
  //add car option and layout
  public void AddCar()
  {
    //header
    System.out.println("===================================");
    System.out.println("|            ADD A CAR            |");
    System.out.println("===================================");
    //option
    System.out.println("Select car type to add");
    System.out.println("1. Sedan");
    System.out.println("2. Coupe");
    System.out.println("3. Crossover");
    System.out.println("4. Convertible");
    System.out.print("Select car type to add:Enter car type:");
   
  }
  //return car layout
  public void ReturnCar()
  {
    //header
    System.out.println("===================================");
    System.out.println("|          RETURN A CAR           |");
    System.out.println("===================================");
    
  }
  //display car layout
  public void ChooseDisplayCar()
  {
    //header
    System.out.println("===================================");
    System.out.println("|           DISPLAY CAR           |");
    System.out.println("===================================");
    //opition layout
    System.out.println("Select car type to add");
    System.out.println("1. Sedan");
    System.out.println("2. Coupe");
    System.out.println("3. Crossover");
    System.out.println("4. Convertible");
    System.out.println("5. All Car");
  }
  //rent car option
  public void RentCar()
  {
    //header
    System.out.println("===================================");
    System.out.println("|      CIMP Car Rental System     |");
    System.out.println("===================================");
    
  }
  //display car layout
  public void DisplayCar()
  {
    //header
    System.out.println("\tCODE\t\tMAKE\t\tMODEL\t\tOTHER INFO\tMILEAGE\t\t  RENTER\tALOWABLE KM\t\tDUE DATE");    
    System.out.println("=====================================================================================================================================");
    
  }
}
