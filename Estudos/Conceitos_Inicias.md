# Conceitos Iniciais e Sortidos

<aside>
💡 **DEFINIÇÕES IMPORTANTES**

</aside>

# Métodos especiais - SLIDE 1

Dentro desse paradigma de programação, são adotadas algumas convenções entre a comunidade de programadores e a gama de linguagens para estabelcer definições e requisitos.

Uma delas é a definição de métodos especiais, quais são métodos específicos - relativos a seus objetos - tratados especialmente pelo compilador/interpratador a fim de associá-los diretamente à sua classe de pertencimento.

Esses métodos seriam predefinições de implementação que deveriam acompanhar a construção de uma classe.

### Construtor

O método responsável por inicializar um objeto de uma dada classe, que deve ser chamado sempre ao instanciar um objeto.

Em java, chamamos-o do mesmo nome da classe, indicando sua relação de construção

em Python, referimos a ele como `__init__().`

### ToString

O método responsável por representar a forma de Output de um objeto, retornando a string signo para quem o chama. 
Por padrão, a linguagem já implementa esse e outros métodos especiais, porém, podemos sobrescrever tal método para nossas implementações particular - por isso o @Override .

Em java `ToString()` , já em Pyhton `__str__()`

### Outros

Existem outros métodos, que variam da utilidade do objeto e da linguagem. Como os acessores, os comparadores, os de deleção, os de tamanho e etc…

---

# Sobrecarga - SLIDE 2

A sobrecarga é um recurso de implementação que possibilita a construção de métodos mais versáteis. Para isso, vejamos como referenciar métodos.

## Assinatura

> Assinatura de um método ou de uma função é o conjunto formado pelo nome e pelos parâmetros do método. Podemos ter funções com mesmo nome e parâmetros diferentes, isso pois suas assinaturas diferem.
> 

Logo, sobrecarga refere-se ao criar um nome de função que está associado a diferentes assinaturas, de modo que, ao depender da forma dos parâmetros passado à invocação, o compilador escolherá quais das implementações associadas àquele nome será referenciada.

Em Java, para executar tal técnica, basta referenciar funções de assinaturas diferentes com o mesmo nome. Já em Python, não temos sobrecarga, logo, precisamos utilizar parâmetros predefinidos ou opcionas.

---

# Passagem de Parâmetros em python

> A passagem de parâmetros em python segue o padrão de referência por objeto. Logo, se o que estamos transmitindo é uma variável, a passagem de parâmetros acontece por valor. Porém, se estamos passando objetos - como os criados ou simplesmente os implementados (listas, …) -  a passagem é por referência.
> 

<aside>
❗ Objetos imutáveis : objetos que não podem ser mudados. Ao passa-los como referência, seus valores não serão mudados na memória. Exemplo: String, tupla, …

</aside>

## Parâmetros pré-definidos e opcionais

Somos capazes de criar assinaturas que acompanham parâmetros especiais, estes que podem ter valores pré-determinados pela assinatura, ou o valor passado como parâmetro. Dessa forma, podemos construir métodos mais versáteis.

```nasm
def funcao (p1, p2, p3 = 10) :
    print(p1);
    print(p2);
    print(p3);

funcao(1, 2) -> 1, 2, 10
funcao(1, 2, -15) -> 1, 2, -15
```

Se necessário, posso definir também o tipo do parâmetro e do retorno:

```nasm
def funcao (p1, p2 : int, p3 = None) -> float :
  print(p1)
  print(p2)

  if(p3!= None) :
    print(p3)
    
  return p1/p2
```

## Tuplas e dicionários como parâmetros

### Tuplas

Com a notação de `*args` podemos passar tuplas como parâmetros para uma assinatura, de forma que o interpretador interprete os parâmetros passados de forma a associa-los posicionalmente dentro da tupla conforme sua ordem

```nasm
def f (a, *args, b)

-> f(1, 2, "abc", Aluno, 3)
			- a = 1 
			- *args[0] = 2
			- *args[1] = "abc"
			- *args[3] = Aluno
			- b = 3 
```

### Dicionários

Já para construir um dicionário ao invés da tupla, utilizamos `**kwargs` :

```nasm
def f (**kwargs)

-> f(nome : "vicenzo", idade : 19)
	- kwargs.nome = "vicenzo"
	- kwargs.idade = 19
```

---

# Escopo de atributos e métodos em Java - SLIDE 4

