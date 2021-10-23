package com.mjin.two;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2884 {

    public static final int DAY_HOURS = 24;
    public static final int HOUR_MINUTES = 60;
    public static final int DAY_MINUTES = DAY_HOURS * HOUR_MINUTES;

    public static final int MINUS_MINUTES = 45;

    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int resultMinutes = ((DAY_HOURS * HOUR_MINUTES) + (H * HOUR_MINUTES
                    + M - MINUS_MINUTES)) % DAY_MINUTES;
            System.out.printf("%d %d\n", resultMinutes / HOUR_MINUTES, resultMinutes % HOUR_MINUTES);
        }
    }
}