package blind75.matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
//    Given a Matrix, print the given blind75.matrix in spiral order.
//    Example 1:
//    Input: Matrix[][] = { { 1, 2, 3, 4 },
//        { 5, 6, 7, 8 },
//        { 9, 10, 11, 12 },
//        { 13, 14, 15, 16 } }

    //    Outhput: 1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10.
    public static void main(String args[]) {
        int arr[][] = {  {1, 2, 3, 4},
                         {5, 6, 7, 8},
                         {9, 10, 11, 12},
                         {13, 14, 15, 16}};

        printSpiral(arr, 4, 4);

    }

    private static void printSpiral(int[][] arr, int height, int width) {

//        algo:
//            set 4 boundaries
//        Top = 0
//        Right = n-1
//        Bottom = p-1
//        left=0
//        add from left to right
//        increment top
//        add top to bottom
//        decrement right
//        add from right to left
//        decrement bottom
//        add bottom to top
//        increment left
//        do this in loop till all elements are not exhausted ie bottom = top and left = right


        List<Integer> res=new ArrayList<>();
        int top=0;
        int right = arr[0].length-1;
        int bottom = arr.length-1;
        int left = 0;

        while(left<right && top<bottom){
//            print elements from left to right
            for(int i=left;i<=right;i++){
                res.add(arr[top][i]);
            }
            top++;
            for(int i= top;i<=bottom;i++){
                res.add(arr[i][right]);
            }
            right--;
            for(int i=right;i>=left;i--){
                res.add(arr[bottom][i]);
            }
            bottom--;
            for(int i=bottom;i>=top;i--){
                res.add(arr[i][left]);
            }
            left++;
        }

        res.stream().forEach(e -> System.out.print(" "+e+" "));

    }

    private static void printSpiralWrong(int[][] arr, int rows, int columns) {
        for(int i=0;i<rows;i++){
            if(i%2==0){
                for(int j=0;j<columns;j++){
                    System.out.print(" "+arr[i][j]+",");
                }
            }
            else{
                for(int j=columns-1;j>=0;j--){
                    System.out.print(" "+arr[i][j]+",");
                }
            }
        }
    }
}

