package com.mjin.two;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B15552 {

    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int N = Integer.parseInt(br.readLine());

            StringBuffer sb = new StringBuffer();
            int first = 0, second = 0;
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                first = Integer.parseInt(st.nextToken());
                second = Integer.parseInt(st.nextToken());
                sb.append(first + second).append("\n");
            }

            bw.write(sb.toString());
        }
    }
}
