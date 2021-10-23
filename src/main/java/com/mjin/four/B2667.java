package com.mjin.four;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// https://www.acmicpc.net/problem/2667
public class B2667 {

    public static final int HOME = 1;
    public static final int EMPTY = 0;

    private static final int[][] nestedPositions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            int N = Integer.parseInt(br.readLine());

            int[][] map = new int[N][N];
            boolean[][] visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                String s = br.readLine();
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(s.charAt(j) + "");
                }
            }

            List<Integer> colorCounts = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == HOME && !visited[i][j]) {
                        visited[i][j] = true;
                        colorCounts.add(writeColor(map, visited, i, j));
                    }
                }
            }

            Collections.sort(colorCounts);

            bw.write(colorCounts.size() + "\n");
            for (Integer colorCount : colorCounts) {
                bw.write(colorCount + "\n");
            }
        }
    }

    private static int writeColor(int[][] map, boolean[][] visited, int row, int col) {
        int sum = 1;

        for (int[] nestedPosition : nestedPositions) {
            if (row + nestedPosition[0] < 0 || col + nestedPosition[1] < 0) {
                continue;
            }
            if (row + nestedPosition[0] > map.length - 1 || col + nestedPosition[1] > map.length - 1) {
                continue;
            }

            if (!visited[row + nestedPosition[0]][col + nestedPosition[1]] &&
                    map[row + nestedPosition[0]][col + nestedPosition[1]] == HOME) {
                visited[row + nestedPosition[0]][col + nestedPosition[1]] = true;
                sum += writeColor(map, visited, row + nestedPosition[0], col + nestedPosition[1]);
            }
        }

        return sum;
    }
}