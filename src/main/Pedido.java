package main;

import java.util.ArrayList;
import java.util.List;

/**
 * Universidade Estadual do Sudoeste da Bahia (UESB)
 * Curso: Tecnologia em Análise e Desenvolvimento de Sistemas
 * Disciplina: Engenharia de Software Avançada
 * Professor: Lucas Santos de Oliveira
 * Autor: Thiago Ferreira Prates Neves
 *
 * Projeto: Café Expresso
 *
 * Descrição:
 * Controla o ciclo de vida do pedido e suas regras de negócio.
 */
public class Pedido {

    private List<ItemPedido> itens = new ArrayList<>();
    private StatusPedido status = StatusPedido.PENDENTE;

    public void adicionarItem(ItemPedido item) {

        if (status != StatusPedido.PENDENTE) {
            throw new IllegalStateException("Não é possível adicionar itens após pagamento.");
        }

        itens.add(item);
    }

    public double calcularTotal() {
        double total = 0;

        for (ItemPedido item : itens) {
            total += item.calcularSubtotal();
        }

        return total;
    }

    public void avancarStatus() {

        if (status == StatusPedido.PENDENTE) {
            status = StatusPedido.PAGO;
        } else if (status == StatusPedido.PAGO) {
            status = StatusPedido.EM_PREPARO;
        } else if (status == StatusPedido.EM_PREPARO) {
            status = StatusPedido.FINALIZADO;
        } else {
            throw new IllegalStateException("Pedido já finalizado.");
        }
    }

    public StatusPedido getStatus() {
        return status;
    }

    public List<ItemPedido> getItens() {
        return new ArrayList<>(itens);
    }
}