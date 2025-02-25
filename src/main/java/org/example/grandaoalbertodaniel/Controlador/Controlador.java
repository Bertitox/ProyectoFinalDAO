package org.example.grandaoalbertodaniel.Controlador;

import jakarta.validation.Valid;
import org.example.grandaoalbertodaniel.DTO.Pelicula;
import org.example.grandaoalbertodaniel.Interfaces.InterfacesJPA.PeliculaRepository;
import org.example.grandaoalbertodaniel.Interfaces.InterfacesMongo.PeliculaMongoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/grandao")
public class Controlador {

    PeliculaMongoRepository peliculaMongoRepository;
    PeliculaRepository peliculaJPARepository;

    public Controlador(PeliculaMongoRepository peliculaMongoRepository, PeliculaRepository peliculaJPARepository) {
        this.peliculaMongoRepository = peliculaMongoRepository;
        this.peliculaJPARepository = peliculaJPARepository;
    }

    @GetMapping("/jpa")
    public ResponseEntity get() {
        return ResponseEntity.ok(peliculaJPARepository.findAll());
    }

    @PostMapping("/jpa")
    public ResponseEntity post(@Valid @RequestBody Pelicula pelicula) {
        peliculaJPARepository.save(pelicula);
        return ResponseEntity.ok(pelicula);
    }

    @PutMapping("/jpa")
    public ResponseEntity update(@Valid @RequestBody Pelicula pelicula) {
        peliculaJPARepository.save(pelicula);
        return ResponseEntity.ok(pelicula);
    }

    @DeleteMapping("/jpa/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        Pelicula pelicula = peliculaJPARepository.findById(id).get();
        peliculaJPARepository.delete(pelicula);
        return ResponseEntity.ok(pelicula);
    }
}
