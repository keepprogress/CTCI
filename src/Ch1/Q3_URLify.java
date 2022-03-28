package Ch1;

public class Q3_URLify {
    void replaceSpaces(char[] str, int trueLength) {
        int spaceCount = 0, index, i = 0;
        for(i = 0; i < trueLength; i++) {
            if(str[i] == ' ') {
                spaceCount++;
            }
        }
        // triple spaceCount to meet the need
        index = trueLength + spaceCount * 2;
        for(i = trueLength; i >= 0; i--) {
            if(str[i] == ' ') {
                str[index - 1] = '0';
                str[index - 2] = '2';
                str[index - 3] = '%';
                index -= 3;
            } else {
                str[index -1] = str[i];
                index -= 1;
            }
        }
    }
}
