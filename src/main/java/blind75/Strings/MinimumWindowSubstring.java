package blind75.Strings;

//
//Given two strings s and t of lengths m and n respectively, return the minimum window
//        substring
//        of s such that every character in t (including duplicates) is included in the window.
//        If there is no such substring, return the empty string "".
//
//        The testcases will be generated such that the answer is unique.

//        Input: s = "ADOBECODEBANC", t = "ABC"
//        Output: "BANC"
//        Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    public static void main(String[] args) {
        System.out.println(minimumWindow("ADOBECODEBANC", "ABC"));
    }

    private static String minimumWindow(String input, String target) {
        if (target.equals("")) return "";
        Map<Character, Integer> targetWindow = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < target.toCharArray().length; i++) {
            if (targetWindow.containsKey(target.charAt(i))) {
                targetWindow.put(target.charAt(i), targetWindow.get(target.charAt(i)) + 1);
            } else {
                targetWindow.put(target.charAt(i), 1);
            }
        }
        int have = 0;
        int need = targetWindow.keySet().size();
        int[] result = new int[2];
        int resultLength = Integer.MAX_VALUE;
        int left = 0;
        for (int right = 0; right < input.length(); right++) {
            Character currentCharacter = input.charAt(right);
            if (window.containsKey(currentCharacter)) window.put(currentCharacter, window.get(currentCharacter) + 1);
            else {
                window.put(currentCharacter, 1);
            }
            if (target.contains(String.valueOf(currentCharacter)) && window.get(currentCharacter) == targetWindow.get(currentCharacter)) {
                have += 1;
            }
            while (have == need) {
                if (right - left + 1 < resultLength) {
                    result[0] = left;
                    result[1] = right;
                    resultLength = right - left + 1;
                }
//             now we want the window to be as small as possible so we pop from the left
                window.put(input.charAt(left), window.get(input.charAt(left)) - 1);
                if (target.contains(String.valueOf(input.charAt(left))) && window.get(input.charAt(left)) < targetWindow.get(input.charAt(left))) {
                    have = have - 1;
                }
                left = left + 1;
            }
        }
        return input.substring(result[0], result[1] + 1);
    }

//    private static String minimumWindow(String input, String target) {

//        int need=target.length();
//        int have=0;
//        HashMap<Character, Integer> map=new HashMap();
//
//        for(int i=0;i<target.length();i++){
//            if(map.keySet().contains(target.charAt(i))){
//                map.put(target.charAt(i), map.get(target.charAt(i))+1);
//            }
//        }
//
//        for(int i=0;i<input.length();i++){
//
//        }

//    }

//    lets have 2 variables : have and need
//    we will have 2 hash maps
//'one will contain all the characters of the target which we need and the occurences of these characters'
//    'another will contain the characters of our substring as we move'
//    'for each charater we check if the character is present in need hashmap and if the value is equal to the value of our hashmap'
//    'if yes we increment the have value'
//    'when have is equals to need we have our  first possible substring'
//    'we store its length in a variable'

//    'then we start popping elements from the front till our have = need is not met'
//    once it is not met we add to the end again one by one till its met
//    'once it is met we check if the length of the substring is less than the min value previously set if yes we set it as the new value'
//    'if no then we repeat by popping elemnets from the start again'
//    if at any point of removing the length of have = need is equal to minimum value we update the minimum value

//    do this till the end index cant be expanded any more

}
