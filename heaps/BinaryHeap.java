package heaps;

public class BinaryHeap {
    int[] heap;
    int lastIndex;
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

        this.lastIndex = arr.length - 1 ;



    }


    public void iterateHeap(){
        for (int i : this.heap){
            System.out.print( + i + " ");
        }
        System.out.println(" ");
    }

    public int deleteElement (){
//        To delete, get the head which is the first item
        int root = this.heap[0];
//        get the last item in the arr and fix it at the top
        this.heap[0] = this.heap[this.lastIndex];
        this.heap[this.lastIndex ] = 0;

//
        int parentNodeIndex = 0;
        while(parentNodeIndex * 2 + 1 <= lastIndex && this.heap[parentNodeIndex] < Math.max(this.heap[parentNodeIndex * 2 + 1] , this.heap[parentNodeIndex * 2])){
            int greatestIndex = this.heap[parentNodeIndex * 2 + 1] > this.heap[parentNodeIndex * 2] ? parentNodeIndex * 2 + 1 : parentNodeIndex * 2 ;
            int parentNode = this.heap[parentNodeIndex];
            this.heap[parentNodeIndex] = this.heap[greatestIndex];
            this.heap[greatestIndex] = parentNode;
            parentNodeIndex = greatestIndex ;
//
        }
//
        this.lastIndex--;

        return root;
    }
}
