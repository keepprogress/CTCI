package Ch1;

public class Q8_Zero_Matrix {
    void setZeros(int[][] matrix) {
        boolean[] row = new boolean[matrix.length];
        boolean[] columns = new boolean[matrix[0].length];

        // flag 0 value in row and columns
        for(int i = 0; i < row.length; i++) {
            for(int j = 0; j < columns.length; j++) {
                if(matrix[i][j] == 0) {
                    row[i] = true;
                    columns[j] = true;
                }
            }
        }

        // nullify rows
        for(int i = 0; i < row.length; i++) {
            if(row[i]) {
                nullifyRows(matrix, i);
            }
        }

        // nullify columns
        for(int j = 0; j < columns.length; j++) {
            if(columns[j]) {
                nullifyColumns(matrix, j);
            }
        }
    }

    void nullifyRows(int[][] matrix, int row) {
        for(int i = 0; i < matrix[0].length; i++) {
            matrix[row][i] = 0;
        }
    }

    void nullifyColumns(int[][] matrix, int col) {
        for(int j = 0; j < matrix.length; j++) {
            matrix[j][col] = 0;
        }
    }
}
