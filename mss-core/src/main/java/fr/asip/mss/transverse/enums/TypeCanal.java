/**
 * 
 */
package fr.asip.mss.transverse.enums;

/**
 * @author npaumier Type du canal d'authentification
 */
public enum TypeCanal {
	SMS("SMS"), Mail("Mail"), Push("Push");

	private final String typeCanal;

	/**
	 * @param typeCanal
	 */
	private TypeCanal(final String typeCanal) {
		this.typeCanal = typeCanal;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Enum#toString()
	 */
	@Override
	public String toString() {
		return typeCanal;
	}

	/**
	 * Indique si une valeur est contenue dans l'énumération.
	 * 
	 * @param test
	 *            valeur à tester
	 * @return boolean
	 */
	public static boolean contains(String test) {

		for (TypeCanal c : TypeCanal.values()) {
			if (c.typeCanal.equals(test)) {
				return true;
			}
		}
		return false;
	}

}
