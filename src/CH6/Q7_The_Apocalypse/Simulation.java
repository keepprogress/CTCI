package CH6.Q7_The_Apocalypse;

import java.util.Random;

public class Simulation {
    public static void main(String[] args) {
        System.out.println(runNFamilies(1000000));
    }

    private static double runNFamilies(int n) {
        int boys = 0;
        int girls = 0;
        for (int i = 0; i < n; i++) {
            int[] genders = runOneFamily();
            girls += genders[0];
            boys += genders[1];
        }
        return girls / (double) (boys + girls);
    }

    private static int[] runOneFamily() {
        Random random = new Random();
        int boys = 0;
        int girls = 0;
        while (girls == 0) {
            if (random.nextBoolean()) {
                girls += 1;
            } else {
                boys += 1;
            }
        }
        int[] genders = {girls, boys};
        return genders;
    }
}
