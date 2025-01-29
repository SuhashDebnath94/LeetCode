package arrays;

public class N01_FindLargestElementInArray {
    public static void main(String[] args) {
        int[] arr={1,3,5,6,4,2};
        System.out.println(getLargestElement(arr));
    }

    private static int getLargestElement(int[] arr) {
        int res=Integer.MIN_VALUE;
        for (int i=0;i<arr.length;i++){
            res=Math.max(res, arr[i]);
        }
        return res;
    }

    //Or

    //Sort array and get the last element.

}
