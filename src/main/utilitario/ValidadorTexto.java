package main.utilitario;

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
 * Classe utilitária responsável
 * por validações textuais.
 */
public final class ValidadorTexto {

    /**
     * Construtor privado.
     */
    private ValidadorTexto() {
    }

    /**
     * Verifica se texto está vazio.
     *
     * @param texto Texto informado
     * @return true caso inválido
     */
    public static boolean textoEstaVazio(String texto) {
        return texto == null || texto.isBlank();
    }

    /**
     * Remove espaços excedentes.
     *
     * @param texto Texto informado
     * @return Texto tratado
     */
    public static String limparEspacos(String texto) {

        if (texto == null) {
            return "";
        }

        return texto.trim();
    }
}