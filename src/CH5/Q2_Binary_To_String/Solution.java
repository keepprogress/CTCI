package CH5.Q2_Binary_To_String;

public class Solution {
    public static String printBinary(double num) {
        if (num >= 1 || num < 0) {
            return "ERROR";
        }

        StringBuilder binary = new StringBuilder();
        while(num > 0) {
            /* Setting a limit on length: 32 characters */
            if (binary.length() > 32) {
                return "ERROR";
            }
            double r = num * 2;
            if (r > 1) {
                binary.append(1);
                num = r - 1;
            } else {
                binary.append(0);
                num = r;
            }
        }
        return binary.toString();
    }
}
