package servico;

public class ServicoCaixa {

    private static double total = 0;
    private static int pedidos = 0;

    public static void registrar(double valor) {
        total += valor;
        pedidos++;
    }

    public static void relatorio() {

        System.out.println("\n===== CAIXA =====");
        System.out.println("Total: " + total);
        System.out.println("Pedidos: " + pedidos);
    }
}