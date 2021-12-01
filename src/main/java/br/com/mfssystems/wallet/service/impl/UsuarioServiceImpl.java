package br.com.mfssystems.wallet.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mfssystems.wallet.entity.Usuario;
import br.com.mfssystems.wallet.repository.UsuarioRepository;
import br.com.mfssystems.wallet.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	UsuarioRepository repository ;
	
	@Override
	public Usuario save(Usuario usuario) {
		
		return repository.save( usuario );
	}

	@Override
	public Optional<Usuario> findByEmail(String email) {
		
		return repository.findByEmailEquals(email);
	}

}
