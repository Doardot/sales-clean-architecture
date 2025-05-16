## 1. Objetivo

- Implementar o backend de um sistema de vendas usando:
    - Padrões de projeto
    - Princípios SOLID
    - Arquitetura Limpa
- O foco é no backend REST monolítico, em Java com Spring Boot
- O banco de dados: H2 em memória
- Deve conter dados de seed para testes

## 2. Escopo do sistema
- **Produtos**
    - Cada produto possui:
        - Código
        - Descrição
        - Preço unitário atual

- **Estoque**
    - Para cada produto em estoque:
        - Quantidade máxima armazenável
        - Quantidade mínima a ser mantida
        - Quantidade atual disponível

- **Pedido e Orçamento**
    - Cliente realiza pedido com lista de itens e quantidades desejadas.
    - O sistema retorna um orçamento que inclui:
        - Código do orçamento
        - Data do orçamento
        - Nome do cliente
        - Lista de itens do pedido
        - Estado e país da compra
        - Somatório dos custos dos itens
        - Valor do imposto estadual/regional
        - Valor do imposto federal/nacional
        - Valor do desconto
        - Valor final para o consumidor
    - Todos os orçamentos ficam armazenados para consulta futura.

- **Efetivação de Venda**
    - Cliente pode aprovar o orçamento.
    - Na aprovação:
        - Verificar disponibilidade no estoque para todos os itens.
        - Se disponível, realizar baixa no estoque.
        - Marcar o orçamento como “efetivado”.
    - Se não disponível ou orçamento inválido, a venda não ocorre.
    - Ignorar pagamento e entrega.

## 3. Regras de negócio

- **Região Atendida**
    - O sistema atende apenas alguns estados brasileiros inicialmente.
    - Deve permitir indicar país e estado/região no pedido.
    - Caso país ou estado não seja atendido, o pedido é recusado.

- **Cálculo de Impostos**
    - Sempre calcular:
        - Imposto estadual/regional (variável conforme estado)
        - Imposto federal/nacional (fixo)
    - Impostos são calculados antes da aplicação de descontos.
    - Exemplos de tabela de impostos estaduais (Anexo I):
        - RS: isento até R$ 100,00, depois 10% sobre o que ultrapassa.
        - SP: alíquota fixa de 12%.
        - PE: 15% geral, 5% para produtos essenciais (com * na descrição).
    - Imposto federal: 15% sobre o total do orçamento.

- **Política de Descontos**
    - 5% de desconto por item cuja quantidade seja maior que 3.
    - 10% de desconto no total do orçamento para orçamentos com mais de 10 itens.
    - Descontos são cumulativos.
    - Políticas de desconto podem ser alteradas no futuro.

- **Validade do Orçamento**
    - Orçamentos têm validade de 21 dias.
    - Após esse período, não podem ser efetivados.

## 4. Endpoints REST a Implementar

- Retornar catálogo de produtos.
- Solicitar orçamento para um pedido (lista de itens).
- Efetivar orçamento (se válido e estoque disponível).
- Informar chegada de produtos no estoque (atualizar quantidades).
- Retornar quantidade disponível no estoque para todo o catálogo.
- Retornar quantidade disponível para uma lista específica de produtos.
- Retornar lista de orçamentos efetivados em um período (data inicial e final).

## 5. Requisitos Técnicos e considerações

- Seguir princípios SOLID.
- Usar arquitetura limpa (Clean Architecture).
- Explorar padrões de projeto (ex: Repository, Factory, Strategy, etc).
- Banco de dados a critério do grupo (nesse caso H2 por facilidade).
- Fornecer dados seed para testes.
- O sistema backend deve estar preparado para integrar com futuros frontends (não obrigatório desenvolver frontend).
- Apresentação obrigatória em aula com demonstração funcional e respostas técnicas (ou seja -> documentar código)
- Aspectos de pagamento e entrega estão fora do escopo.
- Sistema deve ser escalável para suportar futuros países e regiões.
