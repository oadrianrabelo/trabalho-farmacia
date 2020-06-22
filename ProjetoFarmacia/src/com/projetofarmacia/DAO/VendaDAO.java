package com.projetofarmacia.DAO;

import com.projetofarmacia.jdbc.ConnectionFactory;
import java.sql.Connection;

public class VendaDAO {
    private final Connection conecta;
    
    public VendaDAO() {
        this.conecta = new ConnectionFactory().conecta();
    }
}
