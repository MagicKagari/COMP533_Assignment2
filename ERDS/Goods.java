/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.20.2.4305 modeling language!*/

package ERDS;
import java.util.*;

// line 56 "../classdiagram.ump"
public class Goods extends Resource
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Goods Attributes
  private int quantityUnits;
  private int dimension;
  private int weight;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Goods(String aDescription, int aQuantityUnits, int aDimension, int aWeight)
  {
    super(aDescription);
    quantityUnits = aQuantityUnits;
    dimension = aDimension;
    weight = aWeight;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setQuantityUnits(int aQuantityUnits)
  {
    boolean wasSet = false;
    quantityUnits = aQuantityUnits;
    wasSet = true;
    return wasSet;
  }

  public boolean setDimension(int aDimension)
  {
    boolean wasSet = false;
    dimension = aDimension;
    wasSet = true;
    return wasSet;
  }

  public boolean setWeight(int aWeight)
  {
    boolean wasSet = false;
    weight = aWeight;
    wasSet = true;
    return wasSet;
  }

  public int getQuantityUnits()
  {
    return quantityUnits;
  }

  public int getDimension()
  {
    return dimension;
  }

  public int getWeight()
  {
    return weight;
  }

  public void delete()
  {
    super.delete();
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "quantityUnits" + ":" + getQuantityUnits()+ "," +
            "dimension" + ":" + getDimension()+ "," +
            "weight" + ":" + getWeight()+ "]"
     + outputString;
  }
}