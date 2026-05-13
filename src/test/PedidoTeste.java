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

    @Test
    @DisplayName("Deve criar produto corretamente")
    void deveCriarProdutoCorretamente() {

        Produto produto = new Produto(1, "Café", 5.50);

        assertEquals(1, produto.getId());
        assertEquals("Café", produto.getNome());
        assertEquals(5.50, produto.getPreco());
    }

    @Test
    @DisplayName("Deve calcular subtotal do item")
    void deveCalcularSubtotalDoItem() {

        Produto cafe = new Produto(1, "Cafe", 5.0);
        ItemPedido item = new ItemPedido(cafe, 2);

        // CORRETO AGORA (não existe calcularSubtotal)
        assertEquals(10.0, item.getSubtotal());
    }

    @Test
    @DisplayName("Deve adicionar item ao pedido")
    void deveAdicionarItemAoPedido() {

        Pedido pedido = new Pedido();
        pedido.adicionarItem(new ItemPedido(new Produto(1, "Cafe", 5.0), 1));

        assertEquals(1, pedido.getItens().size());
    }

    @Test
    @DisplayName("Deve calcular total corretamente")
    void deveCalcularTotalCorretamente() {

        Pedido pedido = new Pedido();

        pedido.adicionarItem(new ItemPedido(new Produto(1, "Cafe", 5.0), 2));
        pedido.adicionarItem(new ItemPedido(new Produto(2, "Pao", 3.0), 3));

        assertEquals(19.0, pedido.calcularTotal());
    }

    @Test
    @DisplayName("Pedido inicia pendente")
    void pedidoDeveIniciarPendente() {

        Pedido pedido = new Pedido();

        assertEquals(StatusPedido.PENDENTE, pedido.getStatus());
    }

    @Test
    @DisplayName("Deve avançar status corretamente")
    void deveAvancarStatus() {

        Pedido pedido = new Pedido();

        pedido.avancarStatus();
        assertEquals(StatusPedido.PAGO, pedido.getStatus());

        pedido.avancarStatus();
        assertEquals(StatusPedido.EM_PREPARO, pedido.getStatus());

        pedido.avancarStatus();
        assertEquals(StatusPedido.FINALIZADO, pedido.getStatus());
    }

    @Test
    @DisplayName("Não deve avançar após finalizado")
    void naoDeveAvancarAposFinalizado() {

        Pedido pedido = new Pedido();

        pedido.avancarStatus();
        pedido.avancarStatus();
        pedido.avancarStatus();

        assertThrows(IllegalStateException.class, pedido::avancarStatus);
    }

    @Test
    @DisplayName("Não deve permitir item nulo")
    void naoDevePermitirItemNulo() {

        assertThrows(IllegalArgumentException.class,
                () -> new ItemPedido(null, 1));
    }

    @Test
    @DisplayName("Não deve permitir quantidade inválida")
    void naoDevePermitirQuantidadeInvalida() {

        Produto cafe = new Produto(1, "Cafe", 5.0);

        assertThrows(IllegalArgumentException.class,
                () -> new ItemPedido(cafe, 0));
    }

    @Test
    @DisplayName("Deve formatar moeda")
    void deveFormatarMoeda() {

        String valor = FormatadorMoeda.formatar(15.5);

        assertNotNull(valor);
        assertTrue(valor.contains("15"));
    }

    @Test
    @DisplayName("Deve validar texto vazio")
    void deveValidarTextoVazio() {

        assertTrue(ValidadorTexto.textoEstaVazio(""));
        assertTrue(ValidadorTexto.textoEstaVazio(" "));
    }

    @Test
    @DisplayName("Deve limpar espaços")
    void deveLimparEspacos() {

        String texto = ValidadorTexto.limparEspacos("  Café  ");

        assertEquals("Café", texto);
    }

    @Test
    @DisplayName("Deve gerar PIX sem erro")
    void deveGerarPix() {

        Pedido pedido = new Pedido();
        pedido.adicionarItem(new ItemPedido(new Produto(1, "Cafe", 5.0), 2));

        assertDoesNotThrow(() -> PixService.gerarPix(pedido));
    }

    @Test
    @DisplayName("Lista deve ser protegida")
    void listaDeveSerProtegida() {

        Pedido pedido = new Pedido();
        pedido.adicionarItem(new ItemPedido(new Produto(1, "Cafe", 5.0), 1));

        assertThrows(UnsupportedOperationException.class,
                () -> pedido.getItens().clear());
    }

    @Test
    @DisplayName("Console cores funciona")
    void consoleCoresFunciona() {

        String texto = ConsoleCores.cor("TESTE", ConsoleCores.VERDE);

        assertNotNull(texto);
        assertTrue(texto.contains("TESTE"));
    }

    @Test
    @DisplayName("Deve realizar pagamento")
    void deveRealizarPagamento() {

        Pedido pedido = new Pedido();
        pedido.adicionarItem(new ItemPedido(new Produto(1, "Cafe", 10.0), 1));

        ServicoPagamento pagamento = new ServicoPagamento();

        String retorno = pagamento.realizarPagamento(pedido);

        assertNotNull(retorno);
        assertTrue(retorno.contains("Pagamento"));
    }
}
