package com.mjin.four;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

// https://www.acmicpc.net/problem/2606
public class B2606 {

    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            int N = Integer.parseInt(br.readLine());
            int M = Integer.parseInt(br.readLine());

            Map<Integer, List<Integer>> networkMap = new HashMap<>();
            boolean[] visited = new boolean[N];
            for (int i = 0; i < M; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int first = Integer.parseInt(st.nextToken()) - 1;
                int second = Integer.parseInt(st.nextToken()) - 1;
                makeNetworkEdge(networkMap, first, second);
                makeNetworkEdge(networkMap, second, first);
            }

            visited[0] = true;
            bw.write((getVirusAreaSize(networkMap, visited, 0) - 1) + "\n");
        }
    }

    private static void makeNetworkEdge(Map<Integer, List<Integer>> networkMap, int first, int second) {
        List<Integer> edges = networkMap.getOrDefault(first, new ArrayList<>());
        edges.add(second);
        networkMap.put(first, edges);
    }

    private static int getVirusAreaSize(Map<Integer, List<Integer>> networkMap, boolean[] visited, int nodeNumber) {
        int sum = 1;

        for (int connectedNodeNumber : networkMap.getOrDefault(nodeNumber, new ArrayList<>())) {
            if (!visited[connectedNodeNumber]) {
                visited[connectedNodeNumber] = true;
                sum += getVirusAreaSize(networkMap, visited, connectedNodeNumber);
            }
        }
        return sum;
    }
}