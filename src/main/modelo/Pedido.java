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

    private List<ItemPedido> itens = new ArrayList<>();
    private StatusPedido status = StatusPedido.PENDENTE;

    public void adicionarItem(ItemPedido item) {
        itens.add(item);
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public double calcularTotal() {
        return itens.stream()
                .mapToDouble(ItemPedido::getSubtotal)
                .sum();
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public void avancarStatus() {

        switch (status) {
            case PENDENTE -> status = StatusPedido.PAGO;
            case PAGO -> status = StatusPedido.EM_PREPARO;
            case EM_PREPARO -> status = StatusPedido.FINALIZADO;
            case FINALIZADO -> System.out.println("Pedido já finalizado");
        }
    }
}
