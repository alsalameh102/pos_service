package fr.asip.mss.transverse.utils;

import fr.asip.mss.dao.Canal;
import fr.asip.mss.exceptions.ErreurFonctionnelleException;
import fr.asip.mss.exceptions.ErreurTechniqueException;
import fr.asip.mss.transverse.enums.CodeErreurFonctionnelle;
import fr.asip.mss.transverse.enums.CodeErreurTechnique;
import fr.asip.mss.transverse.enums.SystemExp;
import fr.asip.mss.transverse.enums.TypeCanal;
import org.slf4j.Logger;
import org.slf4j.MDC;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//import org.slf4j.MDC;

/**
 * Classe utilitaire de logs.
 */
public final class LogsUtils {

	/**
	 * Log type événement entrée.
	 */
	private static final String LOG_EVENT_TYPE_IN = "CIN";
	/**
	 * Log type événement sortie.
	 */
	private static final String LOG_EVENT_TYPE_OUT = "COUT";
	/**
	 * Log status KO.
	 */
	private static final String LOG_STATUS_KO = "KO";
	/**
	 * Log status OK.
	 */
	private static final String LOG_STATUS_OK = "OK";

	/**
	 * Construit la chaine da caractère a écrire dans les logs. Pour une erreur
	 * fonctionnelle
	 * 
	 * @param idNat
	 *            id de l'utilisateur
	 * @param canal
	 *            les infos à afficher du canal qui n'a pas pu être enrôlé
	 * @param codeError
	 *            l'erreur technique qui est survenue
	 * @param req
	 *            la requête http en cause de l'erreur
	 * @return StringBuilder
	 */
	private static StringBuilder buildLogString(final String idNat,
			final Canal canal, final CodeErreurFonctionnelle codeError,
			final HttpServletRequest req) {
		StringBuilder strBuilder = new StringBuilder();
		// On n'utilise pas de if != null else car getRemoteAddr() appel get()
		// qui renvoi un NPE qui ne peut pas être déterminé a l'avance.
		try {
			strBuilder.append(req.getRemoteAddr());
		} catch (NullPointerException e) {
			strBuilder.append("remoteAddrNull");
		}
		strBuilder.append(" idNat=");
		if (idNat != null) {
			Pattern p = Pattern.compile("^[a-zA-Z0-9_]*$");
			Matcher m = p.matcher(idNat);
			if (m.matches()) {
				strBuilder.append(idNat);
			} else {
				strBuilder.append("format incorrect : n'est pas un entier");
			}
		} else {
			strBuilder.append("idNatNull");
		}
		strBuilder.append(" Enrolement KO");
		strBuilder.append(" canal=");
		if (canal != null && canal.getCanalType() != null) {
			if (SystemExp.contains(canal.getCanalType())) {
				strBuilder.append(canal.getCanalType());
			} else {
				strBuilder.append("type canal inconnu");
			}
		} else {
			strBuilder.append("canalTypeNull");
		}
		strBuilder.append(".");
		if (canal != null && canal.getOs() != null) {
			if (SystemExp.contains(canal.getOs())) {
				strBuilder.append(canal.getOs());
			} else {
				strBuilder.append("os inconnu");
			}
		} else {
			strBuilder.append("osNull");
		}
		strBuilder.append(" Err=");
		if (codeError != null && codeError.getCode() != null) {
			strBuilder.append(codeError.getCode());
		} else {
			strBuilder.append("codeErrNull");
		}
		strBuilder.append(" - ");
		if (codeError != null && codeError.getLibelle() != null) {
			strBuilder.append(codeError.getLibelle());
		} else {
			strBuilder.append("libelleNull");
		}

		return strBuilder;
	}

