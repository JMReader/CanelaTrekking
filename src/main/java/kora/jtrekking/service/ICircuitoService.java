package kora.jtrekking.service;

import java.util.ArrayList;


import kora.jtrekking.model.Circuito;

public interface ICircuitoService {
	public Circuito crearCircuito();
	public void guardarCircuito(Circuito nuevoCircuito);
	public ArrayList<Circuito> ObtenerCircuitos();
	public void modificicarCircuito(Circuito circuitoNuevo) throws Exception;
	public void eliminarCircuito(Integer circuitoId) throws Exception;
	public void cambiarCircuito(Circuito cViejo, Circuito cNuevo) throws Exception;
	public ArrayList<Circuito> obtenerTodosCircuito();
}
