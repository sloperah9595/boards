package com.example.kanbas;

import com.example.kanbas.persistances.entities.StatusEntity;
import com.example.kanbas.persistances.repositories.StatusRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class KanbasApplication implements CommandLineRunner {

	private final Log logger = LogFactory.getLog(this.getClass());
    private StatusRepository statusRepository;

	public KanbasApplication(StatusRepository statusRepository) {
		this.statusRepository = statusRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(KanbasApplication.class, args);


	}

	@Override
	public void run(String... args) {
		System.out.println("hola mundo");
		saveInitialStatuses();


	}

	private void saveInitialStatuses() {
		StatusEntity todo = new StatusEntity("TO_DO","to do","This task is pending to start");
		StatusEntity inprogress = new StatusEntity("PROGRESS","progress","This task is in progress");
		StatusEntity finish = new StatusEntity("FINISH","finish","This task is finished");

		List<StatusEntity> statuses = Arrays.asList(todo, inprogress, finish);

		try {
			statusRepository.saveAll(statuses);
			statuses.stream().forEach(user -> logger.info("Mi usuario registrado " + user.toString()));
		} catch (RuntimeException e) {
			logger.error("La siguiente exepcion ocurrio durante la ejecución del metodo para registrar usuarios");
			logger.error(e.getMessage());
		}

	}

}
