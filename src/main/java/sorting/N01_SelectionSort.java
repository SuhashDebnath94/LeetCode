package sorting;

public class N01_SelectionSort {
    public static void main(String[] args) {
        int[] arr = {3, 5, 7, 8, 15, 1};

        System.out.println(selectionSort(arr));
    }

    private static int[] selectionSort(int[] arr) {
        for(int i=0;i<= arr.length-2;i++){
            int minimum=i;
            for (int j=i;j<=arr.length-1;j++){
                if(arr[minimum]> arr[j]) minimum=j;
            }
            //swap i and j
            int temp=arr[i];
            arr[i]=arr[minimum];
            arr[minimum]=temp;
        }
        return arr;
    }
}
