package br.com.mfssystems.wallet.service;


import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.mfssystems.wallet.entity.Usuario;
import br.com.mfssystems.wallet.repository.UsuarioRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class UsuarioServiceTest {

	@MockBean
	UsuarioRepository repository ;
	
	@Autowired
	UsuarioService service;
	
	@Before
	public void setUp() {
		BDDMockito.given( repository.findByEmailEquals( Mockito.anyString())).willReturn( Optional.of( new Usuario()));
		
	}
	
	public void testFindByEmail() {
		
		Optional<Usuario> usuario = service.findByEmail("email@teste.com") ;
	    assertTrue(usuario.isPresent());
	}
}
