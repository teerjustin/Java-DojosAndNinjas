package com.example.DojosAndNinjas.services;

import org.springframework.stereotype.Service;

import com.example.DojosAndNinjas.models.Ninja;
import com.example.DojosAndNinjas.repositories.NinjaRepository;



@Service
public class NinjaService {
	
	private final NinjaRepository ninjaRepository;
	
	public NinjaService(NinjaRepository ninjaRepository) {
		this.ninjaRepository = ninjaRepository;
	}
	
	public Ninja createNinja(Ninja b) {
		return ninjaRepository.save(b);
	}
}
