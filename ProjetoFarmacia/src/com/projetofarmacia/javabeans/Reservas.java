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
public class Reservas {
    private int idReserva;
    private String nomeCliente, telefone;
    private Farmacia farmacia;
    private Produto produto;

    public Reservas() {
    }

    public Reservas(int idReserva, String nomeCliente, String telefone, Farmacia farmacia, Produto produto) {
        this.idReserva = idReserva;
        this.nomeCliente = nomeCliente;
        this.telefone = telefone;
        this.farmacia = farmacia;
        this.produto = produto;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Farmacia getFarmacia() {
        return farmacia;
    }

    public void setFarmacia(Farmacia farmacia) {
        this.farmacia = farmacia;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
    
    
}
