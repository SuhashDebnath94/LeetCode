package slidingWindow;

public class N02_PrintFirstNegativeNumberInWindowOfSizeK {
    public static void main(String[] args) {
        int[] arr={12, -1, -7, 8, -15, 30, 16, 28};
        int windowSize=3;

        printFirstNegatives(arr, windowSize);
    }

    private static void printFirstNegatives(int[] arr, int windowSize) {
        int i=0;
        int j=0;

        while(j< arr.length){
            if((j-i)+1<windowSize){
                j++;
            }
            else if((j-i)+1 == windowSize){
                for(int k=i;k<j;k++){
                    if(arr[k]<0){
                        System.out.println(arr[k]);
                        break;
                    }
                }
                i++;
                j++;
            }
        }
    }
}
