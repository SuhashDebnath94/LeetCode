package sorting;

public class N02_BubbleSort {
    public static void main(String[] args) {
        int[] arr = {3, 5, 7, 8, 15, 1};

        System.out.println(bubbleSort(arr));
    }

    private static int[] bubbleSort(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }
}
