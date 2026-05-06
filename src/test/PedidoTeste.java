package test;

import main.ItemPedido;
import main.Pedido;
import main.Produto;
import main.StatusPedido;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Universidade Estadual do Sudoeste da Bahia (UESB)
 * Curso: Tecnologia em Análise e Desenvolvimento de Sistemas
 * Disciplina: Engenharia de Software Avançada
 * Professor: Lucas Santos de Oliveira
 * Autor: Thiago Ferreira Prates Neves
 * <p>
 * Projeto – Café Expresso
 *
 * Classe de testes unitários do sistema Pedido.
 * Aplicação de TDD para validação das regras de negócio.
 */
public class PedidoTeste {

    /**
     * Testa se um item é corretamente adicionado ao pedido.
     * Valida a inserção de itens na estrutura de dados do pedido.
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
     * Testa o cálculo correto do valor total do pedido.
     * Garante que a soma dos subtotais dos itens está correta.
     */
    @Test
    void deveCalcularTotalCorretamente() {
        Produto cafe = new Produto("Café", 5.0);
        Produto pao = new Produto("Pão", 3.0);

        Pedido pedido = new Pedido();

        pedido.adicionarItem(new ItemPedido(cafe, 2)); // 10.0
        pedido.adicionarItem(new ItemPedido(pao, 3));  // 9.0

        assertEquals(19.0, pedido.calcularTotal(), 0.01);
    }

    /**
     * Testa a validação de regra de negócio para Produto nulo.
     * Garante que o sistema não permite criação de item inválido.
     */
    @Test
    /**void naoDevePermitirProdutoNulo() {
        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> new ItemPedido(null, 1)
        );

        assertTrue(exception.getMessage().toLowerCase().contains("produto"));
    }

    /**
     * Testa a sequência correta de mudança de status do pedido.
     * Valida o fluxo: PENDENTE → PAGO → EM_PREPARO → FINALIZADO.
     */
    @Test
    void deveSeguirFluxoCorretoDeStatus() {
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
     * Testa se o sistema impede avanço inválido de status.
     * Garante que regras de transição não podem ser violadas.
     */
    @Test
    void naoDevePermitirPularStatus() {
        Pedido pedido = new Pedido();

        Exception exception = assertThrows(
                IllegalStateException.class,
                () -> {
                    pedido.avancarStatus();
                    pedido.avancarStatus();
                    pedido.avancarStatus();
                    pedido.avancarStatus(); // tentativa inválida
                }
        );

        assertNotNull(exception);
    }
}