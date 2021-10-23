package com.mjin.three;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2869
public class B2869 {

    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            bw.write(calculateUpDays(A, B, V) + "\n");
        }
    }

    private static int calculateUpDays(final int A, final int B, final int V) {
        int oneDayDistance = A - B;
        int targetDistance = V - A;
        int upDays = 1 + targetDistance / oneDayDistance;
        return targetDistance % oneDayDistance == 0 ? upDays : upDays + 1;
    }
}