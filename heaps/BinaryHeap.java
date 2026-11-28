package heaps;

public class BinaryHeap {
    int[] heap;
    int[] arr;
    int lastIndex;
//    Create a heap from an array
    public BinaryHeap(int[] arr) {
//        Create the heap
        this.arr = arr;
        this.lastIndex = arr.length;
    }


    public void iterateHeap(){
        for (int i : this.heap){
            System.out.print( + i + " ");
        }
        System.out.println(" ");
    }

    public void createHeap(){
        this.heap = arr.clone();

        for (int i = 0 ; i < this.arr.length ; i++){
            if(i == 0 ) continue;
            int parentIndex = (i - 1 )/ 2;
            int childIndex = i;

            if(this.heap[parentIndex] >= this.heap[childIndex]) continue;

//           Swap as far as the child is greater than the parent
            while( childIndex > 0 && this.heap[parentIndex] < this.heap[childIndex]){
//                Swap the values
                int tmp = this.heap[childIndex];
                this.heap[childIndex] = this.heap[parentIndex];
                this.heap[parentIndex] = tmp;

                childIndex = parentIndex; parentIndex = (parentIndex - 1) / 2;

            }
        }

        this.lastIndex = this.heap.length - 1 ;

        this.iterateHeap();
    }

    public int delElem(){
        if(this.lastIndex < 0) throw new IllegalStateException("Heap is empty");
        int root = this.heap[0];
//        get the last item in the arr and fix it at the top
        this.heap[0] = this.heap[this.lastIndex];


        int parentNodeIndex = 0;
//        Get the children and the largest value
        while (parentNodeIndex * 2 + 1 <= lastIndex){
//            get the greatest child index
            int greatestIndex = parentNodeIndex * 2 + 1;
            if(greatestIndex + 1 <= lastIndex){
                greatestIndex = this.heap[greatestIndex] > this.heap[greatestIndex + 1] ? greatestIndex : greatestIndex + 1 ;
            }
            if(this.heap[parentNodeIndex] >= this.heap[greatestIndex]) break;

            int parentNode = this.heap[parentNodeIndex];
            this.heap[parentNodeIndex] = this.heap[greatestIndex];
            this.heap[greatestIndex] = parentNode;
            parentNodeIndex = greatestIndex ;
        }

        this.heap[this.lastIndex ] = 0;
        lastIndex--;
        return root;
    }

    public int deleteElement (){
//        To delete, get the head which is the first item
        int root = this.heap[0];
//        get the last item in the arr and fix it at the top
        this.heap[0] = this.heap[this.lastIndex];
        this.heap[this.lastIndex] = 0;

        int parentNodeIndex = 0;
        while(parentNodeIndex * 2 + 1 <= lastIndex && this.heap[parentNodeIndex] < Math.max(this.heap[parentNodeIndex * 2 + 1] , this.heap[parentNodeIndex * 2])){
            int greatestIndex = this.heap[parentNodeIndex * 2 + 1] > this.heap[parentNodeIndex * 2] ? parentNodeIndex * 2 + 1 : parentNodeIndex * 2 ;
            if(this.heap[greatestIndex] <= this.heap[parentNodeIndex]) break;
            int parentNode = this.heap[parentNodeIndex];
            this.heap[parentNodeIndex] = this.heap[greatestIndex];
            this.heap[greatestIndex] = parentNode;
            parentNodeIndex = greatestIndex ;
//
        }
//
//        Place the deleted item from the back
        this.heap[lastIndex] = root;
        this.lastIndex--;

        return root;
    }

//    Using two arrays don't work well. Best to clone the array
    public void heapifyBetter(){
        heap = arr.clone();
        int n = heap.length;
//        after cloning, the leaf elements are already in there so the loop starts at the part above the leaf elements
        for (int i = n / 2 - 1; i >= 0; i--) siftDown(i, n);
        this.iterateHeap();


    }

    private void siftDown(int i, int n) {
        while (2 * i + 1 < n) {
            int child = 2 * i + 1;
            // The greatest child index. If child + 1 and that child is greater, then increase index
            if (child + 1 < n && heap[child + 1] > heap[child]) child++;
            if (heap[i] >= heap[child]) break;   // the check you're missing
            int tmp = heap[i]; heap[i] = heap[child]; heap[child] = tmp;
            i = child;                            // follow the child you swapped with
        }
    }
}
