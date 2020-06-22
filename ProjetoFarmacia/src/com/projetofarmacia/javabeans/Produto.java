package com.projetofarmacia.javabeans;

// CRIAÇÃO DA CLASSE PRODUTO

import java.util.Date;

public class Produto {
    // ATRIBUTOS
    private int idProduto, quantidade;
    private String nomeProduto, fornecedor, lote, tarja, status;
    private long codigoBarras;
    private Date dataValidade, dataFabricacao;
    private double preco;
    private TipoProduto tipoProduto;
    private Farmacia farmacia;

    // CONSTRUTORES
    public Produto() { }

    public Produto(int idProduto, int quantidade, String nomeProduto, String fornecedor, String lote, String tarja, String status, long codigoBarras, Date dataValidade, Date dataFabricacao, double preco, TipoProduto tipoProduto, Farmacia farmacia) {
        this.idProduto = idProduto;
        this.quantidade = quantidade;
        this.nomeProduto = nomeProduto;
        this.fornecedor = fornecedor;
        this.lote = lote;
        this.tarja = tarja;
        this.status = status;
        this.codigoBarras = codigoBarras;
        this.dataValidade = dataValidade;
        this.dataFabricacao = dataFabricacao;
        this.preco = preco;
        this.tipoProduto = tipoProduto;
        this.farmacia = farmacia;
    }
    
    // MÉTODOS GETTERS AND SETTERS

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public String getTarja() {
        return tarja;
    }

    public void setTarja(String tarja) {
        this.tarja = tarja;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(long codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public Date getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(Date dataValidade) {
        this.dataValidade = dataValidade;
    }

    public Date getDataFabricacao() {
        return dataFabricacao;
    }

    public void setDataFabricacao(Date dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public TipoProduto getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(TipoProduto tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    public Farmacia getFarmacia() {
        return farmacia;
    }

    public void setFarmacia(Farmacia farmacia) {
        this.farmacia = farmacia;
    }
    
}
