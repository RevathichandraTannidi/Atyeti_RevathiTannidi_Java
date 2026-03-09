package org.atyeti.javapractice;

import java.util.HashSet;
import java.util.Set;

public class Non_Repeating_Characters {
    public static void main(String[] args) {
        String s="abcabcbb";
        String longestString=LongestSubString(s);
        System.out.println("substring : "+longestString);
        System.out.println("lenght of the substring: "+longestString.length());

    }

  public static String LongestSubString(String s) {
        Set<Character> set=new HashSet<>();
        int left=0;int maxLen=0;int startIndex=0;

        for (int right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }

            set.add(s.charAt(right));

            if (right - left + 1 > maxLen) {
                maxLen = right - left + 1;
                startIndex = left;
            }
        }

        return s.substring(startIndex, startIndex + maxLen);

    }
}
