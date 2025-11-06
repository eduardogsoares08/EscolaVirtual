/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import beans.Aluno;
import conexao.InterfaceConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlunoDao {

    private final InterfaceConexao conexao;
    private final Connection conn;

    public AlunoDao(InterfaceConexao conexao) {
        this.conexao = conexao;
        this.conn = conexao.conectar();
    }

    public void inserir(Aluno aluno) {
        String sql = "INSERT INTO aluno (nome, materia, faltas, media) VALUES (?,?,?,?)";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);

            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getMateria());
            stmt.setInt(3, aluno.getFaltas());
            stmt.setDouble(4, aluno.getMedia());

            stmt.execute();

        } catch (Exception e) {
            System.out.println("Erro ao inserir os dados na tabela: " + e.getMessage());
        }

    }

    public List<Aluno> getAluno(String nome) {
        String sql = "SELECT * FROM aluno WHERE nome LIKE ?";

        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, "%" + nome + "%");

            ResultSet rs;
            rs = stmt.executeQuery();

            List<Aluno> listaAluno = new ArrayList<>();

            while (rs.next()) {
                Aluno aluno = new Aluno();

                aluno.setNome(rs.getString("Nome"));
                aluno.setMateria(rs.getString("Materia"));
                aluno.setFaltas(rs.getInt("Faltas"));
                aluno.setMedia(rs.getDouble("Media"));

                listaAluno.add(aluno);

            }
            return listaAluno;

        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            return null;
        }
    }

}
