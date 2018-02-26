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
@ContextConfiguration(locations = { "classpath:/*-context.xml" })
public class HomologationDaoTest {

    private static boolean setup = false;
    private static final String NUMHOMOLOGATION1 = "1538749025";
    private static int iDHOMOLOGATION1 = -1;
    private static final String NUMHOMOLOGATION2 = "2349723230";
    private static int iDHOMOLOGATION2 = -1;
    private static final String NUMHOMOLOGATION3 = "2347586291";
    private static final String NUMHOMOLOGATION4 = "8243571209";
    private static final String NUMHOMOLOGATION5 = "7597823475";

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
                Homologation homologation1 = new Homologation();
                homologation1.setNumHomologation(NUMHOMOLOGATION1);
                iDHOMOLOGATION1 = HomologationDao.add(homologation1, cnx);
                Homologation homologation2 = new Homologation();
                homologation2.setNumHomologation(NUMHOMOLOGATION2);
                iDHOMOLOGATION2 = HomologationDao.add(homologation2, cnx);
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
    public void testFindByIdHomologation() throws SQLException {
        Connection cnx = null;
        try {
            cnx = ConnectionFactory.getInstance().getConnection();
            Homologation h = HomologationDao.findByIdHomologation(
                    iDHOMOLOGATION1, cnx);
            Assert.assertNotNull(h);
            Assert.assertEquals(iDHOMOLOGATION1, h.getIdHomologation());
            Assert.assertEquals(NUMHOMOLOGATION1, h.getNumHomologation());
        } finally {
            ConnectionFactory.close(cnx);
        }
    }

    /**
     * @throws SQLException
     *             exception
     */
    @Test
    public void testFindByNumHomologation() throws SQLException {
        Connection cnx = null;
        try {
            cnx = ConnectionFactory.getInstance().getConnection();
            Homologation h = HomologationDao.findByNumHomologation(
                    NUMHOMOLOGATION1, cnx);
            Assert.assertNotNull(h);
            Assert.assertEquals(iDHOMOLOGATION1, h.getIdHomologation());
            Assert.assertEquals(NUMHOMOLOGATION1, h.getNumHomologation());
        } finally {
            ConnectionFactory.close(cnx);
        }
    }

    /**
     * @throws SQLException
     *             exception
     */
    @Test
    public void testFindAll() throws SQLException {
        Connection cnx = null;
        try {
            cnx = ConnectionFactory.getInstance().getConnection();
            List<Homologation> liste = HomologationDao.findAll(cnx);
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
    public void testAdd() throws SQLException {
        Connection cnx = null;
        try {
            cnx = ConnectionFactory.getInstance().getConnection();
            Homologation homologation = new Homologation();
            homologation.setNumHomologation(NUMHOMOLOGATION3);
            int id = HomologationDao.add(homologation, cnx);
            Homologation h = HomologationDao.findByIdHomologation(id, cnx);
            Assert.assertNotNull(h);
            Assert.assertEquals(NUMHOMOLOGATION3, h.getNumHomologation());
            HomologationDao.delete(Integer.toString(id), cnx);
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
            Homologation h = HomologationDao.findByIdHomologation(
                    iDHOMOLOGATION2, cnx);
            Assert.assertNotNull(h);
            Assert.assertEquals(NUMHOMOLOGATION2, h.getNumHomologation());
            h.setNumHomologation(NUMHOMOLOGATION4);
            HomologationDao.update(h, cnx);
            h = HomologationDao.findByIdHomologation(iDHOMOLOGATION2, cnx);
            Assert.assertNotNull(h);
            Assert.assertEquals(NUMHOMOLOGATION4, h.getNumHomologation());
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
            Homologation homologation = new Homologation();
            homologation.setNumHomologation(NUMHOMOLOGATION5);
            int id = HomologationDao.add(homologation, cnx);
            HomologationDao.delete(Integer.toString(id), cnx);
            Homologation h = HomologationDao.findByIdHomologation(id, cnx);
            Assert.assertNull(h);
        } finally {
            ConnectionFactory.close(cnx);
        }
    }

}
