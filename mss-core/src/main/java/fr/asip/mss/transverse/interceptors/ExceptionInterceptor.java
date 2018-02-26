package fr.asip.mss.transverse.interceptors;

import java.io.ByteArrayInputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.interceptor.AbstractSoapInterceptor;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.Phase;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class ExceptionInterceptor extends AbstractSoapInterceptor {

	public ExceptionInterceptor() {
		super(Phase.PRE_LOGICAL);
	}

	public void handleMessage(SoapMessage message) throws Fault {
		Fault fault = (Fault) message.getContent(Exception.class);
		Throwable ex = fault.getCause();
		String msg = fault.getMessage();

		if (msg.startsWith("Unmarshalling Error:")) {
			fault.setMessage("Un des champs a un format invalide");

			try {
				DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
				dbf.setNamespaceAware(true);
				DocumentBuilder db = dbf.newDocumentBuilder();

				String errorXML = "<ns1:ErreurFonctionnelle xmlns:ns1=\"http://services.msg.mss.asip.fr/\"><code xmlns:ns2=\"http://services.msg.mss.asip.fr/\">36</code></ns1:ErreurFonctionnelle>";
				String xml = "<detail>" + errorXML.toString() + "</detail>"; //stringWriter.toString()
				Document doc = db.parse(new ByteArrayInputStream(xml.getBytes()));

				Element elt = doc.getDocumentElement();
				fault.setDetail(elt);
			} catch (Exception e1) {
				System.out.println("Cannot build detail element: " + e1.getMessage());
			}
		}

	}

}
