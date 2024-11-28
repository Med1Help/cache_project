package com.Cacheproject.services;

import com.Cacheproject.dtos.ClientDto;
import com.Cacheproject.entities.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {
    // Create a new client
    Client createClient(ClientDto ClientDto);

    // Retrieve a client by its ID
    Optional<Client> getClientById(Long id);

    // Retrieve all clients
    List<Client> getAllClients();

    // Update an existing client
    Client updateClient(Long id, ClientDto ClientDto);

    // Delete a client by its ID
    void deleteClient(Long id);

}
