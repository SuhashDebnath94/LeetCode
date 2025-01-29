package sorting;

public class N03_InsertionSort {
    public static void main(String[] args) {
        int[] arr = {3, 5, 2, 4, 15, 1};

        System.out.println(insertionSort(arr));
    }

    private static int[] insertionSort(int[] arr) {
        for (int i=0;i<=arr.length-1;i++){
            int j=i;
            while(j>0 && arr[j-1]>arr[j]){
                //swap
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
                j--;
            }
        }
        return arr;
    }

}
