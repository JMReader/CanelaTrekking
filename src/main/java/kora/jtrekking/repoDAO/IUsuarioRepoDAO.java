package kora.jtrekking.repoDAO;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import kora.jtrekking.model.Usuario;

@Repository
public interface IUsuarioRepoDAO extends CrudRepository <Usuario, Integer> {
	
	public Optional <Usuario> findByuserName(String usuario);
}
