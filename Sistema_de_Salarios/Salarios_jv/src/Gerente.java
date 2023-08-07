public class Gerente extends Funcionario {

    //ATRIBUTOS
    private final int coeficiente_salario;

    //CONSTRUTOR
    public Gerente(String nome, String cpf) throws CPF_Invalido {
        super(nome, cpf);
        coeficiente_salario = 2;
    }

    @Override
    protected double calculaSalario() {
       return coeficiente_salario * get_salario_base();
    }
}
