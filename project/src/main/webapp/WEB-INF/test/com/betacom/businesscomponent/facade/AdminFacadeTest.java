package test.com.betacom.businesscomponent.facade;

import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.sql.Connection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

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
import com.betacom.businesscomponent.model.Docente;

@TestMethodOrder(OrderAnnotation.class)
class AdminFacadeTest {
	Connection conn;
	Corsista corsista;
	static Corso corso;
	Corsista corsista2;
	Corsista corsista3;
	static Corso corso2;
	
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
		
		corso2 = new Corso();
		corso2.setCodCorso(8);
		corso2.setAulaCorso("AB12");
		corso2.setCommentiCorso("commento corso");
		corso2.setCostoCorso(1500.00);
		corso2.setDocente(800);
		corso2.setNomeCorso("corso di prova");
		GregorianCalendar gc2 = new GregorianCalendar(2020, 9, 2);
		corso2.setDataInizioCorso(gc2.getTime());
		corso2.setDataFineCorso(new Date());
		
		CorsoBC corsoBC = new CorsoBC();
		corsoBC.create(corso);
		corsoBC.create(corso2);
		System.out.println("Corso di prova creato");
	}
	
	@BeforeEach
	void setUp() throws Exception {
		conn = DBAccess.getConnection();
		corsista = new Corsista();
		corsista.setNomeCorsista("Mario");
		corsista.setCognomeCorsista("Giallo");
		corsista.setPrecForm(1);
		
		corsista2 = new Corsista();
		corsista2.setNomeCorsista("Marco");
		corsista2.setCognomeCorsista("Viola");
		corsista2.setPrecForm(0);
		
		corsista3 = new Corsista();
		corsista3.setNomeCorsista("Marta");
		corsista3.setCognomeCorsista("Rossi");
		corsista3.setPrecForm(1);
	}

	@AfterEach
	void tearDown() throws Exception {
		try {
			CorsistaBC cBC = new CorsistaBC();
			cBC.delete(corsista);
			cBC.delete(corsista2);
			cBC.delete(corsista3);
			System.out.println("Tabella ripulita");
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
			AdminFacade.getInstance().createCorsista(corsista2, corso);
			AdminFacade.getInstance().createCorsista(corsista3, corso2);
			System.out.println("Corsista creato");
		} catch(DAOException | ClassNotFoundException | IOException exc) {
			exc.printStackTrace();
			fail("Errore nel CreateCorsista");
		}
	}
	
	@Test
	@Order(2)
	void testGetCorsisti() {
		try {
			AdminFacade.getInstance().createCorsista(corsista, corso);
			AdminFacade.getInstance().createCorsista(corsista2, corso);
			AdminFacade.getInstance().createCorsista(corsista3, corso2);
			List<Corsista> corsisti = AdminFacade.getInstance().getCorsisti();
			for(Corsista c: corsisti)
				System.out.println(c.toString());
			System.out.println("getCorsisti funzionate");
		} catch(DAOException | ClassNotFoundException | IOException exc) {
			exc.printStackTrace();
			fail("Errore nel getCorsisti");
		}
	}
	
	@Test
	@Order(3)
	void testGetNumber() {
		try {
			AdminFacade.getInstance().createCorsista(corsista, corso);
			AdminFacade.getInstance().createCorsista(corsista2, corso);
			AdminFacade.getInstance().createCorsista(corsista3, corso2);
			System.out.println("getNumber funzionate: " + AdminFacade.getInstance().getNumber());
		} catch(DAOException | ClassNotFoundException | IOException exc) {
			exc.printStackTrace();
			fail("Errore nel getNumber");
		}
	}
	
	@Test
	@Order(4)
	void testGetTrendCourse() {
		try {
			AdminFacade.getInstance().createCorsista(corsista, corso);
			AdminFacade.getInstance().createCorsista(corsista2, corso);
			AdminFacade.getInstance().createCorsista(corsista3, corso2);
			Corso c = AdminFacade.getInstance().getTrendCourse();
			System.out.println("getTrendCourse funzionate: " + c.toString());
		} catch(DAOException | ClassNotFoundException | IOException exc) {
			exc.printStackTrace();
			fail("Errore nel getTrendCourse");
		}
	}
	
	@Test
	@Order(5)
	void testGetLastDate() {
		try {
			AdminFacade.getInstance().createCorsista(corsista, corso);
			AdminFacade.getInstance().createCorsista(corsista2, corso);
			AdminFacade.getInstance().createCorsista(corsista3, corso2);
			Date d = AdminFacade.getInstance().getLastDate();
			System.out.println("getLastDate funzionante: " + d);
		} catch(DAOException | ClassNotFoundException | IOException exc) {
			exc.printStackTrace();
			fail("Errore nel lastDate");
		}
	}
	
	@Test
	@Order(6)
	void testGetMidLength() {
		try {
			AdminFacade.getInstance().createCorsista(corsista, corso);
			AdminFacade.getInstance().createCorsista(corsista2, corso);
			AdminFacade.getInstance().createCorsista(corsista3, corso2);
			int day = AdminFacade.getInstance().getMidLength();
			System.out.println("getMidLength funzionante: " + day);
		} catch(DAOException | ClassNotFoundException | IOException exc) {
			exc.printStackTrace();
			fail("Errore nel getMidLength");
		}
	}
	
	@Test
	@Order(7)
	void testComment() {
		try {
			AdminFacade.getInstance().createCorsista(corsista, corso);
			AdminFacade.getInstance().createCorsista(corsista2, corso);
			AdminFacade.getInstance().createCorsista(corsista3, corso2);
			int comment = AdminFacade.getInstance().getComment();
			System.out.println("getComment funzionante: " + comment);
		} catch(DAOException | ClassNotFoundException | IOException exc) {
			exc.printStackTrace();
			fail("Errore nel getComment");
		}
	}
	
	@Test
	@Order(8)
	void testGetTeacherCourses() {
		try {
			AdminFacade.getInstance().createCorsista(corsista, corso);
			AdminFacade.getInstance().createCorsista(corsista2, corso);
			AdminFacade.getInstance().createCorsista(corsista3, corso2);
			List<Docente> docenti = AdminFacade.getInstance().getTeacherCourses();
			for(Docente d: docenti)
				System.out.println(d.toString());
			System.out.println("getTeacherCourses funzionante");
		} catch(DAOException | ClassNotFoundException | IOException exc) {
			exc.printStackTrace();
			fail("Errore nel getTeacherCourses");
		}
	}
	
	@Test
	@Order(9)
	void testgetSlotsAvailable() {
		try {
			AdminFacade.getInstance().createCorsista(corsista, corso);
			AdminFacade.getInstance().createCorsista(corsista2, corso);
			AdminFacade.getInstance().createCorsista(corsista3, corso2);
			int posti = AdminFacade.getInstance().getSlotsAvailable(corso);
			System.out.println("getSlotsAvailable funzionante: " + posti);
		} catch(DAOException | ClassNotFoundException | IOException exc) {
			exc.printStackTrace();
			fail("Errore nel getSlotsAvailable");
		}
	}
	
	@Test
	@Order(10)
	void testGetCorsi() {
		try {
			AdminFacade.getInstance().createCorsista(corsista, corso);
			AdminFacade.getInstance().createCorsista(corsista2, corso);
			AdminFacade.getInstance().createCorsista(corsista3, corso2);
			List<Corso> corsi = AdminFacade.getInstance().getCorsi();
			for(Corso c: corsi)
				System.out.println(c.toString());
			System.out.println("getCorsifunzionate");
		} catch(DAOException | ClassNotFoundException | IOException exc) {
			exc.printStackTrace();
			fail("Errore nel getCorsisti");
		}
	}
	
	

	@AfterAll
	static void tearAfterAll() throws Exception {
		try {
			CorsoBC corsoBC = new CorsoBC();
			corsoBC.delete(corso);
			corsoBC.delete(corso2);
			System.out.println("Tabelle ripulite");
		} catch(DAOException exc) {
			exc.printStackTrace();
			fail("Errore nella pulizia dei record");
		}
	}
}
