package com.mjin.three;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// https://www.acmicpc.net/problem/2839
public class B2839 {

    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            int N = Integer.parseInt(br.readLine());

            bw.write(calculateBagCount(N) + "\n");
        }
    }

    private static int calculateBagCount(int N) {
        int minBagCount = Integer.MAX_VALUE;

        for (int i = 0; i <= (N / 5); i++) {
            int bagCount = N / 5 - i;
            int remainder = N % 5 + i * 5;

            if (remainder % 3 == 0) {
                bagCount += remainder / 3;
                minBagCount = Math.min(bagCount, minBagCount);
            }
        }

        return minBagCount == Integer.MAX_VALUE ? -1 : minBagCount;
    }
}