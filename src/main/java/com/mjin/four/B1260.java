package com.mjin.four;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Collectors;

// https://www.acmicpc.net/problem/1260
public class B1260 {

    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            Graph graph = new Graph();
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int firstNodeNumber = Integer.parseInt(st.nextToken());
                int secondNodeNumber = Integer.parseInt(st.nextToken());
                graph.addEdge(firstNodeNumber, secondNodeNumber);
                graph.addEdge(secondNodeNumber, firstNodeNumber);
            }

            System.out.println(graph.getDfsPath(V) + "\n" + graph.getBfsPath(V));
        }
    }

    static class Graph {

        private final Map<Integer, List<Integer>> edgesMapByNodeNumber;

        public Graph() {
            edgesMapByNodeNumber = new HashMap<>();
        }

        public void addEdge(int source, int destination) {
            List<Integer> edges = edgesMapByNodeNumber.getOrDefault(source, new ArrayList<>());
            edges.add(destination);
            edges.sort(Integer::compare);

            edgesMapByNodeNumber.put(source, edges);
        }

        public String getDfsPath(int startNodeNumber) {
            List<Integer> dfsPath = new ArrayList<>();

            Map<Integer, Boolean> visited = new HashMap<>();
            Stack<Integer> stack = new Stack<>();

            Integer nodeNumber;
            List<Integer> edges;

            stack.push(startNodeNumber);
            visited.put(startNodeNumber, true);
            while (stack.size() != 0) {
                nodeNumber = stack.peek();

                if (!dfsPath.contains(nodeNumber)) {
                    dfsPath.add(nodeNumber);
                }

                boolean hasNextNode = false;
                edges = edgesMapByNodeNumber.getOrDefault(nodeNumber, new ArrayList<>());
                for (int connectedNodeNumber : edges) {
                    if (!visited.getOrDefault(connectedNodeNumber, false)) {
                        stack.push(connectedNodeNumber);
                        visited.put(connectedNodeNumber, true);
                        hasNextNode = true;
                        break;
                    }
                }

                if (!hasNextNode) {
                    stack.pop();
                }
            }

            return dfsPath.stream()
                          .map(String::valueOf)
                          .collect(Collectors.joining(" "));
        }

        public String getBfsPath(int startNodeNumber) {
            List<Integer> bfsPath = new ArrayList<>();

            Map<Integer, Boolean> visited = new HashMap<>();
            Queue<Integer> queue = new LinkedBlockingQueue<>();

            int nodeNumber;

            queue.add(startNodeNumber);
            visited.put(startNodeNumber, true);
            while (queue.size() != 0) {
                nodeNumber = queue.remove();
                bfsPath.add(nodeNumber);

                edgesMapByNodeNumber.getOrDefault(nodeNumber, new ArrayList<>())
                                    .forEach(connectedNodeNumber -> {
                                        if (!visited.getOrDefault(connectedNodeNumber, false)) {
                                            queue.add(connectedNodeNumber);
                                            visited.put(connectedNodeNumber, true);
                                        }
                                    });
            }

            return bfsPath.stream()
                          .map(String::valueOf)
                          .collect(Collectors.joining(" "));
        }
    }
}