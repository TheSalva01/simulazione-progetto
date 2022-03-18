package test.com.betacom.architecture.dao;

import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Connection;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.betacom.architecture.dao.CorsoCorsistaDAO;
import com.betacom.architecture.dao.DAOException;
import com.betacom.architecture.dbaccess.DBAccess;
import com.betacom.businesscomponent.model.CorsoCorsista;

@TestMethodOrder(OrderAnnotation.class)
class CorsoCorsistaDAOTest {

	private static CorsoCorsista corsoCorsista;
	private static Connection conn; 
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		conn = DBAccess.getConnection();
		
		corsoCorsista = new CorsoCorsista();
		corsoCorsista.setCodCorsista(1);
		corsoCorsista.setCodCorso(1);
	}

	@Test
	@Order(0)
	void testCreate() {
		try {
			CorsoCorsistaDAO.getFactory().create(conn, corsoCorsista);
		} catch (DAOException e) {
			fail("Failed to create CorsoCorsista");
		}
	}

}
