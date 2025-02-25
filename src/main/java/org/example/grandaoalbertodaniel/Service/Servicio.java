package org.example.grandaoalbertodaniel.Service;

import org.bson.types.ObjectId;
import org.example.grandaoalbertodaniel.DTO.Pelicula;
import org.example.grandaoalbertodaniel.DTO.Pelicula;
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


}
