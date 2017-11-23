package ru.dbondin.ormtest.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ru.dbondin.ormtest.entities.Cat;

@Repository
public interface CatRepository extends CrudRepository<Cat, Long>{

	List<Cat> findAllByName(String name);
	List<Cat> findAllByNameOrAge(String name, int age);
	
	@Query(nativeQuery=true, value="select 100 as id, 'Кот-призрак' as name, 0 as age, null as breed_id, 'MALE' as sex")
	List<Cat> findByComplexQuery();
}
