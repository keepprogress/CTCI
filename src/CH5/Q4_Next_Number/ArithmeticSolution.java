package CH5.Q4_Next_Number;

public class ArithmeticSolution {

    public static int getNextArith(int n) {
        /* ... same calculation for c0 and c1 as before */
        /* Compute c0 and c1 */
        int c = n;
        int c0 = 0;
        int c1 = 0;
        while(((c & 1) == 0) && (c != 0)) {
            c0++;
            c >>= 1;
        }

        while ((c & 1) == 1) {
            c1++;
            c >>= 1;
        }

        /* Error: if n == 11..1100..00, then there is no bigger number with the same number of 1s. */
        if (c0 + c1 == 31 || c0 + c1 == 0) {
            return -1;
        }

        // n += 2^c0 -1 => Set trailing 0s to 1, giving us p trailing 1s
        // n += 1  => Flip first p 1s to 0s, and put a 1 at bit p
        // n += 2^(c1-1) -1 => Set trailing c1 - 1 0s to 1s.
        // next = n + 2^c0 -1 + 1 + 2^(c1-1) -1
        //      = n + 2^c0 + 2^(c1-1) -1
        return n + (1 << c0) + (1 << (c1 - 1)) - 1;
    }

    int getPrevArith(int n) {
        /* Compute c0 and c1 */
        int temp = n;
        int c0 = 0;
        int c1 = 0;
        while ((temp & 1) == 1) {
            c1++;
            temp >>= 1;
        }
        if (temp == 0) return -1;

        while (((temp & 1) == 0) && (temp != 0)) {
            c0++;
            temp >>= 1;
        }
        // assume n = 10000011
        // n -= 2^c1 -1 => Set trailing 1s to 0s. n is now 10000000
        // n -= 1 => Flips trailing 0s to 1s. n is now 01111111
        // n -= 2^(c0-1) -1 => Flips last (c0-1) 0s. n is now 01110000

        return n - (1 << c1) - (1 << (c0 - 1)) + 1;
    }
}
