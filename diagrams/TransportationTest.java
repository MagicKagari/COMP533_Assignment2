package classDiagram;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TransportationTest {
	private static Transportation transportation = new Transportation(null, 0, 0, 0, 0);

	@Before
	public void setUp() throws Exception {
	}

	//@Test
	//public void testTransportation() {
	
		
	//}

	@Test
	public void testSetCompanyName() {
		transportation.setCompanyName("Company1");
		assertEquals(true, transportation.setCompanyName("Company1"));
	}

	@Test
	public void testSetCapacityWeight() {
		transportation.setCapacityWeight(9000);
		assertEquals(true, transportation.setCapacityWeight(9000));
	}

	//@Test
	//public void testSetCapacitySpace() {
		
	//}

	@Test
	public void setAvailability() {
		transportation.setAvailability(0);
		assertEquals(false, transportation.setAvailability(0));//!!!!
	}

	//@Test
	//public void testSetRange() {
		
	//}

	//@Test
	//public void testGetCompanyName() {
		
	//}

	//@Test
	//public void testGetAvailability() {
		
	//}

	//@Test
	//public void testGetRessource() {
		
	//}

	@Test
	public void testNumberOfRessources() {
		transportation.numberOfRessources();
		assertEquals(3, transportation.numberOfRessources());
	}

	@Test
	public void testHasRessources() {
		transportation.hasRessources();
		assertEquals(true, transportation.hasRessources());
	}

	@Test
	public void testGetCoordinator() {
		transportation.getCoordinator(1);
		assertEquals("Coordinator01", transportation.setAvailability(1));//!!!!
	}

	public static Transportation getTransportation() {
		return transportation;
	}

	public static void setTransportation(Transportation transportation) {
		TransportationTest.transportation = transportation;
	}

}
