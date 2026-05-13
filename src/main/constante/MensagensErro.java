package constante;

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
 * Centraliza mensagens de erro utilizadas
 * pelas regras de negócio do sistema.
 */
public final class MensagensErro {

    /**
     * Construtor privado para impedir instanciação.
     */
    private MensagensErro() {
    }

    public static final String NOME_INVALIDO =
            "Nome inválido.";

    public static final String PRECO_INVALIDO =
            "Preço inválido.";

    public static final String PRODUTO_NULO =
            "Produto não pode ser nulo.";

    public static final String QUANTIDADE_INVALIDA =
            "Quantidade inválida.";

    public static final String PEDIDO_VAZIO =
            "O pedido não possui itens.";

    public static final String STATUS_INVALIDO =
            "Status do pedido inválido.";

    public static final String PAGAMENTO_INVALIDO =
            "Pagamento inválido.";
}