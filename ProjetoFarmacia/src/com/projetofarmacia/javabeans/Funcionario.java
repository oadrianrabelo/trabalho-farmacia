package com.projetofarmacia.javabeans;

// CRIAÇÃO DA CLASSE FUNCIONÁRIO

import java.util.Date;

public class Funcionario {
    // ATRIBUTOS
    private int idFuncionario, crm;
    private String nomeFuncionario, enderecoFuncionario, rgFuncionario, cpfFuncionario, loginFuncionario, senhaFuncionario, sexo;
    private Date dataNascimento, dataAdmissao, dataDesligamento;
    private Farmacia farmacia;
    private Departamento departamento;
    private TipoFuncionario tipoFuncionario;

    // CONSTRUTORES
    public Funcionario() { }

    public Funcionario(int idFuncionario, int crm, String nomeFuncionario, String enderecoFuncionario, String rgFuncionario, String cpfFuncionario, String loginFuncionario, String senhaFuncionario, String sexo, Date dataNascimento, Date dataAdmissao, Date dataDesligameto, Farmacia farmacia, Departamento departamento, TipoFuncionario tipoFuncionario) {
        this.idFuncionario = idFuncionario;
        this.crm = crm;
        this.nomeFuncionario = nomeFuncionario;
        this.enderecoFuncionario = enderecoFuncionario;
        this.rgFuncionario = rgFuncionario;
        this.cpfFuncionario = cpfFuncionario;
        this.loginFuncionario = loginFuncionario;
        this.senhaFuncionario = senhaFuncionario;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
        this.dataAdmissao = dataAdmissao;
        this.dataDesligamento = dataDesligameto;
        this.farmacia = farmacia;
        this.departamento = departamento;
        this.tipoFuncionario = tipoFuncionario;
    }

    // MÉTODOS GETTERS AND SETTERS
    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public String getEnderecoFuncionario() {
        return enderecoFuncionario;
    }

    public void setEnderecoFuncionario(String enderecoFuncionario) {
        this.enderecoFuncionario = enderecoFuncionario;
    }

    public String getRgFuncionario() {
        return rgFuncionario;
    }

    public void setRgFuncionario(String rgFuncionario) {
        this.rgFuncionario = rgFuncionario;
    }

    public String getCpfFuncionario() {
        return cpfFuncionario;
    }

    public void setCpfFuncionario(String cpfFuncionario) {
        this.cpfFuncionario = cpfFuncionario;
    }

    public String getLoginFuncionario() {
        return loginFuncionario;
    }

    public void setLoginFuncionario(String loginFuncionario) {
        this.loginFuncionario = loginFuncionario;
    }

    public String getSenhaFuncionario() {
        return senhaFuncionario;
    }

    public void setSenhaFuncionario(String senhaFuncionario) {
        this.senhaFuncionario = senhaFuncionario;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Date getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(Date dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public Farmacia getFarmacia() {
        return farmacia;
    }

    public void setFarmacia(Farmacia farmacia) {
        this.farmacia = farmacia;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public TipoFuncionario getTipoFuncionario() {
        return tipoFuncionario;
    }

    public void setTipoFuncionario(TipoFuncionario tipoFuncionario) {
        this.tipoFuncionario = tipoFuncionario;
    }

    public int getCrm() {
        return crm;
    }

    public void setCrm(int crm) {
        this.crm = crm;
    }

    public Date getDataDesligamento() {
        return dataDesligamento;
    }

    public void setDataDesligamento(Date dataDesligamento) {
        this.dataDesligamento = dataDesligamento;
    }

    
    
}
