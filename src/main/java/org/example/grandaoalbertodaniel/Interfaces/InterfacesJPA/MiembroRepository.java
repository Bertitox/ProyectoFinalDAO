package org.example.grandaoalbertodaniel.Interfaces.InterfacesJPA;

import org.example.grandaoalbertodaniel.DTO.Miembro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MiembroRepository extends JpaRepository<Miembro, Integer> {
}

