package fr.asip.mss.transverse.utils;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

/**
 * 
 * @author JCORTES
 * 
 */
public class JaxbUtilsTest {

    private static final String IDCANAL = "123456";
    private static final String JSONSTR = "{\"canal\":{\"idCanal\":\""
            + IDCANAL + "\"}}";

    /**
     * test obj to json.
     */
    @Test
    public void testObjToJsonStr() throws IOException {
        Canal canal = new Canal();
        canal.setIdCanal(IDCANAL);
        Assert.assertEquals(JSONSTR, JaxbUtils.objToJsonStr(canal));

    }

}
