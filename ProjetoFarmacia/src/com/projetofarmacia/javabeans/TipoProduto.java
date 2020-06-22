package com.projetofarmacia.javabeans;

// CRIAÇÃO DA CLASSE TIPOPRODUTO
public class TipoProduto {
    // ATRIBUTOS
    private int idTipoProduto;
    private String tipoProduto;
    
    // CONSTRUTORES
    public TipoProduto() { }
    
    public TipoProduto(int idTipoProduto, String tipoProduto) {
        this.idTipoProduto = idTipoProduto;
        this.tipoProduto = tipoProduto;
    }

    // MÉTODOS GETTERS AND SETTERS

    public int getIdTipoProduto() {
        return idTipoProduto;
    }

    public void setIdTipoProduto(int idTipoProduto) {
        this.idTipoProduto = idTipoProduto;
    }

    public String getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(String tipoProduto) {
        this.tipoProduto = tipoProduto;
    }
    
    
}
