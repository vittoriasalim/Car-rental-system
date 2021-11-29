//importing calendar and datee
import java.util.Calendar;
import java.util.Date;
//extends car class
public class Crossover extends Car{

   //=========== CONSTRUCTOR ===========//
   /* To instantiate a Crossover object
    * @param code     - The car code of this car
    * @param make     - The maker of this car
    * @param model    - The model name of this car
    * @param numSeats - Number of seats the Crossover has */
   private int numSeats;
   private int allowableMileage;

   public Crossover()
   {
     //default constructor
     numSeats=0;
     allowableMileage=0;
   
   }
   public Crossover( int code, String make, String model, int numSeats ) {
   //super constructor for code make and model
   super (code,make,model);
   //instantiate crossover info
   this.numSeats=numSeats;
   }
   
   
   //========== PUBLIC METHODS =========//
   public int GetNumSeats()
   {
     //return crossover info to CRS
     return this.numSeats;
   }
 
       
   public void Rent(String renter ,int numDays)
   {
     //set number of days to super method
     super.SetRenter(renter);
     //calculate allowable mileage
     this.allowableMileage= GetNumSeats() * (numDays*150);
     //set allowable distance to super method
     super.SetAllowableDist(this.allowableMileage);
     
     //increment date base on the number of days the custmer rent
    Date date = new Date();
    Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    //add num days to current date
    cal.add(Calendar.DATE,numDays);
    Date dueDate=cal.getTime();
    //set due date to super method
    super.SetDueDate(dueDate);
   }
  


  
     
   
   
}