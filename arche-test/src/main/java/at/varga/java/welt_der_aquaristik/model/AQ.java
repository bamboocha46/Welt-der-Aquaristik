/**
 * 
 */
package at.varga.java.welt_der_aquaristik.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author eszte It is a class for aquariums
 */
@Entity
@Table(name = "AQs")
public class AQ implements Serializable {

	private static final long serialVersionUID = 6680534280756930387L;
	private long aqId;

	private String titel;

	private double volumen;

	private int sizeWidth;

	private int sizeLength;

	private int sizeHeight;

	private int temperatur;

	private double gH;

	private double ph;

	private double stockingDensity;

	private List<FishTypeInAQ> fishesInAQList;

	public AQ() {
	}

	public AQ(long aqId, String titel, int sizeWidth, int sizeLength, int sizeHeight, int temperatur, double gH,
			double ph, List<FishTypeInAQ> listOfFishes) {
		super();
		this.aqId = aqId;
		this.titel = titel;
		this.volumen = sizeWidth * sizeLength * sizeHeight / 1000;
		this.sizeWidth = sizeWidth;
		this.sizeLength = sizeLength;
		this.sizeHeight = sizeHeight;
		this.temperatur = temperatur;
		this.gH = gH;
		this.ph = ph;
		this.fishesInAQList = listOfFishes;
	}

	public AQ(long aqId, String titel, int sizeWidth, int sizeLength, int sizeHeight, int temperatur, double gH,
			double ph) {

	}

	public AQ(int sizeWidth, int sizeLength, int sizeHeight) {
		this.volumen = sizeWidth * sizeLength * sizeHeight / 1000;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getAqId() {
		return aqId;
	}

	public void setAqId(long aqId) {
		this.aqId = aqId;
	}

	public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	public double getVolumen() {
		return volumen;
	}

	public void setAQVolumen(int sizeWidth, int sizeLength, int sizeHeight) {
		this.volumen = sizeWidth * sizeLength * sizeHeight / 1000;
	}

	public void setVolumen(double volumen) {
		this.volumen = volumen;
	}

	public int getSizeWidth() {
		return sizeWidth;
	}

	public void setSizeWidth(int sizeWidth) {
		this.sizeWidth = sizeWidth;
	}

	public int getSizeLength() {
		return sizeLength;
	}

	public void setSizeLength(int sizeLength) {
		this.sizeLength = sizeLength;
	}

	public int getSizeHeight() {
		return sizeHeight;
	}

	public void setSizeHeight(int sizeHeight) {
		this.sizeHeight = sizeHeight;
	}

	public int getTemperatur() {
		return temperatur;
	}

	public void setTemperatur(int temperatur) {
		this.temperatur = temperatur;
	}

	public double getgH() {
		return gH;
	}

	public void setgH(double gH) {
		this.gH = gH;
	}

	public double getPh() {
		return ph;
	}

	public void setPh(double ph) {
		this.ph = ph;
	}

	public double getStockingDensity() {
		if (fishesInAQList != null) {
			stockingDensity = 0;
			for (FishTypeInAQ f : fishesInAQList) {
				stockingDensity += (f.getQuantity() * f.getFishType().getSize()) / volumen;
			}
			return stockingDensity;
		} else
			return 0;
	}

	public void setStockingDensity(double stockingDensity) {
		this.stockingDensity = stockingDensity;
	}

	@OneToMany(mappedBy = "aq", orphanRemoval = true, fetch = FetchType.EAGER)
	public List<FishTypeInAQ> getListOfFishes() {
		return fishesInAQList;
	}

	public void setListOfFishes(List<FishTypeInAQ> listOfFishes) {
		this.fishesInAQList = listOfFishes;
	}

	@Override
	public String toString() {
		return titel;
	}
}