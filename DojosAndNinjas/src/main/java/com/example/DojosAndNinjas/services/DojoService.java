package com.example.DojosAndNinjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.DojosAndNinjas.models.Dojo;
import com.example.DojosAndNinjas.repositories.DojoRepository;

@Service
public class DojoService {
    // adding the book repository as a dependency
    private final DojoRepository dojoRepository;
    
    public DojoService(DojoRepository dojoRepository) {
        this.dojoRepository = dojoRepository;
    }
    
    // returns all the dojo
    public List<Dojo> allDojos() {
        return dojoRepository.findAll();
    }
    // creates a dojo
    public Dojo createDojo(Dojo b) {
        return dojoRepository.save(b);
    }
    
	public void deleteDojo(Long id) {
		dojoRepository.deleteById(id);
	}
    
	//update dojo
	public Dojo updateDojo(Long id, String name) {
		Optional<Dojo> dojo = dojoRepository.findById(id);
		Dojo b = dojo.get();
		b.setName(name);
		return dojoRepository.save(b);
	}
   
    // retrieves a dojo
    public Dojo findDojo(Long id) {
        Optional<Dojo> optionalDojo = dojoRepository.findById(id);
        if(optionalDojo.isPresent()) {
            return optionalDojo.get();
        } else {
            return null;
        }
    }
}
