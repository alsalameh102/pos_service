package fr.asip.mss.dao;


/**
 * 
 * Classe représentant la table en BDD Notification.
 * 
 */
public class Notification {

    private int activated;
    private String email;
    private int idCanal;
    private int idNotification;

    /**
     * constructeur.
     */
    public Notification() {
    }

    /**
     * getActivated.
     * 
     * @return activated
     */
    public int getActivated() {
        return activated;
    }

    /**
     * aDateMaj.
     * 
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * getIdCanal.
     * 
     * @return idCanal
     */
    public int getIdCanal() {
        return idCanal;
    }

    /**
     * getIdNotification.
     * 
     * @return idNotification
     */
    public int getIdNotification() {
        return idNotification;
    }

    /**
     * setActivated.
     * 
     * @param aActivated
     *            aActivated
     */
    public void setActivated(final int aActivated) {
        activated = aActivated;
    }

    /**
     * setEmail.
     * 
     * @param aEmail
     *            aEmail
     */
    public void setEmail(final String aEmail) {
        email = aEmail;
    }

    /**
     * setIdCanal.
     * 
     * @param aIdCanal
     *            aIdCanal
     */
    public void setIdCanal(final int aIdCanal) {
        idCanal = aIdCanal;
    }

    /**
     * setIdNotification.
     * 
     * @param aIdNotification
     *            aIdNotification
     */
    public void setIdNotification(final int aIdNotification) {
        idNotification = aIdNotification;
    }

}
