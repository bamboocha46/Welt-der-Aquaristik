package at.varga.java.welt_der_aquaristik.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
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
	//private SimpleObjectProperty<FishType> fishType;
	@OneToOne
	@JoinColumn(name = "fk_FishType")
	private FishType fishType;
	private long id;
	@ManyToOne
//	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_AQ")
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

	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}
	

//	@Override
//	public String toString() {
//		return "FishTypeInAQ [fish=" + fish + ", aqID=" + aqID + ", quantity=" + quantity + "]";
//	}

}
