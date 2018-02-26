package fr.asip.mss.transverse.enums;

/**
 * Enumérateur contenant les code d'erreur technique.
 */
public enum CodeErreurTechnique {

    /** Declaration des erreurs techniques. **/
    TEC1("1", "Erreur technique", 500),
    TEC2("2", "Acces BDD en erreur", 500),
    TEC3("3", "Acces Zimbra en erreur", 500);

    /**
     * Récupère une valeur de l'enum corrspondant a une String passée en
     * paramètre
     * 
     * @param code
     *            le code a trouver
     * @return CodeErreurFonctionnelle
     */
    public static final CodeErreurTechnique getByCode(final String code) {
        if (code != null) {
            for (CodeErreurTechnique b : CodeErreurTechnique.values()) {
                if (code.equalsIgnoreCase(b.code)) {
                    return b;
                }
            }
        }
        return null;
    }

    /** Le code associé à l'erreur. **/
    private String code;
    /** Le http status associé à l'erreur. **/
    private int httpStatus;

    /** Le libelle associé à l'erreur. **/
    private String libelle;

    /**
     * Le constructeur.
     * 
     * @param aCode
     *            le code de l'erreur technique
     * @param aLibelle
     *            le libelle de l'erreur technique
     * @param aHttpStatus
     *            le http status de l'erreur technique
     */
    private CodeErreurTechnique(final String aCode, final String aLibelle,
            final int aHttpStatus) {
        this.code = aCode;
        this.libelle = aLibelle;
        this.httpStatus = aHttpStatus;
    }

    /**
     * @return the code
     */
    public final String getCode() {
        return code;
    }

    /**
     * @return the httpStatus
     */
    public final int getHttpStatus() {
        return httpStatus;
    }

    /**
     * @return the libelle
     */
    public final String getLibelle() {
        return libelle;
    }

}
