package Heap;

import java.util.Random;

/**
 * Created by Khmely on 19.04.2018.
 */

public class Heap {
    int[] heap;

    public Heap(){
        heap = new int[0];
    }

    public Heap(int size){
        heap = new int[size];
    }

    void random(int n){
        Random rand = new Random();
        for(int i=0; i<heap.length; i++){
            heap[i] = rand.nextInt(n);
        }

    }
    void print(){
        for(int i=0; i<heap.length; i++){
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    void buildHeap(){
        int n = heap.length;
        for(int i = n/2-1; i>=0; i--){
            min(n, i);
        }
    }

    public void min(int n, int i){
        int left = i*2+1;
        int right = i*2+2;
        int least = i;
        if(left < n && heap[left] < heap[i]){
            least = left;
        }

        if(right < n && heap[right] < heap[least]){
            least = right;
        }

        if(least != i){
            int tmp = heap[i];
            heap[i] = heap[least];
            heap[least] = tmp;
            min(n, least);
        }
    }

    void sort(){
        buildHeap();
        int n=heap.length;
        for(int i = n-1; i>=0; i--){
            int tmp = heap[0];
            heap[0] = heap[i];
            heap[i] = tmp;
            min(i, 0);
        }
    }

    private void expand(){
        int[] tmp = new int[heap.length+1];
        for(int i = 0; i<heap.length; i++)
            tmp[i] = heap[i];
        heap = tmp;
    }

    private void reduce(){
        int[] tmp = new int[heap.length - 1];
        for(int i = 1; i < heap.length; i++)
            tmp[i-1] = heap[i];
        heap = tmp;
    }
    public void enqueue(int v)
    {
        expand();
        heap[heap.length - 1] = v;
        buildHeap();
    }

    public String dequeue()  {
        if(heap.length==0){
            return "Queue is Empty";

        }
        int result = heap[0];
        reduce();
        buildHeap();
        return "Dequeue: " + result;
    }

    public String delete( int i)  {
        if(i >= heap.length){
            return "There is no such index";
        }
        int result = heap[i];
        heap[i] = heap[0];
        reduce();
        buildHeap();
        return "Deleted: " + result;
    }
    public void change(int index, int newValue){
        heap[index] = newValue;
        expand();
        buildHeap();
        delete(index);
    }
}

