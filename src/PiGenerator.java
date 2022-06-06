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
    public static int[] computePiInHex(int precision){
        int[] piInHex = new int[precision];
        for (int i = 0; i < precision; i++) {
            piInHex[i] = piDigit(i+1); // +1 to remove 3 from pi.
        }

        return piInHex;

    }

    /**
     * Computes the nth digit of Pi in base-16.
     *
     * If n < 0, return -1.
     *
     * @param n The digit of Pi to retrieve in base-16.
     * @return The nth digit of Pi in base-16.
     */
    public static int piDigit(int n) {
        if (n < 0) return -1;

        n -= 1;
        double x = 4 * piTerm(1, n) - 2 * piTerm(4, n) -
                piTerm(5, n) - piTerm(6, n);
        x = x - Math.floor(x);

        return (int)(x * 16);
    }

    private static double piTerm(int j, int n) {
        // Calculate the left sum
        double s = 0;
        for (int k = 0; k <= n; ++k) {
            int r = 8 * k + j;
            s += powerMod(16, n-k, r) / (double) r;
            s = s - Math.floor(s);
        }

        // Calculate the right sum
        double t = 0;
        int k = n+1;
        // Keep iterating until t converges (stops changing)
        while (true) {
            int r = 8 * k + j;
            double newt = t + Math.pow(16, n-k) / r;
            if (t == newt) {
                break;
            } else {
                t = newt;
            }
            ++k;
        }

        return s+t;
    }
}


