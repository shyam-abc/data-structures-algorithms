package com.datastructures_algorithms.neetcode_150._1_25;

import java.util.ArrayList;
import java.util.List;

/**
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.



Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
Example 2:

Input: n = 1
Output: ["()"]


Constraints:

1 <= n <= 8
 */
public class _24GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        backtrack(result, sb, 0, 0, n);
        return result;
    }

    private void backtrack(List<String> result, StringBuilder sb, int open, int close, int max) {
        if (sb.length() == max * 2) {
            result.add(sb.toString());
            return;
        }

        if (open < max) {
            sb.append('(');
            backtrack(result, sb, open + 1, close, max);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (close < open) {
            sb.append(')');
            backtrack(result, sb, open, close + 1, max);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
