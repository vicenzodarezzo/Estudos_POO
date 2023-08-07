from Teste import Teste


n_gerentes = int(input("Insira o número de gerentes a serem incluídos "))
n_vendedores = int(input("Insira o número de vendedores a serem incluídos "))
n_assistentes = int(input("Insira o número de assistentes a serem incluidos "))

teste = Teste(n_assistentes + n_vendedores + n_gerentes)
teste.leitura(n_gerentes, n_vendedores, n_assistentes)
teste.print_folha_salarial()
