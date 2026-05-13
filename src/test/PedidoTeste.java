package test;

import enumeracao.StatusPedido;

import modelo.ItemPedido;
import modelo.Pedido;
import modelo.Produto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import utilitario.FormatadorMoeda;
import utilitario.ValidadorTexto;

import static org.junit.jupiter.api.Assertions.*;

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
 * Classe responsável pelos testes unitários
 * do sistema Café Expresso.
 *
 * OBJETIVOS:
 * - Validar regras de negócio
 * - Garantir funcionamento das entidades
 * - Aplicar conceitos de TDD
 * - Simular cenários reais
 * - Testar fluxos positivos e negativos
 *
 * TECNOLOGIAS:
 * - Java
 * - JUnit 5
 *
 * =========================================================
 */
public class PedidoTeste {

    /**
     * =====================================================
     * TESTE:
     * Deve criar produto corretamente
     * =====================================================
     */
    @Test
    @DisplayName("Deve criar produto corretamente")
    void deveCriarProdutoCorretamente() {

        Produto produto =
                new Produto(1, "Café", 5.0);

        assertEquals(1, produto.getId());

        assertEquals(
                "Café",
                produto.getNome()
        );

        assertEquals(
                5.0,
                produto.getPrecoUnitario()
        );
    }

    /**
     * =====================================================
     * TESTE:
     * Não deve permitir nome vazio
     * =====================================================
     */
    @Test
    @DisplayName("Não deve permitir nome vazio")
    void naoDevePermitirNomeVazio() {

        assertThrows(
                IllegalArgumentException.class,

                () -> new Produto(
                        1,
                        "",
                        5.0
                )
        );
    }

    /**
     * =====================================================
     * TESTE:
     * Não deve permitir preço negativo
     * =====================================================
     */
    @Test
    @DisplayName("Não deve permitir preço negativo")
    void naoDevePermitirPrecoNegativo() {

        assertThrows(
                IllegalArgumentException.class,

                () -> new Produto(
                        1,
                        "Café",
                        -10.0
                )
        );
    }

    /**
     * =====================================================
     * TESTE:
     * Não deve permitir quantidade inválida
     * =====================================================
     */
    @Test
    @DisplayName("Não deve permitir quantidade inválida")
    void naoDevePermitirQuantidadeNegativa() {

        Produto cafe =
                new Produto(1, "Café", 5.0);

        assertThrows(
                IllegalArgumentException.class,

                () -> new ItemPedido(
                        cafe,
                        -1
                )
        );
    }

    /**
     * =====================================================
     * TESTE:
     * Não deve permitir produto nulo
     * =====================================================
     */
    @Test
    @DisplayName("Não deve permitir produto nulo")
    void naoDevePermitirProdutoNulo() {

        assertThrows(
                IllegalArgumentException.class,

                () -> new ItemPedido(
                        null,
                        1
                )
        );
    }

    /**
     * =====================================================
     * TESTE:
     * Deve calcular subtotal corretamente
     * =====================================================
     */
    @Test
    @DisplayName("Deve calcular subtotal corretamente")
    void deveCalcularSubtotal() {

        Produto cafe =
                new Produto(1, "Café", 5.0);

        ItemPedido item =
                new ItemPedido(cafe, 3);

        assertEquals(
                15.0,
                item.calcularSubtotal()
        );
    }

    /**
     * =====================================================
     * TESTE:
     * Deve adicionar item ao pedido
     * =====================================================
     */
    @Test
    @DisplayName("Deve adicionar item ao pedido")
    void deveAdicionarItemAoPedido() {

        Produto cafe =
                new Produto(1, "Café", 5.0);

        ItemPedido item =
                new ItemPedido(cafe, 2);

        Pedido pedido = new Pedido();

        pedido.adicionarItem(item);

        assertEquals(
                1,
                pedido.getItens().size()
        );
    }

    /**
     * =====================================================
     * TESTE:
     * Deve calcular total corretamente
     * =====================================================
     */
    @Test
    @DisplayName("Deve calcular total corretamente")
    void deveCalcularTotalCorretamente() {

        Produto cafe =
                new Produto(1, "Café", 5.0);

        Produto pao =
                new Produto(2, "Pão", 3.0);

        Pedido pedido = new Pedido();

        pedido.adicionarItem(
                new ItemPedido(cafe, 2)
        );

        pedido.adicionarItem(
                new ItemPedido(pao, 3)
        );

        assertEquals(
                19.0,
                pedido.calcularTotal(),
                0.01
        );
    }

