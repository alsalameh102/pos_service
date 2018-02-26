package fr.asip.mss.filter;

import java.io.ByteArrayInputStream;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.LoggerFactory;

public class X509Passing extends AbstractPassingFilter {

	// LOGGER MSSANTE
	private static final org.slf4j.Logger LOG = LoggerFactory
			.getLogger(X509Passing.class);
	private static final String X509_PASSING_FILTER_NAME = "X509Passing";

	/**
	 * Constructeur qui indique le nom du filtre à la super classe.
	 */
	public X509Passing() {
		filterName = X509_PASSING_FILTER_NAME;
	}

	/**
	 * On transfère le certificat passé dans le header de la requête HTTP dans
	 * ces attributs.
	 */
	@Override
	protected void filterJob(ServletRequest request) {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		LOG.debug("Trying to pass X509");
		String cert = httpRequest.getHeader("ssl_client_cert");
		String verify = httpRequest.getHeader("ssl_client_verify");
		if (cert != null && verify != null) {
			LOG.debug("Certificate : \n\"" + cert + "\"");
			LOG.debug("Verify : " + verify);
			// On vérifie que le certificat est valide
			if (verify.equals("SUCCESS")) {
				LOG.debug("Building cert...");
				cert = processCertString(cert);
				ByteArrayInputStream in = new ByteArrayInputStream(
						cert.getBytes());
				try {
					CertificateFactory cf = CertificateFactory
							.getInstance("X.509");

					LOG.debug("OK");
					LOG.debug("Setting as attribute...");
					// met dans les attributs
					X509Certificate x509[] = new X509Certificate[1];
					x509[0] = (X509Certificate) cf.generateCertificate(in);
					request.setAttribute(
							"javax.servlet.request.X509Certificate", x509);
					LOG.debug("OK");
				} catch (CertificateException e) {
					LOG.error(
							"Le certificat n'a pas pu etre recupere pour le transfert",
							e);
				}
			} else {
				LOG.debug("invalid cert");
			}
		} else {
			LOG.debug("no cert");
		}
	}

