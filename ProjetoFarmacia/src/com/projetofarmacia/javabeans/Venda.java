package com.projetofarmacia.javabeans;

// CRIAÇÃO DA CLASSE VENDA

import java.util.Date;

public class Venda {
    // ATRIBUTOS
    private int idVenda;
    private String cliente, status, obs, cpf, endereco;
    private double total;
    private Date dataVenda;
    private Farmacia farmacia;
    private Funcionario funcionario;
    private Produto produto;
    
    // CONSTRUTORES

    public Venda() { }

    public Venda(int idVenda, String cliente, String status, String obs, String cpf, String endereco, double total, Date dataVenda, Farmacia farmacia, Funcionario funcionario, Produto produto) {
        this.idVenda = idVenda;
        this.cliente = cliente;
        this.status = status;
        this.obs = obs;
        this.cpf = cpf;
        this.endereco = endereco;
        this.total = total;
        this.dataVenda = dataVenda;
        this.farmacia = farmacia;
        this.funcionario = funcionario;
        this.produto = produto;
    }

    // GETTERS E SETTERS

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
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
