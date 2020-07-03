package com.projetofarmacia.DAO;

import com.projetofarmacia.javabeans.Farmacia;
import com.projetofarmacia.javabeans.Funcionario;
import com.projetofarmacia.jdbc.ConnectionFactory;
import com.projetofarmacia.javabeans.Receita;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ReceitaDAO {
    private final Connection conecta;
    
    public ReceitaDAO() {
        this.conecta = new ConnectionFactory().conecta();
    }
    
    public void cadastrarReceita(Receita obj){
        try {
            String cmdsql = "insert into receita(id_receita, nome_paciente, nome_profissional, crm, cpf, endereco_paciente, endereco_profissional, fk_id_funcionario, fk_id_farmacia) values (?,?,?,?,?,?,?,?,?);";
            try (PreparedStatement stmt = conecta.prepareStatement(cmdsql)) {
                stmt.setInt(1,  obj.getIdReceita());
                stmt.setString(2, obj.getNomePaciente());
                stmt.setString(3, obj.getNomeProfissional());
                stmt.setString(4, obj.getCrm());
                stmt.setString(5, obj.getCpf());
                stmt.setString(6, obj.getEnderecoPaciente());
                stmt.setString(7, obj.getEnderecoProfissional());
                stmt.setInt(8, obj.getFuncionario().getIdFuncionario());
                stmt.setInt(9, obj.getFarmacia().getIdFarmacia());
                
                
                stmt.execute();
                stmt.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
