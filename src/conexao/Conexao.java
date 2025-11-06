/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao implements InterfaceConexao{
    
   private static final String URL = "jdbc:mysql://localhost/escola_virtual";
    private static final String usuario = "root";
    private static final String senha = "dudu";
    
    
    @Override
    public Connection conectar() {

        try {
            return DriverManager.getConnection(URL, usuario, senha);
        } catch (SQLException e) {
            System.out.println("Erro na conexão: " + e.getMessage());
            return null;
        }
        

    }
}
