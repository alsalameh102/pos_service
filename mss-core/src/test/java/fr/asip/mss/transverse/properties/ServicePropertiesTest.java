package fr.asip.mss.transverse.properties;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fr.asip.mss.exceptions.ErreurFonctionnelleException;

/**
 * Classe de test de InputChecker.
 * 
 */
public class ServicePropertiesTest {

    private static final String ZIMBRAKEYPREAUTH = "mssante.fr:c3c72d0235087e836b7483256819324609def2a0d380104c04baf0d"
            + "2d7db9b41";
    private static final String KEYPREAUTH = "c3c72d0235087e836b7483256819324609def2a0d380104c04baf0d2d7db9b41";
    private static final String NULLKEYPREAUTH = "";
    private static final String MAIL_VALID = "test@mssante.fr";
    private static final String DOMAIN_VALID = "mssante.fr";
    private static final String MAIL_INVALID = "test@inconnu.fr";
    private static final String DOMAIN_INVALID = "inconnu.fr";

    private static ServiceProperties serviceProperties = null;

    /**
     * setup.
     * 
     * @throws Exception
     *             exception
     */
    @Before
    public void setUp() throws Exception {
        if (serviceProperties == null) {
            serviceProperties = new ServiceProperties();
            serviceProperties.setZimbraKeyPreAuth(ZIMBRAKEYPREAUTH);
        }
    }

    /**
     * Test avec un mail valide.
     * 
     */
    @Test
    public void testZimbraKeyPreauthWithValidMail()
            throws ErreurFonctionnelleException {
        Assert.assertEquals(KEYPREAUTH,
                serviceProperties.getZimbraKeyPreAuth(MAIL_VALID));
    }

    /**
     * Test avec un domain valide.
     * 
     */
    @Test
    public void testZimbraKeyPreauthWithValidDomain()
            throws ErreurFonctionnelleException {
        Assert.assertEquals(KEYPREAUTH,
                serviceProperties.getZimbraKeyPreAuth(DOMAIN_VALID));
    }

    /**
     * Test avec un mail invalide.
     * 
     */
    @Test
    public void testZimbraKeyPreauthWithInvalidMail()
            throws ErreurFonctionnelleException {
        Assert.assertEquals(NULLKEYPREAUTH,
                serviceProperties.getZimbraKeyPreAuth(MAIL_INVALID));
    }

    /**
     * Test avec un domain invalide.
     * 
     */
    @Test
    public void testZimbraKeyPreauthWithInvalidDomain()
            throws ErreurFonctionnelleException {
        Assert.assertEquals(NULLKEYPREAUTH,
                serviceProperties.getZimbraKeyPreAuth(DOMAIN_INVALID));
    }

}
