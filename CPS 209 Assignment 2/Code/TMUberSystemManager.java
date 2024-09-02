// Name: Sharaf Hussain
// ID: 501246102
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
/*
 * 
 * This class contains the main logic of the system.
 * 
 *  It keeps track of all users, drivers and service requests (RIDE or DELIVERY)
 * 
 */
public class TMUberSystemManager
{
  private ArrayList<User>   users;
  private ArrayList<Driver> drivers;

  private ArrayList<TMUberService> serviceRequests; 

  public double totalRevenue; // Total revenues accumulated via rides and deliveries
  
  // Rates per city block
  private static final double DELIVERYRATE = 1.2;
  private static final double RIDERATE = 1.5;
  
  // Portion of a ride/delivery cost paid to the driver
  private static final double PAYRATE = 0.1;

  // These variables are used to generate user account and driver ids
  int userAccountId = 900;
  int driverId = 700;

  public TMUberSystemManager()
  {
    users   = new ArrayList<User>();
    drivers = new ArrayList<Driver>();
    serviceRequests = new ArrayList<TMUberService>(); 
    
    TMUberRegistered.loadPreregisteredUsers(users);
    TMUberRegistered.loadPreregisteredDrivers(drivers);
     
    totalRevenue = 0;
  }

  // General string variable used to store an error message when something is invalid 
  // (e.g. user does not exist, invalid address etc.)  
  // The methods below will throw exptions for error messages

  
  // Generate a new user account id
  private String generateUserAccountId()
  {
    return "" + userAccountId + users.size();
  }
  
  // Generate a new driver id
  private String generateDriverId()
  {
    return "" + driverId + drivers.size();
  }

  // Given user account id, find user in list of users
  public User getUser(String accountId)
  {
    for (int i = 0; i < users.size(); i++)
    {
      if (users.get(i).getAccountId().equals(accountId))
        return users.get(i);
    }
    return null;
  }
  
  // Check for duplicate user
  private boolean userExists(User user)
  {
    // Simple way
    // return users.contains(user);
    for (int i = 0; i < users.size(); i++)
    {
      if (users.get(i).equals(user))
        return true;
    }
    return false;
  }
  
 // Check for duplicate driver
 private boolean driverExists(Driver driver)
 {
   // simple way
   // return drivers.contains(driver);
   
   for (int i = 0; i < drivers.size(); i++)
   {
     if (drivers.get(i).equals(driver))
       return true;
   }
   return false;
 }
  
 
 // Given a user, check if user ride/delivery request already exists in service requests
 private boolean existingRequest(TMUberService req)
 {
   // Simple way
   // return serviceRequests.contains(req);
   
   for (int i = 0; i < serviceRequests.size(); i++)
   {
     if (serviceRequests.get(i).equals(req))
       return true;
   }
   return false;
 } 
 
  
  // Calculate the cost of a ride or of a delivery based on distance 
  private double getDeliveryCost(int distance)
  {
    return distance * DELIVERYRATE;
  }

  private double getRideCost(int distance)
  {
    return distance * RIDERATE;
  }

  // Go through all drivers and see if one is available
  // Choose the first available driver
  private Driver getAvailableDriver()
  {
    for (int i = 0; i < drivers.size(); i++)
    {
      Driver driver = drivers.get(i);
      if (driver.getStatus() == Driver.Status.AVAILABLE)
        return driver;
    }
    return null;
  }

  // Print Information (printInfo()) about all registered users in the system
  public void listAllUsers()
  {
    System.out.println();
    
    for (int i = 0; i < users.size(); i++)
    {
      int index = i + 1;
      System.out.printf("%-2s. ", index);
      users.get(i).printInfo();
      System.out.println(); 
    }
  }

  // Print Information (printInfo()) about all registered drivers in the system
  public void listAllDrivers()
  {
    System.out.println();
    
    for (int i = 0; i < drivers.size(); i++)
    {
      int index = i + 1;
      System.out.printf("%-2s. ", index);
      drivers.get(i).printInfo();
      System.out.println(); 
    }
  }

