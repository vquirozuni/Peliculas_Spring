package com.peliculas.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.peliculas.entities.Pelicula;
import com.peliculas.services.IActorService;
import com.peliculas.services.IGeneroService;
import com.peliculas.services.IPeliculaService;

@Controller
public class PeliculasController {

	private IPeliculaService peliculaService;
	private IGeneroService generoService;
	private IActorService actorService;
	
	public PeliculasController(IPeliculaService peliculaService, IGeneroService generoService, IActorService actorService) {
		this.peliculaService = peliculaService;
		this.generoService = generoService;
		this.actorService = actorService;
	}

	@GetMapping("pelicula")
	public String crear(Model model) {
		Pelicula pelicula = new Pelicula();
		model.addAttribute("pelicula", pelicula);
		model.addAttribute("generos", generoService.findAll());
		model.addAttribute("actores", actorService.findAll());
		model.addAttribute("titulo", "Nueva Pelicula");
		return "pelicula";
	}

	@GetMapping("pelicula/{id}")
	public String editar(@PathVariable(name = "id") Long id, Model model) {
		Pelicula pelicula = new Pelicula();
		model.addAttribute("pelicula", pelicula);
		model.addAttribute("generos", generoService.findAll());
		model.addAttribute("actores", actorService.findAll());
		model.addAttribute("titulo", "Editar Pelicula");
		return "pelicula";
	}

	@PostMapping("pelicula")
	public String guardar(Pelicula pelicula, @ModelAttribute(name="ids") String ids) {
		List<Long> idsProtagonistas = Arrays.stream(ids.split(",")).map(Long::parseLong).collect(Collectors.toList());
		pelicula.setProtagonistas(actorService.findAllById(idsProtagonistas));
		peliculaService.save(pelicula);
		return "redirect:home";
	}

	@GetMapping({ "/", "/home", "/index" })
	public String home() {
		return "home";
	}

}
