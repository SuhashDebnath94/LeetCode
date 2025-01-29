package strings;

public class N16_NeedleHaystack {

    /**
     * Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
     *
     */

    public static void main(String[] args) {
        System.out.println(strStr( "ac",  "dghdfkgdfjgkdfhgdfkjghdfkjghdkfjhgkjdfhgkdfjghdfkjghac"));
    }

    private static int strStr(String haystack, String needle) {
        int i=0;
        if(needle.length()==0)
            return 0;
        while(i<=haystack.length()-needle.length())
        {
            String ans=haystack.substring(i,i+needle.length());
            if(ans.equals(needle))
                return i;
            i++;
        }
        return -1;
    }
}
