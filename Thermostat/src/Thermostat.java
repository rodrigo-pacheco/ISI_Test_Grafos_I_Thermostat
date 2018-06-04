
public class Thermostat{
	
	public enum Temp{
		High, Low;
	}
	
	public enum PartOfDay{
		Sleep, Wake;
	}
	
	public void up() {
		if (temperature == Temp.Low) {
			temperature = Temp.High;
		}
	}
	
	public void down() {
		if(temperature == Temp.High) {
			temperature = Temp.Low;
		}
	}
}