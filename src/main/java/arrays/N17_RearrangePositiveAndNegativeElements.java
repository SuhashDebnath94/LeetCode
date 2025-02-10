package arrays;

public class N17_RearrangePositiveAndNegativeElements {
    /**
     * Given and array of equal number of positive and negative elements, give the resultant array such that it has alternate positive and negative elements
     * Make sure the order of positive and negative elements are maintained
     *
     * eg:
     *      {9, 7,-2, 5,-1, -3}
     * result:
     *      {9, -2, 7, -1, 5, -3}
     */

    public static void main(String[] args) {
        int[] arr={9, 7,-2, 5,-1, -3};
        System.out.println(rearrange(arr));
    }

    private static int[] rearrange(int[] arr) {
        int i=0;
        int j=1;
        int[] res=new int[arr.length];

        for(int k=0;k<arr.length;k++){
            if(arr[k]<0){
                res[j]=arr[k];
                j+=2;
            } else if (arr[k]>0) {
                res[i]=arr[k];
                i+=2;
            }
        }
        return res;
    }
}

