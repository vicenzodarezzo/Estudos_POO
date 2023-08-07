# Genéricos - Polimorfismo Paramétrico (1)

> Implementações genéricas são aquelas que utilizam em suas implementações um tipo genérico, que será definido na passagem de parâmetros durante a instanciação.
> 

# Caso base : polimorfismo de coerção

Sabemos que o polimorfismo de coerção é um polimorfismo do tipo ad-hoc e exige um conjunto de detalhes de implementação e utilização que ficam a cargo do programador, como realizar corretamente os castings, não confundir objetos de tipos diferentes e etc…

### Por exemplo : **************Implementando uma pilha universal (JAVA)**************

Ao implementar uma pilha universal, podemos utilizar o polimorfismo de coerção realizando o código em cima da classe `Object`, que é superclasse de todas as outras. 

Ao incluir, não necessariamente precisaria fazer o casting, pelo fato de que estamos transmitindo a informação de uma subclasse para a superclasse, papel que o próprio compilador pode realizar  pois há menos risco de truncamento.

Entretanto, ao retirar informações da pilha, a coerção de Object para sua subclasse não é trivial para o compilador por culpa da possibilidade de truncamento, logo, fica a cargo do programador realizar corretamente todos os castings.

# Solução : tipos como parâmetros

Para construir um tipo genérico, em sua assinatura, devemos declarar um tipo genérico que será utilizado na implementação. E, na hora da instanciação, esse tipo deve ser passado como parâmetro.

## Em java - Uma pilha genérica uniforme :

### Observações:

- Ao declarar e referenciar, pode-se utilizar diretamente o tipo genérico, porém, ao inicializar, deve ser utilizada a coerção do `Object`.
- Podemos utilizar, ao invés de um só tipo, uma restrições de tipos com base em uma hierarquia. Se utilizamos `< T extends X >` fazemos com que a pilha aceito todo tipo que seja subclasse de X.

```python
public class Pilha <T> {
	T[] lista;
	int topo;
	public Pilha(int n){
		lista = (T[]) Object[n];
	}

	public void push (T a){
		lista[topo++] = a
	}
}
```
