package heaps;

public class BinaryHeap {
    int[] heap;
//    Create a heap from an array
    public BinaryHeap(int[] arr) {
//        Create the heap
        this.heap = new int[arr.length];

//        Loop the array and get the item O(n)
        for (int i = 0 ; i < arr.length ; i++){
//           get the parentIndex. -1 because trees uses 1 as the start index.
            int parentIndex = (i + 1) / 2 - 1;
            if(i == 0 || this.heap[parentIndex] >= arr[i]){
                this.heap[i] = arr[i];
                continue;
            }

            int childIndex = i;

//           Swap as far as the child is greater than the parent
            while(parentIndex != childIndex && this.heap[parentIndex] < arr[i]){
//                Swap the values
               this.heap[childIndex] = this.heap[parentIndex];
               this.heap[parentIndex] = arr[i];

                childIndex = parentIndex;
                parentIndex = parentIndex / 2;
            }
        }


    }


    public void iterateHeap(){
        for (int i : this.heap){
            System.out.print( + i + " ");
        }
        System.out.println(" ");
    }
}
