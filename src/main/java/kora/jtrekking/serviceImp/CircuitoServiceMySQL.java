package kora.jtrekking.serviceImp;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


import kora.jtrekking.model.Circuito;
import kora.jtrekking.repoDAO.ICircuitoRepoDAO;
import kora.jtrekking.service.ICircuitoService;

@Service
@Qualifier("implementacionCircuito")
public class CircuitoServiceMySQL implements ICircuitoService{
	@Autowired
	Circuito Circuito;
	@Autowired
	ICircuitoRepoDAO Repo;
	
	@Override
	public Circuito crearCircuito() {
		// TODO Auto-generated method stub
		return Circuito;
	}

	@Override
	public void guardarCircuito(Circuito nuevoCircuito) {
		// TODO Auto-generated method stub
		Repo.save(nuevoCircuito);
	}

	@Override
	public ArrayList<Circuito> ObtenerCircuitos() {
		// TODO Auto-generated method stub
		return (ArrayList<Circuito>) Repo.findAll();
	}

	@Override
	public void modificicarCircuito(Circuito circuitoNuevo) throws Exception{
		// TODO Auto-generated method stub
		Circuito cViejo = Repo.findByid(circuitoNuevo.getId()).orElseThrow(()->new Exception("el circuito no fue encontrado"));
		cambiarCircuito(cViejo, circuitoNuevo);
		Repo.save(cViejo);
		
	}

	@Override
	public void eliminarCircuito(Integer circuitoId) throws Exception {
		// TODO Auto-generated method stub
		Circuito circuitoEliminar = Repo.findByid(circuitoId).orElseThrow(()->new Exception("el circuito no fue encontrado"));
		Repo.delete(circuitoEliminar);
	}

	@Override
	public void cambiarCircuito(Circuito cViejo, Circuito cNuevo) throws Exception{
		// TODO Auto-generated method stub
		cViejo.setDescripcion(cNuevo.getDescripcion());
		cViejo.setDificultad(cNuevo.getDificultad());
		cViejo.setDistancia(cNuevo.getDistancia());
		cViejo.setDuracion(cNuevo.getDuracion());
		cViejo.setImagen(cNuevo.getImagen());
		cViejo.setImagen1(cNuevo.getImagen1());
		cViejo.setImagen2(cNuevo.getImagen2());
		cViejo.setOperable(cNuevo.getOperable());
		cViejo.setNivelAlt(cNuevo.getNivelAlt());
		cViejo.setNombre(cNuevo.getNombre());
		cViejo.setRegion(cNuevo.getRegion());
		
		
	}

	@Override
	public ArrayList<kora.jtrekking.model.Circuito> obtenerTodosCircuito() {
		// TODO Auto-generated method stub
		return (ArrayList<Circuito>) Repo.findAll();
	}

	@Override
	public Circuito obtenerCircuitoid(int id) {
		// TODO Auto-generated method stub
		 
		return Repo.findByid(id).orElseThrow(null);
	}

	@Override
	public ArrayList<kora.jtrekking.model.Circuito> obtenerRecomendaciones(int id) {
		// TODO Auto-generated method stub
		//(int)(Math.random()*aux.size());
		
		ArrayList<Circuito> aux;
		aux= (ArrayList<Circuito>)Repo.otrosCircuitos();
		
		for(int i=0;i<aux.size();i++) {
			if(aux.get(i).getId()==id) {
				
				aux.remove(i);
			}
		}
		
		return aux;
	}

	@Override
	public ArrayList<kora.jtrekking.model.Circuito> buscarCircuitos(String busqueda) {
		// TODO Auto-generated method stub
		ArrayList<Circuito> aux; 
		ArrayList<Circuito> finale = new ArrayList<Circuito>(); 
		aux = (ArrayList<Circuito>)Repo.findAll();
		
		for(int i=0;i<aux.size();i++) {
			if(aux.get(i).getNombre().toLowerCase().contains(busqueda.toLowerCase())) {
				finale.add(aux.get(i));
			}
		}
		return finale;
	}
}








