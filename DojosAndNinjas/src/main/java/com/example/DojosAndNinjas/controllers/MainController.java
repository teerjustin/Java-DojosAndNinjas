package com.example.DojosAndNinjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.DojosAndNinjas.models.Dojo;
import com.example.DojosAndNinjas.models.Ninja;
import com.example.DojosAndNinjas.services.DojoService;
import com.example.DojosAndNinjas.services.NinjaService;


@Controller
public class MainController {
	
    private final DojoService dojoService;
    private final NinjaService ninjaService;
    
    public MainController(DojoService dojoService, NinjaService ninjaService) {
        this.dojoService = dojoService;
        this.ninjaService = ninjaService;
    }
    
	@GetMapping("/dojos")
    public String index(Model model) {
        List<Dojo> dojos = dojoService.allDojos();
        model.addAttribute("dojos", dojos);
        System.out.println("I am here");
        return "index.jsp";
    }
	
    @RequestMapping("/dojos/new")
    public String newPerson(@ModelAttribute("dojo") Dojo dojo) {
        return "NewDojo.jsp";
    }
    
	@GetMapping("/dojos/new")
    @RequestMapping(value="/dojos/new/create", method=RequestMethod.POST)
	  public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		
		System.out.println("I SHOULD BE CREATING A DOJO");
		if (result.hasErrors()) {
			return "redirect:/dojos";
		} else {
		    dojoService.createDojo(dojo);
		    return "redirect:/dojos";
		}
	}
	
	@RequestMapping("/dojos/new/ninja")
	 public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		List<Dojo> dojos = dojoService.allDojos();
	    model.addAttribute("dojos", dojos);
       return "NewNinja.jsp";
   }
	
	@GetMapping("/dojos/new/ninja")
    @RequestMapping(value="/dojos/new/ninja/create", method=RequestMethod.POST)
	  public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
		System.out.println("I SHOULD BE CREATING A NINJA");
		
		if (result.hasErrors()) {
			System.out.println("THERE IS AN ERROR CREATING A NINJA");
			System.out.println(result.getAllErrors());
			return "redirect:/dojos";
			
		} else {
		    ninjaService.createNinja(ninja);
		    System.out.println("REDIRECTING BACK HOME, NINJA SHOULD BE CREATED");
		    return "redirect:/dojos";
		}
	}
	
	@RequestMapping("/dojos/{id}")
    public String showDojo(@PathVariable("id") Long id, Model model) {
		Dojo dojo = dojoService.findDojo(id);
		model.addAttribute("dojo", dojo);
        return "showNinjasInDojo.jsp";
    }

}
