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
public final class UnregisteredDeviceDao {

    private static final Logger LOG = LoggerFactory
            .getLogger(UnregisteredDeviceDao.class);
    private static final String STATEMENTADD = "INSERT INTO UNREGISTEREDDEVICE(os, idPush, pushMode, dateMaj) "
            + "VALUES(?,?,?,NOW())";
    private static final String STATEMENTDEL = "DELETE FROM UNREGISTEREDDEVICE WHERE idUnregisteredDevice = ?";
    private static final String STATEMENTFINDBYID = "select idUnregisteredDevice, os, idPush, pushMode, dateMaj "
            + "from UNREGISTEREDDEVICE where idUnregisteredDevice = ?";
    private static final String STATEMENTFINDALLTOPURGE = "select idUnregisteredDevice, os, idPush, pushMode, dateMaj "
            + "from UNREGISTEREDDEVICE";
    private static final String STATEMENTUPDATE = "UPDATE UNREGISTEREDDEVICE SET os=?, idPush=?, pushMode=?, "
            + "dateMaj=? WHERE idUnregisteredDevice = ?";

    /**
     * Ajout d'un nouveau UnregisteredDevice. Ne ferme pas la connexion.
     * 
     * @param unregisteredDevice
     *            unregisteredDevice
     * @param cnx
     *            connexion
     * @return l'id du UnregisteredDevice créé
     * @throws SQLException
     *             exception
     */
    public static int add(final UnregisteredDevice unregisteredDevice,
            final Connection cnx) throws SQLException {
        LOG.debug("add");

        PreparedStatement pst = null;
        ResultSet results = null;
        int id = -1;

        try {
            pst = cnx.prepareStatement(STATEMENTADD,
                    Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, unregisteredDevice.getOs());
            pst.setString(2, unregisteredDevice.getIdPush());
            pst.setString(3, unregisteredDevice.getPushMode());
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
     * Alimentation du unregisteredDevice suite au résultat d'une requête.
     * 
     * @param results
     *            résultat de la requête
     * @return unregisteredDevice alimenté
     * @throws SQLException
     *             e
     */
    private static UnregisteredDevice alimenteUnregisteredDevice(
            final ResultSet results) throws SQLException {
        UnregisteredDevice unregisteredDevice = new UnregisteredDevice();
        unregisteredDevice.setIdUnregisteredDevice(results
                .getInt("idUnregisteredDevice"));
        unregisteredDevice.setIdPush(results.getString("idPush"));
        unregisteredDevice.setPushMode(results.getString("pushMode"));
        unregisteredDevice.setOs(results.getString("os"));
        unregisteredDevice.setDateMaj(DateUtils.timestampToDate(results
                .getTimestamp("dateMaj")));
        return unregisteredDevice;
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
     * Supprimer un UnregisteredDevice. Ne ferme pas la connexion.
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
     * Select d'un UnregisteredDevice par idUnregisteredDevice. Ne ferme pas la
     * connexion.
     * 
     * @param idUnregisteredDevice
     *            idUnregisteredDevice
     * @param cnx
     *            connexion
     * @return un UnregisteredDevice si trouvé, sinon null
     * @throws SQLException
     *             exception
     */
    public static UnregisteredDevice findByIdUnregisteredDevice(
            final int idUnregisteredDevice, final Connection cnx)
            throws SQLException {
        LOG.debug("findByIdUnregisteredDevice");

        PreparedStatement pst = null;
        ResultSet results = null;
        UnregisteredDevice unregisteredDevice = null;
        try {

            pst = cnx.prepareStatement(STATEMENTFINDBYID);
            pst.setInt(1, idUnregisteredDevice);

            // execute the query
            results = pst.executeQuery();

            if (results == null) {
                return null;
            }

            if (results.next()) {
                unregisteredDevice = alimenteUnregisteredDevice(results);
            }
            return unregisteredDevice;
        } finally {
            close(results);
            close(pst);
        }

    }

    /**
     * Recherche de tous les unregisteredDevice qui sont à purger. Ne ferme pas
     * la connexion.
     * 
     * @param cnx
     *            connexion
     * @return List des unregisteredDevice si trouvé, sinon null
     * @throws SQLException
     *             exception
     */
    public static List<UnregisteredDevice> findAllToPurge(final Connection cnx)
            throws SQLException {
        LOG.debug("findAllToPurge");

        PreparedStatement pst = null;
        ResultSet results = null;
        List<UnregisteredDevice> list = new ArrayList<UnregisteredDevice>();
        UnregisteredDevice unregisteredDevice;
        try {

            pst = cnx.prepareStatement(STATEMENTFINDALLTOPURGE);

            // execute the query
            results = pst.executeQuery();

            if (results == null) {
                return null;
            }

            while (results.next()) {
                unregisteredDevice = alimenteUnregisteredDevice(results);
                list.add(unregisteredDevice);
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
     * Update d'un UnregisteredDevice. Ne ferme pas la connexion.
     * 
     * @param unregisteredDevice
     *            unregisteredDevice
     * @param cnx
     *            connexion
     * @throws SQLException
     *             exception
     */
    public static void update(final UnregisteredDevice unregisteredDevice,
            final Connection cnx) throws SQLException {
        LOG.debug("update");

        PreparedStatement pst = null;
        ResultSet results = null;

        try {
            pst = cnx.prepareStatement(STATEMENTUPDATE);
            pst.setString(1, unregisteredDevice.getOs());
            pst.setString(2, unregisteredDevice.getIdPush());
            pst.setString(3, unregisteredDevice.getPushMode());
            if (unregisteredDevice.getDateMaj() != null) {
                pst.setTimestamp(4, new Timestamp(unregisteredDevice
                        .getDateMaj().getTime()));
            } else {
                pst.setTimestamp(4, null);
            }
            pst.setInt(5, unregisteredDevice.getIdUnregisteredDevice());

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
    private UnregisteredDeviceDao() {

    }

}
