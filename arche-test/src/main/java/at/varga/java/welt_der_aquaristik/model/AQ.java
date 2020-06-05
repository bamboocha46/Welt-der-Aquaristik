/**
 * 
 */
package at.varga.java.welt_der_aquaristik.model;

import java.util.List;

/**
 * @author eszte It is a class for aquariums
 */
public class AQ {

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
	private List<FishTypeInAQ> listOfFishes;

	public AQ(long aqId, String titel, double volumen, int sizeWidth, int sizeLength, int sizeHeight, int temperatur,
			double gH, double ph, double stockingDensity, List<FishTypeInAQ> listOfFishes) {
		super();
		this.aqId = aqId;
		this.titel = titel;
		this.volumen = volumen;
		this.sizeWidth = sizeWidth;
		this.sizeLength = sizeLength;
		this.sizeHeight = sizeHeight;
		this.temperatur = temperatur;
		this.gH = gH;
		this.ph = ph;
		this.stockingDensity = stockingDensity;
		this.listOfFishes = listOfFishes;
	}

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

	public List<FishTypeInAQ> getListOfFishes() {
		return listOfFishes;
	}

	public void setListOfFishes(List<FishTypeInAQ> listOfFishes) {
		this.listOfFishes = listOfFishes;
	}

	@Override
	public String toString() {
		return "AQ [aqId=" + aqId + ", titel=" + titel + ", volumen=" + volumen + ", sizeWidth=" + sizeWidth
				+ ", sizeLength=" + sizeLength + ", sizeHeight=" + sizeHeight + ", temperatur=" + temperatur + ", gH="
				+ gH + ", ph=" + ph + ", stockingDensity=" + stockingDensity + ", listOfFishes=" + listOfFishes + "]";
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
