package fr.asip.mss.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.asip.mss.transverse.utils.DateUtils;

/**
 * Composant d'accès à la table des QRCodes .
 * 
 * */
public final class QRCodeDao {

	private static final String STATEMENTFINDBYCODE = "select idQRCode, idNat, nom, prenom, profession, "
			+ "typeUtilisateur, codeAppareillement, dateCreation from QRCODE where codeAppareillement = ?";
	private static final String STATEMENTFINDALLBYIDNAT = "select idQRCode, idNat, nom, prenom, profession, "
			+ "typeUtilisateur, codeAppareillement, dateCreation from QRCODE where idNat = ?";
	private static final String STATEMENTADD = "INSERT INTO QRCODE(idNat, nom, prenom, profession, typeUtilisateur, "
			+ "codeAppareillement, dateCreation) VALUES(?,?,?,?,?,?,NOW())";
	private static final String STATEMENTADDPERIME = "INSERT INTO QRCODE(idNat, nom, prenom, profession, "
			+ "typeUtilisateur, codeAppareillement, dateCreation) VALUES(?,?,?,?,?,?,NOW() - INTERVAL 10 MINUTE)";
	private static final String STATEMENTPURGE = "DELETE FROM QRCODE WHERE dateCreation < now() - INTERVAL 2 MINUTE";
	private static final String STATEMENTDELETEBYCODE = "DELETE FROM QRCODE WHERE codeAppareillement = ?";

	private static final Logger LOG = LoggerFactory.getLogger(QRCodeDao.class);

	/**
	 * constructeur.
	 */
	private QRCodeDao() {
	}

	/**
	 * Select d'un QRCode par codeAppareillement. Ne ferme pas la connexion.
	 * 
	 * @param codeAppareillement
	 *            codeAppareillement
	 * @param cnx
	 *            connexion
	 * @return un QRCode si trouvé, sinon null
	 * @throws SQLException
	 *             exception
	 */
	public static QRCode findByCodeAppareillement(
			final String codeAppareillement, final Connection cnx)
			throws SQLException {
		LOG.debug("findByCodeAppareillement");

		PreparedStatement pst = null;
		ResultSet results = null;
		QRCode qrCode = null;
		try {
			pst = cnx.prepareStatement(STATEMENTFINDBYCODE);
			pst.setString(1, codeAppareillement);

			// execute the query
			results = pst.executeQuery();

			if (results == null) {
				return null;
			}

			if (results.next()) {
				qrCode = alimenteQrCode(results);
			}
			return qrCode;
		} finally {
			close(results);
			close(pst);
		}

	}

	/**
	 * Alimentation du QR Code à partir du résultat de la requête.
	 * 
	 * @param results
	 *            résultat de la requête
	 * @return QRCode alimenté
	 * @throws SQLException
	 *             e
	 */
	private static QRCode alimenteQrCode(final ResultSet results)
			throws SQLException {
		QRCode code = new QRCode();
		code.setCodeAppareillement(results.getString("codeAppareillement"));
		code.setDateCreation(DateUtils.timestampToDate(results
				.getTimestamp("dateCreation")));
		code.setIdNat(results.getString("idNat"));
		code.setIdQRCode(results.getInt("idQRCode"));
		code.setNom(results.getString("nom"));
		code.setPrenom(results.getString("prenom"));
		code.setProfession(results.getString("profession"));
		code.setTypeUtilisateur(results.getString("typeUtilisateur"));
		return code;

	}

	/**
	 * Recherche de tous les qrCodes appartenant a l'idNat. Ne ferme pas la
	 * connexion.
	 * 
	 * @param idNat
	 *            idNat
	 * @param cnx
	 *            connexion
	 * @return List des qrCodes si trouvé, sinon null
	 * @throws SQLException
	 *             exception
	 */
	public static List<QRCode> findAllByIdNat(final String idNat,
			final Connection cnx) throws SQLException {
		LOG.debug("findAllByIdNat");

		PreparedStatement pst = null;
		ResultSet results = null;
		List<QRCode> list = new ArrayList<QRCode>();
		QRCode qrCode;
		try {
			pst = cnx.prepareStatement(STATEMENTFINDALLBYIDNAT);
			pst.setString(1, idNat);

			// execute the query
			results = pst.executeQuery();

			if (results == null) {
				return null;
			}

			while (results.next()) {
				qrCode = alimenteQrCode(results);
				list.add(qrCode);
			}
			if (list.isEmpty()) {
				return null;
			}
			return list;
		} finally {
			close(results);
			close(pst);
		}

	}

