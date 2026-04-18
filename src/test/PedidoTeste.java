import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Universidade Estadual do Sudoeste da Bahia (UESB)
 * Curso: Tecnologia em Análise e Desenvolvimento de Sistemas
 * Disciplina: Engenharia de Software Avançada
 * Professor: Lucas Santos de Oliveira
 * Autor: Thiago Ferreira Prates Neves
 *
 * Projeto – Café Expresso
 *
 * Descrição:
 * Testes unitários aplicando TDD para validação das regras de negócio
 * do sistema de pedidos da cafeteria.
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

        pedido.adicionarItem(new ItemPedido(cafe, 2)); // 10
        pedido.adicionarItem(new ItemPedido(pao, 3));  // 9

        assertEquals(19.0, pedido.calcularTotal(), 0.01);
    }

    @Test
    void naoDevePermitirProdutoNulo() {

        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> new ItemPedido(null, 1)
        );

        assertTrue(exception.getMessage().toLowerCase().contains("produto"));
    }

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