  // Print Information (printInfo()) about all current service requests
  public void listAllServiceRequests()
  {
    for (int i = 0; i < serviceRequests.size(); i++)
    {
      int index = i + 1;
      System.out.println();
      System.out.print(index + ". ");
      for (int j = 0; j < 60; j++)
        System.out.print("-");
      serviceRequests.get(i).printInfo();
      System.out.println(); 
    }
  }

  // Add a new user to the system
  public void registerNewUser(String name, String address, double wallet)
  {
    // Check to ensure name is valid
    if (name == null || name.equals(""))
    {
      throw new InvalidInputError("Invalid User Name " + name);
    }
    // Check to ensure address is valid
    if (!CityMap.validAddress(address))
    {
      throw new InvalidInputError("Invalid User Address " + address);
    }
    // Check to ensure wallet amount is valid
    if (wallet < 0)
    {
      throw new InvalidInputError("Invalid Money in Wallet");
    }
    // Check for duplicate user
    User user = new User(generateUserAccountId(), name, address, wallet);
    if (userExists(user))
    {
      throw new UserError("User Already Exists in System");
    }
    users.add(user);  
  }

  // Add a new driver to the system
  public void registerNewDriver(String name, String carModel, String carLicencePlate, String driverAddress)
  {
    // Check to ensure name is valid
    if (name == null || name.equals(""))
    {
      throw new InvalidInputError("Invalid Driver Name " + name);
    }
    // Check to ensure car models is valid
    if (carModel == null || carModel.equals(""))
    {
      throw new InvalidInputError("Invalid Car Model " + carModel);
    }
    // Check to ensure car licence plate is valid
    // i.e. not null or empty string
    if (carLicencePlate == null || carLicencePlate.equals(""))
    {
      throw new InvalidInputError("Invalid Car Licence Plate " + carLicencePlate);
    }
    if (driverAddress == null || !CityMap.validAddress(driverAddress))
    {
      throw new InvalidInputError("Invalid Address " + driverAddress);
    }
    // Check for duplicate driver. If not a duplicate, add the driver to the drivers list
    Driver driver = new Driver(generateDriverId(), name, carModel, carLicencePlate, driverAddress);
    if (driverExists(driver))
    {
      throw new DriverError("Driver Already Exists in System");
    }
    drivers.add(driver);
  }

  // Request a ride. User wallet will be reduced when drop off happens
  public void requestRide(String accountId, String from, String to)
  {
    // Check valid user account
    User user = getUser(accountId);
    if (user == null)
    {
      throw new UserError("User Account Not Found " + accountId);
    }
    // Check for a valid from and to addresses
    if (!CityMap.validAddress(from))
    {
      throw new InvalidInputError("Invalid Address " + from);
    }
    if (!CityMap.validAddress(to))
    {
      throw new InvalidInputError("Invalid Address " + to);
    }
    // Get the distance for this ride
    int distance = CityMap.getDistance(from, to);         // city blocks
    // Distance == 0 or == 1 is not accepted - walk!
    if (!(distance > 1))
    {
      throw new ServiceRequestError("Insufficient Travel Distance");
    }
    // Check if user has enough money in wallet for this trip
    double cost = getRideCost(distance);
    if (user.getWallet() < cost)
    {
      throw new ServiceRequestError("Insufficient Funds");
    }
    // Get an available driver
    Driver driver = getAvailableDriver();
    if (driver == null) 
    {
      throw new ServiceRequestError("No Drivers Available");
    }
    // Create the request
    TMUberRide req = new TMUberRide(driver, from, to, user, distance, cost);
    
    // Check if existing ride request for this user - only one ride request per user at a time
    if (existingRequest(req))
    {
      throw new ServiceRequestError("User Already Has Ride Request");
    }
    driver.setStatus(Driver.Status.DRIVING);
    serviceRequests.add(req);
    user.addRide();
  }

