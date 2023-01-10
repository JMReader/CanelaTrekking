package kora.jtrekking.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import kora.jtrekking.model.Usuario;
import kora.jtrekking.service.IUsuarioService;

@Controller
public class UsuarioController {
 
    IUsuarioService usuarioRepo;
    @PostMapping(value = "/usuario/cargar")
	public String guardarCirc( @Valid @ModelAttribute("Usuario") Usuario Usuariocargar,
			BindingResult resultado, Model model) throws IOException {

		usuarioRepo.guardarUsuario(Usuariocargar);

		return (Usuariocargar.toString());
	}


}
