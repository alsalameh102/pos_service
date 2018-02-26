package fr.asip.mss.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 
 * @author JCORTES
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/*-context.xml" })
public class CanalDaoTest {

    private static int iDCANAL1 = -1;
    private static int iDCANAL2 = -1;
    private static int iDCANAL3 = -1;
    private static final String IDMOBILE1 = "E9D2E1B9-71FE-4CA6-9216-7B1424956714";
    private static final String IDMOBILE2 = "APA91bHo-oJvegVs6e8QnHFQPgyigYtc2GkDv09tRJggqtmj7fLQZC5-S8qy9XtdWzVlfw7uC"
            + "BerTgyNsX5SXLeZRbYEeRl0caXc8ctHIo7hpqV4nQYy6YeYYzvWmPVeeZo_LwpdadsEJwmFh-fnUu4FUT1ARaucSw";
    private static final String IDNAT1 = "7827364559";
    private static final String IDNAT2 = "8827364559";
    private static final String IDNAT3 = "2336794682";
    private static final String IDPUSH1 = "2abcdfbcf13ee253921a175cf632f0eacaa36dda4abb429fa8ce3b3000a5b23c";
    private static final String IDPUSH2 = "20508824423";
    private static int iDUTILISATEUR1 = -1;
    private static int iDUTILISATEUR2 = -1;
    private static int iDUTILISATEUR3 = -1;
    private static boolean setup = false;
    private static final String TYPECANAL = "Push";

    /**
     * setup.
     * 
     * @throws Exception
     *             exception
     */
    @Before
    public void setUp() throws Exception {
        if (!setup) {
            setup = true;
            Connection cnx = null;
            try {
                cnx = ConnectionFactory.getInstance().getConnection();
                Utilisateur utilisateur1 = new Utilisateur();
                utilisateur1.setIdNat(IDNAT1);
                utilisateur1.setNom("Charles");
                utilisateur1.setPrenom("Henri");
                utilisateur1.setProfession("medecin");
                utilisateur1.setMail("email@email.com");
                utilisateur1.setTypeUtilisateur("PS");
                iDUTILISATEUR1 = UtilisateurDao.add(utilisateur1, cnx);

                Canal canal1 = new Canal();
                canal1.setIdUtilisateur(iDUTILISATEUR1);
                canal1.setOs("iOS");
                canal1.setCanalType(TYPECANAL);
                canal1.setIdPush(IDPUSH1);
                canal1.setIdMobile(IDMOBILE1);
                canal1.setStatut("OK");
                canal1.setPwd("123456");
                canal1.setTypeChiffrage("SHA256");
                iDCANAL1 = CanalDao.add(canal1, cnx);

                Canal canal2 = new Canal();
                canal2.setIdUtilisateur(iDUTILISATEUR1);
                canal2.setOs("Android");
                canal2.setCanalType(TYPECANAL);
                canal2.setIdPush(IDPUSH2);
                canal2.setIdMobile(IDMOBILE2);
                canal2.setStatut("OK");
                canal2.setPwd("123456");
                canal2.setTypeChiffrage("EAS256");
                iDCANAL2 = CanalDao.add(canal2, cnx);

                Canal canal3 = new Canal();
                canal3.setIdUtilisateur(iDUTILISATEUR1);
                canal3.setOs("iOS");
                canal3.setCanalType(TYPECANAL);
                canal3.setIdPush(IDPUSH1);
                canal3.setIdMobile(IDMOBILE1);
                canal3.setStatut("OK");
                canal3.setPwd("123456");
                canal3.setTypeChiffrage("EAS256");
                iDCANAL3 = CanalDao.add(canal3, cnx);

                Utilisateur utilisateur2 = new Utilisateur();
                utilisateur2.setIdNat(IDNAT2);
                utilisateur2.setNom("Jean");
                utilisateur2.setPrenom("Dupont");
                utilisateur2.setProfession("medecin");
                utilisateur2.setMail("email@email.com");
                utilisateur2.setTypeUtilisateur("PS");
                iDUTILISATEUR2 = UtilisateurDao.add(utilisateur2, cnx);

                Canal canal4 = new Canal();
                canal4.setIdUtilisateur(iDUTILISATEUR2);
                canal4.setOs("iOS");
                canal4.setCanalType(TYPECANAL);
                canal4.setIdPush(IDPUSH1);
                canal4.setIdMobile(IDMOBILE1);
                canal4.setStatut("OK");
                canal4.setPwd("123456");
                canal4.setTypeChiffrage("SHA256");
                CanalDao.add(canal4, cnx);

                Canal canal5 = new Canal();
                canal5.setIdUtilisateur(iDUTILISATEUR2);
                canal5.setOs("Android");
                canal5.setCanalType(TYPECANAL);
                canal5.setIdPush(IDPUSH2);
                canal5.setIdMobile(IDMOBILE2);
                canal5.setStatut("OK");
                canal5.setPwd("123456");
                canal5.setTypeChiffrage("SHA256");
                CanalDao.add(canal5, cnx);

                Utilisateur utilisateur3 = new Utilisateur();
                utilisateur3.setIdNat(IDNAT3);
                utilisateur3.setNom("Jean");
                utilisateur3.setPrenom("Dupont");
                utilisateur3.setProfession("medecin");
                utilisateur3.setMail("email@email.com");
                utilisateur3.setTypeUtilisateur("PS");
                iDUTILISATEUR3 = UtilisateurDao.add(utilisateur3, cnx);

                Canal canal6 = new Canal();
                canal6.setIdUtilisateur(iDUTILISATEUR3);
                canal6.setOs("iOS");
                canal6.setCanalType(TYPECANAL);
                canal6.setIdPush(IDPUSH1);
                canal6.setIdMobile(IDMOBILE1);
                canal6.setStatut("OK");
                canal6.setPwd("123456");
                canal6.setTypeChiffrage("SHA256");
                CanalDao.add(canal6, cnx);

                Canal canal7 = new Canal();
                canal7.setIdUtilisateur(iDUTILISATEUR3);
                canal7.setOs("Android");
                canal7.setCanalType(TYPECANAL);
                canal7.setIdPush(IDPUSH2);
                canal7.setIdMobile(IDMOBILE2);
                canal7.setStatut("OK");
                canal7.setPwd("123456");
                canal7.setTypeChiffrage("SHA256");
                CanalDao.add(canal7, cnx);
            } finally {
                ConnectionFactory.close(cnx);
            }
        }
    }

    /**
     * @throws SQLException
     *             exception
     */
    @Test
    public void testAdd() throws SQLException {
        Connection cnx = null;
        try {
            cnx = ConnectionFactory.getInstance().getConnection();
            Canal canal = new Canal();
            canal.setIdUtilisateur(iDUTILISATEUR1);
            canal.setOs("iOS");
            canal.setCanalType(TYPECANAL);
            canal.setIdPush("2abcdfbcf13ee253921a175cf632f0eacaa36dda4abb429fa8ce3b3000a5b23c");
            canal.setIdMobile(IDMOBILE1);
            canal.setStatut("OK");
            canal.setPwd("123456");
            canal.setTypeChiffrage("SHA256");
            int id = CanalDao.add(canal, cnx);
            Canal c = CanalDao.findByIdCanal(id, cnx);
            Assert.assertNotNull(c);
            Assert.assertEquals(iDUTILISATEUR1, c.getIdUtilisateur());
        } finally {
            ConnectionFactory.close(cnx);
        }
    }

    /**
     * @throws SQLException
     *             exception
     */
    @Test
    public void testDelete() throws SQLException {
        Connection cnx = null;
        try {
            cnx = ConnectionFactory.getInstance().getConnection();
            Canal c = CanalDao.findByIdCanal(iDCANAL2, cnx);
            Assert.assertNotNull(c);
            CanalDao.delete(iDCANAL2, cnx);
            c = CanalDao.findByIdCanal(iDCANAL2, cnx);
            Assert.assertNull(c);
        } finally {
            ConnectionFactory.close(cnx);
        }
    }

    /**
     * @throws SQLException
     *             exception
     */
    @Test
    public void testDeleteAllByIdUtilisateur() throws SQLException {
        Connection cnx = null;
        try {
            cnx = ConnectionFactory.getInstance().getConnection();
            List<Canal> liste = CanalDao.findAllByIdNat(IDNAT2, cnx);
            Assert.assertNotNull(liste);
            Assert.assertEquals(2, liste.size());
            CanalDao.deleteAllByIdUtilisateur(iDUTILISATEUR2, cnx);
            liste = CanalDao.findAllByIdNat(IDNAT2, cnx);
            Assert.assertNull(liste);
        } finally {
            ConnectionFactory.close(cnx);
        }
    }

    /**
     * @throws SQLException
     *             exception
     */
    @Test
    public void testFindAllByIdNat() throws SQLException {
        Connection cnx = null;
        try {
            cnx = ConnectionFactory.getInstance().getConnection();
            List<Canal> liste = CanalDao.findAllByIdNat(IDNAT3, cnx);
            Assert.assertNotNull(liste);
            Assert.assertEquals(2, liste.size());
        } finally {
            ConnectionFactory.close(cnx);
        }
    }

    /**
     * @throws SQLException
     *             exception
     */
    @Test
    public void testFindByIdCanal() throws SQLException {
        Connection cnx = null;
        try {
            cnx = ConnectionFactory.getInstance().getConnection();
            Canal c = CanalDao.findByIdCanal(iDCANAL1, cnx);
            Assert.assertNotNull(c);
            Assert.assertEquals(iDCANAL1, c.getIdCanal());
        } finally {
            ConnectionFactory.close(cnx);
        }
    }

    /**
     * @throws SQLException
     *             exception
     */
    @Test
    public void testFindByIdPush() throws SQLException {
        Connection cnx = null;
        try {
            cnx = ConnectionFactory.getInstance().getConnection();
            Canal canal = CanalDao.findByIdPush(null, cnx);
            Assert.assertNull(canal);

            canal = CanalDao.findByIdPush(IDPUSH1, cnx);
            Assert.assertNotNull(canal);
            Assert.assertEquals(TYPECANAL, canal.getCanalType());
            Assert.assertEquals(IDMOBILE1, canal.getIdMobile());
            Assert.assertEquals(IDPUSH1, canal.getIdPush());
            Assert.assertEquals(iDUTILISATEUR1, canal.getIdUtilisateur());

        } finally {
            ConnectionFactory.close(cnx);
        }
    }

    /**
     * @throws SQLException
     *             exception
     */
    @Test
    public void testFindByIdUtilisateurAndIdMobile() throws SQLException {
        Connection cnx = null;
        try {
            cnx = ConnectionFactory.getInstance().getConnection();
            Canal c = CanalDao.findByIdMobile(IDMOBILE1, cnx);
            Assert.assertNotNull(c);
            Assert.assertEquals(iDCANAL1, c.getIdCanal());
        } finally {
            ConnectionFactory.close(cnx);
        }
    }

    /**
     * @throws SQLException
     *             exception
     */
    @Test
    public void testFindByIdUtilisateurTypeCanalAndIdPush() throws SQLException {
        Connection cnx = null;
        try {
            cnx = ConnectionFactory.getInstance().getConnection();
            Canal c = CanalDao.findByIdUtilisateurTypeCanal(iDUTILISATEUR1,
                    TYPECANAL, cnx);
            Assert.assertNotNull(c);
            Assert.assertEquals(iDCANAL1, c.getIdCanal());
        } finally {
            ConnectionFactory.close(cnx);
        }
    }

    /**
     * @throws SQLException
     *             exception
     */
    @Test
    public void testUpdate() throws SQLException {
        Connection cnx = null;
        try {
            cnx = ConnectionFactory.getInstance().getConnection();
            Canal c = CanalDao.findByIdCanal(iDCANAL3, cnx);
            Assert.assertNotNull(c);
            Assert.assertEquals("OK", c.getStatut());
            c.setStatut("Bloqued");
            CanalDao.update(c, cnx);
            c = CanalDao.findByIdCanal(iDCANAL3, cnx);
            Assert.assertNotNull(c);
            Assert.assertEquals("Bloqued", c.getStatut());
        } finally {
            ConnectionFactory.close(cnx);
        }
    }

}
