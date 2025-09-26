import java.util.*;
import java.util.HashMap;

public class CabBooking
{
    //User Class 
    static class User{
    private String name;
    private int age;
    private int x;
    private int y; //current location
    private char sex;
    
    public User(String name, int age, int x, int y, char sex){
        this.name = name;
        this.age = age;
        this.x = x;
        this.y = y;
        this.sex =sex;
    }
    
    public String getName(){
        return this.name;
    }
    public int getAge(){
        return this.age;
    }
    public char getSex(){
        return this.sex;
    }
    public void updateLocation(int x, int y){
        this.x=x;
        this.y=y;
    }
    public void getInfo(){
        System.out.println("User Name : "+this.name);
        System.out.println("Age : "+this.age);
        System.out.println("Sex : "+this.sex);
        System.out.println("Location : ("+this.x+","+this.y+")");
    }
}

//Driver Class 
static class Driver{
    private String name;
    private int age;
    private char sex;
    private String vehicleNumber;
    private int x;
    private int y;
    private String vehicleName;
    private boolean available;
    private int totalEarning;
    
    public Driver(String name,int age, char sex,  String vehicleNumber, int x, int y, String vehicleName){
        this.name =name;
        this.age = age;
        this.sex = sex;
        this.vehicleNumber =vehicleNumber;
        this.x=x;
        this.y=y;
        this.vehicleName =vehicleName;
        this.available = true;
        this.totalEarning =0;
    }
    
    public void updateLocation(int x, int y){
        this.x=x;
        this.y=y;
    }
    
    public void changeDriverStatus(boolean available){
        this.available = available;
    }
    
    public int getlocationX(){
        return this.x;
    }
    public int getlocationY(){
        return this.y;
    }
    public void updateEarning(int fare){
        this.totalEarning+=fare;
    }
    public void getEarning(){
        System.out.println(this.name + " earns "+ this.totalEarning);
    }
    public void getInfo(){
        System.out.println("Name : "+this.name);
        System.out.println("Age : "+this.age);
        System.out.println("Sex : "+this.sex);
        System.out.println("Location : ("+this.x+","+this.y+")");
        System.out.println("Vehicle Number : "+ this.vehicleNumber);
        System.out.println("Vehicle Name : "+ this.vehicleName);
        //System.out.println("Total Earning : "+ this.totalEarning);
        System.out.println();
    }
    
    public boolean isAvailable(){
        return this.available;
    }
    
    
}
    
//UberCab class     
static class UberCab{
        HashMap<String, Driver> cabs =new HashMap<>();
        
        public void addCabDirver(String name,int age, char sex,  String vehicleNumber, int x, int y, String vehicleName){
                cabs.put(vehicleNumber, new Driver(name, age, sex, vehicleNumber, x, y, vehicleName));
        }
        
        public void DriverDetails(){
            System.out.println("Driver details are given below : ");
            int i=1;
            for(Driver driver : cabs.values()){
                System.out.print("(" +i+ ") ");
                driver.getInfo();
                i++;
                
            }
            System.out.println("_______________________________________");
        }
        
        public void getEarningDetails(){
             int i=1;
            for(Driver driver : cabs.values()){
                System.out.print("(" +i+ ") ");
                driver.getEarning();
                i++;
                
            }
            System.out.println("_______________________________________");
            
        }
        
        public Driver getAvailability(int srcX, int srcY, int max_dist){
            //System.out.println("Rajkishor3");
            int i=1;
            
            for(Driver driver : cabs.values()){
                //driver.getInfo();
                if(driver!=null && driver.isAvailable()){
                  //  driver.getInfo();
                    int dist = Math.abs(driver.getlocationX()-srcX)+Math.abs(driver.getlocationY()-srcY);
                    if(dist<=max_dist){
                        //System.out.println("Rajkishor2");
                        return driver;
                    }
                }
            }
            return null;
        }
        
        
}

//Ride class booked by users 
static class RideDetails{
    HashMap<String, User> riders = new HashMap<>();
    UberCab cab;
    
    
    public RideDetails(UberCab cab){
           this.cab = cab;
    }
    
    public void addRiders(String id ,String name, int age, int x, int y, char sex){
        riders.put(id, new User( name, age, x, y, sex));
    }
    
    public void riderDetails(){
            System.out.println("Rider details are given below : ");
            int i=1;
            for( Map.Entry<String, User> val : riders.entrySet()){
              System.out.println("(" +i+ ")" + "User Id : "+ val.getKey());
              val.getValue().getInfo();
              i++;
            }
        
        
            System.out.println("________________________________________________");
        }
       
    //Finding available ride for registered users    
    public void findRide(String id, int srcX, int srcY, int destX, int destY){
        User user = riders.get(id);
        
        //checking for valid users 
        if(user==null){
            System.out.println("User is not registered. Kindly register first");
            System.out.println("____________________________________");
            return;
        }else{
            System.out.println("User details is given below : ");
            user.getInfo();
        }
        
        //checking for available rides nearby (upto 5 unit distance)
        Driver nearbyDriver= cab.getAvailability(srcX, srcY, 5);
        if(nearbyDriver==null){
            System.out.println("No driver found");
            System.out.println("______________________________________");
            return;
        }
        if(nearbyDriver!=null){
            System.out.println("Driver found. Details are given below : ");
            nearbyDriver.getInfo();
            System.out.println("Ride starts .....Enjoy your ride :) ");
        }
        
        //Fare calucaltion 
        int dist = Math.abs(destX-srcX)+Math.abs(destY-srcY);
        int fare = dist*10;
        
        
        //upadating the earning details of dirvers 
        nearbyDriver.updateEarning(fare);
        System.out.println("Total earning by all Drivers after this ride : ");
        cab.getEarningDetails();
        
        
        //updating the location of driver 
        nearbyDriver.updateLocation(destX, destY);
        
        //updating the location of user 
        user.updateLocation(destX, destY);
        
        
    }
    
}
    
    
//Main function   
public static void main (String[] args) throws java.lang.Exception
    {
        
        UberCab Cabs = new UberCab();
        RideDetails ride = new RideDetails(Cabs);  // Pass cab system to ride
        
        //Rider Details : 
        ride.addRiders("Abhi@123","Abhishek", 23, 0, 0 , 'M');
        ride.addRiders("Rahul@xyz","Rahul", 29, 10,0, 'M');
        ride.addRiders("Nan@987","Nandini", 22, 15, 6, 'F');
       // ride.riderDetails();
        
        
    
        
        //Driver registration : 
        Cabs.addCabDirver("Driver1", 22, 'M', "KA-01-12345",10,1,"Swift");
        Cabs.addCabDirver("Driver2", 29, 'M', "KA-02-12345",11,10,"Swift");
        Cabs.addCabDirver("Driver3", 24, 'F', "KA-03-12345",5,3,"Skoda");
        //Cabs.DriverDetails();
        //Cabs.getEarningDetails();
        
        
        //finding ride for users 
        ride.findRide("Rahul@xyz", 10,0,15,3);
        //System.out.println("Updated Location of drivers are : ");
       // Cabs.DriverDetails();
        
        
        ride.findRide("Nan@987", 0,0,10,2); //no driver for pickup in 5 unit dist 
        //System.out.println("Updated Location of drivers are : ");
        //Cabs.DriverDetails();
        
        ride.findRide("Abhi@987", 0,0,10,2); //User not registered 
        
        
        ride.findRide("Nan@987", 5,0,10,2);
        System.out.println("Updated Location of drivers are : ");
        Cabs.DriverDetails();
        ride.riderDetails();

    }
}
