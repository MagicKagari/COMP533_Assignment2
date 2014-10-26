/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.20.2.4305 modeling language!*/

package ERDS;
import java.util.*;

// line 3 "../classdiagram.ump"
// line 101 "../classdiagram.ump"
public class Emergency
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Emergency Attributes
  private String location;

  //Emergency State Machines
  enum Sm { LocalEmergency, Reported, ResourceNeeded, ResourceFound, ResourceLocating, ResourceLocated, TransportationFound, TransportationSent, TransportResource, EmergencyResolved }
  private Sm sm;

  //Emergency Associations
  private List<Organization> organizations;
  private List<Community> communities;
  private List<Ressource> ressources;
  private List<RessourceNeeds> ressourceNeeds;
  private List<Coordinator> coordinators;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Emergency(String aLocation)
  {
    location = aLocation;
    organizations = new ArrayList<Organization>();
    communities = new ArrayList<Community>();
    ressources = new ArrayList<Ressource>();
    ressourceNeeds = new ArrayList<RessourceNeeds>();
    coordinators = new ArrayList<Coordinator>();
    setSm(Sm.LocalEmergency);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setLocation(String aLocation)
  {
    boolean wasSet = false;
    location = aLocation;
    wasSet = true;
    return wasSet;
  }

  public String getLocation()
  {
    return location;
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

  public boolean reportEmergency()
  {
    boolean wasEventProcessed = false;
    
    Sm aSm = sm;
    switch (aSm)
    {
      case LocalEmergency:
        setSm(Sm.Reported);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean checkNeededResource()
  {
    boolean wasEventProcessed = false;
    
    Sm aSm = sm;
    switch (aSm)
    {
      case Reported:
        setSm(Sm.ResourceNeeded);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean findNeededRessource()
  {
    boolean wasEventProcessed = false;
    
    Sm aSm = sm;
    switch (aSm)
    {
      case ResourceNeeded:
        setSm(Sm.ResourceFound);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean locateResource()
  {
    boolean wasEventProcessed = false;
    
    Sm aSm = sm;
    switch (aSm)
    {
      case ResourceFound:
        setSm(Sm.ResourceLocating);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean failToLocate()
  {
    boolean wasEventProcessed = false;
    
    Sm aSm = sm;
    switch (aSm)
    {
      case ResourceLocating:
        setSm(Sm.ResourceLocating);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean successfullToLocate()
  {
    boolean wasEventProcessed = false;
    
    Sm aSm = sm;
    switch (aSm)
    {
      case ResourceLocating:
        setSm(Sm.ResourceLocated);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean identifyTransportation()
  {
    boolean wasEventProcessed = false;
    
    Sm aSm = sm;
    switch (aSm)
    {
      case ResourceLocated:
        setSm(Sm.TransportationFound);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean sendTransportation()
  {
    boolean wasEventProcessed = false;
    
    Sm aSm = sm;
    switch (aSm)
    {
      case TransportationFound:
        setSm(Sm.TransportationSent);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean transportationArrived()
  {
    boolean wasEventProcessed = false;
    
    Sm aSm = sm;
    switch (aSm)
    {
      case TransportationSent:
        setSm(Sm.TransportResource);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean ressourceArrived()
  {
    boolean wasEventProcessed = false;
    
    Sm aSm = sm;
    switch (aSm)
    {
      case TransportResource:
        setSm(Sm.EmergencyResolved);
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

  public Community getCommunity(int index)
  {
    Community aCommunity = communities.get(index);
    return aCommunity;
  }

  public List<Community> getCommunities()
  {
    List<Community> newCommunities = Collections.unmodifiableList(communities);
    return newCommunities;
  }

  public int numberOfCommunities()
  {
    int number = communities.size();
    return number;
  }

  public boolean hasCommunities()
  {
    boolean has = communities.size() > 0;
    return has;
  }

  public int indexOfCommunity(Community aCommunity)
  {
    int index = communities.indexOf(aCommunity);
    return index;
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

  public RessourceNeeds getRessourceNeed(int index)
  {
    RessourceNeeds aRessourceNeed = ressourceNeeds.get(index);
    return aRessourceNeed;
  }

  public List<RessourceNeeds> getRessourceNeeds()
  {
    List<RessourceNeeds> newRessourceNeeds = Collections.unmodifiableList(ressourceNeeds);
    return newRessourceNeeds;
  }

  public int numberOfRessourceNeeds()
  {
    int number = ressourceNeeds.size();
    return number;
  }

  public boolean hasRessourceNeeds()
  {
    boolean has = ressourceNeeds.size() > 0;
    return has;
  }

  public int indexOfRessourceNeed(RessourceNeeds aRessourceNeed)
  {
    int index = ressourceNeeds.indexOf(aRessourceNeed);
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

  public static int minimumNumberOfOrganizations()
  {
    return 0;
  }

  public Organization addOrganization(String aName, String aLocation, String aAvailableRessources)
  {
    return new Organization(aName, aLocation, aAvailableRessources, this);
  }

  public boolean addOrganization(Organization aOrganization)
  {
    boolean wasAdded = false;
    if (organizations.contains(aOrganization)) { return false; }
    Emergency existingEmergency = aOrganization.getEmergency();
    boolean isNewEmergency = existingEmergency != null && !this.equals(existingEmergency);
    if (isNewEmergency)
    {
      aOrganization.setEmergency(this);
    }
    else
    {
      organizations.add(aOrganization);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeOrganization(Organization aOrganization)
  {
    boolean wasRemoved = false;
    //Unable to remove aOrganization, as it must always have a emergency
    if (!this.equals(aOrganization.getEmergency()))
    {
      organizations.remove(aOrganization);
      wasRemoved = true;
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

  public static int minimumNumberOfCommunities()
  {
    return 0;
  }

  public boolean addCommunity(Community aCommunity)
  {
    boolean wasAdded = false;
    if (communities.contains(aCommunity)) { return false; }
    communities.add(aCommunity);
    if (aCommunity.indexOfEmergency(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aCommunity.addEmergency(this);
      if (!wasAdded)
      {
        communities.remove(aCommunity);
      }
    }
    return wasAdded;
  }

  public boolean removeCommunity(Community aCommunity)
  {
    boolean wasRemoved = false;
    if (!communities.contains(aCommunity))
    {
      return wasRemoved;
    }

    int oldIndex = communities.indexOf(aCommunity);
    communities.remove(oldIndex);
    if (aCommunity.indexOfEmergency(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aCommunity.removeEmergency(this);
      if (!wasRemoved)
      {
        communities.add(oldIndex,aCommunity);
      }
    }
    return wasRemoved;
  }

  public boolean addCommunityAt(Community aCommunity, int index)
  {  
    boolean wasAdded = false;
    if(addCommunity(aCommunity))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfCommunities()) { index = numberOfCommunities() - 1; }
      communities.remove(aCommunity);
      communities.add(index, aCommunity);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveCommunityAt(Community aCommunity, int index)
  {
    boolean wasAdded = false;
    if(communities.contains(aCommunity))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfCommunities()) { index = numberOfCommunities() - 1; }
      communities.remove(aCommunity);
      communities.add(index, aCommunity);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addCommunityAt(aCommunity, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfRessources()
  {
    return 0;
  }

  public boolean addRessource(Ressource aRessource)
  {
    boolean wasAdded = false;
    if (ressources.contains(aRessource)) { return false; }
    ressources.add(aRessource);
    if (aRessource.indexOfEmergency(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aRessource.addEmergency(this);
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
    if (aRessource.indexOfEmergency(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aRessource.removeEmergency(this);
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

  public static int minimumNumberOfRessourceNeeds()
  {
    return 0;
  }

  public boolean addRessourceNeed(RessourceNeeds aRessourceNeed)
  {
    boolean wasAdded = false;
    if (ressourceNeeds.contains(aRessourceNeed)) { return false; }
    ressourceNeeds.add(aRessourceNeed);
    if (aRessourceNeed.indexOfEmergency(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aRessourceNeed.addEmergency(this);
      if (!wasAdded)
      {
        ressourceNeeds.remove(aRessourceNeed);
      }
    }
    return wasAdded;
  }

  public boolean removeRessourceNeed(RessourceNeeds aRessourceNeed)
  {
    boolean wasRemoved = false;
    if (!ressourceNeeds.contains(aRessourceNeed))
    {
      return wasRemoved;
    }

    int oldIndex = ressourceNeeds.indexOf(aRessourceNeed);
    ressourceNeeds.remove(oldIndex);
    if (aRessourceNeed.indexOfEmergency(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aRessourceNeed.removeEmergency(this);
      if (!wasRemoved)
      {
        ressourceNeeds.add(oldIndex,aRessourceNeed);
      }
    }
    return wasRemoved;
  }

  public boolean addRessourceNeedAt(RessourceNeeds aRessourceNeed, int index)
  {  
    boolean wasAdded = false;
    if(addRessourceNeed(aRessourceNeed))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfRessourceNeeds()) { index = numberOfRessourceNeeds() - 1; }
      ressourceNeeds.remove(aRessourceNeed);
      ressourceNeeds.add(index, aRessourceNeed);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveRessourceNeedAt(RessourceNeeds aRessourceNeed, int index)
  {
    boolean wasAdded = false;
    if(ressourceNeeds.contains(aRessourceNeed))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfRessourceNeeds()) { index = numberOfRessourceNeeds() - 1; }
      ressourceNeeds.remove(aRessourceNeed);
      ressourceNeeds.add(index, aRessourceNeed);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addRessourceNeedAt(aRessourceNeed, index);
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
    coordinators.add(aCoordinator);
    if (aCoordinator.indexOfEmergency(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aCoordinator.addEmergency(this);
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
    if (aCoordinator.indexOfEmergency(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aCoordinator.removeEmergency(this);
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
    for(int i=organizations.size(); i > 0; i--)
    {
      Organization aOrganization = organizations.get(i - 1);
      aOrganization.delete();
    }
    ArrayList<Community> copyOfCommunities = new ArrayList<Community>(communities);
    communities.clear();
    for(Community aCommunity : copyOfCommunities)
    {
      aCommunity.removeEmergency(this);
    }
    ArrayList<Ressource> copyOfRessources = new ArrayList<Ressource>(ressources);
    ressources.clear();
    for(Ressource aRessource : copyOfRessources)
    {
      aRessource.removeEmergency(this);
    }
    ArrayList<RessourceNeeds> copyOfRessourceNeeds = new ArrayList<RessourceNeeds>(ressourceNeeds);
    ressourceNeeds.clear();
    for(RessourceNeeds aRessourceNeed : copyOfRessourceNeeds)
    {
      aRessourceNeed.removeEmergency(this);
    }
    ArrayList<Coordinator> copyOfCoordinators = new ArrayList<Coordinator>(coordinators);
    coordinators.clear();
    for(Coordinator aCoordinator : copyOfCoordinators)
    {
      aCoordinator.removeEmergency(this);
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "location" + ":" + getLocation()+ "]"
     + outputString;
  }
}