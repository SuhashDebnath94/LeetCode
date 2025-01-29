package blind75.Binary;

public class NumberOf1Bits {
//    Write a function that takes an unsigned integer and returns the number of '1' bits it has (also known as the Hamming weight).

    public static void main(String[] args) {
        System.out.println(count1BitsMe(15));
        System.out.println(count_setbits(15));
    }

    private static int count1BitsMe(int n) {
        int sum = 0;
        if(n==1){
            return n;
        }
        else{
            sum = sum + n%2;
            return sum+count1BitsMe(n/2) ;
        }
    }

    public static int count_setbits(int N)
    {
        int cnt=0;

        while(N>0)
        {
            cnt+=(N&1);
            N=N>>1;
        }

        return cnt;
    }
}
