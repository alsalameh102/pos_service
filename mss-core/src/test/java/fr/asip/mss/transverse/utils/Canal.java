package fr.asip.mss.transverse.utils;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Bean Canal pour test conversion JSON.
 */
@XmlRootElement(name = "canal")
public class Canal {

    private String idCanal;

    /**
     * @return the idCanal
     */
    public final String getIdCanal() {
        return idCanal;
    }

    /**
     * @param aIdCanal
     *            the idCanal to set
     */
    public final void setIdCanal(final String aIdCanal) {
        idCanal = aIdCanal;
    }

}
