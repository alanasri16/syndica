package org.sandicat;

import java.text.DateFormat;
import java.text.SimpleDateFormat;


import org.sandicat.DTO.HabitantRepository;
import org.sandicat.entities.Habitant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SyndicatFinaleApplication implements CommandLineRunner{
	
	@Autowired
	private HabitantRepository habitantRepository;

	public static void main(String[] args) {
		SpringApplication.run(SyndicatFinaleApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		DateFormat df=new SimpleDateFormat("yyyy/MM/dd");
		
		habitantRepository.save(new Habitant ("chédi","chédi",df.parse("10/02/2000"),"chedi@gamil.com",25631410,"photo.jpg"));
		habitantRepository.save(new Habitant ("imen","imen",df.parse("10/02/2000"),"chedi@gamil.com",25631410,"photo.jpg"));
		habitantRepository.save(new Habitant ("ibtissem","ibtissem",df.parse("10/02/2000"),"chedi@gamil.com",25631410,"photo.jpg"));
		habitantRepository.save(new Habitant ("ala","ala",df.parse("10/02/2000"),"chedi@gamil.com",25631410,"photo.jpg"));
		
		habitantRepository.findAll().forEach(c->{
			System.out.println(c.getNom());
		});
		
	}
}
