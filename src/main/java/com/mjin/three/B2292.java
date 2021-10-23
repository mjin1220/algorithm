package com.mjin.three;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// https://www.acmicpc.net/problem/2292
public class B2292 {

    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            int N = Integer.parseInt(br.readLine());
            bw.write(getMinPassingDoors(N) + "\n");
        }
    }

    /**
     * depth 의 마지막 인덱스를 구해오는 메서드
     * 1 + 6 * ((1 + (N - 1)) * ((N - 1) / 2))
     *
     * @param depth depth
     * @return lastIndex
     */
    private static int getLastIndex(int depth) {
        return (int) (1 + 6 * ((1 + (depth - 1)) * ((double) (depth - 1) / 2)));
    }

    private static int getMinPassingDoors(int N) {
        int answer = 1;

        while (getLastIndex(answer) < N) {
            answer++;
        }

        return answer;
    }
}