  // Request a food delivery. User wallet will be reduced when drop off happens
  public void requestDelivery(String accountId, String from, String to, String restaurant, String foodOrderId)
  {
    // Check for valid user account
    User user = getUser(accountId);
    if (user == null)
    {
      throw new UserError("User Account Not Found " + accountId);
    }
    // Check for valid from and to address
    if (!CityMap.validAddress(from))
    {
      throw new InvalidInputError("Invalid Address " + from);
    }
    if (!CityMap.validAddress(to))
    {
      throw new InvalidInputError("Invalid Address " + to);
    }
    // Get the distance to travel
    int distance = CityMap.getDistance(from, to);         // city blocks
    // Distance must be at least 1 city block
    if (distance == 0)
    {
      throw new ServiceRequestError("Insufficient Travel Distance");
    }
    // Check if user has enough money in wallet for this delivery
    double cost = getDeliveryCost(distance);
    if (user.getWallet() < cost)
    {
      throw new ServiceRequestError("Insufficient Funds");
    }
    // Find an available driver, if any
    Driver driver = getAvailableDriver();
    if (driver == null) 
    {
      throw new ServiceRequestError("No Drivers Available");
    }
    TMUberDelivery delivery = new TMUberDelivery(driver, from, to, user, distance, cost, restaurant, foodOrderId); 
    // Check if existing delivery request for this user for this restaurant and food order #
    if (existingRequest(delivery))
    {
      throw new ServiceRequestError("User Already Has Delivery Request at Restaurant with this Food Order");
    }
    driver.setStatus(Driver.Status.DRIVING);
    serviceRequests.add(delivery);
    user.addDelivery();
  }


  // Cancel an existing service request. 
  // parameter request is the index in the serviceRequests array list
  public void cancelServiceRequest(int zone, int request)
  {
    // Check if valid request #
    if (request < 1 || request > serviceRequests.size())
    {
      throw new InvalidInputError("Invalid Request # " + request);
    }
    if (zone < 0) {
      throw new InvalidInputError("Invalid Zone: " + zone);
    }
    serviceRequests.remove(request-1);
  }
  
  // Drop off a ride or a delivery. This completes a service.
  // parameter request is the index in the serviceRequests array list
  public void dropOff(int request)
  {
    if (request < 1 || request > serviceRequests.size())
    {
      throw new InvalidInputError("Invalid Request # " + request);
    }
    TMUberService service = serviceRequests.get(request-1);
    serviceRequests.remove(request-1);          // remove request from array list
    totalRevenue += service.getCost();          // add service cost to revenues
    Driver driver = service.getDriver();
    driver.pay(service.getCost()*PAYRATE);      // pay the driver
    totalRevenue -= service.getCost()*PAYRATE;  // deduct driver fee from total revenues
    driver.setStatus(Driver.Status.AVAILABLE);  // driver is now available again
    User user = service.getUser();
    user.payForService(service.getCost());      // user pays for ride or delivery
  }


  // Sort users by name
  public void sortByUserName()
  {
    Collections.sort(users, new NameComparator());
    listAllUsers();
  }

  private class NameComparator implements Comparator<User>
  {
    public int compare(User a, User b)
    {
      return a.getName().compareTo(b.getName());
    }
  }

  // Sort users by number amount in wallet
  public void sortByWallet()
  {
    Collections.sort(users, new UserWalletComparator());
    listAllUsers();
  }

  private class UserWalletComparator implements Comparator<User>
  {
    public int compare(User a, User b)
    {
      if (a.getWallet() > b.getWallet()) return 1;
      if (a.getWallet() < b.getWallet()) return -1; 
      return 0;
    }
  }

  // Sort trips (rides or deliveries) by distance
  // class TMUberService must implement Comparable
  public void sortByDistance()
  {
    Collections.sort(serviceRequests);
    listAllServiceRequests();
  }

  public class InvalidInputError extends RuntimeException {
    public InvalidInputError(String message) {
      super(message);
    }
  }

  public class UserError extends RuntimeException {
    public UserError(String message) {
      super(message);
    }
  }

  public class DriverError extends RuntimeException {
    public DriverError(String message) {
      super(message);
    }
  }

  public class ServiceRequestError extends RuntimeException {
    public ServiceRequestError(String message) {
      super(message);
    }
  }
}
