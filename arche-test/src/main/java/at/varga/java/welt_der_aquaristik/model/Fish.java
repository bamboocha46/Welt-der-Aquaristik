package at.varga.java.welt_der_aquaristik.model;

/**
 * @author eszte
 * It is a class for fishes
 */
public class Fish extends WaterAnimal {
	
	private Cast cast;

	public Fish(long id, String breed, double size, double aqVolumen, float temperatur, float ph, int gH,
			Socialization socialization) {
		super(id, breed, size, aqVolumen, temperatur, ph, gH, socialization);
		// TODO Auto-generated constructor stub
	}

	public Cast getCast() {
		return cast;
	}

	public void setCast(Cast cast) {
		this.cast = cast;
	}
	
	

}
