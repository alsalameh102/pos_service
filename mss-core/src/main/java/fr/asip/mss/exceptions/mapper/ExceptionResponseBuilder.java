package fr.asip.mss.exceptions.mapper;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.impl.WebApplicationExceptionMapper;
import org.json.JSONException;
import org.json.JSONObject;

import fr.asip.mss.exceptions.ErreurFonctionnelleException;
import fr.asip.mss.exceptions.ErreurTechniqueException;
import fr.asip.mss.transverse.enums.CodeErreurFonctionnelle;
import fr.asip.mss.transverse.enums.CodeErreurTechnique;

/**
 * 
 * @author JCORTES
 * 
 */
public class ExceptionResponseBuilder extends WebApplicationExceptionMapper {

    /**
     * Formate l'erreur en json pour la sortie. Transforme les
     * JsonMappingException en ErreurFonctionnelleException s'il n'y a pas déjà
     * une ErreurFonctionnelleException à l'intérieur (placé par un xmlAdapter
     * pour avoir un code erreur différent de celui par défaut). Transforme les
     * autres erreurs en ErreurTechniqueException.
     * 
     * @param waex
     *            exception
     * @return Response
     */
    @Override
    public Response toResponse(final WebApplicationException waex) {
        if (waex instanceof javax.ws.rs.InternalServerErrorException
                && waex.getCause() != null
                && (waex.getCause() instanceof org.codehaus.jackson.map.JsonMappingException || waex
                        .getCause() instanceof org.codehaus.jackson.JsonParseException)) {
            ErreurFonctionnelleException ex = null;
            if (waex.getCause().getCause() != null
                    && waex.getCause().getCause() instanceof fr.asip.mss.exceptions.ErreurFonctionnelleException) {
                ex = (ErreurFonctionnelleException) waex.getCause().getCause();
            } else {
                Exception exception = null;
                if (waex.getCause() instanceof org.codehaus.jackson.map.JsonMappingException) {
                    exception = (org.codehaus.jackson.map.JsonMappingException) waex
                            .getCause();
                } else if (waex.getCause() instanceof org.codehaus.jackson.JsonParseException) {
                    exception = (org.codehaus.jackson.JsonParseException) waex
                            .getCause();
                }
                if (waex.getCause().getMessage().indexOf("CodeService") > -1) {
                    ex = new ErreurFonctionnelleException(
                            CodeErreurFonctionnelle.CF38, exception);
                } else {
                    ex = new ErreurFonctionnelleException(
                            CodeErreurFonctionnelle.CF36, exception);
                }
            }
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
        } else {
            ErreurTechniqueException ex = new ErreurTechniqueException(
                    CodeErreurTechnique.TEC1, waex);
            String errormsg = null;
            try {
                JSONObject errorJsonFormat = new JSONObject();
                JSONObject error = new JSONObject();
                error.put("type", "TECHNIQUE");
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
}
