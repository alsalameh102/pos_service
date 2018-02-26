package fr.asip.mss.dao;

/**
 * 
 * @author JCORTES
 * 
 */
public class Homologation {

    private int idHomologation;
    private String numHomologation;

    /**
     * constructeur.
     */
    public Homologation() {
    }

    /**
     * @return the idHomologation
     */
    public final int getIdHomologation() {
        return idHomologation;
    }

    /**
     * @param aIdHomologation
     *            the idHomologation to set
     */
    public final void setIdHomologation(int aIdHomologation) {
        idHomologation = aIdHomologation;
    }

    /**
     * @return the numHomologation
     */
    public final String getNumHomologation() {
        return numHomologation;
    }

    /**
     * @param aNumHomologation
     *            the numHomologation to set
     */
    public final void setNumHomologation(String aNumHomologation) {
        numHomologation = aNumHomologation;
    }

}
