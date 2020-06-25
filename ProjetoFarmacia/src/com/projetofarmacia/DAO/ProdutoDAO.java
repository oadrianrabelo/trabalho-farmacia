package com.projetofarmacia.DAO;

import com.projetofarmacia.javabeans.Farmacia;
import com.projetofarmacia.jdbc.ConnectionFactory;
import java.sql.Connection;
import com.projetofarmacia.javabeans.Produto;
import com.projetofarmacia.javabeans.TipoProduto;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ProdutoDAO {
    private final Connection conecta;
    
    public ProdutoDAO() {
        this.conecta = new ConnectionFactory().conecta();
    }
    
    public void cadastrarProduto(Produto obj) {
        try {
            String cmdsql = "INSERT INTO Produto(id_produto, nome_produto, fornecedor, lote, data_de_fabricacao, data_de_validade, codigo_de_barras, quantidade, tarja, preco, status_produto, fk_id_tipo_produto, fk_id_farmacia) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
            
            try (PreparedStatement stmt = conecta.prepareStatement(cmdsql)){
                stmt.setInt(1, obj.getIdProduto());
                stmt.setString(2, obj.getNomeProduto());
                stmt.setString(3, obj.getFornecedor());
                stmt.setString(4, obj.getLote());

                stmt.setDate(5, converteData(obj.getDataFabricacao()));
                stmt.setDate(6, converteData(obj.getDataValidade()));
                
                stmt.setLong(7, obj.getCodigoBarras());
                stmt.setInt(8, obj.getQuantidade());
                stmt.setString(9, obj.getTarja());
                stmt.setDouble(10, obj.getPreco());
                stmt.setString(11, obj.getStatus());
                stmt.setInt(12, 1);
                stmt.setInt(13, 1);
                
                stmt.execute();
                stmt.close();
                
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (ParseException | RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<Produto> listarProduto() {
        try {
            List<Produto> lista = new ArrayList<>();
//            String cmdsql = "SELECT id_produto, nome_produto, fornecedor, quantidade, tarja, preco, data_de_validade, data_de_fabricacao, fk_id_farmacia, statusProduto, lote, fk_id_tipo_produto, codigo_de_barras FROM Produto;";
            String cmdsql = "select p.id_produto, p.nome_produto, p.fornecedor, p.quantidade, p.tarja, p.preco, p.data_de_validade, p.data_de_fabricacao, p.status_produto, p.lote, p.codigo_de_barras, t.tipo_produto, f.nome_farmacia from produto p inner join tipo_produto t on (p.fk_id_tipo_produto = t.id_tipo_produto) inner join farmacia f on (p.fk_id_farmacia = f.id_farmacia);";
            
            PreparedStatement stmt = conecta.prepareStatement(cmdsql);
            
            ResultSet rs = stmt.executeQuery();
            
            
            while (rs.next()) {
                try {
                    Produto p = new Produto();
                    Farmacia f = new Farmacia();
                    TipoProduto tp = new TipoProduto();
                    p.setIdProduto(rs.getInt(1));
                    p.setNomeProduto(rs.getString(2));
                    p.setFornecedor(rs.getString(3));
                    p.setQuantidade(rs.getInt(4));
                    p.setTarja(rs.getString(5));
                    p.setPreco(rs.getDouble(6));
                    p.setDataValidade(rs.getDate(7));
                    p.setDataFabricacao(rs.getDate(8));
                    p.setStatus(rs.getString(9));
                    p.setLote(rs.getString(10));
                    p.setCodigoBarras(rs.getLong(11));
                    tp.setTipoProduto(rs.getString(12));
                    f.setNomeFarmacia(rs.getString(13));
                    p.setTipoProduto(tp);
                    p.setFarmacia(f);
                    lista.add(p);
                    
                } catch (NullPointerException e) {
                    
                }
            } 
            
            return lista;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void alterarProduto (Produto obj) {
        try {
            String cmdsql = "UPDATE Produto SET nome_produto = ?, fornecedor = ?, lote = ?, quantidade = ?, tarja = ?, preco = ?, data_de_validade = ?, data_de_fabricacao = ?, codigo_de_barras = ?, status_produto = ?, fk_id_tipo_produto = ? WHERE id_produto = ?;";
            
            try (PreparedStatement stmt = conecta.prepareStatement(cmdsql)) { 
            
                stmt.setString(1, obj.getNomeProduto());
                stmt.setString(2, obj.getFornecedor());
                stmt.setString(3, obj.getLote());
                stmt.setInt(4, obj.getQuantidade());
                stmt.setString(5, obj.getTarja());
                stmt.setDouble(6, obj.getPreco());
                stmt.setDate(7, converteData(obj.getDataValidade()));
                stmt.setDate(8, converteData(obj.getDataFabricacao()));
                stmt.setLong(9, obj.getCodigoBarras());
                stmt.setString(10, obj.getStatus());
                stmt.setInt(11, obj.getTipoProduto().getIdTipoProduto());
                stmt.setInt(12, obj.getIdProduto());
                
                stmt.executeUpdate();
                stmt.close();
                
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        } catch (RuntimeException | ParseException e) {
            throw new RuntimeException(e);
        }
    }
        
    public void excluirProduto(Produto obj) {
        try {
            String cmdsql = "DELETE FROM Produto WHERE id_produto = ?;";
            PreparedStatement stmt = conecta.prepareStatement(cmdsql);
            stmt.setInt(1, obj.getIdProduto());
            
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void corrigeId() {
        try {
            String corrige01 = "SET @num :=0;";
            String corrige02 = "UPDATE Produto SET id_produto = @num := (@num+1);";
            String corrige03 = "ALTER TABLE Produto auto_increment = 1;";
            PreparedStatement stmt = conecta.prepareStatement(corrige01);
            
            stmt.addBatch(corrige01);
            stmt.addBatch(corrige02);
            stmt.addBatch(corrige03);
            
            stmt.executeBatch();
            stmt.close();
        } catch (SQLException e) {
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
