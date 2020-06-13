/**
 * 
 */
package at.varga.java.welt_der_aquaristik.model;

/**
 * @author eszte
 * This castes are the most popular aquarium-fish-castes. 
 * If User would like to add an other cast of animals, he can choice "Eigene_fisch" cast.
 */
public enum Cast {

	BARSCH(1), BÄRBLING(2), KALTWASSERFISCH(3), LABYRINTHFISH(4), LEBENDGEBÄRENDE(5), SALMLER(6), WELS(7),
	ANDERE_FISCH(8);

	private final int CAST_ID;

	private Cast(int CAST_ID) {
		this.CAST_ID = CAST_ID;
	}

	public int getCAST_ID() {
		return CAST_ID;
	}

}
