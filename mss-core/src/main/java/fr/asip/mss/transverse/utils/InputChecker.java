package fr.asip.mss.transverse.utils;

import fr.asip.mss.exceptions.ErreurFonctionnelleException;
import fr.asip.mss.transverse.enums.CodeErreurFonctionnelle;

/**
 * Classe utilitaire fournissant des outils pour valider les entrées
 * utilisateur.
 * 
 */
public final class InputChecker {

	public static final int ADDRESS_EMAIL_LENGTH = 256;
	public static final int ADDRESS_TYPE_LENGTH = 5;
	public static final int ABS_PATH_LENGTH = 220;
	public static final int BODY_LENGTH = 50000;
	public static final int CONTENT_TYPE_LENGTH = 40;
	public static final int ID_NAT_LENGTH = 32;
	private static final String MAIL_REG_EXP = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?";
	public static final int OPERATION_LENGTH = 10;
	public static final int PRIORITY_LENGTH = 6;
	public static final int REPLY_TYPE_LENGTH = 9;
	public static final int SEARCH_STRING_ANNUAIRE_LENGTH = 30;
	public static final int SEARCH_STRING_LENGTH = 256;
	public static final int SUBJECT_LENGTH = 250;
	public static final int TIME_SEARCH_LENGTH = 19;
	public static final int TOKEN_LENGTH = 60;

	/**
	 * Vérifie que l'adresse email passée en paramètre correspond à l'expression
	 * régulière definie par la classe utilitaire.
	 * 
	 * @param inputParam
	 *            l'adresse email
	 * @throws ErreurFonctionnelleException
	 *             e
	 */
	public static void checkExpressionReguliere(final String inputParam)
			throws ErreurFonctionnelleException {
		if (inputParam != null && !inputParam.matches(MAIL_REG_EXP)) {
			throw new ErreurFonctionnelleException(
					CodeErreurFonctionnelle.CF36, new Exception(inputParam
							+ " ne correspond pas à l'expression regulière : "
							+ MAIL_REG_EXP));
		}
	}

	/**
	 * Vérifie la longueur d'un chaine de caractères par rapport à l'entier
	 * passé en paramètre.
	 * 
	 * @param inputParam
	 *            la chaine de caractères à vérifier
	 * @param length
	 *            la longueur
	 * @param code
	 *            le code
	 * @throws ErreurFonctionnelleException
	 *             e
	 */
	public static void checkLength(final String inputParam, final int length,
			final CodeErreurFonctionnelle code)
			throws ErreurFonctionnelleException {
		if (inputParam != null && inputParam.length() > length) {
			throw new ErreurFonctionnelleException(code, new Exception(
					inputParam + " est trop long (" + length
							+ " caractères max.)"));
		}
	}

	/**
	 * Verifie que la valeur de la string aOperation est conforme à une
	 * operation.
	 * 
	 * @param aOperation
	 *            une string représentant une opération à effectuer sur un
	 *            message
	 * @throws ErreurFonctionnelleException
	 *             e
	 */
	public static void checkOperation(final String aOperation)
			throws ErreurFonctionnelleException {
		if (aOperation != null) {
			if (!(aOperation.equals("DELETE") || aOperation.equals("TRASH")
					|| aOperation.equals("READ") || aOperation.equals("UNREAD")
					|| aOperation.equals("SPAM")
					|| aOperation.equals("FLAGGED")
					|| aOperation.equals("UNFLAGGED") || aOperation
						.equals("UNSPAM"))) {
				throw new ErreurFonctionnelleException(
						CodeErreurFonctionnelle.CF36, new Exception(
								"L'opération renseignée est invalide."));
			}
		}

	}

	/**
	 * Vérifie la validé, pour une priorité, de la chaine de caractères passée
	 * en paramètre.
	 * 
	 * @param aPriority
	 *            la priorité à vérifier
	 * @throws ErreurFonctionnelleException
	 *             e
	 */
	public static void checkPriorityValue(final String aPriority)
			throws ErreurFonctionnelleException {
		if (aPriority != null) {
			if (!(aPriority.equals("NORMAL") || aPriority.equals("HAUTE"))) {
				throw new ErreurFonctionnelleException(
						CodeErreurFonctionnelle.CF36, new Exception(
								"La priorité renseignée est invalide."));
			}
		}

	}

	/**
	 * @param aReplyType
	 *            aReplyType
	 * @throws ErreurFonctionnelleException
	 *             e
	 */
	public static void checkReplyTypeValue(final String aReplyType)
			throws ErreurFonctionnelleException {
		if (aReplyType != null) {
			if (!(aReplyType.equals("REPLIED") || aReplyType
					.equals("FORWARDED"))) {
				throw new ErreurFonctionnelleException(
						CodeErreurFonctionnelle.CF36, new Exception(
								"Le replyType renseigné est invalide."));
			}
		}

	}

	/**
	 * @param aToken
	 *            aToken
	 * @return the token or 0 if synchro
	 * @throws ErreurFonctionnelleException
	 *             e
	 */
	public static String checkSyncToken(final String aToken)
			throws ErreurFonctionnelleException {
		if (aToken == null || aToken.equals("")) {
			return "0";
		}
		InputChecker.checkLength(aToken, InputChecker.TOKEN_LENGTH,
				CodeErreurFonctionnelle.CF36);
		String aTokenPositive = aToken.replace("-", "");
		if (!org.apache.commons.lang3.StringUtils.isNumeric(aTokenPositive)) {
			throw new ErreurFonctionnelleException(
					CodeErreurFonctionnelle.CF36, null);
		}
		int intToken = Integer.parseInt(aToken);

		if (intToken <= 0) {
			return "0";
		}
		return aToken;

	}

	/**
	 * Constructeur.
	 */
	private InputChecker() {
	}
}
