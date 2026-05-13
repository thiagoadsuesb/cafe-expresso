package modelo;

import constante.MensagensErro;

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
 * Classe responsável por representar
 * um item do pedido.
 * =========================================================
 */
public class ItemPedido {

    private Produto produto;

    private int quantidade;

    /**
     * Construtor do item.
     *
     * @param produto Produto selecionado
     * @param quantidade Quantidade
     */
    public ItemPedido(
            Produto produto,
            int quantidade
    ) {

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
     * Calcula subtotal do item.
     *
     * @return subtotal
     */
    public double calcularSubtotal() {

        return produto.getPreco() * quantidade;
    }

    /**
     * Retorna produto.
     *
     * @return produto
     */
    public Produto getProduto() {
        return produto;
    }

    /**
     * Retorna quantidade.
     *
     * @return quantidade
     */
    public int getQuantidade() {
        return quantidade;
    }
}