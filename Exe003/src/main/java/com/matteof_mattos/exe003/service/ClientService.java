package com.matteof_mattos.exe003.service;

import com.matteof_mattos.exe003.DTO.ClientDTO;
import com.matteof_mattos.exe003.entities.Client;
import com.matteof_mattos.exe003.exceptions.DatabaseException;
import com.matteof_mattos.exe003.exceptions.ResourceNotFoundException;
import com.matteof_mattos.exe003.repositories.ClientRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    @Transactional(readOnly = true)
    public ClientDTO getClient(long id) throws ResourceNotFoundException{

        Client client = repository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Recurso não encontrado."));
        return new ClientDTO(client);
    }

    @Transactional(readOnly = true)
    public Page<ClientDTO> getClients(String name, Pageable pageable){
        Page<Client> clients = repository.searchByName(name, pageable);
        return clients.map(ClientDTO::new);
    }

    @Transactional
    public ClientDTO insertClient(ClientDTO clientDTO) {

        Client client = repository.save(new Client(clientDTO));
        return new ClientDTO(client);
    }

    @Transactional
    public ClientDTO updateClient(long id, ClientDTO clientDTO) throws ResourceNotFoundException {

        try{

            Client client = repository.getReferenceById(id);
            client.setName(clientDTO.getName());
            client.setChildren(clientDTO.getChildren());
            client.setIncome(clientDTO.getIncome());
            client.setBirthDate(clientDTO.getBirthDate());
            client.setCpf(clientDTO.getCpf());

            client = repository.save(client);
            return new ClientDTO(client);

        } catch (EntityNotFoundException exc){
            throw new ResourceNotFoundException("Recurso não encontrado.");
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void deleteClient(long id) throws ResourceNotFoundException{

        if (!repository.existsById(id)){
            throw new ResourceNotFoundException("Recurso não encontrado.");
        } else {
            try {
                repository.deleteById(id);
            } catch (DataIntegrityViolationException exc){
                throw new DatabaseException("Integridade referencial violada.");
            }
        }
    }
}
