package kora.jtrekking.service;

import java.util.ArrayList;


import kora.jtrekking.model.Circuito;

public interface ICircuitoService {
	//metodos sin consultas sql
	public Circuito obtenerCircNosql(ArrayList<Circuito> circuitos, int id);
	public ArrayList<Circuito> obtenerRegionNosql(String region, ArrayList<Circuito> circuitos);
	//metodos con consulta sql
	public Circuito crearCircuito();
	public void guardarCircuito(Circuito nuevoCircuito);
	public ArrayList<Circuito> ObtenerCircuitos();
	public Circuito obtenerCircuitoid(int id);
	
	public void modificicarCircuito(Circuito circuitoNuevo) throws Exception;
	public void eliminarCircuito(Integer circuitoId) throws Exception;
	public void cambiarCircuito(Circuito cViejo, Circuito cNuevo) throws Exception;
	public ArrayList<Circuito> obtenerTodosCircuito();
	
	public ArrayList<Circuito> obtenerRecomendaciones(int id);
	public ArrayList<Circuito>  buscarCircuitos(String busqueda);

}
