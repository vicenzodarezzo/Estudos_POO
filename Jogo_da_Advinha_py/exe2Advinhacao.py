from advinha import Advinha

obj = Advinha()

# Recebendo o delimitador do intervalo do usuário
str_entrada = "Insira o valor delimitador do intervalo : "
print(str_entrada)
d = int(input())
obj.set_delimitador_max(d)

# loop de advinhação

flag_advinhacao = False

while not flag_advinhacao:

    palpite = obj.gerar_palpite()

    str_palpite = f'O palpite gerado foi {palpite}\n'
    print(str_palpite)
    str_loop = """\tSe o número pensado for esse, digite 0
    Se for menor do que número pensado, digite 1
    Se for maior do que número pensando, digite 2\n"""

    flag_leitura = False

    while not flag_leitura:

        print(str_loop)
        # Verificando se o usuário não insere um caractere inválido
        try:
            resposta = int(input())
        except ValueError:
            print("Resposta inválida\n")
            continue

        if resposta == 0:
            print("O numero pensado foi %d\n" % palpite)
            flag_advinhacao = True
            flag_leitura = True

        elif resposta == 1:
            obj.set_delimitador_max(palpite)
            flag_leitura = True

        elif resposta == 2:
            obj.set_delimitador_min(palpite)
            flag_leitura = True
        else:
            # Verificando se o usuário não insere um número inválido
            print("Resposta inválida\n")
