package test.com.betacom.architecture.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.betacom.architecture.dao.CorsoDAO;
import com.betacom.architecture.dao.DAOException;
import com.betacom.architecture.dbaccess.DBAccess;
import com.betacom.businesscomponent.model.Corso;
import com.betacom.businesscomponent.model.Docente;

@TestMethodOrder(OrderAnnotation.class)
class CorsoDAOTest {
	private static Corso corso;
	private static Connection conn;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		conn = DBAccess.getConnection();
		corso = new Corso();
		corso.setCodCorso(999);
		corso.setNomeCorso("Offerte Piccol");
		corso.setDataInizioCorso(new GregorianCalendar(2000, 9, 15).getTime());
		corso.setDataFineCorso(new GregorianCalendar(2001, 6, 30).getTime());
		corso.setCostoCorso(2400.00);
		corso.setCommentiCorso(new String []{"solo per ieri a pochi euro"});
		corso.setAulaCorso("29H");
		corso.setDocente(541);
		System.out.println(corso);
	}
	
	@Test
	@Order(1)
	void testGetById() {
		try {
			Corso corso = CorsoDAO.getFactory().getById(conn, 4);
			System.out.println(corso.toString());

		} catch (DAOException exc) {
			exc.printStackTrace();
			fail(exc.getMessage());
		}
	}

	
	@Test
	@Order(2)
	void testGetAll() {
		try {
			List<Corso> corsi = CorsoDAO.getFactory().getAll(conn);
			assertNotNull(corsi);
			System.out.println(corsi);
		} catch (DAOException exc) {
			exc.printStackTrace();
			fail("Recupero corsi fallito");
		}
	}
	
	@Test
	@Order(3)
	void getDocenti() {
		try {
			List<Docente> docenti = CorsoDAO.getFactory().getDocenti(conn);
			assertNotNull(docenti);
			System.out.println(docenti);
		}catch (DAOException exc) {
			exc.printStackTrace();
			fail("Recupero Docenti fallito");
		}
	}
	
	
	
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		try {
			CorsoDAO.getFactory().delete(conn, corso);
			System.out.println("Corso eliminato");
		} catch (DAOException exc) {
			exc.printStackTrace();
			fail("Delete corso fallito");
		}
	}
}
