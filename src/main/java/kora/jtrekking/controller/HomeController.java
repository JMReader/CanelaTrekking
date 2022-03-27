package kora.jtrekking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kora.jtrekking.model.Usuario;
import kora.jtrekking.repoDAO.ICircuitoRepoDAO;
import kora.jtrekking.service.ICircuitoService;
import kora.jtrekking.serviceImp.UsuarioServiceMySQL;




@Controller
public class HomeController {
	
	@Autowired
	ICircuitoRepoDAO circuitoRepo;
	@Autowired
	UsuarioServiceMySQL usuarioRepo;
	@Autowired
	@Qualifier("implementacionCircuito")
	ICircuitoService circuitoSer;
	@GetMapping({"/home"})
	public String cargarhome(Model model){
		//mandamos un atributo al modelo de pagina que nos servira para mostrar el header de dsitintas maneras dependiendo el tipo de pagina que estemos consultando.
		model.addAttribute("pag", "home");
		model.addAttribute("circuitos", circuitoSer.obtenerTodosCircuito());
		model.addAttribute("titulo", "Todos los circuitos");
		return "index";
	}
	
	@GetMapping({"/quienesSomos"})
	public String cargaqSomos(Model model){
		model.addAttribute("pag", "QS");
		return "quienesSomos";
	}
	
	@GetMapping({"/valle"})
	public String cargaValle(Model model){
		model.addAttribute("pag", "val");
		model.addAttribute("circuitos", circuitoRepo.mostrarCircuitosValle());
		model.addAttribute("titulo", "Circuitos del Valle");
		return "index";
	}
	@GetMapping({"/puna"})
	public String cargaPuna(Model model){
		model.addAttribute("pag", "pun");
		model.addAttribute("circuitos", circuitoRepo.mostrarCircuitosPuna());
		model.addAttribute("titulo", "Circuitos de la Puna");
		return "index";
	}
	@GetMapping({"/quebrada"})
	public String cargaQuebrada(Model model){
		model.addAttribute("pag", "queb");
		model.addAttribute("circuitos", circuitoRepo.mostrarCircuitosQueb());
		model.addAttribute("titulo", "Circuitos de la Quebrada");
		return "index";
	}
	@GetMapping({"/yungas"})
	public String cargaYungas(Model model){
		model.addAttribute("pag", "yung");
		model.addAttribute("circuitos", circuitoRepo.mostrarCircuitosYung());
		model.addAttribute("titulo", "Circuitos de las Yungas");
		return "index";
	}
	
	
	
	
	}
