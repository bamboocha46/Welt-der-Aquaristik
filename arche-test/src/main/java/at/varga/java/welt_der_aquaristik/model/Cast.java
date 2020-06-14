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

	BARSCH(1), BAERBLING(2), KALTWASSERFISCH(3), LABYRINTHFISCH(4), LEBENDGEBAERENDE(5), SALMLER(6), WELS(7),
	ANDERE_FISCH(8);

	private final int CAST_ID;

	private Cast(int CAST_ID) {
		this.CAST_ID = CAST_ID;
	}

	public int getCAST_ID() {
		return CAST_ID;
	}

	public String getCastName() {
		if (CAST_ID == 1) {
			return "Barsch";
		} else if (CAST_ID == 2) {
			return "Bärbling";
		} else if (CAST_ID == 3) {
			return "Kaltwasserfisch";
		} else if (CAST_ID == 4) {
			return "Labyrinthfisch";
		}  else if (CAST_ID == 5) {
			return "Lebendgebärende";
		}  else if (CAST_ID == 6) {
			return "Salmler";
		}  else if (CAST_ID == 7) {
			return "Wels";
		}  else if (CAST_ID == 8) {
			return "Anderer Fisch";
		}
		return null;

	}
//	
//	@Override
//	public String toString() {
//		return null;
//	}

}
