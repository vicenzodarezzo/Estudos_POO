import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        Scanner scanner1 = new Scanner(System.in);
        Senha senha = new Senha() ;

        System.out.println("Bem vindo ao jogo da senha\nInsira o número que delimita o intervalo de advinhação:");
        boolean flag_leitura = false ;

        // Inicializando o intervalo para que o jogo determine a senha ;

        while(!flag_leitura){
            try{
                int n = scanner1.nextInt() ;
                flag_leitura = true ;
                senha.set_delimitador(n) ;
            }catch(java.util.InputMismatchException e) {
                System.out.print("Número inválido, tente novamente:");
                scanner1.nextLine();
            }
        }

        // Dando início ao loop de tentativas
        senha.jogo_advinhacao();
    }
}