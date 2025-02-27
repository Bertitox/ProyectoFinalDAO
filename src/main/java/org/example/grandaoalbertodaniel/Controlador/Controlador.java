package org.example.grandaoalbertodaniel.Controlador;

import org.example.grandaoalbertodaniel.DTO.PeliculaFichero;
import org.example.grandaoalbertodaniel.DTO.Pelicula;
import org.example.grandaoalbertodaniel.Service.Servicio;
import com.mongodb.client.MongoClient;
import jakarta.validation.Valid;
import org.example.grandaoalbertodaniel.Interfaces.InterfacesJPA.PeliculaRepository;
import org.example.grandaoalbertodaniel.Interfaces.InterfacesMongo.PeliculaMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grandao")
public class Controlador {

    @Autowired
    private Servicio servicio;

    //JPA
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

    //MONGODB

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
    public ResponseEntity<?> deleteMongo(@PathVariable String id) {
        servicio.deleteMongoPelicula(id);
        return ResponseEntity.ok().body("Pelicula eliminada");
    }

    //TXT

    @GetMapping("/fichero")
    public List<PeliculaFichero> obtenerPeliculas() {
        return servicio.obtenerPeliculas();
    }

    @PostMapping("/fichero")
    public void agregarPelicula(@RequestBody PeliculaFichero pelicula) {
        servicio.agregarPelicula(pelicula);
    }
}
