package Ch1;


/**
 *  requirement:
 *  Assume you have a method isSubstring which check
 *  if one word is a substring of another.
 *  Given two strings. s1 and s2, write code to check
 *  if s2 is a rotation of s1 using only one call
 *  to isSubstring (e.g "waterbottle" is a rotation of "erbottlewat").
 */

public class Q9_String_Rotation {
    public static void main(String[] args) {
        String s1="waterbottle!";
        String s2="erbottle!wat";
        System.out.println('"'+s1+'"'+" is a rotation of "+'"'+s2+'"'+": "+isRotation(s1,s2));
    }

    private static boolean isRotation(String s1, String s2) {
        if(s1.length() == s2.length() && s1.length() > 0) {
            /** Concatenate s2 and s2 **/
            String s2s2 = s2 + s2;
            return isSubstring(s2s2, s1);
        }
        return false;
    }

    private static boolean isSubstring(String longer, String shorter) {
        int count = 0;
        for(int i = 0; i < longer.length(); i++) {
            if(shorter.charAt(count) == longer.charAt(i)) {
                count++;
            } else {
                count = 0;
            }
            if (count == shorter.length() && count > 0){
                return true;
            }
        }
        return false;
    }
}

/**
 *   first thought:
 *   find the first char in s2
 *   then rebuild the s2 to be s1
 *   check if s2 is substring of s1
 *
 *   for every char in s2
 *      if(s2[i] == s1[0])
 *          if s2.substring(i).concat(s2.substring(0,i)) is substring of s1
 *          return true
 *   but this will have a problem if s1 have multiple duplicated first char
 *   then the for loop need check multiple times
 *
 *   improved thought:
 *   we can see origin String as xy, rotated String as yx
 *   in yxyx we can find xy once
 *   so just check if xy is substring in yxyx
 *
 */
