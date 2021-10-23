package com.mjin.two;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class B10828 {

    public static void main(String[] args) throws Exception {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int N = Integer.parseInt(br.readLine());

            Stack stack = new Stack();

            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                StackCommands stackCommand = StackCommands.valueOf(st.nextToken().toUpperCase());
                switch (stackCommand) {
                    case PUSH:
                        int input = Integer.parseInt(st.nextToken());
                        stack.push(input);
                        break;
                    case POP:
                        sb.append(stack.size() == 0 ? -1 : stack.pop()).append("\n");
                        break;
                    case SIZE:
                        sb.append(stack.size()).append("\n");
                        break;
                    case EMPTY:
                        sb.append(stack.empty() ? 1 : 0).append("\n");
                        break;
                    case TOP:
                        sb.append(stack.size() == 0 ? -1 : stack.peek()).append("\n");
                        break;
                }
            }

            bw.write(sb.toString());
        }
    }

    enum StackCommands {
        PUSH,
        POP,
        SIZE,
        EMPTY,
        TOP;
    }
}