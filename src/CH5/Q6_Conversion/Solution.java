package CH5.Q6_Conversion;

public class Solution {
    public static int countDifferentBits(int n1, int n2) {
        int count = 0;
        int diff = n1 ^ n2;
        while (diff > 0) {
            if ((diff & 1) == 1) {
                count++;
            }
            diff >>= 1;
        }
        return count;
    }

    /*    11001
    * XOR 01011
    * ----------
    *     10010
    * count 1 in the result is the amount need to be flipped  */
}
