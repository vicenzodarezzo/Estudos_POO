# Abstração e Estaticidade

# Estaticidade

> Estaticidade é uma propriedade que diz respeito a associações de membros (atributos ou métodos) a uma classe, de forma que, não precisemos inicializar um objeto na classe para executar ou acessar o membro, e sim simplesmente referencia-lo através da classe
> 

## Atributos estáticos

Seriam atributos que não dizem respeito ao objeto, e sim sobre a classe, de forma que ele nada tenha a ver com o método construtor. Logo, ele será compartilhado entre todos os objetos daquela classe,

## Métodos estáticos

Seriam métodos que dizem respeito à classe e nada dependem do objeto em si. Também sendo comum e compartilhado entre os objetos.

## Relação entre membros estáticos e membros dinâmicos

Membros dinâmicos seriam os não estáticos - construídos e relacionados ao objeto. Como o objeto pertence a classe e se relaciona com ela, não há problema em chamar ou acessar membros estáticos dentro de métodos dinâmicos, porém a recíproca não é válida, pois o objeto depende da classe e a classe não depende do objeto.

## Implementações

### Java

A referência a esse tipo de membro deve ser feita sem inicializar um objeto, apenas referenciando a classe.

em java, para criar membros estáticos, basta adicionar a notação `static` junto da declaração:

```python
class Classe{

	private static int Valor;
	public static int leInt() {}

}

int y = Classe.leInt() ;
int x = Classe.valor
```

### Python

Em python as coisas são um pouco diferentes.

Primeiro que os métodos e atributos estáticos podem ser referenciados a partir da classe ou do objeto. 

Segundo, ela implementa um outro tipo de método.

- ********Método estático :********  relativo a sua classe de declaração, porém não acessa os valores e informações pertencentes nela.
    - É implementado com uma flag de `@staticmethod`
        
        ```python
        class super_class:
           'Essa é a super classe'
           @staticmethod
           def m():
               print(super_class.__doc__)
        class sub_class(super_class):
           'Essa é a sub classe'
        
        -> super_class.m -> 'Essa é a super classe'
        -> sub_class.m -> 'Essa é a super classe'
        ```
        
- ****************************************Método de classe :**************************************** relativo à classe passada como parâmetro, portanto, acessa os valores e informações pertencentes nela, além de variar sua execução conforme o parâmetro - que é a classe onde ele é implementada
    - É implementado com `@classmethod`
    
    ```python
    class super_class:
       'Essa é a super classe'
       @classmethod
       def m(cls):
           print(cls.__doc__)
    class sub_class(super_class):
       'Essa é a sub classe'
    
    -> super_class.m -> 'Essa é a super classe'
    -> sub_class.m -> 'Essa é a sub classe'
    ```
    

# Abstração

> A abstração de membros representa a mplementação de modelos, de forma que esses modelos possam ser continuados e reescritos conforme suas heranças. Logo, através dele, podemos criar padrões de implementação para heranças, garantindo a forma de seus filhos.
> 

## Métodos abstratos dentro de uma classe

Tendo em vista a criação de objetos segundo um padrão, podemos utiliza a estratégia de uma superclasse contendo métodos abstratos, de forma que essa superclasse represente o modelo que será continuado e implementado por suas subclasses. Dessa forma, garantimos:

- A implementação obrigatória das assinaturas abstratas da superclasse nas subs
- Que a classe que contém o método abstract não será instanciada
- Toda subclasse do modelo que não implementa o método também deve ser abstrata

## Implementação em Java

A referência à abstração em java é dado pelo operador `abstract` posicionado dentro de uma assinatura de classe ou método.

*Uma classe que contém um método abstrato deve obrigatoriamente ser abstrata*

Para implementar métodos abstratos, basta nomear sua assinatura

## Implementação em Pyhton

Em python, a implementação da abstração é dependente da classe ABC do módulo abc que disponibiliza a flag `@abstractmethod`.

Portanto, para implementar uma abstração, devemos criar uma classe que herda ABC e possuí um método com a flag.

```python
from abc import ABC, abstractmethod

class Abstract(ABC) :
	@abstractmethod
	def metodo(a, b, c) : pass
```
