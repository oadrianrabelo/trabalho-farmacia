package com.projetofarmacia.javabeans;


// CRIAÇÃO DA CLASSE ENTREGAS RESERVADAS
public class EntregasReservadas {
    // ATRIBUTOS
    private int idEntregas;
    private String nome, rg, cpf, endereco, complemento;
    private Venda venda;

    // CONSTRUTORES
    public EntregasReservadas() {
    }

    public EntregasReservadas(int idEntregas, String nome, String rg, String cpf, String endereco, String complemento, Venda venda) {
        this.idEntregas = idEntregas;
        this.nome = nome;
        this.rg = rg;
        this.cpf = cpf;
        this.endereco = endereco;
        this.complemento = complemento;
        this.venda = venda;
    }
    
    // MÉTODOS GETTERS AND SETTERS
    public int getIdEntregas() {
        return idEntregas;
    }

    public void setIdEntregas(int idEntregas) {
        this.idEntregas = idEntregas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
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

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }
    
    
}
