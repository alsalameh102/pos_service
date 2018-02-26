package fr.asip.mss.dao;

import java.sql.Connection;
import java.sql.SQLException;

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
public class UnregisteredDeviceDaoTest {

    private static int iDUNREGISTEREDDEVICE1 = -1;
    private static int iDUNREGISTEREDDEVICE2 = -1;
    private static int iDUNREGISTEREDDEVICE3 = -1;
    private static final String PUSHMODE1 = "distrib";
    private static final String OS1 = "IOS";
    private static final String OS2 = "ANDROID";
    private static final String IDPUSH1 = "2abcdfbcf13ee253921a175cf632f0eacaa36dda4abb429fa8ce3b3000a5b23c";
    private static final String IDPUSH2 = "2abcdfbcf13ee253921a175cf632f0eacaa36dda4abb429fa8ce3b3000a5b23d";
    private static final String IDPUSH3 = "2abcdfbcf13ee253921a175cf632f0eacaa36dda4abb429fa8ce3b3000a5b23e";
    private static final String IDPUSH4 = "2abcdfbcf13ee253921a175cf632f0eacaa36dda4abb429fa8ce3b3000a5b23f";
    private static boolean setup = false;

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
                UnregisteredDevice unregisteredDevice1 = new UnregisteredDevice();
                unregisteredDevice1.setOs(OS1);
                unregisteredDevice1.setIdPush(IDPUSH1);
                unregisteredDevice1.setPushMode(PUSHMODE1);
                iDUNREGISTEREDDEVICE1 = UnregisteredDeviceDao.add(
                        unregisteredDevice1, cnx);

                UnregisteredDevice unregisteredDevice2 = new UnregisteredDevice();
                unregisteredDevice2.setOs(OS1);
                unregisteredDevice2.setIdPush(IDPUSH2);
                unregisteredDevice2.setPushMode(PUSHMODE1);
                iDUNREGISTEREDDEVICE2 = UnregisteredDeviceDao.add(
                        unregisteredDevice2, cnx);

                UnregisteredDevice unregisteredDevice3 = new UnregisteredDevice();
                unregisteredDevice3.setOs(OS1);
                unregisteredDevice3.setIdPush(IDPUSH3);
                unregisteredDevice3.setPushMode(PUSHMODE1);
                iDUNREGISTEREDDEVICE3 = UnregisteredDeviceDao.add(
                        unregisteredDevice3, cnx);

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
            UnregisteredDevice unregisteredDevice = new UnregisteredDevice();
            unregisteredDevice.setOs(OS1);
            unregisteredDevice.setIdPush(IDPUSH4);
            unregisteredDevice.setPushMode(PUSHMODE1);
            int id = UnregisteredDeviceDao.add(unregisteredDevice, cnx);
            UnregisteredDevice u = UnregisteredDeviceDao
                    .findByIdUnregisteredDevice(id, cnx);
            Assert.assertNotNull(u);
            Assert.assertEquals(IDPUSH4, u.getIdPush());
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
            UnregisteredDevice u = UnregisteredDeviceDao
                    .findByIdUnregisteredDevice(iDUNREGISTEREDDEVICE1, cnx);
            Assert.assertNotNull(u);
            UnregisteredDeviceDao.delete(iDUNREGISTEREDDEVICE1, cnx);
            u = UnregisteredDeviceDao.findByIdUnregisteredDevice(
                    iDUNREGISTEREDDEVICE1, cnx);
            Assert.assertNull(u);
        } finally {
            ConnectionFactory.close(cnx);
        }
    }

    /**
     * @throws SQLException
     *             exception
     */
    @Test
    public void testFindByIdUnregisteredDevice() throws SQLException {
        Connection cnx = null;
        try {
            cnx = ConnectionFactory.getInstance().getConnection();
            UnregisteredDevice u = UnregisteredDeviceDao
                    .findByIdUnregisteredDevice(iDUNREGISTEREDDEVICE2, cnx);
            Assert.assertNotNull(u);
            Assert.assertEquals(iDUNREGISTEREDDEVICE2,
                    u.getIdUnregisteredDevice());
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
            UnregisteredDevice u = UnregisteredDeviceDao
                    .findByIdUnregisteredDevice(iDUNREGISTEREDDEVICE3, cnx);
            Assert.assertNotNull(u);
            u.setOs(OS2);
            UnregisteredDeviceDao.update(u, cnx);
            u = UnregisteredDeviceDao.findByIdUnregisteredDevice(
                    iDUNREGISTEREDDEVICE3, cnx);
            Assert.assertNotNull(u);
            Assert.assertEquals(OS2, u.getOs());
        } finally {
            ConnectionFactory.close(cnx);
        }
    }

}
