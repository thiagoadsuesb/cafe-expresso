package test;

<<<<<<< HEAD
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
=======
import main.*;
import org.junit.jupiter.api.Test;
>>>>>>> 7bfb9e5940ae7a1f4d37d0608fe6a55abeeb8e30

import static org.junit.jupiter.api.Assertions.*;

/**
<<<<<<< HEAD
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
=======
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
>>>>>>> 7bfb9e5940ae7a1f4d37d0608fe6a55abeeb8e30

        assertEquals(1, pedido.getItens().size());
    }

    @Test
<<<<<<< HEAD
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
=======
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
>>>>>>> 7bfb9e5940ae7a1f4d37d0608fe6a55abeeb8e30

        pedido.avancarStatus();
        assertEquals(StatusPedido.PAGO, pedido.getStatus());

        pedido.avancarStatus();
        assertEquals(StatusPedido.EM_PREPARO, pedido.getStatus());

        pedido.avancarStatus();
        assertEquals(StatusPedido.FINALIZADO, pedido.getStatus());
    }
<<<<<<< HEAD

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
=======
}
>>>>>>> 7bfb9e5940ae7a1f4d37d0608fe6a55abeeb8e30
