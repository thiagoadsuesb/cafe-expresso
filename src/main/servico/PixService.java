package servico;

import modelo.Pedido;
import utilitario.FormatadorMoeda;

import java.util.UUID;

/**
 * =========================================================
 * PIX SIMULADO BACEN (CÓDIGO COPIA E COLA)
 * =========================================================
 */
public class PixService {

    public static String gerarPix(Pedido pedido) {

        String txid = UUID.randomUUID().toString().substring(0, 26);
        double valor = pedido.calcularTotal();

        String pix =
                "000201" +
                        "26580014BR.GOV.BCB.PIX" +
                        "0136eu@thiagoprates.com.br" +
                        "52040000" +
                        "5303986" +
                        "54" + String.format("%.2f", valor).replace(",", ".") +
                        "5802BR" +
                        "5925CAFE EXPRESSO" +
                        "6008BRASIL" +
                        "62" + txid.length() + txid;

        System.out.println("=== PIX GERADO ===");
        System.out.println("TXID: " + txid);
        System.out.println("VALOR: " + FormatadorMoeda.formatar(valor));
        System.out.println(pix);

        return pix;
    }
}