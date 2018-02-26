package fr.asip.mss.dao;

import java.util.Date;

/**
 * 
 * @author JCORTES
 * 
 */
public class Utilisateur {

    private int idUtilisateur;
    private String idNat;
    private String nom;
    private String prenom;
    private String mail;
    private String profession;
    private String typeUtilisateur;
    private Date lastAccessDatetime;
    private int statut;

    /**
     * constructeur.
     */
    public Utilisateur() {

    }

    /**
     * @return the idUtilisateur
     */
    public final int getIdUtilisateur() {
        return idUtilisateur;
    }

    /**
     * @param aIdUtilisateur
     *            the idUtilisateur to set
     */
    public final void setIdUtilisateur(final int aIdUtilisateur) {
        idUtilisateur = aIdUtilisateur;
    }

    /**
     * @return the idNat
     */
    public final String getIdNat() {
        return idNat;
    }

    /**
     * @param aIdNat
     *            the idNat to set
     */
    public final void setIdNat(final String aIdNat) {
        idNat = aIdNat;
    }

    /**
     * @return the nom
     */
    public final String getNom() {
        return nom;
    }

    /**
     * @param aNom
     *            the nom to set
     */
    public final void setNom(final String aNom) {
        nom = aNom;
    }

    /**
     * @return the prenom
     */
    public final String getPrenom() {
        return prenom;
    }

    /**
     * @param aPrenom
     *            the prenom to set
     */
    public final void setPrenom(final String aPrenom) {
        prenom = aPrenom;
    }

    /**
     * @return the mail
     */
    public final String getMail() {
        return mail;
    }

    /**
     * @param aMail
     *            the mail to set
     */
    public final void setMail(final String aMail) {
        mail = aMail;
    }

    /**
     * @return the profession
     */
    public final String getProfession() {
        return profession;
    }

    /**
     * @param aProfession
     *            the profession to set
     */
    public final void setProfession(final String aProfession) {
        profession = aProfession;
    }

    /**
     * @return the typeUtilisateur
     */
    public final String getTypeUtilisateur() {
        return typeUtilisateur;
    }

    /**
     * @param aTypeUtilisateur
     *            the typeUtilisateur to set
     */
    public final void setTypeUtilisateur(final String aTypeUtilisateur) {
        typeUtilisateur = aTypeUtilisateur;
    }

    /**
     * @return the statut
     */
    public final int getStatut() {
        return statut;
    }

    /**
     * @param aStatut
     *            the statut to set
     */
    public final void setStatut(final int aStatut) {
        statut = aStatut;
    }

    /**
     *  @return date de derniere connexion
     */
    public Date getLastAccessDatetime() {
        return lastAccessDatetime;
    }

    /**
     * @param lastAccessDatetime date de derniere connexion
     */
    public void setLastAccessDatetime(Date lastAccessDatetime) {
        this.lastAccessDatetime = lastAccessDatetime;
    }

}
