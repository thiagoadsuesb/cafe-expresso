package main;

/**
 * Universidade Estadual do Sudoeste da Bahia (UESB)
 * Curso: Tecnologia em Análise e Desenvolvimento de Sistemas
 * Disciplina: Engenharia de Software Avançada
 * Professor: Lucas Santos de Oliveira
 * Autor: Thiago Ferreira Prates Neves
 *
 * Projeto – Café Expresso
 *
 * Responsabilidade:
 * Representa um produto do cardápio.
 */
public class Produto {

    private String nome;
    private double precoUnitario;

    public Produto(String nome, double precoUnitario) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException(MensagensErro.NOME_INVALIDO);
        }
        if (precoUnitario <= 0) {
            throw new IllegalArgumentException(MensagensErro.PRECO_INVALIDO);
        }

        this.nome = nome;
        this.precoUnitario = precoUnitario;
    }

    public String getNome() {
        return nome;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }
}