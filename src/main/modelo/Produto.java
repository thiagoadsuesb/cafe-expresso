package modelo;

import constante.MensagensErro;
import utilitario.ValidadorTexto;

/**
 * Universidade Estadual do Sudoeste da Bahia (UESB)
 * Curso: Tecnologia em Análise e Desenvolvimento de Sistemas
 * Disciplina: Engenharia de Software Avançada
 * Professor: Lucas Santos de Oliveira
 * Autor: Thiago Ferreira Prates Neves
 *
 * Projeto: Café Expresso
 *
 * Descrição:
 * Representa um produto do cardápio
 * da cafeteria com nome e preço unitário.
 */
public class Produto {

    private String nome;
    private double precoUnitario;

    /**
     * Construtor da classe Produto.
     *
     * @param nome Nome do produto
     * @param precoUnitario Valor unitário
     */
    public Produto(String nome, double precoUnitario) {

        if (ValidadorTexto.textoEstaVazio(nome)) {
            throw new IllegalArgumentException(
                    MensagensErro.NOME_INVALIDO
            );
        }

        if (precoUnitario <= 0) {
            throw new IllegalArgumentException(
                    MensagensErro.PRECO_INVALIDO
            );
        }

        this.nome = ValidadorTexto.limparEspacos(nome);
        this.precoUnitario = precoUnitario;
    }

    /**
     * Retorna o nome do produto.
     *
     * @return Nome do produto
     */
    public String getNome() {
        return nome;
    }

    /**
     * Retorna o preço unitário.
     *
     * @return Preço unitário
     */
    public double getPrecoUnitario() {
        return precoUnitario;
    }
}