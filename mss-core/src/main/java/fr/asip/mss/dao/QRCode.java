package fr.asip.mss.dao;

import java.util.Date;

/**
 * 
 * @author JCORTES
 * 
 */
public class QRCode {

    private int idQRCode;
    private String idNat;
    private String nom;
    private String prenom;
    private String profession;
    private String typeUtilisateur;
    private String codeAppareillement;
    private Date dateCreation;

    /**
     * constructeur.
     */
    public QRCode() {
    }

    /**
     * @return the idQRCode
     */
    public final int getIdQRCode() {
        return idQRCode;
    }

    /**
     * @param aIdQRCode
     *            the idQRCode to set
     */
    public final void setIdQRCode(final int aIdQRCode) {
        idQRCode = aIdQRCode;
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
     * @return the codeAppareillement
     */
    public final String getCodeAppareillement() {
        return codeAppareillement;
    }

    /**
     * @param aCodeAppareillement
     *            the codeAppareillement to set
     */
    public final void setCodeAppareillement(final String aCodeAppareillement) {
        codeAppareillement = aCodeAppareillement;
    }

    /**
     * @return the dateCreation
     */
    public final Date getDateCreation() {
        return dateCreation;
    }

    /**
     * @param aDateCreation
     *            the dateCreation to set
     */
    public final void setDateCreation(final Date aDateCreation) {
        dateCreation = aDateCreation;
    }

}
