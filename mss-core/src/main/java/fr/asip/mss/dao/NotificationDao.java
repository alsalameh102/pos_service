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
 * Composant d'accès à la table des notifications .
 * 
 * */
public final class NotificationDao {

    private static final Logger LOG = LoggerFactory
            .getLogger(NotificationDao.class);
    private static final String STATEMENTADD = "INSERT INTO NOTIFICATION (idCanal, mail,isActivated) VALUES(?,?,?)";
    private static final String STATEMENTDEL = "DELETE FROM NOTIFICATION WHERE idCanal = ?";
    // private static final String STATEMENTFINDALL =
    // "SELECT idNotification, idCanal, isActivated, mail from NOTIFICATION";
    private static final String STATEMENTFINDNOTIFICATION = "SELECT idNotification, idCanal, isActivated, mail from NOTIFICATION where mail=? and idCanal=?";

    private static final String STATEMENTFINDNOTIFICATIONWITHMAIL = "SELECT idNotification, idCanal, isActivated, mail from NOTIFICATION where mail=?";

    private static final String STATEMENTUPDATENOTIFICATION = "UPDATE NOTIFICATION set isActivated=?"
            + " where idNotification=?";

    /**
     * Ajout d'une nouvelle notification. Ne ferme pas la connexion.
     * 
     * @param notification
     *            Notification à ajouter
     * @param cnx
     *            connexion
     * @return l'id de la notification créée
     * @throws SQLException
     *             exception
     */
    public static int add(final Notification notification, final Connection cnx)
            throws SQLException {
        LOG.debug("add");

        PreparedStatement pst = null;
        ResultSet results = null;
        int id = -1;

        try {
            pst = cnx.prepareStatement(STATEMENTADD,
                    Statement.RETURN_GENERATED_KEYS);
            pst.setInt(1, notification.getIdCanal());
            pst.setString(2, notification.getEmail());
            pst.setInt(3, notification.getActivated());
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
     * Méthode d'alimentation de notification à partir du résultat de requête.
     * 
     * @param results
     *            résultat de requête
     * @return notification alimentée
     * @throws SQLException
     *             e
     */
    private static Notification alimenteNotification(final ResultSet results)
            throws SQLException {
        Notification notification = new Notification();
        notification.setEmail(results.getString("mail"));
        notification.setIdCanal(results.getInt("idCanal"));
        notification.setIdNotification(results.getInt("idNotification"));
        notification.setActivated(results.getInt("isActivated"));
        return notification;
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
     * Supprimer une notification. Ne ferme pas la connexion.
     * 
     * @param idCanal
     *            identifiant du canal sur lequel on souhaite supprimer la
     *            notification
     * @param cnx
     *            connexion
     * @throws SQLException
     *             exception
     */
    public static void delete(final int idCanal, final Connection cnx)
            throws SQLException {
        LOG.debug("delete");

        PreparedStatement pst = null;
        ResultSet results = null;
        try {
            pst = cnx.prepareStatement(STATEMENTDEL);
            pst.setInt(1, idCanal);
            // execute the query
            pst.executeUpdate();
        } finally {
            close(results);
            close(pst);
        }
    }

    /**
     * Recherche de la notification pour un mail et un canal donné. Ne ferme pas
     * la connexion.
     * 
     * @param idCanal
     *            idCanal
     * @param email
     *            adresse de messagerie
     * @param cnx
     *            connexion
     * @return la première notification trouvée
     * @throws SQLException
     *             exception
     */
    public static Notification findAllByCanalEmail(final int idCanal,
            final String email, final Connection cnx) throws SQLException {
        LOG.debug("findAllByCanalEmail");

        PreparedStatement pst = null;
        ResultSet results = null;
        Notification notif = null;
        if (email != null && cnx != null) {
            try {
                pst = cnx.prepareStatement(STATEMENTFINDNOTIFICATION);

                pst.setString(1, email);
                pst.setInt(2, idCanal);
                // execute the query
                results = pst.executeQuery();

                if (results == null) {
                    return null;
                }

                if (results.next()) {
                    notif = alimenteNotification(results);
                }

            } finally {
                close(results);
                close(pst);
            }
        }
        return notif;
    }

    /**
     * Recherche de la notification pour un mail donné. Ne ferme pas la
     * connexion.
     * 
     * @param email
     *            adresse de messagerie
     * @param cnx
     *            connexion
     * @return la première notification trouvée
     * @throws SQLException
     *             exception
     */
    public static List<Notification> findAllByEmail(final String email,
            final Connection cnx) throws SQLException {
        LOG.debug("findAllByEmail");

        List<Notification> notifs = null;
        PreparedStatement pst = null;
        ResultSet results = null;
        Notification notif = null;
        if (email != null && cnx != null) {
            try {
                pst = cnx.prepareStatement(STATEMENTFINDNOTIFICATIONWITHMAIL);

                pst.setString(1, email);
                // execute the query
                results = pst.executeQuery();

                if (results == null) {
                    return null;
                }

                notifs = new ArrayList<Notification>();
                while (results.next()) {
                    notif = alimenteNotification(results);
                    notifs.add(notif);
                }

            } finally {
                close(results);
                close(pst);
            }
        }
        return notifs;
    }

    /**
     * Mise à jour d'une notification : juste le champ isActivated. Ne ferme pas
     * la connexion.
     * 
     * @param notif
     *            notification sur laquelle on souhaite mettre à jour
     *            isActivated.
     * @param cnx
     *            connexion
     * @throws SQLException
     *             exception
     */
    public static void updateIsActivated(final Notification notif,
            final Connection cnx) throws SQLException {
        LOG.debug("updateIsActivated");

        PreparedStatement pst = null;
        ResultSet results = null;
        if (notif != null && cnx != null) {
            try {
                pst = cnx.prepareStatement(STATEMENTUPDATENOTIFICATION);
                pst.setInt(1, notif.getActivated());
                pst.setInt(2, notif.getIdNotification());
                // execute the query
                pst.executeUpdate();
            } finally {
                close(results);
                close(pst);
            }
        }
    }

    /**
     * constructeur.
     */
    private NotificationDao() {

    }

}
