package kora.jtrekking.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import kora.jtrekking.model.Usuario;
import kora.jtrekking.repoDAO.IUsuarioRepoDAO;
import kora.jtrekking.service.IUsuarioService;


@Service
@Qualifier("implementacionUsuario")
public class UsuarioServiceMySQL implements IUsuarioService{


	@Autowired
	Usuario unUsuario;
	@Autowired
	IUsuarioRepoDAO repo;
	
	@Override
	public void guardarUsuario(Usuario unUsuario) {
		// TODO Auto-generated method stub
		String contra = unUsuario.getClave(); 
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
		unUsuario.setClave(bCryptPasswordEncoder.encode(contra));
		repo.save(unUsuario);
	}

	@Override
	public Usuario crearUsuario() {
		// TODO Auto-generated method stub
		return unUsuario;
	}

	@Override
	public Usuario EncontrarUsuarioPorNombre(String username) throws Exception {
		// TODO Auto-generated method stub
		return repo.findByuserName(username).orElseThrow(()->new Exception("El usuario no fue encontrado"));
	}

	@Override
	public void modificarUsuario(Usuario usuarioNuevo) throws Exception {
		// TODO Auto-generated method stub
		Usuario usuarioViejo = repo.findById(usuarioNuevo.getId()).orElseThrow(()->new Exception("El usuario no fue encontrado"));
		cambiarUsuarios(usuarioViejo, usuarioNuevo);
		repo.save(usuarioViejo);
	}
	private void cambiarUsuarios(Usuario usuarioViejo, Usuario usuarioNuevo) {
		usuarioViejo.setClave(usuarioNuevo.getClave());
		usuarioViejo.setUserName(usuarioNuevo.getUserName());
	}

}
