package aplicacao;

/**
 * =========================================================
 * UNIVERSIDADE ESTADUAL DO SUDOESTE DA BAHIA (UESB)
 * CURSO: ANÁLISE E DESENVOLVIMENTO DE SISTEMAS
 * DISCIPLINA: ENGENHARIA DE SOFTWARE AVANÇADA
 * PROFESSOR: LUCAS SANTOS DE OLIVEIRA
 * ALUNO: THIAGO FERREIRA PRATES NEVES
 * =========================================================
 */
public class Sobre {

    public static void exibir() {

        System.out.println("""
                
                ====================================
                        SOBRE O SISTEMA
                ====================================

                Projeto: Café Expresso System
                Disciplina: Engenharia de Software Avançada
                Professor: Lucas Santos de Oliveira
                Aluno: Thiago Ferreira Prates Neves
                Curso: ADS - UESB

                Funcionalidades:
                ✔ Controle de pedidos
                ✔ Pagamento PIX
                ✔ Cozinha automática
                ✔ Caixa diário
                ✔ Testes unitários
                ✔ TDD e refatoração

                GitHub:
                https://github.com/thiagoadsuesb/cafe-expresso

                ====================================
                """);
    }
}