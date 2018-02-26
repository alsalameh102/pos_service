package fr.asip.mss.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import fr.asip.mss.transverse.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Composant d'accès à la table des utilisateurs .
 * 
 * */
public final class UtilisateurDao {

	private static final Logger LOG = LoggerFactory
			.getLogger(UtilisateurDao.class);
	private static final String STATEMENTADD = "INSERT INTO UTILISATEUR (idNat, nom, prenom, mail, profession, "
			+ "typeUtilisateur, last_access_datetime) VALUES(?,?,?,?,?,?,?)";
	private static final String STATEMENTDEL = "DELETE FROM UTILISATEUR WHERE idUtilisateur = ?";
	private static final String STATEMENTFINDBYCODE = "select idUtilisateur, nom, prenom, mail, profession, "
			+ "typeUtilisateur, statut, last_access_datetime, idNat from UTILISATEUR where idNat = ?";

	private static final String STATEMENTUPDATE = "UPDATE UTILISATEUR SET nom=?, prenom=?, mail=?, profession=?, typeUtilisateur=?, "
			+ "statut=?, last_access_datetime=?, idNat=? WHERE idUtilisateur = ?";

	private static final String STATEMENTGETALL = "select idUtilisateur, nom, prenom, mail, profession, "
			+ "typeUtilisateur, statut, last_access_datetime, idNat from UTILISATEUR";

	/**
	 * Ajout d'un nouvel Utilisateur. Ne ferme pas la connexion.
	 * 
	 * @param utilisateur
	 *            utilisateur
	 * @param cnx
	 *            connexion
	 * @return l'id de l'Utilisateur créé
	 * @throws SQLException
	 *             exception
	 */
	public static int add(final Utilisateur utilisateur, final Connection cnx)
			throws SQLException {
		LOG.debug("add");

		PreparedStatement pst = null;
		ResultSet results = null;
		int id = -1;
		try {
			pst = cnx.prepareStatement(STATEMENTADD,
					Statement.RETURN_GENERATED_KEYS);
			pst.setString(1, utilisateur.getIdNat());
			pst.setString(2, utilisateur.getNom());
			pst.setString(3, utilisateur.getPrenom());
			pst.setString(4, utilisateur.getMail());
			pst.setString(5, utilisateur.getProfession());
			pst.setString(6, utilisateur.getTypeUtilisateur());
			if (utilisateur.getLastAccessDatetime() != null) {
				pst.setTimestamp(7, new Timestamp(utilisateur.getLastAccessDatetime().getTime()));
			} else {
				pst.setTimestamp(7, null);
			}
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
	 * Retourne la liste de tous les utilisateurs en base. si la table est vide
	 * la methode retourne une liste vide.
	 * 
	 * @param cnx
	 *            la connexion
	 * @return liste d'Utilisateur
	 * @throws SQLException
	 * @See Utilisateur
	 */
	public static List<Utilisateur> getAll(final Connection cnx)
			throws SQLException {
		LOG.debug("getAll");

		PreparedStatement pst = null;
		ResultSet results = null;
		Utilisateur user = null;
		List<Utilisateur> ret = new ArrayList<Utilisateur>();

		try {
			pst = cnx.prepareStatement(STATEMENTGETALL);
			// execute the query
			results = pst.executeQuery();

			while (results.next()) {
				user = alimenteUtilisateur(results);
				ret.add(user);
			}

		} finally {
			close(results);
			close(pst);
		}

		return ret;
	}

	/**
	 * Méthode permettant d'alimenter un utilisateur à partir du résultat de
	 * requête.
	 * 
	 * @param results
	 *            résultat de requête
	 * @return utilisateur alimenté
	 * @throws SQLException
	 *             e
	 */
	private static Utilisateur alimenteUtilisateur(final ResultSet results)
			throws SQLException {
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setIdNat(results.getString("idNat"));
		utilisateur.setIdUtilisateur(results.getInt("idUtilisateur"));
		utilisateur.setMail(results.getString("mail"));
		utilisateur.setNom(results.getString("nom"));
		utilisateur.setPrenom(results.getString("prenom"));
		utilisateur.setProfession(results.getString("profession"));
		utilisateur.setStatut(results.getInt("statut"));
		utilisateur.setLastAccessDatetime(results.getDate("last_access_datetime"));
		utilisateur.setTypeUtilisateur(results.getString("typeUtilisateur"));
		return utilisateur;
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
	 * Supprimer un Utilisateur. Ne ferme pas la connexion.
	 * 
	 * @param id
	 *            id
	 * @param cnx
	 *            connexion
	 * @throws SQLException
	 *             exception
	 */
	public static void delete(final int id, final Connection cnx)
			throws SQLException {
		LOG.debug("delete");

		PreparedStatement pst = null;
		ResultSet results = null;

		try {
			pst = cnx.prepareStatement(STATEMENTDEL);
			pst.setInt(1, id);
			// execute the query
			pst.executeUpdate();
		} finally {
			close(results);
			close(pst);
		}
	}

	/**
	 * Select d'un utilisateur par idNat. Ne ferme pas la connexion.
	 * 
	 * @param idNat
	 *            idNat
	 * @param cnx
	 *            connexion
	 * @return un utilisateur si trouvé, sinon null
	 * @throws SQLException
	 *             exception
	 */
	public static Utilisateur findByIdNat(final String idNat,
			final Connection cnx) throws SQLException {

		LOG.debug("findByIdNat");

		PreparedStatement pst = null;
		ResultSet results = null;
		Utilisateur user = null;
		try {

			pst = cnx.prepareStatement(STATEMENTFINDBYCODE);
			pst.setString(1, idNat);

			// execute the query
			results = pst.executeQuery();

			if (results == null) {
				return null;
			}

			if (results.next()) {
				user = alimenteUtilisateur(results);
			}
			return user;
		} finally {
			close(results);
			close(pst);
		}

	}

	/**
	 * Update d'un Utilisateur. Ne ferme pas la connexion.
	 * 
	 * @param utilisateur
	 *            utilisateur
	 * @param cnx
	 *            connexion
	 * @throws SQLException
	 *             exception
	 */
	public static void update(final Utilisateur utilisateur,
			final Connection cnx) throws SQLException {
		LOG.debug("update");

		PreparedStatement pst = null;
		ResultSet results = null;

		try {
			pst = cnx.prepareStatement(STATEMENTUPDATE);
			pst.setString(1, utilisateur.getNom());
			pst.setString(2, utilisateur.getPrenom());
			pst.setString(3, utilisateur.getMail());
			pst.setString(4, utilisateur.getProfession());
			pst.setString(5, utilisateur.getTypeUtilisateur());
			pst.setString(6, String.valueOf(utilisateur.getStatut()));
			if (utilisateur.getLastAccessDatetime() != null) {
				pst.setTimestamp(7, new Timestamp(utilisateur.getLastAccessDatetime().getTime()));
			} else {
				pst.setTimestamp(7, null);
			}
			pst.setString(8, utilisateur.getIdNat());
			pst.setString(9, String.valueOf(utilisateur.getIdUtilisateur()));
			// execute the query
			pst.executeUpdate();
		} finally {
			close(results);
			close(pst);
		}
	}


	/**
	 * constructeur.
	 */
	private UtilisateurDao() {

	}

}
