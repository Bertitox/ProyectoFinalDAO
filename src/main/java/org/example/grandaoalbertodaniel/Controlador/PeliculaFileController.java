package org.example.grandaoalbertodaniel.Controlador;

import org.example.grandaoalbertodaniel.DTO.PeliculaFichero;
import org.example.grandaoalbertodaniel.Service.PeliculaFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/peliculas-file")
public class PeliculaFileController {

    @Autowired
    private PeliculaFileService peliculaFileService;

    // Obtener todas las películas desde el fichero
    @GetMapping
    public List<PeliculaFichero> obtenerPeliculas() {
        return peliculaFileService.obtenerPeliculas();
    }

    // Agregar una nueva película al fichero
    @PostMapping
    public void agregarPelicula(@RequestBody PeliculaFichero pelicula) {
        peliculaFileService.agregarPelicula(pelicula);
    }

    // Guardar una lista de películas en el fichero
    @PostMapping("/guardar")
    public void guardarPeliculas(@RequestBody List<PeliculaFichero> peliculas) {
        peliculaFileService.guardarPeliculas(peliculas);
    }
}
