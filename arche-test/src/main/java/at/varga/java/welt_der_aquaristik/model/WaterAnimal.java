package at.varga.java.welt_der_aquaristik.model;

/**
 * @author eszte Abstractclass for Wateranimals
 */
public abstract class WaterAnimal {

	private long id;
	private String breed;
	private double size;
	private double minAqVolumen;
	private double maxAqVolumen;
	private float minTemperatur;
	private float maxTemperatur;
	private float minPh;
	private float maxPh;
	private int minGH;
	private int maxGH;
	private static String picture;
	private Socialization socialization;
	// private final String PICTURE_URL;

	public WaterAnimal(long id, String breed, double size, double minAqVolumen, double maxAqVolumen,
			float minTemperatur, float maxTemperatur, float minPh, float maxPh, int minGH, int maxGH,
			Socialization socialization) {
		super();
		this.id = id;
		this.breed = breed;
		this.size = size;
		this.minAqVolumen = minAqVolumen;
		this.maxAqVolumen = maxAqVolumen;
		this.minTemperatur = minTemperatur;
		this.maxTemperatur = maxTemperatur;
		this.minPh = minPh;
		this.maxPh = maxPh;
		this.minGH = minGH;
		this.maxGH = maxGH;
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

	public double getMinAqVolumen() {
		return minAqVolumen;
	}

	public void setMinAqVolumen(double minAqVolumen) {
		this.minAqVolumen = minAqVolumen;
	}

	public double getMaxAqVolumen() {
		return maxAqVolumen;
	}

	public void setMaxAqVolumen(double maxAqVolumen) {
		this.maxAqVolumen = maxAqVolumen;
	}

	public float getMinTemperatur() {
		return minTemperatur;
	}

	public void setMinTemperatur(float minTemperatur) {
		this.minTemperatur = minTemperatur;
	}

	public float getMaxTemperatur() {
		return maxTemperatur;
	}

	public void setMaxTemperatur(float maxTemperatur) {
		this.maxTemperatur = maxTemperatur;
	}

	public float getMinPh() {
		return minPh;
	}

	public void setMinPh(float minPh) {
		this.minPh = minPh;
	}

	public float getMaxPh() {
		return maxPh;
	}

	public void setMaxPh(float maxPh) {
		this.maxPh = maxPh;
	}

	public int getMinGH() {
		return minGH;
	}

	public void setMinGH(int minGH) {
		this.minGH = minGH;
	}

	public int getNaxGH() {
		return maxGH;
	}

	public void setNaxGH(int naxGH) {
		this.maxGH = naxGH;
	}

	public static String getPicture() {
		return picture;
	}

	public static void setPicture(String picture) {
		WaterAnimal.picture = picture;
	}

	public Socialization getSocialization() {
		return socialization;
	}

	public void setSocialization(Socialization socialization) {
		this.socialization = socialization;
	}

	@Override
	public String toString() {
		return "WaterAnimal [id=" + id + ", breed=" + breed + ", size=" + size + ", minAqVolumen=" + minAqVolumen
				+ ", maxAqVolumen=" + maxAqVolumen + ", minTemperatur=" + minTemperatur + ", maxTemperatur="
				+ maxTemperatur + ", minPh=" + minPh + ", maxPh=" + maxPh + ", minGH=" + minGH + ", maxGH=" + maxGH
				+ ", socialization=" + socialization + "]";
	}
	
	

//	public WaterAnimal(long id, String breed, double size, double aqVolumen, float temperatur, float ph, int gH,
//			Socialization socialization) {
//		super();
//		this.id = id;
//		this.breed = breed;
//		this.size = size;
//		this.minAqVolumen = aqVolumen;
//		this.minTemperatur = temperatur;
//		this.minPh = ph;
//		this.minGH = gH;
//		this.socialization = socialization;
//	}
//
//	public long getId() {
//		return id;
//	}
//
//	public void setId(long id) {
//		this.id = id;
//	}
//
//	public String getBreed() {
//		return breed;
//	}
//
//	public void setBreed(String breed) {
//		this.breed = breed;
//	}
//
//	public double getSize() {
//		return size;
//	}
//
//	public void setSize(double size) {
//		this.size = size;
//	}
//
//	public double getaqVolumen() {
//		return minAqVolumen;
//	}
//
//	public void setAqVolumen(double aqVolumen) {
//		this.minAqVolumen = aqVolumen;
//	}
//
//	public float getTemperatur() {
//		return minTemperatur;
//	}
//
//	public void setTemperatur(float temperatur) {
//		this.minTemperatur = temperatur;
//	}
//
//	public float getPh() {
//		return minPh;
//	}
//
//	public void setPh(float ph) {
//		this.minPh = ph;
//	}
//
//	public int getgH() {
//		return minGH;
//	}
//
//	public void setgH(int gH) {
//		this.minGH = gH;
//	}
//
//	public Socialization getSocialization() {
//		return socialization;
//	}
//
//	public void setSocialization(Socialization socialization) {
//		this.socialization = socialization;
//	}
//
//	@Override
//	public String toString() {
//		return "WaterAnimal [id=" + id + ", breed=" + breed + ", size=" + size + ", aqVolumen=" + minAqVolumen + ", temperatur="
//				+ minTemperatur + ", ph=" + minPh + ", gH=" + minGH + ", socialization=" + socialization + "]";
//	}
}
