/**
 * 
 */
package at.varga.java.welt_der_aquaristik.application;

/**
 * @author eszte
 * 
 */
public class Validator {
	
	public boolean isNotNull (Object o) {
		if (!o.equals(null)) {
			return true;
		}
		
		return false;
	}
	
//	public boolean isNotInteger (Object o) {
//		
//	}

}
