# Interface (polimorfismo sem herança)
### Feito por Laura Fernandes e Vicenzo D`Arezzo Zilio
> É uma coleção de métodos abstratos, que definem a assinatura dos métodos sem fornecer uma implementação. Uma interface pode ser implementada por classes para garantir que essas classes forneçam a implementação dos métodos definidos na interface.
> 

# Por que usar?

→ Capturar similaridades de comportamento entre classes não relacionadas

→ Superclasse abstrata não seria natural, pois não há “parentesco” entre as classes

→ Exigir métodos que uma ou mais classes não relacionadas devem necessariamente implementar

→ Revelar uma interface de programação sem revelar as classes que a usam

# Em java:

- É uma classe abstrata pura, ou seja, só tem métodos abstratos (sem implementações).
- Sem atributos, a não ser constantes (public, static, e final)
- Sem construtores
- Palavra IMPLEMENTS declara interfaces implementadas

Exemplo prático: em um sistema de gerenciamento de empresas a classe empregado e a classe contas a se pagar não possuem quase nada em comum. Porém, os objetos de ambas as classes representam uma despesa que deve ser quitada no final do mês pela empresa. Ou seja, cada objeto, não importa a classe, deve ser capaz de “calcular o valor total de pagamento”. SOLUÇÃO: interface Pagavel com método getValorPagamento().

![Untitled](Interface%20(polimorfismo%20sem%20heranc%CC%A7a)%20d3ad6e10ca874357ba38e1a209877458/Untitled.png)

- Uma classe pode satisfazer a várias interfaces
- A classe DEVE implementar todos os métodos de cada interface
- Se assemelha a herança múltipla

![Untitled](Interface%20(polimorfismo%20sem%20heranc%CC%A7a)%20d3ad6e10ca874357ba38e1a209877458/Untitled%201.png)
