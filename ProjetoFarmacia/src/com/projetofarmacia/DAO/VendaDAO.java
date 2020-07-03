package com.projetofarmacia.DAO;

import com.projetofarmacia.tests.*;
import com.projetofarmacia.javabeans.Farmacia;
import com.projetofarmacia.javabeans.Funcionario;
import com.projetofarmacia.javabeans.Produto;
import com.projetofarmacia.jdbc.ConnectionFactory;
import com.projetofarmacia.javabeans.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class VendaDAO {
    private final Connection conecta;
    
    public VendaDAO() {
        this.conecta = new ConnectionFactory().conecta();
    }
    
    public void insereVenda(Venda obj) {
        String cmdsql = "INSERT INTO Venda(id_venda, nome, data_venda, tarja, tipo, `status`, quantidade, total, fk_id_produto, fk_id_funcionario, fk_id_farmacia) values (?,?,?,?,?,?,?,?,?,?,?)";
        
        try (PreparedStatement stmt = conecta.prepareStatement(cmdsql)) {
            stmt.setInt(1, obj.getIdVenda());
            stmt.setString(2, obj.getNome());
            stmt.setDate(3, converteData(obj.getDataVenda()));
            stmt.setString(4, obj.getTarja());
            stmt.setString(5, obj.getTipo());
            stmt.setString(6, obj.getStatus());
            stmt.setInt(7, obj.getQuantidade());
            stmt.setDouble(8, obj.getTotal());
            stmt.setInt(9, obj.getProduto().getIdProduto());
            stmt.setInt(10, obj.getFuncionario().getIdFuncionario());
            stmt.setInt(11, obj.getFarmacia().getIdFarmacia());
            
            stmt.execute();
            stmt.close();
            
        } catch (SQLException | ParseException e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<Venda> listarAberto(Farmacia far) {
        try {
            List<Venda> lista = new ArrayList<>();
            String cmdsql = "select v.*, p.preco, p.nome_produto, f.nome_funcionario from venda v inner join produto p on (v.fk_id_produto = p.id_produto) inner join funcionario f on (v.fk_id_funcionario = f.id_funcionario) WHERE `status` like '%em aberto%' and v.fk_id_farmacia = ?;";
            PreparedStatement stmt = conecta.prepareStatement(cmdsql);
            stmt.setInt(1, far.getIdFarmacia());
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                try {
                    Produto p = new Produto();
                    Farmacia f = new Farmacia();
                    Venda v = new Venda();
                    Funcionario fun = new Funcionario();
                    v.setIdVenda(rs.getInt(1));
                    v.setNome(rs.getString(2));
                    v.setDataVenda(rs.getDate(3));
                    v.setTarja(rs.getString(4));
                    v.setTipo(rs.getString(5));
                    v.setStatus(rs.getString(6));
                    v.setQuantidade(rs.getInt(7));
                    v.setTotal(rs.getDouble(8));
                    
                    p.setIdProduto(rs.getInt(9));
                    f.setIdFarmacia(rs.getInt(10));
                    fun.setIdFuncionario(rs.getInt(11));
                    
                    p.setPreco(rs.getDouble(12));
                    p.setNomeProduto(rs.getString(13));
                    fun.setNomeFuncionario(rs.getString(14));
                    
                    v.setProduto(p);
                    v.setFarmacia(f);
                    v.setFuncionario(fun);
                    
                    lista.add(v);
                    
                } catch (NullPointerException e) {
                    
                }
            } 
            
            return lista;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void removeItemVenda(Venda obj) {
        try {
            String cmdsql = "DELETE FROM Venda WHERE id_venda = ?;";
            
            PreparedStatement stmt = conecta.prepareStatement(cmdsql);
            stmt.setInt(1, obj.getIdVenda());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void finalizarVenda(Venda obj) {
        try {
            String cmdsql = "UPDATE Venda SET `status` = 'finalizado' WHERE `status` like 'EM ABERTO' OR `status` LIKE 'NO CAIXA';";
            
            try (PreparedStatement stmt = conecta.prepareStatement(cmdsql)) {
                
                stmt.executeUpdate();
                stmt.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (RuntimeException e) {
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
