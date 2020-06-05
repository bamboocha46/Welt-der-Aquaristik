package at.varga.java.welt_der_aquaristik.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

public class FishTypeInAQ {

	//private SimpleObjectProperty<FishType> fishType;
	private FishType fishType;
	private SimpleLongProperty aqID;
	private SimpleStringProperty breed;
	private SimpleIntegerProperty quantity;


	public FishTypeInAQ(String breed, long aqID, int quantity) {
		super();
		this.breed = new SimpleStringProperty(breed);
		this.aqID = new SimpleLongProperty(aqID);
		this.quantity = new SimpleIntegerProperty(quantity);
	}


	public String getBreed() {

		return breed.get();
	}

//	public FishType getFish() {
//		if (this.fishType.getValue() instanceof FishType) {
//			return (FishType) fishType.get();
//		}
//		return null;
//	}

//	public void setFish(FishType fish) {
//		this.fish = fish;
//	}

	public Long getAqID() {
		return aqID.get();
	}

//	public void setAqID(long aqID) {
//		this.aqID = aqID;
//	}

	public Integer getQuantity() {
		return quantity.get();
	}

//	public void setQuantity(int quantity) {
//		this.quantity = quantity;
//	}

//	@Override
//	public String toString() {
//		return "FishTypeInAQ [fish=" + fish + ", aqID=" + aqID + ", quantity=" + quantity + "]";
//	}

}
