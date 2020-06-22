package com.projetofarmacia.DAO;

import com.projetofarmacia.jdbc.ConnectionFactory;
import java.sql.Connection;

public class EntregasDAO {
    private final Connection conecta;
    
    public EntregasDAO() {
        this.conecta = new ConnectionFactory().conecta();
    }
}
