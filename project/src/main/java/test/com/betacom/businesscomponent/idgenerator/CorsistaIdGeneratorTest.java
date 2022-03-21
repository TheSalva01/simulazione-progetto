package test.com.betacom.businesscomponent.idgenerator;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.betacom.architecture.dao.DAOException;
import com.betacom.businesscomponent.idgenerator.CorsistaIdGenerator;

class CorsistaIdGeneratorTest {

	@Test
	void test() {
		try {
			CorsistaIdGenerator corsIdGen = CorsistaIdGenerator.getInstance();
			assertNotNull(corsIdGen, "Istanza non creata correttamente");
			long valore = corsIdGen.nextVal();
			assertEquals(valore, corsIdGen.nextVal() - 1);
		} catch(ClassNotFoundException | DAOException | IOException exc) {
			exc.printStackTrace();
			fail("Valore non generato correttamente");
		}
	}
}
