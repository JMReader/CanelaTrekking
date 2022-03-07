package kora.jtrekking.service;


import kora.jtrekking.model.Usuario;

public interface IUsuarioService {
	public void guardarUsuario(Usuario unUsuario);
	public Usuario crearUsuario();
	public Usuario EncontrarUsuarioPorNombre(String username) throws Exception;
	public void modificarUsuario(Usuario usuarioNuevo) throws Exception;
}
