package DP;

public class MaximumFallingPathSum {
    /**
     * Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.
     *
     * A falling path starts at any element in the first row and chooses the element in the next row that is either directly below or diagonally left/right.
     * Specifically, the next element from position (row, col) will be (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).
     */


    public static void main(String[] args) {
        int[][] matrix={
                {2, 1, 3},
                {6, 5, 4},
                {7, 8, 9}
        };
        long start = System.nanoTime();
        System.out.println(getMaximumPath(matrix));
        long end = System.nanoTime();
        System.out.println("Program takes " + (end - start) + " nano-seconds");
    }

    private static int getMaximumPath(int[][] matrix) {
        int max=Integer.MIN_VALUE;
        for (int j=0;j<matrix[0].length;j++){
            max=Math.max(max, getMaximumPath(matrix, 0, j));

        }
        return max;
    }

    private static int getMaximumPath(int[][] matrix, int i, int j) {
        if(i==matrix.length-1){
            return matrix[matrix.length-1][j];
        }
        int down=matrix[i][j]+getMaximumPath(matrix, i+1, j);
        int downRight=Integer.MIN_VALUE;
        if(j<matrix[0].length-1){
            downRight=matrix[i][j]+getMaximumPath(matrix, i+1, j+1);
        }
        int downLeft=Integer.MIN_VALUE;
        if(j>0) {
            downLeft = matrix[i][j] + getMaximumPath(matrix, i + 1, j - 1);
        }

        return Math.max(Math.max(down, downRight), downLeft);
    }
}
