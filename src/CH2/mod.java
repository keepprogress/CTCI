package CH2;

public class mod {
    public static void main(String[] args) {
        System.out.println(Math.floorMod(3,8));
        System.out.println(Math.floorMod(8,3));
    }

    // if k = 8
    // circle length = 3
    // and slow runner is 0 step into loop
    // then fast runner is mod(8,3) = 2 step into loop => denote as K

    // following is facts
    // 1. slow runner is 0 step into loop
    // 2. fast runner is K step into loop
    // 3. slow runner is K

    // if k = 3
    // circle length = 8
    // and slow runner is 0 step into loop
    // then fast runner is mod(3,8) = 3 step into loop => denote as K

}
