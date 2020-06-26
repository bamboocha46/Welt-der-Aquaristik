package at.varga.java.welt_der_aquaristik.model;

/**
 * @author eszte An enum class for behavior of animals. AGGRESSIVE animals can
 *         attack other animals GROUP animals need company SEPARETE animals must
 *         be keep alone
 */
public enum Socialization {
	AGRESSIV("Agressiv"), GRUPPENFISH("Gruppenfisch"), EINZELHALTUNG("Einzelhaltung");

	private final String name;

	Socialization(String s) {
		this.name = s;
	}

	public String getName() {
		return name;
	}

}
