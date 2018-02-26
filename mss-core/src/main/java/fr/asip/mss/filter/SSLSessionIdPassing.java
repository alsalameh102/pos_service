package fr.asip.mss.filter;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.LoggerFactory;

public class SSLSessionIdPassing extends AbstractPassingFilter {

	// LOGGER MSSANTE
	private static final org.slf4j.Logger LOG = LoggerFactory
			.getLogger(SSLSessionIdPassing.class);

	private static final String SSL_SESSION_ID_PASSING_FILTER_NAME = "SSLSessionIdPassing";

	/**
	 * Constructeur indiquand à la super classe le nom du filtre.
	 */
	public SSLSessionIdPassing() {
		filterName = SSL_SESSION_ID_PASSING_FILTER_NAME;
	}

	/**
	 * On transfère le certificat passé dans le header de la requête HTTP dans
	 * ces attributs.
	 */
	@Override
	protected void filterJob(ServletRequest request) {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String sslSessionId = httpRequest.getHeader("ssl_session_id");
		LOG.debug("Trying to pass SSL_SESSION_ID {}", sslSessionId);

		if (sslSessionId != null && !sslSessionId.trim().isEmpty()) {
			LOG.debug("Adding SSL_SESSION_ID : {} to request  attribute",
					sslSessionId);
			request.setAttribute("javax.servlet.request.ssl_session_id",
					sslSessionId);
		} else {
			LOG.debug("No SSL_SESSION_ID");
		}
	}
}
