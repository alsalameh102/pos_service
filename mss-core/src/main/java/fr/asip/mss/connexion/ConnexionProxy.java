package fr.asip.mss.connexion;

import org.apache.cxf.configuration.jsse.TLSClientParameters;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;

/**
 * Cette classe permet de modifier le timeout des appels aux sous-système.
 */
public final class ConnexionProxy {

    /**
     * @param service
     *            le service
     * @param connectionTimeout
     *            la durée du timeout pour la connexion
     * @param receiveTimeout
     *            la durée du timeout pour la reception d'une réponse
     */
    public static void initProxyService(final Object service,
            final Long connectionTimeout, final Long receiveTimeout) {
        final HTTPClientPolicy clientPolicy = new HTTPClientPolicy();
        clientPolicy.setConnectionTimeout(connectionTimeout);
        clientPolicy.setReceiveTimeout(receiveTimeout);

        final Client client = ClientProxy.getClient(service);
        final HTTPConduit httpConduit = (HTTPConduit) client.getConduit();
        httpConduit.setClient(clientPolicy);
    }

    /**
     * @param service
     *            le service
     * @param connectionTimeout
     *            la durée du timeout pour la connexion
     * @param receiveTimeout
     *            la durée du timeout pour la reception d'une réponse
     */
    public static void initProxyServiceSsl(final Object service,
            final Long connectionTimeout, final Long receiveTimeout) {
        final HTTPClientPolicy clientPolicy = new HTTPClientPolicy();
        clientPolicy.setConnectionTimeout(connectionTimeout);
        clientPolicy.setReceiveTimeout(receiveTimeout);

        final Client client = ClientProxy.getClient(service);
        final HTTPConduit httpConduit = (HTTPConduit) client.getConduit();
        final TLSClientParameters tlsParams = new TLSClientParameters();
        tlsParams.setDisableCNCheck(true);

        httpConduit.setTlsClientParameters(tlsParams);
        httpConduit.setClient(clientPolicy);
    }

    /**
     * Constructeur privé (car classe utilitaire).
     */
    private ConnexionProxy() {
    }
}
