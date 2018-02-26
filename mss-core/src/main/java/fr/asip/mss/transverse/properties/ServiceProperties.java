package fr.asip.mss.transverse.properties;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Classe permettant d'accéder aux données d'appel services externalisées en
 * properties.
 */
public class ServiceProperties implements Serializable {

    private static final long serialVersionUID = 3461611176430392619L;

    private Integer annuaireConnectionTimeout;
    private Long annuaireReceiveTimeout;
    private Long authPrivateConnectionTimeout;
    private Long authPrivateReceiveTimeout;
    private String endpointSopraRechercherAnnuaire;

    private String endpointSopraRecupereBal;

    private boolean securedDownload;

    private String serviceZimbraDownloadFile;

    private String servletUploadFile;

    private Long zimbraAuthValidTime;

    private Long zimbraConnectionTimeout;

    private final Map<String, String> zimbraKeyPreAuth = new HashMap<String, String>();

    private Long zimbraReceiveTimeout;

    /**
     * @return the annuaireConnectionTimeout
     */
    public Integer getAnnuaireConnectionTimeout() {
        return annuaireConnectionTimeout;
    }

    /**
     * @return the annuaireReceiveTimeout
     */
    public Long getAnnuaireReceiveTimeout() {
        return annuaireReceiveTimeout;
    }

    /**
     * @return the authPrivateConnectionTimeout
     */
    public final Long getAuthPrivateConnectionTimeout() {
        return authPrivateConnectionTimeout;
    }

    /**
     * @return the authPrivateReceiveTimeout
     */
    public final Long getAuthPrivateReceiveTimeout() {
        return authPrivateReceiveTimeout;
    }

    /**
     * getEndpointSopraRechercherAnnuaire.
     * 
     * @return endpointSopraRechercherAnnuaire
     */
    public String getEndpointSopraRechercherAnnuaire() {
        return endpointSopraRechercherAnnuaire;
    }

    /**
     * @return the endpointSopraRecupereBal
     */
    public final String getEndpointSopraRecupereBal() {
        return endpointSopraRecupereBal;
    }

    /**
     * @return the serviceZimbraDownloadFile
     */
    public String getServiceZimbraDownloadFile() {
        return serviceZimbraDownloadFile;
    }

    /**
     * @return the servletUploadFile
     */
    public String getServletUploadFile() {
        return servletUploadFile;
    }

    /**
     * @return the zimbraAuthValidTime
     */
    public final Long getZimbraAuthValidTime() {
        return zimbraAuthValidTime;
    }

    /**
     * @return the zimbraConnectionTimeout
     */
    public final Long getZimbraConnectionTimeout() {
        return zimbraConnectionTimeout;
    }

    /**
     * Retourne la clé zimbra pour le domaine passé en paramètre.
     * 
     * @param mailOrDomain
     *            mail ou domaine
     * @return the zimbraKeyPreAuth
     */
    public final String getZimbraKeyPreAuth(final String mailOrDomain) {
        String res = null;
        if (mailOrDomain != null) {
            int pos = mailOrDomain.indexOf("@");
            if (pos > -1) {
                res = zimbraKeyPreAuth.get(mailOrDomain.substring(pos + 1));
            } else {
                res = zimbraKeyPreAuth.get(mailOrDomain);
            }
        }
        if (res == null) {
            res = "";
        }
        return res;
    }

    /**
     * @return the zimbraReceiveTimeout
     */
    public final Long getZimbraReceiveTimeout() {
        return zimbraReceiveTimeout;
    }

    /**
     * @return the securedDownload
     */
    public boolean isSecuredDownload() {
        return securedDownload;
    }

    /**
     * @param aAnnuaireConnectionTimeout
     */
    public void setAnnuaireConnectionTimeout(
            final Integer aAnnuaireConnectionTimeout) {
        this.annuaireConnectionTimeout = aAnnuaireConnectionTimeout;
    }

    /**
     * @param aAnnuaireReceiveTimeout
     */
    public void setAnnuaireReceiveTimeout(final Long aAnnuaireReceiveTimeout) {
        this.annuaireReceiveTimeout = aAnnuaireReceiveTimeout;
    }

    /**
     * @param aAuthPrivateConnectionTimeout
     *            the authPrivateConnectionTimeout to set
     */
    public final void setAuthPrivateConnectionTimeout(
            final Long aAuthPrivateConnectionTimeout) {
        authPrivateConnectionTimeout = aAuthPrivateConnectionTimeout;
    }

    /**
     * @param aAuthPrivateReceiveTimeout
     *            the authPrivateReceiveTimeout to set
     */
    public final void setAuthPrivateReceiveTimeout(
            final Long aAuthPrivateReceiveTimeout) {
        authPrivateReceiveTimeout = aAuthPrivateReceiveTimeout;
    }

    /**
     * setEndpointSopraRechercherAnnuaire.
     * 
     * @param endpointSopraRechercherAnnuaire
     *            endpointSopraRechercherAnnuaire
     */
    public void setEndpointSopraRechercherAnnuaire(
            String endpointSopraRechercherAnnuaire) {
        this.endpointSopraRechercherAnnuaire = endpointSopraRechercherAnnuaire;
    }

    /**
     * @param aEndpointSopraRecupereBal
     *            the endpointSopraRecupereBal to set
     */
    public final void setEndpointSopraRecupereBal(
            final String aEndpointSopraRecupereBal) {
        endpointSopraRecupereBal = aEndpointSopraRecupereBal;
    }

    /**
     * @param securedDownload
     *            the securedDownload to set
     */
    public void setSecuredDownload(final boolean securedDownload) {
        this.securedDownload = securedDownload;
    }

    /**
     * @param serviceZimbraDownloadFile
     *            the serviceZimbraDownloadFile to set
     */
    public void setServiceZimbraDownloadFile(
            final String serviceZimbraDownloadFile) {
        this.serviceZimbraDownloadFile = serviceZimbraDownloadFile;
    }

    /**
     * @param servletUploadFile
     *            the servletUploadFile to set
     */
    public void setServletUploadFile(final String servletUploadFile) {
        this.servletUploadFile = servletUploadFile;
    }

    /**
     * @param aZimbraAuthValidTime
     *            the zimbraAuthValidTime to set
     */
    public final void setZimbraAuthValidTime(final Long aZimbraAuthValidTime) {
        zimbraAuthValidTime = aZimbraAuthValidTime;
    }

    /**
     * @param aZimbraConnectionTimeout
     *            the zimbraConnectionTimeout to set
     */
    public final void setZimbraConnectionTimeout(
            final Long aZimbraConnectionTimeout) {
        zimbraConnectionTimeout = aZimbraConnectionTimeout;
    }

    /**
     * @param aZimbraKeyPreAuth
     *            the zimbraKeyPreAuth to set
     */
    public final void setZimbraKeyPreAuth(final String aZimbraKeyPreAuth) {
        if (aZimbraKeyPreAuth != null) {
            String[] keys = aZimbraKeyPreAuth.split(",");
            for (String key : keys) {
                String[] keyPreAuth = key.split(":");
                if (keyPreAuth.length == 2) {
                    zimbraKeyPreAuth.put(keyPreAuth[0].trim(),
                            keyPreAuth[1].trim());
                }
            }
        }
    }

    /**
     * @param aZimbraReceiveTimeout
     *            the zimbraReceiveTimeout to set
     */
    public final void setZimbraReceiveTimeout(final Long aZimbraReceiveTimeout) {
        zimbraReceiveTimeout = aZimbraReceiveTimeout;
    }

}
