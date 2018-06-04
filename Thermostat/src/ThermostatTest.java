import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class ThermostatTest {

	@Before
	public void setUp() {
		t.partOfDay = t.PartOfDay.Wake;
		t.temperatura = t.Temp.Low;
	}
	
	// Wake-Low , Wake-High , Sleep-High , Seep-Low , Wake-Low 
	@Test
	public void testPrimeraVuelta() {
		assertTrue("Valores iniciales incorrectos",
				   t.PartOfDay == t.PartOfDay.Wake &&
				   t.Temp 	   == t.Temp.Low);
		t.up();
		assertTrue("Falla el up",
					t.PartOfDay == t.PartOfDay.Wake &&
					t.Temp		== t.Temp.High);
		t.advance();
		assertTrue("Falla el primer advance",
					t.PartOfDay == t.PartOfDay.Sleep &&
					t.Temp   	== t.Temp.High);
		t.down();
		assertTrue("Falla el down",
					t.PartOfDay == t.PartOfDay.Sleep &&
					t.Temp   	== t.Temp.Low);
		t.advance();
		assertTrue("Falla el segundo advance",
					t.PartOfDay == t.PartOfDay.Wake &&
					t.Temp 	   == t.Temp.Low);
	}
	
	// Wake-Low , Seep-Low , Sleep-High , Wake-High , Wake-Low 
	@Test
	public void testSegundaVuelta() {
		assertTrue("Valores iniciales incorrectos",
				   t.PartOfDay == t.PartOfDay.Wake &&
				   t.Temp 	   == t.Temp.Low);
		
		t.advance();
		assertTrue("Falla el primer advance",
					t.PartOfDay == PartOfDay.Sleep &&
					t.Temp 		== Temp.Low);
		
		t.up();
		assertTrue("Falla el up",
					t.PartOfDay == PartOfDay.Sleep &&
					t.Temp 		== Temp.High);
		
		t.advance();
		assertTrue("Falla el segundo advance",
					t.PartOfDay == PartOfDay.Wake && 
					t.Temp 		== Temp.High);
		
		t.down();
		assertTrue("Falla el down",
					t.PartOfDay == PartOfDay.Wake &&
					t.Temp 		== Temp.Low);
	}

}
