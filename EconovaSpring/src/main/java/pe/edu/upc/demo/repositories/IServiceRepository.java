package pe.edu.upc.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.upc.demo.entities.Service;

@Repository
public interface IServiceRepository extends JpaRepository<Service, Integer> {

	@Query(value = "select e.name_company, sum(s.quantity_waste) from company e inner join service s on e.id_company = s.id_company group by e.name_company", nativeQuery = true)
	public List<String[]> tipodesechocantidad();
}
