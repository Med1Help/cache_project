package com.Cacheproject.services;

import com.Cacheproject.daos.ClientRepo;
import com.Cacheproject.dtos.ClientDto;
import com.Cacheproject.dtos.mapper.ClientDtoMapper;
import com.Cacheproject.entities.Client;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService{
    private final ClientDtoMapper clientDtoMapper;
    private final ClientRepo clientRepo;
    
    @Override
    public Client createClient(ClientDto clientDto) {
        Client client = clientDtoMapper.clientDtoToClient(clientDto);
        return clientRepo.save(client);
    }

    @Override
    public Optional<Client> getClientById(Long id) {
        return clientRepo.findById(id);
    }

    @Override
    public List<Client> getAllClients() {
        return clientRepo.findAll();
    }

    @Override
    public Client updateClient(Long id, ClientDto clientDto) {
        Client client = clientDtoMapper.clientDtoToClient(clientDto);
//        client.setId(id);
        return clientRepo.save(client);
    }

    @Override
    public void deleteClient(Long id) {
        Client client = clientRepo.findById(id).get();
        clientRepo.delete(client);
    }
}
