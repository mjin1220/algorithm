package com.mjin.one;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.StringTokenizer;

public class B1008 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BigDecimal firstNumber = BigDecimal.valueOf(Long.parseLong(st.nextToken()));
        BigDecimal secondNumber = BigDecimal.valueOf(Long.parseLong(st.nextToken()));
        System.out.println(firstNumber.divide(secondNumber, 15, RoundingMode.HALF_UP));
    }
}
