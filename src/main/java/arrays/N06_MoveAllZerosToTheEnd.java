package arrays;

public class N06_MoveAllZerosToTheEnd {
    public static void main(String[] args) {
        Integer[] arr={0,1,2,4,2,0,1,2,3,7,0,1,4,0,0,0,4,5};
        ArrayUtil.printAllElements(moveZerosToTheEnd2(arr));
    }

    private static int[] moveZerosToTheEnd(int[] arr) {
        int low=0;
        int high=arr.length-1;

        while(arr[high]==0){
            high--;
        }

        while(low<high){
            if(arr[high]==0){
                high--;
                continue;
            }
            if(arr[low]==0) {
                arr[low] = arr[high];
                arr[high] = 0;
                high--;
            }
            low++;
        }

        return arr;
    }

    //OR
    private static Integer[] moveZerosToTheEnd2(Integer[] arr){
        int j=-1;
        for (int i=0;i<arr.length;i++){
            if(arr[i]==0){
                j=i;
                break;
            }
        }
        for (int i=j+1;i<arr.length;i++){
            if(arr[i]!=0){
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                j++;
            }
        }
        return arr;
    }

}
