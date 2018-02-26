package fr.asip.mss.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

/**
 * 
 * @author JCORTES
 * 
 */
public final class ConnectionFactory {

    private static DataSource dataSource;

    private static ConnectionFactory connectionFactory = null;

    /**
     * constructeur.
     */
    private ConnectionFactory() {
    }

    /**
     * @return connection
     * @throws SQLException
     *             exception
     */
    public Connection getConnection() throws SQLException {
        Connection conn = dataSource.getConnection();
        return conn;
    }

    /**
     * @return instance de ConnectionFactory
     */
    public static ConnectionFactory getInstance() {
        if (connectionFactory == null) {
            connectionFactory = new ConnectionFactory();
        }
        return connectionFactory;
    }

    /**
     * utilitaire, ferme la ressource sans exception.
     * 
     * @param cnx
     *            connexion
     */
    public static void close(final Connection cnx) {
        // close the connection
        if (cnx != null) {
            try {
                cnx.close();
            } catch (Exception e) {
                // ignore
            }
        }
    }

    /**
     * @param aDataSource
     *            dataSource
     */
    public static void setDataSource(final DataSource aDataSource) {
        ConnectionFactory.dataSource = aDataSource;
    }

}
