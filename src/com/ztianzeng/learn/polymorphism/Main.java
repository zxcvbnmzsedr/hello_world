package com.ztianzeng.learn.polymorphism;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Main a = new Main();
        System.out.println(a.isValid("()"));
    }

    public boolean isValid(String s) {
        Map<String, String> map = new HashMap<>();
        map.put("{", "}");
        map.put("[", "]");
        map.put("(", ")");
        String[] forS = s.split("");
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < forS.length; i++) {
            String temp = forS[i];
            if ("{[(".contains(temp)) {
                stack.add(temp);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                String peek = stack.pop();
                if (!temp.equals(map.get(peek))) {
                    return false;
                }
            }

        }
        return stack.isEmpty();
    }
}
