package com.mjin.etc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

// https://www.acmicpc.net/problem/4949
public class B4949 {

    private static final String END_STR = ".";

    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            String str = br.readLine();
            while (!END_STR.equals(str)) {
                bw.write(validateParenthesis(str) + "\n");
                str = br.readLine();
            }
        }
    }

    private static String validateParenthesis(String str) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            switch (c) {
                case '(':
                case '[':
                    stack.push(c);
                    break;
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(') {
                        return "no";
                    }
                    break;
                case ']':
                    if (stack.isEmpty() || stack.pop() != '[') {
                        return "no";
                    }
                    break;
            }
        }

        return stack.isEmpty() ? "yes" : "no";
    }
}