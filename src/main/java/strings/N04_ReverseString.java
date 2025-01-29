package strings;

public class N04_ReverseString {
//    Write a function that reverses a string. The input string is given as an array of characters s.
//
//    You must do this by modifying the input array in-place with O(1) extra memory.

    public static void main(String[] args) {
        String arr="hello";
        reverse(arr.toCharArray());
    }

    private static char[] reverse(char[] arr) {
        int low=0;
        int high=arr.length-1;

        while(low<high){
            char temp=arr[high];
            arr[high]=arr[low];
            arr[low]=temp;
            low++;
            high--;
        }
        return arr;
    }

}
