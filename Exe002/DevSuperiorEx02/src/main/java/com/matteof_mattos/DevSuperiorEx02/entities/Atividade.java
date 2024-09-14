package com.matteof_mattos.DevSuperiorEx02.entities;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_atividade")
public class Atividade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;

    private String descricao;

    private double preco;

    @ManyToMany(mappedBy = "atividades")
    private Set<Participante> participantes = new HashSet<>();

    @ManyToOne()
    @JoinColumn(name = "categoria_id",
            foreignKey = @ForeignKey(name = "fk_atividade_categoria"),referencedColumnName = "id")
    private Categoria categoria;

    @OneToMany(mappedBy = "atividade")
    private Set<Bloco> blocos = new HashSet<>();

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Atividade() { }

    public Atividade(long id, String nome, String descricao, double preco, Categoria categoria) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.categoria = categoria;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Set<Participante> getParticipantes() {
        return participantes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Atividade atividade = (Atividade) o;
        return id == atividade.id && Objects.equals(nome, atividade.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome);
    }

    public Set<Bloco> getBlocos() {
        return blocos;
    }
}
