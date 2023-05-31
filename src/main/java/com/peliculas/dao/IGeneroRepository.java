package com.peliculas.dao;

import com.peliculas.entities.Genero;

public interface IGeneroRepository {
	public void save(Genero genero);

	public Genero findById(Long id);
}
