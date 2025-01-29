package bitManipulation;

import java.util.Stack;

public class N15_ReverseBits {

//    The problem is to reverse the bits of n and print the number obtained after reversing the bits.

    //    Example 1:
//    Input: 6
//    Output: 3
//    Explanation:
//            (6)10 = (110)2.
//    After reversing the bits we get:
//            (011)2 = (3)10.

    public static void main(String[] args) {
        System.out.println(reverseBits(6));
    }

    private static double reverseBits(int i) {
        if(i==0 || i == 1){
            return i;
        }
        Stack stack=new Stack();

        while(i!=0){
            stack.push(i%2);
            i=i/2;
        }
        int pow=0;
        double res=0;
        while(!stack.isEmpty()){
            int x= (int) stack.pop();
            res=res+x*Math.pow(2,pow);
            pow++;
        }
        return res;
    }
}
