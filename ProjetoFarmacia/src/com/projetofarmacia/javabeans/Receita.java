package com.projetofarmacia.javabeans;

public class Receita {
    private int idReceita;
    private String nomePaciente, nomeProfissional, enderecoPaciente, enderecoProfissional, crm, cpf;
    private Farmacia farmacia;
    private Funcionario funcionario;

    public Receita() {
    }

    public Receita(int idReceita, String nomePaciente, String nomeProfissional, String enderecoPaciente, String enderecoProfissional, String crm, String cpf, Farmacia farmacia, Funcionario funcionario) {
        this.idReceita = idReceita;
        this.nomePaciente = nomePaciente;
        this.nomeProfissional = nomeProfissional;
        this.enderecoPaciente = enderecoPaciente;
        this.enderecoProfissional = enderecoProfissional;
        this.crm = crm;
        this.cpf = cpf;
        this.farmacia = farmacia;
        this.funcionario = funcionario;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    
    public int getIdReceita() {
        return idReceita;
    }

    public void setIdReceita(int idReceita) {
        this.idReceita = idReceita;
    }

    public String getNomePaciente() {
        return nomePaciente;
    }

    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    public String getNomeProfissional() {
        return nomeProfissional;
    }

    public void setNomeProfissional(String nomeProfissional) {
        this.nomeProfissional = nomeProfissional;
    }

    public String getEnderecoPaciente() {
        return enderecoPaciente;
    }

    public void setEnderecoPaciente(String enderecoPaciente) {
        this.enderecoPaciente = enderecoPaciente;
    }

    public String getEnderecoProfissional() {
        return enderecoProfissional;
    }

    public void setEnderecoProfissional(String enderecoProfissional) {
        this.enderecoProfissional = enderecoProfissional;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
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
    
    
    
}
