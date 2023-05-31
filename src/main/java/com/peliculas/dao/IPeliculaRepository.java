package com.peliculas.dao;

import org.springframework.data.repository.CrudRepository;

import com.peliculas.entities.Pelicula;

public interface IPeliculaRepository extends CrudRepository<Pelicula, Long>{

}
