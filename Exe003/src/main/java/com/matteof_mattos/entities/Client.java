package com.matteof_mattos.entities;

import com.matteof_mattos.DTO.ClientDTO;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tb_clients")
public class Client {

    @Id
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @Column(unique = true)
    private String cpf;

    private double income;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private LocalDate birthDate;

    private int children;

    public Client() { }

    public Client(long id, String name, String cpf, double income, LocalDate birthDate, int children) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.income = income;
        this.birthDate = birthDate;
        this.children = children;
    }

    public Client(ClientDTO clientDTO) {
        this.cpf= clientDTO.getCpf();
        this.name=clientDTO.getName();
        this.income= clientDTO.getIncome();
        this.children= clientDTO.getChildren();
        this.birthDate= clientDTO.getBirthDate();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public int getChildren() {
        return children;
    }

    public void setChildren(int children) {
        this.children = children;
    }
}
