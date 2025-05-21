# Orquestra Vendas: Uma Sinfonia de SOLID & Clean Architecture

Uma aplicação monolítica desenvolvida em Java com Spring Boot, implementando um sistema de vendas robusto e escalável. O foco está em fornecer um backend RESTful que respeita os padrões de projeto, os princípios SOLID e a Arquitetura Limpa, garantindo facilidade de manutenção e evolução futura.

---

## 1. Objetivo

O objetivo deste projeto é implementar o backend de um sistema de vendas com ênfase em:

- **Projeto e Manutenção**: Utilização de padrões de projeto e princípios SOLID para garantir desenvolvimento modular e de fácil manutenção.
- **Arquitetura Limpa**: Organização do código de forma a separar claramente as camadas e responsabilidades, facilitando adaptações futuras.
- **Backend REST Monolítico**: Desenvolvimento de uma aplicação robusta utilizando Java e Spring Boot.
- **Banco de Dados**: Uso do H2 em memória para agilizar testes e desenvolvimento, complementado com dados seed para simular um ambiente real de trabalho.

---

## 2. Escopo do Sistema

### Produtos

Cada produto no sistema é definido pelos seguintes atributos:
- **Código**: Identificador único do produto.
- **Descrição**: Informações detalhadas sobre o produto.
- **Preço Unitário Atual**: Valor atual para aquisição do produto.

### Estoque

O gerenciamento do estoque contempla, para cada produto armazenado:
- **Quantidade Máxima Armazenável**: Capacidade máxima do local de armazenamento.
- **Quantidade Mínima a Ser Mantida**: Nível mínimo necessário para não comprometer as vendas.
- **Quantidade Atual Disponível**: Valor dinâmico que reflete as entradas e saídas do estoque.

### Pedido e Orçamento

O fluxo de negociação com o cliente inicia com a realização do pedido e a emissão de um orçamento que inclui:
- Código do orçamento;
- Data de emissão;
- Nome do cliente;
- Lista detalhada de itens e suas quantidades;
- Estado e país de onde a compra se origina;
- Somatório dos custos dos itens;
- Cálculo dos impostos estaduais/regionais e federal/nacional;
- Valor do desconto aplicado;
- Valor final para o consumidor.

Todos os orçamentos gerados são armazenados para consultas futuras e possibilitam a rastreabilidade das operações.

### Efetivação de Venda

O processo de venda ocorre quando o cliente aprova o orçamento, seguindo os passos abaixo:
- **Verificação de Estoque**: Confirmação da disponibilidade de cada item solicitado.
- **Baixa no Estoque**: Atualização das quantidades, deduzindo os itens vendidos.
- **Marcação do Orçamento**: Registro do orçamento como “efetivado” somente se todas as condições forem atendidas.

Caso o estoque seja insuficiente ou o orçamento esteja inválido (como por expiração), a venda não é realizada. Neste fluxo, aspectos de pagamento e entrega foram propositalmente deixados fora de escopo.

---

## 3. Regras de Negócio

### Região Atendida

- O sistema atende inicialmente apenas alguns estados brasileiros.  
- Durante o pedido, é obrigatório indicar país e estado/região.  
- Pedidos oriundos de regiões não atendidas são recusados.

### Cálculo de Impostos

Os impostos são calculados **antes** da aplicação dos descontos, conforme:

- **Imposto Estadual/Regional**: Valor variável de acordo com o estado:
  - **RS**: Isento até R$ 100,00; a partir desse valor, aplica-se 10% sobre o excedente.
  - **SP**: Alíquota fixa de 12%.
  - **PE**: Alíquota geral de 15% e 5% para produtos essenciais (identificados com um asterisco na descrição).
- **Imposto Federal/Nacional**: Alíquota fixa de 15% sobre o total do orçamento.

### Política de Descontos

Descontos podem ser aplicados de maneira cumulativa:
- **Desconto por Item**: 5% de desconto para cada item cuja quantidade seja maior que 3.
- **Desconto Total**: 10% de desconto no total do orçamento para pedidos que contenham mais de 10 itens.

Essas políticas foram desenvolvidas para serem facilmente adaptadas a novas regras, garantindo flexibilidade para futuras atualizações.

### Validade do Orçamento

- Orçamentos possuem validade de 21 dias.  
- Após esse período, eles se tornam inválidos e não podem ser efetivados.

---

## 4. Endpoints REST Implementados

A seguir, os principais endpoints disponibilizados:

- **Catálogo de Produtos**: Retorna o catálogo completo de produtos.
- **Solicitação de Orçamento**: Recebe um pedido (lista de itens e suas quantidades) e retorna um orçamento detalhado.
- **Efetivação de Orçamento**: Valida e efetiva o orçamento, realizando a baixa no estoque caso haja disponibilidade.
- **Atualização de Estoque**: Endpoint para registrar a chegada de novos produtos e atualizar quantidades.
- **Consulta de Estoque Total**: Retorna a quantidade disponível para todo o catálogo.
- **Consulta de Estoque Específico**: Retorna a quantidade disponível para uma lista específica de produtos.
- **Consulta de Orçamentos Efetivados**: Filtra e retorna os orçamentos efetivados em um período (definido por data inicial e final).

---

## 5. Requisitos Técnicos e Considerações

- O código segue estritamente os **princípios SOLID** para garantir uma base robusta e de fácil manutenção.
- Adota-se a **Arquitetura Limpa (Clean Architecture)** para uma clara separação de responsabilidades e escalabilidade.
- São explorados vários **padrões de projeto** (por exemplo, Repository, Factory, Strategy) para promover um design modular.
- O banco de dados utilizado é o **H2 (em memória)**, facilitando testes e desenvolvimento ágil, com dados seed pré-definidos para simulação realista.
- O backend foi desenvolvido com a futura integração com frontends em mente, mesmo que estes não estejam implementados neste escopo.
- Aspectos relacionados a pagamento e entrega foram deliberadamente excluídos para focar nos processos de vendas e orçamentos.
- O sistema foi desenhado para ser escalável, possibilitando a inclusão de novos países e regiões conforme a expansão do negócio.
