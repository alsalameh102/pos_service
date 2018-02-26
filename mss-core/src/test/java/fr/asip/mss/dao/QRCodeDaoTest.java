package fr.asip.mss.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

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
@ContextConfiguration(locations = { "classpath:/*-context.xml" })
public class QRCodeDaoTest {

    private static final int DELAIVALIDITE = 120000;

    private static boolean setup = false;
    private static final String IDNAT1 = "1127364559";
    private static final String IDNAT2 = "3462892184";
    private static final String IDNAT3 = "3567413495";
    private static final String CODEAPPAREILLEMENTVALIDE1 = UUID.randomUUID()
            .toString();
    private static final String CODEAPPAREILLEMENTVALIDE2 = UUID.randomUUID()
            .toString();
    private static final String CODEAPPAREILLEMENTVALIDE3 = UUID.randomUUID()
            .toString();
    private static final String CODEAPPAREILLEMENTVALIDE4 = UUID.randomUUID()
            .toString();
    private static final String CODEAPPAREILLEMENTPERIME1 = UUID.randomUUID()
            .toString();
    private static final String CODEAPPAREILLEMENTPERIME2 = UUID.randomUUID()
            .toString();

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
                QRCode qrCode = new QRCode();
                qrCode.setIdNat(IDNAT1);
                qrCode.setNom("Charles");
                qrCode.setPrenom("Henri");
                qrCode.setProfession("medecin");
                qrCode.setTypeUtilisateur("PS");
                qrCode.setCodeAppareillement(CODEAPPAREILLEMENTVALIDE1);
                QRCodeDao.add(qrCode, cnx);

                QRCode qrCodePerime = new QRCode();
                qrCodePerime.setIdNat(IDNAT2);
                qrCodePerime.setNom("Dupont");
                qrCodePerime.setPrenom("Jean");
                qrCodePerime.setProfession("medecin");
                qrCodePerime.setTypeUtilisateur("PS");
                qrCodePerime.setCodeAppareillement(CODEAPPAREILLEMENTPERIME1);
                QRCodeDao.add(qrCodePerime, true, cnx);

                QRCode qrCodeValide = new QRCode();
                qrCodeValide.setIdNat(IDNAT2);
                qrCodeValide.setNom("Dupont");
                qrCodeValide.setPrenom("Jean");
                qrCodeValide.setProfession("medecin");
                qrCodeValide.setTypeUtilisateur("PS");
                qrCodeValide.setCodeAppareillement(CODEAPPAREILLEMENTVALIDE2);
                QRCodeDao.add(qrCodeValide, false, cnx);

                QRCode qrCodeValide2 = new QRCode();
                qrCodeValide2.setIdNat(IDNAT3);
                qrCodeValide2.setNom("Dupont");
                qrCodeValide2.setPrenom("Jean");
                qrCodeValide2.setProfession("medecin");
                qrCodeValide2.setTypeUtilisateur("PS");
                qrCodeValide2.setCodeAppareillement(CODEAPPAREILLEMENTVALIDE4);
                QRCodeDao.add(qrCodeValide2, false, cnx);

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
    public void testFindByCodeAppareillement() throws SQLException {
        Connection cnx = null;
        try {
            cnx = ConnectionFactory.getInstance().getConnection();
            QRCode qrCode = QRCodeDao.findByCodeAppareillement(
                    CODEAPPAREILLEMENTVALIDE1, cnx);
            Assert.assertNotNull(qrCode);
            Assert.assertEquals(CODEAPPAREILLEMENTVALIDE1,
                    qrCode.getCodeAppareillement());
            Assert.assertEquals(IDNAT1, qrCode.getIdNat());
        } finally {
            ConnectionFactory.close(cnx);
        }
    }

    @Test
    public void testFindByCodeAppareillementAucunResultat() throws SQLException {
        Connection cnx = null;
        try {
            cnx = ConnectionFactory.getInstance().getConnection();
            QRCode qrCode = QRCodeDao.findByCodeAppareillement("toto", cnx);
            Assert.assertNull(qrCode);

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
            List<QRCode> liste = QRCodeDao.findAllByIdNat(IDNAT1, cnx);
            Assert.assertNotNull(liste);
            Assert.assertEquals(1, liste.size());
            Assert.assertEquals(IDNAT1, liste.get(0).getIdNat());
            Assert.assertEquals(CODEAPPAREILLEMENTVALIDE1, liste.get(0)
                    .getCodeAppareillement());
        } finally {
            ConnectionFactory.close(cnx);
        }
    }

