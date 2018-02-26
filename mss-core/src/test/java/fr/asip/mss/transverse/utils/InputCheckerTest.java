package fr.asip.mss.transverse.utils;

import org.junit.Assert;
import org.junit.Test;

import fr.asip.mss.exceptions.ErreurFonctionnelleException;
import fr.asip.mss.transverse.enums.CodeErreurFonctionnelle;

/**
 * Classe de test de InputChecker.
 * 
 */
public class InputCheckerTest {

    private static final int USER_ID_LENGTH = 80;

    /**
     * Test la methode de vérification du format d'une adresse email.
     * 
     * @throws ErreurFonctionnelleException
     *             e
     */
    @Test
    public void testCheckExpressionRegOK1() throws ErreurFonctionnelleException {
        String userId = "ok@blabla-tt.fr";
        InputChecker.checkExpressionReguliere(userId);
        Assert.assertTrue("Aucune erreur", true);
    }

    /**
     * Test la methode de vérification du format d'une adresse email.
     * 
     * @throws ErreurFonctionnelleException
     *             e
     */
    @Test
    public void testCheckExpressionRegNull()
            throws ErreurFonctionnelleException {
        InputChecker.checkExpressionReguliere(null);
        Assert.assertTrue("Aucune erreur", true);
    }

    /**
     * Test la methode de vérification du format d'une adresse email.
     * 
     * @throws ErreurFonctionnelleException
     *             e
     */
    @Test
    public void testCheckExpressionRegOK2() throws ErreurFonctionnelleException {
        String userId = "ok@blabla.fr";
        InputChecker.checkExpressionReguliere(userId);
        Assert.assertTrue("Aucune erreur", true);
    }

    /**
     * Test la methode de vérification de longueur d'un paramètre pour la
     * longueur maxi.
     * 
     * @throws ErreurFonctionnelleException
     *             e
     */
    @Test
    public void testCheckLengthLimitOK() throws ErreurFonctionnelleException {
        String userId = "testAvecUneAdresseEmailLimit--------------------------------@vraimentLimit---.fr";
        Assert.assertEquals(USER_ID_LENGTH, userId.length());
        InputChecker.checkLength(userId, USER_ID_LENGTH,
                CodeErreurFonctionnelle.CF36);
        Assert.assertTrue("Aucune erreur", true);
    }

    /**
     * Teste la validitéavec entrée nulle.
     * 
     * @throws ErreurFonctionnelleException
     *             e
     */
    @Test
    public void testCheckLengthEntreeNulle()
            throws ErreurFonctionnelleException {
        InputChecker.checkLength(null, USER_ID_LENGTH,
                CodeErreurFonctionnelle.CF36);
        Assert.assertTrue("Aucune erreur", true);
    }

    /**
     * Test la methode de vérification de longueur d'un paramètre.
     * 
     * @throws ErreurFonctionnelleException
     *             e
     */
    @Test
    public void testCheckLengthOK() throws ErreurFonctionnelleException {
        String userId = "ok@blabla.fr";
        InputChecker.checkLength(userId, USER_ID_LENGTH,
                CodeErreurFonctionnelle.CF36);
        Assert.assertTrue("Aucune erreur", true);
    }

    /**
     * Test la methode de vérification de longueur d'un paramètre pour un param
     * trop long de 1 char.
     * 
     * @throws ErreurFonctionnelleException
     *             e
     */
    @Test(expected = ErreurFonctionnelleException.class)
    public void testCheckLengthTooLong() throws ErreurFonctionnelleException {
        String userId = "testAvecUneAdresseEmailVraimentTropLongue--------------------@vraimentTropLong.fr";
        Assert.assertEquals(USER_ID_LENGTH + 1, userId.length());
        InputChecker.checkLength(userId, USER_ID_LENGTH,
                CodeErreurFonctionnelle.CF36);
        Assert.assertTrue("Aucune erreur", true);
    }

    /**
     * test la vérification de la priorité quand value est mauvaise.
     */
    @Test
    public void testCheckPriorityValue01() {
        try {
            InputChecker.checkPriorityValue("wrong value");
            Assert.assertFalse("On devrait avoir erreur 36", true);
        } catch (ErreurFonctionnelleException e) {
            Assert.assertEquals(CodeErreurFonctionnelle.CF36.getCode(),
                    e.getCode());
        }
    }

