package ru.dbondin.ormtest;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import ru.dbondin.ormtest.entities.Breed;
import ru.dbondin.ormtest.entities.Cat;
import ru.dbondin.ormtest.repositories.CatRepository;

public class Test1 implements CommandLineRunner {

	private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(Test1.class);

	@PersistenceContext
	private EntityManager em;

	@Autowired
	private CatAdder catAdder;

	@Autowired
	private CatRepository catRepository;
	
	@Override
	public void run(String... arg0) throws Exception {
		LOGGER.info("*** started ***");

		
		// catAdder.xxx();
		
		// catAdder.addCat();
		// catAdder.addCatAnyway();
		// catAdder.incrementAge(3);

		List<Breed> bl = (List<Breed>) em.createQuery("from Breed").getResultList();

		bl.forEach(b -> LOGGER.info(">>> {}", b));
		
		catRepository.findAllByNameOrAge("Васька", 10).forEach(c -> LOGGER.info("XXX {}", c));
		
		Cat c = catRepository.findOne(1L);
		LOGGER.info("CAT: {}", c);
		
		catRepository.findByComplexQuery().forEach(cc -> LOGGER.info("COMPLEX: {}", cc));
	}
}
