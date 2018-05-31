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
					t.getTemp   == t.Temp.High);
		t.advance();
		assertTrue("Falla el primer advance",
					t.PartOfDay == t.PartOfDay.Sleep &&
					t.getTemp   == t.Temp.High);
		t.down();
		assertTrue("Falla el down",
					t.PartOfDay == t.PartOfDay.Sleep &&
					t.getTemp   == t.Temp.Low);
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
					t.getPartOfDay() == PartOfDay.Sleep &&
					t.getTemp() == Temp.High);
		
		t.up();
		assertTrue("Falla el up",
					t.getPartOfDay() == PartOfDay.Wake &&
					t.getTemp() == Temp.High);
		
		t.advance();
		assertTrue("Falla el segundo advance",
					t.getPartOfDay() == PartOfDay.Wake && 
					t.getTemp() == Temp.Low);
		
		t.down();
		assertTrue("Falla el down",
					t.getPartOfDay() == PartOfDay.Sleep &&
					t.getTemp() == Temp.Low);
	}

}
