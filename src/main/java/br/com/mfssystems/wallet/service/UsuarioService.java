package br.com.mfssystems.wallet.service;

import java.util.Optional;

import br.com.mfssystems.wallet.entity.Usuario;

public interface UsuarioService {
	
	Usuario save( Usuario usuario );
	
	Optional<Usuario> findByEmail( String email ) ;

}