Em java, sempre que criamos atributos e métodos dentro de uma classe, devemos instancia-los, em suas definições, com indicativos de quem pode acessar aquele método.

Para isso, podemos associá-los a 3 categorias:

- **Public**
    
    Qualquer interação com o objeto no repositório do projeto pode acessar o instanciar tal atributo ou método.
    
- **Private**
    
    Somente as interações dentro da definição da classe têm acesso ao atributo ou método.
    
- **Protected**
    
    Somente interações dentro da definição da classe ou dentro da definição de subclasses desta têm acesso ao atributo ou método.
    

---

# Propriedades de métodos em Python - SLIDE 5

Propriedades são maneiras de associar métodos à atributos na linguagem python de forma que possamos definir métodos assessores e modificadores, por exemplo.

Dado um atributo x, podemos utilizar a flag `@property` para associar um método à esse atributo, de forma que tratemos a chamada do método como acesso ao atributo:

```python
@property
def idade(self) :
	print("Uai")
	return self._idade
```

Logo toda vez que o código retornar a memória de `objeto.idade` o programa executará o método propriedade.

Existem propriedades específicas como a de modificadores, veja

```python
@idade.setter
def funcao(self, x) :
	print("UEPA")
	self._idade = x
```

Aqui, toda vez que o código atribuir um valor para o atributo “idade” do objeto, esse método será chamado, como em `objeto.idade = 10`. Observe que a referência se dá no nome da flag, e não do método, diferentemente da propriedade genérica.

---

# Diferença entre Int e Integer ?

## O que é um class wrapper ?

> Um class wrapper (ou classe wrapper) em Java é uma classe que envolve e encapsula um tipo primitivo correspondente, fornecendo métodos e funcionalidades adicionais para trabalhar com esse tipo primitivo como se fosse um objeto. Em Java, existem classes wrappers para cada tipo primitivo:
> 

- **`Integer`**: encapsula o tipo primitivo **`int`**.
- **`Double`**: encapsula o tipo primitivo **`double`**.
- **`Boolean`**: encapsula o tipo primitivo **`boolean`**.
- **`Character`**: encapsula o tipo primitivo **`char`**.
- **`Byte`**: encapsula o tipo primitivo **`byte`**.
- **`Short`**: encapsula o tipo primitivo **`short`**.
- **`Long`**: encapsula o tipo primitivo **`long`**.
- **`Float`**: encapsula o tipo primitivo **`float`**.

## Exemplo tratando a relação entre int e interger :

1. Tipo Primitivo vs. Classe Wrapper: **`int`** é um tipo primitivo, enquanto **`Integer`** é uma classe wrapper que encapsula o tipo primitivo **`int`**. As classes wrapper fornecem funcionalidades adicionais, como métodos e constantes, além de permitir que valores primitivos sejam tratados como objetos.
2. Comportamento em relação a atribuição de valor: Como um tipo primitivo, **`int`** pode ser atribuído diretamente com um valor inteiro, por exemplo: **`int x = 10;`**. Já o **`Integer`** é uma classe e, portanto, requer a utilização de construtores ou métodos de fábrica para criar um objeto **`Integer`** a partir de um valor **`int`**, por exemplo: **`Integer y = Integer.valueOf(20);`**.
3. Nullability: Enquanto **`int`** é um tipo primitivo e não pode ser nulo, **`Integer`** é um objeto e pode receber o valor **`null`**. Isso pode ser útil em situações onde um valor opcional ou desconhecido precisa ser representado.
4. Autoboxing e Unboxing: Java fornece recursos de autoboxing e unboxing para permitir a conversão automática entre tipos primitivos e suas classes wrapper correspondentes. O autoboxing é a conversão automática de um tipo primitivo para a classe wrapper correspondente, por exemplo, **`Integer num = 5;`**. O unboxing é a conversão automática de um objeto wrapper para o tipo primitivo correspondente, por exemplo, **`int value = num;`**.
5. Uso em coleções genéricas: Em coleções genéricas, como listas ou mapas, apenas objetos podem ser armazenados. Portanto, quando você precisa armazenar valores inteiros em uma coleção, é necessário usar a classe **`Integer`** em vez do tipo primitivo **`int`**.

Em resumo, **`int`** é um tipo primitivo que representa números inteiros, enquanto **`Integer`** é uma classe wrapper que encapsula o tipo primitivo **`int`** e fornece funcionalidades adicionais, como a capacidade de ser nulo, métodos auxiliares e compatibilidade com coleções genéricas.

---
