package blind75.Strings;

import java.util.ArrayList;
import java.util.List;

public class EncodeDEcode {
    public static void main(String[] args) {
        String encodedString=encode("hello World");
        System.out.println(encodedString);

        String decodedString=decode(encodedString);
        System.out.println(decodedString);
    }

    private static String decode(String encodedString) {

//        get first number
//        remove next element

        char[] charArr=encodedString.toCharArray();
        StringBuffer buff=new StringBuffer();
        int i=0;
        while (i<charArr.length){
            int len=Integer.parseInt(String.valueOf(charArr[i]));
            int j=i+1;
            while(j<=i+len){
                buff.append(charArr[j]);
                j++;
            }
            buff.append(" ");
            i=i+len+1;
        }
        return buff.toString();

    }

    private static String encode(String input) {
        StringBuffer buff = new StringBuffer();
        String[] words=input.split(" ");
        for (int i=0;i<words.length;i++){
            int len=words[i].length();
            buff.append(len);
            buff.append(words[i]);
        }
        return buff.toString();
    }


}
