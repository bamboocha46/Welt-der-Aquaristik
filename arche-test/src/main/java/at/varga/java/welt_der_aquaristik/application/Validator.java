/**
 * 
 */
package at.varga.java.welt_der_aquaristik.application;


/**
 * @author eszte
 * 
 */
public class Validator {
	
	

	public static boolean isNotNull(Object o) {
		if (!o.equals(null)) {
			return true;
		}

		return false;
	}

	//Temperatur for Aquariumfishes schould be between 4 and 35°C
	public static boolean isTemperaturCorrect(int i) {
		if (i >= 4 && i <= 35) {
			return true;
		}

		return false;
	}

	//General Hardness==GH for Aquariumfishes schould be between 0 and 30°C
	public static boolean isGHCorrect(double d) {
		if (d >= 0 && d <= 30) {
			return true;
		}

		return false;
	}
	//pH for Aquariumfishes schould be between 0 and 30°C
	public static boolean isPHCorrect(double d) {
		if (d >= 6.5 && d <= 8.2) {
			return true;
		}

		return false;
	}

}
