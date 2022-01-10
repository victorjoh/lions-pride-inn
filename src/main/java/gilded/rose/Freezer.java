package gilded.rose;

public class Freezer {

	public static double getTemperature() {
		throw new IllegalStateException("Failed to connect to temperature sensor");
	}
}
