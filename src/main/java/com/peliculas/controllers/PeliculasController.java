package com.peliculas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.peliculas.entities.Pelicula;
import com.peliculas.services.IPeliculaService;

@Controller
public class PeliculasController {

	private IPeliculaService peliculaService;

	public PeliculasController(IPeliculaService peliculaService) {
		this.peliculaService = peliculaService;
	}

	@GetMapping("pelicula")
	public String crear(Model model) {
		Pelicula pelicula = new Pelicula();
		model.addAttribute("pelicula", pelicula);
		model.addAttribute("titulo", "Nueva Pelicula");
		return "pelicula";
	}
	
	@GetMapping("pelicula/{id}")
	public String editar(@PathVariable(name="id") Long id ,Model model) {
		Pelicula pelicula = new Pelicula();
		model.addAttribute("pelicula", pelicula);
		model.addAttribute("titulo", "Editar Pelicula");
		return "pelicula";
	}
	
	
	@PostMapping("Pelicula")
	public Long guardar(@RequestParam String nombre) {
		Pelicula Pelicula = new Pelicula();
		Pelicula.setNombre(nombre);
		peliculaService.save(Pelicula);
		return Pelicula.getId();
	}

	@GetMapping("Pelicula/{id}")
	public String buscarPorId(@PathVariable(name = "id") Long id) {
		return peliculaService.findById(id).getNombre();
	}

}
