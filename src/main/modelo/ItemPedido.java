package modelo;

import constante.MensagensErro;

/**
 * =========================================================
 * UNIVERSIDADE ESTADUAL DO SUDOESTE DA BAHIA (UESB)
 * CURSO: TECNOLOGIA EM ANÁLISE E DESENVOLVIMENTO DE SISTEMAS
 * DISCIPLINA: ENGENHARIA DE SOFTWARE AVANÇADA
 * PROFESSOR: LUCAS SANTOS DE OLIVEIRA
 * AUTOR: THIAGO FERREIRA PRATES NEVES
 * =========================================================
 *
 * PROJETO: CAFÉ EXPRESSO
 *
 * DESCRIÇÃO:
 * Classe responsável por representar
 * um item do pedido.
 * =========================================================
 */
public class ItemPedido {

    /**
     * Produto do item.
     */
    private Produto produto;

    /**
     * Quantidade solicitada.
     */
    private int quantidade;

    /**
     * =====================================================
     * CONSTRUTOR
     * =====================================================
     *
     * @param produto Produto selecionado
     * @param quantidade Quantidade escolhida
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
     * =====================================================
     * CALCULA SUBTOTAL
     * =====================================================
     *
     * @return Valor subtotal
     */
    public double calcularSubtotal() {

        return produto.getPrecoUnitario()
                * quantidade;
    }

    /**
     * =====================================================
     * RETORNA PRODUTO
     * =====================================================
     *
     * @return Produto
     */
    public Produto getProduto() {
        return produto;
    }

    /**
     * =====================================================
     * RETORNA QUANTIDADE
     * =====================================================
     *
     * @return Quantidade
     */
    public int getQuantidade() {
        return quantidade;
    }
}