/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.20.2.4305 modeling language!*/

package ERDS;
import java.util.*;

// line 79 "../classdiagram.ump"
public class ResourceNeeds
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ResourceNeeds Attributes
  private int requiredQuantity;

  //ResourceNeeds Associations
  private List<Emergency> emergencies;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ResourceNeeds(int aRequiredQuantity)
  {
    requiredQuantity = aRequiredQuantity;
    emergencies = new ArrayList<Emergency>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setRequiredQuantity(int aRequiredQuantity)
  {
    boolean wasSet = false;
    requiredQuantity = aRequiredQuantity;
    wasSet = true;
    return wasSet;
  }

  public int getRequiredQuantity()
  {
    return requiredQuantity;
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

  public static int minimumNumberOfEmergencies()
  {
    return 0;
  }

  public boolean addEmergency(Emergency aEmergency)
  {
    boolean wasAdded = false;
    if (emergencies.contains(aEmergency)) { return false; }
    emergencies.add(aEmergency);
    if (aEmergency.indexOfResourceNeed(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aEmergency.addResourceNeed(this);
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
    if (aEmergency.indexOfResourceNeed(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aEmergency.removeResourceNeed(this);
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

  public void delete()
  {
    ArrayList<Emergency> copyOfEmergencies = new ArrayList<Emergency>(emergencies);
    emergencies.clear();
    for(Emergency aEmergency : copyOfEmergencies)
    {
      aEmergency.removeResourceNeed(this);
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "requiredQuantity" + ":" + getRequiredQuantity()+ "]"
     + outputString;
  }
}