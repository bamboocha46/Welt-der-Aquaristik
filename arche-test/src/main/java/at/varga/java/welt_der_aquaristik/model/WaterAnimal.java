package at.varga.java.welt_der_aquaristik.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import at.varga.java.welt_der_aquaristik.model.Socialization;

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

	private String pictureUrl;

	private Socialization socialization;

	public WaterAnimal() {

	}

	public WaterAnimal(long id, String breed, double size, double minAqVolumen, double maxAqVolumen,
			float minTemperatur, float maxTemperatur, float minPh, float maxPh, int minGH, int maxGH, String pictureUrl,
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
		this.pictureUrl = pictureUrl;
		this.socialization = socialization;
	}

	@Id
	@GeneratedValue
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

	public int getMaxGH() {
		return maxGH;
	}

	public void setMaxGH(int maxGH) {
		this.maxGH = maxGH;
	}

	public String getPictureUrl() {
		return pictureUrl;
	}

	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}

	public Socialization getSocialization() {
		return socialization;
	}

	public void setSocialization(Socialization socialization) {
		this.socialization = socialization;
	}

	@Override
	public String toString() {
		return breed;
	}

}