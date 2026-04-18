# Café Expresso

## Descrição

O Café Expresso é um sistema de autoatendimento projetado para simular o funcionamento de um totem digital em cafeterias de pequeno porte.
A aplicação permite que o próprio cliente realize a montagem do pedido, enquanto o sistema gerencia automaticamente o cálculo de valores e o fluxo de atendimento.

Mais do que um simulador de pedidos, o projeto foi desenvolvido com foco na aplicação de práticas de Engenharia de Software, garantindo organização, consistência e evolução controlada do sistema.

---

## Objetivo do Projeto

Este projeto tem como objetivo aplicar, na prática, conceitos fundamentais da disciplina de Engenharia de Software Avançada, tais como:

* Modelagem orientada a objetos
* Definição e validação de regras de negócio
* Testes automatizados (TDD)
* Controle de versões com Git
* Organização estrutural do código

---

## Requisitos Funcionais

* RF01: Permitir o cadastro de produtos com nome e preço
* RF02: Permitir a adição de múltiplos itens a um pedido
* RF03: Calcular automaticamente o valor total do pedido
* RF04: Controlar o status do pedido ao longo do atendimento


## Regras de Negócio

O sistema implementa um fluxo controlado de estados para garantir consistência no processo:

PENDENTE → PAGO → EM PREPARO → FINALIZADO

Regras aplicadas:

* Não é permitido avançar etapas fora da ordem definida
* Um pedido não pode ser enviado para preparo sem confirmação de pagamento
* Um pedido não pode ser finalizado sem ter sido preparado
* O valor total do pedido deve ser calculado automaticamente com base nos itens


## Modelagem do Sistema

O sistema foi estruturado com base em princípios de separação de responsabilidades:

* **Produto**
  Representa os itens disponíveis no cardápio, contendo nome e valor unitário.

* **ItemPedido**
  Responsável por associar um produto à quantidade desejada, incluindo o cálculo de subtotal.

* **Pedido**
  Atua como núcleo do sistema, agregando itens e controlando o fluxo de estados.

* **StatusPedido**
  Define os estados possíveis do pedido, garantindo controle do ciclo de vida.


## Diagrama UML

O diagrama de classes do sistema está disponível em:

doc/uml.md

Ele descreve a relação entre as entidades principais e suas responsabilidades dentro do sistema.


## Testes e Qualidade

O desenvolvimento segue a abordagem TDD (Test-Driven Development), com foco na validação das regras de negócio.

Os testes cobrem:

* Cálculo de subtotal por item
* Cálculo do valor total do pedido
* Transições válidas e inválidas de status

Essa abordagem contribui para:

* Redução de falhas
* Maior confiabilidade
* Facilidade de manutenção


## Estrutura do Projeto

src/
├── main/
│    ├── Produto.java
│    ├── ItemPedido.java
│    ├── Pedido.java
│    ├── StatusPedido.java
│    ├── MensagensErro.java
│    └── MensagensSistema.java
│
└── test/
└── PedidoTeste.java

doc/
└── uml.md/

## Tecnologias Utilizadas

* Java
* JUnit 5
* Git e GitHub


## Execução

O projeto pode ser executado diretamente pela IDE (IntelliJ) ou via linha de comando com Java.


## Considerações Finais

O Café Expresso foi desenvolvido como um exercício prático de aplicação de conceitos de Engenharia de Software, com foco em organização, qualidade e evolução do sistema.

A estrutura adotada permite futuras expansões, como interface gráfica, persistência em banco de dados e integração com meios de pagamento.
