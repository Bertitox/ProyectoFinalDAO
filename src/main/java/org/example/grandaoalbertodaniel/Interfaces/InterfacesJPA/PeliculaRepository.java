package org.example.grandaoalbertodaniel.Interfaces.InterfacesJPA;

import org.example.grandaoalbertodaniel.DTO.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeliculaRepository extends JpaRepository<Pelicula, Integer> {
}
