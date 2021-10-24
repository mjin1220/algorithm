package com.mjin.etc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

// https://www.acmicpc.net/problem/1874
public class B1874 {

    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            Stack<Integer> stack = new Stack<>();
            int N = Integer.parseInt(br.readLine());
            StringBuffer sb = new StringBuffer();

            int input = Integer.parseInt(br.readLine());
            int addedLastNumber = input;
            for (int i = 1; i <= input; i++) {
                stack.push(i);
                sb.append("+\n");
            }

            stack.pop();
            sb.append("-\n");

            for (int i = 1; i < N; i++) {
                input = Integer.parseInt(br.readLine());

                if (!stack.isEmpty() && input == stack.peek()) {
                    stack.pop();
                    sb.append("-\n");
                } else if (input > addedLastNumber) {
                    for (int j = addedLastNumber + 1; j <= input; j++) {
                        stack.push(j);
                        sb.append("+\n");
                    }
                    addedLastNumber = input;
                    stack.pop();
                    sb.append("-\n");
                } else {
                    bw.write("NO\n");
                    return;
                }
            }

            bw.write(sb.toString());
        }
    }
}