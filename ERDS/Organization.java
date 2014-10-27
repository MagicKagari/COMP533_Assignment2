/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.20.2.4305 modeling language!*/

package ERDS;
import java.util.*;

// line 12 "../classdiagram.ump"
public class Organization
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Organization Attributes
  private String name;
  private String location;
  private String availableResources;

  //Organization Associations
  private List<Person> persons;
  private List<Resource> resources;
  private Emergency emergency;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Organization(String aName, String aLocation, String aAvailableResources, Emergency aEmergency)
  {
    name = aName;
    location = aLocation;
    availableResources = aAvailableResources;
    persons = new ArrayList<Person>();
    resources = new ArrayList<Resource>();
    boolean didAddEmergency = setEmergency(aEmergency);
    if (!didAddEmergency)
    {
      throw new RuntimeException("Unable to create organization due to emergency");
    }
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

  public boolean setLocation(String aLocation)
  {
    boolean wasSet = false;
    location = aLocation;
    wasSet = true;
    return wasSet;
  }

  public boolean setAvailableResources(String aAvailableResources)
  {
    boolean wasSet = false;
    availableResources = aAvailableResources;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }

  public String getLocation()
  {
    return location;
  }

  public String getAvailableResources()
  {
    return availableResources;
  }

  public Person getPerson(int index)
  {
    Person aPerson = persons.get(index);
    return aPerson;
  }

  public List<Person> getPersons()
  {
    List<Person> newPersons = Collections.unmodifiableList(persons);
    return newPersons;
  }

  public int numberOfPersons()
  {
    int number = persons.size();
    return number;
  }

  public boolean hasPersons()
  {
    boolean has = persons.size() > 0;
    return has;
  }

  public int indexOfPerson(Person aPerson)
  {
    int index = persons.indexOf(aPerson);
    return index;
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

  public Emergency getEmergency()
  {
    return emergency;
  }

  public static int minimumNumberOfPersons()
  {
    return 0;
  }

  public boolean addPerson(Person aPerson)
  {
    boolean wasAdded = false;
    if (persons.contains(aPerson)) { return false; }
    if (persons.contains(aPerson)) { return false; }
    if (persons.contains(aPerson)) { return false; }
    persons.add(aPerson);
    if (aPerson.indexOfOrganization(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aPerson.addOrganization(this);
      if (!wasAdded)
      {
        persons.remove(aPerson);
      }
    }
    return wasAdded;
  }

  public boolean removePerson(Person aPerson)
  {
    boolean wasRemoved = false;
    if (!persons.contains(aPerson))
    {
      return wasRemoved;
    }

    int oldIndex = persons.indexOf(aPerson);
    persons.remove(oldIndex);
    if (aPerson.indexOfOrganization(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aPerson.removeOrganization(this);
      if (!wasRemoved)
      {
        persons.add(oldIndex,aPerson);
      }
    }
    return wasRemoved;
  }

  public boolean addPersonAt(Person aPerson, int index)
  {  
    boolean wasAdded = false;
    if(addPerson(aPerson))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPersons()) { index = numberOfPersons() - 1; }
      persons.remove(aPerson);
      persons.add(index, aPerson);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMovePersonAt(Person aPerson, int index)
  {
    boolean wasAdded = false;
    if(persons.contains(aPerson))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPersons()) { index = numberOfPersons() - 1; }
      persons.remove(aPerson);
      persons.add(index, aPerson);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addPersonAt(aPerson, index);
    }
    return wasAdded;
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
    resources.add(aResource);
    if (aResource.indexOfOrganization(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aResource.addOrganization(this);
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
    if (aResource.indexOfOrganization(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aResource.removeOrganization(this);
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

  public boolean setEmergency(Emergency aEmergency)
  {
    boolean wasSet = false;
    if (aEmergency == null)
    {
      return wasSet;
    }

    Emergency existingEmergency = emergency;
    emergency = aEmergency;
    if (existingEmergency != null && !existingEmergency.equals(aEmergency))
    {
      existingEmergency.removeOrganization(this);
    }
    emergency.addOrganization(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    ArrayList<Person> copyOfPersons = new ArrayList<Person>(persons);
    persons.clear();
    for(Person aPerson : copyOfPersons)
    {
      aPerson.removeOrganization(this);
    }
    ArrayList<Resource> copyOfResources = new ArrayList<Resource>(resources);
    resources.clear();
    for(Resource aResource : copyOfResources)
    {
      aResource.removeOrganization(this);
    }
    Emergency placeholderEmergency = emergency;
    this.emergency = null;
    placeholderEmergency.removeOrganization(this);
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "name" + ":" + getName()+ "," +
            "location" + ":" + getLocation()+ "," +
            "availableResources" + ":" + getAvailableResources()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "emergency = "+(getEmergency()!=null?Integer.toHexString(System.identityHashCode(getEmergency())):"null")
     + outputString;
  }
}