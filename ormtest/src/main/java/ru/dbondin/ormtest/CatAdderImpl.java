package ru.dbondin.ormtest;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.slf4j.Logger;

import ru.dbondin.ormtest.entities.Breed;
import ru.dbondin.ormtest.entities.Cat;

public class CatAdderImpl implements CatAdder {
	
	private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(CatAdderImpl.class);

	@PersistenceContext
	private EntityManager em;
	
	@Override
	@Transactional
	public void addCat() {

		Cat c = em.find(Cat.class, 4L);
		
		if (c == null) {

			c = new Cat();
			c.setId(4L);
			c.setName("Томас");
			c.setAge(10);

			em.persist(c);
		}
	}
	
	@Override
	@Transactional
	public void addCatAnyway() {
		Cat c = new Cat();
		c.setName("Кот-" + (int) (10000.0 * Math.random()));
		c.setAge((int) (10.0 * Math.random()));
		
		em.persist(c);
	}
	
	@Override
	@Transactional
	public void incrementAge(int incr) {
		((List<Cat>)em.createQuery("from Cat").getResultList()).forEach(c -> {
			if(c.getAge() != null) {
				c.setAge(c.getAge() + incr);
				em.persist(c);
			}
		});
	}
	
	@Override
	@Transactional
	public void xxx() {
		List<Cat> cl = (List<Cat>) em.createQuery("from Cat").getResultList();

		cl.forEach(c -> {
			LOGGER.info(">>> {}", c);
			if (c.getBreed() != null) {
				LOGGER.info(">>>     breed={}", c.getBreed());
				
			}
		});
		
		Breed b = em.find(Breed.class, 1L);
		if(b != null) {
			LOGGER.info("BBB {}", b);
			b.getCats().forEach(c -> LOGGER.info("BBB     {}", c));
		}
	}
}
