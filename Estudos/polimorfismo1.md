# Polimorfismo

> Polimorfismo é toda estratégia de implementação que permite tornar o código mais versátil, isto é, fazer com que as implementações abranjam a maior quantidade de especificidades variadas daquele formato.
> 

## Categorias de polimorfismo

Tais soluções podem ser classificadas quanto a sua efetividade:

- Soluções ad-hocs são soluções que são viáveis somente às implementações momentâneas, isto é, se quisermos que ela abranja mais casos, precisamos verificar se o sistema suporta esses novos casos.
    - Soluções tendem a ser mais fácil e permitem funcionalidades maiores - isto é - realizam tarefas mais complexas e com mais objetos
- Soluções universais são aquelas que conseguem abordar todos os casos anteriores e possíveis casos futuros através de sua implementação.
    - Soluções tendem a ser mais difíceis e permitem funcionalidades menores- isto é - realizam tarefas mais simples e com menos objetos

# Casos de polimorfismo

Em suma, falando de polimorfismo por si, podemos dividir as estratégias em 6 casos, nem todos são implementáveis em todas as linguagens, logo, devemos analisar tais casos conforme nossa ferramenta de implementação

<aside>
👁️ Esses dois primeiros tipos são mais naturais na implementação de classes e objetos de forma que passemos mais superficialmente por eles, pois já foram descritos e utilizados.

</aside>

### → Polimorfismo de Sobreposição - Ad-hoc

É aquele que consiste em diferentes implementações locais para uma mesma referência genérica, de forma que consigamos instanciar todas as implementações dentro de uma só assinatura, variando seu resultado conforme o escopo de sua chamada.

Por exemplo, esse é o caso da utilização flag `@Override` em alguns métodos, de forma que a classe filha possa implementar uma variante local do método existente na classe mãe, instanciando as duas implementações conforme a classe utilizada na chamada.

### → Polimorfismo de Sobrecarga - Ad-hoc (dito polimorfismo sem herança)

Refere-se ao uso da sobrecarga, que já discutimos aqui, e faz referência à ideia de utilizar várias implementações de um mesmo nome sobre uma mesma assinatura -mas com parâmetros diferentes. Portanto, diferentemente da sobreposição, em que o direcionamento das versões se dá pela localidade, nesse caso, o direcionamento se da pelos parâmetros passados no programa principal

Em java, a implementação desse caso é mais natural, pois a linguagem suporta a sobrecarga, porém, podemos realizá-lo em python também através de algumas “gambiarras” como propriedades, parâmetros pré-definidos e etc

![Untitled](Polimorfismo%206e92cbda156942fe8d37bb84e7b8c008/Untitled.png)

<aside>
👁️ Agora, podemos tratar de casos menos triviais de polimorfismo com um pouco mais de profundidade

</aside>

# → Polimorfismo de Coerção - Ad-hoc

Coerção refere-se ao ato de trocar o tipo de um objeto ou variável para que uma implementação possa ser realizada. Observe que os próprios compiladores já realizam essas tarefas - coerção automática. Porém, somos capazes de utilizar essa estratégia explicitamente para generalizar implementações.

-lembrar que a superclasse fica antes do = e a subclasse fica dps(pq é uma especialização da superclasse)

![Untitled](Polimorfismo%206e92cbda156942fe8d37bb84e7b8c008/Untitled%201.png)

## Na aplicação da orientação a objetos

Imagine que variadas subclasses herdam uma superclasse. De forma que, possamos tratar os objetos dessas classes posteriores e diferentes como objetos similares através de uma coerção para a superclasse. 

Dessa forma, conseguimos implementar, funções interfaces e outras classes com base na superclasse e, ao passar a superclasse em questão para essas implementações, passamos suas subclasses que serão convertidas (casting explícito ou implícito) para a superclasse. Tornando, portando, essa implementação genérica às subclasses.

```python
def geraCartesiano( IntervaloGenerico1, IntervaloGenerico1 ) :

	coordenadas_iniciais = {}
	coordenadas_iniciais[0] = IntervaloGenerico1.ini
	coordenadas_iniciais[0] = IntervaloGenerico2.ini
	coordenadas_finais[0] = IntervaloGenerico1.fim
	coordenadas_finais[0] = IntervaloGenerico2.fim
	

geraCartesiano( intervaloInteiroA, intervaloInteiroB )
geraCartesiano( intervaloRealA, intervaloInteiroB )
geraCartesiano( intervaloImaginárioA, intervaloInteiroB )

```

## Problemas

Observe que a maneira mais segura de realizar esse caso de polimorfismo é a coerção da subclasse para a superclasse. Mesmo assim, precisamos tomar cuidado com os métodos sobrescritos, o que pode ocasionar um problema, dependendo de sua implementação.

Outro detalhe é, podemos tratar a superclasse como uma subclasse, porém, pode ser que o programa obtenha problemas com coisas que são implementadas na classe a qual se convergiu e não são implementadas na classe original. 

### Java

Para isso, podemos utilizar a expressão `objeto instanceof Classe` que vai retornar um valor lógico associado ao fato de que o objeto é instanciado como a Classe ou não, permitindo que façamos estruturas mais seguras nas implementações de coerção.

### Python - Duck typing

O python afere seus tipos com base nas implementações através da tipagem dinâmica, o que pode tornar o campo da coerção mais perigoso tendo em vista que os tipos aqui podem não ser ditos.

Entretanto, a linguagem possui alguns recursos como a definição explícita de tipos de parâmetros, e métodos de verificação de tipo, além de que a verificação acima descrita pode ser realizada com a função `isinstance(obj, Classe)`.

# → Polimorfismo de Parâmetros e de inclusão

> Esses tipos de polimorfismo são mais complexos e dependem de algumas implementações da linguagem. Portanto, esses conceitos serão trabalhados dentro das descrições sobre generics e collections.
>
