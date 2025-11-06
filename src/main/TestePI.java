/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import beans.Aluno;
import dao.AlunoDao;
import conexao.Conexao;

public class TestePI {
    public static void main(String[] args) {
        AlunoDao dao = new AlunoDao(new Conexao());

        Aluno aluno = new Aluno();
        aluno.setNome("Maria");
        aluno.setMateria("Programação");
        aluno.setFaltas(1);
        aluno.setMedia(9.5);

        dao.inserir(aluno);
        System.out.println("Aluno inserido com sucesso!");
    }
}