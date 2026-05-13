package test;

import enumeracao.StatusPedido;
import modelo.ItemPedido;
import modelo.Pedido;
import modelo.Produto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import servico.PixService;
import servico.ServicoPagamento;

import utilitario.ConsoleCores;
import utilitario.FormatadorMoeda;
import utilitario.ValidadorTexto;

import static org.junit.jupiter.api.Assertions.*;

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
 * Classe responsável pelos testes unitários
 * do sistema Café Expresso.
 *
 * OBJETIVOS:
 * - Validar regras de negócio
 * - Garantir funcionamento das entidades
 * - Aplicar TDD
 * - Validar refatoração
 * - Testar fluxo completo do sistema
 *
 * TECNOLOGIAS:
 * - Java 26
 * - JUnit 5
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
                new Produto(
                        1,
                        "Café Expresso",
                        5.50
                );

        assertEquals(
                1,
                produto.getId()
        );

        assertEquals(
                "Café Expresso",
                produto.getNome()
        );

        assertEquals(
                5.50,
                produto.getPreco()
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
                        "Cafe",
                        -5.0
                )
        );
    }

    /**
     * =====================================================
     * TESTE:
     * Deve calcular subtotal
     * =====================================================
     */
    @Test
    @DisplayName("Deve calcular subtotal")
    void deveCalcularSubtotal() {

        Produto cafe =
                new Produto(
                        1,
                        "Cafe",
                        5.0
                );

        ItemPedido item =
                new ItemPedido(
                        cafe,
                        2
                );

        assertEquals(
                10.0,
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

        Pedido pedido = new Pedido();

        Produto cafe =
                new Produto(
                        1,
                        "Cafe",
                        5.0
                );

        pedido.adicionarItem(
                new ItemPedido(cafe, 1)
        );

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

        Pedido pedido = new Pedido();

        Produto cafe =
                new Produto(
                        1,
                        "Cafe",
                        5.0
                );

        Produto pao =
                new Produto(
                        2,
                        "Pao",
                        3.0
                );

        pedido.adicionarItem(
                new ItemPedido(cafe, 2)
        );

        pedido.adicionarItem(
                new ItemPedido(pao, 3)
        );

        assertEquals(
                19.0,
                pedido.calcularTotal()
        );
    }

    /**
     * =====================================================
     * TESTE:
     * Pedido deve iniciar pendente
     * =====================================================
     */
    @Test
    @DisplayName("Pedido deve iniciar pendente")
    void pedidoDeveIniciarPendente() {

        Pedido pedido = new Pedido();

        assertEquals(
                StatusPedido.PENDENTE,
                pedido.getStatus()
        );
    }

    /**
     * =====================================================
     * TESTE:
     * Deve avançar status
     * =====================================================
     */
    @Test
    @DisplayName("Deve avançar status")
    void deveAvancarStatus() {

        Pedido pedido = new Pedido();

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
     * Não deve avançar após finalizado
     * =====================================================
     */
    @Test
    @DisplayName("Não deve avançar após finalizado")
    void naoDeveAvancarAposFinalizado() {

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
     * Não deve permitir item nulo
     * =====================================================
     */
    @Test
    @DisplayName("Não deve permitir item nulo")
    void naoDevePermitirItemNulo() {

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
     * Não deve permitir quantidade inválida
     * =====================================================
     */
    @Test
    @DisplayName("Não deve permitir quantidade inválida")
    void naoDevePermitirQuantidadeInvalida() {

        Produto cafe =
                new Produto(
                        1,
                        "Cafe",
                        5.0
                );

        assertThrows(
                IllegalArgumentException.class,

                () -> new ItemPedido(
                        cafe,
                        0
                )
        );
    }

    /**
     * =====================================================
     * TESTE:
     * Deve formatar moeda
     * =====================================================
     */
    @Test
    @DisplayName("Deve formatar moeda")
    void deveFormatarMoeda() {

        String valor =
                FormatadorMoeda.formatar(15.5);

        assertTrue(
                valor.contains("15")
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
                ValidadorTexto.textoEstaVazio(" ")
        );
    }

    /**
     * =====================================================
     * TESTE:
     * Deve limpar espaços
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
     * Deve gerar pagamento
     * =====================================================
     */
    @Test
    @DisplayName("Deve realizar pagamento")
    void deveRealizarPagamento() {

        Pedido pedido = new Pedido();

        Produto cafe =
                new Produto(
                        1,
                        "Cafe",
                        10.0
                );

        pedido.adicionarItem(
                new ItemPedido(cafe, 1)
        );

        ServicoPagamento pagamento =
                new ServicoPagamento();

        String retorno =
                pagamento.realizarPagamento(pedido);

        assertNotNull(retorno);

        assertTrue(
                retorno.contains("Pagamento")
        );
    }

    /**
     * =====================================================
     * TESTE:
     * Deve gerar PIX
     * =====================================================
     */
    @Test
    @DisplayName("Deve gerar PIX")
    void deveGerarPix() {

        Pedido pedido = new Pedido();

        Produto cafe =
                new Produto(
                        1,
                        "Cafe",
                        5.0
                );

        pedido.adicionarItem(
                new ItemPedido(cafe, 2)
        );

        assertDoesNotThrow(
                () -> PixService.gerarPix(pedido)
        );
    }

    /**
     * =====================================================
     * TESTE:
     * Lista deve ser protegida
     * =====================================================
     */
    @Test
    @DisplayName("Lista deve ser protegida")
    void listaDeveSerProtegida() {

        Pedido pedido = new Pedido();

        Produto cafe =
                new Produto(
                        1,
                        "Cafe",
                        5.0
                );

        pedido.adicionarItem(
                new ItemPedido(cafe, 1)
        );

        assertThrows(
                UnsupportedOperationException.class,

                () -> pedido.getItens().clear()
        );
    }

    /**
     * =====================================================
     * TESTE:
     * Console cores deve funcionar
     * =====================================================
     */
    @Test
    @DisplayName("Console cores deve funcionar")
    void consoleCoresDeveFuncionar() {

        String texto =
                ConsoleCores.cor(
                        "TESTE",
                        ConsoleCores.VERDE
                );

        assertNotNull(texto);

        assertTrue(
                texto.contains("TESTE")
        );
    }
}