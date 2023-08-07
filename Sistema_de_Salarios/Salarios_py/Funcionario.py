from abc import ABC, abstractmethod


# -> CLASSE DE EXCESSÃO
class CPF_invalido(Exception):
    pass


# -> SUPER CLASSE ABSTRATA
class Funcionario(ABC):

    # CONSTRUTOR
    def __init__(self, nome, cpf):
        self.nome = nome
        self.cpf = cpf
        if not self.verifica_cpf(cpf):
            raise CPF_invalido("CPF inserido não é válido\n")
        self._salarioBase = 2000

    @abstractmethod
    def calcula_salario(self):
        pass

    # ACESSORES
    def get_nome(self):
        return self.nome

    def get_cpf(self):
        return self.cpf

    def _get_salario(self):
        return self._salarioBase

    # IMPRESSÃO
    def __str__(self):
        returned_string = f"Nome:{self.nome}\nCPF:{self.cpf}\nSalário:{self.calcula_salario()}\n"
        return returned_string

    # VERIFICADOR DE CPF

    @staticmethod
    def verifica_cpf(cpf):
        multiplicadores = [11, 10, 9, 8, 7, 6, 5, 4, 3, 2]
        soma = 0

        # Verificação do primeiro dígito de controle;
        for i in range(0, 9):
            soma = soma + int(cpf[i]) * (multiplicadores[i] - 1)

        resto = (soma * 10) % 11
        if resto == 10:
            resto = 0

        if resto != int(cpf[9]):
            return False

        # Verificação do segundo dígito de controle:

        soma = 0

        for i in range(0, 10):
            soma = soma + int(cpf[i]) * multiplicadores[i]

        resto = (soma * 10) % 11
        if resto == 10:
            resto = 0

        if resto != int(cpf[10]):
            return False
        else:
            return True


# -> SUB CLASSES

class Gerente(Funcionario):

    # CONSTRUTOR
    def __init__(self, nome, cpf):
        super().__init__(nome, cpf)
        self.multiplicador_salario = 2

    # OVER RIDE
    def calcula_salario(self):
        return self.multiplicador_salario * self._get_salario()


class Assistente(Funcionario):

    # CONSTRUTOR
    def __init__(self, nome, cpf):
        super().__init__(nome, cpf)
        self.multiplicador_salario = 1

    # OVER RIDE
    def calcula_salario(self):
        return self.multiplicador_salario * self._get_salario()


class Vendedor(Funcionario):

    # CONSTRUTOR
    def __init__(self, nome, cpf, comissao_input):
        super().__init__(nome, cpf)
        self.multiplicador_salario = 1
        self.comissao = comissao_input

    # OVER RIDE
    def calcula_salario(self):
        return self.multiplicador_salario * self._get_salario() + self.comissao
