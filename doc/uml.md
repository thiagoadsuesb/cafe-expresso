\# UML – Sistema Café Expresso



\## Diagrama de Classes



O sistema é estruturado com base em orientação a objetos, separando responsabilidades entre entidades de domínio e regras de negócio.







\## Estrutura Principal



+------------------+

|     Produto      |

+------------------+

| - nome           |

| - precoUnitario  |

+------------------+

| + getPreco()     |

+------------------+



&#x20;       1

&#x20;       |

&#x20;       | 1..\*

&#x20;       |



+------------------+

|   ItemPedido     |

+------------------+

| - produto        |

| - quantidade     |

+------------------+

| + getSubtotal()  |

+------------------+



&#x20;       \*

&#x20;       |

&#x20;       |

&#x20;       1



+-------------------------------+

|            Pedido            |

+-------------------------------+

| - itens: List<ItemPedido>    |

| - status: StatusPedido       |

+-------------------------------+

| + adicionarItem()            |

| + calcularTotal()            |

| + confirmarPagamento()       |

| + enviarParaPreparo()        |

| + finalizarPedido()          |

+-------------------------------+



&#x20;       |

&#x20;       |

&#x20;       v



+----------------------+

|   StatusPedido       |

+----------------------+

| PENDENTE             |

| PAGO                 |

| EM\_PREPARO           |

| FINALIZADO           |

+----------------------+



\## Testes (TDD – Representação no modelo)



Os testes não fazem parte do domínio, mas validam o comportamento do sistema.



+----------------------+

|   PedidoTeste       |

+----------------------+

| + deveCalcularTotal()|

| + deveSomarItens()   |

| + deveValidarStatus()|

| + naoDevePularEstado()|

+----------------------+





\## Regras de dependência



\* Pedido depende de ItemPedido

\* ItemPedido depende de Produto

\* StatusPedido controla o fluxo do Pedido

\* PedidoTeste valida comportamento do Pedido





\## Observação de Engenharia de Software



O sistema segue princípios de:



\* Separação de responsabilidades (SRP)

\* Encapsulamento

\* Controle de estado (State Machine)

\* Testabilidade (TDD)



