package test.com.betacom.businesscomponent;

import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.betacom.architecture.dao.DAOException;
import com.betacom.architecture.dbaccess.DBAccess;
import com.betacom.businesscomponent.CorsoBC;
import com.betacom.businesscomponent.model.Corso;
import com.betacom.businesscomponent.model.Docente;

public class CorsoBCTest {
	Connection conn;
	Corso corso;
	Docente docente;

	@BeforeEach
	 void setUp() throws Exception {
		conn = DBAccess.getConnection();
		corso = new Corso();
		corso.setCodCorso(999);
		corso.setNomeCorso("Offerte Piccol");
		corso.setDataInizioCorso(new GregorianCalendar(2000, 9, 15).getTime());
		corso.setDataFineCorso(new GregorianCalendar(2001, 6, 30).getTime());
		corso.setCostoCorso(2400.00);
		corso.setCommentiCorso("solo per ieri a pochi euro");
		corso.setAulaCorso("29H");
		corso.setDocente(541);
	}
	
	
	@Test
	void testCreate(){
		try {
			CorsoBC cBC = new CorsoBC();
			cBC.create(corso);
			System.out.println("Corso creato");
		} catch(DAOException | ClassNotFoundException | IOException exc) {
			exc.printStackTrace();
			fail("Errore creazione corso");
		}
	}

	@Test
	void testGetCorsi() throws ClassNotFoundException, IOException, SQLException {
		try {
			List<Corso> corsi = CorsoBC.getFactory().getCorsi();
				System.out.println(corsi);
		} catch (DAOException exc) {
			exc.printStackTrace();
			fail("Recupero corsi fallito");
		}
	}
	
	@Test
	void testGetComment() throws ClassNotFoundException, IOException, SQLException {
		try {
			int nCommenti = CorsoBC.getFactory().getComment();
			System.out.println("Numero di commenti: " + nCommenti);
		} catch (DAOException exc) {
			exc.printStackTrace();
			fail("Recupero commenti fallito");
		}
	}
	
	@Test
	void testgetTeacherCourses() throws ClassNotFoundException, IOException, SQLException {
		try {
			List<Docente> teacher = CorsoBC.getFactory().getTeacherCourses();
			System.out.println("Docenti con più corsi: " + teacher);
		} catch (DAOException exc) {
			exc.printStackTrace();
			fail("Recupero commenti fallito");
		}
	}
	
	@Test
	void testGetLastDate() throws ClassNotFoundException, IOException, SQLException {
		try {
			Date LastDate = CorsoBC.getFactory().getLastDate();
			System.out.println("L' ultima data di inizio corso è: " + LastDate);
		} catch (DAOException exc) {
			exc.printStackTrace();
			fail("Recupero commenti fallito");
		}
	}
	
	
	  @Test 
	  void testMidLength() throws ClassNotFoundException, IOException, SQLException { 
		  try { 
		  	int MidLength = CorsoBC.getFactory().getMidLenght();
		  	System.out.println("La media in giorni di tutti i corsi è: " + MidLength); 
		  } catch (DAOException exc) { 
			exc.printStackTrace();
		  	fail("Recupero media giorni fallito"); 
		  } 
	  }
	 
	
	@Test
	void testgetCorsiAvailable() throws ClassNotFoundException, IOException, SQLException {
		try {
			List<Corso> CorsiAvailable = CorsoBC.getFactory().getCorsiAvailable();
			System.out.println("I corsi con posti disponibili sono: " + CorsiAvailable);
		} catch (DAOException exc) {
			exc.printStackTrace();
			fail("Recupero commenti fallito");
		}
	}
	
	@Test
	void testDelete() throws Exception {
		try {
			CorsoBC cBC = new CorsoBC();
			cBC.delete(corso);
			System.out.println("Corso eliminato");
		} catch(DAOException exc) {
			exc.printStackTrace();
			fail("Errore nella pulizia dei record");
		}
	}
}
