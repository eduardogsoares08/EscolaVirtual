/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

    public Connection Conexao() {

        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/ escola_virtual ",
                    "root",
                    "dudu"
            );
            return conn;

        } catch (Exception e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
            return null;
        }

    }
}
