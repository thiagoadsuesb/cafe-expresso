package servico;

import modelo.Pedido;
import utilitario.FormatadorMoeda;

public class PixService {

    public static void gerarPix(Pedido pedido) {

        System.out.println("\n===== PIX GERADO =====");

        System.out.println("Chave: eu@thiagoprates.com.br");

        System.out.println("Valor: " +
                FormatadorMoeda.formatar(pedido.calcularTotal()));

        System.out.println("\n[ QR CODE SIMULADO ]");
        System.out.println("██████████████████");
        System.out.println("█  CAFÉ EXPRESSO █");
        System.out.println("█  PAGAMENTO PIX █");
        System.out.println("██████████████████");
    }
}