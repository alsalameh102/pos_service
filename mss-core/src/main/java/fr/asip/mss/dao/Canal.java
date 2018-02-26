package fr.asip.mss.dao;

import java.util.Date;

/**
 * 
 * Classe réprésentant la table CANAL.
 * 
 */
public class Canal {

    private String canalType;
    private Date dateConnexion;
    private Date dateCreation;
    private Date dateEchec;
    private Date dateMaj;
    private String email;
    private int idCanal;
    private String idMobile;
    private String idPush;
    private String pushMode;
    private int idUtilisateur;
    private int nbEchec;
    private String numTel;
    private String os;
    private String pwd;
    private String statut;
    private String typeChiffrage;

    /**
     * constructeur.
     */
    public Canal() {
    }

    /**
     * @return the canalType
     */
    public final String getCanalType() {
        return canalType;
    }

    /**
     * @return the dateConnexion
     */
    public final Date getDateConnexion() {
        return dateConnexion;
    }

    /**
     * @return the dateCreation
     */
    public final Date getDateCreation() {
        return dateCreation;
    }

    /**
     * @return the dateEchec
     */
    public final Date getDateEchec() {
        return dateEchec;
    }

    /**
     * @return the dateMaj
     */
    public final Date getDateMaj() {
        return dateMaj;
    }

    /**
     * @return the email
     */
    public final String getEmail() {
        return email;
    }

    /**
     * @return the idCanal
     */
    public final int getIdCanal() {
        return idCanal;
    }

    /**
     * @return the idMobile
     */
    public final String getIdMobile() {
        return idMobile;
    }

    /**
     * @return the idPush
     */
    public final String getIdPush() {
        return idPush;
    }

    /**
     * @return the idUtilisateur
     */
    public final int getIdUtilisateur() {
        return idUtilisateur;
    }

    /**
     * @return the nbEchec
     */
    public final int getNbEchec() {
        return nbEchec;
    }

    /**
     * @return the numTel
     */
    public final String getNumTel() {
        return numTel;
    }

    /**
     * @return the os
     */
    public final String getOs() {
        return os;
    }

    /**
     * @return the pwd
     */
    public final String getPwd() {
        return pwd;
    }

    /**
     * @return the statut
     */
    public final String getStatut() {
        return statut;
    }

    /**
     * getTypeChiffrage.
     * 
     * @return typeChiffrage
     */
    public String getTypeChiffrage() {
        return typeChiffrage;
    }

    /**
     * @param aCanalType
     *            the canalType to set
     */
    public final void setCanalType(final String aCanalType) {
        canalType = aCanalType;
    }

    /**
     * @param aDateConnexion
     *            the dateConnexion to set
     */
    public final void setDateConnexion(final Date aDateConnexion) {
        dateConnexion = aDateConnexion;
    }

    /**
     * @param aDateCreation
     *            the dateCreation to set
     */
    public final void setDateCreation(final Date aDateCreation) {
        dateCreation = aDateCreation;
    }

    /**
     * @param aDateEchec
     *            the dateEchec to set
     */
    public final void setDateEchec(final Date aDateEchec) {
        dateEchec = aDateEchec;
    }

    public void setDateMaj(Date dateMaj) {
        this.dateMaj = dateMaj;
    }

    /**
     * @param aEmail
     *            the email to set
     */
    public final void setEmail(final String aEmail) {
        email = aEmail;
    }

    /**
     * @param aIdCanal
     *            the idCanal to set
     */
    public final void setIdCanal(final int aIdCanal) {
        idCanal = aIdCanal;
    }

    /**
     * @param aIdMobile
     *            the idMobile to set
     */
    public final void setIdMobile(final String aIdMobile) {
        idMobile = aIdMobile;
    }

    /**
     * @param aIdPush
     *            the idPush to set
     */
    public final void setIdPush(final String aIdPush) {
        idPush = aIdPush;
    }

    /**
     * @param aIdUtilisateur
     *            the idUtilisateur to set
     */
    public final void setIdUtilisateur(final int aIdUtilisateur) {
        idUtilisateur = aIdUtilisateur;
    }

    /**
     * @param aNbEchec
     *            the nbEchec to set
     */
    public final void setNbEchec(final int aNbEchec) {
        nbEchec = aNbEchec;
    }

    /**
     * @param aNumTel
     *            the numTel to set
     */
    public final void setNumTel(final String aNumTel) {
        numTel = aNumTel;
    }

    /**
     * @param aOs
     *            the os to set
     */
    public final void setOs(final String aOs) {
        os = aOs;
    }

    /**
     * @param aPwd
     *            the pwd to set
     */
    public final void setPwd(final String aPwd) {
        pwd = aPwd;
    }

    /**
     * @param aStatut
     *            the statut to set
     */
    public final void setStatut(final String aStatut) {
        statut = aStatut;
    }

    /**
     * setTypeChiffrage.
     * 
     * @param aTypeChiffrage
     *            typeChiffrage
     */
    public void setTypeChiffrage(final String aTypeChiffrage) {
        typeChiffrage = aTypeChiffrage;
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
