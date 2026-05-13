package aplicacao;

import enumeracao.StatusPedido;
import modelo.ItemPedido;
import modelo.Pedido;
import modelo.Produto;
import servico.PixService;
import servico.ServicoCaixa;
import servico.ServicoCozinha;
import test.DetalheTeste;
import utilitario.ConsoleCores;
import utilitario.FormatadorMoeda;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
 * Sistema de gerenciamento de cafeteria
 * com controle de pedidos, cozinha,
 * pagamento PIX e caixa diário.
 * =========================================================
 */
public class Main {

    private static final Scanner scanner =
            new Scanner(System.in);

    private static Pedido pedido =
            new Pedido();

    private static final List<Produto> cardapio =
            new ArrayList<>();

    public static void main(String[] args) {

        carregarCardapio();

        menu();
    }

    /**
     * ================= MENU =================
     */
    private static void menu() {

        int opcao;

        do {

            limparTela();

            cabecalho();

            System.out.println(ConsoleCores.cor(
                    "[1] NOVO PEDIDO",
                    ConsoleCores.VERDE));

            System.out.println("[2] CARDÁPIO");
            System.out.println("[3] FINALIZAR PEDIDO");
            System.out.println("[4] STATUS");
            System.out.println("[5] COZINHA");
            System.out.println("[6] PIX");
            System.out.println("[7] CAIXA");
            System.out.println("[8] SOBRE");
            System.out.println("[9] TESTES");
            System.out.println("[0] SAIR");

            linha();

            System.out.print("ESCOLHA: ");

            opcao = lerInt();

            switch (opcao) {

                case 1 -> novoPedido();

                case 2 -> cardapio();

                case 3 -> finalizarPedido();

                case 4 -> status();

                case 5 -> cozinha();

                case 6 -> pix();

                case 7 -> caixa();

                case 8 -> Sobre.exibir();

                case 9 -> DetalheTeste.executarRelatorioTeste();

                case 0 -> System.out.println(
                        "Sistema encerrado.");

                default -> System.out.println(
                        "Opção inválida.");
            }

            pausar();

        } while (opcao != 0);
    }

    /**
     * ================= PEDIDO =================
     */
    private static void novoPedido() {

        pedido = new Pedido();

        pedido.setStatus(StatusPedido.PENDENTE);

        System.out.println(ConsoleCores.cor(
                "Pedido criado com sucesso!",
                ConsoleCores.VERDE));
    }

    /**
     * ================= CARDÁPIO =================
     */
    private static void cardapio() {

        System.out.println("\n===== CARDÁPIO =====");

        for (Produto p : cardapio) {

            System.out.println(
                    p.getId()
                            + " - "
                            + p.getNome()
                            + " - "
                            + FormatadorMoeda.formatar(
                            p.getPreco()
                    )
            );
        }

        System.out.println(
                "\nDigite 0 para sair.");

        int opcao;

        do {

            System.out.print("Produto: ");

            opcao = lerInt();

            if (opcao == 0) {
                break;
            }

            Produto produto =
                    buscarProduto(opcao);

            if (produto != null) {

                pedido.adicionarItem(
                        new ItemPedido(produto, 1)
                );

                System.out.println(
                        "Item adicionado!");
            }

        } while (true);
    }

    /**
     * ================= BUSCAR PRODUTO =================
     */
    private static Produto buscarProduto(int id) {

        for (Produto p : cardapio) {

            if (p.getId() == id) {
                return p;
            }
        }

        return null;
    }

    /**
     * ================= FINALIZAR =================
     */
    private static void finalizarPedido() {

        pedido.setStatus(
                StatusPedido.FINALIZADO);

        System.out.println(
                "\nPedido finalizado!");
    }

    /**
     * ================= STATUS =================
     */
    private static void status() {

        System.out.println(
                "\nSTATUS: "
                        + pedido.getStatus());

        System.out.println(
                "TOTAL: "
                        + FormatadorMoeda.formatar(
                        pedido.calcularTotal()
                ));
    }

    /**
     * ================= COZINHA =================
     */
    private static void cozinha() {

        ServicoCozinha cozinha =
                new ServicoCozinha();

        cozinha.preparar(pedido);
    }

    /**
     * ================= PIX =================
     */
    private static void pix() {

        if (pedido.getItens().isEmpty()) {

            System.out.println(ConsoleCores.cor(
                    "Pedido vazio!",
                    ConsoleCores.VERMELHO));

            return;
        }

        PixService.gerarPix(pedido);

        pedido.setStatus(StatusPedido.PAGO);
    }

    /**
     * ================= CAIXA =================
     */
    private static void caixa() {

        ServicoCaixa.registrar(
                pedido.calcularTotal());

        ServicoCaixa.relatorio();
    }

    /**
     * ================= CARDÁPIO FIXO =================
     */
    private static void carregarCardapio() {

        cardapio.add(
                new Produto(
                        1,
                        "Cafe Expresso",
                        5.50
                )
        );

        cardapio.add(
                new Produto(
                        2,
                        "Cappuccino",
                        8.00
                )
        );

        cardapio.add(
                new Produto(
                        3,
                        "Pao de Queijo",
                        4.00
                )
        );

        cardapio.add(
                new Produto(
                        4,
                        "Quiche de Frango",
                        12.00
                )
        );
    }

    /**
     * ================= UI =================
     */
    private static void cabecalho() {

        System.out.println("""
                ====================================
                   CAFÉ EXPRESSO SYSTEM - UESB
                Engenharia de Software Avançada
                ====================================
                """);
    }

    private static void linha() {

        System.out.println(
                "====================================");
    }

    private static void limparTela() {

        for (int i = 0; i < 10; i++) {

            System.out.println();
        }
    }

    private static void pausar() {

        System.out.println(
                "\nENTER PARA CONTINUAR...");

        scanner.nextLine();
    }

    private static int lerInt() {

        int valor = scanner.nextInt();

        scanner.nextLine();

        return valor;
    }
}