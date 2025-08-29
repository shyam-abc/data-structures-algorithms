package com.datastructures_algorithms.neetcode_150._1_25;

import java.util.ArrayList;
import java.util.List;

public class _8EncodeDecodeStrings {
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length()).append('#').append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String s) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < s.length()) {
            int j = i;
            while (s.charAt(j) != '#') {
                j++;
            }

            int length = Integer.parseInt(s.substring(i, j));
            j++;

            String word = s.substring(j, j + length);
            result.add(word);

            i = j + length;
        }

        return result;
    }
}
