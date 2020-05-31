package at.varga.java.welt_der_aquaristik.model;

/**
 * @author eszte
 * An enum class for behavior of animals. 
 * AGGRESSIVE animals can attack other animals
 * GROUP animals need company
 * SEPARETE animals must be keep alone
 */
public enum Socialization {
	AGGRESSIVE(1), GROUP(2), SEPARETE(3);

	private final int SOCIALIZATION_ID;
	
	private Socialization(int socializationId) {
		this.SOCIALIZATION_ID = socializationId;
	}

	public int getSocializationId() {
		return SOCIALIZATION_ID;
	}
	
	
	
}
