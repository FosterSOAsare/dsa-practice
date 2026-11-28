package heaps;

public class main {
    public void  main(String[] args){
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        BinaryHeap heap = new BinaryHeap(arr);
        heap.createHeap();
//        heap.iterateHeap();
        heap.heapifyBetter();

//        This converts the heap from what it was to a sorted array in ascending order
//        for (int i = 0 ; i < arr.length ; i++){
//            heap.deleteElement();
//            heap.iterateHeap();
//        }


    }
}
