/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.20.2.4305 modeling language!*/

package ERDS;
import java.util.*;

// line 84 "../classdiagram.ump"
public class Person
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Person Attributes
  private String name;
  private int age;
  private String gender;

  //Person Associations
  private List<Skill> skills;
  private List<Organization> organizations;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Person(String aName, int aAge, String aGender)
  {
    name = aName;
    age = aAge;
    gender = aGender;
    skills = new ArrayList<Skill>();
    organizations = new ArrayList<Organization>();
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

  public boolean setAge(int aAge)
  {
    boolean wasSet = false;
    age = aAge;
    wasSet = true;
    return wasSet;
  }

  public boolean setGender(String aGender)
  {
    boolean wasSet = false;
    gender = aGender;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }

  public int getAge()
  {
    return age;
  }

  public String getGender()
  {
    return gender;
  }

  public Skill getSkill(int index)
  {
    Skill aSkill = skills.get(index);
    return aSkill;
  }

  public List<Skill> getSkills()
  {
    List<Skill> newSkills = Collections.unmodifiableList(skills);
    return newSkills;
  }

  public int numberOfSkills()
  {
    int number = skills.size();
    return number;
  }

  public boolean hasSkills()
  {
    boolean has = skills.size() > 0;
    return has;
  }

  public int indexOfSkill(Skill aSkill)
  {
    int index = skills.indexOf(aSkill);
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

  public static int minimumNumberOfSkills()
  {
    return 0;
  }

  public boolean addSkill(Skill aSkill)
  {
    boolean wasAdded = false;
    if (skills.contains(aSkill)) { return false; }
    skills.add(aSkill);
    if (aSkill.indexOfPerson(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aSkill.addPerson(this);
      if (!wasAdded)
      {
        skills.remove(aSkill);
      }
    }
    return wasAdded;
  }

  public boolean removeSkill(Skill aSkill)
  {
    boolean wasRemoved = false;
    if (!skills.contains(aSkill))
    {
      return wasRemoved;
    }

    int oldIndex = skills.indexOf(aSkill);
    skills.remove(oldIndex);
    if (aSkill.indexOfPerson(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aSkill.removePerson(this);
      if (!wasRemoved)
      {
        skills.add(oldIndex,aSkill);
      }
    }
    return wasRemoved;
  }

  public boolean addSkillAt(Skill aSkill, int index)
  {  
    boolean wasAdded = false;
    if(addSkill(aSkill))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfSkills()) { index = numberOfSkills() - 1; }
      skills.remove(aSkill);
      skills.add(index, aSkill);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveSkillAt(Skill aSkill, int index)
  {
    boolean wasAdded = false;
    if(skills.contains(aSkill))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfSkills()) { index = numberOfSkills() - 1; }
      skills.remove(aSkill);
      skills.add(index, aSkill);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addSkillAt(aSkill, index);
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
    organizations.add(aOrganization);
    if (aOrganization.indexOfPerson(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aOrganization.addPerson(this);
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
    if (aOrganization.indexOfPerson(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aOrganization.removePerson(this);
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

  public void delete()
  {
    ArrayList<Skill> copyOfSkills = new ArrayList<Skill>(skills);
    skills.clear();
    for(Skill aSkill : copyOfSkills)
    {
      aSkill.removePerson(this);
    }
    ArrayList<Organization> copyOfOrganizations = new ArrayList<Organization>(organizations);
    organizations.clear();
    for(Organization aOrganization : copyOfOrganizations)
    {
      aOrganization.removePerson(this);
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "name" + ":" + getName()+ "," +
            "age" + ":" + getAge()+ "," +
            "gender" + ":" + getGender()+ "]"
     + outputString;
  }
}