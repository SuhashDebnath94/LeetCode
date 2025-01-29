package blind75.Binary;

public class SumOf2Integers {
//    Given two integers a and b, return the sum of the two integers without using the operators + and -.

//    Logic?
//        do a xor on each item
//    but also take care of the carry over
//    so to do that we do a & and we shift it to the left
//    1001 ^1011 = 0010
//    1001 & 1011 = 1001 we left shift it so it becomes 10010
//    we do this till the first number becomes 0 which means there is no carry
//    10010 ^ 1011 = 10000
//    10010 & 1011 = 00010 we left shift this so it becomes 00100
//    00100 ^ 10000 = 10100
//    00100 & 10000 = 00000 which is 0 so we have no carry over
//    so the result is 10100
//    which is 20 which is our answer

    public static void main(String[] args) {
        System.out.println(getSum2(13,10));
    }

    public static int getSum(int a, int b) {
        return a==0 ? a^b : getSum((a&b)<<1,a^b);
    }

    public static int getSum2(int a, int b) {
        if(a==0){
            return a^b;
        }
        else{
            return getSum2((a&b)<<1,a^b);
        }
    }

    public static int getSumIncr(int a, int b){
        for(int i=1; i<=b;i++){
            a++;
        }
        return a;
    }
}
