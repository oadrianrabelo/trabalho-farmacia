package com.projetofarmacia.javabeans;

// CRIAÇÃO DA CLASSE DEPARTAMENTO
public class Departamento {
    // ATRIBUTOS
    private int idDepartamento;
    private String nomeDepartamento;
    
    // CONSTRUTORES
    public Departamento() { }
    
    public Departamento(int idDepartamento, String nomeDepartamento) {
        this.idDepartamento = idDepartamento;
        this.nomeDepartamento = nomeDepartamento;
    }
    // MÉTODOS GETTERS AND SETTERS

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getNomeDepartamento() {
        return nomeDepartamento;
    }

    public void setNomeDepartamento(String nomeDepartamento) {
        this.nomeDepartamento = nomeDepartamento;
    }
    
    

}
