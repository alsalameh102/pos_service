package fr.asip.mss.filter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;

public class X509PassingTest {

    private static final String CERT = "-----BEGIN CERTIFICATE-----\n"
            + "MIIEQTCCAymgAwIBAgIBATANBgkqhkiG9w0BAQUFADCBkzEaMBgGA1UEAxMRTW9u\n"
            + "a2V5IE1hY2hpbmUgQ0ExCzAJBgNVBAYTAlVLMREwDwYDVQQIEwhTY290bGFuZDEQ\n"
            + "MA4GA1UEBxMHR2xhc2dvdzEcMBoGA1UEChMTbW9ua2V5bWFjaGluZS5jby51azEl\n"
            + "MCMGCSqGSIb3DQEJARYWY2FAbW9ua2V5bWFjaGluZS5jby51azAeFw0wNTAzMDYy\n"
            + "MzI4MjJaFw0wNjAzMDYyMzI4MjJaMIGvMQswCQYDVQQGEwJVSzERMA8GA1UECBMI\n"
            + "U2NvdGxhbmQxEDAOBgNVBAcTB0dsYXNnb3cxGzAZBgNVBAoTEk1vbmtleSBNYWNo\n"
            + "aW5lIEx0ZDElMCMGA1UECxMcT3BlbiBTb3VyY2UgRGV2ZWxvcG1lbnQgTGFiLjEU\n"
            + "MBIGA1UEAxMLTHVrZSBUYXlsb3IxITAfBgkqhkiG9w0BCQEWEmx1a2VAbW9ua2V5\n"
            + "bWFjaGluZTBcMA0GCSqGSIb3DQEBAQUAA0sAMEgCQQDItxZr07mm65ttYH7RMaVo\n"
            + "VeMCq4ptfn+GFFEk4+54OkDuh1CHlk87gEc1jx3ZpQPJRTJx31z3YkiAcP+RDzxr\n"
            + "AgMBAAGjggFIMIIBRDAJBgNVHRMEAjAAMBEGCWCGSAGG+EIBAQQEAwIHgDALBgNV\n"
            + "HQ8EBAMCBeAwHQYDVR0OBBYEFG7mW1czzw4vFcL03+wUvvvPVFY8MIHABgNVHSME\n"
            + "gbgwgbWAFKt47K8QG4qbH8exJY8WKPIXmq02oYGZpIGWMIGTMRowGAYDVQQDExFN\n"
            + "b25rZXkgTWFjaGluZSBDQTELMAkGA1UEBhMCVUsxETAPBgNVBAgTCFNjb3RsYW5k\n"
            + "MRAwDgYDVQQHEwdHbGFzZ293MRwwGgYDVQQKExNtb25rZXltYWNoaW5lLmNvLnVr\n"
            + "MSUwIwYJKoZIhvcNAQkBFhZjYUBtb25rZXltYWNoaW5lLmNvLnVrggEAMDUGCWCG\n"
            + "SAGG+EIBBAQoFiZodHRwczovL21vbmtleW1hY2hpbmUuY28udWsvY2EtY3JsLnBl\n"
            + "bTANBgkqhkiG9w0BAQUFAAOCAQEAZ961bEgm2rOq6QajRLeoljwXDnt0S9BGEWL4\n"
            + "PMU2FXDog9aaPwfmZ5fwKaSebwH4HckTp11xwe/D9uBZJQ74Uf80UL9z2eo0GaSR\n"
            + "nRB3QPZfRvop0I4oPvwViKt3puLsi9XSSJ1w9yswnIf89iONT7ZyssPg48Bojo8q\n"
            + "lcKwXuDRBWciODK/xWhvQbaegGJ1BtXcEHtvNjrUJLwSMDSr+U5oUYdMohG0h1iJ\n"
            + "R+JQc49I33o2cTc77wfEWLtVdXAyYY4GSJR6VfgvV40x85ItaNS3HHfT/aXU1x4m\n"
            + "W9YQkWlA6t0blGlC+ghTOY1JbgWnEfXMmVgg9a9cWaYQ+NQwqA==\n"
            + "-----END CERTIFICATE-----";
    private static final String FAILED = "FAILED";

    private static final String SUCCESS = "SUCCESS";
    private static final String WRONG_CERT = "wrong_value";
    private X509Passing filter;
    private HttpServletRequest request;

