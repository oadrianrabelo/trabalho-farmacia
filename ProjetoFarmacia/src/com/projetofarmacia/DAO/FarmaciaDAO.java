package com.projetofarmacia.DAO;

import com.projetofarmacia.javabeans.Farmacia;
import com.projetofarmacia.jdbc.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FarmaciaDAO {
    private final Connection conecta;
    
    public FarmaciaDAO() {
        this.conecta = new ConnectionFactory().conecta();
    }
    
    public String nomeFarmacia(Farmacia obj) {
        try {
            String nomeFarm = "";
            String cmdsql = "SELECT nome_farmacia FROM Farmacia WHERE id_farmacia = ?;";
            PreparedStatement stmt = conecta.prepareStatement(cmdsql);
            stmt.setInt(1, obj.getIdFarmacia());
            
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                try {
                    
                    obj.setNomeFarmacia(rs.getString("nome_farmacia"));
                    
                    nomeFarm = obj.getNomeFarmacia();
                    
                    System.out.println(nomeFarm);
                } catch (NullPointerException e) {
                    throw new RuntimeException(e);
                }
            }
            return nomeFarm;
                
           
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } 
    }
}
