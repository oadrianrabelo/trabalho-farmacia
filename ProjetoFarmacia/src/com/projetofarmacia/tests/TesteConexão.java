package com.projetofarmacia.tests;

import com.projetofarmacia.jdbc.ConnectionFactory;
import java.sql.Connection;

public class TesteConexão {
    // Classe criada para testar conexões
    
    public static void main(String[] args) {
        try {
            System.out.println("Testando conexão");
            Connection con = new ConnectionFactory().conecta();
            System.out.println("Conectado");
        } catch (Exception e) {
            System.out.println("Não conectado, erro: " + e);
            e.printStackTrace();
        }
    }
}
