package strings;

import java.util.LinkedList;
import java.util.Stack;

public class N02_RemoveOutermostParenthesis {
    /**
     * A valid parentheses string is either empty "", "(" + A + ")", or A + B, where A and B are valid parentheses strings, and + represents string concatenation.
     *
     * For example, "", "()", "(())()", and "(()(()))" are all valid parentheses strings.
     * A valid parentheses string s is primitive if it is nonempty, and there does not exist a way to split it into s = A + B, with A and B nonempty valid parentheses strings.
     *
     * Given a valid parentheses string s, consider its primitive decomposition: s = P1 + P2 + ... + Pk, where Pi are primitive valid parentheses strings.
     *
     * Return s after removing the outermost parentheses of every primitive string in the primitive decomposition of s.
     *
     *
     *
     * Example 1:
     *
     * Input: s = "(()())(())"
     * Output: "()()()"
     * Explanation:
     * The input string is "(()())(())", with primitive decomposition "(()())" + "(())".
     * After removing outer parentheses of each part, this is "()()" + "()" = "()()()".
     * Example 2:
     *
     * Input: s = "(()())(())(()(()))"
     * Output: "()()()()(())"
     * Explanation:
     * The input string is "(()())(())(()(()))", with primitive decomposition "(()())" + "(())" + "(()(()))".
     * After removing outer parentheses of each part, this is "()()" + "()" + "()(())" = "()()()()(())".
     * Example 3:
     *
     * Input: s = "()()"
     * Output: ""
     * Explanation:
     * The input string is "()()", with primitive decomposition "()" + "()".
     * After removing outer parentheses of each part, this is "" + "" = "".
     *
     */

    public static void main(String[] args) {
        String input1="(()())(())";
        String input2="(()())(())(()(()))";
        String input3="()()";
        System.out.println(removeOuterMostParenthesis(input1));
    }

    private static String removeOuterMostParenthesis(String s) {
        Stack<Character> bracket = new Stack<>();
        StringBuilder sb = new StringBuilder("");
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                if(bracket.size()>0){
                    sb.append(s.charAt(i));
                }
                bracket.push(s.charAt(i));
            }else{
                bracket.pop();
                if(bracket.size()>0){
                    sb.append(s.charAt(i));
                }
            }
        }
        return sb.toString();
    }
}
