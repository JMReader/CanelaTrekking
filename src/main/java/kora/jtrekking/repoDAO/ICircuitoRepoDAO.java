package kora.jtrekking.repoDAO;

import java.util.List;
import java.util.Optional;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import kora.jtrekking.model.Circuito;



@Repository
public interface ICircuitoRepoDAO extends CrudRepository <Circuito, Integer>{
	public Optional<Circuito> findByid(Integer idCircuito);
	
	@Query(value = "SELECT * FROM canelat.circuitos where region =  'valle';",nativeQuery=true)
	public ArrayList<Circuito> mostrarCircuitosValle();
	@Query(value = "SELECT * FROM canelat.circuitos where region =  'puna';",nativeQuery=true)
	public ArrayList<Circuito> mostrarCircuitosPuna();
	@Query(value = "SELECT * FROM canelat.circuitos where region =  'quebrada';",nativeQuery=true)
	public ArrayList<Circuito> mostrarCircuitosQueb();
	@Query(value = "SELECT * FROM canelat.circuitos where region =  'yungas';",nativeQuery=true)
	public ArrayList<Circuito> mostrarCircuitosYung();
	@Query(value = "SELECT * FROM canelat.circuitos ORDER BY RAND() LIMIT 0,6;",nativeQuery=true)
	public List<Circuito> otrosCircuitos();
	@Query(value = "SELECT * FROM canelat.circuitos where dificultad ='baja';",nativeQuery=true)
	public List<Circuito> circuitosDifBaja();
	@Query(value = "SELECT * FROM canelat.circuitos where dificultad ='media';",nativeQuery=true)
	public List<Circuito> circuitosDifMedia();
	@Query(value = "SELECT * FROM canelat.circuitos where dificultad ='alta';",nativeQuery=true)
	public List<Circuito> circuitosDifAlta();
	@Query(value = "SELECT * FROM canelat.circuitos where duracion < 4;",nativeQuery=true)
	public List<Circuito> circuitosDurCuatro();
	@Query(value = "SELECT * FROM canelat.circuitos where duracion > 4 and duracion < 8 ;",nativeQuery=true)
	public List<Circuito> circuitosDurOcho();
	@Query(value = "SELECT * FROM canelat.circuitos where duracion > 8 and duracion < 24;",nativeQuery=true)
	public List<Circuito> circuitosDurMasOcho();
	@Query(value = "SELECT * FROM canelat.circuitos where  duracion > 24;",nativeQuery=true)
	public List<Circuito> circuitosTravesias();
	@Query(value = "SELECT * FROM canelat.circuitos where  distancia < 6;",nativeQuery=true)
	public List<Circuito> circuitosDisSeis();
	@Query(value = "SELECT * FROM canelat.circuitos where  distancia > 6 and distancia < 12;",nativeQuery=true)
	public List<Circuito> circuitosDisDoce();
	@Query(value = "SELECT * FROM canelat.circuitos where  distancia > 12 and distancia < 20;",nativeQuery=true)
	public List<Circuito> circuitosDisVeinte();
	@Query(value = "SELECT * FROM canelat.circuitos where  duracion > 20;",nativeQuery=true)
	public List<Circuito> circuitosDisMasVeinte();
}
