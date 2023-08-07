import java.util.Calendar;
public class RandomClass {
    
    // Atributos :
    private final long p ;
    private final long m ;
    private final long a ;
    private long seed;

    // Métodos
    public RandomClass(){
        p = 2147483648L;
        m = 843314861L;
        a = 453816693L;
        seed = Calendar.getInstance().getTimeInMillis() % p;
    }
    public void init_seed (long s) {
        seed = s ;
    }
    public double get_rand() {
        seed = (a + m * seed) % p;
        double out = seed ;
        return out / p ;
    }
    public int get_int_Rand(int max_n){
        double rand = get_rand() * max_n ;
        return (int) rand ;
    }
}
