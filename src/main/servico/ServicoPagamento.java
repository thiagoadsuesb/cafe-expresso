package servico;

import modelo.Pedido;
import utilitario.FormatadorMoeda;

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
 * Serviço responsável pelo processamento
 * e validação de pagamentos.
 */
public class ServicoPagamento {

    /**
     * Realiza o pagamento do pedido.
     *
     * @param pedido Pedido atual
     * @return Mensagem de confirmação
     */
    public String realizarPagamento(Pedido pedido) {

        double total = pedido.calcularTotal();

        return "Pagamento realizado com sucesso. Total: "
                + FormatadorMoeda.formatar(total);
    }
}