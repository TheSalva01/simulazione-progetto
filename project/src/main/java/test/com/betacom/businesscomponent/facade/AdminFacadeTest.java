package test.com.betacom.businesscomponent.facade;

import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.sql.Connection;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.betacom.architecture.dao.DAOException;
import com.betacom.architecture.dbaccess.DBAccess;
import com.betacom.businesscomponent.CorsistaBC;
import com.betacom.businesscomponent.CorsoBC;
import com.betacom.businesscomponent.facade.AdminFacade;
import com.betacom.businesscomponent.model.Corsista;
import com.betacom.businesscomponent.model.Corso;
import com.betacom.businesscomponent.model.CorsoCorsista;

@TestMethodOrder(OrderAnnotation.class)
class AdminFacadeTest {
	Connection conn;
	Corsista corsista;
	static Corso corso;
	CorsoCorsista cc;
	
	@BeforeAll
	static void setBeforeAll() throws Exception {
		corso = new Corso();
		corso.setCodCorso(7);
		corso.setAulaCorso("AB12");
		corso.setCommentiCorso("commento corso");
		corso.setCostoCorso(1500.00);
		corso.setDocente(800);
		corso.setNomeCorso("corso di prova");
		GregorianCalendar gc = new GregorianCalendar(2021, 9, 2);
		corso.setDataInizioCorso(gc.getTime());
		corso.setDataFineCorso(new Date());
		
		CorsoBC corsoBC = new CorsoBC();
		corsoBC.create(corso);
		System.out.println("Corso di prova creato");
	}
	
	@BeforeEach
	void setUp() throws Exception {
		conn = DBAccess.getConnection();
		corsista = new Corsista();
		corsista.setNomeCorsista("Mario");
		corsista.setCognomeCorsista("Giallo");
		corsista.setPrecForm(1);
	}

	@AfterEach
	void tearDown() throws Exception {
		try {
			CorsistaBC cBC = new CorsistaBC();
			cBC.delete(corsista);
			System.out.println("Tabelle ripulite");
		} catch(DAOException exc) {
			exc.printStackTrace();
			fail("Errore nella pulizia dei record");
		}
	}

	@Test
	@Order(1)
	void testCreateCorsista() {
		try {
			AdminFacade.getInstance().createCorsista(corsista, corso);
			System.out.println("Corsista creato");
		} catch(DAOException | ClassNotFoundException | IOException exc) {
			exc.printStackTrace();
			fail("Errore nel CreateCorsista");
		}
	}
	
	@AfterAll
	static void tearAfterAll() throws Exception {
		try {
			CorsoBC corsoBC = new CorsoBC();
			corsoBC.delete(corso);
			System.out.println("Tabelle ripulite");
		} catch(DAOException exc) {
			exc.printStackTrace();
			fail("Errore nella pulizia dei record");
		}
	}
}
