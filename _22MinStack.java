package com.datastructures_algorithms.neetcode_150._1_25;

import java.util.Stack;

public class _22MinStack {
    private final Stack<Long> stack;
    private long min;

    public _22MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push((long) val);
            min = val;
        } else {
            if (val < min) {
                stack.push(2L * val - min);
                min = val;
            } else {
                stack.push((long) val);
            }
        }
    }

    public void pop() {
        long top = stack.pop();
        if (top < min) {
            min = 2 * min - top;
        }
    }

    public int top() {
        long top = stack.peek();
        if (top < min) {
            return (int) min;
        } else {
            return (int) top;
        }
    }

    public int getMin() {
        return (int) min;
    }
}