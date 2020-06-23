package com.projetofarmacia.DAO;

import com.projetofarmacia.jdbc.ConnectionFactory;
import java.sql.Connection;
import com.projetofarmacia.javabeans.Produto;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import javax.swing.text.DateFormatter;

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
//                String pattern = "dd/MM/yyyy";
//                SimpleDateFormat df = new SimpleDateFormat(pattern);
//                Date today = Calendar.getInstance().getTime();
//                String dataFab = df.format(obj.getDataFabricacao());
//                String dataVal = df.format(obj.getDataValidade());
//                java.sql.Date datFab = new java.sql.Date(df.parse(dataFab).getTime());
//                java.sql.Date datav = new java.sql.Date(df.parse(dataVal).getTime());
                
                stmt.setDate(5, converteData(obj.getDataFabricacao()));
                stmt.setDate(6, converteData(obj.getDataValidade()));
                
                stmt.setLong(7, obj.getCodigoBarras());
                stmt.setInt(8, obj.getQuantidade());
                stmt.setString(9, obj.getTarja());
                stmt.setDouble(10, obj.getPreco());
                stmt.setString(11, obj.getStatus());
                stmt.setInt(12, 1);
                stmt.setInt(13, 1);
                
                stmt.executeUpdate();
                stmt.close();
                
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (Exception e) {
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
