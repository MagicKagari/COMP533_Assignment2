/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.20.2.4305 modeling language!*/

package ERDS;
import java.util.*;

// line 46 "../classdiagram.ump"
public class LocalOrganization extends Organization
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public LocalOrganization(String aName, String aLocation, String aAvailableRessources, Emergency aEmergency)
  {
    super(aName, aLocation, aAvailableRessources, aEmergency);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public void delete()
  {
    super.delete();
  }

}