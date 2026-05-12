package main.modelo;

import main.constante.MensagensErro;

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
 * Representa a associação entre
 * produto e quantidade no pedido.
 */
public class ItemPedido {

    private Produto produto;
    private int quantidade;

    /**
     * Construtor do item do pedido.
     *
     * @param produto Produto selecionado
     * @param quantidade Quantidade solicitada
     */
    public ItemPedido(Produto produto, int quantidade) {

        if (produto == null) {
            throw new IllegalArgumentException(
                    MensagensErro.PRODUTO_NULO
            );
        }

        if (quantidade <= 0) {
            throw new IllegalArgumentException(
                    MensagensErro.QUANTIDADE_INVALIDA
            );
        }

        this.produto = produto;
        this.quantidade = quantidade;
    }

    /**
     * Calcula o subtotal do item.
     *
     * @return Valor subtotal
     */
    public double calcularSubtotal() {
        return produto.getPrecoUnitario() * quantidade;
    }

    /**
     * Retorna o produto.
     *
     * @return Produto
     */
    public Produto getProduto() {
        return produto;
    }

    /**
     * Retorna a quantidade.
     *
     * @return Quantidade
     */
    public int getQuantidade() {
        return quantidade;
    }
}