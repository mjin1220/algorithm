package com.mjin.four;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1330
public class B1330 {

    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            Integer A = Integer.parseInt(st.nextToken());
            Integer B = Integer.parseInt(st.nextToken());

            switch (A.compareTo(B)) {
                case 1:
                    bw.write(">");
                    break;
                case 0:
                    bw.write("==");
                    break;
                case -1:
                    bw.write("<");
                    break;
            }
        }
    }
}