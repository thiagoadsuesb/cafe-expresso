package modelo;

/**
 * =========================================================
 * UNIVERSIDADE ESTADUAL DO SUDOESTE DA BAHIA (UESB)
 * CURSO: ANÁLISE E DESENVOLVIMENTO DE SISTEMAS
 * DISCIPLINA: ENGENHARIA DE SOFTWARE AVANÇADA
 * PROFESSOR: LUCAS SANTOS DE OLIVEIRA
 * ALUNO: THIAGO FERREIRA PRATES NEVES
 * =========================================================
 *
 * PROJETO: CAFÉ EXPRESSO SYSTEM
 *
 * DESCRIÇÃO:
 * Representa um produto do cardápio da cafeteria.
 * =========================================================
 */

/**
 * =========================================================
 * PRODUTO DO CARDÁPIO
 * =========================================================
 */

public class Produto {

    private int id;
    private String nome;
    private double preco;

    public Produto(int id, String nome, double preco) {
        if (id <= 0) throw new IllegalArgumentException("ID inválido");
        if (nome == null || nome.isBlank()) throw new IllegalArgumentException("Nome inválido");
        if (preco <= 0) throw new IllegalArgumentException("Preço inválido");

        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    public int getId() { return id; }

    public String getNome() { return nome; }

    public double getPreco() { return preco; }
}