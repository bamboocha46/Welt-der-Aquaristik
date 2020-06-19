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
public class FishType extends WaterAnimal implements Serializable {

	private static final long serialVersionUID = -7861091170212727608L;

	private Cast cast;
	private long id;

	public FishType(long id, String breed, double size, double minAqVolumen, double maxAqVolumen, float minTemperatur,
			float maxTemperatur, float minPh, float maxPh, int minGH, int maxGH, String pictureUrl,
			Socialization socialization, Cast cast) {
		super(id, breed, size, minAqVolumen, maxAqVolumen, minTemperatur, maxTemperatur, minPh, maxPh, minGH, maxGH,
				pictureUrl, socialization);
		this.cast = cast;
	}

	public FishType() {
	}

	public Cast getCast() {
		return cast;
	}

	public void setCast(Cast cast) {
		this.cast = cast;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	

}
