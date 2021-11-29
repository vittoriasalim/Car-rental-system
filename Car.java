//importing date to the class
import java.util.Date;


public abstract class Car {
  // Global Variables to be used throughout the program. Please use these whenever possible
  public static final int SEDAN       = 0;
  public static final int COUPE       = 1;
  public static final int CROSSOVER   = 2;
  public static final int CONVERTIBLE = 3;
  
  // Instance Variables
  private int code;
  private String make;
  private String model;
  //other variable 
  private String renter;
  private  double mileage;
  private double allowableMileage;
  private Date dueDate;
  private boolean isRent;
  private double returnCar;
  
  
  //============== Constructor ===============
  /* Default constructor for initiating a Car object */
  public Car() {
    //default
    mileage =0;
    renter="";
    allowableMileage=0;
    dueDate=null;
    isRent=false;
    
  }
  
  /* To instantiate a Car object
   * @param code        - The car code of this car
   * @param make        - The maker of this car
   * @param model       - The model name of this car */
  public Car( int code, String make, String model) {
    this.code  = code;
    this.make  = make;
    this.model = model;
  }
  
  //============= Private Methods ===============
  /* May add your own private methods here */   
  
  
  //============= Public Methods ================   
  /* Get the car code
   * @return - The car code */
  public int GetCode() {
    //getter method to display code
    return this.code;     // Needs to be changed
  }
  
  /* Get the car maker
   * @return - The car maker */   
  public String GetMake() {
    //getter method to display make
    return this.make;  // Needs to be changed
  }
  
  /* Get the car model
   * @return - The car model */   
  public String GetModel() {
    //getter method to display model
    return this.model;  // Needs to be changed
  }
  
  /* Get the car's current mileage
   * @return - The car mileage */ 
  
  public double GetMileage() {
    //getter method to display mileage
    return this.mileage;     // Needs to be changed
  }
  
  /* Get the car's rental status
   * @return - Return true if the car is rented out
   *           Return false otherwise. */
  public boolean IsRent() {
    //check if car is rented or not 
    //by tracking the renter name 
    //if renter name is not null
    if (this.renter !=null)
    {
      //car is rented
      this.isRent=true;
    }
    //renter null
    else if (this.renter == null)
    {
      //car is not rented
      this.isRent =false;
    }
    return this.isRent;  // Needs to be changed
  }
  
  /* Get the car's renter name
   * @return - Returns the renter's name, if it is rented out
   *           Return null otherwise. */  
  public String GetRenter() {
    String renter ="";
    //if renter name is not null
    if (this.renter != null)
    {
      //return variable is renter name
      renter =this.renter;
    }
    
    
    return renter;  // Needs to be changed
  }
  
  /* Get the car's rental duedate
   * @return - Returns the car's rental duedate, if it is rented out
   *           Return null otherwise. */     
  public Date GetDueDate() {
    //to display duedate return due date variable that has been set
    return this.dueDate ; // Needs to be changed
  }
  
  /* Get the car's rental allowable distance
   * @return - The car's rental allowable distance */     
  public double GetAllowableDist() {
    //get allowable mileage to be displayed 
    return this.allowableMileage;     // Needs to be changed
  }      
  
  /* Set the car's rental duedate 
   * @param date - The due date of the car */    
  public void SetDueDate(Date date)  {
    //due date has been set in sub class program
    this.dueDate=date;
    
  }   
  
  /* Set the car's renter name
   * @param renter - The name of the renter renting the car */     
  public void SetRenter(String renter) {
    //setter method 
    //renter name has been set in sub class program
    this.renter = renter;
  }   
  
  /* Set the car's rental allowable distance 
   * @param dist - The distance allowable to drive for the car */     
  public void SetAllowableDist( int dist ) {
    //setter method 
    //data is set in the sub class program
    this.allowableMileage=dist;
    
  }
  
  /* Returns a rented car back to the system
   * @param distDrove - The distance the renter drove during the rental period
   * @return          - Returns penalty cost, if drove over the allowable distance.
   *                    Returns 0 otherwise.
   *                  - if drive morethan allowable distance every km will be charged $1.25*/
  
  public double Return(int distDrove) {
    //if renter is not equals to null(rented)
    //it will start to count whether customer need to pay penalty or not
    if (this.renter != null)
    {
      //if customer drove doesn't beyond the allowable mileage ,
      //customer doesn't need to pay penalty 
      if (distDrove <= this.allowableMileage)
      {
        this.returnCar= 0;  
        //it is used to add the total mileage from each returned car
        this.mileage +=distDrove;
      }
      //if it is beyond the limit it will count the penalty,
      //customer needs to pay
      else if (distDrove > this.allowableMileage)
      {
        this.returnCar =((distDrove-this.allowableMileage)*1.25);
        //it will add total mileage from returned car
        this.mileage +=distDrove;
      }
      //renter name will be null if return is success
      this.renter=null;
      
    }
    
    return this.returnCar;   // Dummy return value, needs to be changed
  }   
  
  
  /* Specify that the card is being borrowed
   * @param renter - The renter's name */
  public abstract void Rent(String renter, int numDays);
}