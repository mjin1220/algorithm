package com.mjin.four;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.concurrent.LinkedBlockingQueue;

// https://www.acmicpc.net/problem/2178
public class B2178 {

    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[][] map = new int[N][M];
            for (int i = 0; i < N; i++) {
                String line = br.readLine();
                for (int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(line.charAt(j) + "");
                }
            }

            bw.write(calculateShortestDistance(N, M, map) + "\n");
        }
    }

    private static int calculateShortestDistance(int N, int M, int[][] map) {
        // use BFS

        boolean[][] visited = new boolean[N][M];
        Queue<Point> queue = new LinkedBlockingQueue<>();

        queue.add(new Point(0, 0, 1));
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            Point point = queue.remove();

            if (point.getRow() == N - 1 && point.getCol() == M - 1) {
                return point.getDistance();
            }

            int[][] connectedPositions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

            for (int[] connectedPosition : connectedPositions) {
                if (point.getRow() + connectedPosition[0] < 0 || point.getCol() + connectedPosition[1] < 0) {
                    continue;
                }

                if (point.getRow() + connectedPosition[0] > N - 1 || point.getCol() + connectedPosition[1] > M - 1) {
                    continue;
                }

                if (!visited[point.getRow() + connectedPosition[0]][point.getCol() + connectedPosition[1]]
                        && map[point.getRow() + connectedPosition[0]][point.getCol() + connectedPosition[1]] == 1) {
                    queue.add(new Point(point.getRow() + connectedPosition[0],
                            point.getCol() + connectedPosition[1],
                            point.getDistance() + 1));
                    visited[point.getRow() + connectedPosition[0]][point.getCol() + connectedPosition[1]] = true;
                }
            }
        }

        return -1;
    }

    static class Point {

        int row;
        int col;
        int distance;

        public Point(int row, int col, int distance) {
            this.row = row;
            this.col = col;
            this.distance = distance;
        }

        public int getRow() {
            return row;
        }

        public int getCol() {
            return col;
        }

        public int getDistance() {
            return distance;
        }
    }
}