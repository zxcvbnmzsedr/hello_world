package com.ztianzeng.learn.leetcode.code;

import java.util.Stack;

public class Evalute {
    public static void main(String[] args) {
        String key = "(1+((2+3)*(4*5)))";
        // 运算符栈
        Stack<String> opts = new Stack<>();
        // 操作数栈
        Stack<Double> vals = new Stack<>();
        String[] vvvv = key.split("");
        for (String s : vvvv) {
            switch (s) {
                case "(":
                    break;
                case "+":
                case "-":
                case "*":
                case "/":
                    opts.push(s);
                    break;
                case ")":
                    // 弹出操作数栈
                    String a = opts.pop();
                    Double val = vals.pop();
                    Double v = 0.0;
                    switch (a) {
                        case "+":
                            v = val + vals.pop();
                            break;
                        case "-":
                            v = val - vals.pop();
                            break;
                        case "*":
                            v = val * vals.pop();
                            break;
                        case "/":
                            v = val / vals.pop();
                            break;
                        default:
                            break;
                    }
                    vals.push(v);

                    break;
                default:
                    vals.push(Double.valueOf(s));
                    break;
            }
        }
        System.out.println(vals.pop());

    }
}
