package com.mjin.five;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

// https://www.acmicpc.net/problem/9012
public class B9012 {

    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            int T = Integer.parseInt(br.readLine());
            for (int i = 0; i < T; i++) {
                bw.write(validateParenthesis(br.readLine()) + "\n");
            }
        }
    }

    private static String validateParenthesis(String parenthesis) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < parenthesis.length(); i++) {
            char p = parenthesis.charAt(i);

            if (p == '(') {
                stack.push(p);
            } else { // ')'
                if (stack.isEmpty() || stack.pop() != '(') {
                    return "NO";
                }
            }
        }

        return stack.isEmpty() ? "YES" : "NO";
    }
}