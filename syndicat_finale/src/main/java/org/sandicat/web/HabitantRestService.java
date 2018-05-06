package org.sandicat.web;

import java.awt.print.Pageable;
import java.util.List;

import org.sandicat.DTO.HabitantRepository;
import org.sandicat.entities.Habitant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class HabitantRestService {

	@Autowired
	private HabitantRepository habitantRepository;
	
	@RequestMapping(value="/savehabitant",method=RequestMethod.POST)
	public Habitant saveUtilisateur(@RequestBody Habitant h) {
		return habitantRepository.save(h);
	}
	@RequestMapping(value="/listhabitant",method=RequestMethod.GET)
	public List<Habitant> findhabitant() {
		return habitantRepository.findAll();
	}
	@RequestMapping(value="/listhabitant/{id}",method=RequestMethod.GET)
	public Habitant findhabitantbyid(@PathVariable Long id) {
		return habitantRepository.findOne(id);
	}
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	public boolean deletehabitant(@PathVariable Long id) {
		 
				habitantRepository.delete(id);
				return true;
	}
	@RequestMapping(value="/update/{id}",method=RequestMethod.PUT)
	public Habitant updatehabitant(@PathVariable Long id,@RequestBody Habitant h) {
		 h.setId(id);
		return habitantRepository.save(h);
	}
	
	@RequestMapping(value="/chercherHabitant",method=RequestMethod.GET)
	public Page<Habitant> recherche(
			@RequestParam(name="mc",defaultValue="")String mc,
			@RequestParam(name="page",defaultValue="0")int page,
			@RequestParam(name="size",defaultValue="5")int size) {
		return habitantRepository.chercher("%"+mc+"%", new PageRequest(page,size));
	}
}
