package at.varga.java.welt_der_aquaristik.model;

/**
 * @author eszte It is a class for fishes
 */
public class FishType extends WaterAnimal {

	private Cast cast;
	
	

public FishType(long id, String breed, double size, double minAqVolumen, double maxAqVolumen, float minTemperatur,
			float maxTemperatur, float minPh, float maxPh, int minGH, int maxGH, String pictureUrl,
			Socialization socialization, Cast cast) {
		super(id, breed, size, minAqVolumen, maxAqVolumen, minTemperatur, maxTemperatur, minPh, maxPh, minGH, maxGH,
				pictureUrl, socialization);
		this.cast = cast;
	}


//	public FishType(long id, String breed, double size, double aqVolumen, float temperatur, float ph, int gH,
//			Socialization socialization) {
//		super(id, breed, size, aqVolumen, temperatur, ph, gH, socialization);
//		// TODO Auto-generated constructor stub
//	}

	public Cast getCast() {
		return cast;
	}

	public void setCast(Cast cast) {
		this.cast = cast;
	}

}
