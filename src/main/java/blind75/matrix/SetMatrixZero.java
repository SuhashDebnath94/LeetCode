package blind75.matrix;

import java.util.Arrays;

public class SetMatrixZero {

//    Given a blind75.matrix if an element in the blind75.matrix is 0 then you will have to set its entire column and row to 0 and then return the blind75.matrix.

//    Examples 1:
//
//    Input: blind75.matrix=[[1,1,1],[1,0,1],[1,1,1]]
//
//    Output: [[1,0,1],[0,0,0],[1,0,1]]
//
//    Explanation: Since blind75.matrix[2][2]=0.Therfore the 2nd column and 2nd row wil be set to 0.

    public static void main(String args[]) {
        int arr[][] = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        setZeroes(arr);
        System.out.println("The Final Matrix is ");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void setZeroes(int [][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        int dummy1[] = new int[rows];
        int dummy2[] = new int[cols];

        Arrays.fill(dummy1,-1);
        Arrays.fill(dummy2,-1);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    dummy1[i] = 0;
                    dummy2[j] = 0;
                }
            }

        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dummy1[i] == 0 || dummy2[j]==0) {
                    matrix[i][j] = 0;
                }
            }
        }

    }
}
