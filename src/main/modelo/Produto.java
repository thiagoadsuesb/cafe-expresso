package modelo;

/**
 * =========================================================
 * UNIVERSIDADE ESTADUAL DO SUDOESTE DA BAHIA (UESB)
 * CURSO: ANÁLISE E DESENVOLVIMENTO DE SISTEMAS
 * DISCIPLINA: ENGENHARIA DE SOFTWARE AVANÇADA
 * PROFESSOR: LUCAS SANTOS DE OLIVEIRA
 * ALUNO: THIAGO FERREIRA PRATES NEVES
 * =========================================================
 */

public class Produto {

    private int id;
    private String nome;
    private double preco;

    public Produto(int id, String nome, double preco) {

        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }
}