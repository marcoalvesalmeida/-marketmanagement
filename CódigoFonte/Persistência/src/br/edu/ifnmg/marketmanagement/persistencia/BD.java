/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.marketmanagement.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author petronio
 */
public class BD {
    
    private static Connection conexao;
    
    public static Connection getConexao() throws ClassNotFoundException, SQLException{
        if(conexao == null){
            Class.forName("com.mysql.jdbc.Driver");
            conexao = DriverManager.getConnection("jdbc:mysql://localhost/marketmanagement", "root", "");
        }
        return conexao;
    }
    
}
