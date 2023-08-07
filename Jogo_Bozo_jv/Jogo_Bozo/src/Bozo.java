import java.util.Scanner;
public class Bozo {

    // Atributos
    RolaDados dados;
    Placar placar;
    int contador_rodadas;
    static Scanner scanner;

    // Método construtor;
    public Bozo(){
        dados = new RolaDados();
        placar = new Placar();
        scanner = new Scanner(System.in);
        contador_rodadas = 0;
    }

    // Método de interface de jogo :
    public void main(){
        boolean flag_rolar_dados;
        int posicao;

        // Início do Jogo:
        System.out.println("Bem vindo ao jogo Bozó\nAperte ENTER para iniciar e ver o placar:");
        scanner.nextLine();
        System.out.print(placar.toString());

        while (contador_rodadas++ < 10){

            flag_rolar_dados = true;

            System.out.printf("****** Rodada %d\nAperte ENTER para lançar os dados:", contador_rodadas);
            scanner.nextLine();


            //Gerando a mão inicial:

            dados.rolar_dados();
            System.out.printf(dados.toString());

            //Verificando se o usuário gostaria de trocar algum dos dados:
            for (int i = 0; i < 2 && flag_rolar_dados; i++){

                System.out.print("Digite o número dos dados que quiser trocar, separados por espaço.\nSe não quiser, digite ENTER.\n");

                String linha = scanner.nextLine();

                Scanner read_line = new Scanner(linha);

                aferencia:
                if(read_line.hasNextInt()){

                    while(read_line.hasNextInt()){
                        int n = read_line.nextInt();
                        if(n > dados.quantidade_dados || n < 1){
                            System.out.print("Número digitado inválido. Insira um novo número no intervalo correto\n");
                            System.out.print(dados.toString());
                            read_line.close();
                            linha = scanner.nextLine();
                            read_line = new Scanner(linha);
                        }
                        else dados.rolar_pontual(n);
                    }
                    System.out.printf(dados.toString());

                } else { flag_rolar_dados = false; }

                read_line.close();
            }

            // Escolha da posição desejada no tabuleiro
            System.out.print(placar.toString());
            System.out.print("Escolha a posição a ocupar com essa jogada ===> ");
            posicao = scanner.nextInt();
            while(posicao > 10 || posicao < 1){
                if(scanner.hasNextLine()) scanner.nextLine();
                System.out.print("Número inválido, insira uma posição correspondente ao tabuleiro ===> ");
                posicao = scanner.nextInt();
            }
            System.out.print("\n");
            placar.add(posicao, dados);
            System.out.print(placar.toString());

            // Limpa a memória temporária para a próxima interação
            if(scanner.hasNextLine()) scanner.nextLine();
        }

        // Calcula a pontuação final:
        System.out.printf("""
                ****************************s**
                *********
                ********* Seu Score final foi : %d
                *********
                ******************************
                """, placar.get_pontuacao_geral());

    }

    public void close(){
        scanner.close();
    }
}