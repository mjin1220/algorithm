package com.mjin.two;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B1927 {

    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int N = Integer.parseInt(br.readLine());

            Heap minHeap = MinHeap.getInstance();

            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < N; i++) {
                long input = Long.parseLong(br.readLine());
                if (input == 0) {
                    sb.append(minHeap.pop()).append("\n");
                } else {
                    minHeap.insert(input);
                }
            }

            bw.write(sb.toString());
        }
    }

    interface Heap {

        void insert(long value);

        long pop();
    }

    static class MinHeap implements Heap {

        public static final int MAX_MIN_HEAP_INDEX = 131072;
        public static final int MAX_MIN_HEAP_SIZE = MAX_MIN_HEAP_INDEX + 1;
        public static final int ROOT_INDEX = 1;

        private final long[] heap;
        private int heapIndex;

        private MinHeap() {
            heap = new long[MAX_MIN_HEAP_SIZE];
            heapIndex = 0;

            for (int i = 0; i < MAX_MIN_HEAP_SIZE; i++) {
                heap[i] = Long.MAX_VALUE;
            }
        }

        public static MinHeap getInstance() {
            return LazyHolder.minHeap;
        }

        private static class LazyHolder {
            private static final MinHeap minHeap = new MinHeap();
        }

        @Override
        public void insert(long value) {
            heap[++heapIndex] = value;

            int parentIndex = heapIndex / 2, childIndex = heapIndex;
            while (parentIndex > 0) {
                if (heap[parentIndex] <= heap[childIndex]) {
                    break;
                }

                swap(parentIndex, childIndex);

                childIndex = parentIndex;
                parentIndex = parentIndex / 2;
            }
        }

        @Override
        public long pop() {
            if (heapIndex == 0) {
                return 0;
            }

            long ret = heap[ROOT_INDEX];

            // move last element to root
            heap[ROOT_INDEX] = heap[heapIndex];
            heap[heapIndex--] = Long.MAX_VALUE;

            // calculate min heap
            int parentIndex = ROOT_INDEX, leftChildIndex = parentIndex * 2, rightChildIndex = leftChildIndex + 1;
            while (parentIndex < heapIndex) {
                if (leftChildIndex > MAX_MIN_HEAP_INDEX || rightChildIndex > MAX_MIN_HEAP_INDEX) {
                    break;
                }

                int targetChildIndex = leftChildIndex;
                if (heap[leftChildIndex] > heap[rightChildIndex]) {
                    targetChildIndex = rightChildIndex;
                }

                if (heap[parentIndex] <= heap[targetChildIndex]) {
                    break;
                }

                swap(parentIndex, targetChildIndex);

                parentIndex = targetChildIndex;
                leftChildIndex = parentIndex * 2;
                rightChildIndex = leftChildIndex + 1;
            }

            return ret;
        }

        private void swap(int firstIndex, int secondIndex) {
            long preFirstValue = heap[firstIndex];
            heap[firstIndex] = heap[secondIndex];
            heap[secondIndex] = preFirstValue;
        }
    }
}