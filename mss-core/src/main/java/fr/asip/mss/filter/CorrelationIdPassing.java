package fr.asip.mss.filter;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

/**
 * Ajoute un UID dans le thread local de log4j.
 * 
 */
public class CorrelationIdPassing extends AbstractPassingFilter {

	private static final String CORRELATION_ID_PASSING_FILTER_NAME = "CorrelationIdPassing";
	private static final String NO_CORRELATION_ID = "{NO_CORRELATION_ID}";
	private static final String NULL_HEADER_APACHE = "(null)";

	/**
	 * Constructeur qui indique à la super classe le non du filtre.
	 */
	public CorrelationIdPassing() {
		filterName = CORRELATION_ID_PASSING_FILTER_NAME;
	}

	// LOGGER MSSANTE
	private static final org.slf4j.Logger LOG = LoggerFactory
			.getLogger(CorrelationIdPassing.class);

	/**
	 * Surcharge pour nettoyer MDC.
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		try {
			super.doFilter(request, response, chain);
		} finally {
			MDC.clear();
		}
	}

	/**
	 * On transfère le certificat passé dans le header de la requête HTTP dans
	 * ces attributs.
	 */
	@Override
	protected void filterJob(ServletRequest request) {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String requestCorrelationId = httpRequest
				.getHeader("REQUEST_CORRELATION_ID");
		LOG.debug("Trying to pass REQUEST_CORRELATION_ID {}",
				requestCorrelationId);

		try {
			if (isNotBlank(requestCorrelationId)
					&& !NULL_HEADER_APACHE.equals(requestCorrelationId)) {
				LOG.debug(
						"Adding to REQUEST_CORRELATION_ID  : {} to LOG4J Threadlocal...",
						requestCorrelationId);
				MDC.put("request_correlation_id", "{" + requestCorrelationId
						+ "}");
			} else {
				LOG.debug(
						"No REQUEST_CORRELATION_ID, adding \"{}\" to LOG4J Threadlocal...",
						NO_CORRELATION_ID);
				MDC.put("request_correlation_id", NO_CORRELATION_ID);
			}
		} catch (Throwable e) {
			LOG.debug(e.getLocalizedMessage(), e);
		}
	}
}
