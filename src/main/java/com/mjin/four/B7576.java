package com.mjin.four;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.concurrent.LinkedBlockingQueue;

// https://www.acmicpc.net/problem/7576
public class B7576 {

    private static final int RIPE = 1;
    private static final int UNRIPE = 0;
    private static final int EMPTY = -1;

    private static final int[][] nestedPositions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static final Queue<Point> queue = new LinkedBlockingQueue<>();

    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            int[][] board = new int[N][M];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            bw.write(calculateShortestDay(N, M, board) + "\n");
        }
    }

    private static int calculateShortestDay(final int N, final int M, final int[][] board) {
        int[][] shortestDayBoard = new int[N][M];
        boolean[][] visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == RIPE) {
                    queue.add(new Point(i, j, 0));
                    shortestDayBoard[i][j] = 0;
                    visited[i][j] = true;
                } else {
                    shortestDayBoard[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        while (!queue.isEmpty()) {
            Point p = queue.remove();
            shortestDayBoard[p.getRow()][p.getCol()] = p.getDays();

            for (int[] nestedPosition : nestedPositions) {
                if (p.getRow() + nestedPosition[0] < 0 || p.getCol() + nestedPosition[1] < 0) {
                    continue;
                }
                if (p.getRow() + nestedPosition[0] > N - 1 || p.getCol() + nestedPosition[1] > M - 1) {
                    continue;
                }

                if (!visited[p.getRow() + nestedPosition[0]][p.getCol() + nestedPosition[1]] &&
                        board[p.getRow() + nestedPosition[0]][p.getCol() + nestedPosition[1]] == UNRIPE) {
                    queue.add(new Point(p.getRow() + nestedPosition[0], p.getCol() + nestedPosition[1], p.getDays() + 1));
                    visited[p.getRow() + nestedPosition[0]][p.getCol() + nestedPosition[1]] = true;
                }
            }
        }

        int maxRipeDays = -1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == EMPTY) {
                    continue;
                }

                maxRipeDays = Math.max(maxRipeDays, shortestDayBoard[i][j]);
            }
        }

        return maxRipeDays == Integer.MAX_VALUE ? -1 : maxRipeDays;
    }

    static class Point {

        int row;
        int col;
        int days;

        public Point(int row, int col, int days) {
            this.row = row;
            this.col = col;
            this.days = days;
        }

        public int getRow() {
            return row;
        }

        public int getCol() {
            return col;
        }

        public int getDays() {
            return days;
        }
    }
}