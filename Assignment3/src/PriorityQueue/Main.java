package PriorityQueue;

import sun.awt.geom.AreaOp;

import javax.xml.soap.SOAPPart;

public class Main {
    public static void main(String[] args) {
int [] data = {3, 4, 2, 7, 1, 4, -1, 3, 8, -2, 10, 0};
PriorityQueue1 pq = new PriorityQueue1(4);
for (int i = 0; i < data.length; i++){
    pq.enqueue(data[i]);
}
for (int i =0; i < data.length; i++){
    System.out.println(pq.dequeue());
}
    }
}
