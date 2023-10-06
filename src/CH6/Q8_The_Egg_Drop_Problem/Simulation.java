package CH6.Q8_The_Egg_Drop_Problem;

public class Simulation {
    private static int breakingPoint = 89;
    private static int countDrops = 0;

    static boolean drop(int floor) {
        countDrops++;
        return floor >= breakingPoint;
    }

    static int findBreakingPoint(int floors) {
        // Since each drop of Egg1 takes one more step, Egg2 is allowed one fewer step.
        // we must reduce the number of steps potentially required by Egg2 by one drop each time.
        // For example, if Egg 1 is dropped on floor 20 and then floor 30,
        // Egg2 is potentially required to take 9 steps.
        // When we drop Egg1 again, we must reduce potential Egg2 step to only 8.
        // That is, we must drop Egg1 at floor 39.
        // Therefore, Egg1 must start at floor X, then go up by X-1 floors, then X-2,..., until it gets to 100.

        // x + (x-1) + (x-2) + (x-3) + .... + 1
        // x(x+1)/2>100
        // x > 13.65
        // when floor == 100, interval == 14
        int interval = 14;
        int previousFloor = 0;
        int egg1 = interval;

        /* Drop egg1 at decreasing intervals */
        while (!drop(egg1) && egg1 <= floors) {
            interval -= 1;
            previousFloor = egg1;
            egg1 += interval;
        }

        /* Drop egg2 at 1 unit increments */
        int egg2 = previousFloor + 1;
        while (egg2 < egg1 && egg2 <= floors && !drop(egg2)) {
            egg2 += 1;
        }

        /* If it didn't break, return -1 */
        return egg2 > floors ? -1 : egg2;
    }

    public static void main(String[] args) {
        int max = 0;
        for (int i = 1; i <= 100; i++) {
            countDrops = 0;
            breakingPoint = i;
            int bp = findBreakingPoint(100);

            if (bp == breakingPoint) {
                System.out.println("SUCCESS: " + i + " -> " + bp + " -> " + countDrops);
            } else {
                System.out.println("ERROR: " + i + " -> " + bp + " vs " + breakingPoint);
                break;
            }
            max = countDrops > max ? countDrops : max;
        }
        System.out.println(max);
    }
}
