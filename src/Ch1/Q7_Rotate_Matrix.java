package Ch1;

public class Q7_Rotate_Matrix {
    boolean rotate(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length != matrix.length) return false;
        int n = matrix.length;
        for (int layer = 0; layer < n / 2; layer++) {
            int first = layer;
            int last = n - 1 - layer;
            for (int i = first; i < last; i++) {
                int offset = i - first;
                // save top
                int temp = matrix[first][i];

                // left -> top
                matrix[first][i] = matrix[last - offset][first];

                // bottom -> left
                matrix[last - offset][first] = matrix[last][last - offset];

                // right -> bottom
                matrix[last][last - offset] = matrix[i][last];

                // top -> right
                matrix[i][last] = temp;

            }
        }
        return true;
    }
}

//  O O O P
//  L C V P
//  L M K P
//  L G G G
