package servico;

import modelo.ItemPedido;
import modelo.Pedido;
import enumeracao.StatusPedido;

public class ServicoCozinha {

    public void preparar(Pedido pedido) {

        System.out.println("\n COZINHA RECEBEU PEDIDO...");

        pedido.setStatus(StatusPedido.EM_PREPARO);

        for (ItemPedido item : pedido.getItens()) {

            long tempo = calcularTempo(item.getProduto().getNome());

            System.out.println(" Preparando: " + item.getProduto().getNome());

            try {
                Thread.sleep(tempo);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        pedido.setStatus(StatusPedido.FINALIZADO);

        System.out.println("\n PEDIDO FINALIZADO NA COZINHA!");
    }

    private long calcularTempo(String produto) {

        return switch (produto) {
            case "Cafe Expresso" -> 2000;
            case "Cappuccino" -> 3000;
            case "Pao de Queijo" -> 4000;
            case "Quiche de Frango" -> 6000;
            case "Empada Chilena" -> 5000;
            default -> 2500;
        };
    }
}