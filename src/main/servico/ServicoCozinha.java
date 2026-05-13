package servico;

import modelo.ItemPedido;
import modelo.Pedido;
import enumeracao.StatusPedido;

/**
 * =========================================================
 * UESB - ENGENHARIA DE SOFTWARE AVANÇADA
 * =========================================================
 * Serviço responsável por simular o preparo
 * de pedidos na cozinha da cafeteria.
 *
 * REGRA DE NEGÓCIO:
 * - Pedido só pode ser preparado se existir itens
 * - Status muda para EM_PREPARO durante execução
 * - Status final é FINALIZADO
 * - Tempo de preparo depende dos itens
 * =========================================================
 */
public class ServicoCozinha {

    public void preparar(Pedido pedido) {

        System.out.println("COZINHA RECEBEU PEDIDO");

        pedido.setStatus(StatusPedido.EM_PREPARO);

        try {
            Thread.sleep(1500);
        } catch (Exception ignored) {}

        pedido.setStatus(StatusPedido.FINALIZADO);

        System.out.println("PEDIDO FINALIZADO");
    }
}