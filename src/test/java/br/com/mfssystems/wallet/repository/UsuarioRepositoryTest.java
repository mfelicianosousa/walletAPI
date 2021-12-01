package br.com.mfssystems.wallet.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.mfssystems.wallet.entity.Usuario;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class UsuarioRepositoryTest {
	
	private static final String EMAIL = "email@teste.com";

	@Autowired
	UsuarioRepository repository ;
	
	@Before
	public void setUp() {
		Usuario usuario = new Usuario();
		usuario.setNome("Set Up User");
		usuario.setPassword("Senha123");
		usuario.setEmail(EMAIL);
		repository.save(usuario);
	}
	
	@After 
	public void tearDown() {
		repository.deleteAll();
	}
	
	@Test
	public void testSave() {
		
		Usuario usuario = new Usuario() ;
		usuario.setNome("Teste");
		usuario.setPassword("123456");
		usuario.setEmail("teste@teste.com") ;
		Usuario response = repository.save( usuario );
		
		assertNotNull(response);
	}
	
	public void testFindByEmail() {
		Optional<Usuario> response = repository.findByEmailEquals(EMAIL);
		assertTrue(response.isPresent());
		assertEquals(response.get().getEmail(),EMAIL);
	}
	
}
