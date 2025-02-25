package org.example.grandaoalbertodaniel.Interfaces.InterfacesMongo;

import org.example.grandaoalbertodaniel.DTO.Reserva;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReservaMongoRepository extends MongoRepository<Reserva, Long> {
}
