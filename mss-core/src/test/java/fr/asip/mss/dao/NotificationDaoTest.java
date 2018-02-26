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
 * Classe de test de NotificationDao.
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/*-context.xml" })
public class NotificationDaoTest {

    private static boolean setup = false;

    private int idNotif1;

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

                Notification notif = new Notification();
                notif.setActivated(0);
                notif.setEmail("test1@test.test");
                notif.setIdCanal(1);
                idNotif1 = NotificationDao.add(notif, cnx);

                notif = new Notification();
                notif.setActivated(1);
                notif.setEmail("test1@test.test");
                notif.setIdCanal(3);
                NotificationDao.add(notif, cnx);

                notif = new Notification();
                notif.setActivated(1);
                notif.setEmail("test2@test.test");
                notif.setIdCanal(2);
                NotificationDao.add(notif, cnx);
            } finally {
                ConnectionFactory.close(cnx);
            }
        }
    }

    @Test
    public void testDelete() throws SQLException {
        Connection cnx = null;
        try {
            cnx = ConnectionFactory.getInstance().getConnection();
            Notification notif = NotificationDao.findAllByCanalEmail(2,
                    "test2@test.test", cnx);
            Assert.assertNotNull(notif);

            NotificationDao.delete(2, cnx);

            notif = NotificationDao.findAllByCanalEmail(2, "test2@test.test",
                    cnx);
            Assert.assertNull(notif);

        } finally {
            ConnectionFactory.close(cnx);
        }
    }

    @Test
    public void testFindAllByEmail() throws SQLException {
        Connection cnx = null;
        try {
            cnx = ConnectionFactory.getInstance().getConnection();

            List<Notification> notifs = NotificationDao.findAllByEmail(null,
                    cnx);
            Assert.assertNull(notifs);

            notifs = NotificationDao.findAllByEmail("test1@test.test", null);
            Assert.assertNull(notifs);

            notifs = NotificationDao.findAllByEmail("test1@test.test", cnx);
            Assert.assertNotNull(notifs);
            Assert.assertEquals(2, notifs.size());
            Assert.assertEquals(0, notifs.get(0).getActivated());
            Assert.assertEquals("test1@test.test", notifs.get(0).getEmail());
            Assert.assertEquals(1, notifs.get(0).getIdCanal());
            Assert.assertEquals(idNotif1, notifs.get(0).getIdNotification());

            Assert.assertEquals(1, notifs.get(1).getActivated());
            Assert.assertEquals("test1@test.test", notifs.get(1).getEmail());
            Assert.assertEquals(3, notifs.get(1).getIdCanal());

        } finally {
            ConnectionFactory.close(cnx);
        }
    }

    @Test
    public void testFindAllByEmailTypeCanal() throws SQLException {
        Connection cnx = null;
        try {
            cnx = ConnectionFactory.getInstance().getConnection();

            Notification notif = NotificationDao.findAllByCanalEmail(1, null,
                    cnx);
            Assert.assertNull(notif);

            notif = NotificationDao.findAllByCanalEmail(1, "test@test.test",
                    null);
            Assert.assertNull(notif);

            notif = NotificationDao.findAllByCanalEmail(1, "test1@test.test",
                    cnx);
            Assert.assertNotNull(notif);
            Assert.assertEquals(0, notif.getActivated());
            Assert.assertEquals("test1@test.test", notif.getEmail());
            Assert.assertEquals(1, notif.getIdCanal());
            Assert.assertEquals(idNotif1, notif.getIdNotification());

        } finally {
            ConnectionFactory.close(cnx);
        }
    }

    @Test
    public void testFindAllByIdPushEmail() throws SQLException {
        Connection cnx = null;
        try {
            cnx = ConnectionFactory.getInstance().getConnection();

            Notification notif = NotificationDao.findAllByCanalEmail(1, null,
                    cnx);
            Assert.assertNull(notif);

            notif = NotificationDao.findAllByCanalEmail(1, "test1@test.test",
                    null);
            Assert.assertNull(notif);

            notif = NotificationDao.findAllByCanalEmail(1, "test1@test.test",
                    cnx);
            Assert.assertNotNull(notif);
            Assert.assertEquals(0, notif.getActivated());
            Assert.assertEquals("test1@test.test", notif.getEmail());
            Assert.assertEquals(1, notif.getIdCanal());
            Assert.assertEquals(idNotif1, notif.getIdNotification());

        } finally {
            ConnectionFactory.close(cnx);
        }
    }

    @Test
    public void testUpdateIsActivated() throws SQLException {
        Connection cnx = null;
        try {
            cnx = ConnectionFactory.getInstance().getConnection();
            NotificationDao.updateIsActivated(null, cnx);

            NotificationDao.updateIsActivated(new Notification(), null);

            NotificationDao.updateIsActivated(new Notification(), cnx);

            Notification notif = new Notification();
            notif.setActivated(1);

            NotificationDao.updateIsActivated(notif, cnx);

            Notification res = NotificationDao.findAllByCanalEmail(1,
                    "test1@test.test", cnx);
            Assert.assertEquals(1, res.getActivated());

            notif = new Notification();
            notif.setActivated(0);

            NotificationDao.updateIsActivated(notif, cnx);

            res = NotificationDao
                    .findAllByCanalEmail(1, "test1@test.test", cnx);
            Assert.assertEquals(0, res.getActivated());

        } finally {
            ConnectionFactory.close(cnx);
        }
    }
}