    @Test
    public void testFindAllByIdNatAucunResultat() throws SQLException {
        Connection cnx = null;
        try {
            cnx = ConnectionFactory.getInstance().getConnection();
            List<QRCode> liste = QRCodeDao.findAllByIdNat("toto", cnx);
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
    public void testAddValide() throws SQLException {
        Connection cnx = null;
        try {
            cnx = ConnectionFactory.getInstance().getConnection();
            QRCode qrCode = new QRCode();
            qrCode.setIdNat(IDNAT3);
            qrCode.setNom("Charles");
            qrCode.setPrenom("Henri");
            qrCode.setProfession("medecin");
            qrCode.setTypeUtilisateur("PS");
            qrCode.setCodeAppareillement(CODEAPPAREILLEMENTVALIDE3);
            QRCodeDao.add(qrCode, cnx);
            qrCode = QRCodeDao.findByCodeAppareillement(
                    CODEAPPAREILLEMENTVALIDE3, cnx);
            Assert.assertNotNull(qrCode);
            Assert.assertEquals(CODEAPPAREILLEMENTVALIDE3,
                    qrCode.getCodeAppareillement());
            Assert.assertNotNull(qrCode.getDateCreation());
            Assert.assertTrue(qrCode.getDateCreation().after(
                    new Date(Calendar.getInstance().getTime().getTime()
                            - DELAIVALIDITE)));
        } finally {
            ConnectionFactory.close(cnx);
        }
    }

    /**
     * @throws SQLException
     *             exception
     */
    @Test
    public void testAddPerime() throws SQLException {
        Connection cnx = null;
        try {
            cnx = ConnectionFactory.getInstance().getConnection();
            QRCode qrCode = new QRCode();
            qrCode.setIdNat(IDNAT3);
            qrCode.setNom("Charles");
            qrCode.setPrenom("Henri");
            qrCode.setProfession("medecin");
            qrCode.setTypeUtilisateur("PS");
            qrCode.setCodeAppareillement(CODEAPPAREILLEMENTPERIME2);
            QRCodeDao.add(qrCode, true, cnx);
            qrCode = QRCodeDao.findByCodeAppareillement(
                    CODEAPPAREILLEMENTPERIME2, cnx);
            Assert.assertNotNull(qrCode);
            Assert.assertEquals(CODEAPPAREILLEMENTPERIME2,
                    qrCode.getCodeAppareillement());
            Assert.assertFalse(qrCode.getDateCreation().after(
                    new Date(Calendar.getInstance().getTime().getTime()
                            - DELAIVALIDITE)));
        } finally {
            ConnectionFactory.close(cnx);
        }
    }

    /**
     * @throws SQLException
     *             exception
     */
    @Test
    public void testPurge() throws SQLException {
        Connection cnx = null;
        try {
            cnx = ConnectionFactory.getInstance().getConnection();
            QRCodeDao.purge(cnx);
            List<QRCode> liste = QRCodeDao.findAllByIdNat(IDNAT2, cnx);
            Assert.assertNotNull(liste);
            Assert.assertEquals(1, liste.size());
        } finally {
            ConnectionFactory.close(cnx);
        }
    }

    /**
     * @throws SQLException
     *             exception
     */
    @Test
    public void testDeleteByCodeAppareillement() throws SQLException {
        Connection cnx = null;
        try {
            cnx = ConnectionFactory.getInstance().getConnection();
            QRCode qrCode = QRCodeDao.findByCodeAppareillement(
                    CODEAPPAREILLEMENTVALIDE4, cnx);
            Assert.assertNotNull(qrCode);
            QRCodeDao
                    .deleteByCodeAppareillement(CODEAPPAREILLEMENTVALIDE4, cnx);
            qrCode = QRCodeDao.findByCodeAppareillement(
                    CODEAPPAREILLEMENTVALIDE4, cnx);
            Assert.assertNull(qrCode);
        } finally {
            ConnectionFactory.close(cnx);
        }
    }

}
