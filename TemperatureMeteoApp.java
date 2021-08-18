import java.util.Random;
import java.lang.Math;

public class TemperatureMeteoApp {

	public static void main(String[] args) {
		
		final int codeFinland = 246;
		final int codeChile = 152;
		final int codeCanada = 124;
		final int codeMoldova = 498;
		final int codeChina = 156;
		
		double tempFinland = OpenMeteoProvider.getCurrentTemperature(codeFinland);
		double tempChile = OpenMeteoProvider.getCurrentTemperature(codeChile);
		double tempCanada = PrivateMeteoProvider.getCurrentTemperature(codeCanada);
		int humidFinland = PrivateMeteoProvider.getCurrentHumidity(codeFinland);		
		int humidChile = PrivateMeteoProvider.getCurrentHumidity(codeChile);		
		int humidCanada = PrivateMeteoProvider.getCurrentHumidity(codeCanada);
		
		System.out.printf("Meteo in Finland: temperature %.1f C, humidity: %d %%\n", tempFinland, humidFinland);
		System.out.printf("Meteo in Chile: temperature %.1f C, humidity %d %%\n", tempChile, humidChile);
		System.out.printf("Meteo in Canada: temperature %.1f C, humidity %d %%\n", tempCanada, humidCanada);
	}

}

class OpenMeteoProvider {
	
	static double getCurrentTemperature (int countryCode ) {
		
		switch (countryCode) {
			case 498 : return generateRandomDouble();
			case 152 : return generateRandomDouble();
			case 156 : return generateRandomDouble();
			case 124 : return generateRandomDouble();
			case 246 : return generateRandomDouble();
			default : System.err.println("Can't provide data for this country!");
				      return 0;					   
		}
	}
	
	static double generateRandomDouble () {
		Random random = new Random ();
		return (double) Math.round((100*random.nextDouble()-50)*10)/10;
	}
	
	static int generateRandomInt () {
		Random random = new Random ();
		return random.nextInt(100);
	}
}

class PrivateMeteoProvider extends OpenMeteoProvider {
	
	static int getCurrentHumidity (int countryCode) {		
		
		switch (countryCode) {
			case 498 : return generateRandomInt();
			case 152 : return generateRandomInt();
			case 156 : return generateRandomInt();
			case 124 : return generateRandomInt();
			case 246 : return generateRandomInt();
			default : System.err.println("Can't provide data for this country!");
			          return 0;					   
		}
	}
}