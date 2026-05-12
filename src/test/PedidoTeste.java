package test;

import main.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * =========================================================
 * Universidade Estadual do Sudoeste da Bahia (UESB)
 * Curso: Tecnologia em Análise e Desenvolvimento de Sistemas
 * Disciplina: Engenharia de Software Avançada
 * Professor: Lucas Santos de Oliveira
 * Autor: Thiago Ferreira Prates Neves
 * Projeto: Café Expresso
 * =========================================================
 *
 * Classe responsável pelos testes unitários
 * da entidade Pedido.
 *
 * Objetivos:
 * - Validar regras de negócio
 * - Garantir integridade do sistema
 * - Aplicar conceitos de TDD
 * - Simular cenários reais e inválidos
 *
 * Tecnologias:
 * - Java
 * - JUnit 5
 *
 * =========================================================
 */

public class PedidoTeste {

    /**
     * Deve adicionar um item corretamente ao pedido.
     */
    @Test
    void deveAdicionarItemAoPedido() {

        Produto cafe = new Produto("Café", 5.0);
        ItemPedido item = new ItemPedido(cafe, 2);

        Pedido pedido = new Pedido();

        pedido.adicionarItem(item);

        assertEquals(1, pedido.getItens().size());
    }

    /**
     * Deve calcular corretamente o valor total do pedido.
     */
    @Test
    void deveCalcularTotalCorretamente() {

        Produto cafe = new Produto("Café", 5.0);
        Produto pao = new Produto("Pão", 3.0);

        Pedido pedido = new Pedido();

        pedido.adicionarItem(new ItemPedido(cafe, 2));
        pedido.adicionarItem(new ItemPedido(pao, 3));

        assertEquals(19.0, pedido.calcularTotal(), 0.01);
    }

    /**
     * Não deve permitir produto nulo.
     */
    @Test
    void naoDevePermitirProdutoNulo() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new ItemPedido(null, 1)
        );
    }

    /**
     * Deve avançar os status corretamente.
     */
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

    /**
     * Não deve permitir quantidade negativa.
     *
     * TESTE TDD - RED
     */
    @Test
    void naoDevePermitirQuantidadeNegativa() {

        Produto cafe = new Produto("Café", 5.0);

        assertThrows(
                IllegalArgumentException.class,
                () -> new ItemPedido(cafe, -1)
        );
    }

    /**
     * Não deve permitir produto com preço negativo.
     *
     * TESTE TDD - RED
     */
    @Test
    void naoDevePermitirPrecoNegativo() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new Produto("Café", -10.0)
        );
    }

    /**
     * Não deve permitir nome vazio.
     *
     * TESTE TDD - RED
     */
    @Test
    void naoDevePermitirNomeVazio() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new Produto("", 5.0)
        );
    }

    /**
     * Pedido vazio deve possuir total zero.
     */
    @Test
    void pedidoVazioDeveTerTotalZero() {

        Pedido pedido = new Pedido();

        assertEquals(0.0, pedido.calcularTotal());
    }

    /**
     * Não deve permitir avançar status após finalizado.
     *
     * TESTE TDD - RED
     */
    @Test
    void naoDeveAvancarStatusAposFinalizado() {

        Pedido pedido = new Pedido();

        pedido.avancarStatus();
        pedido.avancarStatus();
        pedido.avancarStatus();

        assertThrows(
                IllegalStateException.class,
                pedido::avancarStatus
        );
    }
}