/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetofarmacia.DAO;

import com.projetofarmacia.interfaces.ReservarProduto;
import com.projetofarmacia.javabeans.Farmacia;
import com.projetofarmacia.javabeans.Produto;
import com.projetofarmacia.javabeans.Reservas;
import com.projetofarmacia.javabeans.TipoProduto;
import com.projetofarmacia.jdbc.ConnectionFactory;
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

/**
 *
 * @author Ádrian Rabelo
 */
public class ReservasDAO {
    private final Connection conecta;

    public ReservasDAO() {
        this.conecta = new ConnectionFactory().conecta();
    }
    
    public void reservarProduto(Reservas obj) {
        try {
            String cmdsql = "INSERT INTO Reservas(id_reserva,nome_cliente, telefone, nome_produto, fk_id_farmacia, fk_id_produto) values (?,?,?,?,?,?);";
            try (PreparedStatement stmt = conecta.prepareStatement(cmdsql)) {
                stmt.setInt(1, obj.getIdReserva());
                stmt.setString(2, obj.getNomeCliente());
                stmt.setString(3, obj.getTelefone());
                stmt.setString(4, obj.getProduto().getNomeProduto());
                stmt.setInt(5, obj.getFarmacia().getIdFarmacia());
                stmt.setInt(6, obj.getProduto().getIdProduto());
                
                stmt.execute();
                stmt.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public List<Reservas> listarReservados() {
        try {
            List<Reservas> lista = new ArrayList<>();
//            String cmdsql = "SELECT id_produto, nome_produto, fornecedor, quantidade, tarja, preco, data_de_validade, data_de_fabricacao, fk_id_farmacia, statusProduto, lote, fk_id_tipo_produto, codigo_de_barras FROM Produto;";
//            String cmdsql = "select p.id_produto, p.nome_produto, p.fornecedor, p.quantidade, p.tarja, p.preco, p.data_de_validade, p.data_de_fabricacao, p.status_produto, p.lote, p.codigo_de_barras, t.tipo_produto, f.nome_farmacia from produto p inner join tipo_produto t on (p.fk_id_tipo_produto = t.id_tipo_produto) inner join farmacia f on (p.fk_id_farmacia = f.id_farmacia);";
            String cmdsql = "select r.*, f.nome_farmacia, p.tarja, p.preco, p.data_de_validade from reservas r inner join farmacia f on (r.fk_id_farmacia = f.id_farmacia) inner join produto p on (r.fk_id_produto = p.id_produto);";
            
            PreparedStatement stmt = conecta.prepareStatement(cmdsql);
            
            ResultSet rs = stmt.executeQuery();
            
            
            while (rs.next()) {
                try {
                    Reservas r = new Reservas();
                    Produto p = new Produto();
                    Farmacia f = new Farmacia();
                    r.setIdReserva(rs.getInt(1));
                    r.setNomeCliente(rs.getString(2));
                    p.setNomeProduto(rs.getString(3));
                    r.setTelefone(rs.getString(4));
                    f.setIdFarmacia(rs.getInt(5));
                    p.setIdProduto(rs.getInt(6));
                    f.setNomeFarmacia(rs.getString(7));
                    p.setTarja(rs.getString(8));
                    p.setPreco(rs.getDouble(9));
                    p.setDataValidade(converteData(rs.getDate(10)));
                    
                    r.setProduto(p);
                    r.setFarmacia(f);
                    lista.add(r);
                    
                } catch (NullPointerException | ParseException e) {
                    
                }
            } 
            
            return lista;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void removeReserva(Reservas obj) {
        try {
            String cmdsql = "DELETE FROM Reservas WHERE id_reserva = ?;";
            try (PreparedStatement stmt = conecta.prepareStatement(cmdsql)) {
                stmt.setInt(1, obj.getIdReserva());
                
                stmt.execute();
                stmt.close();
            }
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
