package com.projetofarmacia.DAO;

import com.projetofarmacia.jdbc.ConnectionFactory;
import java.sql.Connection;
import com.projetofarmacia.javabeans.Produto;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

public class ProdutoDAO {
    private final Connection conecta;
    
    public ProdutoDAO() {
        this.conecta = new ConnectionFactory().conecta();
    }
    
    public void cadastrarProduto(Produto obj) {
        try {
            String cmdsql = "INSERT INTO Produto(id_produto, nome_produto, fornecedor, lote, data_de_fabricacao, data_de_validade, codigo_de_barras, quantidade, tarja, preco, statusProduto, fk_id_tipo_produto, fk_id_farmacia) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
            
            try (PreparedStatement stmt = conecta.prepareStatement(cmdsql)){
                stmt.setInt(1, obj.getIdProduto());
                stmt.setString(2, obj.getNomeProduto());
                stmt.setString(3, obj.getFornecedor());
                stmt.setString(4, obj.getLote());
                stmt.setDate(5, obj.getDataFabricacao());
                stmt.setDate(6, );
                stmt.setLong(7, obj.getCodigoBarras());
                stmt.setInt(8, obj.getQuantidade());
                stmt.setString(9, obj.getTarja());
                stmt.setDouble(10, obj.getPreco());
                stmt.setString(11, obj.getStatus());
                stmt.setInt(12, obj.getTipoProduto().getIdTipoProduto());
                stmt.setInt(13, obj.getFarmacia().getIdFarmacia());
                
                stmt.executeUpdate();
                stmt.close();
                
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
