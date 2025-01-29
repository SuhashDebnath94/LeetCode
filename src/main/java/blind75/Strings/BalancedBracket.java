package blind75.Strings;

import java.util.Stack;

public class BalancedBracket {

//    Problem Statement: Check Balanced Parentheses. Given string str containing just the characters ‘(‘, ‘)’, ‘{‘, ‘}’, ‘[‘ and ‘]’, check if the input string is valid and return true if the string is balanced otherwise return false.
//
//    Note: string str is valid if:
//
//    Open brackets must be closed by the same type of brackets.
//    Open brackets must be closed in the correct order.
//
//            Input: str = “( )[ { } ( ) ]”
//
//    Output: True
//
//    Explanation: As every open bracket has its corresponding
//    close bracket. Match parentheses are in correct order
//    hence they are balanced.

    public static void main(String[] args) {

        String s = "()[{}()]";
        if (isValidPrac(s) == true)
            System.out.println("True");
        else
            System.out.println("False");
    }

    //    create stack
//    if opening then put into stack
//    if closing check if stack is empty
//    if empty then return false
//    if not empty then pop
//    check if popped element is opposite
//    if not return false
//    do this till string end
//    check if stack is empty
    public static boolean isValid(String s) {
        Stack<Character> st = new Stack<Character>();
        for (char it : s.toCharArray()) {
            if (it == '(' || it == '[' || it == '{')
                st.push(it);
            else {
                if (st.isEmpty()) return false;
                char ch = st.pop();
                if ((it == ')' && ch == '(') || (it == ']' && ch == '[') || (it == '}' && ch == '{')) continue;
                else return false;
            }
        }
        return st.isEmpty();
    }

    public static boolean isValidPrac(String input){
        Stack<Character> stack= new Stack<>();
        for(char i: input.toCharArray()){
            if(i=='(' || i=='{' || i=='['){
                stack.push(i);
            }
            else {

                    if (stack.isEmpty()) return false;
                    char ch=stack.pop();
                    if((i==')' && ch=='(')||(i=='}' && ch=='{')||(i==']' && ch=='[')) continue;
                    else return false;

            }
        }

        return stack.isEmpty();

    }
}
