package Ch1;

public class Q6_String_Compression {
    String compress(String str) {
        StringBuilder compressed = new StringBuilder();
        int countConsecutive = 0;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) != str.charAt(i+1) || i+1 > str.length()) {
                compressed.append(str.charAt(i));
                compressed.append(countConsecutive);
                countConsecutive = 0;
            }
        }
        return str.length() > compressed.length() ? compressed.toString() : str;
    }
}
