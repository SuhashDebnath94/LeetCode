package recursion;

public class Recursion01 {
//    Recursion is when a function calls itself till a certain condition is met
//    void f(i){
//        print(i);
//        void f(i);
//    }

//    this will end up calling infinitely resulting in stack overflow.

//    so we write a base condition which will stop execution
//    a recursion tree is the heirarchy of calls
//  stack space is taken when a function is waiting

    public static void main(String[] args) {
        int num=5;
        System.out.println(printFactorial(num));

    }

    private static int printFactorial(int num) {
        if(num==1){
            return 1; //base condition;
        }
        else{
            return num*printFactorial(num-1);
        }
    }
}
