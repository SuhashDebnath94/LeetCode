package arrays;

public class N04_CheckIfArrayIsSorted {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5};
        System.out.println(checkIfArrayISSorted(arr));
    }

    private static boolean checkIfArrayISSorted(int[] arr) {
        for(int i=1;i<arr.length;i++){
            if(arr[i]<arr[i-1]){
                return false;
            }
        }
        return true;
    }
}
