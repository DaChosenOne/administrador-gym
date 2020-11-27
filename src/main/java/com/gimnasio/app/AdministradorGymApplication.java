package com.gimnasio.app;

import com.gimnasio.app.models.Cliente;
import com.gimnasio.app.models.Inscripcion;
import com.gimnasio.app.repository.ClienteRepository;
import com.gimnasio.app.repository.InscripcioneRepository;
import com.gimnasio.app.services.EmailBody;
import com.gimnasio.app.services.EmailPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class AdministradorGymApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AdministradorGymApplication.class, args);
	}

	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private InscripcioneRepository inscripcioneRepository;
	@Autowired
	private  EmailPort emailPort;

	@Override
	public void run(String... args) throws Exception {
		if(conectadoAInternet()) {
			SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
			EmailBody emailBody = new EmailBody();
			StringBuilder texto = new StringBuilder();
			texto.append("<b>Lista de Clientes</b> <br>");
			for (Inscripcion inscripcion : inscripcioneRepository.findAll()) {
				if (new Date().after(inscripcion.getFechaConclusion())) {
					texto.append(inscripcion.getCliente().getNombre() + " y su incripcion vencio el: " + inscripcion.getFechaConclusion() + "<br>");
				}
			}
			emailBody.setContent(texto.toString());
			emailBody.setEmail("doomlord97@gmail.com");
			emailBody.setSubject("Lista de clientes con suscripcion vencida");
			emailPort.sendEmail(emailBody);
		}
	}
	public boolean conectadoAInternet() throws InterruptedException, IOException, IOException {
		String comando = "ping -c 1 google.com";
		return (Runtime.getRuntime().exec(comando).waitFor() == 0);
	}
}
