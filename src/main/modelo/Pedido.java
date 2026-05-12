package main.modelo;

import java.util.ArrayList;
import java.util.List;

import main.enumeracao.StatusPedido;
import main.excecao.ExcecaoStatusInvalido;
import main.constante.MensagensErro;

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
 * Controla o ciclo de vida do pedido
 * e suas regras de negócio.
 */
public class Pedido {

    private List<ItemPedido> itens;
    private StatusPedido status;

    /**
     * Construtor da classe Pedido.
     */
    public Pedido() {
        this.itens = new ArrayList<>();
        this.status = StatusPedido.PENDENTE;
    }

    /**
     * Adiciona item ao pedido.
     *
     * @param item Item do pedido
     */
    public void adicionarItem(ItemPedido item) {

        if (status != StatusPedido.PENDENTE) {
            throw new IllegalStateException(
                    "Não é possível adicionar itens após pagamento."
            );
        }

        itens.add(item);
    }

    /**
     * Calcula o valor total do pedido.
     *
     * @return Valor total
     */
    public double calcularTotal() {

        double total = 0;

        for (ItemPedido item : itens) {
            total += item.calcularSubtotal();
        }

        return total;
    }

    /**
     * Avança o status do pedido.
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
                throw new ExcecaoStatusInvalido(
                        MensagensErro.STATUS_INVALIDO
                );
        }
    }

    /**
     * Retorna status atual.
     *
     * @return Status do pedido
     */
    public StatusPedido getStatus() {
        return status;
    }

    /**
     * Retorna lista protegida de itens.
     *
     * @return Lista de itens
     */
    public List<ItemPedido> getItens() {
        return new ArrayList<>(itens);
    }
}