package com.matteof_mattos.Exe003.DTO;

import com.matteof_mattos.Exe003.entities.Client;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

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

    @PastOrPresent(message = "A data de nascimento informada é inválida.")
    private LocalDate birthDate;

    @Positive(message = "A quantidade de filhos não pode ser negativa.")
    private int children;

    public ClientDTO() { }

    public ClientDTO(long id,String name,String cpf,Double income,LocalDate birthDate,int children) {
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.income = income;
		this.birthDate = birthDate;
		this.children = children;
	}

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
