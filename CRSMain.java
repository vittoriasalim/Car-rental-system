//importing scanner to the system
import java.util.Scanner;
public class CRSMain {
  public static void main(String[] args) {
    CRS crs = new CRS();                         // DO NOT DELETE: Creates a CRS object to keep track of the system
    Displayer disp = new Displayer();            // DO NOT DELETE: Used for handling all the displaying
    
    String carListFilename = "CarList.txt";      // The filename of the dummy file that has all the cars information
    
    
    Scanner input = new Scanner (System.in);
    //indicating each varibles
    int option,carType,crossOverInfo,addCarFile,display,rentCode,numDays,returnCode;
    String carMake,carModel,sedanInfo,renter;
    int dist;
    
    boolean coupeInfo;
    double convertibleInfo;
    
    
    //do while loop to loop main program or display for user to choose
    do
    {
      //MAIN MENU
      disp.MainMenu();
      option = input.nextInt();
      
      
      
      //add car from file
      if(option ==1)
      {
        //call CRS method to add car from file
        addCarFile = crs.AddCar(carListFilename);
        System.out.println("Successfully added "+addCarFile+"  the system");
        
      }
      //add single car
      else if (option ==2)
      {
        //display car option and header
        disp.AddCar();
        carType = input.nextInt();
        input.nextLine();
        System.out.print("\nEnter car make:");
        carMake = input .nextLine();
        System.out.print("\nEnter car model:");
        carModel = input.nextLine();
        //check car type chosen to be added into the system
        //"sedan"
        if(carType==1)
        {
          System.out.print("Enter sedan info:");
          sedanInfo = input.nextLine();
          //call out add single car method from CRS 
          boolean status = crs.AddCar(carType-1,carMake,carModel,sedanInfo );
          //check if sedan has been succesfully added or not
          if(status == true )
          {
            //print out message
            System.out.println("Succesfully added "+"\'"+carModel+"\'");
          }
          //if sedan cant be add
          else if(status == false)
          {
            System.out.println("Unsuccesfully added "+"\'"+carModel+"\'");
          }
        }
        //check car type chosen 
        //"coupe"
        else if(carType==2)
        {
          System.out.print("Enter if coupe has any back seats(true/false):");
          coupeInfo = input.nextBoolean();
          //call car single car method
          boolean status =crs.AddCar(carType-1 ,carMake,carModel,""+coupeInfo );
          //check if coupe is added
          if(status == true )
          {
            //print out message
            System.out.println("Succesfully added "+"\'"+carModel+"\'");
          }
          //if coupe cant be add
          else if(status == false)
          {
            //message error
            System.out.println("Unsuccesfully added "+"\'"+carModel+"\'");
          }
        }
        //check chosen type
        //crossover
        else if(carType==3)
        {
          System.out.println("Enter if cross-over info");
          crossOverInfo = input.nextInt();
          //call crossover method
          boolean status =crs.AddCar(carType-1 ,carMake,carModel,""+crossOverInfo );
          //if corssover is added
          if(status == true )
          {
            //print out message
            System.out.println("Succesfully added "+"\'"+carModel+"\'");
          }
          //if crossover is not added
          else if(status == false)
          {
            //message if crossover cant be added
            System.out.println("Unsuccesfully added "+"\'"+carModel+"\'");
          }
        }
        //check if convertible is chosen
        else if(carType==4)
        {
          System.out.println("Enter if convertible info:");
          convertibleInfo = input.nextDouble();
          //call convertible method
          boolean status =crs.AddCar(carType-1 ,carMake,carModel,""+convertibleInfo );
          //check if convertible is added
          if(status == true )
          {
            //print out message
            System.out.println("Succesfully added "+"\'"+carModel+"\'");
          }
          //if convertible is not added
          else if(status == false)
          {
            //error message
            System.out.println("Unsuccesfully added "+"\'"+carModel+"\'");
          }
        }
        //if cartype is not in the option
        else if (carType != 1||carType!=2||carType!=3||carType!=4)
        {
          System.out.println("option is not in the system");
        }
        
      }
      //to display car data
      else if (option ==3)
      {
        //layout of car
        //car header and option of car type to be displayed
        disp.ChooseDisplayCar();
        display = input.nextInt();
        //if user choose sedan
        if(display ==1)
        {
          //display sedan 
          disp.DisplayCar();
          crs.DisplaySedan();
        }
        //if user choose coupe
        else if(display ==2)
        {
          //display coupe
          disp.DisplayCar();
          crs.DisplayCoupe();
        }
        //if user choose crossover 
        else if (display ==3)
        {
          //display crossover
          disp.DisplayCar();
          crs.DisplayCrossover();
        }
        //if user choose convertible
        else if (display ==4)
        {
          //display convertible
          disp.DisplayCar();
          crs.DisplayConvertible();
        }
        
        
        //if user choose all car to be displayed
        else if (display ==5)
        {
          //display all car
          disp.DisplayCar();
          crs.DisplayAllCar();
        }
        //if option is not in the layout
        else if (display !=1||display!=2||display!=3||display!=4||display!=5)
        {
          System.out.println("display option is not in the menu ");
        }
        
        
      }
      //if user wanna rent a car
      else if (option ==4)
      {
        //rent car display
        //header 
        disp.RentCar();
        //user enter car code to be display
        System.out.print("Enter car's Car-Code to rent:");
        rentCode=input.nextInt();
        //user enter his/her name
        System.out.print("Enter renter's name: ");
        input.nextLine();
        renter = input.nextLine();
        //user enter number of days in to rent
        System.out.print("Enter number of days to rent:");
        numDays=input.nextInt();
        //if code less than starting point
        if(rentCode<1000)
        {
          System.out.println("Code "+rentCode+" is not in the system ");
        }
        else
        {
          //check if car succesfully rented or not
          if (crs.RentCar(rentCode,renter,numDays)== true)
          {
            System.out.println("Successfully rented a car");
          }
          //if car cant be rented
          else if (crs.RentCar(rentCode,renter,numDays)== false)
          {
            System.out.println("Unable to rent a car");
          }
        }
        
        
      }
      //return car option
      else if (option ==5)
      {
        //display car header
        disp.ReturnCar();
        System.out.print("Enter returning car's Car-Code:");
        //let user enter car code
        returnCode= input.nextInt();
        System.out.print("Enter distance(km) drove:");
        //let user enter distance have been traveled
        dist=input.nextInt();
        
        //check if car enter is under 1000/starting point
        if (returnCode<1000)
        {
          System.out.println("Unable to return the car "+"\'"+returnCode+"\'"+" may not exist in the system");
        }
        //if it is acceptable
        else
        {
          //call return mehtod form CRS
          double returnValue = crs.ReturnCar(returnCode,dist);
          //give message that user must pay penalty
          if(returnValue > 0)
          {
            System.out.println("Successfully returned a car,but must pay $ "+returnValue+" for the extra mileage");
          }
          //user has successfully return car without paying penalty
          else if(returnValue==0)
          {
            System.out.println("Successfully returned a car");
          }
          //car cant be returned 
          //it is not in the system
          else if(returnValue ==-1)
          {
            System.out.println("Unable to return the car "+"\'"+returnCode+"\'"+" may not exist in the system");
          }
          //car cant be returned
          //it is not rented
          else if (returnValue ==-2)
          {
            System.out.println("Car code"+"\'"+returnCode+"\'"+"is not rented");
          }
        }
      }
      // print nothing when it is 6
      else if (option ==6)
      {
        System.out.print("");
      }
      //it will show warning if user choose number not from the option given
      else if (option != 1||option !=2||option!=3||option !=4||option !=5|| option !=6)
      {
        System.out.println("Option is not in the main program ");
      } 
    }
    //break or exit the loop
    while (option != 6);
    System.out.println("Thank You For Using"); 
    
  }
}