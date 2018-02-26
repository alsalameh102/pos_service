package fr.asip.mss.filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.LoggerFactory;

public abstract class AbstractPassingFilter implements Filter {

	protected String filterName;

	// LOGGER MSSANTE
	private static final org.slf4j.Logger LOG = LoggerFactory
			.getLogger(AbstractPassingFilter.class);

	@Override
	public void destroy() {
		// callback de destruction de ce filtre
	}

	/**
	 * On transfère le certificat passé dans le header de la requête HTTP dans
	 * ces attributs.
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		LOG.debug("Begin filter {} ...", filterName);
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		logHeaders(request, httpRequest);
		filterJob(httpRequest);

		// propagation de la requête le long de la chaîne
		LOG.debug("Ending...");
		if (chain != null) {
			chain.doFilter(request, response);
		}

	}

	/**
	 * Actual filter job.
	 * 
	 * @param httpRequest
	 *            HttpServletRequest
	 */
	protected abstract void filterJob(ServletRequest request);

	/**
	 * Log les headers de la requete.
	 * 
	 * @param request
	 *            request
	 * @param httpRequest
	 */
	private void logHeaders(ServletRequest request,
			HttpServletRequest httpRequest) {
		if (LOG.isDebugEnabled()) {
			if (request != null) {
				LOG.debug("----------------------Headers----------------------");
				Enumeration<String> headerNames = httpRequest.getHeaderNames();
				while (headerNames.hasMoreElements()) {
					String headerName = headerNames.nextElement();
					LOG.debug("Header Name: " + headerName);
					String headerValue = httpRequest.getHeader(headerName);
					LOG.debug(", Header Value: " + headerValue);
				}
			} else {
				LOG.debug("No Request");
			}
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// l'objet filterConfig encapsule les paramètres
		// d'initialisation de ce filtre
	}

}
