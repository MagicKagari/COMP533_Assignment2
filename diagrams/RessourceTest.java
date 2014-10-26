package classDiagram;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;
import  org.junit.runner.RunWith;
import  org.junit.runners.Parameterized;
import  org.junit.runners.Parameterized.Parameters;

import andycpp.Calculator;

import  java.util.Arrays;
import  java.util.Collection;

//@RunWith(Parameterized. class )

public class RessourceTest {
private static Ressource ressource = new Ressource(null);
	
	//private   int  param;
	 
    //private   int  result;
//@Parameters

//public   static  Collection data()   {

  //  return  Arrays.asList( new  Object[][]  {

  //           { 2 ,  4 }  ,

  //           { 0 ,  0 }  ,

  //           {-3 ,  9 }  ,

 // }  );

//}  

//public  RessourceTest( int  param,  int  result)   {
  
 // this .param  =  param;

 // this .result  =  result;

//}  

	@Before
	public void setUp() throws Exception {
	}

   // @Test
    
    //public   void  getTransportation()   {

     // ressource.getTransportation(param);

    //  assertEquals(result, ressource.getTransportation(param));
	
	
	//@Test
	//public void testGetDescription() {
	
	//}

	@Test
	public void testGetTransportation() {
		ressource.getTransportation(1); 
		assertEquals("air", ressource.getTransportation(1));
	}

	@Test
	public void testNumberOfTransportations() {
		ressource.numberOfTransportations();
		assertEquals(3, ressource.numberOfTransportations());
	}

	@Test
	public void testGetEmergency() {
		ressource.getEmergency(1); 
		assertEquals("WHO", ressource.getEmergency(1));
	}

	@Test
	public void testNumberOfEmergencies() {
		ressource.numberOfEmergencies();
		assertEquals(3, ressource.numberOfEmergencies());
	}

	@Test
	public void testGetOrganization() {
		ressource.getOrganization(1); 
		assertEquals("charity", ressource.getOrganization(1));
	}

	@Test
	public void testGetCoordinator() {
		ressource.getCoordinator(1); 
		assertEquals("Coordinator01", ressource.getCoordinator(1));
	}

	//@Test
	//public void testAddEmergencyAt() {
		
	//}

	//@Test
	//public void testAddOrganizationAt() {
		
	//}

	//@Test
	//public void testAddOrMoveOrganizationAt() {
		
	//}

	//@Test
	//public void testAddCoordinatorAt() {
		
	//}

	//@Test
	//public void testAddOrMoveCoordinatorAt() {
		
	//}

	public static Ressource getRessource() {
		return ressource;
	}

	public static void setRessource(Ressource ressource) {
		RessourceTest.ressource = ressource;
	}

}
