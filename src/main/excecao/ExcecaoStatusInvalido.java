package main.excecao;

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
 * Exceção lançada quando ocorre
 * uma transição inválida de status.
 */
public class ExcecaoStatusInvalido extends RuntimeException {

    /**
     * Construtor da exceção.
     *
     * @param mensagem Mensagem de erro
     */
    public ExcecaoStatusInvalido(String mensagem) {
        super(mensagem);
    }
}