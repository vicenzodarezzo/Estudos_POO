// Classe de excessão utilizada para construir um funcionário verificando a validade do cpf inserido
public class CPF_Invalido extends Exception {
    public CPF_Invalido(String mensagem) {
        super(mensagem);
    }
}