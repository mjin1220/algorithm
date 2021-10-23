package com.mjin.two;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B10845 {

    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int N = Integer.parseInt(br.readLine());

            Queue queue = Queue.getInstance();

            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                QueueCommands command = QueueCommands.valueOf(st.nextToken().toUpperCase());
                switch (command) {
                    case PUSH:
                        int input = Integer.parseInt(st.nextToken());
                        queue.push(input);
                        break;
                    case POP:
                        sb.append(queue.pop()).append("\n");
                        break;
                    case SIZE:
                        sb.append(queue.size()).append("\n");
                        break;
                    case EMPTY:
                        sb.append(queue.empty()).append("\n");
                        break;
                    case FRONT:
                        sb.append(queue.front()).append("\n");
                        break;
                    case BACK:
                        sb.append(queue.back()).append("\n");
                        break;
                }
            }

            bw.write(sb.toString());
        }
    }

    enum QueueCommands {
        PUSH,
        POP,
        SIZE,
        EMPTY,
        FRONT,
        BACK;
    }

    static class Queue {
        private static final int MAX_QUEUE_SIZE = 10000;

        private int[] queue = new int[MAX_QUEUE_SIZE];
        private int frontIndex = 0, backIndex = 0;

        private Queue() {
        }

        public static Queue getInstance() {
            return LazyHolder.queue;
        }

        private static class LazyHolder {
            private static final Queue queue = new Queue();
        }

        public void push(int number) {
            queue[backIndex] = number;
            backIndex = (backIndex + 1) % MAX_QUEUE_SIZE;
        }

        public int pop() {
            if (this.empty() == 1) {
                return -1;
            }

            int value = queue[frontIndex];
            frontIndex = (frontIndex + 1) % MAX_QUEUE_SIZE;
            return value;
        }

        public int size() {
            return (MAX_QUEUE_SIZE + backIndex - frontIndex) % MAX_QUEUE_SIZE;
        }

        public int empty() {
            return this.size() == 0 ? 1 : 0;
        }

        public int front() {
            if (this.empty() == 1) {
                return -1;
            }

            return queue[frontIndex];
        }

        public int back() {
            if (this.empty() == 1) {
                return -1;
            }

            return queue[backIndex - 1];
        }
    }
}