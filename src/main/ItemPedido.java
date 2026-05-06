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
 * Representa um item dentro de um pedido.
 */
public class ItemPedido {

    private Produto produto;
    private int quantidade;

    public ItemPedido(Produto produto, int quantidade) {

        if (produto == null) {
            throw new IllegalArgumentException(MensagensErro.PRODUTO_NULO);
        }

        if (quantidade <= 0) {
            throw new IllegalArgumentException(MensagensErro.QUANTIDADE_INVALIDA);
        }

        this.produto = produto;
        this.quantidade = quantidade;
    }

    public double calcularSubtotal() {
        return produto.getPrecoUnitario() * quantidade;
    }
}