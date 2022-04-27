package com.desafio.ecad;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.desafio.ecad.entities.Arquivo;
import com.desafio.ecad.entities.Tipo;
import com.desafio.ecad.repositories.ArquivoRepository;
import com.desafio.ecad.repositories.TipoRepository;

@SpringBootApplication
public class EcadApplication implements CommandLineRunner {
	
	@Autowired
	ArquivoRepository arquivoRepository;
	
	@Autowired
	TipoRepository tipoRepository;

	public static void main(String[] args) {
		SpringApplication.run(EcadApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
		
		List<Arquivo> arquivos = arquivoRepository.findAll();
		if (arquivos.isEmpty())
		{
			Tipo t1 = new Tipo(1L, "RET");
			Tipo t2 = new Tipo(2L, "REM");
			tipoRepository.save(t1);
			tipoRepository.save(t2);
			
			Arquivo a1 = new Arquivo(null, "BRADESCO", t1, "ARQUIVO1", new Date(fmt.parse("15/08/2019").getTime()), "THABECK", new Date(fmt.parse("15/08/2019").getTime()), 508, 110266.19);
			Arquivo a2 = new Arquivo(null, "BRADESCO", t1, "ARQUIVO2", new Date(fmt.parse("22/11/2020").getTime()), "THABECK", new Date(fmt.parse("22/11/2020").getTime()), 320, 100598.09);
			Arquivo a3 = new Arquivo(null, "BRADESCO", t1, "ARQUIVO3", new Date(fmt.parse("02/10/2019").getTime()), "FARAUJO", new Date(fmt.parse("02/10/2019").getTime()), 8, 34975.86);
			Arquivo a4 = new Arquivo(null, "BRADESCO", t1, "ARQUIVO4", new Date(fmt.parse("20/02/2022").getTime()), "FARAUJO", new Date(fmt.parse("20/02/2022").getTime()), 603, 139811.77);
			Arquivo a5 = new Arquivo(null, "BRADESCO", t2, "ARQUIVO5", new Date(fmt.parse("17/05/2021").getTime()), "THABECK", new Date(fmt.parse("17/05/2021").getTime()), 286, 208924.25);
			Arquivo a6 = new Arquivo(null, "BRADESCO", t2, "ARQUIVO6", new Date(fmt.parse("21/10/2021").getTime()), "FARAUJO", new Date(fmt.parse("21/10/2021").getTime()), 15, 6260.33);
			arquivoRepository.save(a1);
			arquivoRepository.save(a2);
			arquivoRepository.save(a3);
			arquivoRepository.save(a4);
			arquivoRepository.save(a5);
			arquivoRepository.save(a6);
		}
		
	}

}
