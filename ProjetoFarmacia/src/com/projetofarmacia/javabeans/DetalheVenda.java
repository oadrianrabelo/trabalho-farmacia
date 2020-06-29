package com.projetofarmacia.javabeans;


// CRIAÇÃO DA CLASSE ENTREGAS RESERVADAS
public class DetalheVenda {
    // ATRIBUTOS
    String produto;
    int quantidade;
    double valor, subtotal;
    Venda venda;
    
    // CONSTRUTORES
    public DetalheVenda() {
    }
    
    public DetalheVenda(String produto, int quantidade, double valor, double subtotal, Venda venda) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.valor = valor;
        this.subtotal = subtotal;
        this.venda = venda;
    }
    
    
    // MÉTODOS GETTERS AND SETTERS

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }
    
    
    
}
