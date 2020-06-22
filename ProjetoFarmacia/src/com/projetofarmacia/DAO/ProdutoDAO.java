package com.projetofarmacia.DAO;

import com.projetofarmacia.jdbc.ConnectionFactory;
import java.sql.Connection;

public class ProdutoDAO {
    private final Connection conecta;
    
    public ProdutoDAO() {
        this.conecta = new ConnectionFactory().conecta();
    }
}