	/**
	 * Construit la chaine da caractère a écrire dans les logs. Pour une erreur
	 * technique
	 * 
	 * @param idNat
	 *            id de l'utilisateur
	 * @param canal
	 *            les infos à afficher du canal qui n'a pas pu être enrôlé
	 * @param codeError
	 *            l'erreur technique qui est survenue
	 * @param req
	 *            la requête http en cause de l'erreur
	 * @return StringBuilder
	 */
	private static StringBuilder buildLogString(final String idNat,
			final Canal canal, final CodeErreurTechnique codeError,
			final HttpServletRequest req) {
		StringBuilder strBuilder = new StringBuilder();
		// On n'utilise pas de if != null else car getRemoteAddr() appel get()
		// qui renvoi un NPE qui ne peut pas être déterminé a l'avance.
		try {
			strBuilder.append(req.getRemoteAddr());
		} catch (NullPointerException e) {
			strBuilder.append("remoteAddrNull");
		}
		strBuilder.append(" idNat=");
		if (idNat != null) {
			Pattern p = Pattern.compile("^[a-zA-Z0-9_]*$");
			Matcher m = p.matcher(idNat);
			if (m.matches()) {
				strBuilder.append(idNat);
			} else {
				strBuilder.append("format incorrect : n'est pas un entier");
			}
		} else {
			strBuilder.append("idNatNull");
		}
		strBuilder.append(" Enrolement KO");
		strBuilder.append(" canal=");
		if (canal != null && canal.getCanalType() != null) {
			if (TypeCanal.contains(canal.getCanalType())) {
				strBuilder.append(canal.getCanalType());
			} else {
				strBuilder.append("type canal inconnu");
			}
		} else {
			strBuilder.append("canalTypeNull");
		}
		strBuilder.append(".");
		if (canal != null && canal.getOs() != null) {
			if (SystemExp.contains(canal.getOs())) {
				strBuilder.append(canal.getOs());
			} else {
				strBuilder.append("os inconnu");
			}
		} else {
			strBuilder.append("osNull");
		}
		strBuilder.append(" Err=");
		if (codeError != null && codeError.getCode() != null) {
			strBuilder.append(codeError.getCode());
		} else {
			strBuilder.append("codeErrNull");
		}
		strBuilder.append(" - ");
		if (codeError != null && codeError.getLibelle() != null) {
			strBuilder.append(codeError.getLibelle());
		} else {
			strBuilder.append("libelleNull");
		}

		return strBuilder;
	}

	/**
	 * Construit la chaine da caractère a écrire dans les logs. Pour une erreur
	 * fonctionnelle
	 * 
	 * @param idNat
	 *            id de l'utilisateur
	 * @param codeError
	 *            l'erreur fonctionnelle qui est survenue
	 * @param req
	 *            la requête http en cause de l'erreur
	 * @param method
	 *            la méthode appelée
	 * @return StringBuilder
	 */
	private static StringBuilder buildLogString(final String idNat,
			final CodeErreurFonctionnelle codeError,
			final HttpServletRequest req, final String method) {
		StringBuilder strBuilder = new StringBuilder();
		// On n'utilise pas de if != null else car getRemoteAddr() appel get()
		// qui renvoi un NPE qui ne peut pas être déterminé a l'avance.
		try {
			strBuilder.append(req.getRemoteAddr());
		} catch (NullPointerException e) {
			strBuilder.append("remoteAddrNull");
		}
		strBuilder.append(" idNat=");
		if (idNat != null) {
			Pattern p = Pattern.compile("^[a-zA-Z0-9_]*$");
			Matcher m = p.matcher(idNat);
			if (m.matches()) {
				strBuilder.append(idNat);
			} else {
				strBuilder.append("format incorrect : n'est pas un entier");
			}
		} else {
			strBuilder.append("idNatNull");
		}
		strBuilder.append(" Appel KO");
		strBuilder.append(" Err=");
		if (codeError != null && codeError.getCode() != null) {
			strBuilder.append(codeError.getCode());
		} else {
			strBuilder.append("codeErrNull");
		}
		strBuilder.append(" - ");
		if (codeError != null && codeError.getLibelle() != null) {
			strBuilder.append(codeError.getLibelle());
		} else {
			strBuilder.append("libelleNull");
		}
		strBuilder.append(" Method=");
		if (method != null) {
			strBuilder.append(method);
		} else {
			strBuilder.append("methodNull");
		}

		return strBuilder;
	}

