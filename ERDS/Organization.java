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
  private String availableRessources;

  //Organization Associations
  private List<Person> persons;
  private List<Ressource> ressources;
  private Emergency emergency;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Organization(String aName, String aLocation, String aAvailableRessources, Emergency aEmergency)
  {
    name = aName;
    location = aLocation;
    availableRessources = aAvailableRessources;
    persons = new ArrayList<Person>();
    ressources = new ArrayList<Ressource>();
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

  public boolean setAvailableRessources(String aAvailableRessources)
  {
    boolean wasSet = false;
    availableRessources = aAvailableRessources;
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

  public String getAvailableRessources()
  {
    return availableRessources;
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
    ressources.add(aRessource);
    if (aRessource.indexOfOrganization(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aRessource.addOrganization(this);
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
    if (aRessource.indexOfOrganization(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aRessource.removeOrganization(this);
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
    ArrayList<Ressource> copyOfRessources = new ArrayList<Ressource>(ressources);
    ressources.clear();
    for(Ressource aRessource : copyOfRessources)
    {
      aRessource.removeOrganization(this);
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
            "availableRessources" + ":" + getAvailableRessources()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "emergency = "+(getEmergency()!=null?Integer.toHexString(System.identityHashCode(getEmergency())):"null")
     + outputString;
  }
}