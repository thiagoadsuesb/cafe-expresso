package servico;

import modelo.ItemPedido;
import modelo.Pedido;
import excecao.ExcecaoPedidoVazio;

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
 * Serviço responsável pelas regras
 * de negócio relacionadas ao pedido.
 */
public class ServicoPedido {

    /**
     * Adiciona um item ao pedido.
     *
     * @param pedido Pedido atual
     * @param item Item do pedido
     */
    public void adicionarItem(Pedido pedido, ItemPedido item) {
        pedido.adicionarItem(item);
    }

    /**
     * Calcula o valor total do pedido.
     *
     * @param pedido Pedido atual
     * @return Valor total
     */
    public double calcularTotal(Pedido pedido) {

        if (pedido.getItens().isEmpty()) {
            throw new ExcecaoPedidoVazio(
                    "O pedido não possui itens."
            );
        }

        return pedido.calcularTotal();
    }
}