package com.mjin.three;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// https://www.acmicpc.net/problem/1193
public class B1193 {

    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            int X = Integer.parseInt(br.readLine());
            bw.write(getFraction(X) + "\n");
        }
    }

    /**
     * depth 의 마지막 인덱스를 구해오는 메서드
     *
     * @param depth depth
     * @return lastIndex
     */
    private static int getLastIndex(int depth) {
        return (int) ((1 + depth) * ((double) depth / 2));
    }

    private static String getFraction(int X) {
        int parent = 1;
        int child = 1;

        while (getLastIndex(parent) < X) {
            parent++;
        }

        int remainder = X - getLastIndex(parent - 1) - 1;

        if (parent % 2 == 0) {
            return String.format("%d/%d", child + remainder, parent - remainder);
        }

        return String.format("%d/%d", parent - remainder, child + remainder);
    }
}