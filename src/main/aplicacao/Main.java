package aplicacao;

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
 * Sistema de gerenciamento de pedidos
 * desenvolvido em Java utilizando
 * interface textual estilo MS-DOS.
 * =========================================================
 */

import java.util.Scanner;

import modelo.ItemPedido;
import modelo.Pedido;
import modelo.Produto;

import enumeracao.StatusPedido;

public class Main {

    /**
     * Scanner principal.
     */
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Pedido atual.
     */
    private static Pedido pedido = new Pedido();

    /**
     * =====================================================
     * MÉTODO PRINCIPAL
     * =====================================================
     */
    public static void main(String[] args) {

        iniciarSistema();
    }

    /**
     * =====================================================
     * INICIAR SISTEMA
     * =====================================================
     */
    public static void iniciarSistema() {

        int opcao;

        do {

            limparTela();

            exibirCabecalho();

            System.out.println("  [1] ADICIONAR PRODUTO");
            System.out.println("  [2] VISUALIZAR PEDIDO");
            System.out.println("  [3] FINALIZAR PEDIDO");
            System.out.println("  [0] SAIR");

            desenharLinha();

            System.out.print("  ESCOLHA UMA OPCAO: ");

            opcao = lerInteiro();

            switch (opcao) {

                case 1:
                    menuProdutos();
                    break;

                case 2:
                    visualizarPedido();
                    break;

                case 3:
                    finalizarPedido();
                    break;

                case 0:
                    encerrarSistema();
                    break;

                default:
                    System.out.println("\n  OPCAO INVALIDA!");
                    pausarSistema();
            }

        } while (opcao != 0);
    }

    /**
     * =====================================================
     * CABEÇALHO PRINCIPAL
     * =====================================================
     */
    public static void exibirCabecalho() {

        desenharLinha();

        System.out.println("||                                             ||");
        System.out.println("||              CAFE EXPRESSO                  ||");
        System.out.println("||                                             ||");
        System.out.println("||      SISTEMA INTELIGENTE DE PEDIDOS         ||");
        System.out.println("||                                             ||");

        desenharLinha();
    }

    /**
     * =====================================================
     * MENU DE PRODUTOS
     * =====================================================
     */
    public static void menuProdutos() {

        int opcao;

        do {

            limparTela();

            desenharLinha();

            System.out.println("||                CARDAPIO                    ||");

            desenharLinha();

            System.out.println("  [1] Cafe Expresso ............ R$ 5.50");
            System.out.println("  [2] Cappuccino ............... R$ 8.00");
            System.out.println("  [3] Chocolate Quente ......... R$ 9.50");
            System.out.println("  [0] Voltar");

            desenharLinha();

            System.out.print("  ESCOLHA UM PRODUTO: ");

            opcao = lerInteiro();

            switch (opcao) {

                case 1:
                    adicionarProduto(1, "Cafe Expresso", 5.50);
                    break;

                case 2:
                    adicionarProduto(2, "Cappuccino", 8.00);
                    break;

                case 3:
                    adicionarProduto(3, "Chocolate Quente", 9.50);
                    break;

                case 0:
                    break;

                default:
                    System.out.println("\n  PRODUTO INVALIDO!");
                    pausarSistema();
            }

        } while (opcao != 0);
    }

    /**
     * =====================================================
     * ADICIONAR PRODUTO
     * =====================================================
     */
    public static void adicionarProduto(
            int id,
            String nome,
            double preco
    ) {

        Produto produto = new Produto(id, nome, preco);

        ItemPedido item = new ItemPedido(produto, 1);

        pedido.adicionarItem(item);

        System.out.println("\n  PRODUTO ADICIONADO COM SUCESSO!");

        pausarSistema();
    }

    /**
     * =====================================================
     * VISUALIZAR PEDIDO
     * =====================================================
     */
    public static void visualizarPedido() {

        limparTela();

        desenharLinha();

        System.out.println("||              PEDIDO ATUAL                  ||");

        desenharLinha();

        if (pedido.getItens().isEmpty()) {

            System.out.println("\n  NENHUM ITEM NO PEDIDO.");

            pausarSistema();

            return;
        }

        for (ItemPedido item : pedido.getItens()) {

            System.out.println(
                    "  "
                            + item.getProduto().getNome()
                            + " | QTD: "
                            + item.getQuantidade()
                            + " | R$ "
                            + item.getProduto().getPreco()
            );
        }

        desenharLinha();

        System.out.println("  TOTAL: R$ " + pedido.calcularTotal());

        desenharLinha();

        pausarSistema();
    }

    /**
     * =====================================================
     * FINALIZAR PEDIDO
     * =====================================================
     */
    public static void finalizarPedido() {

        limparTela();

        pedido.setStatus(StatusPedido.FINALIZADO);

        desenharLinha();

        System.out.println("||         PEDIDO FINALIZADO!                 ||");

        desenharLinha();

        System.out.println("  STATUS: " + pedido.getStatus());
        System.out.println("  TOTAL : R$ " + pedido.calcularTotal());

        desenharLinha();

        pausarSistema();
    }

    /**
     * =====================================================
     * ENCERRAR SISTEMA
     * =====================================================
     */
    public static void encerrarSistema() {

        limparTela();

        desenharLinha();

        System.out.println("||                                             ||");
        System.out.println("||        SISTEMA ENCERRADO COM SUCESSO        ||");
        System.out.println("||                                             ||");

        desenharLinha();
    }

    /**
     * =====================================================
     * DESENHAR LINHA
     * =====================================================
     */
    public static void desenharLinha() {

        System.out.println("=================================================");
    }

    /**
     * =====================================================
     * PAUSAR SISTEMA
     * =====================================================
     */
    public static void pausarSistema() {

        System.out.println("\n  PRESSIONE ENTER PARA CONTINUAR...");
        scanner.nextLine();
    }

    /**
     * =====================================================
     * LIMPAR TELA
     * =====================================================
     */
    public static void limparTela() {

        for (int i = 0; i < 30; i++) {

            System.out.println();
        }
    }

    /**
     * =====================================================
     * LER INTEIRO
     * =====================================================
     */
    public static int lerInteiro() {

        int valor = scanner.nextInt();
        scanner.nextLine();

        return valor;
    }
}