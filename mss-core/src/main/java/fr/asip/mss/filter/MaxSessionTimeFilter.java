package fr.asip.mss.filter;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.net.InternetDomainName;

/**
 * 
 * @author JCORTES
 * 
 */
public class MaxSessionTimeFilter implements Filter {

	// 4h en millisecondes
	private static final String MAX_SESSION_TIME_PARAMETER = "MAX_SESSION_TIME";
	private static final int MAX_SESSION_TIME_DEFAULT = 14400000;
	private static int maxSessionTime = 0;

	private static final Logger LOG = LoggerFactory
			.getLogger(MaxSessionTimeFilter.class);

	@Override
	public void init(final FilterConfig filterConfig) {
		// l'objet filterConfig encapsule les paramètres
		// d'initialisation de ce filtre
		if (filterConfig != null) {
			String maxSessionTimeValue = filterConfig
					.getInitParameter(MAX_SESSION_TIME_PARAMETER);
			if (maxSessionTimeValue != null) {
				maxSessionTime = Integer.parseInt(maxSessionTimeValue);
			} else {
				maxSessionTime = MAX_SESSION_TIME_DEFAULT;
			}
		} else {
			maxSessionTime = MAX_SESSION_TIME_DEFAULT;
		}
	}

	@Override
	public void destroy() {
		// callback de destruction de ce filtre
	}

	@Override
	public void doFilter(final ServletRequest request,
			final ServletResponse response, final FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;

		HttpSession session = httpRequest.getSession(false);
		if (session != null && !session.isNew() && maxSessionTime > 0) {
			if (System.currentTimeMillis() > session.getCreationTime()
					+ maxSessionTime) {
				LOG.debug("Fin de session. RemoteAddr={}",
						request.getRemoteAddr());
				session.invalidate();
				eraseCookie(httpRequest, httpResponse);
				httpResponse.sendRedirect(httpRequest.getRequestURI());
				return;
			}
		}

		// propagation de la requête le long de la chaîne
		filterChain.doFilter(request, response);
	}

	/**
	 * 
	 * @param req
	 *            request
	 * @param resp
	 *            response
	 */
	private void eraseCookie(final HttpServletRequest req,
			final HttpServletResponse resp) {
		String domain = null;
		try {
			URI uri = new URI(req.getRequestURL().toString());
			domain = InternetDomainName.from(uri.getHost()).topPrivateDomain()
					.toString();
		} catch (URISyntaxException e) {
			LOG.debug(e.getMessage(), e);
		}

		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				cookie.setValue("");
				cookie.setPath("/");
				if (domain != null) {
					cookie.setDomain(domain);
				}
				cookie.setMaxAge(0);
				resp.addCookie(cookie);
			}
		}
	}

}
