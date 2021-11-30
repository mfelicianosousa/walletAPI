package br.com.mfssystems.wallet.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mfssystems.wallet.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

		Optional<Usuario> findByEmailEquals(String email) ;
}
