package test.com.betacom.architecture.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.betacom.architecture.dao.CorsistaDAO;
import com.betacom.architecture.dao.DAOException;
import com.betacom.architecture.dbaccess.DBAccess;
import com.betacom.businesscomponent.model.Corsista;

class CorsistaDAOTest {
	private Connection conn;
	private Corsista corsista;

	@BeforeEach
	void setUp() throws Exception {
		conn = DBAccess.getConnection();
		corsista = new Corsista();
		corsista.setCodCorsista(131);
		corsista.setNomeCorsista("Mario");
		corsista.setCognomeCorsista("Giallo");
		corsista.setPrecForm(1);
	}

	@AfterEach
	void tearDown() throws Exception {
		try {
			CorsistaDAO.getFactory().delete(conn, corsista);
			System.out.println("Tabella ripulita");
		} catch(DAOException exc) {
			exc.printStackTrace();
			fail("Errore nella pulizia dei record");
		}
	}

	@Test
	void testCreate() {
		try {
			CorsistaDAO.getFactory().create(conn, corsista);
			System.out.println("Corsista creato");
		} catch(DAOException exc) {
			exc.printStackTrace();
			fail("Create fallito");
		}
	}
	
	@Test
	void testDelete() {
		try {
			CorsistaDAO.getFactory().create(conn, corsista);
			CorsistaDAO.getFactory().delete(conn, corsista);
			System.out.println("Corsista eliminato");
		} catch(DAOException exc) {
			exc.printStackTrace();
			fail("Create fallito");
		}
	}
	
	@Test
	void TestGetAll() {
		try {
			CorsistaDAO.getFactory().create(conn, corsista);
			List<Corsista> corsista = CorsistaDAO.getFactory().getAll(conn);
			assertNotNull(corsista);
			System.out.printf("Lista corsisti:");
			for(Corsista c: corsista)
				System.out.println(c.toString());
		} catch(DAOException exc) {
			exc.printStackTrace();
			fail("Recupero getAll fallito");
		}
	}

}