	/**
	 * Construit la chaine da caractère a écrire dans les logs. Pour une erreur
	 * fonctionnelle
	 * 
	 * @param idNat
	 *            id de l'utilisateur
	 * @param codeError
	 *            l'erreur technique qui est survenue
	 * @param req
	 *            la requête http en cause de l'erreur
	 * @param method
	 *            la méthode appelée
	 * @return StringBuilder
	 */
	private static StringBuilder buildLogString(final String idNat,
			final CodeErreurTechnique codeError, final HttpServletRequest req,
			final String method) {
		StringBuilder strBuilder = new StringBuilder();
		// On n'utilise pas de if != null else car getRemoteAddr() appel get()
		// qui renvoi un NPE qui ne peut pas être déterminé a l'avance.
		try {
			strBuilder.append(req.getRemoteAddr());
		} catch (NullPointerException e) {
			strBuilder.append("remoteAddrNull");
		}
		strBuilder.append(" idNat=");
		if (idNat != null) {
			Pattern p = Pattern.compile("^[a-zA-Z0-9_]*$");
			Matcher m = p.matcher(idNat);
			if (m.matches()) {
				strBuilder.append(idNat);
			} else {
				strBuilder.append("format incorrect : n'est pas un entier");
			}
		} else {
			strBuilder.append("idNatNull");
		}
		strBuilder.append(" Appel KO");
		strBuilder.append(" Err=");
		if (codeError != null && codeError.getCode() != null) {
			strBuilder.append(codeError.getCode());
		} else {
			strBuilder.append("codeErrNull");
		}
		strBuilder.append(" - ");
		if (codeError != null && codeError.getLibelle() != null) {
			strBuilder.append(codeError.getLibelle());
		} else {
			strBuilder.append("libelleNull");
		}
		strBuilder.append(" Method=");
		if (method != null) {
			strBuilder.append(method);
		} else {
			strBuilder.append("methodNull");
		}

		return strBuilder;
	}

	/**
	 * getStatusKo.
	 * 
	 * @return LOG_STATUS_KO
	 */
	public static String getStatusKo() {
		return LOG_STATUS_KO;
	}

	/**
	 * getStatusOk.
	 * 
	 * @return LOG_STATUS_OK
	 */
	public static String getStatusOk() {
		return LOG_STATUS_OK;
	}

	/**
	 * getTypeIn.
	 * 
	 * @return LOG_EVENT_TYPE_IN
	 */
	public static String getTypeIn() {
		return LOG_EVENT_TYPE_IN;
	}

	/**
	 * getTypeOut.
	 * 
	 * @return LOG_EVENT_TYPE_OUT
	 */
	public static String getTypeOut() {
		return LOG_EVENT_TYPE_OUT;
	}

	/**
	 * Méthode de log applicatif pour les enrôlements de terminaux mobile
	 * échoués a cause d'une erreur fonctionnelle. Peut logger en ERROR ou WARN
	 * 
	 * @param idNat
	 *            id de l'utilisateur
	 * @param canal
	 *            les infos à afficher du canal qui n'a pas pu être enrôlé
	 * @param codeError
	 *            l'erreur qui est survenue
	 * @param req
	 *            la requête http en cause de l'erreur
	 * @param logger
	 *            le logger a utiliser
	 * @param logType
	 *            le type de log a utiliser (ERROR/WARN)
	 * @param e
	 *            l'eexception a l'origine de l'erreur (optionnel)
	 * @return une ErreurFonctionnelleException correspondant à l'erreur
	 *         survenue
	 */
	public static ErreurFonctionnelleException logFailEnrol(final String idNat,
			final Canal canal, final CodeErreurFonctionnelle codeError,
			final HttpServletRequest req, final Logger logger,
			final String logType, final Exception e)
			throws ErreurFonctionnelleException {
		StringBuilder strBuilder = buildLogString(idNat, canal, codeError, req);

		if ("error".equalsIgnoreCase(logType)) {
			if (e != null) {
				logger.error(e.getMessage(), e);
			}
			logger.error(strBuilder.toString());
		}
		if ("warn".equalsIgnoreCase(logType)) {
			if (e != null) {
				logger.warn(e.getMessage(), e);
			}
			logger.warn(strBuilder.toString());
		}
		return new ErreurFonctionnelleException(codeError, e);
	}

