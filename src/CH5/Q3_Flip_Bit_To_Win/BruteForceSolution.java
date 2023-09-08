package CH5.Q3_Flip_Bit_To_Win;

import java.util.ArrayList;

public class BruteForceSolution {

    public static int longestSequence(int n) {
        if (n == -1) return Integer.BYTES * 8;
        ArrayList<Integer> sequences = getAlternatingSequence(n);
        return findLongestSequence(sequences);
    }

    public static ArrayList<Integer> getAlternatingSequence(int n) {
        ArrayList<Integer> sequences = new ArrayList<>();

        int searchingFor = 0;
        int counter = 0;

        for (int i = 0; i < Integer.BYTES * 8; i++) {
            if ((n & 1) != searchingFor) {
                sequences.add(counter);
                searchingFor = n & 1; // Flip 0 to 1 or 1 to 0
                counter = 0;
            }
            counter ++;
            n >>>= 1;
        }
        sequences.add(counter);

        return sequences;
    }

    public static int findLongestSequence(ArrayList<Integer> seq) {
        int maxSeq = 1;

        for (int i = 0; i < seq.size(); i += 2) {
            int zerosSeq = seq.get(i);
            int onesSeqRight = i - 1 >= 0 ? seq.get(i - 1) : 0;
            int onesSeqLeft = i + 1 < seq.size() ? seq.get(i + 1) : 0;

            int thisSeq = 0;
            if (zerosSeq == 1) { // Can merge
                thisSeq = onesSeqLeft + 1 + onesSeqRight;
            } else if (zerosSeq > 0) { // Just add a zero to either side because according to the description we still have 1 zero to flip.
                thisSeq = 1 + Math.max(onesSeqLeft, onesSeqRight);
            } else { // No zero, but take either side
                thisSeq = Math.max(onesSeqLeft, onesSeqRight);
            }
            maxSeq = Math.max(thisSeq, maxSeq);
        }
        return maxSeq;
    }
}
