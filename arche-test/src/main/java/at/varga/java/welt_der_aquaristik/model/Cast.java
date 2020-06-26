/**
 * 
 */
package at.varga.java.welt_der_aquaristik.model;

/**
 * @author eszte This castes are the most popular aquarium-fish-castes. If User
 *         would like to add an other cast of animals, he can choice
 *         "Eigene_fisch" cast.
 */
public enum Cast {

	BARSCH(0), BAERBLING(1), KALTWASSERFISCH(2), LABYRINTHFISCH(3), LEBENDGEBAERENDE(4), SALMLER(5), WELS(6),
	ANDERE_FISCH(7);

	private final int CAST_ID;

	private Cast(int CAST_ID) {
		this.CAST_ID = CAST_ID;
	}

	public int getCAST_ID() {
		return CAST_ID;
	}

	public String getCastName() {
		if (CAST_ID == 0) {
			return "Barsch";
		} else if (CAST_ID == 1) {
			return "Bärbling";
		} else if (CAST_ID == 2) {
			return "Kaltwasserfisch";
		} else if (CAST_ID == 3) {
			return "Labyrinthfisch";
		} else if (CAST_ID == 4) {
			return "Lebendgebärende";
		} else if (CAST_ID == 5) {
			return "Salmler";
		} else if (CAST_ID == 6) {
			return "Wels";
		} else if (CAST_ID == 7) {
			return "Anderer Fisch";
		}
		return null;

	}

}