    /**
     * test la vérification de la priorité quand value = HAUTE.
     * 
     * @throws ErreurFonctionnelleException
     *             e
     */
    @Test
    public void testCheckPriorityValue02() throws ErreurFonctionnelleException {
        InputChecker.checkPriorityValue("HAUTE");
        Assert.assertTrue("Aucune erreur", true);
    }

    /**
     * test la vérification de la priorité quand value nulle.
     * 
     * @throws ErreurFonctionnelleException
     *             e
     */
    @Test
    public void testCheckPriorityValueNull()
            throws ErreurFonctionnelleException {
        InputChecker.checkPriorityValue(null);
        Assert.assertTrue("Aucune erreur", true);
    }

    /**
     * test la vérification de la priorité quand value = NORMAL.
     * 
     * @throws ErreurFonctionnelleException
     *             e
     */
    @Test
    public void testCheckPriorityValue03() throws ErreurFonctionnelleException {
        InputChecker.checkPriorityValue("NORMAL");
        Assert.assertTrue("Aucune erreur", true);
    }

    /**
     * test la vérification de la priorité quand value = normal.
     */
    @Test
    public void testCheckPriorityValue04() {
        try {
            InputChecker.checkPriorityValue("normal");
            Assert.assertFalse("On devrait avoir erreur 36", true);
        } catch (ErreurFonctionnelleException e) {
            Assert.assertEquals(CodeErreurFonctionnelle.CF36.getCode(),
                    e.getCode());
        }
    }

    /**
     * test la vérification du replyType quand value est mauvaise.
     */
    @Test
    public void testCheckReplyTypeValue01() {
        try {
            InputChecker.checkReplyTypeValue("wrong value");
            Assert.assertFalse("On devrait avoir erreur 36", true);
        } catch (ErreurFonctionnelleException e) {
            Assert.assertEquals(CodeErreurFonctionnelle.CF36.getCode(),
                    e.getCode());
        }
    }

    /**
     * test la vérification du replyType quand value = REPLIED.
     * 
     * @throws ErreurFonctionnelleException
     *             e
     */
    @Test
    public void testCheckReplyTypeValue02() throws ErreurFonctionnelleException {
        InputChecker.checkReplyTypeValue("REPLIED");
        Assert.assertTrue("Aucune erreur", true);
    }

    /**
     * test la vérification du replyType quand value est nulle.
     * 
     * @throws ErreurFonctionnelleException
     *             e
     */
    @Test
    public void testCheckReplyTypeValueNull()
            throws ErreurFonctionnelleException {
        InputChecker.checkReplyTypeValue(null);
        Assert.assertTrue("Aucune erreur", true);
    }

    /**
     * test la vérification du replyType quand value = FORWARDED.
     * 
     * @throws ErreurFonctionnelleException
     *             e
     */
    @Test
    public void testCheckReplyTypeValue03() throws ErreurFonctionnelleException {
        InputChecker.checkReplyTypeValue("FORWARDED");
        Assert.assertTrue("Aucune erreur", true);
    }

    /**
     * test la vérification du replyType quand value = forwarded.
     */
    @Test
    public void testCheckReplyTypeValue04() {
        try {
            InputChecker.checkReplyTypeValue("forwarded");
            Assert.assertFalse("On devrait avoir erreur 36", true);
        } catch (ErreurFonctionnelleException e) {
            Assert.assertEquals(CodeErreurFonctionnelle.CF36.getCode(),
                    e.getCode());
        }
    }

    /**
     * Test en robustesse la methode de vérification du format d'une adresse
     * email avec majuscule.
     * 
     * 
     * @throws ErreurFonctionnelleException
     *             e
     */
    public void testRobustCheckExpressionReg01()
            throws ErreurFonctionnelleException {
        String userId = "Notok@blabla.fr";
        InputChecker.checkExpressionReguliere(userId);
        Assert.assertTrue("Aucune erreur", true);
    }

    /**
     * Test en robustesse la methode de vérification du format d'une adresse
     * email.
     * 
     * Condition invalidante : unmauvais char -> é
     * 
     * @throws ErreurFonctionnelleException
     *             e
     */
    @Test
    public void testRobustCheckExpressionReg02()
            throws ErreurFonctionnelleException {
        String userId = "énotok@blabla.fr";
        try {
            InputChecker.checkExpressionReguliere(userId);
            Assert.assertTrue("On devrait avoir une erreur 36", false);
        } catch (ErreurFonctionnelleException e) {
            Assert.assertEquals(CodeErreurFonctionnelle.CF36.getCode(),
                    e.getCode());
        }
    }

