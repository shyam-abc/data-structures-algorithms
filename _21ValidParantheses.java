package com.datastructures_algorithms.neetcode_150._1_25;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

 An input string is valid if:

 Open brackets must be closed by the same type of brackets.
 Open brackets must be closed in the correct order.
 Every close bracket has a corresponding open bracket of the same type.

 Example 1:

 Input: s = "()"

 Output: true

 Example 2:

 Input: s = "()[]{}"

 Output: true

 Example 3:

 Input: s = "(]"

 Output: false

 Example 4:

 Input: s = "([])"

 Output: true

 Example 5:

 Input: s = "([)]"

 Output: false
 */
public class _21ValidParantheses {
    public boolean isValid(String s) {
        Map<Character, Character> bracketMap = new HashMap<>();
        bracketMap.put(')', '(');
        bracketMap.put('}', '{');
        bracketMap.put(']', '[');

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if(!bracketMap.containsKey(c))
                stack.push(c);
            else{
                if(stack.isEmpty())
                    return false;
                char topElement = stack.pop();
                if(topElement != bracketMap.get(c))
                    return false;
            }
        }

        return stack.isEmpty();
    }
}
