package modelo;

import enumeracao.StatusPedido;

import java.util.ArrayList;
import java.util.List;

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
 * Classe responsável pelo gerenciamento
 * completo do pedido da cafeteria.
 *
 * RESPONSABILIDADES:
 * - Armazenar itens do pedido
 * - Controlar status do pedido
 * - Calcular valor total
 * - Validar regras de negócio
 * - Garantir integridade do sistema
 *
 * REGRAS DE NEGÓCIO:
 * - Não permitir itens nulos
 * - Não permitir alteração após pagamento
 * - Não permitir avanço após finalização
 * - Proteger encapsulamento da lista
 * =========================================================
 */
public class Pedido {

    /**
     * Lista interna de itens do pedido.
     */
    private final List<ItemPedido> itens;

    /**
     * Status atual do pedido.
     */
    private StatusPedido status;

    /**
     * =====================================================
     * CONSTRUTOR
     * =====================================================
     *
     * Inicializa o pedido com:
     * - lista vazia
     * - status pendente
     */
    public Pedido() {

        this.itens = new ArrayList<>();

        this.status = StatusPedido.PENDENTE;
    }

    /**
     * =====================================================
     * ADICIONAR ITEM
     * =====================================================
     *
     * Adiciona um novo item ao pedido.
     *
     * REGRAS:
     * - Item não pode ser nulo
     * - Pedido deve estar pendente
     *
     * @param item Item do pedido
     */
    public void adicionarItem(ItemPedido item) {

        if (item == null) {

            throw new IllegalArgumentException(
                    "Item do pedido não pode ser nulo."
            );
        }

        if (status != StatusPedido.PENDENTE) {

            throw new IllegalStateException(
                    "Não é permitido adicionar itens após processamento do pedido."
            );
        }

        itens.add(item);
    }

    /**
     * =====================================================
     * CALCULAR TOTAL
     * =====================================================
     *
     * Calcula o valor total do pedido
     * somando todos os subtotais.
     *
     * @return Valor total do pedido
     */
    public double calcularTotal() {

        double total = 0;

        for (ItemPedido item : itens) {

            total += item.calcularSubtotal();
        }

        return total;
    }

    /**
     * =====================================================
     * AVANÇAR STATUS
     * =====================================================
     *
     * Realiza a transição de status
     * do pedido conforme fluxo:
     *
     * PENDENTE -> PAGO
     * PAGO -> EM_PREPARO
     * EM_PREPARO -> FINALIZADO
     *
     * Caso já esteja finalizado,
     * lança exceção.
     */
    public void avancarStatus() {

        switch (status) {

            case PENDENTE:

                status = StatusPedido.PAGO;

                break;

            case PAGO:

                status = StatusPedido.EM_PREPARO;

                break;

            case EM_PREPARO:

                status = StatusPedido.FINALIZADO;

                break;

            default:

                throw new IllegalStateException(
                        "Pedido já foi finalizado."
                );
        }
    }

    /**
     * =====================================================
     * RETORNAR STATUS
     * =====================================================
     *
     * Retorna o status atual do pedido.
     *
     * @return Status atual
     */
    public StatusPedido getStatus() {

        return status;
    }

    /**
     * =====================================================
     * ALTERAR STATUS
     * =====================================================
     *
     * Altera manualmente o status do pedido.
     *
     * REGRA:
     * - Status não pode ser nulo
     *
     * @param status Novo status
     */
    public void setStatus(StatusPedido status) {

        if (status == null) {

            throw new IllegalArgumentException(
                    "Status não pode ser nulo."
            );
        }

        this.status = status;
    }

    /**
     * =====================================================
     * RETORNAR ITENS
     * =====================================================
     *
     * Retorna lista protegida de itens.
     *
     * A lista retornada é imutável
     * para proteger encapsulamento.
     *
     * @return Lista imutável de itens
     */
    public List<ItemPedido> getItens() {

        return List.copyOf(itens);
    }
}