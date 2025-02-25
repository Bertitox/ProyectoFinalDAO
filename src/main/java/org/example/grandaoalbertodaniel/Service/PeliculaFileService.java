package org.example.grandaoalbertodaniel.Service;

import org.example.grandaoalbertodaniel.DAOs.DAOTXT.PeliculaFileDAO;
import org.example.grandaoalbertodaniel.DTO.PeliculaFichero;
import org.example.grandaoalbertodaniel.DAOs.DAOXML.PeliculaXMLDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeliculaFileService {

    private final PeliculaFileDAO peliculaFileDAO = new PeliculaFileDAO();  // Inicializamos el DAO

    // Guardar lista de películas en fichero
    public void guardarPeliculas(List<PeliculaFichero> peliculas) {
        peliculaFileDAO.guardarPeliculas(peliculas);
    }

    // Leer lista de películas desde el fichero
    public List<PeliculaFichero> obtenerPeliculas() {
        return peliculaFileDAO.leerPeliculas();
    }

    // Agregar una nueva película al fichero
    public void agregarPelicula(PeliculaFichero pelicula) {
        peliculaFileDAO.agregarPelicula(pelicula);
    }
}
