# Desafio SC Clouds

## Sumário
- [Questões Conceituais](#questões-conceituais)
    - [Diferenciar as camadas 2 e 3 do modelo OSI, e indicar os protocolos utilizados para endereçamento nestas camadas](#diferenciar-as-camadas-2-e-3-do-modelo-osi-e-indicar-os-protocolos-utilizados-para-endereçamento-nestas-camadas)
    - [Qual a diferença entre adotar uma solução proprietária como o sistema operacional Windows quando comparado a adoção de uma solução OpenSource como o sistema operacional Ubuntu? Quais seriam os pontos negativos e positivos de cada abordagem?](#qual-a-diferença-entre-adotar-uma-solução-proprietária-como-o-sistema-operacional-windows-quando-comparado-a-adoção-de-uma-solução-opensource-como-o-sistema-operacional-ubuntu-quais-seriam-os-pontos-negativos-e-positivos-de-cada-abordagem)
    - [O que seria um projeto OpenSource? Como empresas podem adotar tais tecnologias e o que isso acarreta?](#o-que-seria-um-projeto-opensource-como-empresas-podem-adotar-tais-tecnologias-e-o-que-isso-acarreta)
- [Etapa Prática](#etapa-prática)
    - [Requisitos](#requisitos)
    - [Compilação](#compilação)
    - [Execução](#execução)
    - [Testes](#testes)
    - [Troubleshooting](#troubleshooting)
## Questões Conceituais

### Diferenciar as camadas 2 e 3 do modelo OSI, e indicar os protocolos utilizados para endereçamento nestas camadas.

A divisão do modelo OSI se dá por camadas hierarquicas de abstração de rede, começando da mais física para a mais abstrata. As camadas inferiores estão mais próximas do hardware, enquanto as superiores lidam com aspectos mais abstratos da comunicação de dados.

A camada 2, ou camada de Enlance, é responsável pela transferência de dados entre nós adjacentes em uma rede. Ela é subdividida em duas sub-camadas: camada MAC (Medium access control) e camada LLC (Logical Link Control).

A subcamada MAC é responsável pelo controle de acesso ao meio físico de transmissão. Ela determina como os dispositivos na rede ganham acesso ao meio e enviam dados sem colidir uns com os outros.

Já a subcamada LLC fornece um controle lógico de enlace, suas responsabilidades incluem a multiplexação de protocolos que compartilham a camada de enlace de dados, permitindo que vários protocolos de rede funcionem sobre a mesma rede física. A LLC também oferece mecanismos de controle de erro e controle de fluxo para garantir a entrega confiável de dados.

Dentre os protocolos da camada de enlance estão o PPP (Point-to-Point Protocol), Ethernet, Wi-Fi, Bluetooth, Frame Relay, ATM (Asynchronous Transfer Mode), entre outros.

A camada 3, ou camada de rede, é responsável por transferir pacotes de rede de comprimento variável de um host de origem para um host de destino através de uma ou mais redes. Quando requisitada, esta camada emite solicitações de serviço para a camada de enlace. Além disso, essa camada cuida da fragmentação de pacotes e controle de fluxo na rede.

Dentre os protocolos da camada de rede estão: o IPv4/IPv6 (Internet Protocol), ICMP (Internet Control Message Protocol), IGMP (Internet Group Management Protocol).

### Qual a diferença entre adotar uma solução proprietária como o sistema operacional Windows quando comparado a adoção de uma solução OpenSource como o sistema operacional Ubuntu? Quais seriam os pontos negativos e positivos de cada abordagem?

A adoção de soluções Open Source permitem um grau maior de controle, escrutínio e flexibilidade para o usuário, visto que as responsabilidades do projeto não ficam monopolizadas pelo fornecedor, como é o caso de projetos Closed Source.

#### Benefícios de Projetos Open Source
- Permitem a inspeção do código fonte.
- Permitem requisitar e adicionar novas features.
- Transparência.
- Software OpenSource estimula uma comunidade engajada com o projeto que podem fazer contribuições.
#### Pontos Negativos de Projetos Open Source
- Se um projeto tem poucos contribuidores e um baixo nível de escrutínio, isso pode resultar em vários problemas devido à baixa manutenção.
#### Benefícios de Projetos Closed Source
- Terceirização de responsabilidade, permitindo o usuário focar apenas no uso do software para aplicações.
#### Pontos Negativos de Projetos Closed Source
- Terceirização de responsabilidade pode ser prejudicial a longo prazo, porque adição de novas features ou manutenção do software dependem da direção e interesse do fornecedor, que pode mudar com o tempo.
- Funcionalidades adicionadas pelo fornecedor podem priorizar o seu próprio ecossistema, prendendo o usuário às suas soluções.

### O que seria um projeto OpenSource? Como empresas podem adotar tais tecnologias e o que isso acarreta?

Projetos OpenSource são projetos construidos com uma abordagem aberta e colaborativa, permitindo que o produto seja abertamente visto, modificado e distribuído. Uma característica marcante do Open Source é a comunidade, que não só utiliza o software, mas também contribúi para ele, ajudando a melhorá-lo e dar manutenção.

Uma empresa pode decidir tanto adotar um projeto Open Source como solução ou converter seu produto para Open Source. Os benefícios da adoção de uma solução OpenSource já foram listados anteriormento. Já os benefícios para a conversão de um produto para Open Source, isso permite um grau maior de confiabilidade no produto, que passa a ter vários revisores, além disso, uma consequência do código aberto é a criação de uma comunidade especialista no código fonte do projeto, facilitando o processo de aquisição de talento.

Portanto, adotar ou converter produtos para Open Source pode trazer benefícios significativos para as empresas, incluindo acesso a uma vasta rede de colaboradores e expertise, bem como maior transparência e inovação contínua.

### Etapa Prática
#### Requisitos
- Java 11
- Maven

#### Compilação

```
mvn clean package
```
O resultado da compilação é `target/sc-clouds-1.0-jar-with-dependencies.jar`

#### Execução
```
Usage: app [-hV] -m=<method> <command> <number>
Computes Fibonacci sequences and prime numbers.
      <command>           The command to execute: fibonacci or prime
      <number>            The number for the command
  -h, --help              Show this help message and exit.
  -m, --method=<method>   The method to use: recursive or iterative
  -V, --version           Print version information and exit.

```

Exemplo de execução:
```
java -jar target/sc-clouds-1.0-jar-with-dependencies.jar comando valor -m metodo 

```
- Comando: **fibonacci** ou **prime**
- Value: número inteiro
- Método: **recursive** ou **iterative**

```
java -jar target/sc-clouds-1.0-jar-with-dependencies.jar fibonacci -m recursive 10
> Fibonacci result: 55

```

```
java -jar target/sc-clouds-1.0-jar-with-dependencies.jar prime -m iterative 10
> Prime numbers up to 10: [2, 3, 5, 7]
```

#### Testes
Para verificar a integridade da solução, execute os testes:
```
mvn test
```

#### Troubleshooting
Caso obtenha o seguinte erro: `no main manifest attribute, in target/sc-clouds-1.0.jar`, verifique se você está executando `sc-clouds-1.0.jar` no lugar de `sc-clouds-1.0-jar-with-dependencies.jar`.

