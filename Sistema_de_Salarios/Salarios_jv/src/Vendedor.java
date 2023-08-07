public class Vendedor extends Funcionario{
    //ATRIBUTOS
    private final int coeficiente_salario;
    private final double comissao;
    //CONSTRUTOR
    public Vendedor(String nome, String cpf, double comissao_input) throws CPF_Invalido {
        super(nome, cpf);
        coeficiente_salario = 1;
        comissao = comissao_input;
    }

    @Override
    protected double calculaSalario() {
        return coeficiente_salario * get_salario_base() + comissao;
    }
}

