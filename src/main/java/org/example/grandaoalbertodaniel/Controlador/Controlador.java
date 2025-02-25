package org.example.grandaoalbertodaniel.Controlador;

import org.example.grandaoalbertodaniel.DTO.PeliculaFichero;
import org.example.grandaoalbertodaniel.DTO.PeliculaMongo;
import org.example.grandaoalbertodaniel.Service.PeliculaFileService;
import org.example.grandaoalbertodaniel.Service.Servicio;
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
    private PeliculaFileService peliculaFileService;

    @Autowired
    private Servicio servicio;

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
    public ResponseEntity<?> guardarMongo(@RequestBody PeliculaMongo pelicula) {
        servicio.saveMongoPelicula(pelicula);
        return ResponseEntity.ok(pelicula);
    }

    //Actualizar Película
    @PutMapping("/mongo")
    public ResponseEntity<?> updateMongo(@Valid @RequestBody PeliculaMongo pelicula) {
        servicio.saveMongoPelicula(pelicula);
        return ResponseEntity.ok(pelicula);
    }

    // Eliminar película
    @DeleteMapping("/mongo/{id}")
    public ResponseEntity<?> deleteMongo(@PathVariable String id) {
        servicio.deleteMongoPelicula(id);
        return ResponseEntity.ok().body("Pelicula eliminada");
    }

    @GetMapping("/fichero")
    public List<PeliculaFichero> obtenerPeliculas() {
        return peliculaFileService.obtenerPeliculas();
    }

    @PostMapping("/fichero/agregar")
    public void agregarPelicula(@RequestBody PeliculaFichero pelicula) {
        peliculaFileService.agregarPelicula(pelicula);
    }

    @PostMapping("/fichero/guardar")
    public void guardarPeliculas(@RequestBody List<PeliculaFichero> peliculas) {
        peliculaFileService.guardarPeliculas(peliculas);
    }
}
