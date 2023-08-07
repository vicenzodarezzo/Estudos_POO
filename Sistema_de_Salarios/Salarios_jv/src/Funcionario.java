public abstract class Funcionario {

    //ATRIBUTOS
    public String nome;
    public String cpf;
    protected double salario_base;

    //CONSTRUTOR
    public Funcionario(String nome_input, String cpf_input) throws CPF_Invalido{
        nome = nome_input;
        cpf = cpf_input;
        if(!verificaCPF(cpf)) throw new CPF_Invalido("O CPF inserido é inválido\n");
        salario_base = 2000;
    }

    //MÉTODOS DE ACESSO
    protected double get_salario_base(){
        return salario_base;
    }
    public String get_nome(){
        return nome;
    }
    public String get_CPF(){
        return cpf;
    }

    //MÉTODO DE IMPRESSÃO

    @Override
    public String toString() {
        return String.format("Nome: %s\nCPF :%s\nSalário: %f\n", get_nome(), get_CPF(), calculaSalario());
    }

    //MÉTODOS ABSTRATOS
    protected abstract double calculaSalario();

    //MÉTODOS ESTÁTICOS
    static boolean verificaCPF(String cpf){

        int[] multiplicadores = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};
        int soma = 0;
        int valor_char;
        int resto;

        //VERIFICAÇÃO DO PRIMEIRO DÍGITO DE CONTROLE

        // primeira interação: realiza a soma
        for(int i = 0;  i < 9;  i++){
            valor_char = Character.digit(cpf.charAt(i), 10);

            soma = soma + valor_char * (multiplicadores[i] - 1);
        }

        // verifica o módulo
        resto = (soma*10) % 11;
        if(resto == 10) resto = 0;

        if(resto != Character.digit(cpf.charAt(9), 10)) return false;

        //VERIFICAÇÃO DO SEGUNDO DÍGITO DE CONTROLE
        soma = 0;

        // primeira interação: realiza a soma incluindo o primeiro dígito de controle
        for(int i = 0;  i < 10;  i++){
            valor_char = Character.digit(cpf.charAt(i), 10);
            soma = soma + valor_char * (multiplicadores[i]);

        }

        // verifica o módulo
        resto = (soma*10) % 11;
        if(resto == 10) resto = 0;

        //FINALIZAÇÃO
        return resto == Character.digit(cpf.charAt(10), 10);
    }

}


