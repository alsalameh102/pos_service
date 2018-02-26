package fr.asip.mss.transverse.object.mapper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

import org.codehaus.jackson.map.AnnotationIntrospector;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.introspect.JacksonAnnotationIntrospector;
import org.codehaus.jackson.xc.JaxbAnnotationIntrospector;

import fr.asip.mss.transverse.utils.DateUtils;

/**
 * 
 * @author JCORTES
 * 
 */
public class JacksonObjectMapper extends ObjectMapper {

    /**
     * constructeur.
     */
    public JacksonObjectMapper() {
        super();
        super.configure(SerializationConfig.Feature.WRAP_ROOT_VALUE, true);
        super.configure(DeserializationConfig.Feature.UNWRAP_ROOT_VALUE, true);
        super.configure(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS,
                false);
        DateFormat df = new SimpleDateFormat(DateUtils.DATE_FORMAT);
        df.setTimeZone(TimeZone.getTimeZone("CET"));
        super.setDateFormat(df);
        // super.configure(SerializationConfig.Feature.INDENT_OUTPUT, true);
        super.setSerializationInclusion(JsonSerialize.Inclusion.NON_NULL);
        AnnotationIntrospector primary = new JaxbAnnotationIntrospector();
        AnnotationIntrospector secondary = new JacksonAnnotationIntrospector();
        AnnotationIntrospector pair = new AnnotationIntrospector.Pair(primary,
                secondary);
        super.setAnnotationIntrospector(pair);
    }

}
