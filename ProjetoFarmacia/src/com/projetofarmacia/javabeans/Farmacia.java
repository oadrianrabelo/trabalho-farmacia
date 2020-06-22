package com.projetofarmacia.javabeans;

// CRIAÇÃO DA CLASSE FARMÁCIA
public class Farmacia {
    // ATRIBUTOS
    private int idFarmacia;
    private String nomeFarmacia, endereco;
    
    // CONSTRUTORES
    public Farmacia() { }

    public Farmacia(int idFarmacia, String nomeFarmacia, String endereco) {
        this.idFarmacia = idFarmacia;
        this.nomeFarmacia = nomeFarmacia;
        this.endereco = endereco;
    }
    
    // MÉTODOS GETTERS AND SETTERS
    
    public int getIdFarmacia() {
        return idFarmacia;
    }

    public void setIdFarmacia(int idFarmacia) {
        this.idFarmacia = idFarmacia;
    }

    public String getNomeFarmacia() {
        return nomeFarmacia;
    }

    public void setNomeFarmacia(String nomeFarmacia) {
        this.nomeFarmacia = nomeFarmacia;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    
}
