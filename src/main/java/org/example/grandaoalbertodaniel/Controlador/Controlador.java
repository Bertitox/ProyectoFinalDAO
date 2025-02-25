package org.example.grandaoalbertodaniel.Controlador;

import Service.Servicio;
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


    private Servicio servicio = new Servicio();

    @Autowired
    public Controlador(PeliculaMongoRepository peliculaMongoRepository, PeliculaRepository peliculaJPARepository, MongoClient mongo) {
        this.peliculaMongoRepository = peliculaMongoRepository;
        this.peliculaJPARepository = peliculaJPARepository;
        this.mongo = mongo;
    }

    //CONTROLADOR DE MYSQL

    @GetMapping("/jpa")
    public ResponseEntity<List<?>> get() {
        return ResponseEntity.ok(servicio.getJPAPelicula());
    }

    @PostMapping("/jpa")
    public ResponseEntity<?> post(@Valid @RequestBody Pelicula pelicula) {
        servicio.saveJPAPelicula(pelicula);
        return ResponseEntity.ok(pelicula);
    }

    @PutMapping("/jpa")
    public ResponseEntity<?> update(@Valid @RequestBody Pelicula pelicula) {
        servicio.updateJPAPelicula(pelicula);
        return ResponseEntity.ok(pelicula);
    }

    @DeleteMapping("/jpa/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        servicio.deleteJPAPelicula(id);
        return ResponseEntity.ok().body("Pelicula eliminada");
    }

    //CONTROLADOR DE MONGODB

    //Select ALL Películas
    @GetMapping("/mongo")
    public ResponseEntity<List<?>> obtenerMongo() {
        return ResponseEntity.ok(servicio.getMongoPelicula());
    }

    //Crear Película
    @PostMapping("/mongo")
    public ResponseEntity<?> guardarMongo(@RequestBody Pelicula pelicula) {
        servicio.saveMongoPelicula(pelicula);
        return ResponseEntity.ok(pelicula);
    }

    //Actualizar Película
    @PutMapping("/mongo")
    public ResponseEntity<?> updateMongo(@Valid @RequestBody Pelicula pelicula) {
        servicio.saveMongoPelicula(pelicula);
        return ResponseEntity.ok(pelicula);
    }

    // Eliminar película
    @DeleteMapping("/mongo/{id}")
    public ResponseEntity<?> deleteMongo(@PathVariable Integer id) {
        servicio.deleteMongoPelicula(id);
        return ResponseEntity.ok().body("Pelicula eliminada");
    }
}
