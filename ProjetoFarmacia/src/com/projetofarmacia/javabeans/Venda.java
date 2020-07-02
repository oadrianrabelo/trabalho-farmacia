package com.projetofarmacia.javabeans;

// CRIAÇÃO DA CLASSE VENDA

import java.util.Date;

public class Venda {
    // ATRIBUTOS
    private int idVenda, quantidade;
    private double total;
    private String nome, status, tipo, tarja;
    private Date dataVenda;
    private Farmacia farmacia;
    private Funcionario funcionario;
    private Produto produto;
    
    // CONSTRUTORES

    public Venda() {
    }

    public Venda(int idVenda, int quantidade, double total, String nome, String status, String tipo, String tarja, Date dataVenda, Farmacia farmacia, Funcionario funcionario, Produto produto) {
        this.idVenda = idVenda;
        this.quantidade = quantidade;
        this.total = total;
        this.nome = nome;
        this.status = status;
        this.tipo = tipo;
        this.tarja = tarja;
        this.dataVenda = dataVenda;
        this.farmacia = farmacia;
        this.funcionario = funcionario;
        this.produto = produto;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTarja() {
        return tarja;
    }

    public void setTarja(String tarja) {
        this.tarja = tarja;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public Farmacia getFarmacia() {
        return farmacia;
    }

    public void setFarmacia(Farmacia farmacia) {
        this.farmacia = farmacia;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
    
}
