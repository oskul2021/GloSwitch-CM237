package com.gloswitchcm237.tikitsupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gloswitchcm237.tikitsupport.models.Talk;
import com.gloswitchcm237.tikitsupport.models.Tikit;
import com.gloswitchcm237.tikitsupport.repositories.TalkRepositoy;
import com.gloswitchcm237.tikitsupport.repositories.TikitRepository;

import jakarta.transaction.Transactional;

@SpringBootApplication
public class TikitSupportApplication implements CommandLineRunner {
	@Autowired
	private TikitRepository tikitRepository;
	@Autowired
	private TalkRepositoy talkRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(TikitSupportApplication.class, args);
	}
	
	@Transactional
	@Override
	public void run(String... args) throws Exception {
		/*
		 * Tikit tikit1 = new Tikit(143, "error while deposit", "nothing",
		 * "deposit not effective"); Tikit tikit2 = new Tikit(144,
		 * "error while withdraw", "nothing", "deposit not effective"); Talk talk = new
		 * Talk(144, "okay"); talkRepository.save(talk); tikit1.addTalk(talk);
		 * tikitRepository.save(tikit1); tikitRepository.save(tikit2);
		 * //talk.setTikit(tikit1);
		 * 
		 * tikitRepository.findAll().forEach(t -> System.out.println(t.getSubject()));
		 * talkRepository.findAll().forEach(t -> System.out.println(t.getText()));
		 */
	}

}
