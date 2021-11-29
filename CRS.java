// The Car Rental System class
//importing date format and date
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CRS {
  private Garage garage;            // DO NOT DELETE. Garage object
  private int carCodeCounter;       /* DO NOT DELETE. The car code counter to keep track of the current 
   code to be assigned to newly added cars */
  
  //set constant variable for return method
  private final int RETURN_IS_NOT_RENTED=-2;
  private final int RETURN_SUCCESS=0;
  private final int RETURN_NOT_IN_THE_SYSTEM=-1;
  
  
  //=============== Constructor =================
  public CRS() {
    this.garage = new Garage();    // DO NOT DELETE. Instantiating the Garage object
    this.carCodeCounter = 1000;      
  }
  
  public CRS(int maxCar) {
    this.garage = new Garage(maxCar);    // DO NOT DELETE. Instantiating the Garage object
    this.carCodeCounter = 1000;        
  }
  
  //============= Private Methods =============== 
  /* Place your private methods here */
  
  //display allowable mileage method
  private void DisplayMileage(Car car)
  {
    //check if car is rented 
    if(car.IsRent()==true)
    {
      //print allowable mileage
      System.out.printf("%18.1f",car.GetAllowableDist());
    }
    else
    {
      //print nothing
      System.out.print("");
    }
  }
  //display renter method
  private void DisplayRenter(Car car)
  {
    //car is rented
    if(car.IsRent()==true)
    {
      //print renter name
      System.out.printf("%15s",car.GetRenter());
    }
    else
    {
      //print nothing
      System.out.print("");
    }
  }
  //method to display car date in CRS(minimize repetition of code)
  private void DisplayDate(Car car)
  {
    //set the date format
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    //get the increment of date
    Date date = car.GetDueDate();
    //check if rented
    if(car.IsRent()==true)
    {
      //print date
      System.out.printf("%18s",df.format(date));
    }
    else
    {
      //print nothing
      System.out.print("");
    }
  }
  
  
  
  //============= Public Methods =============== 
  /* PROVIDED METHOD: Add (or import) cars to the system using the dummy textfile that contains cars information
   * @param filename - The textfile name that contains the car information 
   *                   (Textfile must be in the same folder)
   * @return         - The number of cars added */
  public int AddCar(String filename) {
    
    int carsAdded = this.garage.AddCar( filename, this.carCodeCounter);
    this.carCodeCounter += carsAdded;
    return carsAdded;
  }
  
  /* Add a single car to the system
   * @param carType - The car type. Could find these Constanst Global values in Car class
   * @param make    - The maker of the car (Honda, Toyota, BMW, etc...)
   * @param model   - The model name of the car (Civic, Golf GTI, etc...)
   * @param info    - Any special info related to a specific car type
   * @return        - Return true if car is successfully added to the system.
   *                  Return false otherwise. */
  public boolean AddCar(int carType, String make, String model, String info) {
    boolean result = true;
    //check if cartype is sedan 
    if(carType == Car.SEDAN)
    {
      //polymorphism 
      //set sedan as car type is sedan
      //it will add sedan car
      Car sedan = new Sedan(this.carCodeCounter,make,model,info);
      if(this.garage.AddCar(sedan)==true)
      {
        //if it true code will be increment by one
        this.carCodeCounter++;
        result = true;
      }
      else if (this.garage.AddCar(sedan)==false)
      {
        //if false it cant be add to car system
        result = false;
      }
      
    }
    //check if car type is coupe or not
    else if (carType == Car.COUPE)
    {
      //polymorphism 
      //set coupe car data
      Car coupe = new Coupe(this.carCodeCounter,make,model,Boolean.valueOf(info));
      if(this.garage.AddCar(coupe)==true)
      {
        //if true code will be increment by 1
        this.carCodeCounter++;
        result = true;
      }
      else if (this.garage.AddCar(coupe)==false)
      {
        //car will not be added to the garage system
        result = false;
      }
    }
    //check if cartype is cross over
    else if (carType ==Car.CROSSOVER)
    {
      //polymorphism
      //set crossover car as car type is crossover
      Car crossOver = new Crossover (this.carCodeCounter ,make,model,Integer.valueOf(info));
      //check if add car is true 
      if(this.garage.AddCar(crossOver)==true)
      {
        //car code will be increment by 1
        this.carCodeCounter++;
        result = true;
      }
      else if (this.garage.AddCar(crossOver)==false)
      {
        //car cant be addded to the system
        result = false;
      }
    }
    //check if it is convertible
    else if (carType == Car.CONVERTIBLE)
    {
      //polymorphism
      //set sub class convertible
      Car convertible = new Convertible(this.carCodeCounter,make,model,Double.valueOf(info));
      //ass car to conevertible
      if(this.garage.AddCar(convertible)==true)
      {
        //increment code by one
        this.carCodeCounter++;
        //car is added to the system
        result = true;
      }
      else if (this.garage.AddCar(convertible)==false)
      {
        //car cant be added to the system
        result = false;
      }
    }
    //return add car result to give message to the prompt
    return result;     // Needs to be changed
  }
  
  /* Display all the cars in the Garage */
  public void DisplayAllCar() {
    //to get position of the car data in the garage system
    for (int i = 0 ;i <= garage.NumCars() ;i++)
    {
      //create car object to get car data
      Car allCar = garage.GetCarAt(i);
      
      //check if car in the system or not
      if(allCar!=null)
      {
        //take each method from car class or super class
        int carCode = allCar.GetCode();
        String carMake =allCar.GetMake();
        String carModel=allCar.GetModel();
        double mileage = allCar.GetMileage();
        
        
        
        //print out each data of sedan
        if(allCar instanceof Sedan)
        {
          System.out.printf("%10d",carCode);
          System.out.printf("%15s",carMake);
          System.out.printf("%15s",carModel);
          //print out additional information form car class
          System.out.printf("%20s",((Sedan)allCar).SpecialInfo());
          System.out.printf("%12.1f",mileage);
          DisplayRenter(allCar);
          DisplayMileage(allCar);
          DisplayDate(allCar);
          System.out.println("");
        }
        //take in coupe data from car class
        else if ( allCar instanceof Coupe)
        {
          //print out coupe data 
          System.out.printf("%10d",carCode);
          System.out.printf("%15s",carMake);
          System.out.printf("%15s",carModel);
          //cast coupe 
          boolean seat = ((Coupe)allCar).HasBackSeat();
          String seater="" ;
          //check if coupe info have back seat or no
          if (seat==true)
          {
            seater = "Has back seat";
          }
          else if (seat == false)
          {
            seater = "No back seat";
          }
          //print out additional information
          System.out.printf("%20s",seater);
          System.out.printf("%12.1f",mileage);
          DisplayRenter(allCar);
          DisplayMileage(allCar);
          DisplayDate(allCar);
          System.out.println("");
        }
        // check if it is crossOver data
        else if ( allCar instanceof Crossover)
        {
          //print out crossOver data
          System.out.printf("%10d",carCode);
          System.out.printf("%15s",carMake);
          System.out.printf("%15s",carModel);
          //cast into crossOver /subclass to get cross over info
          System.out.printf("%13d seater",((Crossover)allCar).GetNumSeats());
          //print out additional information from car class mehtod
          System.out.printf("%12.1f",mileage);
          DisplayRenter(allCar);
          DisplayMileage(allCar);
          DisplayDate(allCar);
          
          System.out.println("");
          
        }
        //check if it is convertible class
        else if ( allCar instanceof Convertible)
        {
          //print out convertible data
          System.out.printf("%10d",carCode);
          System.out.printf("%15s",carMake);
          System.out.printf("%15s",carModel);
          //cast into convertible class to get convertible info from 
          //convertible method
          System.out.printf("%16.1f sec",((Convertible)allCar).OpenTopTime());
          //additional information from car class
          System.out.printf("%12.1f",mileage);
          DisplayRenter(allCar);
          DisplayMileage(allCar);
          DisplayDate(allCar);
          System.out.println("");
          
          
        }
      }
    }
    
    
  }
  
  /* Display only the sedans in the Garage */
  public void DisplaySedan() {
    //get each data form each position
    for (int i = 0 ;i <= garage.NumCars() ;i++)
    {
      //get car data from garage system
      Car allCar = garage.GetCarAt(i);
      //check if data is in the garage system
      //check if car in the system or not
      if(allCar!=null)
      {
        //call each mehtod from car class
        int carCode = allCar.GetCode();
        String carMake =allCar.GetMake();
        String carModel=allCar.GetModel();
        double mileage = allCar.GetMileage();
        
        
        //check if the data take in Sedan class
        if(allCar instanceof Sedan)
        {
          //print out sedan data
          System.out.printf("%10d",carCode);
          System.out.printf("%15s",carMake);
          System.out.printf("%15s",carModel);
          //cast car object into sedan to get sedan method
          System.out.printf("%20s",((Sedan)allCar).SpecialInfo());
          //additional information from car class method
          System.out.printf("%12.1f",mileage);
          DisplayRenter(allCar);
          DisplayMileage(allCar);
          DisplayDate(allCar);
          System.out.println("");
        }
      }
    }
    
    
  }
  
  /* Display only the coupe in the Garage */   
  public void DisplayCoupe() {   
    //take each data from each postion 
    for (int i = 0 ;i <= garage.NumCars() ;i++)
    {
      //create car object to get data
      Car allCar = garage.GetCarAt(i);
      //check if car in the system or not
      if(allCar!=null)
      {
        //call each method from car class
        int carCode = allCar.GetCode();
        String carMake =allCar.GetMake();
        String carModel=allCar.GetModel();
        double mileage = allCar.GetMileage();
        
        
        //check if it is coupe class to print only coupe data
        if ( allCar instanceof Coupe)
        {
          //print out coupe data
          System.out.printf("%10d",carCode);
          System.out.printf("%15s",carMake);
          System.out.printf("%15s",carModel);
          //cast car class to coupe class
          //to get coupe method
          //which will print coupe information
          boolean seat = ((Coupe)allCar).HasBackSeat();
          String seater="";
          //if coupe info return true
          //coupe has back seat
          
          if(seat == true )
          {
            seater = "Has Back Seat";
            System.out.printf("%20s",seater);
          }
          else if(seat==false)
          {
            //couper has no back seat
            seater = "No Back Seat";
            System.out.printf("%20s",seater);
          }
          //print out additional information
          System.out.printf("%12.1f",mileage);
          DisplayRenter(allCar);
          DisplayMileage(allCar);
          DisplayDate(allCar);
          
          System.out.println("");
        }
      }
    }
  }
  
  /* Display only the Crossovers in the Garage */     
  public void DisplayCrossover() {  
    //take each position of garage data
    for (int i = 0 ;i <= garage.NumCars() ;i++)
    {
      //create car object to take car position
      Car allCar = garage.GetCarAt(i);
      //check if car is in the system
      //check if car in the system or not
      if(allCar!=null)
      {
        //get each method from car class
        int carCode = allCar.GetCode();
        String carMake =allCar.GetMake();
        String carModel=allCar.GetModel();
        double mileage = allCar.GetMileage();
        //check if it is crossover car
        if ( allCar instanceof Crossover)
        {
          //print out crossover data
          System.out.printf("%10d",carCode);
          System.out.printf("%15s",carMake);
          System.out.printf("%15s",carModel);
          //cast car object into crossover to egt crossover info
          System.out.printf("%13d seater",((Crossover)allCar).GetNumSeats());
          //additional information
          System.out.printf("%12.1f",mileage);
          DisplayRenter(allCar);
          DisplayMileage(allCar);
          DisplayDate(allCar);
          
          System.out.println("");
          
        }
      }
    }
  }
  
  /* Display only the Convertibles in the Garage */  
  public void DisplayConvertible() {  
    //take each position of car data from garage system
    for (int i = 0 ;i <= garage.NumCars() ;i++)
    {
      //create car object to get car position
      Car allCar = garage.GetCarAt(i);
      //check if car is in the system
      //check if car in the system or not
      if(allCar!=null)
      {
        //take each car data from car class
        int carCode = allCar.GetCode();
        String carMake =allCar.GetMake();
        String carModel=allCar.GetModel();
        double mileage = allCar.GetMileage();
        
        
        
        //check if car is convertible type
        if ( allCar instanceof Convertible)
        {
          //print out car data
          System.out.printf("%10d",carCode);
          System.out.printf("%15s",carMake);
          System.out.printf("%15s",carModel);
          //cast car object into convertible to get convertible information
          System.out.printf("%16.1f sec",((Convertible)allCar).OpenTopTime());
          //print out additional information of convertible type
          System.out.printf("%12.1f",mileage);
          DisplayRenter(allCar);
          DisplayMileage(allCar);
          DisplayDate(allCar);
          System.out.println("");
          
          
        }
      }
    }
  }
  
  /* Rent a car in the system
   * @param code    - The car code that the user wants to rent
   * @param renter  - The renter's name
   * @param numDays - The number of days the renter wants to rent
   * @return        - Return true if the car is rented successfully.
   *                  Return false otherwise. */  
  public boolean RentCar( int code, String renter, int numDays) {
    //return varible
    boolean result = true;
    //create car object
    //take car position
    Car car = garage.GetCarAt(code - 1000);
    //check if car in the system
    if (car != null)
    {
      //check if code matches positon in the system
      if (car.GetCode()== code)
      {
        //car succesfully been return
        result = true ;
        //fill in the abstract method 
        //overriden method to any subclass
        car.Rent(renter ,numDays);
      }
      else
      {
        //car cant be rent because it doesnt match the code in the system
        result = false ;
        
      }
    }
    else
    {
      //car is not in the system
      result = false;
    }
    return result ;    // Needs to be changed      
  }
  
  /* Return a rented car back to the system
   * @param code      - The car code of the car that is being returned
   * @param distDrove - The distance drove during the renting period
   * @return          - Return 0 if the renter did not drive more than the 
   *                             allowable distance during the renting period 
   *                    Return the amount of penalty if the renter drove 
   *                             more than the allowable distance */
  public double ReturnCar( int code, int distDrove ) {
    double result =0;
    Car car = garage.GetCarAt(code-1000);
    //check if car is in the system
    if(car != null )
    {
      //check if car is rented or not 
      //check if code matches the position of code in the system
      if (car.IsRent()==true)
      {
        //if customer need to pay penalty
        if(car.Return(distDrove)>0)
        {
          //need to pay penalty
          result = car.Return(distDrove);
        }
        //customer doesnt have to pay penalty 
        else if (car.Return(distDrove)==0)
        {
          //successfully return a car without penalty
          result =RETURN_SUCCESS;
        }
        
      }
      else 
      {
        //If car is not rented 
        result = RETURN_IS_NOT_RENTED;
      }
      
    }
    else 
    {
      
      //car is not in the system
      result = RETURN_NOT_IN_THE_SYSTEM;
      
    }
    
    return result ;    // Needs to be changed      
  }
}