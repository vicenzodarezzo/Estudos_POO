import java.util.InputMismatchException;
import java.util.Scanner;
public class Teste {
    Funcionario[] funcionarios;
    Scanner scanner;

    //CONSTRUTOR
    public Teste(int n_funcionarios){
        funcionarios = new Funcionario[n_funcionarios];
        scanner = new Scanner(System.in);
    }

    public void leitura_teste(int n_gerentes, int n_vendedores, int n_assistentes){

        String buffer_nome;
        String buffer_CPF;
        double buffer_comissao;
        boolean flag_leitura;

        for(int i = 0; i < n_gerentes; i++){
            flag_leitura = false;
            while(!flag_leitura){
                try{
                    System.out.print("Insira o nome e o Cpf do gerente a ser incluído, um em cada linha\n");
                    buffer_nome = scanner.nextLine();
                    buffer_CPF = scanner.nextLine();
                    funcionarios[i] = new Gerente(buffer_nome, buffer_CPF);
                    flag_leitura = true;
                }catch (CPF_Invalido e){
                    System.out.println("CPF inserido inválido, tente outro CPF.");
                    scanner.nextLine();
                }catch (InputMismatchException e){
                    System.out.println("Input inserido inválido, tente novamente.");
                    scanner.nextLine();
                }
            }
        }


        for(int i = n_gerentes; i < n_gerentes + n_assistentes; i++){
            flag_leitura = false;
            while(!flag_leitura){
                try{
                    System.out.print("Insira o nome e o Cpf do assistente a ser incluído, um em cada linha\n");
                    buffer_nome = scanner.nextLine();
                    buffer_CPF = scanner.nextLine();
                    funcionarios[i] = new Assistente(buffer_nome, buffer_CPF);
                    flag_leitura = true;
                }catch (CPF_Invalido e){
                    System.out.println("CPF inserido inválido, tente outro CPF.");
                    scanner.nextLine();
                }catch (InputMismatchException e){
                    System.out.println("Input inserido inválido, tente novamente.");
                    scanner.nextLine();
                }
            }
        }

        for(int i = (n_gerentes + n_assistentes); i < (n_gerentes + n_assistentes + n_vendedores); i++) {
            flag_leitura = false;
            while (!flag_leitura) {
                try {
                    System.out.print("Insira o nome, o Cpf e a comissão do vendedor a ser incluído, um em cada linha\n");
                    buffer_nome = scanner.nextLine();
                    buffer_CPF = scanner.nextLine();
                    buffer_comissao = scanner.nextDouble();
                    funcionarios[i] = new Vendedor(buffer_nome, buffer_CPF, buffer_comissao);
                    flag_leitura = true;
                }catch (CPF_Invalido e){
                    System.out.println("CPF inserido inválido, tente outro CPF.");
                    scanner.nextLine();
                }catch (InputMismatchException e){
                    System.out.println("Input inserido inválido, tente novamente.f");
                    scanner.nextLine();
                }
            }
        }
        scanner.close();
    }

    public void print_folha_salarial(){
        int contador = 0 ;
        for(Funcionario f : funcionarios){
            System.out.printf("Funcionário %d :\n", contador);
            contador++;
            System.out.println(f.toString());
        }
    }

    public static int teste_leitura_nextInt(Scanner scanner1){
        int returned_value = 0;
        boolean control_flag = false;
        while (!control_flag){
            try{
                returned_value = scanner1.nextInt();
                control_flag = true;
            }catch(InputMismatchException e){
                System.out.println("Número inserido inválido, tente novamente");
                scanner1.nextLine();
            }
        }
        return returned_value;
    }

}
