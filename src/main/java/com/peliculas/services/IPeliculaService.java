package com.peliculas.services;

import java.util.List;
import com.peliculas.entities.Pelicula;

public interface IPeliculaService {
	public void save(Pelicula pelicula);

	public Pelicula findById(Long id);

	public void delete(Long id);

	public List<Pelicula> findAll();
}