	/**
	 * Méthode de log applicatif pour les appels MSSanté échoués a cause d'une
	 * erreur fonctionnelle.
	 * 
	 * @param idNat
	 *            id de l'utilisateur
	 * @param codeError
	 *            l'erreur qui est survenue
	 * @param req
	 *            la requête http en cause de l'erreur
	 * @param logger
	 *            le logger a utiliser
	 * @param method
	 *            la methode appelée
	 * @param e
	 *            l'eexception a l'origine de l'erreur (optionnel)
	 * @return une ErreurFonctionnelleException correspondant à l'erreur
	 *         survenue
	 */
	public static ErreurFonctionnelleException logFailServiceCall(
			final String idNat, final CodeErreurFonctionnelle codeError,
			final HttpServletRequest req, final String method,
			final Logger logger, final Exception e) {
		StringBuilder strBuilder = buildLogString(idNat, codeError, req, method);

		if (e != null) {
			logger.error(e.getMessage(), e);
		}
		logger.error(strBuilder.toString());

		return new ErreurFonctionnelleException(codeError, e);
	}

	/**
	 * Méthode de log applicatif pour les enrôlements de terminaux mobile
	 * échoués a cause d'une erreur technique. Peut logger en ERROR ou WARN
	 * 
	 * @param idNat
	 *            id de l'utilisateur
	 * @param canal
	 *            les infos à afficher du canal qui n'a pas pu être enrôlé
	 * @param codeError
	 *            l'erreur qui est survenue
	 * @param req
	 *            la requête http en cause de l'erreur
	 * @param logger
	 *            le logger a utiliser
	 * @param logType
	 *            le type de log a utiliser (ERROR/WARN)
	 * @param e
	 *            l'eexception a l'origine de l'erreur (optionnel)
	 * @return une ErreurFonctionnelleException correspondant à l'erreur
	 *         survenue
	 */
	public static ErreurTechniqueException logFailTechEnrol(final String idNat,
			final Canal canal, final CodeErreurTechnique codeError,
			final HttpServletRequest req, final Logger logger,
			final String logType, final Exception e)
			throws ErreurFonctionnelleException {
		StringBuilder strBuilder = buildLogString(idNat, canal, codeError, req);

		if ("error".equalsIgnoreCase(logType)) {
			// S'il y en a une on log l'exception en cause
			if (e != null) {
				logger.error(e.getMessage(), e);
			}
			logger.error(strBuilder.toString());
		}
		if ("warn".equalsIgnoreCase(logType)) {
			if (e != null) {
				logger.warn(e.getMessage(), e);
			}
			logger.warn(strBuilder.toString());
		}
		return new ErreurTechniqueException(codeError, e);
	}

	/**
	 * Méthode de log applicatif pour les appels MSSanté échoués a cause d'une
	 * erreur technique.
	 * 
	 * @param idNat
	 *            id de l'utilisateur
	 * @param codeError
	 *            l'erreur qui est survenue
	 * @param req
	 *            la requête http en cause de l'erreur
	 * @param logger
	 *            le logger a utiliser
	 * @param method
	 *            la methode appelée
	 * @param e
	 *            l'exception a l'origine de l'erreur (optionnel)
	 * @return une ErreurFonctionnelleException correspondant à l'erreur
	 *         survenue
	 */
	public static ErreurTechniqueException logFailTechServiceCall(
			final String idNat, final CodeErreurTechnique codeError,
			final HttpServletRequest req, final String method,
			final Logger logger, final Exception e) {
		StringBuilder strBuilder = buildLogString(idNat, codeError, req, method);

		if (e != null) {
			logger.error(e.getMessage(), e);
		}
		logger.error(strBuilder.toString());

		return new ErreurTechniqueException(codeError, e);
	}

