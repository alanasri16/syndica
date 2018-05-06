package org.sandicat.web;

import java.util.List;

import org.sandicat.DTO.HabitantRepository;
import org.sandicat.DTO.ProjetRepository;
import org.sandicat.entities.Habitant;
import org.sandicat.entities.Projet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjetRestService {

	@Autowired
	private ProjetRepository projetRepository;
	
	@RequestMapping(value="/saveprojet",method=RequestMethod.POST)
	public Projet saveprojet(@RequestBody Projet p) {
		return projetRepository.save(p);
	}
	@RequestMapping(value="/listprojet",method=RequestMethod.GET)
	public List<Projet> findprojet() {
		return projetRepository.findAll();
	}
	@RequestMapping(value="/listprojet/{id}",method=RequestMethod.GET)
	public Projet findhabitantbyid(@PathVariable Long id) {
		return projetRepository.findOne(id);
	}
	@RequestMapping(value="/deleteprojet/{id}",method=RequestMethod.DELETE)
	public boolean deleteprojet(@PathVariable Long id) {
		 
		projetRepository.delete(id);
				return true;
	}
	@RequestMapping(value="/updateprojet/{id}",method=RequestMethod.PUT)
	public Projet updateprojet(@PathVariable Long id,@RequestBody Projet p) {
		 p.setId(id);
		return projetRepository.save(p);
	}
	
	@RequestMapping(value="/chercherprojet",method=RequestMethod.GET)
	public Page<Projet> recherche(
			@RequestParam(name="mc",defaultValue="")String mc,
			@RequestParam(name="page",defaultValue="0")int page,
			@RequestParam(name="size",defaultValue="5")int size) {
		return projetRepository.chercher("%"+mc+"%", new PageRequest(page, size));
	}
	
}
