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
 * Classe de testes unitários do sistema Pedido.
 * Aplica conceito de TDD para validar regras de negócio.
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

        ItemPedido item1 = new ItemPedido(cafe, 2); // 10
        ItemPedido item2 = new ItemPedido(pao, 3);  // 9

        Pedido pedido = new Pedido();
        pedido.adicionarItem(item1);
        pedido.adicionarItem(item2);

        assertEquals(19.0, pedido.calcularTotal());
    }

    @Test
    void naoDevePermitirProdutoNulo() {

        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> new ItemPedido(null, 1)
        );

        assertTrue(exception.getMessage().contains("Produto"));
    }

    @Test
    void deveAvancarStatusDoPedido() {

        Pedido pedido = new Pedido();

        assertEquals(StatusPedido.PENDENTE, pedido.getStatus());

        pedido.avancarStatus();
        assertEquals(StatusPedido.PAGO, pedido.getStatus());

        pedido.avancarStatus();
        assertEquals(StatusPedido.EM_PREPARO, pedido.getStatus());
    }
}