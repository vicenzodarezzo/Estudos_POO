public class RolaDados{

    //Atributos

    /* Um vetor de dados relativo ao conjunto deles que o jogador
    * interage. Eles são inicializados em 5 unidades no método
    * construtor. */
    private final Dado[] mao;
    int quantidade_dados;

    public RolaDados(){
        mao = new Dado[5];
        quantidade_dados = 5;
       for(int i = 0; i < quantidade_dados; i++){
           mao[i] = new Dado();
       }

    }

    /* Gera uma mão aleatória de 5 dados. */
    public void rolar_dados(){
        for(int i = 0; i < quantidade_dados; i++){
            mao[i].rolar();
        }
    }

    /* Altera pontualmente um dado, gerando um novo número para ele */
    public void rolar_pontual(int id_dado){
        mao[id_dado - 1].rolar();
    }

    /* Retorna uma lista de inteiros relativos aos valores de cada uma das faces
    * armazenadas pelo objeto. */
    public int[] get_dado_lista(){

        int[] faces = new int[quantidade_dados];

        for(int i = 0; i < quantidade_dados; i++){
            faces[i] = mao[i].get_lado();
        }
        return faces;
    }

    /* Retorna uma lista de inteiros relativos a quantas vezes cada valor aparece na
    * mão armazenada dentro do objeto. A posição x do vetor representa quantas vezes o
    * lado x aparece na mão;
    */
    public int[] get_frequencias_lista(){

        int[] frequencias = new int[6];

        for (int i : frequencias) frequencias[i] = 0;

        for(int i = 0; i < quantidade_dados; i++){
            frequencias[mao[i].get_lado() - 1]++;
        }
        return frequencias;
    }

    @Override
    public String toString(){

        String[] s = new String[quantidade_dados];

        for (int i = 0; i < quantidade_dados; i++) s[i] = mao[i].toString();

        StringBuilder retorno = new StringBuilder();

        retorno.append(" 1          2          3          4          5\n");
        for (int i = 0; i < quantidade_dados ; i++) {
            for (int j = 0; j < quantidade_dados; j++) {
                String substring = s[j].substring(i * 8, i * 8 + 7);
                retorno.append(substring).append("    ");
            }
            retorno.append("\n");
        }

        return retorno.toString();
    }

}
