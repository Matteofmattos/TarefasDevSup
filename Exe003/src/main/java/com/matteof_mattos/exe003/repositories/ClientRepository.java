package com.matteof_mattos.exe003.repositories;

import com.matteof_mattos.exe003.entities.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClientRepository extends JpaRepository<Client,Long> {

    @Query("select c from Client c where UPPER(c.name) like UPPER(CONCAT(:name,'%'))")
    Page<Client> searchByName(String name, Pageable pageable);
}
