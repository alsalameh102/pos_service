package fr.asip.mss.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.asip.mss.transverse.utils.DateUtils;

/**
 * Composant d'accès à la table des utilisateurs .
 * 
 * */
public final class CanalDao {

    private static final Logger LOG = LoggerFactory.getLogger(CanalDao.class);
    private static final String STATEMENTADD = "INSERT INTO CANAL(idUtilisateur, canalType, os, idPush, pushMode, idMobile, "
            + "numTel, email, pwd, dateCreation, dateConnexion, dateEchec, nbEchec, statut, typeChiffrage, dateMaj) "
            + "VALUES(?,?,?,?,?,?,?,?,?,NOW(),?,?,?,?, ?, NOW())";
    private static final String STATEMENTADDFROMIMPORT = "INSERT INTO CANAL(idUtilisateur, canalType, os, idPush, idMobile, "
            + "numTel, email, pwd, dateCreation, dateConnexion, dateEchec, nbEchec, statut, typeChiffrage, dateMaj) "
            + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?, ?, NOW())";
    private static final String STATEMENTDEL = "DELETE FROM CANAL WHERE idCanal = ?";
    private static final String STATEMENTDELALLBYIDUTILISATEUR = "DELETE FROM CANAL WHERE idUtilisateur = ?";
    private static final String STATEMENTFINDALLBYID = "SELECT CANAL.idCanal, CANAL.idUtilisateur, CANAL.canalType, "
            + "CANAL.os, CANAL.idPush, CANAL.pushMode, CANAL.idMobile, CANAL.numTel, CANAL.email, CANAL.pwd, CANAL.dateCreation, "
            + "CANAL.dateConnexion, CANAL.dateEchec, CANAL.nbEchec, CANAL.statut, CANAL.typeChiffrage, CANAL.dateMaj FROM CANAL, UTILISATEUR "
            + "WHERE CANAL.idUtilisateur = UTILISATEUR.idUtilisateur AND UTILISATEUR.idNat = ?";
    private static final String STATEMENTFINDBYID = "select idCanal, idUtilisateur, canalType, os, idPush, pushMode, idMobile, "
            + "numTel, email, pwd, dateCreation, dateConnexion, dateEchec, nbEchec, statut, typeChiffrage, dateMaj "
            + "from CANAL where idCanal = ?";
    private static final String STATEMENTFINDBYIDPUSH = "select idCanal, idUtilisateur, canalType, "
            + "os, idPush, pushMode, idMobile, numTel, email, pwd, dateCreation, dateConnexion, dateEchec, nbEchec, statut, typeChiffrage, dateMaj "
            + "from CANAL where idPush = ?";
    private static final String STATEMENTFINDBYIDUTILANDIDMOB = "select idCanal, idUtilisateur, canalType, os, "
            + "idPush, pushMode, idMobile, numTel, email, pwd, dateCreation, dateConnexion, dateEchec, nbEchec, statut, typeChiffrage, dateMaj "
            + "from CANAL where idMobile = ?";
    private static final String STATEMENTFINDBYIDUTILTYPECANAL = "select idCanal, idUtilisateur, canalType, "
            + "os, idPush, pushMode, idMobile, numTel, email, pwd, dateCreation, dateConnexion, dateEchec, nbEchec, statut, typeChiffrage, dateMaj "
            + "from CANAL where idUtilisateur = ? AND canalType = ?";

    private static final String STATEMENTUPDATE = "UPDATE CANAL SET canalType=?, os=?, idPush=?, pushMode=?, idMobile=?, numTel=?, "
            + "email=?, pwd=?, dateMaj=?, dateConnexion=?, dateEchec=?, nbEchec=?, statut=?, typeChiffrage=?, idUtilisateur=? WHERE idCanal = ?";

    /**
     * Ajout d'un nouveau Canal. Ne ferme pas la connexion.
     * 
     * @param canal
     *            canal
     * @param cnx
     *            connexion
     * @return l'id du Canal créé
     * @throws SQLException
     *             exception
     */
    public static int add(final Canal canal, final Connection cnx)
            throws SQLException {
        LOG.debug("add");

        PreparedStatement pst = null;
        ResultSet results = null;
        int id = -1;

        try {
            pst = cnx.prepareStatement(STATEMENTADD,
                    Statement.RETURN_GENERATED_KEYS);
            pst.setInt(1, canal.getIdUtilisateur());
            pst.setString(2, canal.getCanalType());
            pst.setString(3, canal.getOs());
            pst.setString(4, canal.getIdPush());
            pst.setString(5, canal.getPushMode());
            pst.setString(6, canal.getIdMobile());
            pst.setString(7, canal.getNumTel());
            pst.setString(8, canal.getEmail());
            pst.setString(9, canal.getPwd());
            if (canal.getDateConnexion() != null) {
                pst.setTimestamp(10, new Timestamp(canal.getDateConnexion()
                        .getTime()));
            } else {
                pst.setTimestamp(10, null);
            }
            if (canal.getDateEchec() != null) {
                pst.setTimestamp(11, new Timestamp(canal.getDateEchec()
                        .getTime()));
            } else {
                pst.setTimestamp(11, null);
            }
            pst.setInt(12, canal.getNbEchec());
            pst.setString(13, canal.getStatut());
            pst.setString(14, canal.getTypeChiffrage());
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
     * Ajout d'un nouveau Canal. Ne ferme pas la connexion.
     * 
     * @param canal
     *            canal
     * @param cnx
     *            connexion
     * @return l'id du Canal créé
     * @throws SQLException
     *             exception
     */
    public static int addFromImport(final Canal canal, final Connection cnx)
            throws SQLException {
        LOG.debug("add");

        PreparedStatement pst = null;
        ResultSet results = null;
        int id = -1;

        try {
            pst = cnx.prepareStatement(STATEMENTADDFROMIMPORT,
                    Statement.RETURN_GENERATED_KEYS);
            pst.setInt(1, canal.getIdUtilisateur());
            pst.setString(2, canal.getCanalType());
            pst.setString(3, canal.getOs());
            pst.setString(4, canal.getIdPush());
            pst.setString(5, canal.getIdMobile());
            pst.setString(6, canal.getNumTel());
            pst.setString(7, canal.getEmail());
            pst.setString(8, canal.getPwd());
            pst.setTimestamp(10, new Timestamp(canal.getDateCreation()
                    .getTime()));
            if (canal.getDateConnexion() != null) {
                pst.setTimestamp(10, new Timestamp(canal.getDateConnexion()
                        .getTime()));
            } else {
                pst.setTimestamp(10, null);
            }
            if (canal.getDateEchec() != null) {
                pst.setTimestamp(11, new Timestamp(canal.getDateEchec()
                        .getTime()));
            } else {
                pst.setTimestamp(11, null);
            }
            pst.setInt(12, canal.getNbEchec());
            pst.setString(13, canal.getStatut());
            pst.setString(14, canal.getTypeChiffrage());
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
     * Alimentation du canal suite au résultat d'une requête.
     * 
     * @param results
     *            résultat de la requête
     * @return canal alimenté
     * @throws SQLException
     *             e
     */
    private static Canal alimenteCanal(final ResultSet results)
            throws SQLException {
        Canal canal = new Canal();
        canal.setCanalType(results.getString("canalType"));
        canal.setDateConnexion(DateUtils.timestampToDate(results
                .getTimestamp("dateConnexion")));
        canal.setDateCreation(DateUtils.timestampToDate(results
                .getTimestamp("dateCreation")));
        canal.setDateMaj(DateUtils.timestampToDate(results
                .getTimestamp("dateMaj")));
        canal.setDateEchec(DateUtils.timestampToDate(results
                .getTimestamp("dateEchec")));
        canal.setEmail(results.getString("email"));
        canal.setIdCanal(results.getInt("idCanal"));
        canal.setIdMobile(results.getString("idMobile"));
        canal.setIdPush(results.getString("idPush"));
        canal.setPushMode(results.getString("pushMode"));
        canal.setIdUtilisateur(results.getInt("idUtilisateur"));
        canal.setNbEchec(results.getInt("nbEchec"));
        canal.setNumTel(results.getString("numTel"));
        canal.setOs(results.getString("os"));
        canal.setPwd(results.getString("pwd"));
        canal.setStatut(results.getString("statut"));
        canal.setTypeChiffrage(results.getString("typeChiffrage"));
        return canal;
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
     * Supprimer un Canal. Ne ferme pas la connexion.
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
     * Supprimer les canaux d'un utilisateur. Ne ferme pas la connexion.
     * 
     * @param idUtilisateur
     *            idUtilisateur
     * @param cnx
     *            connexion
     * @throws SQLException
     *             exception
     */
    public static void deleteAllByIdUtilisateur(final int idUtilisateur,
            final Connection cnx) throws SQLException {
        LOG.debug("deleteAllByIdUtilisateur");

        PreparedStatement pst = null;
        ResultSet results = null;
        try {
            pst = cnx.prepareStatement(STATEMENTDELALLBYIDUTILISATEUR);
            pst.setInt(1, idUtilisateur);
            // execute the query
            pst.executeUpdate();
        } finally {
            close(results);
            close(pst);
        }
    }

    /**
     * Recherche de tous les canaux appartenant a l'idNat. Ne ferme pas la
     * connexion.
     * 
     * @param idNat
     *            idNat
     * @param cnx
     *            connexion
     * @return List des canaux si trouvé, sinon null
     * @throws SQLException
     *             exception
     */
    public static List<Canal> findAllByIdNat(final String idNat,
            final Connection cnx) throws SQLException {
        LOG.debug("findAllByIdNat");

        PreparedStatement pst = null;
        ResultSet results = null;
        List<Canal> list = new ArrayList<Canal>();
        Canal canal;
        try {

            pst = cnx.prepareStatement(STATEMENTFINDALLBYID);
            pst.setString(1, idNat);

            // execute the query
            results = pst.executeQuery();

            if (results == null) {
                return null;
            }

            while (results.next()) {
                canal = alimenteCanal(results);
                list.add(canal);
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
     * Select d'un Canal par idCanal. Ne ferme pas la connexion.
     * 
     * @param idCanal
     *            idCanal
     * @param cnx
     *            connexion
     * @return un Canal si trouvé, sinon null
     * @throws SQLException
     *             exception
     */
    public static Canal findByIdCanal(final int idCanal, final Connection cnx)
            throws SQLException {
        LOG.debug("findByIdCanal");

        PreparedStatement pst = null;
        ResultSet results = null;
        Canal canal = null;
        try {

            pst = cnx.prepareStatement(STATEMENTFINDBYID);
            pst.setInt(1, idCanal);

            // execute the query
            results = pst.executeQuery();

            if (results == null) {
                return null;
            }

            if (results.next()) {
                canal = alimenteCanal(results);
            }
            return canal;
        } finally {
            close(results);
            close(pst);
        }

    }

    /**
     * Select d'un Canal paridMobile. Ne ferme pas la connexion.
     * 
     * @param idMobile
     *            idMobile
     * @param cnx
     *            connexion
     * @return un Canal si trouvé, sinon null
     * @throws SQLException
     *             exception
     */
    public static Canal findByIdMobile(final String idMobile,
            final Connection cnx) throws SQLException {
        LOG.debug("findByIdMobile");

        PreparedStatement pst = null;
        ResultSet results = null;
        Canal canal = null;
        try {

            pst = cnx.prepareStatement(STATEMENTFINDBYIDUTILANDIDMOB);
            pst.setString(1, idMobile);

            // execute the query
            results = pst.executeQuery();

            if (results == null) {
                return null;
            }

            if (results.next()) {
                canal = alimenteCanal(results);
            }
            return canal;
        } finally {
            close(results);
            close(pst);
        }

    }

    /**
     * Select d'un Canal par idPush. Ne ferme pas la connexion.
     * 
     * @param idPush
     *            idPush
     * @param cnx
     *            connexion
     * @return un Canal si trouvé, sinon null
     * @throws SQLException
     *             exception
     */
    public static Canal findByIdPush(final String idPush, final Connection cnx)
            throws SQLException {
        LOG.debug("findByIdPush");

        PreparedStatement pst = null;
        ResultSet results = null;
        Canal canal = null;
        try {

            pst = cnx.prepareStatement(STATEMENTFINDBYIDPUSH);
            pst.setString(1, idPush);

            // execute the query
            results = pst.executeQuery();

            if (results == null) {
                return null;
            }

            if (results.next()) {
                canal = alimenteCanal(results);
            }
            return canal;
        } finally {
            close(results);
            close(pst);
        }

    }

    /**
     * Select d'un Canal par idUtilisateur, typeCanal . Ne ferme pas la
     * connexion.
     * 
     * @param idUtilisateur
     *            idUtilisateur
     * @param typeCanal
     *            typeCanal
     * @param cnx
     *            connexion
     * @return un Canal si trouvé, sinon null
     * @throws SQLException
     *             exception
     */
    public static Canal findByIdUtilisateurTypeCanal(final int idUtilisateur,
            final String typeCanal, final Connection cnx) throws SQLException {
        LOG.debug("findByIdUtilisateurTypeCanal");

        PreparedStatement pst = null;
        ResultSet results = null;
        Canal canal = null;
        try {

            pst = cnx.prepareStatement(STATEMENTFINDBYIDUTILTYPECANAL);
            pst.setInt(1, idUtilisateur);
            pst.setString(2, typeCanal);

            // execute the query
            results = pst.executeQuery();

            if (results == null) {
                return null;
            }

            if (results.next()) {
                canal = alimenteCanal(results);
            }
            return canal;
        } finally {
            close(results);
            close(pst);
        }

    }

    /**
     * Update d'un Canal. Ne ferme pas la connexion.
     * 
     * @param canal
     *            canal
     * @param cnx
     *            connexion
     * @throws SQLException
     *             exception
     */
    public static void update(final Canal canal, final Connection cnx)
            throws SQLException {
        LOG.debug("update");

        PreparedStatement pst = null;
        ResultSet results = null;

        try {
            pst = cnx.prepareStatement(STATEMENTUPDATE);
            pst.setString(1, canal.getCanalType());
            pst.setString(2, canal.getOs());
            pst.setString(3, canal.getIdPush());
            pst.setString(4, canal.getPushMode());
            pst.setString(5, canal.getIdMobile());
            pst.setString(6, canal.getNumTel());
            pst.setString(7, canal.getEmail());
            pst.setString(8, canal.getPwd());

            if (canal.getDateMaj() != null) {
                pst.setTimestamp(9, new Timestamp(canal.getDateMaj().getTime()));
            } else {
                pst.setTimestamp(9, null);
            }
            if (canal.getDateConnexion() != null) {
                pst.setTimestamp(10, new Timestamp(canal.getDateConnexion()
                        .getTime()));
            } else {
                pst.setTimestamp(10, null);
            }
            if (canal.getDateEchec() != null) {
                pst.setTimestamp(11, new Timestamp(canal.getDateEchec()
                        .getTime()));
            } else {
                pst.setTimestamp(11, null);
            }
            pst.setInt(12, canal.getNbEchec());
            pst.setString(13, canal.getStatut());
            pst.setString(14, canal.getTypeChiffrage());
            pst.setInt(15, canal.getIdUtilisateur());
            pst.setInt(16, canal.getIdCanal());

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
    private CanalDao() {

    }

}
