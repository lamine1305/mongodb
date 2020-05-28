package com.lamine.mongdb;

import com.lamine.mongdb.entity.Client;
import com.lamine.mongdb.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MongdbApplication implements CommandLineRunner {

    @Autowired
    ClientRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(MongdbApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        repository.deleteAll();

        // save a couple of customers
        repository.save(new Client(4,"MEHIDI", "Lamine"));
        repository.save(new Client(5,"ALILI", "Fares"));

        // fetch all customers
        System.out.println("Client found with findAll():");
        System.out.println("-------------------------------");
        for (Client client : repository.findAll()) {
            System.out.println(client.getId());
            System.out.println(client.getNom());
            System.out.println(client.getPrenom());


        }
        System.out.println();

        // fetch an individual customer
        System.out.println("Client found with findByFirstName('Fares'):");
        System.out.println("--------------------------------");
        System.out.println(repository.findByPrenom("Fares"));

        System.out.println("Client found with findByLastName('MEHIDI'):");
        System.out.println("--------------------------------");
        for (Client client : repository.findByNom("MEHIDI")) {
            System.out.println(client.getId());
            System.out.println(client.getNom());
            System.out.println(client.getPrenom());        }

    }

}
