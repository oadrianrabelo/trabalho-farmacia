package com.projetofarmacia.DAO;

import com.projetofarmacia.jdbc.ConnectionFactory;
import java.sql.Connection;

public class FarmaciaDAO {
    private final Connection conecta;
    
    public FarmaciaDAO() {
        this.conecta = new ConnectionFactory().conecta();
    }
}