    /**
     * =====================================================
     * TESTE:
     * Pedido vazio deve ter total zero
     * =====================================================
     */
    @Test
    @DisplayName("Pedido vazio deve ter total zero")
    void pedidoVazioDeveTerTotalZero() {

        Pedido pedido = new Pedido();

        assertEquals(
                0.0,
                pedido.calcularTotal()
        );
    }

    /**
     * =====================================================
     * TESTE:
     * Deve avançar status corretamente
     * =====================================================
     */
    @Test
    @DisplayName("Deve avançar status corretamente")
    void deveAvancarStatusCorretamente() {

        Pedido pedido = new Pedido();

        assertEquals(
                StatusPedido.PENDENTE,
                pedido.getStatus()
        );

        pedido.avancarStatus();

        assertEquals(
                StatusPedido.PAGO,
                pedido.getStatus()
        );

        pedido.avancarStatus();

        assertEquals(
                StatusPedido.EM_PREPARO,
                pedido.getStatus()
        );

        pedido.avancarStatus();

        assertEquals(
                StatusPedido.FINALIZADO,
                pedido.getStatus()
        );
    }

    /**
     * =====================================================
     * TESTE:
     * Não deve avançar status após finalizado
     * =====================================================
     */
    @Test
    @DisplayName("Não deve avançar status após finalizado")
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

    /**
     * =====================================================
     * TESTE:
     * Não deve adicionar item após pagamento
     * =====================================================
     */
    @Test
    @DisplayName("Não deve adicionar item após pagamento")
    void naoDeveAdicionarItemAposPagamento() {

        Pedido pedido = new Pedido();

        pedido.avancarStatus();

        Produto cafe =
                new Produto(1, "Café", 5.0);

        ItemPedido item =
                new ItemPedido(cafe, 1);

        assertThrows(
                IllegalStateException.class,

                () -> pedido.adicionarItem(item)
        );
    }

    /**
     * =====================================================
     * TESTE:
     * Deve validar texto vazio
     * =====================================================
     */
    @Test
    @DisplayName("Deve validar texto vazio")
    void deveValidarTextoVazio() {

        assertTrue(
                ValidadorTexto.textoEstaVazio("")
        );

        assertTrue(
                ValidadorTexto.textoEstaVazio("   ")
        );
    }

    /**
     * =====================================================
     * TESTE:
     * Deve limpar espaços corretamente
     * =====================================================
     */
    @Test
    @DisplayName("Deve limpar espaços")
    void deveLimparEspacos() {

        String texto =
                ValidadorTexto.limparEspacos(
                        "   Café   "
                );

        assertEquals(
                "Café",
                texto
        );
    }

    /**
     * =====================================================
     * TESTE:
     * Deve formatar moeda corretamente
     * =====================================================
     */
    @Test
    @DisplayName("Deve formatar moeda")
    void deveFormatarMoeda() {

        String valor =
                FormatadorMoeda.formatar(15.5);

        assertNotNull(valor);

        assertTrue(
                valor.contains("15")
        );
    }

    /**
     * =====================================================
     * TESTE TDD:
     * Não deve permitir ID inválido
     * =====================================================
     */
    @Test
    @DisplayName("Não deve permitir ID inválido")
    void naoDevePermitirIdInvalido() {

        assertThrows(
                IllegalArgumentException.class,

                () -> new Produto(
                        0,
                        "Café",
                        5.0
                )
        );
    }

    /**
     * =====================================================
     * TESTE TDD:
     * Lista retornada deve ser protegida
     * =====================================================
     */
    @Test
    @DisplayName("Lista retornada deve ser protegida")
    void listaDeItensDeveSerProtegida() {

        Pedido pedido = new Pedido();

        Produto cafe =
                new Produto(1, "Café", 5.0);

        pedido.adicionarItem(
                new ItemPedido(cafe, 1)
        );

        assertThrows(
                UnsupportedOperationException.class,

                () -> pedido.getItens().clear()
        );
    }
}

