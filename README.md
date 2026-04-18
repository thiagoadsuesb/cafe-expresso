# Café Expresso

## Descrição
Sistema acadêmico de autoatendimento para cafeteria desenvolvido em Java, simulando um totem digital de pedidos.

## Objetivo
Aplicar conceitos de Engenharia de Software como:
- Programação Orientada a Objetos (POO)
- Testes Unitários (TDD)
- Controle de versão com Git/GitHub
- Separação de responsabilidades (SRP)

## Funcionalidades
- Cadastro de produtos (nome e preço)
- Adição de itens ao pedido
- Cálculo automático do valor total
- Controle de status do pedido:
  PENDENTE → PAGO → EM PREPARO → FINALIZADO

## Estrutura do sistema
- Produto: representa itens do cardápio
- ItemPedido: representa produto + quantidade
- Pedido: gerencia itens e regras do sistema

## Regras de negócio
- Um pedido só pode avançar de status seguindo a ordem correta
- Não é permitido finalizar pedido sem pagamento
- Cálculo de total deve ser automático

## Testes
O sistema utiliza testes unitários para validar regras de negócio (TDD).

## Tecnologias
- Java
- JUnit 5
- Git / GitHub