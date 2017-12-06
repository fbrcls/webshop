package be.quatrefeuilles.webshop.repository;

import be.quatrefeuilles.webshop.documents.Command;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface CommandRepository extends MongoRepository<Command, String> {

    @Query("{$and:[{'statuses.statusCode':{$in:['PAYED']}},{'statuses.statusCode':{$nin:['PRINTED']}}]}")
    List<Command> findPayedCommands();

}