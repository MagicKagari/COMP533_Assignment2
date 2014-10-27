/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.20.2.4305 modeling language!*/

package ERDS;
import java.util.*;

// line 27 "../classdiagram.ump"
public class Transportation
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Transportation Attributes
  private String companyName;
  private int capacityWeight;
  private int capacitySpace;
  private int availability;
  private int range;

  //Transportation Associations
  private List<Resource> resources;
  private List<Coordinator> coordinators;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Transportation(String aCompanyName, int aCapacityWeight, int aCapacitySpace, int aAvailability, int aRange)
  {
    companyName = aCompanyName;
    capacityWeight = aCapacityWeight;
    capacitySpace = aCapacitySpace;
    availability = aAvailability;
    range = aRange;
    resources = new ArrayList<Resource>();
    coordinators = new ArrayList<Coordinator>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setCompanyName(String aCompanyName)
  {
    boolean wasSet = false;
    companyName = aCompanyName;
    wasSet = true;
    return wasSet;
  }

  public boolean setCapacityWeight(int aCapacityWeight)
  {
    boolean wasSet = false;
    capacityWeight = aCapacityWeight;
    wasSet = true;
    return wasSet;
  }

  public boolean setCapacitySpace(int aCapacitySpace)
  {
    boolean wasSet = false;
    capacitySpace = aCapacitySpace;
    wasSet = true;
    return wasSet;
  }

  public boolean setAvailability(int aAvailability)
  {
    boolean wasSet = false;
    availability = aAvailability;
    wasSet = true;
    return wasSet;
  }

  public boolean setRange(int aRange)
  {
    boolean wasSet = false;
    range = aRange;
    wasSet = true;
    return wasSet;
  }

  public String getCompanyName()
  {
    return companyName;
  }

  public int getCapacityWeight()
  {
    return capacityWeight;
  }

  public int getCapacitySpace()
  {
    return capacitySpace;
  }

  public int getAvailability()
  {
    return availability;
  }

  public int getRange()
  {
    return range;
  }

  public Resource getResource(int index)
  {
    Resource aResource = resources.get(index);
    return aResource;
  }

  public List<Resource> getResources()
  {
    List<Resource> newResources = Collections.unmodifiableList(resources);
    return newResources;
  }

  public int numberOfResources()
  {
    int number = resources.size();
    return number;
  }

  public boolean hasResources()
  {
    boolean has = resources.size() > 0;
    return has;
  }

  public int indexOfResource(Resource aResource)
  {
    int index = resources.indexOf(aResource);
    return index;
  }

  public Coordinator getCoordinator(int index)
  {
    Coordinator aCoordinator = coordinators.get(index);
    return aCoordinator;
  }

  public List<Coordinator> getCoordinators()
  {
    List<Coordinator> newCoordinators = Collections.unmodifiableList(coordinators);
    return newCoordinators;
  }

  public int numberOfCoordinators()
  {
    int number = coordinators.size();
    return number;
  }

  public boolean hasCoordinators()
  {
    boolean has = coordinators.size() > 0;
    return has;
  }

  public int indexOfCoordinator(Coordinator aCoordinator)
  {
    int index = coordinators.indexOf(aCoordinator);
    return index;
  }

  public static int minimumNumberOfResources()
  {
    return 0;
  }

  public boolean addResource(Resource aResource)
  {
    boolean wasAdded = false;
    if (resources.contains(aResource)) { return false; }
    if (resources.contains(aResource)) { return false; }
    if (resources.contains(aResource)) { return false; }
    if (resources.contains(aResource)) { return false; }
    resources.add(aResource);
    if (aResource.indexOfTransportation(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aResource.addTransportation(this);
      if (!wasAdded)
      {
        resources.remove(aResource);
      }
    }
    return wasAdded;
  }

  public boolean removeResource(Resource aResource)
  {
    boolean wasRemoved = false;
    if (!resources.contains(aResource))
    {
      return wasRemoved;
    }

    int oldIndex = resources.indexOf(aResource);
    resources.remove(oldIndex);
    if (aResource.indexOfTransportation(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aResource.removeTransportation(this);
      if (!wasRemoved)
      {
        resources.add(oldIndex,aResource);
      }
    }
    return wasRemoved;
  }

  public boolean addResourceAt(Resource aResource, int index)
  {  
    boolean wasAdded = false;
    if(addResource(aResource))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfResources()) { index = numberOfResources() - 1; }
      resources.remove(aResource);
      resources.add(index, aResource);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveResourceAt(Resource aResource, int index)
  {
    boolean wasAdded = false;
    if(resources.contains(aResource))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfResources()) { index = numberOfResources() - 1; }
      resources.remove(aResource);
      resources.add(index, aResource);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addResourceAt(aResource, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfCoordinators()
  {
    return 0;
  }

  public boolean addCoordinator(Coordinator aCoordinator)
  {
    boolean wasAdded = false;
    if (coordinators.contains(aCoordinator)) { return false; }
    if (coordinators.contains(aCoordinator)) { return false; }
    if (coordinators.contains(aCoordinator)) { return false; }
    if (coordinators.contains(aCoordinator)) { return false; }
    coordinators.add(aCoordinator);
    if (aCoordinator.indexOfTransportation(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aCoordinator.addTransportation(this);
      if (!wasAdded)
      {
        coordinators.remove(aCoordinator);
      }
    }
    return wasAdded;
  }

  public boolean removeCoordinator(Coordinator aCoordinator)
  {
    boolean wasRemoved = false;
    if (!coordinators.contains(aCoordinator))
    {
      return wasRemoved;
    }

    int oldIndex = coordinators.indexOf(aCoordinator);
    coordinators.remove(oldIndex);
    if (aCoordinator.indexOfTransportation(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aCoordinator.removeTransportation(this);
      if (!wasRemoved)
      {
        coordinators.add(oldIndex,aCoordinator);
      }
    }
    return wasRemoved;
  }

  public boolean addCoordinatorAt(Coordinator aCoordinator, int index)
  {  
    boolean wasAdded = false;
    if(addCoordinator(aCoordinator))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfCoordinators()) { index = numberOfCoordinators() - 1; }
      coordinators.remove(aCoordinator);
      coordinators.add(index, aCoordinator);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveCoordinatorAt(Coordinator aCoordinator, int index)
  {
    boolean wasAdded = false;
    if(coordinators.contains(aCoordinator))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfCoordinators()) { index = numberOfCoordinators() - 1; }
      coordinators.remove(aCoordinator);
      coordinators.add(index, aCoordinator);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addCoordinatorAt(aCoordinator, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    ArrayList<Resource> copyOfResources = new ArrayList<Resource>(resources);
    resources.clear();
    for(Resource aResource : copyOfResources)
    {
      aResource.removeTransportation(this);
    }
    ArrayList<Coordinator> copyOfCoordinators = new ArrayList<Coordinator>(coordinators);
    coordinators.clear();
    for(Coordinator aCoordinator : copyOfCoordinators)
    {
      aCoordinator.removeTransportation(this);
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "companyName" + ":" + getCompanyName()+ "," +
            "capacityWeight" + ":" + getCapacityWeight()+ "," +
            "capacitySpace" + ":" + getCapacitySpace()+ "," +
            "availability" + ":" + getAvailability()+ "," +
            "range" + ":" + getRange()+ "]"
     + outputString;
  }
}