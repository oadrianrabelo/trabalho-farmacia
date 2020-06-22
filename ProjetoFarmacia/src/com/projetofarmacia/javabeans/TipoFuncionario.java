package com.projetofarmacia.javabeans;

// CRIAÇÃO DA CLASSE TIPOFUNCIONARIO
public class TipoFuncionario {
    // ATRIBUTOS
    private int idTipoFuncionario;
    private String tipoFuncionario;
    
    // CONSTRUTORES
    public TipoFuncionario() { }

    public TipoFuncionario(int idTipoFuncionario, String tipoFuncionario) {
        this.idTipoFuncionario = idTipoFuncionario;
        this.tipoFuncionario = tipoFuncionario;
    }
    
    // MÉTODOS GETTERS AND SETTERS

    public int getIdTipoFuncionario() {
        return idTipoFuncionario;
    }

    public void setIdTipoFuncionario(int idTipoFuncionario) {
        this.idTipoFuncionario = idTipoFuncionario;
    }

    public String getTipoFuncionario() {
        return tipoFuncionario;
    }

    public void setTipoFuncionario(String tipoFuncionario) {
        this.tipoFuncionario = tipoFuncionario;
    }
    
    
    
}
