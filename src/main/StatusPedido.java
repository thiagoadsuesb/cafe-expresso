package main;

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
 * Define os estados possíveis de um pedido.
 */
public enum StatusPedido {
    PENDENTE,
    PAGO,
    EM_PREPARO,
    FINALIZADO
}