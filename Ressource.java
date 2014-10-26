package classDiagram;



/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.20.2.${svn.Revision} modeling language!*/


import java.util.*;

// line 32 "model.ump"
// line 145 "model.ump"
public class Ressource
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Ressource Attributes
  private String description;

  //Ressource Associations
  private List<Transportation> transportations;
  private List<Emergency> emergencies;
  private List<Organization> organizations;
  private List<Coordinator> coordinators;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Ressource(String aDescription)
  {
    description = aDescription;
    transportations = new ArrayList<Transportation>();
    emergencies = new ArrayList<Emergency>();
    organizations = new ArrayList<Organization>();
    coordinators = new ArrayList<Coordinator>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setDescription(String aDescription)
  {
    boolean wasSet = false;
    description = aDescription;
    wasSet = true;
    return wasSet;
  }

  public String getDescription()
  {
    return description;
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

  public Organization getOrganization(int index)
  {
    Organization aOrganization = organizations.get(index);
    return aOrganization;
  }

  public List<Organization> getOrganizations()
  {
    List<Organization> newOrganizations = Collections.unmodifiableList(organizations);
    return newOrganizations;
  }

  public int numberOfOrganizations()
  {
    int number = organizations.size();
    return number;
  }

  public boolean hasOrganizations()
  {
    boolean has = organizations.size() > 0;
    return has;
  }

  public int indexOfOrganization(Organization aOrganization)
  {
    int index = organizations.indexOf(aOrganization);
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

  public static int minimumNumberOfTransportations()
  {
    return 0;
  }

  public boolean addTransportation(Transportation aTransportation)
  {
    boolean wasAdded = false;
    if (transportations.contains(aTransportation)) { return false; }
    if (transportations.contains(aTransportation)) { return false; }
    if (transportations.contains(aTransportation)) { return false; }
    transportations.add(aTransportation);
    if (aTransportation.indexOfRessource(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aTransportation.addRessource(this);
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
    if (aTransportation.indexOfRessource(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aTransportation.removeRessource(this);
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

  public static int minimumNumberOfEmergencies()
  {
    return 0;
  }

  public boolean addEmergency(Emergency aEmergency)
  {
    boolean wasAdded = false;
    if (emergencies.contains(aEmergency)) { return false; }
    if (emergencies.contains(aEmergency)) { return false; }
    if (emergencies.contains(aEmergency)) { return false; }
    emergencies.add(aEmergency);
    if (aEmergency.indexOfRessource(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aEmergency.addRessource(this);
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
    if (aEmergency.indexOfRessource(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aEmergency.removeRessource(this);
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

  public static int minimumNumberOfOrganizations()
  {
    return 0;
  }

  public boolean addOrganization(Organization aOrganization)
  {
    boolean wasAdded = false;
    if (organizations.contains(aOrganization)) { return false; }
    if (organizations.contains(aOrganization)) { return false; }
    if (organizations.contains(aOrganization)) { return false; }
    organizations.add(aOrganization);
    if (aOrganization.indexOfRessource(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aOrganization.addRessource(this);
      if (!wasAdded)
      {
        organizations.remove(aOrganization);
      }
    }
    return wasAdded;
  }

  public boolean removeOrganization(Organization aOrganization)
  {
    boolean wasRemoved = false;
    if (!organizations.contains(aOrganization))
    {
      return wasRemoved;
    }

    int oldIndex = organizations.indexOf(aOrganization);
    organizations.remove(oldIndex);
    if (aOrganization.indexOfRessource(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aOrganization.removeRessource(this);
      if (!wasRemoved)
      {
        organizations.add(oldIndex,aOrganization);
      }
    }
    return wasRemoved;
  }

  public boolean addOrganizationAt(Organization aOrganization, int index)
  {  
    boolean wasAdded = false;
    if(addOrganization(aOrganization))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfOrganizations()) { index = numberOfOrganizations() - 1; }
      organizations.remove(aOrganization);
      organizations.add(index, aOrganization);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveOrganizationAt(Organization aOrganization, int index)
  {
    boolean wasAdded = false;
    if(organizations.contains(aOrganization))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfOrganizations()) { index = numberOfOrganizations() - 1; }
      organizations.remove(aOrganization);
      organizations.add(index, aOrganization);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addOrganizationAt(aOrganization, index);
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
    coordinators.add(aCoordinator);
    if (aCoordinator.indexOfRessource(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aCoordinator.addRessource(this);
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
    if (aCoordinator.indexOfRessource(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aCoordinator.removeRessource(this);
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
    ArrayList<Transportation> copyOfTransportations = new ArrayList<Transportation>(transportations);
    transportations.clear();
    for(Transportation aTransportation : copyOfTransportations)
    {
      aTransportation.removeRessource(this);
    }
    ArrayList<Emergency> copyOfEmergencies = new ArrayList<Emergency>(emergencies);
    emergencies.clear();
    for(Emergency aEmergency : copyOfEmergencies)
    {
      aEmergency.removeRessource(this);
    }
    ArrayList<Organization> copyOfOrganizations = new ArrayList<Organization>(organizations);
    organizations.clear();
    for(Organization aOrganization : copyOfOrganizations)
    {
      aOrganization.removeRessource(this);
    }
    ArrayList<Coordinator> copyOfCoordinators = new ArrayList<Coordinator>(coordinators);
    coordinators.clear();
    for(Coordinator aCoordinator : copyOfCoordinators)
    {
      aCoordinator.removeRessource(this);
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "description" + ":" + getDescription()+ "]"
     + outputString;
  }
  //public int getResult() {
   //   return result;
  //}
}