	/**
	 * Ajout d'un nouveau QRCode. Ne ferme pas la connexion.
	 * 
	 * @param qrCode
	 *            qrCode
	 * @param cnx
	 *            connexion
	 * @return l'id du QRCode créé
	 * @throws SQLException
	 *             exception
	 */
	public static int add(final QRCode qrCode, final Connection cnx)
			throws SQLException {
		return QRCodeDao.add(qrCode, false, cnx);
	}

	/**
	 * Ajout d'un nouveau QRCode perimé si le boolean est à true. Ne ferme pas
	 * la connexion.
	 * 
	 * @param qrCode
	 *            qrCode
	 * @param perime
	 *            perime
	 * @param cnx
	 *            connexion
	 * @return l'id du QRCode créé
	 * @throws SQLException
	 *             exception
	 */
	public static int add(final QRCode qrCode, final boolean perime,
			final Connection cnx) throws SQLException {
		LOG.debug("add");

		PreparedStatement pst = null;
		ResultSet results = null;
		int id = -1;

		try {
			if (perime) {
				pst = cnx.prepareStatement(STATEMENTADDPERIME,
						Statement.RETURN_GENERATED_KEYS);
			} else {
				pst = cnx.prepareStatement(STATEMENTADD,
						Statement.RETURN_GENERATED_KEYS);
			}
			pst.setString(1, qrCode.getIdNat());
			pst.setString(2, qrCode.getNom());
			pst.setString(3, qrCode.getPrenom());
			pst.setString(4, qrCode.getProfession());
			pst.setString(5, qrCode.getTypeUtilisateur());
			pst.setString(6, qrCode.getCodeAppareillement());
			// execute the query
			pst.executeUpdate();
			results = pst.getGeneratedKeys();
			results.next();
			id = results.getInt(1);
		} finally {
			close(results);
			close(pst);
		}
		return id;
	}

	/**
	 * Purge des QRCode périmés. Ne ferme pas la connexion.
	 * 
	 * @param cnx
	 *            connexion
	 * @throws SQLException
	 *             exception
	 */
	public static void purge(final Connection cnx) throws SQLException {
		PreparedStatement pst = null;
		LOG.debug("purge");

		try {
			pst = cnx.prepareStatement(STATEMENTPURGE);
			// execute the query
			pst.executeUpdate();
		} finally {
			close(pst);
		}
	}

	/**
	 * Suppression d'un QRCode par codeAppareillement. Ne ferme pas la
	 * connexion.
	 * 
	 * @param codeAppareillement
	 *            codeAppareillement
	 * @param cnx
	 *            connexion
	 * @throws SQLException
	 *             exception
	 */
	public static void deleteByCodeAppareillement(
			final String codeAppareillement, final Connection cnx)
			throws SQLException {
		LOG.debug("deleteByCodeAppareillement");

		PreparedStatement pst = null;
		try {
			pst = cnx.prepareStatement(STATEMENTDELETEBYCODE);
			pst.setString(1, codeAppareillement);
			// execute the query
			pst.executeUpdate();
		} finally {
			close(pst);
		}
	}

	/**
	 * utilitaire, ferme la ressource sans exception.
	 * 
	 * @param rs
	 *            resultset
	 */
	private static void close(final ResultSet rs) {
		// close the resultset
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				// ignore
			}
		}
	}

	/**
	 * utilitaire, ferme la ressource sans exception.
	 * 
	 * @param pst
	 *            preparestatement
	 */
	private static void close(final PreparedStatement pst) {
		// close the statement
		if (pst != null) {
			try {
				pst.close();
			} catch (Exception e) {
				// ignore
			}
		}
	}

}
