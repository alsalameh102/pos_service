package fr.asip.mss.exceptions.mapper;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import org.json.JSONException;
import org.json.JSONObject;

import fr.asip.mss.exceptions.ErreurFonctionnelleException;

/**
 * 
 * Formate le retour d'erreur pour l'exposition REST.
 * 
 */
public class ErreurFonctionnelleMapper implements
        ExceptionMapper<ErreurFonctionnelleException> {

    /**
     * @param ex
     *            exception
     * @return Response
     */
    @Override
    public Response toResponse(final ErreurFonctionnelleException ex) {
        String errormsg = null;
        try {
            JSONObject errorJsonFormat = new JSONObject();
            JSONObject error = new JSONObject();
            error.put("type", "FONCTIONNELLE");
            if (ex.getCode() != null) {
                error.put("code", ex.getCode());
            }
            if (ex.getMessage() != null) {
                error.put("message", ex.getMessage());
            }
            if (ex.getCause() != null) {
                JSONObject exception = new JSONObject();
                if (ex.getCause().getMessage() != null) {
                    exception.put("message", ex.getCause().getMessage());
                }
                StringWriter stackTrace = new StringWriter();
                ex.getCause().printStackTrace(new PrintWriter(stackTrace));
                exception.put("stackTrace", stackTrace.toString());
                error.put("exception", exception);
            }
            errorJsonFormat.put("error", error);
            errormsg = errorJsonFormat.toString();
        } catch (JSONException e) {
            StringBuffer sb = new StringBuffer();
            if (ex.getCode() != null) {
                sb.append(ex.getCode());
            }
            if (ex.getCode() != null && ex.getMessage() != null) {
                sb.append(" - ");
            }
            if (ex.getMessage() != null) {
                sb.append(ex.getMessage());
            }
            if (ex.getCause() != null) {
                if (ex.getCause().getMessage() != null) {
                    sb.append("\n").append(ex.getCause().getMessage());
                }
                StringWriter stackTrace = new StringWriter();
                ex.getCause().printStackTrace(new PrintWriter(stackTrace));
                sb.append("\n").append(stackTrace.toString());
            }
            errormsg = sb.toString();
        }
        return Response.status(ex.getHttpStatus()).entity(errormsg).build();
    }

}
