package org.example.grandaoalbertodaniel.Service;

import org.bson.types.ObjectId;
import org.example.grandaoalbertodaniel.DAOs.DAOTXT.PeliculaFileDAO;
import org.example.grandaoalbertodaniel.DTO.Pelicula;
import org.example.grandaoalbertodaniel.DTO.PeliculaFichero;
import org.example.grandaoalbertodaniel.Interfaces.InterfacesJPA.PeliculaRepository;
import org.example.grandaoalbertodaniel.Interfaces.InterfacesMongo.PeliculaMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class Servicio {
    @Autowired
    PeliculaMongoRepository peliculaMongoRepository;

    @Autowired
    PeliculaRepository peliculaJPARepository;

    PeliculaFileDAO peliculaFileDAO = new PeliculaFileDAO();  // Inicializamos el DAO

    //JPA
    public void saveJPAPelicula(Pelicula pelicula) {
        peliculaJPARepository.save(pelicula);
    }

    public void deleteJPAPelicula(Integer id) {
        Pelicula pelicula = peliculaJPARepository.findById(id).get();
        peliculaJPARepository.delete(pelicula);
    }

    public void updateJPAPelicula(Pelicula pelicula) {
        peliculaJPARepository.save(pelicula);
    }

    public List<Pelicula> getJPAPelicula() {
        return peliculaJPARepository.findAll();
    }

    //MONGO
    public void saveMongoPelicula(Pelicula pelicula) {
        peliculaMongoRepository.save(pelicula);
    }

    public void deleteMongoPelicula(String id) {
        Pelicula pelicula = peliculaMongoRepository.findById(id).get();

        peliculaMongoRepository.delete(pelicula);
    }

    public void updateMongoPelicula(Pelicula pelicula) {
        peliculaMongoRepository.save(pelicula);
    }

    public List<Pelicula> getMongoPelicula() {
        return peliculaMongoRepository.findAll();
    }

    //TXT
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
