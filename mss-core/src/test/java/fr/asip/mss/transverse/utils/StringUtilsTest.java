package fr.asip.mss.transverse.utils;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * 
 * Classe de test de StringUtils.
 * 
 */
public class StringUtilsTest {
    @Test
    public void testlisteToString() {
        String res = StringUtils.listeToString(null);
        Assert.assertEquals("", res);

        List<Integer> liste = new ArrayList<Integer>();
        res = StringUtils.listeToString(liste);
        Assert.assertEquals("", res);

        liste = new ArrayList<Integer>();
        liste.add(new Integer(5));
        liste.add(new Integer(6));
        res = StringUtils.listeToString(liste);
        Assert.assertEquals("5,6", res);
    }

    @Test
    public void testremplacerCaracteresSpeciaux() {
        String res = StringUtils.remplacerCaracteresSpeciaux(null);
        Assert.assertEquals("", res);

        res = StringUtils.remplacerCaracteresSpeciaux("");
        Assert.assertEquals("", res);

        res = StringUtils.remplacerCaracteresSpeciaux("rrré#{1111YYA  T");
        Assert.assertEquals("rrré  1111YYA  T", res);
    }

    @Test
    public void testdecouperMots() {
        List<String> res = StringUtils.decouperMots(null);
        Assert.assertNotNull(res);
        Assert.assertEquals(0, res.size());

        res = StringUtils.decouperMots("");
        Assert.assertNotNull(res);
        Assert.assertEquals(0, res.size());

        res = StringUtils.decouperMots("aa ee    yyy  (tA# op");
        Assert.assertNotNull(res);
        Assert.assertEquals(5, res.size());
        Assert.assertEquals("aa*", res.get(0));
        Assert.assertEquals("ee*", res.get(1));
        Assert.assertEquals("yyy*", res.get(2));
        Assert.assertEquals("tA*", res.get(3));
        Assert.assertEquals("op*", res.get(4));
    }

    /**
     * Expression regulière OK.
     */
    @Test
    public void testRemplacerCaracteresSpeciaux() {
        String res = StringUtils.remplacerCaracteresSpeciaux("Heureux");
        Assert.assertEquals("Heureux", res);
    }

    /**
     * Expression regulière OK.
     */
    @Test
    public void testRemplacerCaracteresSpeciauxEmail01() {
        String res = StringUtils.remplacerCaracteresSpeciauxEmail("Heureux");
        Assert.assertEquals("Heureux", res);
    }

    /**
     * Les caractères spéciaux -_.@ dans une adresse email ne doivent pas être
     * supprimé .
     */
    @Test
    public void testRemplacerCaracteresSpeciauxEmail02() {
        String res = StringUtils
                .remplacerCaracteresSpeciauxEmail("tes-_t@mssnate.fr");
        Assert.assertEquals("tes-_t@mssnate.fr", res);
    }

    /**
     * Les "-" en debut de mot ne doivent pas aparaitre dans le retour .
     */
    @Test
    public void testRemplacerCaracteresSpeciauxEmail03() {
        String res = StringUtils
                .remplacerCaracteresSpeciauxEmail(" --_test@mssnate.fr");
        Assert.assertEquals("_test@mssnate.fr", res);
    }

    /**
     * Les "-" en debut de mot ne doivent pas aparaitre dans le retour .
     */
    @Test
    public void testRemplacerCaracteresSpeciauxEmail04() {
        String res = StringUtils
                .remplacerCaracteresSpeciauxEmail("tes -_t -_t@mssnate.fr");
        Assert.assertEquals("tes _t _t@mssnate.fr", res);
    }
}
