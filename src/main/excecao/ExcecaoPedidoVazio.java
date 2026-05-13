package excecao;

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
 * Exceção lançada quando um pedido
 * não possui itens cadastrados.
 */
public class ExcecaoPedidoVazio extends RuntimeException {

    /**
     * Construtor da exceção.
     *
     * @param mensagem Mensagem de erro
     */
    public ExcecaoPedidoVazio(String mensagem) {
        super(mensagem);
    }
}