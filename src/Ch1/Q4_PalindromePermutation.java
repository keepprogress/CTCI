package Ch1;

public class Q4_PalindromePermutation {

    public Boolean checkIfPalindromePermutation(String string) {
        int[] char_set = new int[128];
        int count = 0;
        for(int i = 0; i < string.length(); i++) {
                char_set[string.charAt(i)] = char_set[string.charAt(i)] + 1;
        };
        for(int j = 0; j < char_set.length; j++) {
            if(char_set[j] % 2 != 0) {
                count++;
            };
        };
        if(count == 1) {
            return true;
        };
        return false;
    }
}
