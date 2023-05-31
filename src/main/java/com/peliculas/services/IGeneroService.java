package com.peliculas.services;

import java.util.List;

import com.peliculas.entities.Genero;

public interface IGeneroService {
	public void save(Genero genero);
	public Genero findById(Long id);
	public void delete(Long id);
	public List<Genero> findAll();
}
