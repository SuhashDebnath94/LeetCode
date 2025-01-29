package blind75.Strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeating {
//    Given a String, find the length of longest substring without any repeating character.
//    Example 1:
//
//    Input: s = ”abcabcbb”
//
//    Output: 3
//
//    Explanation: The answer is abc with length of 3.

    static int solveBrute(String str) {

        if(str.length()==0)
            return 0;
        int maxans = Integer.MIN_VALUE;
        for (int i = 0; i < str.length(); i++) // outer loop for traversing the string
        {
            Set< Character > se = new HashSet< >();
            for (int j = i; j < str.length(); j++) // nested loop for getting different string starting with str[i]
            {
                if (se.contains(str.charAt(j))) // if element if found so mark it as ans and break from the loop
                {
                    maxans = Math.max(maxans, j - i);
                    break;
                }
                se.add(str.charAt(j));
            }
        }
        return maxans;

//        Time complexity O(n^2)
    }

//    use hash set
//    take two pointer l and r both starting at 0
//    initialize length as 0
//    check if l is prestnt in hashset if not put it in hashset which would mean current range l-r has repeating charcters
//    update length as l-r +1 which is 0-0+1= 1

//    do this till the element is found in hashset
//    wen found
//    remove A[l] from the set
//    l=l+1
//    do l-r +1 and if it is greater than current length update length, otherwise dont
//    push A[l] into the set
    static int solve(String str) {

        if(str.length()==0)
            return 0;
        int maxans = Integer.MIN_VALUE;
        Set < Character > set = new HashSet < > ();
        int l = 0;
        for (int r = 0; r < str.length(); r++) // outer loop for traversing the string
        {
            if (set.contains(str.charAt(r))) //if duplicate element is found
            {
                while (l < r && set.contains(str.charAt(r))) {
                    set.remove(str.charAt(l));
                    l++;
                }
            }
            set.add(str.charAt(r));
            maxans = Math.max(maxans, r - l + 1);
        }
        return maxans;

//        time complexity: O(2n)
    }

    static int solveOptimal(String s) {
        HashMap < Character, Integer > mpp = new HashMap< Character, Integer >();

        int left = 0, right = 0;
        int n = s.length();
        int len = 0;
        while (right < n) {
            if (mpp.containsKey(s.charAt(right))) left = Math.max(mpp.get(s.charAt(right)) + 1, left);

            mpp.put(s.charAt(right), right);

            len = Math.max(len, right - left + 1);
            right++;
        }
        return len;
    }

    public static void main(String args[]) {
        String str = "takeUforward";
        System.out.println("The length of the longest substring without repeating characters is " + solvePrac(str));

    }

    private static int solvePrac(String str) {
//        initialize length
        int length= 0;
//        initialize left and right pointers
        int left=0;
        int right=0;
//        initialize hashmap
        Map<Character, Integer> map=new HashMap<>();

//        move right pointer one by one
        for(;right< str.length();right++){
//            if map contains the character at right pointer that means it has occurred before and it is repeating
//            then move left index to right index
            if(map.keySet().contains(str.charAt(right))) {
                left=map.get(str.charAt(right));
            }

//            update the last seen index of character in map
            map.put(str.charAt(right), right);

//            update max length by comparing length and right-left +1
            length = Math.max(length, (right-left)+1);
        }
        return length;

//        abcabcbb
    }
}

