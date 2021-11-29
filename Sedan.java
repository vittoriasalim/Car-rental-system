//importing java date and calender
import java.util.Calendar;
import java.util.Date;
//extends car
public class Sedan extends Car{
  
  //=========== CONSTRUCTOR ===========//
  /* To instantiate a Sedan object
   * @param code        - The car code of this car
   * @param make        - The maker of this car
   * @param model       - The model name of this car
   * @param specialInfo - Special features of the sedan */
  
  private String specialInfo;
  
  private int allowableMileage;
  
  public Sedan ()
  {
    //default constructor
    allowableMileage=0;
    
    
  }
  //sedan constuctor
  public Sedan( int code, String make, String model, String specialInfo ) {
    //super constructor takes in code,make ,model
    super(code,make,model);
    //instantiate sedan info
    this.specialInfo=specialInfo;
  }
  
  //========== PUBLIC METHODS =========//
  public String SpecialInfo()
  {
    //return sedan info
    return this.specialInfo;
  }
  //overridden method
  //abstract method from car class
  public void Rent (String renter ,int numDays)
  { 
    //set renter name
    super.SetRenter(renter);
    
    //set allowableMileage 
    this.allowableMileage = numDays*250;
    super.SetAllowableDist(this.allowableMileage);
    
    //increment date base on the number of days the custmer rent
    Date date = new Date();
    Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    //add by num days
    cal.add(Calendar.DATE,numDays);
    Date dueDate=cal.getTime();
    //set duedate from super class mehtod
    super.SetDueDate(dueDate);
  }
  
  
  
}