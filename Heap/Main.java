package Heap;

/**
 * Created by Khmely on 19.04.2018.
 */
public class Main {
    public static void main(String[] args){
        Heap heap = new Heap(10);
        heap.random(20);
        System.out.print("Not sorted table: ");
        heap.print();

        heap.buildHeap();
        System.out.print("Heap: ");
        heap.print();

        heap.sort();
        System.out.print("Sorted Table: ");
        heap.print();

        Heap queue = new Heap();
        queue.enqueue(3);
        queue.enqueue(5);
        queue.enqueue(9);
        queue.enqueue(2);
        queue.enqueue(11);
        System.out.println("============================================================================");
        queue.print();
        System.out.println("==============================Change========================================");
        queue.change(0,100);
        queue.print();
        System.out.println("============================================================================");
        System.out.println(queue.dequeue());
        queue.print();
        System.out.println(queue.dequeue());
        queue.enqueue(6);
        queue.print();
        System.out.println(queue.dequeue());
        queue.print();
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());

        System.out.println("============================================================================");
        queue.enqueue(3);
        queue.enqueue(9);
        queue.enqueue(5);
        queue.enqueue(2);
        queue.enqueue(11);

        queue.print();
        System.out.println(queue.delete(3));
        queue.print();
        System.out.println(queue.delete(2));
        queue.print();

    }

}
