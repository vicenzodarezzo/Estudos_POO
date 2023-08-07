
import java.util.Scanner;


public class Senha {
    // Atributos :
    private int senha ;
    private int tentativas = 0 ;
    private boolean advinhou  = false;
    private final RandomClass rdm;
    Scanner scanner = new Scanner(System.in);

    public Senha() {
        rdm = new RandomClass();
    }

    // Métodos :

    public void set_delimitador(int del){
        rdm.init_seed(1023) ;
        senha = rdm.get_int_Rand(del) ;
        System.out.printf("Numero gerado %d\n", senha );
    }

    public void comparar_palpite(int palpite){
        if(palpite > senha){
            System.out.print("O palpite é maior do que à senha gerada\n") ;
            tentativas++;
        } else if (palpite < senha) {
            System.out.print("O palpite é menor do que à senha gerada\n") ;
            tentativas++;
        } else {
            System.out.print("O palpite é igual à senha gerada\n") ;
            advinhou = true;
        }
    }

    public void jogo_advinhacao(){
        while(!advinhou){
            boolean flag_leitura = false ;
            // loop para garantir a leitura do palpite, pois o scanner pode lançar excessões
            while(!flag_leitura){
                try{
                    System.out.print("Insira seu palpite: ") ;
                    flag_leitura = true;
                    comparar_palpite(scanner.nextInt());
                }catch(java.util.InputMismatchException e){
                    System.out.print("Inteiro inserido inválido\n") ;
                    scanner.nextLine();
                }
            }
        }
        System.out.printf("Parabéns, você advinhou com %d tentativas", tentativas) ;
    }
}
