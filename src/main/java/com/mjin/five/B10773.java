package com.mjin.five;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

// https://www.acmicpc.net/problem/10773
public class B10773 {

    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            int K = Integer.parseInt(br.readLine());
            Stack<Integer> stack = new Stack<>();

            for (int i = 0; i < K; i++) {
                int number = Integer.parseInt(br.readLine());
                if (number == 0) {
                    stack.pop();
                } else {
                    stack.push(number);
                }
            }

            int sum = 0;
            while (!stack.isEmpty()) {
                sum += stack.pop();
            }

            bw.write(sum + "\n");
        }
    }
}