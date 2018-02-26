package fr.asip.mss.transverse.enums;

/**
 * Enumérateur contenant les code d'erreur fonctionnelle.
 */
public enum CodeErreurFonctionnelle {

	/** Declaration des erreurs fonctionnelles. **/
	CF05("5", "Application invalide", 403), CF11("11", "L’utilisateur ne dispose pas  d’un compte lui permettant de déclarer un mobile", 403), CF12("12",
			"Le terminal mobile n'a pas pu être vérifié. " + "Echec de l'enrôlement, merci d'essayer à nouveau.", 403), CF13("13",
			"Le format du mot de passe n'est pas approprié.", 403), CF15("15", "Le canal d'authentification n'existe pas.", 403), CF16("16",
			"Le canal ne vous appartient pas.", 403), CF17("17", "Le mot de passe est invalide, merci de le revérifier.", 403), CF18("18",
			"Le mot de passe de ce canal n'est pas configurable.", 403), CF21("21", "Le code a expiré.", 400), CF23("23", "Le mail est non renseigné.", 400), CF24(
			"24", "L'adresse de messagerie est invalide.", 403), CF28("28", "Un des champs obligatoires n'est pas renseigné", 400), CF29("29",
			"Le canal push n'existe pas.", 403), CF30("30", "Un dossier de même niveau existe déjà avec le même nom", 403), CF31("31",
			"Le nom du dossier est incorrect", 403), CF32("32", "La taille des pièces jointes  est trop importante", 403), CF34("34",
			"L'utilisateur n'a pas d'adresse de messagerie", 403), CF36("36", "Un des champs a un format invalide", 403), CF38("38", "Code service invalide.",
			400), CF39("39", "Le contenu du message est trop volumineux", 403), CF41("41", "Le dossier n'existe pas", 403), CF41B("41",
			"Le dossier parent n'existe pas", 403), CF42("42", "L'adresse de messagerie est inconnue de Zimbra", 403), CF45("45", "Le message n'existe pas",
			403), CF46("46", "La pièce jointe n'existe pas.", 403), CF47("47", "Déplacement de dossier impossible", 403);

	/**
	 * Récupère une valeur de l'enum corrspondant a une String passée en
	 * paramètre
	 * 
	 * @param code
	 *            le code a trouver
	 * @return CodeErreurFonctionnelle
	 */
	public static final CodeErreurFonctionnelle getByCode(final String code) {
		if (code != null) {
			for (CodeErreurFonctionnelle b : CodeErreurFonctionnelle.values()) {
				if (code.equalsIgnoreCase(b.code)) {
					return b;
				}
			}
		}
		return null;
	}

	/** Le code associé à l'erreur. **/
	private String code;
	/** Le http status associé à l'erreur. **/
	private int httpStatus;

	/** Le libelle associé à l'erreur. **/
	private String libelle;

	/**
	 * Le constructeur.
	 * 
	 * @param aCode
	 *            le code de l'erreur fonctionnelle
	 * @param aLibelle
	 *            le libelle de l'erreur fonctionnelle
	 * @param aHttpStatus
	 *            le http status de l'erreur fonctionnelle
	 */
	private CodeErreurFonctionnelle(final String aCode, final String aLibelle, final int aHttpStatus) {
		this.code = aCode;
		this.libelle = aLibelle;
		this.httpStatus = aHttpStatus;
	}

	/**
	 * @return the code
	 */
	public final String getCode() {
		return code;
	}

	/**
	 * @return the httpStatus
	 */
	public final int getHttpStatus() {
		return httpStatus;
	}

	/**
	 * @return the libelle
	 */
	public final String getLibelle() {
		return libelle;
	}
}
