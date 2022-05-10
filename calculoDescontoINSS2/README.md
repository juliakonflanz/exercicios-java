# ✍️ Exercício 2
Realizar a leitura do salário do colaborador e calcular o valor do INSS de acordo com a tabela de valores abaixo, seguindo a regra usada no INSS:

| Salário do contribuinte | Alíquota de INSS |
| --- | --- |
| Até R$ 1.100 |7,5% |
| De R$ 1.100,01 a R$ 2.203,48 | 9% |
| De R$ 2.203,49 a R$ 3.305,22 | 12% |
| De R$ 3.305,23 a R$ 6.433,57 | 14% |
<br>

## Exemplo
Uma pessoa com salário de R$ 4.000,00 deverá calcular o valor do INSS em todas as faixas, considerando o limite de cada uma, e somar tudo, ao invés de usar apenas a alíquota da última faixa (14%).

**Sendo assim:**

- 1ª faixa: R$ 1.100 x 7,5% = R$ 82,50

- 2ª faixa: (R$ 2.203,48 – R$ 1.100) x 9% = R$ 1.103,48 x 9% = R$ 99,31

- 3ª faixa: (R$ 3.305,22 – R$ 2.203,49) x 12% = R$ 1.101,73 x 12% = R$ 132,20

- 4ª faixa: (R$ 4.000 – R$ 3.305,23) x 14% = R$ 694,77 x 14% = R$ 97,26

Somando tudo (R$ 82,50 + R$ 99,31 + R$ 132,20 + R$ 97,26), o desconto total do INSS ficaria R$ 411,27.


