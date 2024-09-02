// Name: Sharaf Hussain
// ID: 501246102
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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

  //These variables are used to generate user account and driver ids
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
  // The methods below will set this errMsg string and then return false
  String errMsg = null;

  public String getErrorMessage()
  {
    return errMsg;
  }
  
  // Given user account id, find user in list of users
  // Return null if not found
  public User getUser(String accountId)
  {
    // Fill in the code
    for (int i=0; i<users.size(); i++)  {
      if (accountId.equals(users.get(i).getAccountId())){
        return users.get(i);
      }
    }
    return null;
  }
  
  // Check for duplicate user
  private boolean userExists(User user)
  {
    // Fill in the code
    for (int i=0; i<users.size(); i++)  {
      if (user.getAccountId().equals(users.get(i).getAccountId())) {
        return true;
      }
    }
    return false;
  }
  
 // Check for duplicate driver
 private boolean driverExists(Driver driver)
 {
   // Fill in the code
   for (int i=0; i<drivers.size(); i++)  {
    if (driver.getId().equals(drivers.get(i).getId())) {
      return true;
    }
  }
   return false;
 }
  
  // Given a user, check if user ride/delivery request already exists in service requests
  private boolean existingRequest(TMUberService req)
  {
    // Fill in the code
    for (int i=0; i<serviceRequests.size(); i++)  {
      if (req.getUser().getAccountId().equals(serviceRequests.get(i).getUser().getAccountId())) {
        return true;
      }
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
  // Return null if no available driver
  private Driver getAvailableDriver()
  {
    for (int i=0; i<drivers.size(); i++) {
      if (drivers.get(i).getStatus().equals(Driver.Status.AVAILABLE)) {
        return drivers.get(i);
      }
    }
    // Fill in the code
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
    // Fill in the code
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
    // Fill in the code
    System.out.println();
    
    for (int i = 0; i < serviceRequests.size(); i++)
    {
      int index = i + 1;
      System.out.printf("%-2s. ------------------------------------------------------------", index);
      serviceRequests.get(i).printInfo();
      System.out.println(); 
    }
  }

  // Add a new user to the system
  public boolean registerNewUser(String name, String address, double wallet)
  {
    // Fill in the code. Before creating a new user, check paramters for validity
    // See the assignment document for list of possible erros that might apply
    // Write the code like (for example):
    // if (address is *not* valid)
    // {
    //    set errMsg string variable to "Invalid Address "
    //    return false
    // }
    // If all parameter checks pass then create and add new user to array list users
    // Make sure you check if this user doesn't already exist!
    if (!(CityMap.validAddress(address))) {
      errMsg = "Invalid Address";
      return false;
    }
    else if ((name == null) || (name.equals(""))) {
      errMsg = "Invalid User Name";
      return false;
    }
    else if (wallet < 0) {
      errMsg = "Invalid Money in Wallet";
      return false;
    }
    User newUser = new User(("900"+users.size()), name, address, 0.0);
    users.add(newUser);
    return true;
  }

  // Add a new driver to the system
  public boolean registerNewDriver(String name, String carModel, String carLicencePlate)
  {
    // Fill in the code - see the assignment document for error conditions
    // that might apply. See comments above in registerNewUser
    if ((name == null) || (name.equals(""))) {
      errMsg = "Invalid Driver Name";
      return false;
    }
    else if ((carModel == null) || (carModel.equals(""))) {
      errMsg = "Invalid Car Model";
      return false;
    }
    else if ((carLicencePlate == null) || (carLicencePlate.equals(""))) {
      errMsg = "Invalid Car Licence Plate";
      return false;
    }
    Driver newDriver = new Driver(("700"+drivers.size()), name, carModel, carLicencePlate);
    drivers.add(newDriver);
    return true;
  }

  // Request a ride. User wallet will be reduced when drop off happens
  public boolean requestRide(String accountId, String from, String to)
  {
    // Check for valid parameters
	// Use the account id to find the user object in the list of users
    // Get the distance for this ride
    // Note: distance must be > 1 city block!
    // Find an available driver
    // Create the TMUberRide object
    // Check if existing ride request for this user - only one ride request per user at a time!
    // Change driver status
    // Add the ride request to the list of requests
    // Increment the number of rides for this user
    User person = users.get(0);
    for (int i=0; i<users.size(); i++) {
      if (users.get(i).getAccountId().equals(accountId)) {
        person = (User) users.get(i);
        break;
      }
    }
    
    if (!person.getAccountId().equals(accountId)) {
      errMsg = "User Account Not Found";
      return false;
    }
    boolean request = false;
    int distance = CityMap.getDistance(from, to); 
    Driver driver = (Driver) getAvailableDriver();
    for (int i=0; i<serviceRequests.size(); i++) {
      if (serviceRequests.get(i).getUser().getAccountId().equals(person.getAccountId())) {
        request = true; 
        break;
      }
    } 
    if (request) {
      errMsg = "User Already Has Ride Request";
      return false;
    }
    else if (distance < 1) {
      errMsg = "Insufficient Travel Distance";
      return false;
    }
    else if ((!(CityMap.validAddress(from))) || (!(CityMap.validAddress(to)))) {
      errMsg = "Invalid Address";
      return false;
    }
    else if (person.getWallet() < getRideCost(distance)) {
      errMsg = "Insufficient Funds";
      return false;
    }
    else if (driver == null) {
      errMsg = "No Drivers Available";
      return false;
    }
    driver.setStatus(Driver.Status.DRIVING);
    TMUberRide ride = new TMUberRide(driver, from, to, person, distance, getRideCost(distance));
    serviceRequests.add(ride);
    person.addRide();
    return true;
  }

  // Request a food delivery. User wallet will be reduced when drop off happens
  public boolean requestDelivery(String accountId, String from, String to, String restaurant, String foodOrderId)
  {
    // See the comments above and use them as a guide
    // For deliveries, an existing delivery has the same user, restaurant and food order id
    // Increment the number of deliveries the user has had
    User person;
    try {
      person = (User) getUser(accountId);
    }
    catch (Exception e) {
      errMsg = "User Account Not Found";
      return false;
    }
    int distance = CityMap.getDistance(from, to); 
    Driver driver = (Driver) getAvailableDriver();
    if (driver == null) {
      errMsg = "No Drivers Available";
      return false;
    }
    for (int i=0; i<serviceRequests.size(); i++) {
      if (serviceRequests.get(i).getServiceType().compareTo("DELIVERY") == 0) {
        TMUberDelivery found = (TMUberDelivery) serviceRequests.get(i);
        TMUberDelivery temp = new TMUberDelivery(driver, from, to, person, distance, getDeliveryCost(distance), restaurant, foodOrderId);
        if ((found.getRestaurant().compareTo(temp.getRestaurant()) == 0)&&(found.getFoodOrderId() == temp.getFoodOrderId())) {
          errMsg = "User Already Has Delivery Request at Restaurant with this Food Order";
          return false;
        } 
      }
    } 
    if (distance < 1) {
      errMsg = "Insufficient Travel Distance";
      return false;
    }
    else if ((!(CityMap.validAddress(from))) || (!(CityMap.validAddress(to)))) {
      errMsg = "Invalid Address";
      return false;
    }
    else if (person.getWallet() < getDeliveryCost(distance)) {
      errMsg = "Insufficient Funds";
      return false;
    }
    driver.setStatus(Driver.Status.DRIVING);
    TMUberDelivery delivery = new TMUberDelivery(driver, from, to, person, distance, getDeliveryCost(distance), restaurant, foodOrderId);
    serviceRequests.add(delivery);
    person.addDelivery();
    return true;
  }


  // Cancel an existing service request. 
  // parameter int request is the index in the serviceRequests array list
  public boolean cancelServiceRequest(int request)
  {
    request = request-1;
    try {
      if (serviceRequests.get(request).getServiceType().equals("RIDE")) {
        serviceRequests.get(request).getUser().minusRide();
      }
      else {
        serviceRequests.get(request).getUser().minusDelivery();
      }
      serviceRequests.remove(request);
    }
    catch(Exception e) {
      errMsg = "Invalid Request #";
      return false;
    }
    // Check if valid request #
    // Remove request from list
    // Also decrement number of rides or number of deliveries for this user
    // since this ride/delivery wasn't completed
    return true;
  }
  
  // Drop off a ride or a delivery. This completes a service.
  // parameter request is the index in the serviceRequests array list
  public boolean dropOff(int request)
  {
    // See above method for guidance
    // Get the cost for the service and add to total revenues
    // Pay the driver
    // Deduct driver fee from total revenues
    // Change driver status
    // Deduct cost of service from user
    request = request-1;
    try {
      double cost = serviceRequests.get(request).getCost();
      totalRevenue += cost-(cost*PAYRATE);
      serviceRequests.get(request).getUser().payForService(cost);
      serviceRequests.get(request).getDriver().setWallet((serviceRequests.get(request).getDriver().getWallet()+(cost*PAYRATE)));
      serviceRequests.get(request).getDriver().setStatus(Driver.Status.AVAILABLE);
      serviceRequests.remove(request);
    }
    catch(Exception e) {
      errMsg = "Invalid Request #";
      return false;
    }
    return true;
  }


  // Sort users by name
  // Then list all users
  public void sortByUserName()
  {
    String[] names = new String[users.size()];
    User[] usersArray = new User[users.size()];
    for (int i=0; i<users.size(); i++) {
      names[i] = users.get(i).getName();
      usersArray[i] = users.get(i);
    }
    NameComparator.bubbleSort(names, usersArray);
    for (int i=0; i<users.size(); i++) {
      users.set(i, usersArray[i]);
    }
    System.out.println();
    for (int i=0; i<users.size(); i++) {
      System.out.printf("%-2s. ", (i+1));
      users.get(i).printInfo();
      System.out.println();
    }
  }

  // Helper class for method sortByUserName
  private class NameComparator 
  {
    public static void bubbleSort(String[] x, User[] y) {
      for (int i=0; i<x.length - 1; i++) {
        boolean swapped = false;
        for (int j=0; j<x.length-i-1; j++) {
          if (x[j].compareToIgnoreCase(x[j+1]) > 0) {
            String temp = x[j];
            User temp2 = y[j];
            x[j] = x[j + 1];
            y[j] = y[j + 1];
            x[j + 1] = temp;
            y[j + 1] = temp2;
            swapped = true;
          }
        }
        if (swapped == false)
          break;
      }
    }
  }

  // Sort users by number amount in wallet
  // Then ist all users
  public void sortByWallet()
  {
    double[] money = new double[users.size()];
    User[] usersArray = new User[users.size()];
    for (int i=0; i<users.size(); i++) {
      money[i] = users.get(i).getWallet();
      usersArray[i] = users.get(i);
    }
    UserWalletComparator.bubbleSort(money, usersArray);
    for (int i=0; i<users.size(); i++) {
      users.set(i, usersArray[i]);
    }
    System.out.println();
    for (int i=0; i<users.size(); i++) {
      System.out.printf("%-2s. ", (i+1));
      users.get(i).printInfo();
      System.out.println();
    }
  }
  // Helper class for use by sortByWallet
  private class UserWalletComparator 
  {
    public static void bubbleSort(double[] x, User[] y) {
      for (int i=0; i<x.length - 1; i++) {
        boolean swapped = false;
        for (int j=0; j<x.length-i-1; j++) {
          if (x[j] > x[j+1]) {
            double temp = x[j];
            User temp2 = y[j];
            x[j] = x[j + 1];
            y[j] = y[j + 1];
            x[j + 1] = temp;
            y[j + 1] = temp2;
            swapped = true;
          }
        }
        if (swapped == false)
          break;
      }
    }
  }

  // Sort trips (rides or deliveries) by distance
  // Then list all current service requests
  public void sortByDistance()
  {
    for (int i=0; i<serviceRequests.size() - 1; i++) {
      boolean swapped = false;
      for (int j=0; j<serviceRequests.size()-i-1; j++) {
        if (serviceRequests.get(j).getDistance() < serviceRequests.get(j+1).getDistance()) {
          TMUberService temp = serviceRequests.get(j);
          serviceRequests.set(j, serviceRequests.get(j+1));
          serviceRequests.set(j+1, temp);
          swapped = true;
        }
      }
      if (swapped == false)
        break;
    }
    System.out.println();
    for (int i=0; i<serviceRequests.size(); i++) {
      System.out.printf("%-2s.", (i+1));
      serviceRequests.get(i).printInfo();
      System.out.println();
    }
  }

}
