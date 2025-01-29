package arrays;

public class ArrayUtil {
    public static void printAllElements(Object[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                System.out.print(" " + arr[i] + ",");
            }
        }
    }
}
