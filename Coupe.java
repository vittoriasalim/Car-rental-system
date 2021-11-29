//improting calender and date
import java.util.Calendar;
import java.util.Date;
public class Coupe extends Car {
  
  //=========== CONSTRUCTOR ===========//
  /* To instantiate a Coupe object
   * @param code        - The car code of this car
   * @param make        - The maker of this car
   * @param model       - The model name of this car
   * @param hasBackSeat - If the coupe has a back seat */
  private boolean hasBackSeat;
  private int allowableMileage;

  
  public Coupe()
  {
    //default constructor
    allowableMileage=0;
    hasBackSeat = true;
   
  }
  
  public Coupe( int code, String make, String model, boolean hasBackSeat ) {
    //super constructor for coupe code ,make and model
    super (code,make,model);
    //instantiate coupe info
    this.hasBackSeat=hasBackSeat;
  }
  
  
  
  //========== PUBLIC METHODS =========//
  public boolean HasBackSeat()
  {
    //return coupe info to CRS
    return this.hasBackSeat;
  }
  
  public void Rent(String renter,int numDays)
  {
    //set renter name to super method
    super.SetRenter(renter);
    //calculate allowable mileage
    //based on number of days 
    this.allowableMileage=numDays*100;
    //set allowable distance to super method
    super.SetAllowableDist(this.allowableMileage);
    
    //increment date base on the number of days the custmer rent
    Date date = new Date();
    Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    cal.add(Calendar.DATE,numDays);
    Date dueDate=cal.getTime();
    //set due date to super method
    super.SetDueDate(dueDate);
  }
  
  
}