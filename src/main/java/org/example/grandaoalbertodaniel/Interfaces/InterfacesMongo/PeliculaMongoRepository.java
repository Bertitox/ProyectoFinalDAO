package org.example.grandaoalbertodaniel.Interfaces.InterfacesMongo;

import org.bson.types.ObjectId;
import org.example.grandaoalbertodaniel.DTO.Pelicula;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PeliculaMongoRepository extends MongoRepository<Pelicula, String> {
}
