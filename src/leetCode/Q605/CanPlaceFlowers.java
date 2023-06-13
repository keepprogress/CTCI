package leetCode.Q605;

import java.util.Arrays;

public class CanPlaceFlowers {
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(flowerbed.length > 2) {
            for(int i = 0; i < flowerbed.length; i++) {
                //can place all situation
                // insert at i
                //   i
                // 0 0 0
                //   0 0
                //
                if(i == 0) {
                    if(flowerbed[0]!=1 && flowerbed[i+1] != 1) {
                        flowerbed[i] = 1;
                        n--;
                    }
                } else if (i == flowerbed.length-1) {
                    if(flowerbed[i-1] != 1 && flowerbed[i] != 1) {
                        flowerbed[i] = 1;
                        n--;
                    }
                } else {
                    if(i != 0 && flowerbed[i-1] !=1 && flowerbed[i] !=1 && flowerbed[i+1] != 1) {
                        flowerbed[i] = 1;
                        n--;
                    }
                }
                System.out.println("n in loop : " + n);
                System.out.println(Arrays.toString(flowerbed));
            }
        } else if(flowerbed.length ==2) {
            if(flowerbed[0] == 0 && flowerbed[1] == 0) {
                flowerbed[0] = 1;
                n--;
            }
        } else {
            if(flowerbed[0] == 0) {
                flowerbed[0] = 1;
                n--;
            }
        }

        System.out.println("n : " + n);
        if(n > 0) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] flower = {0};
        System.out.println(canPlaceFlowers(flower, 0));
    }
}
