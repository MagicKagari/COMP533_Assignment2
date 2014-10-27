/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.20.2.4305 modeling language!*/

package ERDS;
import java.util.*;

// line 92 "../classdiagram.ump"
public class Coordinator
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Coordinator Attributes
  private String name;
  private String id;

  //Coordinator Associations
  private List<Resource> resources;
  private List<Emergency> emergencies;
  private List<Transportation> transportations;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Coordinator(String aName, String aId)
  {
    name = aName;
    id = aId;
    resources = new ArrayList<Resource>();
    emergencies = new ArrayList<Emergency>();
    transportations = new ArrayList<Transportation>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public boolean setId(String aId)
  {
    boolean wasSet = false;
    id = aId;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }

  public String getId()
  {
    return id;
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

  public Emergency getEmergency(int index)
  {
    Emergency aEmergency = emergencies.get(index);
    return aEmergency;
  }

  public List<Emergency> getEmergencies()
  {
    List<Emergency> newEmergencies = Collections.unmodifiableList(emergencies);
    return newEmergencies;
  }

  public int numberOfEmergencies()
  {
    int number = emergencies.size();
    return number;
  }

  public boolean hasEmergencies()
  {
    boolean has = emergencies.size() > 0;
    return has;
  }

  public int indexOfEmergency(Emergency aEmergency)
  {
    int index = emergencies.indexOf(aEmergency);
    return index;
  }

  public Transportation getTransportation(int index)
  {
    Transportation aTransportation = transportations.get(index);
    return aTransportation;
  }

  public List<Transportation> getTransportations()
  {
    List<Transportation> newTransportations = Collections.unmodifiableList(transportations);
    return newTransportations;
  }

  public int numberOfTransportations()
  {
    int number = transportations.size();
    return number;
  }

  public boolean hasTransportations()
  {
    boolean has = transportations.size() > 0;
    return has;
  }

  public int indexOfTransportation(Transportation aTransportation)
  {
    int index = transportations.indexOf(aTransportation);
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
    resources.add(aResource);
    if (aResource.indexOfCoordinator(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aResource.addCoordinator(this);
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
    if (aResource.indexOfCoordinator(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aResource.removeCoordinator(this);
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

  public static int minimumNumberOfEmergencies()
  {
    return 0;
  }

  public boolean addEmergency(Emergency aEmergency)
  {
    boolean wasAdded = false;
    if (emergencies.contains(aEmergency)) { return false; }
    emergencies.add(aEmergency);
    if (aEmergency.indexOfCoordinator(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aEmergency.addCoordinator(this);
      if (!wasAdded)
      {
        emergencies.remove(aEmergency);
      }
    }
    return wasAdded;
  }

  public boolean removeEmergency(Emergency aEmergency)
  {
    boolean wasRemoved = false;
    if (!emergencies.contains(aEmergency))
    {
      return wasRemoved;
    }

    int oldIndex = emergencies.indexOf(aEmergency);
    emergencies.remove(oldIndex);
    if (aEmergency.indexOfCoordinator(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aEmergency.removeCoordinator(this);
      if (!wasRemoved)
      {
        emergencies.add(oldIndex,aEmergency);
      }
    }
    return wasRemoved;
  }

  public boolean addEmergencyAt(Emergency aEmergency, int index)
  {  
    boolean wasAdded = false;
    if(addEmergency(aEmergency))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfEmergencies()) { index = numberOfEmergencies() - 1; }
      emergencies.remove(aEmergency);
      emergencies.add(index, aEmergency);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveEmergencyAt(Emergency aEmergency, int index)
  {
    boolean wasAdded = false;
    if(emergencies.contains(aEmergency))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfEmergencies()) { index = numberOfEmergencies() - 1; }
      emergencies.remove(aEmergency);
      emergencies.add(index, aEmergency);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addEmergencyAt(aEmergency, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfTransportations()
  {
    return 0;
  }

  public boolean addTransportation(Transportation aTransportation)
  {
    boolean wasAdded = false;
    if (transportations.contains(aTransportation)) { return false; }
    transportations.add(aTransportation);
    if (aTransportation.indexOfCoordinator(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aTransportation.addCoordinator(this);
      if (!wasAdded)
      {
        transportations.remove(aTransportation);
      }
    }
    return wasAdded;
  }

  public boolean removeTransportation(Transportation aTransportation)
  {
    boolean wasRemoved = false;
    if (!transportations.contains(aTransportation))
    {
      return wasRemoved;
    }

    int oldIndex = transportations.indexOf(aTransportation);
    transportations.remove(oldIndex);
    if (aTransportation.indexOfCoordinator(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aTransportation.removeCoordinator(this);
      if (!wasRemoved)
      {
        transportations.add(oldIndex,aTransportation);
      }
    }
    return wasRemoved;
  }

  public boolean addTransportationAt(Transportation aTransportation, int index)
  {  
    boolean wasAdded = false;
    if(addTransportation(aTransportation))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTransportations()) { index = numberOfTransportations() - 1; }
      transportations.remove(aTransportation);
      transportations.add(index, aTransportation);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveTransportationAt(Transportation aTransportation, int index)
  {
    boolean wasAdded = false;
    if(transportations.contains(aTransportation))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTransportations()) { index = numberOfTransportations() - 1; }
      transportations.remove(aTransportation);
      transportations.add(index, aTransportation);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addTransportationAt(aTransportation, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    ArrayList<Resource> copyOfResources = new ArrayList<Resource>(resources);
    resources.clear();
    for(Resource aResource : copyOfResources)
    {
      aResource.removeCoordinator(this);
    }
    ArrayList<Emergency> copyOfEmergencies = new ArrayList<Emergency>(emergencies);
    emergencies.clear();
    for(Emergency aEmergency : copyOfEmergencies)
    {
      aEmergency.removeCoordinator(this);
    }
    ArrayList<Transportation> copyOfTransportations = new ArrayList<Transportation>(transportations);
    transportations.clear();
    for(Transportation aTransportation : copyOfTransportations)
    {
      aTransportation.removeCoordinator(this);
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "name" + ":" + getName()+ "," +
            "id" + ":" + getId()+ "]"
     + outputString;
  }
}