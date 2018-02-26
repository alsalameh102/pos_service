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

/**
 * Composant d'accès à la table des utilisateurs .
 * 
 * */
public final class HomologationDao {

    private static final String STATEMENTFINDBYID = "select idHomologation, numHomologation from HOMOLOGATION "
            + "where idHomologation = ?";
    private static final String STATEMENTFINDBYNUMHOMOLOGATION = "select idHomologation, numHomologation "
            + "from HOMOLOGATION where numHomologation = ?";
    private static final String STATEMENTFINDALL = "SELECT idHomologation, numHomologation from HOMOLOGATION";
    private static final String STATEMENTADD = "INSERT INTO HOMOLOGATION(numHomologation) VALUES(?)";
    private static final String STATEMENTUPDATE = "UPDATE HOMOLOGATION SET numHomologation=? WHERE idHomologation = ?";
    private static final String STATEMENTDEL = "DELETE FROM HOMOLOGATION WHERE idHomologation = ?";

    private static final Logger LOG = LoggerFactory
            .getLogger(HomologationDao.class);

    /**
     * constructeur.
     */
    private HomologationDao() {

    }

    /**
     * Select d'un Homolgation par idHomologation. Ne ferme pas la connexion.
     * 
     * @param idHomologation
     *            idHomologation
     * @param cnx
     *            connexion
     * @return un Canal si trouvé, sinon null
     * @throws SQLException
     *             exception
     */
    public static Homologation findByIdHomologation(final int idHomologation,
            final Connection cnx) throws SQLException {
        LOG.debug("findByIdHomologation");

        PreparedStatement pst = null;
        ResultSet results = null;
        Homologation homologation = null;
        try {

            pst = cnx.prepareStatement(STATEMENTFINDBYID);
            pst.setInt(1, idHomologation);

            // execute the query
            results = pst.executeQuery();

            if (results == null) {
                return null;
            }

            if (results.next()) {
                homologation = alimenteHomologation(results);
            }
            return homologation;
        } finally {
            close(results);
            close(pst);
        }

    }

    /**
     * Méthode d'alimentation d'une homologation à partir du résultat de
     * requête.
     * 
     * @param results
     *            résultat de requête
     * @return homologation alimentée
     * @throws SQLException
     *             e
     */
    private static Homologation alimenteHomologation(final ResultSet results)
            throws SQLException {
        Homologation homol = new Homologation();
        homol.setIdHomologation(results.getInt("idHomologation"));
        homol.setNumHomologation(results.getString("numHomologation"));
        return homol;
    }

    /**
     * Select d'un Homolgation par numHomologation. Ne ferme pas la connexion.
     * 
     * @param numHomologation
     *            numHomologation
     * @param cnx
     *            connexion
     * @return un Canal si trouvé, sinon null
     * @throws SQLException
     *             exception
     */
    public static Homologation findByNumHomologation(
            final String numHomologation, final Connection cnx)
            throws SQLException {
        LOG.debug("findByNumHomologation");

        PreparedStatement pst = null;
        ResultSet results = null;
        Homologation homologation = null;
        try {

            pst = cnx.prepareStatement(STATEMENTFINDBYNUMHOMOLOGATION);
            pst.setString(1, numHomologation);

            // execute the query
            results = pst.executeQuery();

            if (results == null) {
                return null;
            }

            if (results.next()) {
                homologation = alimenteHomologation(results);
            }
            return homologation;
        } finally {
            close(results);
            close(pst);
        }

    }

    /**
     * Recherche de tous les Homologation. Ne ferme pas la connexion.
     * 
     * @param cnx
     *            connexion
     * @return List des Homologation si trouvé, sinon null
     * @throws SQLException
     *             exception
     */
    public static List<Homologation> findAll(final Connection cnx)
            throws SQLException {
        LOG.debug("findAll");

        PreparedStatement pst = null;
        ResultSet results = null;
        List<Homologation> list = new ArrayList<Homologation>();
        Homologation homologation;
        try {

            pst = cnx.prepareStatement(STATEMENTFINDALL);

            // execute the query
            results = pst.executeQuery();

            if (results == null) {
                return null;
            }

            while (results.next()) {
                homologation = alimenteHomologation(results);
                list.add(homologation);
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
     * Ajout d'un nouveau Homologation. Ne ferme pas la connexion.
     * 
     * @param homologation
     *            homologation
     * @param cnx
     *            connexion
     * @return l'id du Homologation créé
     * @throws SQLException
     *             exception
     */
    public static int add(final Homologation homologation, final Connection cnx)
            throws SQLException {
        LOG.debug("add");

        PreparedStatement pst = null;
        ResultSet results = null;
        int id = -1;

        try {
            pst = cnx.prepareStatement(STATEMENTADD,
                    Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, homologation.getNumHomologation());
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
     * Update d'un Homologation. Ne ferme pas la connexion.
     * 
     * @param homologation
     *            homologation
     * @param cnx
     *            connexion
     * @throws SQLException
     *             exception
     */
    public static void update(final Homologation homologation,
            final Connection cnx) throws SQLException {
        LOG.debug("update");

        PreparedStatement pst = null;
        ResultSet results = null;

        try {
            pst = cnx.prepareStatement(STATEMENTUPDATE);
            pst.setString(1, homologation.getNumHomologation());
            pst.setInt(2, homologation.getIdHomologation());
            // execute the query
            pst.executeUpdate();
        } finally {
            close(results);
            close(pst);
        }
    }

    /**
     * Supprimer un Homologation. Ne ferme pas la connexion.
     * 
     * @param id
     *            id
     * @param cnx
     *            connexion
     * @throws SQLException
     *             exception
     */
    public static void delete(final String id, final Connection cnx)
            throws SQLException {
        LOG.debug("delete");

        PreparedStatement pst = null;
        ResultSet results = null;

        try {
            pst = cnx.prepareStatement(STATEMENTDEL);
            pst.setString(1, id);
            // execute the query
            pst.executeUpdate();
        } finally {
            close(results);
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
