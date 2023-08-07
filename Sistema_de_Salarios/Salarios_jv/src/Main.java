import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        int n_gerentes, n_vendedores, n_assistentes;
        Scanner scanner1 = new Scanner(System.in);

        System.out.println("Insira o número de gerentes que você quer inserir no sistema:");
        n_gerentes = Teste.teste_leitura_nextInt(scanner1);
        System.out.println("Insira o número de assistentes que você quer inserir no sistema:");
        n_assistentes = Teste.teste_leitura_nextInt(scanner1);
        System.out.println("Insira o número de vendedores que você quer inserir no sistema:");
        n_vendedores = Teste.teste_leitura_nextInt(scanner1);


        Teste teste = new Teste(n_assistentes + n_vendedores + n_gerentes);
        teste.leitura_teste(n_gerentes, n_vendedores, n_assistentes);
        teste.print_folha_salarial();

        scanner1.close();
    }
}