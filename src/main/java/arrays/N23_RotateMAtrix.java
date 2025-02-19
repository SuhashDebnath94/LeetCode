package arrays;

public class N23_RotateMAtrix {
//    Given a matrix, your task is to rotate the matrix 90 degrees clockwise.


//    Input: [[1,2,3],
//            [4,5,6],
//            [7,8,9]]
//
//    Output: [[7,4,1],
//            [8,5,2],
//            [9,6,3]]

    public static void main(String args[]) {
        int arr[][] = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};

        printRotate(arr, 3, 3);

    }

    private static void printRotate(int[][] arr, int height, int width) {

//        Take another dummy matrix of n*n,
//        and then take the first row of the matrix and put it in the last column of the dummy matrix,
//        take the second row of the matrix, and put it in the second last column of the matrix and so.
        int[][] res = new int[height][width];


        for (int j = width - 1; j >= 0; j--) {
            for (int i = 0; i < height; i++) {
                res[i][j] = arr[width-j-1][i];
            }
        }
        for (int i=0;i<res.length;i++){
            for (int j=0;j<res[0].length;j++){
                System.out.print(" "+ res[i][j]+" ");
            }
            System.out.println();
        }
    }

    /**
     How a Beginner Might Think About It (Brute Force)
     Create a new matrix of the same size.
     Place each element (i, j) from the original matrix into its new position in the rotated matrix:

     newMatrix[j][N−i−1]=matrix[i][j]
     Copy the new matrix back to the original one.
     ⏳ Time Complexity: O(N²) | 📦 Space Complexity: O(N²) (Extra matrix used)


     Instead of using extra space, we can rotate the matrix in two simple steps:

        Transpose the matrix → Convert rows into columns (swap matrix[i][j] with matrix[j][i]).
        Reverse each row → Swap left and right elements to get the 90° rotation.
     ⏳ Time Complexity: O(N²) | 📦 Space Complexity: O(1) (No extra storage needed)
     */
    public static void rotate(int[][] matrix) {
        int n = matrix.length;

        // Step 1: Transpose the matrix (swap matrix[i][j] with matrix[j][i])
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {  // Start from i+1 to avoid re-swapping
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 2: Reverse each row (swap left and right elements)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) { // Swap halfway
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = temp;
            }
        }
    }
}
