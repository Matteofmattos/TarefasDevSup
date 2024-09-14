package com.matteof_mattos.exe003.DTO;

import com.matteof_mattos.exe003.entities.Client;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.time.Instant;

public class ClientDTO {

    private long id;

    @NotBlank(message = "O campo nome não pode ser nulo.")
    @Size(min = 3,max = 20,message = "O campo nome deve ter no mínimo 3 caracteres.")
    private String name;

    @NotBlank(message = "O campo cpf não pode ser nulo.")
    @Size(min = 3,max = 20,message = "O campo cpf deve ter 11 digitos.")
    private String cpf;

    @Positive(message = "O valor da renda não pode ser negativo.")
    private double income;

    private Instant birthDate;

    @Positive(message = "A quantidade de filhos não pode ser negativa.")
    private int children;

    public ClientDTO() { }

    public ClientDTO(Client client) {
        this.id= client.getId();
        this.name=client.getName();
        this.cpf=client.getCpf();
        this.income=client.getIncome();
        this.birthDate=client.getBirthDate();
        this.children=client.getChildren();
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

    public Instant getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Instant birthDate) {
        this.birthDate = birthDate;
    }

    public int getChildren() {
        return children;
    }

    public void setChildren(int children) {
        this.children = children;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
