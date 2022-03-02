package PriorityQueue;

import sun.awt.geom.AreaOp;

// max heap implementation
public class PriorityQueue1 {
    private Integer[] heap;
    private int lastIndex;

    PriorityQueue1(Integer size) {
        this.heap = new Integer[size];
        this.lastIndex = 0;
    }

    void enqueue(Integer value) {
        if (lastIndex + 1 > heap.length - 1) {
            Integer[] tempHeap = heap;
            heap = new Integer[tempHeap.length * 2];
            for (int i = 0; i < tempHeap.length; i++) {
                heap[i] = tempHeap[i];
            }
        }
        lastIndex++;
        heap[lastIndex] = value;
        shiftUp();
        String test = "";
        for (int i = 0; i < heap.length; i++) {
            test += " " + heap[i] + " ";
        }
        System.out.println(test);
    }

    Integer dequeue() {
        if (lastIndex <= 0) return null;
        Integer rootValue = heap[1];
        swap(1, lastIndex);
        lastIndex--;
        shiftDown();
        return rootValue;
    }

    // shift the last element of the heap up
    private void shiftUp() {
        int index = lastIndex;
        int parentIndex = parent(index);
        while (parentIndex > 0 && heap[index] > heap[parentIndex]) {
            swap(index, parentIndex);
            index = parentIndex;
            parentIndex = parent(parentIndex);

        }
    }

    // shift the root element of the heap down
    private void shiftDown() {
        int index = 1; // root
        while (index < lastIndex) {
            int maxValue = heap[index];
            int maxIndex = index;
            int leftIndex = left(index);
            if (leftIndex > 0 && maxValue < heap[leftIndex]) {
                maxValue = heap[leftIndex];
                maxIndex = left(index);
            }
            int rightIndex = right(index);
            if (rightIndex > 0 && maxValue < heap[rightIndex]) {
                maxValue = heap[rightIndex];
                maxIndex = rightIndex;
            }
        }

    }

    private int parent(int index) {
        if (index <= 1) return 0;
        return index / 2;
    }

    private int left(int index) {
        int leftChild = index * 2;
        return leftChild <= lastIndex ? leftChild : 0;
    }

    private int right(int index) {
        int rightChild = index * 2 + 1;
        return rightChild <= lastIndex ? rightChild : 0;
    }

    private void swap(int index1, int index2) {
        int temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }
}

