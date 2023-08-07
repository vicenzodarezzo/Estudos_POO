# Herança

> Intuitivamente, herança é o conceito que nos permite criar classes mais específicas a partir de classes mais primitivas - genéricas, de forma que aquelas herdem atributos e métodos dessa. Chamamos a classe herdada de Superclasse.
> 

É importante ressaltar que a classe filha pode não só continuar mas também alterar a sua superclasse dentro de seu escopo.

# 1 - Herança Simples : presente nas duas linguagens

---

<aside>
📖 **JAVA**

</aside>

## Declaração

Ao criar uma classe, se queremos construí-la como uma subclasse de outra, precisamos demarcar a herança logo em sua declaração. fazemos isso através do operador `extends`

```nasm
public class Subclasse extends Superclasse {}
```

Porém, para garantir a hereditariedade, não basta a declaração do objeto. Precisamos instanciar tal propriedade em sua construção

## Construção

Se temos um objeto da subclasse, podemos acessar seus atributos herdados, desde que esses sejam inicializados corretamente dentro do programa criado. 

Para isso, é necessário que a criação da subclasse utilize os métodos de construção da superclasse, criando portanto o objeto específico da superclasse que está abstraído dentro do objeto atual.

Por exemplo, no seu construtor, para que uma subclasse inicialize seus parâmetros herdados, é necessário que esse método invoque o método construtor da classe extendida. Para isso, podemos utilizar o método `super()` que referência o construtor da superclasse.

```java
public class Superclasse {
	int x ;

	public Superclasse(int x){
		this.x = x;
	}
}

public class Subclasse extends Superclasse {
	public Subclasse(int x){
		super(x);
	}
}

-> Subclasse a = Subclasse(x);
-> a.x -> x 
```

### Boas práticas

Para que os atributos da superclasse não se misturem com os atributos da subclasse, é interessante criar métodos que controlem esse tipo de camada. De forma que, caso queria acessar um atributo herdado dentro de um método, referencie esse acesso através de um método de acesso declarado na superclasse.

## Modificações na Superclasse

Uma subclasse também pode reescrever uma método de sua superclasse utilizando um caso específico de sobrecarga, o `@Override`. Este indicativo antes de uma função indica que a respectiva função sobrescreve uma função de mesma assinatura na classe primitiva, dentro do escopo da subclasse.

Logo, sempre que a subclasse referenciar tal método, a implementação utilizada será a indicada para pela flag.

Lembremos que essa sobrescrita acontece somente para os objetos da subclasse. A superclasse e suas demais herdeiras continuam com a implementação anterior.

---

<aside>
📖 ************PYTHON************

</aside>

Primeiro de tudo, vale dizer que toda implementação de um objeto em python é subclasse de uma classe originária `Object` . Logo, a herança simples é intrínseca para qualquer criação de objetos na linguagem.

Como é um padrão, não precisamos referenciá-la.

Entretanto, ao implementar heranças próprias, precisamos instanciar a relação de hierarquia logo na definição da assinatura do objeto, incluído o nome da superclasse estendida dentro de parênteses junto à instanciação.

```java
class Superclasse :
	pass

class Subclasse(Superclasse) :
	pass
```

# Acesso e modificações em python

> Na implementação da linguagem, diferentemente de Java, os métodos e atributos dos objetos são livres. De forma que, no caso da herança simples, eu consiga acessar qualquer método ou atributo da superclasse sem instanciar seus métodos assessores ou construtores.
> 

Entretanto, por boas práticas, é sempre interessante definir a hierarquia e as fronteiras entre a camada da superclasse e da subclasse através de métodos construtores e assessores.

Veja :

### Método que funciona, porém não leva em consideração as boas práticas

```java
class ex :
  def __init__(self, a) :
    self.a = a

class sub(ex) :
  def __init__(self, b) :
    self.a = b

veremos = sub(11)
print(veremos.a)

-> 11
```

### Método que leva em consideração as boas práticas :

Nesse caso, utilizamos a referência super() para acessar a superclasse, podendo acessar seus métodos, como o construtor.

```java
class ex :
  def __init__(self, a) :
    self.a = a

class sub(ex) :
  def __init__(self, b) :
    super().__init__(b)

veremos = sub(11)
print(veremos.a)

-> 11
```

---

# Herança Múltipla :

> herança múltipla é a capacidade de uma classe de herdar mais de uma superclasse, ou seja, ser resultado da herança de mais de uma classe primitiva. Esse conceito é complexo por poder acarretar em problemas, que serão discutidos aqui.
> 

Se referindo à Herança Múltipla por categoria, dentre as duas linguagens, somente Python tem suporte ao conceito

Em Java, essa funcionalidade é tratada dentro do tópico de interfaces, evitando esses problemas.

```python
class SuperclasseA :
	pass

class SuperclasseB :
	pass

class Subclasse(SuperclasseA, SuperclasseB) :
	pass
```

## Problema 1 : referência não unitária a métodos

Imagine que as superclasse possuem métodos com uma mesma assinatura, o que é completamente possível pois podem ser herdadas de uma mesma classe e modificarem um método desta ou simplesmente serem independentes entre si. Ao referenciar esse método em um objeto da subclasse, qual dos métodos seria invocado?

### MRO

Na implementação da linguagem, em um caso como esse, o interpretador leva em consideração a MRO - Method Resolution Order. Isto é, uma convenção implementa da linguagem que ordena as heranças de uma classe

Podemos obter essa ordem no programa via o método `.mro` que retorna uma lista de métodos main das classes ordenadas, indicando a ordenação

A ordem é feita com base em uma busca de profundidade no grafo de herança, partindo da subclasse chamada e, dentro de uma classe, bifurcando a busca com base na ordem de declaração da classe.

![Captura de Tela 2023-06-28 às 18.31.29.png](Heranc%CC%A7a%206b73807a8a974ef8aac4028f5a61470f/Captura_de_Tela_2023-06-28_as_18.31.29.png)

### Chamada de construtores.

Veja que, ao utilizar o comando `super()` também teríamos a inconsistência de qual classe estamos acessando. Logo, a resolução da linguagem é : ao utilizar o comando super(), os métodos assessores das superclasses são acessados na ordem inversa do MRO. Porém, para garantir a execução correta de todos eles, precisamos que tenham os mesmos parâmetros.
