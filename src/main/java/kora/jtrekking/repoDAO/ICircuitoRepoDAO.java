package kora.jtrekking.repoDAO;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import kora.jtrekking.model.Circuito;



@Repository
public interface ICircuitoRepoDAO extends CrudRepository <Circuito, Integer>{
	public Optional<Circuito> findByid(Integer idCircuito);
	
	@Query(value = "SELECT * FROM canelatrekking.circuitos where region =  'valle';",nativeQuery=true)
	public List<Circuito> mostrarCircuitosValle();
	@Query(value = "SELECT * FROM canelatrekking.circuitos where region =  'puna';",nativeQuery=true)
	public List<Circuito> mostrarCircuitosPuna();
	@Query(value = "SELECT * FROM canelatrekking.circuitos where region =  'quebrada';",nativeQuery=true)
	public List<Circuito> mostrarCircuitosQueb();
	@Query(value = "SELECT * FROM canelatrekking.circuitos where region =  'yungas';",nativeQuery=true)
	public List<Circuito> mostrarCircuitosYung();
	@Query(value = "SELECT * FROM canelatrekking.circuitos ORDER BY RAND() LIMIT 0,6;",nativeQuery=true)
	public List<Circuito> otrosCircuitos();
	
}
