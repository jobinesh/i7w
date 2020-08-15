package com.jobinesh.i7w.dailycoding;

import java.util.Arrays;

/**
 * Run-length encoding is a fast and simple method of encoding strings. The basic idea is to represent repeated
 * successive characters as a single count and character. For example, the string "AAAABBBCCDAA" would be encoded as "4A3B2C1D2A".
 */
public class RepetativeCharCoder {
    public int compress(char[] chars) {
        if (chars == null) {
            return 0;
        }
        if (chars.length <= 1) {
            return chars.length;
        }
        char[] copied = chars;
        int cnt = 1;
        int index = 0;
        for (int i = 0; i < copied.length - 1; i++) {
            if (copied[i] == copied[i + 1]) {
                cnt++;
            } else {
                if (cnt > 1) {
                    chars[index] = copied[i];
                    index++;
                    char[] counts = Integer.toString(cnt).toCharArray();
                    for (int j = 0; j < counts.length; j++) {
                        chars[index] = counts[j];
                        index++;
                    }
                } else {
                    copied[index] = copied[i];
                    index++;
                }
                cnt = 1;
            }
        }
        if (cnt > 1) {
            chars[index] = copied[copied.length - 1];
            index++;
            char[] counts = Integer.toString(cnt).toCharArray();
            for (int j = 0; j < counts.length; j++) {
                chars[index] = counts[j];
                index++;
            }
        } else {
            chars[index] = copied[copied.length - 1];
            index++;
        }
        return index;
    }

    public String encode(String text) {
        if (text == null || text.length() == 1) {
            return text;
        }
        StringBuilder encoded = new StringBuilder();
        int cnt = 1;

        for (int i = 0; i < text.length() - 1; i++) {
            if (text.charAt(i) == text.charAt(i + 1)) {
                cnt++;
            } else {
                if (cnt > 1) {
                    encoded.append(cnt);
                    encoded.append(text.charAt(i - 1));
                } else {
                    encoded.append(cnt);
                    encoded.append(text.charAt(i));
                }
                cnt = 1;
            }
        }
        encoded.append(cnt);
        encoded.append(text.charAt(text.length() - 1));
        return encoded.toString();
    }

    public static void main(String[] args) {
        System.out.println(new RepetativeCharCoder().encode("AAAABBBCCDAACDRRRRT"));
        char[] text = "A".toCharArray();
        System.out.println(new RepetativeCharCoder().compress(text));
        System.out.println(Arrays.toString(text));
    }
}