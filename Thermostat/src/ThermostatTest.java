import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class ThermostatTest {

	@Before
	public void setUp() {
		Thermostat.partofday = Thermostat.PartOfDay.Wake;
		Thermostat.temperature = Thermostat.Temp.Low;
	}
	
	// Wake-Low , Wake-High , Sleep-High , Seep-Low , Wake-Low 
	@Test
	public void testPrimeraVuelta() {
		assertTrue("Valores iniciales incorrectos",
				   	Thermostat.partofday   == Thermostat.PartOfDay.Wake &&
				   	Thermostat.temperature == Thermostat.Temp.Low);
		Thermostat.up();
		assertTrue("Falla el up",
					Thermostat.partofday   == Thermostat.PartOfDay.Wake &&
					Thermostat.temperature == Thermostat.Temp.High);
		Thermostat.advance();
		assertTrue("Falla el primer advance",
					Thermostat.partofday   == Thermostat.PartOfDay.Sleep &&
					Thermostat.temperature == Thermostat.Temp.High);
		Thermostat.down();
		assertTrue("Falla el down",
					Thermostat.partofday == Thermostat.PartOfDay.Sleep &&
					Thermostat.temperature   	 == Thermostat.Temp.Low);
		Thermostat.advance();
		assertTrue("Falla el segundo advance",
					Thermostat.partofday == Thermostat.PartOfDay.Wake &&
					Thermostat.temperature 	 == Thermostat.Temp.Low);
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
