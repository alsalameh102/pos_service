package fr.asip.mss.dao;

import java.util.Date;

/**
 * 
 * Classe réprésentant la table CANAL.
 * 
 */
public class UnregisteredDevice {

    private int idUnregisteredDevice;
    private Date dateMaj;
    private String idPush;
    private String os;
    private String pushMode;

    /**
     * constructeur.
     */
    public UnregisteredDevice() {
    }

    /**
     * @return the idUnregisteredDevice
     */
    public final int getIdUnregisteredDevice() {
        return idUnregisteredDevice;
    }

    /**
     * @param aIdUnregisteredDevice
     *            the idUnregisteredDevice to set
     */
    public final void setIdUnregisteredDevice(final int aIdUnregisteredDevice) {
        idUnregisteredDevice = aIdUnregisteredDevice;
    }

    /**
     * @return the dateMaj
     */
    public final Date getDateMaj() {
        return dateMaj;
    }

    /**
     * @param aDateMaj
     *            the dateMaj to set
     */
    public final void setDateMaj(final Date aDateMaj) {
        dateMaj = aDateMaj;
    }

    /**
     * @return the idPush
     */
    public final String getIdPush() {
        return idPush;
    }

    /**
     * @param aIdPush
     *            the idPush to set
     */
    public final void setIdPush(final String aIdPush) {
        idPush = aIdPush;
    }

    /**
     * @return the os
     */
    public final String getOs() {
        return os;
    }

    /**
     * @param aOs
     *            the os to set
     */
    public final void setOs(final String aOs) {
        os = aOs;
    }

    /**
     * @return the pushMode
     */
    public final String getPushMode() {
        return pushMode;
    }

    /**
     * @param aPushMode
     *            the pushMode to set
     */
    public final void setPushMode(final String aPushMode) {
        pushMode = aPushMode;
    }

}
