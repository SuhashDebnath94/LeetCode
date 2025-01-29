package strings;

public class N07_ReverseInteger {
//    Given a signed 32-bit integer x, return x with its digits reversed.
//    If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

    public static void main(String[] args) {
        System.out.println(reverseInteger(123));
    }

    private static int reverseInteger(int num) {
        int res=0;

        boolean isNegative = num<0;

        String temp=String.valueOf(isNegative? String.valueOf(num).substring(1): num);

        String str=String.valueOf(reverseString(temp.toCharArray()));

        if(Long.valueOf(str)<Integer.MAX_VALUE && Long.valueOf(str)>Integer.MIN_VALUE){
            res=Integer.valueOf(str);
        }

        if(isNegative){
            res=Math.negateExact(res);
        }

        return res;
    }

    private static char[] reverseString(char[] arr) {
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
