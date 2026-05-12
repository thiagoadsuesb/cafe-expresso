package main.constante;

/**
 * Universidade Estadual do Sudoeste da Bahia (UESB)
 * Curso: Tecnologia em Análise e Desenvolvimento de Sistemas
 * Disciplina: Engenharia de Software Avançada
 * Professor: Lucas Santos de Oliveira
 * Autor: Thiago Ferreira Prates Neves
 *
 * Projeto – Café Expresso
 *
 * Descrição:
 * Centraliza mensagens do sistema
 * exibidas ao usuário.
 */
public final class MensagensSistema {

    /**
     * Construtor privado para impedir instanciação.
     */
    private MensagensSistema() {
    }

    public static final String PEDIDO_CRIADO =
            "Pedido criado com sucesso.";

    public static final String PEDIDO_FINALIZADO =
            "Pedido finalizado.";

    public static final String ITEM_ADICIONADO =
            "Item adicionado ao pedido.";

    public static final String PAGAMENTO_REALIZADO =
            "Pagamento realizado com sucesso.";
}