package fr.asip.mss.transverse.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

/**
 * Classe d'utilitaires QRCode.
 */
public final class QRCodeUtils {
    private static final Logger LOG = LoggerFactory
            .getLogger(QRCodeUtils.class);

    /**
     * constructeur.
     */
    private QRCodeUtils() {
    }

    /**
     * @param outStream
     *            outStream
     * @param format
     *            format
     * @param size
     *            size
     * @param qrtext
     *            qrtext
     * @throws IOException
     *             exception
     */
    public static void writeQRCode(final OutputStream outStream,
            final String format, final int size, final String qrtext)
            throws IOException {
        // encodage du QrCode
        BitMatrix bitMatrix = generateMatrix(qrtext, size);

        MatrixToImageWriter.writeToStream(bitMatrix, format, outStream);
    }

    /**
     * @param format
     *            format
     * @param size
     *            size
     * @param qrtext
     *            qrtext
     * @return string
     * @throws IOException
     *             exception
     */
    public static String writeQRCodeToString(final String format,
            final int size, final String qrtext) throws IOException {
        // encodage du QrCode
        BitMatrix bitMatrix = generateMatrix(qrtext, size);

        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(bitMatrix, format, outStream);
        return "data:image/" + format + ";base64,"
                + new String(Base64.encodeBase64(outStream.toByteArray()));
    }

    /**
     * Fonction permettant de generer une matrice contenant un QrCode.
     * 
     * @param data
     *            data
     * @param size
     *            size
     * @return BitMatrix
     */
    private static BitMatrix generateMatrix(final String data, final int size) {
        BitMatrix bitMatrix;
        try {
            bitMatrix = new QRCodeWriter().encode(data, BarcodeFormat.QR_CODE,
                    size, size);
            return bitMatrix;

        } catch (WriterException e) {
            LOG.error(e.getMessage(), e);
        }
        return null;
    }

}
