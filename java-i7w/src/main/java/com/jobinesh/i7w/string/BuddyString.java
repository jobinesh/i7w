package com.jobinesh.i7w.string;

import java.util.HashSet;
import java.util.Set;

public class BuddyString {
    public boolean buddyStrings(String a, String b) {
        if (a == null || b == null) {
            return false;
        }

        if (a.isEmpty() || b.isEmpty() || a.length() > 20000 || b.length() > 20000) {
            return false;
        }
        if (a.length() != b.length()) {
            return false;
        }
        int[] diffInices = new int[2];
        int index = 0;
        if (a.equals(b)) {
            Set<Character> s = new HashSet<Character>();
            for (char c :a.toCharArray()) s.add(c);
            return s.size() < a.length();
        }
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                if (index <= 1)
                    diffInices[index++] = i;
                else
                    return false;
            }
        }
        if (index == 0) {

            return true;
        }
        if (index == 2 && a.charAt(diffInices[0]) == b.charAt(diffInices[1]) && a.charAt(diffInices[1]) == b.charAt(diffInices[0]))
            return true;
        else
            return false;
    }

    public static void main(String... args) {
        boolean result = new BuddyString().buddyStrings("aaa", "aaa");
        System.out.println(result);
    }
}
