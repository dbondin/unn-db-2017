package ru.dbondin.ormtest;

import org.flywaydb.core.Flyway;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OrmtestApplication {

	private static void migrate() {
		
		Flyway flyway = new Flyway();
		flyway.setBaselineVersionAsString("1");
		flyway.setDataSource("jdbc:postgresql://localhost/xxx", "test", "test");
		flyway.setBaselineOnMigrate(true);
		flyway.migrate();
		
	}
	
	public static void main(String[] args) {

		migrate();
		
		SpringApplication.run(OrmtestApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner start() {
		return new Test1();
	}
	
	@Bean
	public CatAdder catAdder() {
		return new CatAdderImpl();
	}
}
