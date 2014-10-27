/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.20.2.4305 modeling language!*/

package ERDS;
import java.util.*;

// line 21 "../classdiagram.ump"
// line 148 "../classdiagram.ump"
public class Resource
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Resource Attributes
  private String description;

  //Resource State Machines
  enum Sm { StandBy, OrganizationFound, ProcessingResource, ContactPerson, GettingDescription, PersonArriving, TransportationArriving, HelpingEmergency }
  private Sm sm;

  //Resource Associations
  private List<Transportation> transportations;
  private List<Emergency> emergencies;
  private List<Organization> organizations;
  private List<Coordinator> coordinators;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Resource(String aDescription)
  {
    description = aDescription;
    transportations = new ArrayList<Transportation>();
    emergencies = new ArrayList<Emergency>();
    organizations = new ArrayList<Organization>();
    coordinators = new ArrayList<Coordinator>();
    setSm(Sm.StandBy);
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

  public String getSmFullName()
  {
    String answer = sm.toString();
    return answer;
  }

  public Sm getSm()
  {
    return sm;
  }

  public boolean neededResource()
  {
    boolean wasEventProcessed = false;
    
    Sm aSm = sm;
    switch (aSm)
    {
      case StandBy:
        setSm(Sm.OrganizationFound);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean getResource()
  {
    boolean wasEventProcessed = false;
    
    Sm aSm = sm;
    switch (aSm)
    {
      case OrganizationFound:
        setSm(Sm.ProcessingResource);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean human()
  {
    boolean wasEventProcessed = false;
    
    Sm aSm = sm;
    switch (aSm)
    {
      case ProcessingResource:
        setSm(Sm.ContactPerson);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean packagedGoods()
  {
    boolean wasEventProcessed = false;
    
    Sm aSm = sm;
    switch (aSm)
    {
      case ProcessingResource:
        setSm(Sm.GettingDescription);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean unableToContact()
  {
    boolean wasEventProcessed = false;
    
    Sm aSm = sm;
    switch (aSm)
    {
      case ContactPerson:
        setSm(Sm.StandBy);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean personContacted()
  {
    boolean wasEventProcessed = false;
    
    Sm aSm = sm;
    switch (aSm)
    {
      case ContactPerson:
        setSm(Sm.PersonArriving);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean awaitTransportation()
  {
    boolean wasEventProcessed = false;
    
    Sm aSm = sm;
    switch (aSm)
    {
      case GettingDescription:
        setSm(Sm.TransportationArriving);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean personHelps()
  {
    boolean wasEventProcessed = false;
    
    Sm aSm = sm;
    switch (aSm)
    {
      case PersonArriving:
        setSm(Sm.HelpingEmergency);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean sendResource()
  {
    boolean wasEventProcessed = false;
    
    Sm aSm = sm;
    switch (aSm)
    {
      case TransportationArriving:
        setSm(Sm.HelpingEmergency);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private void setSm(Sm aSm)
  {
    sm = aSm;
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
    if (aTransportation.indexOfResource(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aTransportation.addResource(this);
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
    if (aTransportation.indexOfResource(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aTransportation.removeResource(this);
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
    if (aEmergency.indexOfResource(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aEmergency.addResource(this);
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
    if (aEmergency.indexOfResource(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aEmergency.removeResource(this);
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
    if (aOrganization.indexOfResource(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aOrganization.addResource(this);
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
    if (aOrganization.indexOfResource(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aOrganization.removeResource(this);
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
    if (aCoordinator.indexOfResource(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aCoordinator.addResource(this);
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
    if (aCoordinator.indexOfResource(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aCoordinator.removeResource(this);
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
      aTransportation.removeResource(this);
    }
    ArrayList<Emergency> copyOfEmergencies = new ArrayList<Emergency>(emergencies);
    emergencies.clear();
    for(Emergency aEmergency : copyOfEmergencies)
    {
      aEmergency.removeResource(this);
    }
    ArrayList<Organization> copyOfOrganizations = new ArrayList<Organization>(organizations);
    organizations.clear();
    for(Organization aOrganization : copyOfOrganizations)
    {
      aOrganization.removeResource(this);
    }
    ArrayList<Coordinator> copyOfCoordinators = new ArrayList<Coordinator>(coordinators);
    coordinators.clear();
    for(Coordinator aCoordinator : copyOfCoordinators)
    {
      aCoordinator.removeResource(this);
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "description" + ":" + getDescription()+ "]"
     + outputString;
  }
}