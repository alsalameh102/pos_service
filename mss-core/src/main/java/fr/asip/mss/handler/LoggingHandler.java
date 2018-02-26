package fr.asip.mss.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by A627488 on 28/12/2017.
 */
public class LoggingHandler implements SOAPHandler<SOAPMessageContext> {

    private static final Logger LOGGER = LoggerFactory.getLogger("fr.asip.mss.msg.services.xml");


    @Override
    public Set<QName> getHeaders() {
        return null;
    }

    @Override
    public boolean handleMessage(SOAPMessageContext context) {
        final SOAPMessage msg = context.getMessage();
        final boolean request = ((Boolean) context.get(SOAPMessageContext.MESSAGE_OUTBOUND_PROPERTY)).booleanValue();
        if (request) { // This is a request message.
            Map<String,List<String>> headers = (Map<String,List<String>>)context.get(MessageContext.HTTP_REQUEST_HEADERS);
            if(headers != null) {
                for(Map.Entry<String, List<String>> h : headers.entrySet()) {
                    if("NUMHOMOLOGATION".equalsIgnoreCase(h.getKey())) {
                        String hv = "";
                        for(String s : h.getValue()) {
                            if(hv.length() > 0) hv = hv + ", ";
                            hv = hv + s;
                        }
                        LOGGER.debug("NUMHOMOLOGATION: " + hv);
                    }
                }
            } else {
                LOGGER.debug("Headers is null");
            }
            logMessage(msg);
        } else { // This is the response message
            logMessage(msg);
        }
        return true;
    }

    public void logMessage(final SOAPMessage msg) {
        try {
            final ByteArrayOutputStream baos = new ByteArrayOutputStream();
            msg.writeTo(baos);
            System.out.println(baos.toString());
            LOGGER.debug(baos.toString());
        } catch (SOAPException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean handleFault(SOAPMessageContext context) {
        return true;
    }

    @Override
    public void close(MessageContext context) {

    }
}
