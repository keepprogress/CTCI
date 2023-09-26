package CH5.Q6_Conversion;

public class OptimalSolution {
    public static int bitSwapRequired(int a, int b) {
        int count = 0;
        // a ^ b will give the different bits
        // c & (c - 1) will clear the least significant bit
        for (int c = a ^ b; c != 0; c = c & (c - 1)) {
            count++;
        }
        return count;
    }
}
