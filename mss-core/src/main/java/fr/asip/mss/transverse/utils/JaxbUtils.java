package fr.asip.mss.transverse.utils;

import java.io.IOException;

import fr.asip.mss.transverse.object.mapper.JacksonObjectMapper;

/**
 * Classe d'utilitaires JAXB.
 */
public final class JaxbUtils {

    /**
     * constructeur.
     */
    private JaxbUtils() {
    }

    /**
     * @param obj
     *            objet
     * @return string
     * @throws IOException
     *             exception
     */
    public static String objToJsonStr(final Object obj) throws IOException {
        /*
         * StringWriter sw = new StringWriter(); JAXBContext jaxbctx =
         * JAXBContext.newInstance(obj.getClass()); Configuration config = new
         * Configuration(); MappedNamespaceConvention con = new
         * MappedNamespaceConvention(config); XMLStreamWriter xmlStreamWriter =
         * new MappedXMLStreamWriter(con, sw); Marshaller marshaller =
         * jaxbctx.createMarshaller();
         * marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
         * marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
         * marshaller.marshal(obj, xmlStreamWriter); return sw.toString();
         */
        return (new JacksonObjectMapper()).writeValueAsString(obj);
    }

}
