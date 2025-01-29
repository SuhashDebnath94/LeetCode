package arrays;

public class N02_FindSecondLargest {
    public static void main(String[] args) {
        int[] arr={1,3,5,6,4,8};
        System.out.println(getSecondLargestElementOptimal(arr));
    }

    private static int getSecondLargestElement(int[] arr) {
        int largest=Integer.MIN_VALUE;
        for (int i=0;i<arr.length;i++){
            largest=Math.max(largest, arr[i]);
        }

        int secondLargest=Integer.MIN_VALUE;
        for (int i=0;i<arr.length;i++){
            if(arr[i] != largest){
                secondLargest=Math.max(secondLargest, arr[i]);
            }
        }

        return secondLargest;
    }

//    or

    private static int getSecondLargestElementOptimal(int[] arr) {
        int largest=arr[0];
        int secondLargest=Integer.MIN_VALUE;
        for (int i=1;i<arr.length;i++){
            if(arr[i]>largest){
                secondLargest=largest;
                largest=arr[i];
            }
        }
        return secondLargest;
    }

}
