/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetofarmacia.DAO;

import com.projetofarmacia.jdbc.ConnectionFactory;
import com.projetofarmacia.javabeans.Funcionario;
import com.projetofarmacia.javabeans.TipoFuncionario;
import com.projetofarmacia.javabeans.Farmacia;
import com.projetofarmacia.javabeans.Departamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Ádrian Rabelo
 */
public class FuncionarioDAO {
    private final Connection conecta;
    
    public FuncionarioDAO() {
        this.conecta = new ConnectionFactory().conecta();
    }
    
    public int efetuarLogin (String login, String senha) {
        try {
            Funcionario f = new Funcionario();
            TipoFuncionario tp = new TipoFuncionario();
            String cmdsql = "SELECT * FROM Funcionario WHERE login = ? and senha = ?;";
            
            PreparedStatement stmt = conecta.prepareStatement(cmdsql);
            
            stmt.setString(1, login);
            stmt.setString(2, senha);
            
            ResultSet rs = stmt.executeQuery();
            if (rs.first()) {
                if (rs.getInt("fk_id_tipo_func") == 1) {
                    System.out.println("gerente");
                    return 1;
                } else if (rs.getInt("fk_id_tipo_func") == 2) {
                    System.out.println("Farmaceutico");
                    return 2;
                } else if (rs.getInt("fk_id_tipo_func") == 3) {
                    System.out.println("caixa");
                    return 3;
                } else if (rs.getInt("fk_id_tipo_func") == 4) {
                    System.out.println("estoquista");
                    return 4;
                } else if (rs.getInt("fk_id_tipo_func") == 5) {
                    System.out.println("vendedor");
                    return 5;
                } else {
                    return 0;
                }
            } else {
                return 0;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    
    public void cadastrarFuncionario (Funcionario obj) {
        try {
            String cmdsql = "INSERT INTO Funcionario(id_funcionario, nome_funcionario, endereco_funcionario, rg, cpf, data_de_nascimento, data_de_admissao, data_de_desligamento, sexo, login, senha, fk_id_departamento, fk_id_farmacia, fk_id_tipo_func) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
            
            try (PreparedStatement stmt = conecta.prepareStatement(cmdsql)) {
                stmt.setInt(1, obj.getIdFuncionario());
                stmt.setString(2, obj.getNomeFuncionario());
                stmt.setString(3, obj.getEnderecoFuncionario());
                stmt.setString(4, obj.getRgFuncionario());
                stmt.setString(5, obj.getCpfFuncionario());
                
                stmt.setDate(6, converteData(obj.getDataNascimento()));
                stmt.setDate(7, converteData(obj.getDataAdmissao()));
                stmt.setDate(8, converteData(obj.getDataDesligamento()));
                
                stmt.setString(9, obj.getSexo());
                stmt.setString(10, obj.getLoginFuncionario());
                stmt.setString(11, obj.getSenhaFuncionario());
                stmt.setInt(12, obj.getDepartamento().getIdDepartamento());
                stmt.setInt(13, obj.getFarmacia().getIdFarmacia());
                stmt.setInt(14, obj.getTipoFuncionario().getIdTipoFuncionario());
                
                stmt.execute();
                stmt.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (ParseException | RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<Funcionario> listarFuncionario () {
        try {
            List<Funcionario> lista = new ArrayList<>();
            String cmdsql = "select f.id_funcionario, f.nome_funcionario, f.endereco_funcionario, f.rg, f.cpf, f.data_de_nascimento, f.data_de_admissao, f.data_de_desligamento, f.sexo, f.login, f.senha, d.nome_departamento, fa.nome_farmacia, t.tipo_funcionario from funcionario f inner join departamento d on (f.fk_id_departamento = d.id_departamento) inner join farmacia fa on (f.fk_id_farmacia = fa.id_farmacia) inner join tipo_funcionario t on (f.fk_id_tipo_func = t.id_tipo) ORDER BY id_funcionario;";
            
            PreparedStatement stmt = conecta.prepareStatement(cmdsql);
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                try {
                    Departamento d = new Departamento();
                    Farmacia fa = new Farmacia();
                    Funcionario f = new Funcionario();
                    TipoFuncionario t = new TipoFuncionario();
                    
                    f.setIdFuncionario(rs.getInt(1));
                    f.setNomeFuncionario(rs.getString(2));
                    f.setEnderecoFuncionario(rs.getString(3));
                    f.setRgFuncionario(rs.getString(4));
                    f.setCpfFuncionario(rs.getString(5));
                    f.setDataNascimento(rs.getDate(6));
                    f.setDataAdmissao(rs.getDate(7));
                    f.setDataDesligamento(rs.getDate(8));
                    f.setSexo(rs.getString(9));
                    f.setLoginFuncionario(rs.getString(10));
                    f.setSenhaFuncionario(rs.getString(11));
                    d.setNomeDepartamento(rs.getString(12));
                    fa.setNomeFarmacia(rs.getString(13));
                    t.setTipoFuncionario(rs.getString(14));
                    
                    f.setDepartamento(d);
                    f.setFarmacia(fa);
                    f.setTipoFuncionario(t);
                    
                    lista.add(f);
                    
                } catch (NullPointerException e) {
                    throw new RuntimeException(e);
                }
            }
            return lista;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void alterarFuncionario (Funcionario obj) {
        try {
            String cmdsql = "UPDATE Funcionario SET nome_funcionario = ?, endereco_funcionario = ?, rg = ?, cpf = ?, data_de_nascimento = ?, data_de_admissao = ?, data_de_desligamento = ?, sexo = ?, login = ?, senha = ?, fk_id_departamento = ?, fk_id_farmacia = ?, fk_id_tipo_func = ? WHERE id_funcionario = ?;";
            try (PreparedStatement stmt = conecta.prepareStatement(cmdsql)){
                
                stmt.setString(1, obj.getNomeFuncionario());
                stmt.setString(2, obj.getEnderecoFuncionario());
                stmt.setString(3, obj.getRgFuncionario());
                stmt.setString(4, obj.getCpfFuncionario());
                stmt.setDate(5, converteData(obj.getDataNascimento()));
                stmt.setDate(6, converteData(obj.getDataAdmissao()));
                stmt.setDate(7, converteData(obj.getDataDesligamento()));
                stmt.setString(8, obj.getSexo());
                stmt.setString(9, obj.getLoginFuncionario());
                stmt.setString(10, obj.getSenhaFuncionario());
                stmt.setInt(11, obj.getDepartamento().getIdDepartamento());
                stmt.setInt(12, obj.getFarmacia().getIdFarmacia());
                stmt.setInt(13, obj.getTipoFuncionario().getIdTipoFuncionario());
                stmt.setInt(14, obj.getIdFuncionario());
                
                stmt.executeUpdate();
                stmt.close();
                
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (RuntimeException | ParseException e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<Funcionario> buscarFuncionario(String nome) {
        try {
            List<Funcionario> lista = new ArrayList<>();
            String cmdsql = "select f.id_funcionario, f.nome_funcionario, f.endereco_funcionario, f.rg, f.cpf, f.data_de_nascimento, f.data_de_admissao, f.data_de_desligamento, f.sexo, f.login, f.senha, d.nome_departamento, fa.nome_farmacia, t.tipo_funcionario from funcionario f inner join departamento d on (f.fk_id_departamento = d.id_departamento) inner join farmacia fa on (f.fk_id_farmacia = fa.id_farmacia) inner join tipo_funcionario t on (f.fk_id_tipo_func = t.id_tipo) WHERE f.nome_funcionario like ? ORDER BY id_funcionario;";
            
            PreparedStatement stmt = conecta.prepareStatement(cmdsql);
            stmt.setString(1, "%" + nome + "%");
            
            ResultSet rs = stmt.executeQuery();
            
             while (rs.next()) {
                try {
                    Departamento d = new Departamento();
                    Farmacia fa = new Farmacia();
                    Funcionario f = new Funcionario();
                    TipoFuncionario t = new TipoFuncionario();
                    
                    f.setIdFuncionario(rs.getInt(1));
                    f.setNomeFuncionario(rs.getString(2));
                    f.setEnderecoFuncionario(rs.getString(3));
                    f.setRgFuncionario(rs.getString(4));
                    f.setCpfFuncionario(rs.getString(5));
                    f.setDataNascimento(rs.getDate(6));
                    f.setDataAdmissao(rs.getDate(7));
                    f.setDataDesligamento(rs.getDate(8));
                    f.setSexo(rs.getString(9));
                    f.setLoginFuncionario(rs.getString(10));
                    f.setSenhaFuncionario(rs.getString(11));
                    d.setNomeDepartamento(rs.getString(12));
                    fa.setNomeFarmacia(rs.getString(13));
                    t.setTipoFuncionario(rs.getString(14));
                    
                    f.setDepartamento(d);
                    f.setFarmacia(fa);
                    f.setTipoFuncionario(t);
                    
                    lista.add(f);
                    
                } catch (NullPointerException e) {
                    throw new RuntimeException(e);
                }
            }
            return lista;
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void excluirFuncionario(Funcionario obj) {
        try {
            String cmdsql = "DELETE FROM Funcionario WHERE id_funcionario = ?";
            try (PreparedStatement stmt = conecta.prepareStatement(cmdsql)) {
                stmt.setInt(1, obj.getIdFuncionario());
                
                stmt.execute();
                stmt.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void corrigeId(Funcionario obj) {
        try {
            String corrige01 = "set @num := 0;";
            String corrige02 = "UPDATE Funcionario SET id_funcionario = @num := (@num+1);";
            String corrige03 = "ALTER TABLE Produto auto_increment = 1;";
            try (PreparedStatement stmt = conecta.prepareStatement(corrige01)) {
                stmt.addBatch(corrige01);
                stmt.addBatch(corrige02);
                stmt.addBatch(corrige03);
                
                stmt.executeBatch();
            }
        } catch (SQLException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        } 
    }
    
    public static java.sql.Date converteData(java.util.Date dataConverte) throws ParseException {
        String padrao = "dd/MM/yyyy";
        SimpleDateFormat df = new SimpleDateFormat(padrao);
        Date data = Calendar.getInstance().getTime();
        String dataFormatada = df.format(dataConverte);
        return new java.sql.Date(df.parse(dataFormatada).getTime());
        
    }
}