    /**
     * Test en robustesse la methode de vérification du format d'une adresse
     * email.
     * 
     * Condition invalidante : 0 char avant @
     * 
     * @throws ErreurFonctionnelleException
     *             e
     */
    @Test
    public void testRobustCheckExpressionReg03()
            throws ErreurFonctionnelleException {
        String userId = "@blabla.fr";
        try {
            InputChecker.checkExpressionReguliere(userId);
            Assert.assertTrue("On devrait avoir une erreur 36", false);
        } catch (ErreurFonctionnelleException e) {
            Assert.assertEquals(CodeErreurFonctionnelle.CF36.getCode(),
                    e.getCode());
        }
    }

    /**
     * Test en robustesse la methode de vérification du format d'une adresse
     * email.
     * 
     * Condition invalidante : pas de @
     * 
     * @throws ErreurFonctionnelleException
     *             e
     */
    @Test
    public void testRobustCheckExpressionReg04()
            throws ErreurFonctionnelleException {
        String userId = "notokblabla.fr";
        try {
            InputChecker.checkExpressionReguliere(userId);
            Assert.assertTrue("On devrait avoir une erreur 36", false);
        } catch (ErreurFonctionnelleException e) {
            Assert.assertEquals(CodeErreurFonctionnelle.CF36.getCode(),
                    e.getCode());
        }
    }

    /**
     * Test en robustesse la methode de vérification du format d'une adresse
     * email avec une majuscule.
     * 
     * Condition invalidante : Majuscule
     * 
     * @throws ErreurFonctionnelleException
     *             e
     */
    @Test
    public void testRobustCheckExpressionReg05()
            throws ErreurFonctionnelleException {
        String userId = "notok@Blabla.fr";
        try {
            InputChecker.checkExpressionReguliere(userId);
            Assert.assertTrue("On devrait avoir une erreur 36", false);
        } catch (ErreurFonctionnelleException e) {
            Assert.assertEquals(CodeErreurFonctionnelle.CF36.getCode(),
                    e.getCode());
        }
    }

    /**
     * Test en robustesse la methode de vérification du format d'une adresse
     * email.
     * 
     * Condition invalidante : Chiffre dans le nom de domaine
     * 
     * @throws ErreurFonctionnelleException
     *             e
     */
    @Test
    public void testRobustCheckExpressionReg06()
            throws ErreurFonctionnelleException {
        String userId = "notok@blabla!.fr";
        try {
            InputChecker.checkExpressionReguliere(userId);
            Assert.assertTrue("On devrait avoir une erreur 36", false);
        } catch (ErreurFonctionnelleException e) {
            Assert.assertEquals(CodeErreurFonctionnelle.CF36.getCode(),
                    e.getCode());
        }
    }

    /**
     * Test en robustesse la methode de vérification du format d'une adresse
     * email.
     * 
     * 
     * 
     * @throws ErreurFonctionnelleException
     *             e
     */
    @Test
    public void testRobustCheckExpressionReg07()
            throws ErreurFonctionnelleException {
        String userId = "notok@a.fr";
        InputChecker.checkExpressionReguliere(userId);
        Assert.assertTrue("Aucune erreur", true);
    }

    /**
     * Test en robustesse la methode de vérification du format d'une adresse
     * email.
     * 
     * Condition invalidante : pas de "." dans le nom de domaine
     * 
     * @throws ErreurFonctionnelleException
     *             e
     */
    @Test
    public void testRobustCheckExpressionReg08()
            throws ErreurFonctionnelleException {
        String userId = "notok@blablafr";
        try {
            InputChecker.checkExpressionReguliere(userId);
        } catch (ErreurFonctionnelleException e) {
            Assert.assertEquals(CodeErreurFonctionnelle.CF36.getCode(),
                    e.getCode());
        }
    }

