import structures.MinHeap;
import structures.Vector;

public class App {
    public static void main(String[] args) throws Exception {

        Vector rawHeap = new Vector(10);
        rawHeap.add(20, 33, 2, 1, 8, 3, 14);

        System.out.println("Original raw 'heap' ");
        System.out.println(rawHeap);

        MinHeap minHeap = new MinHeap(rawHeap);

        System.out.println("Converting a raw heap to a min heap");
        System.out.println(minHeap);

        int minimum = minHeap.poll();

        System.out.println("By removing the minimum element: " + minimum + ", we will have the new minimum heap:");
        System.out.println(minHeap);

        System.out.println("Using the heapSort algorithm on the vector 'rawheap' we will obtain the following sorted list:");
        System.out.println(MinHeap.heapSort(rawHeap));

    }
}
