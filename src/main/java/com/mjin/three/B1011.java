package com.mjin.three;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1011
public class B1011 {

    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            int t = Integer.parseInt(br.readLine());

            for (int i = 0; i < t; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                bw.write(calculateMinimumExecutionCount(x, y) + "\n");
            }
        }
    }

    private static int calculateMinimumExecutionCount(int x, int y) {
        int distance = y - x;
        int max = (int) Math.sqrt(distance);

        if (max == Math.sqrt(distance)) {
            return (max * 2 - 1);
        } else if (distance <= max * max + max) {
            return (max * 2);
        } else {
            return (max * 2 + 1);
        }
    }
}