    /**
     * Test en robustesse la methode de vérification du format d'une adresse
     * email avec majuscule.
     * 
     * condition invalidante : majuscule
     * 
     * @throws ErreurFonctionnelleException
     *             e
     */
    @Test
    public void testRobustCheckExpressionReg09()
            throws ErreurFonctionnelleException {
        String userId = "notok@blabla.Fr";
        try {
            InputChecker.checkExpressionReguliere(userId);
        } catch (ErreurFonctionnelleException e) {
            Assert.assertEquals(CodeErreurFonctionnelle.CF36.getCode(),
                    e.getCode());
        }
    }

    /**
     * Test en robustesse la methode de vérification du format d'une adresse
     * email.
     * 
     * //Condition invalidante : Chiffre dans la terminaison du nom de domaine
     * 
     * @throws ErreurFonctionnelleException
     *             e
     */
    @Test
    public void testRobustCheckExpressionReg10()
            throws ErreurFonctionnelleException {
        String userId = "notok@blabla.fr9";
        InputChecker.checkExpressionReguliere(userId);
        Assert.assertTrue("Aucune erreur", true);
    }

    /**
     * Test en robustesse la methode de vérification du format d'une adresse
     * email.
     * 
     * Condition invalidante : 1 lettre dans la terminaison du nom de domaine
     * 
     * @throws ErreurFonctionnelleException
     *             e
     */
    @Test
    public void testRobustCheckExpressionReg11()
            throws ErreurFonctionnelleException {
        String userId = "notok@blabla.f";
        InputChecker.checkExpressionReguliere(userId);
        Assert.assertTrue("Aucune erreur", true);
    }

    /**
     * Test en robustesse la methode de vérification du format d'une adresse
     * email avec nom de domaine long.
     * 
     * 
     * @throws ErreurFonctionnelleException
     *             e
     */
    @Test
    public void testRobustCheckExpressionReg12()
            throws ErreurFonctionnelleException {
        String userId = "notok@blabla.france";
        InputChecker.checkExpressionReguliere(userId);
        Assert.assertTrue("Aucune erreur", true);
    }

    @Test
    public void testCheckOperation() throws ErreurFonctionnelleException {

        InputChecker.checkOperation(null);
        Assert.assertTrue("Aucune erreur", true);

        InputChecker.checkOperation("DELETE");
        Assert.assertTrue("Aucune erreur", true);

        InputChecker.checkOperation("TRASH");
        Assert.assertTrue("Aucune erreur", true);

        InputChecker.checkOperation("READ");
        Assert.assertTrue("Aucune erreur", true);

        InputChecker.checkOperation("UNREAD");
        Assert.assertTrue("Aucune erreur", true);

        InputChecker.checkOperation("SPAM");
        Assert.assertTrue("Aucune erreur", true);

        InputChecker.checkOperation("FLAGGED");
        Assert.assertTrue("Aucune erreur", true);

        InputChecker.checkOperation("UNFLAGGED");
        Assert.assertTrue("Aucune erreur", true);

        InputChecker.checkOperation("UNSPAM");
        Assert.assertTrue("Aucune erreur", true);
        try {
            InputChecker.checkOperation("eee");
            Assert.assertTrue("On devrait avoir une erreur 36", false);
        } catch (ErreurFonctionnelleException e) {
            Assert.assertEquals(CodeErreurFonctionnelle.CF36.getCode(),
                    e.getCode());
        }

    }

    @Test
    public void testCheckSyncToken() throws ErreurFonctionnelleException {

        String res = InputChecker.checkSyncToken(null);
        Assert.assertEquals("0", res);

        res = InputChecker.checkSyncToken("");
        Assert.assertEquals("0", res);

        try {
            res = InputChecker
                    .checkSyncToken("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
            Assert.assertTrue("On devrait avoir une erreur 36", false);
        } catch (ErreurFonctionnelleException e) {
            Assert.assertEquals(CodeErreurFonctionnelle.CF36.getCode(),
                    e.getCode());
        }

        try {
            res = InputChecker.checkSyncToken("ffff");
            Assert.assertTrue("On devrait avoir une erreur 36", false);
        } catch (ErreurFonctionnelleException e) {
            Assert.assertEquals(CodeErreurFonctionnelle.CF36.getCode(),
                    e.getCode());
        }

        res = InputChecker.checkSyncToken("-100");
        Assert.assertEquals("0", res);

        res = InputChecker.checkSyncToken("500");
        Assert.assertEquals("500", res);
    }

}
