from Funcionario import Gerente, Assistente, Vendedor


class Teste:
    # CONSTRUTOR
    def __init__(self, n_funcionarios):
        self.funcionario = [None] * n_funcionarios

    # LEITURA
    def leitura(self, n_gerentes, n_vendedores, n_assistentes):
        contador = 0

        # leitura dos gerentes:
        flag_leitura = False
        while not flag_leitura and contador < n_gerentes:
            try:
                buffer_nome = input("Insira o nome do gerente a ser incluído.\n")
                buffer_cpf = input("Insira o cpf do gerente a ser incluído.\n")
                self.funcionario[contador] = Gerente(buffer_nome, buffer_cpf)
                flag_leitura = True
                contador = contador + 1
            except Exception as e:
                print(f"Erro {contador}:", str(e), "Tente novamente \n")

        # leitura dos vendedores:
        flag_leitura = False
        while not flag_leitura and contador < (n_gerentes + n_vendedores):
            try:
                buffer_nome = input("Insira o nome do vendedor a ser incluído.\n")
                buffer_cpf = input("Insira o cpf do vendedor a ser incluído.\n")
                buffer_comissao = float(input("Insira a comissão do vendendor a ser incluído\n"))
                self.funcionario[contador] = Vendedor(buffer_nome, buffer_cpf, buffer_comissao)
                flag_leitura = True
                contador = contador + 1
            except Exception as e:
                print(f"Erro {contador}:", str(e), "Tente novamente\n")

        # leitura dos assistentes:
        flag_leitura = False
        while not flag_leitura and contador < (n_gerentes + n_vendedores + n_assistentes):
            try:
                buffer_nome = input("Insira o nome do assistente a ser incluído.\n")
                buffer_cpf = input("Insira o cpf do assistente a ser incluído.\n")
                self.funcionario[contador] = Assistente(buffer_nome, buffer_cpf)
                flag_leitura = True
                contador = contador + 1
            except Exception as e:
                print(f"Erro {contador}:", str(e), "Tente novamente\n")

    # Impressão
    def print_folha_salarial(self):
        contador = 0
        for f in self.funcionario:
            print(f"funcionário {contador}:")
            print(str(f))
            contador = contador + 1
