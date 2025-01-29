package slidingWindow;

import java.util.HashMap;
import java.util.HashSet;

public class N06_LongestSubstringWithKUniqueCharacters {
    public static void main(String[] args) {
        String input = "aabacbcbebe";
        int k = 3;

        System.out.println(longestSubstringWithKUniqueChars(input, k));
    }

    private static int longestSubstringWithKUniqueChars(String input, int k) {
        int i = 0;
        int j = 0;
        int result = 0;

        HashMap<Character, Integer> map = new HashMap<>();
        while (j < input.length()) {
            if (map.containsKey(input.charAt(j))) {
                map.put(input.charAt(j), map.get(input.charAt(j)) + 1);
            } else {
                map.put(input.charAt(j), 1);
            }
            if (map.keySet().size()==k) {
               result=Math.max(result, (j-i)+1);
            } else if (map.keySet().size()>k) {
                while(map.keySet().size()>k){
                    if(map.get(input.charAt(i)) ==1) map.remove(input.charAt(i));
                    else map.put(input.charAt(i), map.get(input.charAt(i))-1);
                    i++;
                }
            }
            j++;
        }
        return result;
    }
}
