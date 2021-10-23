package com.mjin.three;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// https://www.acmicpc.net/problem/2775
public class B2775 {

    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            APT apt = APT.getInstance();

            int T = Integer.parseInt(br.readLine());

            for (int i = 0; i < T; i++) {
                int k = Integer.parseInt(br.readLine());
                int n = Integer.parseInt(br.readLine());

                bw.write(apt.getPersonCount(k, n) + "\n");
            }
        }
    }

    static class APT {

        public int[][] rooms;

        private APT() {
            rooms = new int[15][15];

            for (int i = 0; i < 15; i++) {
                rooms[0][i] = i;
            }

            for (int i = 1; i < 15; i++) {
                for (int j = 0; j < 15; j++) {
                    if (j == 0) {
                        rooms[i][j] = 0;
                        continue;
                    }

                    rooms[i][j] = rooms[i][j - 1] + rooms[i - 1][j];
                }

            }
        }

        public static APT getInstance() {
            return LazyHolder.apt;
        }

        private static class LazyHolder {
            private static final APT apt = new APT();
        }


        public int getPersonCount(final int k, final int n) {
            return rooms[k][n];
        }
    }
}