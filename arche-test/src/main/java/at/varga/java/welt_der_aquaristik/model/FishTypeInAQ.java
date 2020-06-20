
package at.varga.java.welt_der_aquaristik.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

@Entity
public class FishTypeInAQ implements Serializable {

	private static final long serialVersionUID = 3045331482720240783L;
	// private SimpleObjectProperty<FishType> fishType;
	
	private FishType fishType;

	private long id;

//	private double fishSummeSize;


	private AQ aq;

	//private String breed;

	private int quantity;
	
	public FishTypeInAQ() {

	}

//	public FishTypeInAQ(AQ aq, String breed, int quantity) {
//		super();
//		this.aq = aq;
//		this.breed = breed;
//		this.quantity = quantity;
//	}
	
	public FishTypeInAQ(AQ aq, int quantity) {
	super();
	this.aq = aq;
	this.quantity = quantity;
}
	
	

//	public FishTypeInAQ(String breed, AQ aq, int quantity) {
//		super();
//		this.breed = new SimpleStringProperty(breed);
//		this.aq = aq;
//		this.quantity = new SimpleIntegerProperty(quantity);
////		this.fishSummeSize = this.fishType.getSize()* quantity;
//
//	}

	
	public FishTypeInAQ(FishType fishType, long id, AQ aq, int quantity) {
		super();
		this.fishType = fishType;
		this.id = id;
		this.aq = aq;
		this.quantity = quantity;
	}

	@OneToOne
	@JoinColumn(name = "fk_FishType")
	public FishType getFishType() {
		return fishType;
	}

	public void setFishType(FishType fishType) {
		this.fishType = fishType;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	@ManyToOne
//	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_AQ")
	public AQ getAq() {
		return aq;
	}

	public void setAq(AQ aq) {
		this.aq = aq;
	}

//	public String getBreed() {
//		return breed;
//	}
//
//	public void setBreed(String breed) {
//		this.breed = breed;
//	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return this.fishType.toString();
	}
	
	

	
//	public SimpleStringProperty getBreed() {
//		return breed;
//	}
//
//	public void setBreed(SimpleStringProperty breed) {
//		this.breed = breed;
//	}
//
//	public SimpleIntegerProperty getQuantity() {
//		return quantity;
//	}
//
//	public void setQuantity(SimpleIntegerProperty quantity) {
//		this.quantity = quantity;
//	}

	

}

//package at.varga.java.welt_der_aquaristik.model;
//
//import java.io.Serializable;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToOne;
//
//import javafx.beans.property.SimpleIntegerProperty;
//import javafx.beans.property.SimpleLongProperty;
//import javafx.beans.property.SimpleStringProperty;
//@Entity
//public class FishTypeInAQ implements Serializable {
//
//	private static final long serialVersionUID = 3045331482720240783L;
//	//private SimpleObjectProperty<FishType> fishType;
//	@OneToOne
//	@JoinColumn(name = "fk_FishType")
//	private FishType fishType;
//	
//	private long id;
//	
////	private double fishSummeSize;
//	
//	@ManyToOne
////	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "fk_AQ")
//	private AQ aq;
//	
//	private SimpleStringProperty breed;
//	
//	private SimpleIntegerProperty quantity;
//	
//
//
//	public FishTypeInAQ(String breed, AQ aq, int quantity) {
//		super();
//		this.breed = new SimpleStringProperty(breed);
//		this.aq = aq;
//		this.quantity = new SimpleIntegerProperty(quantity);
////		this.fishSummeSize = this.fishType.getSize()* quantity;
//
//	}
//	public FishTypeInAQ() {
//		
//	}
//
//
//	public String getBreed() {
//
//		return breed.get();
//	}
//
////	public FishType getFish() {
////		if (this.fishType.getValue() instanceof FishType) {
////			return (FishType) fishType.get();
////		}
////		return null;
////	}
//
////	public void setFish(FishType fish) {
////		this.fish = fish;
////	}
//
////	public Long getAqID() {
////		return aqID.get();
////	}
//
////	public void setAqID(long aqID) {
////		this.aqID = aqID;
////	}
//
//	public Integer getQuantity() {
//		return quantity.get();
//	}
//
//	public AQ getAq() {
//		return aq;
//	}
//	@Id
//	@GeneratedValue
//	public long getId() {
//		return id;
//	}
//
//
//	public void setId(long id) {
//		this.id = id;
//	}
//
//
////	public double getFishSummeSize() {
////		return fishSummeSize;
////	}
//
//	
//
//}
