
public class Thermostat{
	
	public enum Temp{
		High, Low;
	}
	
	public enum PartOfDay{
		Sleep, Wake;
	}
	
	static Temp temperature = Temp.Low;
	static PartOfDay partofday = PartOfDay.Wake;
	
	public static void up() {
		if (temperature == Temp.Low) {
			temperature = Temp.High;
		}
	}
	
	public static void down() {
		if(temperature == Temp.High) {
			temperature = Temp.Low;
		}
	}
	
	public static void advance(){
		if(partofday == PartOfDay.Wake) {
			partofday = PartOfDay.Sleep;
		} else {
			partofday = PartOfDay.Wake;
		}
	}
}