package fr.asip.mss.filter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.io.IOException;
import java.security.cert.CertificateException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;

public class SSLSessionIdPassingTest {

    private final String attributeSessionId = "javax.servlet.request.ssl_session_id";
    private SSLSessionIdPassing filter;
    private final String headerSessionId = "ssl_session_id";
    private HttpServletRequest request;
    private final String sessionId = "12345";

    @Before
    public void init() {
        filter = new SSLSessionIdPassing();
        request = new MockHttpServletRequest();
    }

    /**
     * Quand le header SSL_SESSION_ID est null. Rien ne se passe
     * 
     * @throws ServletException
     *             e
     * @throws IOException
     *             e
     */
    @Test
    public void test01() throws IOException, ServletException {
        // l'attribut SSL_SESSION_ID n'existe pas
        filter.doFilter(request, null, null);
        // Rien ne se passe
        assertNull(request.getAttribute(attributeSessionId));
    }

    /**
     * Quand le header SSL_SESSION_ID est une chaine vide. Rien ne se passe
     * 
     * @throws ServletException
     *             e
     * @throws IOException
     *             e
     */
    @Test
    public void test02() throws IOException, ServletException {
        assertNull(request.getHeader(headerSessionId));
        ((MockHttpServletRequest) request).addHeader(headerSessionId, "");
        assertEquals("", request.getHeader(headerSessionId));
        filter.doFilter(request, null, null);
        // Rien ne se passe
        assertNull(request.getAttribute(attributeSessionId));
    }

    /**
     * Quand le header SSL_SESSION_ID OK
     * 
     * @throws ServletException
     *             e
     * @throws IOException
     *             e
     * @throws CertificateException
     *             e
     */
    @Test
    public void test03() throws IOException, ServletException,
            CertificateException {
        ((MockHttpServletRequest) request)
                .addHeader(headerSessionId, sessionId);
        filter.doFilter(request, null, null);

        String sslSessionId = (String) request.getAttribute(attributeSessionId);
        assertEquals(sessionId, sslSessionId);
    }
}
