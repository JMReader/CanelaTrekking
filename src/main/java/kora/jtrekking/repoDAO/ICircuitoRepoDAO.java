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
	


}
