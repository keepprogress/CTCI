package CH5.Q8_Draw_Line;

public class Solution {
    void drawLine(byte[] screen, int width, int x1, int x2, int y) {
        // if startOffset is not zero, then firstFullByte needs to be incremented
        // we assume that firstFullByte will be next byte
        int startOffset = x1 % 8;
        int firstFullByte = x1 / 8;
        if (startOffset != 0) {
            firstFullByte++;
        }

        // if endOffset is not 7, then lastFullByte needs to be decremented
        // we assume that lastFullByte will be previous byte
        int endOffset = x2 % 8;
        int lastFullByte = x2 / 8;
        if (endOffset != 7) {
            lastFullByte--;
        }

        // Set full bytes
        // when x1 and x2 are in the same byte, this will not be executed
        // ex: x1 = 3, x2 = 5
        // firstFullByte = 1, lastFullByte = -1
        // so this will not be executed
        for (int b = firstFullByte; b <= lastFullByte; b++) {
            screen[(width / 8) * y + b] = (byte) 0xFF;
        }

        // Create masks for start and end of line
        // assume x1 = 3, x2 = 5
        // startOffset = 3, endOffset = 5
        // startMask = 11111111 >> 3 = 00011111
        // endMask =~ (11111111 >> 6) = ~00000011 = 11111100
        // mask = 00011111 & 11111100 = 00011100
        byte startMask = (byte) (0xFF >> startOffset);
        byte endMask = (byte) ~(0xFF >> (endOffset + 1));

        // Set start and end of line
        if ((x1 / 8) == (x2 / 8)) { // If x1 and x2 are in the same byte
            byte mask = (byte) (startMask & endMask);
            screen[(width / 8) * y + (x1 / 8)] |= mask;
        } else {
            // if startOffset != 0, the start of line is in the previous byte of firstFullByte
            if (startOffset != 0) {
                int byteNumber = (width / 8) * y + firstFullByte - 1;
                screen[byteNumber] |= startMask;
            }
            // if endOffset != 7, the end of line is in the next byte of lastFullByte
            if (endOffset != 7) {
                int byteNumber = (width / 8) * y + lastFullByte + 1;
                screen[byteNumber] |= endMask;
            }
        }
    }
}
