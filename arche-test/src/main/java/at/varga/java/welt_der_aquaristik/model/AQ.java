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
//	@OneToMany(mappedBy = "AQ", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	@OneToMany(mappedBy = "AQ", orphanRemoval = true)
	private List<FishTypeInAQ> fishesInAQList;

	public AQ(long aqId, String titel, int sizeWidth, int sizeLength, int sizeHeight, int temperatur,
			double gH, double ph,  List<FishTypeInAQ> listOfFishes) {
		super();
		this.aqId = aqId;
		this.titel = titel;
		this.volumen = sizeWidth*sizeLength*sizeHeight/1000;
		this.sizeWidth = sizeWidth;
		this.sizeLength = sizeLength;
		this.sizeHeight = sizeHeight;
		this.temperatur = temperatur;
		this.gH = gH;
		this.ph = ph;
//		this.stockingDensity = stockingDensity; 
//		for (FishTypeInAQ f: listOfFishes) {
//			
//		}
		this.fishesInAQList = listOfFishes;
	}

	@Id
	@GeneratedValue
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
		return stockingDensity;
	}

	public List<FishTypeInAQ> getListOfFishes() {
		return fishesInAQList;
	}

	public void setListOfFishes(List<FishTypeInAQ> listOfFishes) {
		this.fishesInAQList = listOfFishes;
	}

	@Override
	public String toString() {
		return "AQ [aqId=" + aqId + ", titel=" + titel + ", volumen=" + volumen + ", sizeWidth=" + sizeWidth
				+ ", sizeLength=" + sizeLength + ", sizeHeight=" + sizeHeight + ", temperatur=" + temperatur + ", gH="
				+ gH + ", ph=" + ph + ", stockingDensity=" + stockingDensity + ", listOfFishes=" + fishesInAQList + "]";
	}

//	public double getStockingDensity() {
//		double summeFishSize = 0;
//		for (FishType f : listOfFishes) {
//			summeFishSize = +f.getSize();
//		}
//		stockingDensity = summeFishSize / volumen;
//		return stockingDensity;
//	}

}
