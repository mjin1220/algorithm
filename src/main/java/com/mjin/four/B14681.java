package com.mjin.four;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// https://www.acmicpc.net/problem/14681
public class B14681 {

    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            int x = Integer.parseInt(br.readLine());
            int y = Integer.parseInt(br.readLine());

            if (x > 0 && y > 0) {
                bw.write("1");
            } else if (x > 0 && y < 0) {
                bw.write("4");
            } else if (x < 0 && y > 0) {
                bw.write("2");
            } else if (x < 0 && y < 0) {
                bw.write("3");
            }
        }
    }
}