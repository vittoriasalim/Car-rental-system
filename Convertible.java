//importing calendar and date
import java.util.Calendar;
import java.util.Date;
public class Convertible extends Car{
  
  //=========== CONSTRUCTOR ===========//
  /* To instantiate a Convertible object
   * @param code        - The car code of this car
   * @param make        - The maker of this car
   * @param model       - The model name of this car
   * @param openTopTime - The time it takes to open the convertible top (in seconds) */
  
  private double openTopTime;
  private int allowableMileage;
  
  
  
  public Convertible( int code, String make, String model, double openTopTime ) {
    //super constructor takes in code,make and model
    super (code,make,model);
    //takes in info of convertible car
    this.openTopTime=openTopTime;
  }
  
  
  //========== PUBLIC METHODS =========//
  public double OpenTopTime()
  {
    //return convertible info to CRS
    return this.openTopTime;
  }
  
  
  public void Rent(String renter ,int numDays)
  {
    //set the renter name to super method
    super.SetRenter(renter);
    
    
    //if car less than 5 days allowable mileage will be 500
    if (numDays<5&&numDays>0)
    {
      this.allowableMileage=500;
    }
    //if beyond 5 days ,it will return the calculation 
    //base on the number of days rented
    else if (numDays >= 5)
    {
      this.allowableMileage = (numDays/5)*400;
    }
    //set the allowable mileage to super method
    super.SetAllowableDist(this.allowableMileage);
    
    //increment date 
    //base on the number of days the custmer rent
    Date date = new Date();
    Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    //check if number of days less than 5 
    //no bonus (due date)
    if (numDays <5 && numDays>0)
    {
      cal.add(Calendar.DATE,numDays);
    }
    //if more than or equals 5
    //bonus 5 days
    else if (numDays >=5)
    {
      cal.add(Calendar.DATE,numDays+5);
    }
    Date dueDate=cal.getTime();
    //set the due date to super method
    super.SetDueDate(dueDate);
    
  }
  
  
  
}