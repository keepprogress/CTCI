package CH5.Q4_Next_Number;

public class BruteForceSolution {

    public static int getNext(int n) {
        /* Compute c0 and c1
        * c0 is the number of zeros to the right of p.
        * c1 is the number of ones to the right of p.
        * p is the position of right most non-trailing zero = c0 + c1 */
        int c = n;
        int c0 = 0;
        int c1 = 0;

        /* find zeros first then find ones */
        while (((c & 1) == 0) && (c != 0)) {
            c0++;
            c >>= 1;
        }

        while ((c & 1) == 1) {
            c1++;
            c >>= 1;
        }

        /* Error: if n = 11..1100...00, then there is no bigger number with the same
         * number of 1s.
         * c0 + c1 = 31 means that 32 bits number have no right most non-trailing zero */
        if (c0 + c1 == 31 || c0 + c1 == 0) {
            return -1;
        }

        int p = c0 + c1;// position of right most non-trailing zero

        n |= (1 << p); // flip right most non-trailing zero
        n &= ~((1 << p) - 1); // clear all bits to the right of p
        n |= (1 << (c1 - 1)) -1; // insert (c1-1) ones on the right

        return n;
    }
}
