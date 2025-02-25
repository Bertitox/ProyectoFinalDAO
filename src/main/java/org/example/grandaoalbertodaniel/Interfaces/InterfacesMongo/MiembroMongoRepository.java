package org.example.grandaoalbertodaniel.Interfaces.InterfacesMongo;

import org.example.grandaoalbertodaniel.DTO.Miembro;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MiembroMongoRepository extends MongoRepository<Miembro, Long> {
}
