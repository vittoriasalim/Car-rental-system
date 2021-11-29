/* Developed by: Kevin Wong
 * Date:       : Mar 26, 2020 
 * Version     : 1.01 */
import java.util.Scanner;
import java.io.File;            
import java.io.IOException;   

/* NOTE: PROVIDED CLASS. DO NOT CHANGE ANYTHING HERE OR ELSE 
 *       THE CAR MANAGEMENT SYSTEM WILL NOT WORK. JUST USE IT
 *       AS IS */
public class Garage
{
   private final int maxCar;     // The maximum number of cars the system can contain
   
   /* This is where it stores all the Car objects. Similar to String,
    * we can locate a specific Car object by specifying the location (index). 
    * Let n be the number of cars, then you may use position 0 to n-1, where 1st car is at 0, 
    * 2nd car is at 1, and so now. */
   private Car[] carList;        // An array of Car objects. Don't need to know how it works. Unit 4 content.
   private int numCars;          // The number of cars the garage currently has
      
   //=============== Constructor =================
   /* To instantiate the Garage object */
   public Garage() {
      this(100);
   }

   public Garage(int maxCar) {
      this.maxCar = maxCar;
      this.carList = new Car[this.maxCar];
      this.numCars = 0;
   } 
   
   //============= Public Methods ===============
   /* To add cars from a textfile that contains initial dummy data. Used for testing purposes.
    * The data in the textfile are separated by a tab "\t".
    * @param filename       - The filename that contains the dummy data. The file must be in the same 
    *                         folder with the rest of the code.
    * @param carCodeCounter - The current car code counter from CRS so that it
    *                         fills the new cars added with it, and returns the new
    *                         car counter.
    * @return               - The number of cars added */
   public int AddCar(String filename, int carCodeCounter) {
      String record;
      String[] carInfo;
      int carAdded = 0;
      int currCarCounter = carCodeCounter;
      
      try
      {
         File file = new File(filename); 
         Scanner input = new Scanner(file); 
         
         // While the file has a line of record
         while (input.hasNextLine()) 
         {
            // Look for the account number
            record = input.nextLine();
            carInfo = record.split("\t");
            
            Car newCar = null;
            if( carInfo[0].equals("") ) {
               break;
            }
            int carType = Integer.parseInt(carInfo[0]);
            switch( carType ) {
               case Car.SEDAN:
                  newCar = new Sedan(currCarCounter, carInfo[1], carInfo[2], carInfo[3]);
                  break;
               case Car.COUPE:
                  newCar = new Coupe(currCarCounter, carInfo[1], carInfo[2], Boolean.parseBoolean(carInfo[3]) );
                  break;
               case Car.CROSSOVER:
                  newCar = new Crossover(currCarCounter, carInfo[1], carInfo[2], Integer.parseInt(carInfo[3]) );
                  break;
               case Car.CONVERTIBLE:
                  newCar = new Convertible(currCarCounter, carInfo[1], carInfo[2], Double.parseDouble(carInfo[3]) );
                  break;                  
               default:
            }
            
            // Only add a car when the car is valid
            if( newCar != null ) {
               this.carList[this.numCars] = newCar;
               this.numCars++;
               carAdded++;
               currCarCounter++;
            }
         }
         
         input.close();
      }
      catch (IOException ex)
      {
         // We won't be learning this in the course. You may ignore it.
      }         
      
      return carAdded;
   }
   
   /* Add a single car object into to the carList array. 
    * @param newCar - the new car object and stores it into carList array
    * @return       - True if the car object is added successful. 
    *                 False if otherwise */
   public boolean AddCar(Car newCar) {
      if( this.numCars < this.maxCar ) {
         this.carList[this.numCars] = newCar;
         this.numCars++;
         return true;
      }
      return false;
   }

   /* Remove a single car object completely from the garage by 
    * specifying the car code
    * @code   - The code of the car that you want to remove  
    *           it from carList array
    * @return - True if the car object is removed successful. 
    *           False if otherwise */    
   public boolean RemoveCarByCode(int code) {
      for( int i = 0; i < this.carList.length; i++ ) {
         if( this.carList[i].GetCode() == code ) {
            this.carList[i] = null;
            // Shift the array to fill in the deleted car
            for( int j = i; j < this.carList.length - 1; j++ ) {
               if( this.carList[j + 1] == null ) {
                  break;
               }
               this.carList[j] = this.carList[j + 1];
            }
            this.numCars--;
            
            return true;
         }
      }
      return false;      
   }
   
   /* Get the number of cars that are in the garage (in the carList array)
    * @return - Number of cars the Garage (The carList array) has */    
   public int NumCars() {
      return this.carList.length;
   }
  
   /* Gets the car at a specific location in the garage (in the carList array).
    * Note: The first car is at pos = 0, and the second car is at pos = 1 and so on.
    *       The last car will be total car minus 1 (n-1)
    * @param pos - The position of the car that you want
    *              in the garage (in the carList variable)
    * @return    - If thee re's a car at pos, it returns the Car object of the car that you want
    *              If there's no car at pos (or is out of the array index range), it will return null*/       
   public Car GetCarAt(int pos) {
      if( pos <= this.numCars - 1 ) {
         return this.carList[ pos ];
      }
      else {
         return null;
      }
   }
}