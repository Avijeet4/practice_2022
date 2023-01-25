package com.avijeet.practice_2022.stack;

import java.util.Stack;

class MinStack {
    Stack<Long> s = new Stack();
    Long min;

    public MinStack() {

    }

    public void push(int val) {
        if (!s.isEmpty() && min > val) {
            s.push(2 * (long) val - min);
            min = (long)val;
        } else {
            if (s.isEmpty()) {
                min = (long)val;
            }
            s.push((long)val);
        }
    }

    public void pop() {
        if(s.isEmpty())
            return;
        Long val = s.pop();
        if (min > val) {
            min = (2 * min) - val;
        }
        if(s.isEmpty())
            min=null;
    }

    public int top() {
        if (s.isEmpty())
            return -1;
        if (min > s.peek()) {
            return min.intValue();
        }
        return s.peek().intValue();
    }

    public int getMin() {
        if (s.isEmpty())
            return -1;
        return min.intValue();
    }

    public static void main(String[] args) {
        inputFormat(
                new String[]{"MinStack", "push", "push", "push", "top", "pop", "getMin", "pop", "getMin", "pop", "push", "top", "getMin", "push", "top", "getMin", "pop", "getMin"},
                new int[]{0, 2147483646, 2147483646, 2147483647, 0, 0, 0, 0, 0, 0, 2147483647, 0, 0, -2147483648, 0, 0, 0, 0}
        );
    }

    private static void inputFormat(String[] ops, int[] opValues) {
        MinStack minStack = null;
        for (int i = 0; i < ops.length; i++) {
            if (ops[i].equals("MinStack")) {
                minStack = new MinStack();
            } else if (ops[i].equals("push")) {
                minStack.push(opValues[i]);
            } else if (ops[i].equals("pop")) {
                minStack.pop();
            } else if (ops[i].equals("top")) {
                System.out.println(minStack.top());
            } else if (ops[i].equals("getMin")) {
                System.out.println(minStack.getMin());
            }
        }
    }
}
