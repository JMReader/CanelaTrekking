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
	/* separando los circuitos por region */
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
	
	/* separando los circuitos por dificultad*/
	
	@GetMapping({"/dif/baja"})
	public String cargarDificultadBaja(Model model){
		model.addAttribute("circuitos", circuitoRepo.circuitosDifBaja());
		model.addAttribute("titulo", "Circuitos de Dificultad Baja");
		return "index";
	}
	@GetMapping({"/dif/media"})
	public String cargarDificultadMedia(Model model){
		model.addAttribute("circuitos", circuitoRepo.circuitosDifMedia());
		model.addAttribute("titulo", "Circuitos de Dificultad Media");
		return "index";
	}
	@GetMapping({"/dif/alta"})
	public String cargarDificultadAlta(Model model){
		model.addAttribute("circuitos", circuitoRepo.circuitosDifAlta());
		model.addAttribute("titulo", "Circuitos de Dificultad Alta");
		return "index";
	}
	
	/* separando por distancia */
	
	@GetMapping({"/dis/uno"})
	public String cargarDisMenorSeis(Model model){
		model.addAttribute("circuitos", circuitoRepo.circuitosDisSeis());
		model.addAttribute("titulo", "Circuitos de menos de 6 Km");
		return "index";
	}
	@GetMapping({"/dis/dos"})
	public String cargarDisMenorDoce(Model model){
		model.addAttribute("circuitos", circuitoRepo.circuitosDisDoce());
		model.addAttribute("titulo", "Circuitos de menos de 12 Km");
		return "index";
	}
	@GetMapping({"/dis/tres"})
	public String cargarDisMenorVeinte(Model model){
		model.addAttribute("circuitos", circuitoRepo.circuitosDisDoce());
		model.addAttribute("titulo", "Circuitos de menos de 20 Km");
		return "index";
	}
	@GetMapping({"/dis/cuatro"})
	public String cargarDisMayorVeinte(Model model){
		model.addAttribute("circuitos", circuitoRepo.circuitosDisMasVeinte());
		model.addAttribute("titulo", "Circuitos de más de 20 Km");
		return "index";
	}
	
	/*filter by time*/
	
	@GetMapping({"/circ/dura/uno"})
	public String cargarDurMenorCuatro(Model model){
		model.addAttribute("circuitos", circuitoRepo.circuitosDurCuatro());
		model.addAttribute("titulo", "Circuitos de menos de 4 horas");
		return "index";
	}
	
	@GetMapping({"/circ/dura/dos"})
	public String cargarDurMenorOcho(Model model){
		model.addAttribute("circuitos", circuitoRepo.circuitosDurOcho());
		model.addAttribute("titulo", "Circuitos de menos de 8 horas");
		return "index";
	}
	@GetMapping({"/circ/dura/tres"})
	public String cargarDurMayorOcho(Model model){
		model.addAttribute("circuitos", circuitoRepo.circuitosDurMasOcho());
		model.addAttribute("titulo", "Circuitos de más de 8 horas");
		return "index";
	}
	
	
	@GetMapping({"/circ/travesias"})
	public String cargarTravesias(Model model){
		model.addAttribute("circuitos", circuitoRepo.circuitosTravesias());
		model.addAttribute("titulo", "Travesias (Circuitos de más de un día)");
		return "index";
	}
	
	}
