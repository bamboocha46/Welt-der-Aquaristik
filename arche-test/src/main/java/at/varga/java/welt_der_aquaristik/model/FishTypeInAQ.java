
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

	private FishType fishType;

	private long id;

	private AQ aq;

	private int quantity;

	public FishTypeInAQ() {

	}

	public FishTypeInAQ(AQ aq, int quantity) {
		super();
		this.aq = aq;
		this.quantity = quantity;
	}

	public FishTypeInAQ(FishType fishType, long id, AQ aq, int quantity) {
		super();
		this.fishType = fishType;
		this.id = id;
		this.aq = aq;
		this.quantity = quantity;
	}
	
	public FishTypeInAQ(FishType fishType, AQ aq, int quantity) {
		super();
		this.fishType = fishType;
		this.aq = aq;
		this.quantity = quantity;
	}

	@ManyToOne
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
	@JoinColumn(name = "fk_AQ")
	public AQ getAq() {
		return aq;
	}

	public void setAq(AQ aq) {
		this.aq = aq;
	}

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
}
