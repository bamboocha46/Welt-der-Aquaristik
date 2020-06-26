package at.varga.java.welt_der_aquaristik.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author eszte It is a class for fishes
 */
@Entity
@Table(name = "FishType")
public class FishType implements Serializable {

	private static final long serialVersionUID = -7861091170212727608L;

	private long id;

	private Cast cast;

	private String breed;

	private double size;

	private double minAqVolumen;

	private double maxAqVolumen;

	private int minTemperatur;

	private int maxTemperatur;

	private float minPh;

	private float maxPh;

	private int minGH;

	private int maxGH;

	private String pictureUrl;

	private Socialization socialization;

	public FishType(long id, String breed, double size, double minAqVolumen, double maxAqVolumen, int minTemperatur,
			int maxTemperatur, float minPh, float maxPh, int minGH, int maxGH, String pictureUrl,
			Socialization socialization, Cast cast) {
		super();
		this.id = id;
		this.cast = cast;
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

	public FishType() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Cast getCast() {
		return cast;
	}

	public void setCast(Cast cast) {
		this.cast = cast;
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

	public int getMinTemperatur() {
		return minTemperatur;
	}

	public void setMinTemperatur(int minTemperatur) {
		this.minTemperatur = minTemperatur;
	}

	public int getMaxTemperatur() {
		return maxTemperatur;
	}

	public void setMaxTemperatur(int maxTemperatur) {
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return breed;
	}

}
