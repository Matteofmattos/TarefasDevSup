package com.matteof_mattos.exe003.controller;

import com.matteof_mattos.exe003.DTO.ClientDTO;
import com.matteof_mattos.exe003.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClientDTO> getClient(@PathVariable long id){
        return ResponseEntity.ok(clientService.getClient(id));
    }

    //size=2&page=1&sort=name (quantidade de elementos por página + página número 1 ordenada por nome)
    @GetMapping
    public ResponseEntity<Page<ClientDTO>> getClients(@RequestParam (name ="name",defaultValue = "")
            String name, Pageable pageable){
        return ResponseEntity.ok(clientService.getClients(name,pageable));
    }

    @PostMapping
    public ResponseEntity<ClientDTO> insertClient(@Valid @RequestBody ClientDTO clientDTO){
        clientDTO = clientService.insertClient(clientDTO);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(clientDTO.getId()).toUri();
        return  ResponseEntity.created(uri).body(clientDTO);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ClientDTO> updateClient(@PathVariable long id, @Valid@RequestBody ClientDTO clientDTO){
          return ResponseEntity.ok(clientService.updateClient(id,clientDTO));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable long id){
        clientService.deleteClient(id);
        return  ResponseEntity.noContent().build();
    }
}