    @Before
    public void init() {
        filter = new X509Passing();
        request = new MockHttpServletRequest();
    }

    /**
     * Quand le header SSL_CLIENT_VERIFY est null. Rien ne se passe
     * 
     * @throws ServletException
     *             e
     * @throws IOException
     *             e
     */
    @Test
    public void test01() throws IOException, ServletException {
        // l'attribut SS_client_VERIFY n'existe pas
        ((MockHttpServletRequest) request).addHeader("SSL_CLIENT_CERT", CERT);
        filter.doFilter(request, null, null);
        // Rien ne se passe
        assertNull(request
                .getAttribute("javax.servlet.request.X509Certificate"));
    }

    /**
     * Quand le header SSL_CLIENT_VERIFY != SUCCESS
     * 
     * @throws ServletException
     *             e
     * @throws IOException
     *             e
     */
    @Test
    public void test02() throws IOException, ServletException {
        ((MockHttpServletRequest) request).addHeader("SSL_CLIENT_VERIFY",
                FAILED);
        // l'attribut SS_client_CERT n'existe pas
        filter.doFilter(request, null, null);
        // Rien ne se passe
        assertNull(request
                .getAttribute("javax.servlet.request.X509Certificate"));
    }

    /**
     * Quand le header SSL_CLIENT_CERT n'existe pas (SSL_CLIENT_VERIFY ==
     * SUCCESS). Rien ne se passe
     * 
     * @throws ServletException
     *             e
     * @throws IOException
     *             e
     */
    @Test
    public void test03() throws IOException, ServletException {
        ((MockHttpServletRequest) request).addHeader("SSL_CLIENT_VERIFY",
                SUCCESS);
        // l'attribut SS_client_CERT n'existe pas
        filter.doFilter(request, null, null);
        // Rien ne se passe
        assertNull(request
                .getAttribute("javax.servlet.request.X509Certificate"));
    }

    /**
     * Quand le header SSL_CLIENT_CERT est une chaine vide (SSL_CLIENT_VERIFY ==
     * SUCCESS). Rien ne se passe
     * 
     * @throws ServletException
     *             e
     * @throws IOException
     *             e
     */
    @Test
    public void test04() throws IOException, ServletException {
        ((MockHttpServletRequest) request).addHeader("SSL_CLIENT_VERIFY",
                SUCCESS);
        ((MockHttpServletRequest) request).addHeader("SSL_CLIENT_CERT", "");
        filter.doFilter(request, null, null);
        // Rien ne se passe
        assertNull(request
                .getAttribute("javax.servlet.request.X509Certificate"));
    }

    /**
     * Quand le header SSL_CLIENT_CERT n'est pas un certificat
     * (SSL_CLIENT_VERIFY == SUCCESS). Rien ne se passe
     * 
     * @throws ServletException
     *             e
     * @throws IOException
     *             e
     */
    @Test
    public void test05() throws IOException, ServletException {
        ((MockHttpServletRequest) request).addHeader("SSL_CLIENT_VERIFY",
                SUCCESS);
        ((MockHttpServletRequest) request).addHeader("SSL_CLIENT_CERT",
                WRONG_CERT);
        filter.doFilter(request, null, null);
        // Rien ne se passe
        assertNull(request
                .getAttribute("javax.servlet.request.X509Certificate"));
    }

    /**
     * Quand le header SSL_CLIENT_CERT OK (SSL_CLIENT_VERIFY == SUCCESS)
     * 
     * @throws ServletException
     *             e
     * @throws IOException
     *             e
     * @throws CertificateException
     *             e
     */
    @Test
    public void test06() throws IOException, ServletException,
            CertificateException {
        ((MockHttpServletRequest) request).addHeader("SSL_CLIENT_VERIFY",
                SUCCESS);
        ((MockHttpServletRequest) request).addHeader("SSL_CLIENT_CERT", CERT);
        filter.doFilter(request, null, null);

        X509Certificate x509[] = (X509Certificate[]) request
                .getAttribute("javax.servlet.request.X509Certificate");
        ByteArrayInputStream in = new ByteArrayInputStream(CERT.getBytes());
        CertificateFactory cf = CertificateFactory.getInstance("X.509");

        assertEquals(cf.generateCertificate(in), x509[0]);
    }
}
