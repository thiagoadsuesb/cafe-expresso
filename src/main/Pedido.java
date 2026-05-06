package main; /**
 * Universidade Estadual do Sudoeste da Bahia (UESB)
 * Curso: Tecnologia em Análise e Desenvolvimento de Sistemas
 * Disciplina: Engenharia de Software Avançada
 * Professor: Lucas Santos de Oliveira
 * Autor: Thiago Ferreira Prates Neves
 *
 * Projeto – Café Expresso
 *
 * Responsabilidade:
 * Controlar itens do pedido, cálculo total e fluxo de estados
 * do processo de atendimento.
 */

import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private List<ItemPedido> itens = new ArrayList<>();
    private StatusPedido status = StatusPedido.PENDENTE;

    // =========================
    // REGRA 1: ADICIONAR ITEM
    // =========================
    public void adicionarItem(ItemPedido item) {

        if (status != StatusPedido.PENDENTE) {
            throw new IllegalStateException("Não é possível adicionar itens após pagamento.");
        }

        itens.add(item);
    }

    // =========================
    // REGRA 2: CÁLCULO TOTAL
    // =========================
    public double calcularTotal() {
        double total = 0;

        for (ItemPedido item : itens) {
            total += item.calcularSubtotal();
        }

        return total;
    }

    // =========================
    // REGRA 3: PAGAMENTO
    // =========================
    public void confirmarPagamento() {

        if (itens.isEmpty()) {
            throw new IllegalStateException("Pedido vazio não pode ser pago.");
        }

        if (status != StatusPedido.PENDENTE) {
            throw new IllegalStateException("Pagamento já foi realizado ou inválido.");
        }

        status = StatusPedido.PAGO;
    }

    // =========================
    // REGRA 4: PREPARO
    // =========================
    public void enviarParaPreparo() {

        if (status != StatusPedido.PAGO) {
            throw new IllegalStateException("Pedido deve estar pago para ir ao preparo.");
        }

        status = StatusPedido.EM_PREPARO;
    }

    // =========================
    // REGRA 5: FINALIZAÇÃO
    // =========================
    public void finalizarPedido() {

        if (status != StatusPedido.EM_PREPARO) {
            throw new IllegalStateException("Pedido só pode ser finalizado após preparo.");
        }

        status = StatusPedido.FINALIZADO;
    }

    // =========================
    // STATUS
    // =========================
    public StatusPedido getStatus() {
        return status;
    }

    public List<ItemPedido> getItens() {
        return new ArrayList<>(itens);
    }

    public void avancarStatus() {
    }
}