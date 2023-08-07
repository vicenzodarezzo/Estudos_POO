

public class Dado{

    // Atributos :
    private int resultado ;
    private static RandomClass random;

    // Métodos
    public Dado(){
         random = new RandomClass();
    }

    public void rolar(){
        // the get_int_Rand returns a number in [0, max), so, it's mandatory to add 1 to the returned value;
        resultado = 1 + random.get_int_Rand(6);
    }

    public int get_lado(){
        return resultado;
    }

    @Override
    public String toString() {
        String s = "";

        if (resultado == 1) {
            s += "+-----+\n";
            s += "|     |\n";
            s += "|  *  |\n";
            s += "|     |\n";
            s += "+-----+\n";
        }
        else if (resultado == 2) {
            s += "+-----+\n";
            s += "|*    |\n";
            s += "|     |\n";
            s += "|    *|\n";
            s += "+-----+\n";
        }
        else if (resultado == 3) {
            s += "+-----+\n";
            s += "|*    |\n";
            s += "|  *  |\n";
            s += "|    *|\n";
            s += "+-----+\n";
        }
        else if (resultado == 4) {
            s += "+-----+\n";
            s += "|*   *|\n";
            s += "|     |\n";
            s += "|*   *|\n";
            s += "+-----+\n";
        }
        else if (resultado == 5) {
            s += "+-----+\n";
            s += "|*   *|\n";
            s += "|  *  |\n";
            s += "|*   *|\n";
            s += "+-----+\n";
        }
        else if (resultado == 6) {
            s += "+-----+\n";
            s += "|*   *|\n";
            s += "|*   *|\n";
            s += "|*   *|\n";
            s += "+-----+\n";
        }

            return s;
    }
}