package fr.asip.mss.exceptions;

import javax.xml.bind.annotation.XmlTransient;
import javax.xml.ws.WebFault;

import fr.asip.mss.transverse.enums.CodeErreurFonctionnelle;

/**
 * Classe d'exception correspondant aux erreurs fonctionnelles.
 */
@WebFault(name = "ErreurFonctionnelle")
public class ErreurFonctionnelleException extends Exception {

    private static final long serialVersionUID = -4647449405727420517L;
    private String code;
    private int httpStatus;

    /**
     * Constructeur de l'objet de type ErreurFonctionnelleException.
     */
    public ErreurFonctionnelleException() {
    }

    /**
     * constructeur.
     * 
     * @param codeErreur
     *            codeErreur
     * @param e
     *            exception
     */
    public ErreurFonctionnelleException(
            final CodeErreurFonctionnelle codeErreur, final Exception e) {
        super(codeErreur.getLibelle(), e);
        setCode(codeErreur.getCode());
        setHttpStatus(codeErreur.getHttpStatus());
    }

    /**
     * Constructeur de ErreurFonctionnelleException avec message spécifique et
     * code d'erreur.
     * 
     * @param aCode
     *            le code d'erreur
     * @param aLibelle
     *            message spécifique
     * @param aHttpStatus
     *            le http status de l'erreur
     * @param e
     *            exception
     */
    public ErreurFonctionnelleException(final String aCode,
            final String aLibelle, final int aHttpStatus, final Exception e) {
        super(aLibelle, e);
        setCode(aCode);
        setHttpStatus(aHttpStatus);
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
    @XmlTransient
    public final int getHttpStatus() {
        return httpStatus;
    }

    /**
     * @param aCode
     *            the code to set
     */
    public final void setCode(final String aCode) {
        code = aCode;
    }

    /**
     * @param aHttpStatus
     *            the httpStatus to set
     */
    public final void setHttpStatus(final int aHttpStatus) {
        httpStatus = aHttpStatus;
    }

}
