package kora.jtrekking.controller;

import java.io.IOException;
import java.util.Base64;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import kora.jtrekking.model.Circuito;

import kora.jtrekking.serviceImp.CircuitoServiceMySQL;

@Controller
public class Circuitocontroller {
	private static final Log LOGGER = LogFactory.getLog(Circuitocontroller.class);

	@Autowired
	CircuitoServiceMySQL repo;

	@GetMapping("/circuito/{id}")
	public String verCirc(Model model, @PathVariable(name = "id") Integer id) {
		Circuito circuitoEncontrado = repo.obtenerCircuitoid(id);
		model.addAttribute("circ", circuitoEncontrado);
		model.addAttribute("pag", "QS");
		model.addAttribute("recom", repo.obtenerRecomendaciones(id));
		return ("circuito");
	}

	@GetMapping("cargar/circuito")
	public String crearCirc(Model model) {
		LOGGER.info("METHOD: ingresando el metodo cargar");
		model.addAttribute("circuito", new Circuito());
		return ("cargar");
	}

	@GetMapping("editar/circuito/{id}")
	public String editarCirc(Model model, @PathVariable(name = "id") Integer id) {
		LOGGER.info("METHOD: ingresando el metodo cargar");
		model.addAttribute("editmode", true);
		model.addAttribute("circuito", repo.obtenerCircuitoid(id));
		return ("cargar");
	}

	@PostMapping(value = "/circuito/guardar", consumes = "multipart/form-data")
	public String guardarCirc(@RequestParam("file") MultipartFile file, @RequestParam("file1") MultipartFile file1,
			@RequestParam("file2") MultipartFile file2, @Valid @ModelAttribute("circuito") Circuito nuevoCirc,
			BindingResult resultado, Model model) throws IOException {
			
		byte[] content = file.getBytes();
		String img1 = Base64.getEncoder().encodeToString(content);
		nuevoCirc.setImagen(img1);

		byte[] content1 = file1.getBytes();
		String img2 = Base64.getEncoder().encodeToString(content1);
		nuevoCirc.setImagen1(img2);

		byte[] content2 = file2.getBytes();
		String img3 = Base64.getEncoder().encodeToString(content2);
		nuevoCirc.setImagen2(img3);

		repo.guardarCircuito(nuevoCirc);

		return ("redirect:/cargar/circuito");
	}

}
