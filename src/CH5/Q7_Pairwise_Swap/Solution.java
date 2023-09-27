package CH5.Q7_Pairwise_Swap;

public class Solution {
    public static int swapOddEvenBits(int x) {
        /** use the logical right shift, instead of the arithmetical right shift.
         * This is because we want the sign bit to be filled with a zero
          **/
        return (((x & 0xaaaaaaaa) >>> 1) | ((x & 0x55555555) << 1));
    }
}