	/**
	 * Format un certificat de type string en remplacant les " " non utile en
	 * "\n". Ex :
	 * "-----BEGIN CERTIFICATE----- MIIFZTCCBE2gAwIBAgIDTJcXMA0GCSqGSIb3DQEBBQUAMFExCzAJBgNVBAYTAkZS MQ0wCwYDVQQKEwRURVNUMRswGQYDVQQLExJURVNUIFBST0ZFU1NJT05ORUwxFjAU BgNVBAMTDVRFU1QgQ0xBU1NFLTEwHhcNMTMwNTAxMDAwMDAxWhcNMTYwNTMxMjE1 OTU5WjCBizELMAkGA1UEBhMCRlIxDTALBgNVBAoTBFRFU1QxEDAOBgNVBAsUB03p ZGVjaW4xWzARBgNVBAMTCjAwQjEwNTgxMTAwIgYDVQQEFBtNQVhJTUFYSU1BWElN QVhJTUFYSU1BWDU4MTEwIgYDVQQqFBtNVU1VTVVNVU1VTVVNVU1VTVVNVU1VTVVN VU0wgZ8wDQYJKoZIhvcNAQEBBQADgY0AMIGJAoGBAKmdF3donjSJMVN79iSYpvlQ SRrZhfK4u65Ymul+4dkv6MhTXRduZ0a6E9zLtfHXlS8J4LfKrPVq8QvH1J7d6KpP TWrVm4Lk7tnkHPUdL0Qw8wiS1ePoTpWxwwos4Uvp4NYywTpSnd9T16UVeHaoUpO1 DSwRZtkIOCkhe7FDQ/2pAgMBAAGjggKNMIICiTAfBgNVHSMEGDAWgBR2EDVDtIt/ jG4At5KmkIKzwUvS6jAdBgNVHQ4EFgQUsayv/k/Jp6JYnZ3bpeEa+htaB3gwDgYD VR0PAQH/BAQDAgeAMB8GA1UdJQQYMBYGCCsGAQUFBwMCBgorBgEEAYI3FAICMBkG A1UdIAQSMBAwDgYMKoF6AUcDBwkBAQEBMAkGA1UdEwQCMAAwgb4GA1UdHwSBtjCB szA7oDmgN4Y1aHR0cDovL2FubnVhaXJlLmdpcC1jcHMuZnIvY3JsL3Rlc3QvVEVT VCBDTEFTU0UtMS5jcmwwdKByoHCGbmxkYXA6Ly9hbm51YWlyZS5naXAtY3BzLmZy L2NuPXRlc3QgY2xhc3NlLTEsb3U9dGVzdCBwcm9mZXNzaW9ubmVsLG89dGVzdCxj PWZyP2NlcnRpZmljYXRlcmV2b2NhdGlvbmxpc3Q7YmluYXJ5MHkGA1UdLgRyMHAw bqBsoGqGaGxkYXA6Ly9hbm51YWlyZS5naXAtY3BzLmZyL2NuPXRlc3QgY2xhc3Nl LTEsb3U9dGVzdCBwcm9mZXNzaW9ubmVsLG89dGVzdCxjPWZyP2RlbHRhcmV2b2Nh dGlvbmxpc3Q7YmluYXJ5MDMGA1UdEQQsMCqgKAYKKwYBBAGCNxQCA6AaDBgwLjBC MTA1ODExMEBjYXJ0ZS1jcHMuZnIwEQYJYIZIAYb4QgEBBAQDAgeAMCMGCCqBegFH AQIDBBcTFTgwMjUwMDAwMDEvMjQwMDI0MTQ3MjAPBggqgXoBRwECBQQDBAGAMA8G CCqBegFHAQICBAMCAQAwDwYIKoF6AUcBAgcEAwIBCjAUBggqgXoBRwQCBQQIMAYM BFNNMzYwDQYJKoZIhvcNAQEFBQADggEBAJOWJVKTdQ1nvxfYubUm4MOojFauaPVR cmGb+35zze0dmP4d76TjYG08vmrPl/qaO5XCOrAbd2tU9VXgv5nGCarOABsffYPc gb4/8sMQ96qQGE9u7QMB7jqGNMpqZqnCsC95HI3hEJQyTlEZugEbS5KKhvPRax0d lTm1BN8gE28J2McrOAs5kbQvNe5mvtbcBxo3MFG7yucRfehnoODy13LaCZXjx8RB 4P2EWVBcTX7kYyNTsbZeyZlo7ckJlwICcSHX7sZAh+gZZXjDANRXi8SdqwQnaX6z Ak/tH9gK3qvxfwyPyPkqWunA7BKBUI7ZDugiGl9Ku/lRRFHbPJpAQLc= -----END CERTIFICATE-----"
	 * Devient : "-----BEGIN CERTIFICATE-----\n
	 * "MIIFZTCCBE2gAwIBAgIDTJcXMA0GCSqGSIb3DQEBBQUAMFExCzAJBgNVBAYTAkZS\n" +
	 * "MQ0wCwYDVQQKEwRURVNUMRswGQYDVQQLExJURVNUIFBST0ZFU1NJT05ORUwxFjAU\n" +
	 * "BgNVBAMTDVRFU1QgQ0xBU1NFLTEwHhcNMTMwNTAxMDAwMDAxWhcNMTYwNTMxMjE1\n" +
	 * "OTU5WjCBizELMAkGA1UEBhMCRlIxDTALBgNVBAoTBFRFU1QxEDAOBgNVBAsUB03p\n" +
	 * "ZGVjaW4xWzARBgNVBAMTCjAwQjEwNTgxMTAwIgYDVQQEFBtNQVhJTUFYSU1BWElN\n" +
	 * "QVhJTUFYSU1BWDU4MTEwIgYDVQQqFBtNVU1VTVVNVU1VTVVNVU1VTVVNVU1VTVVN\n" +
	 * "VU0wgZ8wDQYJKoZIhvcNAQEBBQADgY0AMIGJAoGBAKmdF3donjSJMVN79iSYpvlQ\n" +
	 * "SRrZhfK4u65Ymul+4dkv6MhTXRduZ0a6E9zLtfHXlS8J4LfKrPVq8QvH1J7d6KpP\n" +
	 * "TWrVm4Lk7tnkHPUdL0Qw8wiS1ePoTpWxwwos4Uvp4NYywTpSnd9T16UVeHaoUpO1\n" +
	 * "DSwRZtkIOCkhe7FDQ/2pAgMBAAGjggKNMIICiTAfBgNVHSMEGDAWgBR2EDVDtIt/\n" +
	 * "jG4At5KmkIKzwUvS6jAdBgNVHQ4EFgQUsayv/k/Jp6JYnZ3bpeEa+htaB3gwDgYD\n" +
	 * "VR0PAQH/BAQDAgeAMB8GA1UdJQQYMBYGCCsGAQUFBwMCBgorBgEEAYI3FAICMBkG\n" +
	 * "A1UdIAQSMBAwDgYMKoF6AUcDBwkBAQEBMAkGA1UdEwQCMAAwgb4GA1UdHwSBtjCB\n" +
	 * "szA7oDmgN4Y1aHR0cDovL2FubnVhaXJlLmdpcC1jcHMuZnIvY3JsL3Rlc3QvVEVT\n" +
	 * "VCBDTEFTU0UtMS5jcmwwdKByoHCGbmxkYXA6Ly9hbm51YWlyZS5naXAtY3BzLmZy\n" +
	 * "L2NuPXRlc3QgY2xhc3NlLTEsb3U9dGVzdCBwcm9mZXNzaW9ubmVsLG89dGVzdCxj\n" +
	 * "PWZyP2NlcnRpZmljYXRlcmV2b2NhdGlvbmxpc3Q7YmluYXJ5MHkGA1UdLgRyMHAw\n" +
	 * "bqBsoGqGaGxkYXA6Ly9hbm51YWlyZS5naXAtY3BzLmZyL2NuPXRlc3QgY2xhc3Nl\n" +
	 * "LTEsb3U9dGVzdCBwcm9mZXNzaW9ubmVsLG89dGVzdCxjPWZyP2RlbHRhcmV2b2Nh\n" +
	 * "dGlvbmxpc3Q7YmluYXJ5MDMGA1UdEQQsMCqgKAYKKwYBBAGCNxQCA6AaDBgwLjBC\n" +
	 * "MTA1ODExMEBjYXJ0ZS1jcHMuZnIwEQYJYIZIAYb4QgEBBAQDAgeAMCMGCCqBegFH\n" +
	 * "AQIDBBcTFTgwMjUwMDAwMDEvMjQwMDI0MTQ3MjAPBggqgXoBRwECBQQDBAGAMA8G\n" +
	 * "CCqBegFHAQICBAMCAQAwDwYIKoF6AUcBAgcEAwIBCjAUBggqgXoBRwQCBQQIMAYM\n" +
	 * "BFNNMzYwDQYJKoZIhvcNAQEFBQADggEBAJOWJVKTdQ1nvxfYubUm4MOojFauaPVR\n" +
	 * "cmGb+35zze0dmP4d76TjYG08vmrPl/qaO5XCOrAbd2tU9VXgv5nGCarOABsffYPc\n" +
	 * "gb4/8sMQ96qQGE9u7QMB7jqGNMpqZqnCsC95HI3hEJQyTlEZugEbS5KKhvPRax0d\n" +
	 * "lTm1BN8gE28J2McrOAs5kbQvNe5mvtbcBxo3MFG7yucRfehnoODy13LaCZXjx8RB\n" +
	 * "4P2EWVBcTX7kYyNTsbZeyZlo7ckJlwICcSHX7sZAh+gZZXjDANRXi8SdqwQnaX6z\n" +
	 * "Ak/tH9gK3qvxfwyPyPkqWunA7BKBUI7ZDugiGl9Ku/lRRFHbPJpAQLc=\n" +
	 * "-----END CERTIFICATE-----";
	 * 
	 * @param cert
	 *            cert
	 * @return cert adapté à la génération java de certificat
	 */
	private String processCertString(final String cert) {
		if (cert != null) {
			String processedCert = cert;
			processedCert = processedCert.replace(
					"-----BEGIN CERTIFICATE-----", "");
			processedCert = processedCert.replace("-----END CERTIFICATE-----",
					"");
			processedCert = processedCert.trim();
			processedCert = processedCert.replace(" ", "\n");
			StringBuilder strBuilder = new StringBuilder();
			strBuilder.append("-----BEGIN CERTIFICATE-----\n");
			strBuilder.append(processedCert);
			strBuilder.append("\n-----END CERTIFICATE-----");
			return strBuilder.toString();
		}
		return null;
	}

}
