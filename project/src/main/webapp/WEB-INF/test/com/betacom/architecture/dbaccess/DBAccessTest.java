package test.com.betacom.architecture.dbaccess;

import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.betacom.architecture.dao.DAOException;
import com.betacom.architecture.dbaccess.DBAccess;

class DBAccessTest {

	@Test
	void testConnessione() {
		try {
			DBAccess.getConnection();
		} catch (ClassNotFoundException | DAOException | IOException ex) {
			ex.printStackTrace();
			fail("Can't open connection");
		} finally {
			try {
				DBAccess.closeConnection();
			} catch (DAOException ex) {
				ex.printStackTrace();
				fail("Can't close connection");
			}
		}
	}

}
