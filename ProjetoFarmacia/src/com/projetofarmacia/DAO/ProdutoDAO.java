package com.projetofarmacia.DAO;

import com.projetofarmacia.javabeans.Farmacia;
import com.projetofarmacia.jdbc.ConnectionFactory;
import java.sql.Connection;
import com.projetofarmacia.javabeans.Produto;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
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
        } catch (ParseException | RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<Produto> listarProduto() {
        try {
            List<Produto> lista = new ArrayList<>();
            String cmdsql = "SELECT nome_produto, fornecedor, quantidade, tarja, preco, data_de_validade, data_de_fabricacao, fk_id_farmacia FROM Produto;";
            
            PreparedStatement stmt = conecta.prepareStatement(cmdsql);
            
            ResultSet rs = stmt.executeQuery();
            
            
            while (rs.next()) {
                try {
                    Produto p = new Produto();
                    Farmacia f = new Farmacia();
                    p.setNomeProduto(rs.getString(1));
                    p.setFornecedor(rs.getString(2));
                    p.setQuantidade(rs.getInt(3));
                    p.setTarja(rs.getString(4));
                    p.setPreco(rs.getDouble(5));
                    p.setDataFabricacao(rs.getDate(6));
                    p.setDataValidade(rs.getDate(7));
                    f.setIdFarmacia(rs.getInt(8));
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
    public static java.sql.Date converteData(java.util.Date dataConverte) throws ParseException {
        String padrao = "dd/MM/yyyy";
        SimpleDateFormat df = new SimpleDateFormat(padrao);
        Date data = Calendar.getInstance().getTime();
        String dataFormatada = df.format(dataConverte);
        System.out.println(dataFormatada);
        return new java.sql.Date(df.parse(dataFormatada).getTime());
        
    }
}
