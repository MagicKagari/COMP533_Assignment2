package classDiagram;



/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.20.2.${svn.Revision} modeling language!*/


import java.util.*;

// line 38 "model.ump"
// line 150 "model.ump"
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
  private List<Ressource> ressources;
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
    ressources = new ArrayList<Ressource>();
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

  public Ressource getRessource(int index)
  {
    Ressource aRessource = ressources.get(index);
    return aRessource;
  }

  public List<Ressource> getRessources()
  {
    List<Ressource> newRessources = Collections.unmodifiableList(ressources);
    return newRessources;
  }

  public int numberOfRessources()
  {
    int number = ressources.size();
    return number;
  }

  public boolean hasRessources()
  {
    boolean has = ressources.size() > 0;
    return has;
  }

  public int indexOfRessource(Ressource aRessource)
  {
    int index = ressources.indexOf(aRessource);
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

  public static int minimumNumberOfRessources()
  {
    return 0;
  }

  public boolean addRessource(Ressource aRessource)
  {
    boolean wasAdded = false;
    if (ressources.contains(aRessource)) { return false; }
    if (ressources.contains(aRessource)) { return false; }
    if (ressources.contains(aRessource)) { return false; }
    if (ressources.contains(aRessource)) { return false; }
    ressources.add(aRessource);
    if (aRessource.indexOfTransportation(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aRessource.addTransportation(this);
      if (!wasAdded)
      {
        ressources.remove(aRessource);
      }
    }
    return wasAdded;
  }

  public boolean removeRessource(Ressource aRessource)
  {
    boolean wasRemoved = false;
    if (!ressources.contains(aRessource))
    {
      return wasRemoved;
    }

    int oldIndex = ressources.indexOf(aRessource);
    ressources.remove(oldIndex);
    if (aRessource.indexOfTransportation(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aRessource.removeTransportation(this);
      if (!wasRemoved)
      {
        ressources.add(oldIndex,aRessource);
      }
    }
    return wasRemoved;
  }

  public boolean addRessourceAt(Ressource aRessource, int index)
  {  
    boolean wasAdded = false;
    if(addRessource(aRessource))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfRessources()) { index = numberOfRessources() - 1; }
      ressources.remove(aRessource);
      ressources.add(index, aRessource);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveRessourceAt(Ressource aRessource, int index)
  {
    boolean wasAdded = false;
    if(ressources.contains(aRessource))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfRessources()) { index = numberOfRessources() - 1; }
      ressources.remove(aRessource);
      ressources.add(index, aRessource);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addRessourceAt(aRessource, index);
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
    ArrayList<Ressource> copyOfRessources = new ArrayList<Ressource>(ressources);
    ressources.clear();
    for(Ressource aRessource : copyOfRessources)
    {
      aRessource.removeTransportation(this);
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

