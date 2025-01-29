package stack;

public class N03_FindNextGreaterElement {
    /**
     * Find the next greater element of an array:
     *  So if array is:
     *          3   10  4   2   1   2   6   1   7   2   9
     *  Answer will be
     *          10  -1  6   6   2   6   7   7   9   9   10
     *
     *  If elements at the end is exhausted go back to front
     *  If there are no greater elements put -1
     *
     *  Soln:
     *      1) Create a stack
     *      2) Start with pointer in last element (9 in this case)
     *          Check if stack end element is smaller than 9
     *              if yes(while smaller-> stack.pop)
     *              if no
     *                  Add stack last element to new array
     *                  add the current element to stack
     *              move pointer to previous element
     *              If the stack is is empty and current element is not tehe last element, put -1.
     */

    public static void main(String[] args) {
        int[] arr={3,10,4,2,1,2,6,1,7,2,9};
        System.out.println(getNGe(arr));
    }

    private static int[] getNGe(int[] arr) {
        int[] nge=new int[arr.length];
        Stack<Integer> stack=new Stack<>();

        for (int i=0;i<((2*arr.length)-1);i++){
            while (stack.getSize()!=0 && stack.peek()<=arr[i% arr.length]){
                stack.pop();
            }
            if (i< arr.length){
                if(stack.size!=0){
                    nge[i]=stack.peek();
                }
                else {
                    nge[i]=-1;
                }
            }
            stack.push(arr[i% arr.length]);
        }
        return nge;
    }
}
