public class PiGenerator {
    public static int powerMod(int a, int b, int m){
        //Calculates (a^b) mod m where the squaring is done using the exponentiation by squaring algorithm
        return (int)(exp_by_squaring(a, b) % m);
    }
    public static double exp_by_squaring(double a, double b){
        //Calculates a^b using the exponentiation by squaring algorithm
        if (b < 0){
            return exp_by_squaring(1 / a, -b);
        }
        if (b == 0){
            return 1;
        }

        else if (b % 2 == 0){
            return exp_by_squaring(a * a, b / 2);
        }
        else {
            return a * exp_by_squaring(a * a, (b - 1) / 2);
        }
    }
}
