/**
 * 
 */
package at.varga.java.welt_der_aquaristik.model;

import java.util.List;

/**
 * @author eszte
 * It is a class for aquariums
 */
public class AQ {

	private long aqId;
	private String titel;
	private double volumen;
	private int sizeWidth;
	private int sizeLength;
	private int sizeHeight;
	private double stockingDensity;
	private List<FishType> listOfFishes;

	public AQ(long aqId, String titel, int sizeWidth, int sizeLength, int sizeHeight, double stockingDensity,
			List<FishType> listOfFishes) {
		super();
		this.aqId = aqId;
		this.titel = titel;
		this.sizeWidth = sizeWidth;
		this.sizeLength = sizeLength;
		this.sizeHeight = sizeHeight;
		this.volumen = (this.sizeHeight * this.sizeLength * this.sizeWidth) / 1000;
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

	public double getStockingDensity() {
		double summeFishSize = 0;
		for (FishType f : listOfFishes) {
			summeFishSize = +f.getSize();
		}
		stockingDensity = summeFishSize / volumen;
		return stockingDensity;
	}


	public List<FishType> getListOfFishes() {
		return listOfFishes;
	}

	public void setListOfFishes(List<FishType> listOfFishes) {
		this.listOfFishes = listOfFishes;
	}

}
