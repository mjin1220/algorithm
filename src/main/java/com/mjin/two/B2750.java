package com.mjin.two;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class B2750 {

    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int N = Integer.parseInt(br.readLine());
            List<Integer> list = new ArrayList<>();

            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < N; i++) {
                int input = Integer.parseInt(br.readLine());
                list.add(input);
            }

            list.stream()
                .sorted()
                .forEach(item -> sb.append(item)
                                   .append("\n"));
            bw.write(sb.toString());
        }
    }
}