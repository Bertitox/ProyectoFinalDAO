package org.example.grandaoalbertodaniel.Controlador;

import com.mongodb.client.MongoClient;
import jakarta.validation.Valid;
import org.example.grandaoalbertodaniel.DTO.Pelicula;
import org.example.grandaoalbertodaniel.Interfaces.InterfacesJPA.PeliculaRepository;
import org.example.grandaoalbertodaniel.Interfaces.InterfacesMongo.PeliculaMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grandao")
public class Controlador {

    private final MongoClient mongo;

    @Autowired
    PeliculaMongoRepository peliculaMongoRepository;

    @Autowired
    PeliculaRepository peliculaJPARepository;

    @Autowired
    public Controlador(PeliculaMongoRepository peliculaMongoRepository, PeliculaRepository peliculaJPARepository, MongoClient mongo) {
        this.peliculaMongoRepository = peliculaMongoRepository;
        this.peliculaJPARepository = peliculaJPARepository;
        this.mongo = mongo;
    }

    //CONTROLADOR DE MYSQL

    @GetMapping("/jpa")
    public ResponseEntity<List<?>> get() {
        return ResponseEntity.ok(peliculaJPARepository.findAll());
    }

    @PostMapping("/jpa")
    public ResponseEntity<?> post(@Valid @RequestBody Pelicula pelicula) {
        peliculaJPARepository.save(pelicula);
        return ResponseEntity.ok(pelicula);
    }

    @PutMapping("/jpa")
    public ResponseEntity<?> update(@Valid @RequestBody Pelicula pelicula) {
        peliculaJPARepository.save(pelicula);
        return ResponseEntity.ok(pelicula);
    }

    @DeleteMapping("/jpa/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        Pelicula pelicula = peliculaJPARepository.findById(id).get();
        peliculaJPARepository.delete(pelicula);
        return ResponseEntity.ok(pelicula);
    }

    //CONTROLADOR DE MONGODB

    //Select ALL Películas
    @GetMapping("/mongo")
    public ResponseEntity<List<?>> obtenerMongo() {
        return ResponseEntity.ok(peliculaMongoRepository.findAll());
    }

    //Crear Película
    @PostMapping("/mongo")
    public ResponseEntity<?> guardarMongo(@RequestBody Pelicula pelicula) {
        peliculaMongoRepository.save(pelicula);
        return ResponseEntity.ok(pelicula);
    }

    //Actualizar Película
    @PutMapping("/mongo")
    public ResponseEntity<?> updateMongo(@Valid @RequestBody Pelicula pelicula) {
        peliculaMongoRepository.save(pelicula);
        return ResponseEntity.ok(pelicula);
    }

    // Eliminar película
    @DeleteMapping("/mongo/{id}")
    public ResponseEntity<?> deleteMongo(@PathVariable Integer id) {
        Pelicula pelicula = peliculaMongoRepository.findById(id).get();
        peliculaMongoRepository.delete(pelicula);
        return ResponseEntity.ok(pelicula);
    }
}
