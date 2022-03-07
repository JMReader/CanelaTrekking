package kora.trabajo;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import kora.jtrekking.model.Usuario;
import kora.jtrekking.repoDAO.IUsuarioRepoDAO;


/*
@RunWith(SpringRunner.class)
@SpringBootTest
class CanelaTrekkingApplicationTests {
	@Autowired
	IUsuarioRepoDAO repo;
	@Autowired
	private BCryptPasswordEncoder encoder;
	@Test
	void CargarUsuario(){
		
		Usuario nuevo = new Usuario();
		nuevo.setId(3);
		//nuevo.setClave(encoder.encode("xdd"));
		nuevo.setUserName("dou");
		Usuario prueba =repo.save(nuevo);
		assertTrue(prueba.getUserName().equalsIgnoreCase(nuevo.getUserName()));
	}
}
*/