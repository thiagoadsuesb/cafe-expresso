package test;

import main.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
 * Testes unitários do sistema utilizando JUnit.
 */
public class PedidoTeste {

    @Test
    void deveAdicionarItemAoPedido() {
        Produto cafe = new Produto("Café", 5.0);
        ItemPedido item = new ItemPedido(cafe, 2);

        Pedido pedido = new Pedido();
        pedido.adicionarItem(item);

        assertEquals(1, pedido.getItens().size());
    }

    @Test
    void deveCalcularTotalCorretamente() {
        Produto cafe = new Produto("Café", 5.0);
        Produto pao = new Produto("Pão", 3.0);

        Pedido pedido = new Pedido();

        pedido.adicionarItem(new ItemPedido(cafe, 2));
        pedido.adicionarItem(new ItemPedido(pao, 3));

        assertEquals(19.0, pedido.calcularTotal(), 0.01);
    }

    @Test
    void naoDevePermitirProdutoNulo() {
        assertThrows(IllegalArgumentException.class,
                () -> new ItemPedido(null, 1));
    }

    @Test
    void deveAvancarStatusCorretamente() {
        Pedido pedido = new Pedido();

        assertEquals(StatusPedido.PENDENTE, pedido.getStatus());

        pedido.avancarStatus();
        assertEquals(StatusPedido.PAGO, pedido.getStatus());

        pedido.avancarStatus();
        assertEquals(StatusPedido.EM_PREPARO, pedido.getStatus());

        pedido.avancarStatus();
        assertEquals(StatusPedido.FINALIZADO, pedido.getStatus());
    }
}