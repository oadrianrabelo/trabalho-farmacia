package com.projetofarmacia.javabeans;

// CRIAÇÃO DA CLASSE VENDA

import java.util.Date;

public class Venda {
    // ATRIBUTOS
    private int idVenda, quantidade;
    private double precoVenda;
    private Date dataVenda;
    private Farmacia farmacia;
    private Funcionario funcionario;
    private Produto produto;
    
    // CONSTRUTORES

    public Venda() { }

    public Venda(int idVenda, int quantidade, double precoVenda, Date dataVenda, Farmacia farmacia, Funcionario funcionario, Produto produto) {
        this.idVenda = idVenda;
        this.quantidade = quantidade;
        this.precoVenda = precoVenda;
        this.dataVenda = dataVenda;
        this.farmacia = farmacia;
        this.funcionario = funcionario;
        this.produto = produto;
    }
    
    // MÉTODOS GETTERS AND SETTERS

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

    public double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
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
