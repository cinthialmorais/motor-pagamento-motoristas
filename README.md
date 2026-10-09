# Motor de Pagamento de Motoristas — UniDiasUp

Motor financeiro simplificado para uma plataforma de mobilidade urbana, responsável por calcular o pagamento líquido mensal dos motoristas de acordo com a sua categoria.

## Decisões de arquitetura

O projeto segue as restrições definidas pelo arquiteto: não há interfaces nem composição de objetos. Toda a variação de comportamento é resolvida com herança, classe abstrata, polimorfismo por sobrescrita e encapsulamento.

A classe abstrata `Motorista` concentra os dados comuns (nome, placa, quantidade de corridas e valor bruto), todos `private`, e expõe apenas getters de leitura. O valor bruto só pode ser alterado por `registrarCorrida`, o que impede manipulação externa do saldo. O método protegido `descontarPercentualDaPlataforma` evita repetição do cálculo percentual nas filhas.

| Categoria | Taxa da plataforma | Regra extra |
|---|---|---|
| `MotoristaIniciante` | 25% | Desconto de R$ 50,00 se fizer menos de 5 corridas no mês |
| `MotoristaPremium` | 15% | Bônus de R$ 2,00 por corrida, somado ao bruto antes da taxa (sobrescrita de `registrarCorrida`) |
| `MotoristaParceiroFrotista` | 20% | Desconto de R$ 800,00 de aluguel; o líquido nunca fica abaixo de zero |

## Estrutura

```
src/br/com/unidiasup/corridas/
├── Motorista.java                  (classe abstrata)
├── MotoristaIniciante.java
├── MotoristaPremium.java
├── MotoristaParceiroFrotista.java
└── Main.java                       (simulação e extratos)
```

## Como executar

Requer Java 11 ou superior.

```bash
javac -d out src/br/com/unidiasup/corridas/*.java
java -cp out br.com.unidiasup.corridas.Main
```
