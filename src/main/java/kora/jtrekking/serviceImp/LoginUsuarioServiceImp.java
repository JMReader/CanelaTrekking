package kora.jtrekking.serviceImp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import kora.jtrekking.model.Usuario;
import kora.jtrekking.repoDAO.IUsuarioRepoDAO;


@Service
public class LoginUsuarioServiceImp implements UserDetailsService {
	
	@Autowired
	IUsuarioRepoDAO repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		//metodo que nos devolvera los detalle del usuario con su username.
		Usuario encontrado = repo.findByuserName(username).orElseThrow(() -> new UsernameNotFoundException("Usuario inválido"));
		
		//generamos lista autorizaciones
		List<GrantedAuthority> tipos = new ArrayList<>();
		System.out.println(encontrado.getRol());
		
		//genberamos tipos de autorizaciones
		GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(encontrado.getRol());
		tipos.add(grantedAuthority);
		
		//devolvemos los detalle del usuario en sesion
		UserDetails user = (UserDetails) new User(encontrado.getUserName(), encontrado.getClave(), tipos);
		return user;
	}

}
