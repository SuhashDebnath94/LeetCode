package blind75.matrix;

public class RotateMAtrix {
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
}
