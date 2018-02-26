package fr.asip.mss.transverse.utils;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

/**
 * 
 * @author JCORTES
 * 
 */
public class QRCodeUtilsTest {

    private static final String QRCODEFORMAT = "png";
    private static final int QRCODESIZE = 400;
    private static final String QRCODETEXT = "test";
    private static final String QRCODESTRING = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAZAAAAGQAQAAAACoxAthAAA"
            + "BWElEQVR42u3bQXKDMAxAUXVYsOwRehSOFo7Wo+QILFkwVY0QjkMnSZkBK4uvVY15XWks2Saiu0MgEAgEAoFAIBAI5DDyI7fo5sFF9"
            + "So6Fo8hkPrk0/8apVMdMun88RUCCSG95es4Z3IaNE4sxxsI5B2ITvKlEMg7EXtLIZB4UtR9/TOAQCLI3S7pVvf/vbGCQA4nmxh8gd1"
            + "xDAWBHE48k9cO1DI5zbY+0zxeYCGQE4ltjFK0+v2RHvT+VhoMEEgcsbfmuq8rWcL/GQQSQmyBTckr2bdLE3CZlhkIpCrRvIz6xZA1A"
            + "Wvdh0CCSBFlO2p1HwIJIXdnSl7306yUx/EQSHWy/bpjyn6AQOJIvq/MdX+9GOrl8S4JAqlD/BNNfd6OQiCVie/kF+K9KQQSQXLdz71"
            + "pkdYvPgiBQE4h299Z+KG73RI9u0aHQE4jOwICgUAgEAgEAoFAQsgv1r8gXFwRVOsAAAAASUVORK5CYII=";

    /**
     * test generation QRCode.
     */
    @Test
    public void testWriteQRCodeToString() throws IOException {
        Assert.assertEquals(QRCODESTRING, QRCodeUtils.writeQRCodeToString(
                QRCODEFORMAT, QRCODESIZE, QRCODETEXT));

    }

}
