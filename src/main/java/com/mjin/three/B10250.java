package com.mjin.three;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/10250
public class B10250 {

    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            int T = Integer.parseInt(br.readLine());

            for (int i = 0; i < T; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int H = Integer.parseInt(st.nextToken());
                int W = Integer.parseInt(st.nextToken());
                int N = Integer.parseInt(st.nextToken());

                bw.write(String.format("%d%02d", (((N - 1) % H) + 1), ((N - 1) / H) + 1) + "\n");
            }
        }
    }
}