package com.lamine.mongdb.repository;

import com.lamine.mongdb.entity.Client;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface ClientRepository extends MongoRepository<Client,Integer> {
    public Client findByPrenom(String prenom);
    public List<Client> findByNom(String nom);
}
