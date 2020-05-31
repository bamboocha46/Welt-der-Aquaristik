package at.varga.java.welt_der_aquaristik.model;

/**
 * @author eszte
 * Abstractclass for Wateranimals
 */
public abstract class WaterAnimal {

	private long id;
	private String breed;
	private double size;
	private double aqVolumen;
	private float temperatur;
	private float ph;
	private int gH;
	private Socialization socialization;

	public WaterAnimal(long id, String breed, double size, double aqVolumen, float temperatur, float ph, int gH,
			Socialization socialization) {
		super();
		this.id = id;
		this.breed = breed;
		this.size = size;
		this.aqVolumen = aqVolumen;
		this.temperatur = temperatur;
		this.ph = ph;
		this.gH = gH;
		this.socialization = socialization;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		this.size = size;
	}

	public double getaqVolumen() {
		return aqVolumen;
	}

	public void setAqVolumen(double aqVolumen) {
		this.aqVolumen = aqVolumen;
	}

	public float getTemperatur() {
		return temperatur;
	}

	public void setTemperatur(float temperatur) {
		this.temperatur = temperatur;
	}

	public float getPh() {
		return ph;
	}

	public void setPh(float ph) {
		this.ph = ph;
	}

	public int getgH() {
		return gH;
	}

	public void setgH(int gH) {
		this.gH = gH;
	}

	public Socialization getSocialization() {
		return socialization;
	}

	public void setSocialization(Socialization socialization) {
		this.socialization = socialization;
	}

	@Override
	public String toString() {
		return "WaterAnimal [id=" + id + ", breed=" + breed + ", size=" + size + ", aqVolumen=" + aqVolumen + ", temperatur="
				+ temperatur + ", ph=" + ph + ", gH=" + gH + ", socialization=" + socialization + "]";
	}
}
