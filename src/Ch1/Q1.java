package Ch1;

public class Q1 {
    // assuming the String is ASCII
    // assuming that there are 128 characters
    // cus you cannot form a unique String of 256 unique characters out of a 128-character alphabet

    boolean isUniqueChars(String str) {
        if (str.length() > 128) {
            return false;
        }

        boolean[] char_set = new boolean[128];
        for(int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if(char_set[val]) {
                return false;
            }
            char_set[val] = true;
        }
        return true;
    }

    // use bit vector to determining if all characters are unique
    public static boolean isUniqueCharsA(String str) {
        int checker = 0;
        for (int i = 0; i < str.length(); ++i) {
            int val = str.charAt(i) - 'a';
            if ((checker & (1 << val)) > 0) return false;
            checker |= (1 << val);
        }
        return true;
    }

    // walk through step by step
    // assuming that input string 'azya'

    //    string 'a'
    //
    //    a      =00000000000000000000000000000001
    //    checker=00000000000000000000000000000000
    //
    //    checker='a' or checker;
    //// checker now becomes = 00000000000000000000000000000001
    //    checker=00000000000000000000000000000001
    //
    //    a and checker=0 no dupes condition
    //    string 'az'
    //
    //    checker=00000000000000000000000000000001
    //    z      =00000010000000000000000000000000
    //
    //    z and checker=0 no dupes
    //
    //    checker=z or checker;
    //// checker now becomes 00000010000000000000000000000001
    //
    //    string 'azy'
    //
    //    checker= 00000010000000000000000000000001
    //    y      = 00000001000000000000000000000000
    //
    //    checker and y=0 no dupes condition
    //
    //            checker= checker or y;
    //// checker now becomes = 00000011000000000000000000000001
    //    string 'azya'
    //
    //    checker= 00000011000000000000000000000001
    //    a      = 00000000000000000000000000000001
    //
    //    a and checker=1 we have a dupe
    //    Now, it declares a duplicate
}
