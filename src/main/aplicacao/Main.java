package aplicacao;

import modelo.*;
import enumeracao.StatusPedido;
import servico.*;
import test.DetalheTeste;
import utilitario.ConsoleCores;
import utilitario.FormatadorMoeda;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * =========================================================
 * UNIVERSIDADE ESTADUAL DO SUDOESTE DA BAHIA (UESB)
 * CURSO: ADS
 * DISCIPLINA: ENGENHARIA DE SOFTWARE AVANÇADA
 * PROFESSOR: LUCAS SANTOS DE OLIVEIRA
 * =========================================================
 *
 * SISTEMA: CAFÉ EXPRESSO
 * FLUXO: PEDIDO → CARDÁPIO → PIX → COZINHA → CAIXA
 * =========================================================
 */
public class Main {

    private static final Scanner sc = new Scanner(System.in);

    private static Pedido pedido = new Pedido();

    private static final List<Produto> cardapio = new ArrayList<>();

    public static void main(String[] args) {

        carregarCardapio();

        menu();
    }

    // ================= MENU =================
    private static void menu() {

        int op;

        do {
            System.out.println("\n====================================");
            System.out.println(" CAFÉ EXPRESSO SYSTEM - UESB");
            System.out.println("====================================");

            System.out.println("[1] NOVO PEDIDO");
            System.out.println("[2] CARDÁPIO (ADICIONAR ITEM)");
            System.out.println("[3] PIX PAGAMENTO");
            System.out.println("[4] COZINHA");
            System.out.println("[5] CAIXA");
            System.out.println("[6] STATUS");
            System.out.println("[7] TESTES");
            System.out.println("[0] SAIR");

            System.out.print("\nESCOLHA: ");
            op = lerInt();

            switch (op) {

                case 1 -> novoPedido();
                case 2 -> cardapio();
                case 3 -> pix();
                case 4 -> cozinha();
                case 5 -> caixa();
                case 6 -> status();
                case 7 -> DetalheTeste.executarRelatorioTeste();
                case 0 -> System.out.println("Encerrando sistema...");

                default -> System.out.println("Opção inválida!");
            }

        } while (op != 0);
    }

    // ================= PEDIDO =================
    private static void novoPedido() {

        pedido = new Pedido();
        pedido.setStatus(StatusPedido.PENDENTE);

        System.out.println(ConsoleCores.cor("✔ Novo pedido criado!", ConsoleCores.VERDE));
    }

    // ================= CARDÁPIO =================
    private static void cardapio() {

        System.out.println("\n===== CARDÁPIO =====");

        for (Produto p : cardapio) {
            System.out.println(p.getId() + " - " + p.getNome());
        }

        System.out.print("ID produto: ");
        int id = lerInt();

        System.out.print("Quantidade: ");
        int qtd = lerInt();

        Produto escolhido = buscar(id);

        if (escolhido == null) {
            System.out.println("Produto inválido!");
            return;
        }

        pedido.adicionarItem(new ItemPedido(escolhido, qtd));

        System.out.println(ConsoleCores.cor("✔ Item adicionado!", ConsoleCores.AZUL));
    }

    // ================= PIX =================
    private static void pix() {

        if (pedido.getItens().isEmpty()) {
            System.out.println(ConsoleCores.cor("❌ Pedido vazio!", ConsoleCores.VERMELHO));
            return;
        }

        System.out.println("\n===== PIX =====");

        PixService.gerarPix(pedido);

        pedido.setStatus(StatusPedido.PAGO);

        ServicoCaixa.registrar(pedido.calcularTotal());

        System.out.println(ConsoleCores.cor("✔ Pagamento confirmado!", ConsoleCores.VERDE));
    }

    // ================= COZINHA =================
    private static void cozinha() {

        if (pedido.getStatus() != StatusPedido.PAGO) {
            System.out.println(ConsoleCores.cor("❌ Precisa pagar antes!", ConsoleCores.VERMELHO));
            return;
        }

        ServicoCozinha cozinha = new ServicoCozinha();

        cozinha.preparar(pedido);
    }

    // ================= CAIXA =================
    private static void caixa() {

        ServicoCaixa.relatorio();
    }

    // ================= STATUS =================
    private static void status() {

        System.out.println("\nSTATUS: " + pedido.getStatus());

        System.out.println("TOTAL: " +
                FormatadorMoeda.formatar(pedido.calcularTotal()));
    }

    // ================= BUSCA PRODUTO =================
    private static Produto buscar(int id) {

        for (Produto p : cardapio) {
            if (p.getId() == id) return p;
        }
        return null;
    }

    // ================= CARDÁPIO FIXO =================
    private static void carregarCardapio() {

        cardapio.add(new Produto(1, "Cafe Expresso", 5.50));
        cardapio.add(new Produto(2, "Cappuccino", 8.00));
        cardapio.add(new Produto(3, "Pao de Queijo", 4.00));
        cardapio.add(new Produto(4, "Quiche de Frango", 12.00));
    }

    // ================= SCANNER (CORRIGIDO - ISSO RESOLVE TRAVAMENTO) =================
    private static int lerInt() {

        while (!sc.hasNextInt()) {
            sc.nextLine();
            System.out.println("Digite um número válido!");
        }

        int v = sc.nextInt();
        sc.nextLine(); // limpa buffer

        return v;
    }
}