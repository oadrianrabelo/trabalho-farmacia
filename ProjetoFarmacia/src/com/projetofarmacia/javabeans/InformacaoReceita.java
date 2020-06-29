/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetofarmacia.javabeans;

/**
 *
 * @author Ádrian Rabelo
 */
public class InformacaoReceita {
    // ATRIBUTOS
    String nome, especialidade, endereco;
    Venda venda;
    
    // CONSTRUTORES
    public InformacaoReceita() {
    }

    public InformacaoReceita(String nome, String especialidade, String endereco, Venda venda) {
        this.nome = nome;
        this.especialidade = especialidade;
        this.endereco = endereco;
        this.venda = venda;
    }
    
    
    // GETTERS E SETTERS
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }
    
}