	/**
	 * Log les appels réussi aux méthodes des services.
	 * 
	 * @param idNat
	 *            l'id de l'utilisateur
	 * @param method
	 *            nome de la methode utilisé
	 * @param req
	 *            HttpServletRequest qui a exécuté la methode
	 * @param logger
	 *            le logger a utiliser
	 */
	public static void logSuccessfulServiceCall(final String idNat,
			final String method, final HttpServletRequest req,
			final Logger logger) {
		StringBuilder strBuilder = new StringBuilder();
		// On n'utilise pas de if != null else car getRemoteAddr() appel get()
		// qui renvoi un NPE qui ne peut pas être déterminé a l'avance.
		try {
			strBuilder.append(req.getRemoteAddr());
		} catch (NullPointerException e) {
			strBuilder.append("remoteAddrNull");
		}
		strBuilder.append(" idNat=");
		if (idNat != null) {
			Pattern p = Pattern.compile("^[a-zA-Z0-9_]*$");
			Matcher m = p.matcher(idNat);
			if (m.matches()) {
				strBuilder.append(idNat);
			} else {
				strBuilder.append("format incorrect : n'est pas un entier");
			}
		} else {
			strBuilder.append("idNatNull");
		}

		// On est obligé d'utiliser un try catch car getSession throw un NPE
		// s'il n'en a pas
		try {
			String statutAppel = (String) req.getSession().getAttribute(
					"STATUT");
			if (statutAppel != null && statutAppel.equals("appel")) {
				strBuilder.append(" Appel OK");
			} else {
				req.getSession().setAttribute("STATUT", "appel");
				strBuilder.append(" Init OK");
			}
		} catch (NullPointerException e) {
			strBuilder.append(" Appel OK");
		}
		strBuilder.append(" SSL_SESSION_ID=");
		// On n'utilise pas de if != null else car getRemoteAddr() appel get()
		// qui renvoi un NPE qui ne peut pas être déterminé a l'avance.
		try {
			strBuilder.append((String) req
					.getAttribute("javax.servlet.request.ssl_session_id"));
		} catch (NullPointerException e) {
			strBuilder.append("SSL_SESSION_IDNull");
		}
		strBuilder.append(" JSESSIONID=");
		// On n'utilise pas de if != null else car getRemoteAddr() appel get()
		// qui renvoi un NPE qui ne peut pas être déterminé a l'avance.
		try {
			strBuilder.append(req.getSession().getId());
		} catch (NullPointerException e) {
			strBuilder.append("JSESSIONIDNull");
		}
		strBuilder.append(" method=");
		if (method != null) {
			strBuilder.append(method);
		} else {
			strBuilder.append("methodNull");
		}

		logger.info(strBuilder.toString());
	}

	/**
	 * removeMdcLog.
	 */
	public static void removeMdcLog() {
		MDC.remove("log_event_type");
		MDC.remove("log_status");
		MDC.remove("log_service");
		MDC.remove("log_duration");
	}

	/**
	 * Méthode permettant de setter les pattern de logs.
	 * 
	 * @param type
	 *            type de logs CIN/COUT.
	 * @param status
	 *            status OK/KO
	 * @param service
	 *            sous-système appellé
	 * @param duration
	 *            durée de traitement
	 */
	public static void setMdcLog(final String type, final String status,
			final String service, final long duration) {
		MDC.put("log_event_type", type);
		MDC.put("log_status", status);
		MDC.put("log_service", service);
		MDC.put("log_duration", String.valueOf(duration));
	}

	/**
	 * Constructeur privé (car classe utilitaire).
	 */
	private LogsUtils() {
	}
}
