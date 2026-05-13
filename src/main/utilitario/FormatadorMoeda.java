package utilitario;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * =========================================================
 * UNIVERSIDADE ESTADUAL DO SUDOESTE DA BAHIA (UESB)
 * CURSO: ANÁLISE E DESENVOLVIMENTO DE SISTEMAS
 * DISCIPLINA: ENGENHARIA DE SOFTWARE AVANÇADA
 * PROFESSOR: LUCAS SANTOS DE OLIVEIRA
 * ALUNO: THIAGO FERREIRA PRATES NEVES
 * =========================================================
 *
 * PROJETO: CAFÉ EXPRESSO SYSTEM
 *
 * DESCRIÇÃO:
 * Classe utilitária responsável
 * pela formatação monetária do sistema.
 * =========================================================
 */
public final class FormatadorMoeda {

    /**
     * Construtor privado.
     */
    private FormatadorMoeda() {
    }

    /**
     * Formata valor monetário no padrão brasileiro.
     *
     * @param valor Valor monetário
     * @return Valor formatado
     */
    public static String formatar(double valor) {

        Locale localeBrasil = Locale.of("pt", "BR");

        NumberFormat formatador =
                NumberFormat.getCurrencyInstance(localeBrasil);

        return formatador.format(valor);
    }
}