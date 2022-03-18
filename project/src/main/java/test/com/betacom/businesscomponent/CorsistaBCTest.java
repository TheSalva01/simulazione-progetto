package test.com.betacom.businesscomponent;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.betacom.architecture.dao.DAOException;
import com.betacom.architecture.dbaccess.DBAccess;
import com.betacom.businesscomponent.CorsistaBC;
import com.betacom.businesscomponent.model.Corsista;

class CorsistaBCTest {
	Connection conn;
	Corsista corsista;

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
			CorsistaBC cBC = new CorsistaBC();
			cBC.delete(corsista);
			System.out.println("Tabella ripulita");
		} catch(DAOException exc) {
			exc.printStackTrace();
			fail("Errore nella pulizia dei record");
		}
	}

	@Test
	void testCreate(){
		try {
			CorsistaBC cBC = new CorsistaBC();
			cBC.create(corsista);
			System.out.println("Corsista creato");
		} catch(DAOException | ClassNotFoundException | IOException exc) {
			exc.printStackTrace();
			fail("Errore nella pulizia dei record");
		}
	}
	
	@Test
	void testGetAll() {
		try {
			CorsistaBC cBC = new CorsistaBC();
			cBC.create(corsista);
			List<Corsista> corsisti = cBC.getAll();
			assertNotNull(corsisti);
			System.out.printf("Lista corsisti:");
			for(Corsista c: corsisti)
				System.out.println(c.toString());
		} catch(DAOException | ClassNotFoundException | IOException exc) {
			exc.printStackTrace();
			fail("Errore nella pulizia dei record");
		}
	}
	
	@Test
	void testGetNumber() {
		try {
			CorsistaBC cBC = new CorsistaBC();
			cBC.create(corsista);
			int valore = cBC.getNumber();
			System.out.println("Numero di corsisti: " + valore);
		} catch(DAOException | ClassNotFoundException | IOException exc) {
			exc.printStackTrace();
			fail("Errore nella pulizia dei record");
		}
	}
	
	@Test
	void testDelete(){
		try {
			CorsistaBC cBC = new CorsistaBC();
			cBC.create(corsista);
			cBC.delete(corsista);
			System.out.println("Corsista eliminato");
		} catch(DAOException | ClassNotFoundException | IOException exc) {
			exc.printStackTrace();
			fail("Errore nella pulizia dei record");
		}
	}
}
