public class Placar {

    // TEM QUE TER:
    // -> FUNCOES DE GERAR PONTUACAO PARA AS POSICOES EXTERNAS
    // -> FUNCOES DE GERAR PONTUACAO PARA POSICOES INTERNAS


    //Atributos

    /* Tabuleiro vai armazenar os valores de cada posição
    * no placar do jogo. Tais posições são inicializadas com 0
    * e o jogo conta com 10 posições. */
    private final int[] tabuleiro;

    /* Tabuleiro lógico é uma lista de posições que representam
    * cada vértice do placar do jogo, assim como o atributo anterior,
    * porém, um valor lógico relativo se aquele já vértice foi ou não
    * escolhido pelo jogador*/
    private final boolean[] tabuleiro_logico;

    // MÉTODO CONSTRUTOR
    public Placar(){
        tabuleiro = new int[10];
        tabuleiro_logico = new boolean[10];
        for(int i = 0; i < 10; i++){
            tabuleiro[i] = 0;
            tabuleiro_logico[i] = false;
        }
    }

    // PÚBLICAS:

    /* É a função pública que, dado um objeto do tipo RolaDados
    * realiza a heurística de aferência da pontuação com base nas
    * regras do Bozó e adiciona tal valor à respectiva posição.
    * Para isso, gera dois vetores de "int" com base nos métodos de acesso
    * das informações pertencentes à classe RolaDados */
    public void add(int posicao, RolaDados dados){
        posicao--;

        int[] faces = dados.get_dado_lista();
        int[] frequencias = dados.get_frequencias_lista();

        if(posicao < 6){
            add_pontuacao_externa(posicao, faces);
        }else{
            add_pontuacao_interna(posicao, frequencias);
        }

    }

    @Override

    /* Retorna uma string relativa à disposição dos caracteres que representam o placar.
    * De forma que essa possa ser printada por outras classes ou funcionalidades.
    */
    public String toString() {
        String line1, line2, line3, line4, inter_line, inter_line_final;


        line1 = String.format("    %s    |    %s    |    %s    \n", string_vertice_tabuleiro(1),
                string_vertice_tabuleiro(7), string_vertice_tabuleiro(4));
        line2 = String.format("    %s    |    %s    |    %s     \n", string_vertice_tabuleiro(2),
                string_vertice_tabuleiro(8), string_vertice_tabuleiro(5));
        line3 = String.format("    %s    |    %s    |    %s    \n", string_vertice_tabuleiro(3),
                string_vertice_tabuleiro(9), string_vertice_tabuleiro(6));
        line4 = String.format("            |    %s    |         \n", string_vertice_tabuleiro(10));

        inter_line = "--------------------------------------\n";
        inter_line_final = "            +------------+        \n";

        return String.format("%s%s%s%s%s%s%s%s", line1, inter_line, line2, inter_line, line3,
                inter_line, line4, inter_line_final);
    }

    /* Retorna a pontuação geral armazenada nas posições já preenchidas do tabuleiro */
    public int get_pontuacao_geral(){
        int resultado = 0;
        for(int i = 0; i < 10; i++){
            if(tabuleiro_logico[i]) resultado += tabuleiro[i];
        }

        return resultado;
    }

    //PRIVADAS :

    /* - Verifica se a posição foi preenchida */
    private boolean posicao_preenchida(int posicao) { return tabuleiro_logico[posicao - 1]; }

    /* - Retorna uma string formatada com base no preenchimento do vértice, representando-o */
    private String string_vertice_tabuleiro(int posicao){
        posicao--;
        if(!tabuleiro_logico[posicao]){
            return String.format("(%02d)", posicao+1);
        }else{
            return String.format(" %02d ", tabuleiro[posicao]);
        }
    }

   /* - Métodos de verificação de pontuação para posições internas. */
    private int verifica_quadra(int[] contador_faces){
        for(int quantidade : contador_faces){
            if(quantidade == 4) return 30;
        }
        return 0;
    }
    private int verifica_quina(int[] contador_faces){
        for(int quantidade : contador_faces){
            if(quantidade == 5) return 40;
        }
        return 0;
    }

    private int verifca_fullHand(int[] contador_faces){
        boolean flag3, flag2, flag_5;
        flag3 = flag_5 = flag2 = false;

        for (int quantidade : contador_faces) {
            if (quantidade == 3) flag3 = true;
            else if (quantidade == 2) flag2 = true;
            else if (quantidade == 5) flag_5 = true;
        }
        if((flag3 && flag2) || flag_5) return 15;
        else return 0;
    }

    private int verifica_sequencia(int[] contador_faces){
        for (int quantidade : contador_faces){
            if(quantidade > 1) return 0;
        }
        return 20;
    }

    /* - Adiciona o valor relacionado à disposição dos dados para as respectivas
    * posições internas do tabuleiro.
    */
    private void add_pontuacao_interna(int posicao, int[] contador_faces ){

        int pontuacao;

        pontuacao = switch (posicao){
            case 6 -> verifca_fullHand(contador_faces);
            case 7 -> verifica_sequencia(contador_faces);
            case 8 -> verifica_quadra(contador_faces);
            case 9 -> verifica_quina(contador_faces);
            default -> 0;
        };

        tabuleiro[posicao] = pontuacao;
        tabuleiro_logico[posicao] = true;

    }

    /* - Adiciona o valor relacionado à disposição dos dados para as respectivas
     * posições externas do tabuleiro. Aqui a regra de pontuação é geral para cada casa
     * que pertença a esse conjunto.
     */
    private void add_pontuacao_externa(int posicao, int[] faces){

        for(int valor : faces) {
            if (posicao == valor - 1) tabuleiro[posicao] += valor;
        }

        tabuleiro_logico[posicao] = true;
    }


}
