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
public class UtilisateurDaoTest {

	private static boolean setup = false;
	private static final String IDNAT1 = "9827364559";
	private static int iDUTILISATEUR1 = -1;
	private static final String IDNAT2 = "1027364559";
	private static int iDUTILISATEUR2 = -1;
	private static final String IDNAT3 = "4782156332";
	private static final String IDNATTESTGETALL = "0123456789";

	/**
	 * setup.
	 * 
	 * @throws Exception
	 *             exception
	 */
	@Before
	public void setUp() throws Exception {
		if (!setup) {
			System.out.println("DEBUG - setUp()");
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
				Utilisateur utilisateur2 = new Utilisateur();
				utilisateur2.setIdNat(IDNAT2);
				utilisateur2.setNom("Jean");
				utilisateur2.setPrenom("Dupont");
				utilisateur2.setProfession("medecin");
				utilisateur2.setMail("email@email.com");
				utilisateur2.setTypeUtilisateur("PS");
				iDUTILISATEUR2 = UtilisateurDao.add(utilisateur2, cnx);
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
	public void testFindByIdNat() throws SQLException {
		System.out.println("DEBUG - FindByIdNat()");
		Connection cnx = null;
		try {
			cnx = ConnectionFactory.getInstance().getConnection();
			Utilisateur u = UtilisateurDao.findByIdNat(IDNAT1, cnx);
			Assert.assertNotNull(u);
			Assert.assertEquals(IDNAT1, u.getIdNat());
			Assert.assertEquals(iDUTILISATEUR1, u.getIdUtilisateur());
			Assert.assertEquals(1, u.getStatut());
		} finally {
			ConnectionFactory.close(cnx);
		}
	}

	@Test
	public void testFindByIdNatAucunResultat() throws SQLException {
		System.out.println("DEBUG - FindByIdNatAucunResultat()");
		Connection cnx = null;
		try {
			cnx = ConnectionFactory.getInstance().getConnection();
			Utilisateur u = UtilisateurDao.findByIdNat("toto", cnx);
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
	public void testAdd() throws SQLException {
		System.out.println("DEBUG - Add()");
		Connection cnx = null;
		try {
			cnx = ConnectionFactory.getInstance().getConnection();
			Utilisateur utilisateur3 = new Utilisateur();
			utilisateur3.setIdNat(IDNAT3);
			utilisateur3.setNom("Charles");
			utilisateur3.setPrenom("Henri");
			utilisateur3.setProfession("medecin");
			utilisateur3.setMail("email@email.com");
			utilisateur3.setTypeUtilisateur("PS");
			int id = UtilisateurDao.add(utilisateur3, cnx);
			Utilisateur u = UtilisateurDao.findByIdNat(IDNAT3, cnx);
			Assert.assertNotNull(u);
			Assert.assertEquals(IDNAT3, u.getIdNat());
			Assert.assertEquals(id, u.getIdUtilisateur());
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
		System.out.println("DEBUG - Delete()");
		Connection cnx = null;
		try {
			cnx = ConnectionFactory.getInstance().getConnection();
			UtilisateurDao.delete(iDUTILISATEUR2, cnx);
			Utilisateur u = UtilisateurDao.findByIdNat(IDNAT2, cnx);
			Assert.assertNull(u);
		} finally {
			ConnectionFactory.close(cnx);
		}
	}

	@Test
	public void testGetAll() throws SQLException {
		System.out.println("DEBUG - GetAll()");
		Connection cnx = null;
		try {
			cnx = ConnectionFactory.getInstance().getConnection();
			List<Utilisateur> utilisateurs = UtilisateurDao.getAll(cnx);
			int sizeIni = utilisateurs.size();

			Utilisateur utilisateurTestGetAll = new Utilisateur();
			utilisateurTestGetAll.setIdNat(IDNATTESTGETALL);
			utilisateurTestGetAll.setNom("test");
			utilisateurTestGetAll.setPrenom("getAll");
			utilisateurTestGetAll.setProfession("medecin");
			utilisateurTestGetAll.setMail("email@email.com");
			utilisateurTestGetAll.setTypeUtilisateur("PS");
			int id = UtilisateurDao.add(utilisateurTestGetAll, cnx);

			utilisateurs = UtilisateurDao.getAll(cnx);
			int sizePost = utilisateurs.size();

			// Test
			utilisateurs = UtilisateurDao.getAll(cnx);
			Assert.assertTrue(sizePost == sizeIni + 1);

			// Clean test
			UtilisateurDao.delete(id, cnx);
		} finally {
			ConnectionFactory.close(cnx);
		}
	}

}
