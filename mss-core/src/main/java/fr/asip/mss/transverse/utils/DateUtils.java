package fr.asip.mss.transverse.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Classe d'utilitaires de dates.
 */
public final class DateUtils {
	/**
	 * Format de date dd/MM/yyyy.
	 */
	public static final String FORMAT_JJMMAAAA = "dd/MM/yyyy";

	public static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ssXXX";

	/**
	 * Format de date dd/MM/yyyy HH:mm:ss.
	 */
	public static final String FORMAT_JJMMAAAAHHMMSS = "dd/MM/yyyy HH:mm:ss";

	public static final String FORMAT_JJMMAAAAHHMMSSMM = "dd/MM/yyyy HH:mm:ss:mi";

	private static final double MILLISECONDS_IN_A_MINUTE = 60000;

	/**
	 * Méthode renvoyant la date du jour.
	 * 
	 * @return date du jour
	 */
	public static Date dateDuJour() {
		return new Date();
	}

	/**
	 * Méthode de transformation d'une date en chaine de caractère.
	 * 
	 * @param date
	 *            date
	 * @param format
	 *            format de transformation
	 * @return chaine
	 */
	public static String dateToString(final Date date, final String format) {
		String res = null;
		if (date != null && format != null) {
			final SimpleDateFormat formatter = new SimpleDateFormat(format);
			res = formatter.format(date);
		}
		return res;
	}

	/**
	 * Transforme une date en date relative Zimbra.
	 * 
	 * @param date
	 *            date en entrée
	 * @return date relative Zimbra
	 */
	public static String dateToZimbraRelative(final Date date) {
		String res = null;
		if (date != null) {
			Date now = dateDuJour();
			if (now.after(date)) {
				double relative = now.getTime() - date.getTime();
				res = "-" + Math.round(relative / MILLISECONDS_IN_A_MINUTE)
						+ "mi";
			} else {
				double relative = date.getTime() - now.getTime();
				res = "+" + Math.round(relative / MILLISECONDS_IN_A_MINUTE)
						+ "mi";
			}
		}
		return res;
	}

	/**
	 * méthode de transformation d'une chaine de caractère en date.
	 * 
	 * @param sDate
	 *            chaine à transformer
	 * @param format
	 *            format de date souhaité
	 * @return date
	 * @throws ParseException
	 *             ParseException
	 */
	public static Date stringToDate(final String sDate, final String format)
			throws ParseException {
		Date d = null;
		if (sDate != null && format != null) {
			final SimpleDateFormat formatter = new SimpleDateFormat(format);
			d = formatter.parse(sDate);
		}
		return d;
	}

	/**
	 * Transforme un timestamp sql en date
	 * 
	 * @param timestamp
	 *            sql
	 * @return date
	 */
	public static Date timestampToDate(final Timestamp timestamp) {
		Date d = null;
		if (timestamp != null) {
			d = new Date(timestamp.getTime());
		}
		return d;
	}

	/**
	 * Constructeur par défaut.
	 */
	private DateUtils() {
		super();
	}
}
