/**
 * 
 */
package fr.asip.mss.transverse.enums;


/**
 * @author npaumier
 * 
 *         Système d'exploitation du terminal mobile
 */
public enum SystemExp {
	iOS("iOS"), Android("Android");

	private String os;

	/**
	 * Constructor.
	 * 
	 * @param os
	 *            os
	 */
	private SystemExp(String os) {
		this.os = os;
	}

	@Override
	public String toString() {
		return os;
	}

	/**
	 * Indique si une valeur est contenue dans l'énumération.
	 * 
	 * @param test
	 *            valeur à tester
	 * @return boolean
	 */
	public static boolean contains(String test) {

		for (SystemExp c : SystemExp.values()) {
			if (c.os.equals(test)) {
				return true;
			}
		}
		return false;
	}
}
