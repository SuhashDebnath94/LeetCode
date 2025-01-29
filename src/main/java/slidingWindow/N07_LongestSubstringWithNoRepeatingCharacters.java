package slidingWindow;

import java.util.HashSet;

public class N07_LongestSubstringWithNoRepeatingCharacters {
    public static void main(String[] args) {
        String input = "boobies";
        System.out.println(longestSubstringWithNoRepeatingCharacters(input));
    }

    private static int longestSubstringWithNoRepeatingCharacters(String input) {
        int i=0;
        int j=0;

        HashSet<Character> set=new HashSet<>();
        int result=0;

        while(j<input.length()){
            if(!set.contains(input.charAt(j))){
                set.add(input.charAt(j));
                result=Math.max(result, set.size());
                j++;
            }
            else{
                while(set.contains(input.charAt(j))){
                    set.remove(input.charAt(i));
                    i++;
                }
            }
        }
        return result;
    }

}
