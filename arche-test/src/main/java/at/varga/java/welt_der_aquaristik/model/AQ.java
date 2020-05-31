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
	private double volumen;
	private int sizeWidth;
	private int sizeLength;
	private int sizeHeight;
	private double stockingDensity;
	private List<Fish> listOfFishes;

	public AQ(long aqId, int sizeWidth, int sizeLength, int sizeHeight, double stockingDensity,
			List<Fish> listOfFishes) {
		super();
		this.aqId = aqId;
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
		for (Fish f : listOfFishes) {
			summeFishSize = +f.getSize();
		}
		stockingDensity = summeFishSize / volumen;
		return stockingDensity;
	}


	public List<Fish> getListOfFishes() {
		return listOfFishes;
	}

	public void setListOfFishes(List<Fish> listOfFishes) {
		this.listOfFishes = listOfFishes;
	}

}
