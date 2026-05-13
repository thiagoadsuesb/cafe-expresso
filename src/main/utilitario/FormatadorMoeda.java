package utilitario;

import java.text.NumberFormat;
import java.util.Locale;

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
 * Responsável pela formatação
 * monetária do sistema.
 */
public final class FormatadorMoeda {

    /**
     * Construtor privado.
     */
    private FormatadorMoeda() {
    }

    /**
     * Formata valor monetário.
     *
     * @param valor Valor informado
     * @return Valor formatado
     */
    public static String formatar(double valor) {

        Locale localBrasil =
                new Locale("pt", "BR");

        NumberFormat formatador =
                NumberFormat.getCurrencyInstance(localBrasil);

        return formatador.format(valor);
    }
}