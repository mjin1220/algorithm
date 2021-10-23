package com.mjin.three;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1712
public class B1712 {

    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken()); // fixed price
            int B = Integer.parseInt(st.nextToken()); // variable price
            int C = Integer.parseInt(st.nextToken()); // notebook price

            bw.write(calculateBreakEvenPoint(A, B, C) + "\n");
        }
    }

    private static int calculateBreakEvenPoint(int fixedPrice, int variablePrice, int notebookPrice) {
        if (variablePrice >= notebookPrice && (notebookPrice - variablePrice) <= fixedPrice) {
            return -1;
        }

        return (fixedPrice / (notebookPrice - variablePrice)) + 1;
    }
}