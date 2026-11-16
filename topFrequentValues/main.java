package topFrequentValues;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class main {
    public  void main(String[] args){
        int[] values = {1,1,2,3,4,4,3,4,3,4,5,5,5,5,5};
        int[] topFreq = getTopKFrequencies(values , 3);

        for (int f : topFreq){
            System.out.println(f);
        }
    }

    public int[] getTopKFrequencies(int[] arr , int k){
        if (k == arr.length) return arr;
//        Create a map for the frequencies
        HashMap<Integer, Integer> freqs = new HashMap<>();

        for (int item : arr){
//            Store value and frequency
            freqs.put(item  , freqs.getOrDefault(item , 0) + 1);
        }

//        Now the priority queue to store just the ones with highest freq
//        Whenever an item is added, sort and send the smallest to the front
//        PriorityQueue<Integer> pQueue = new PriorityQueue<>((a , b) -> freqs.get(a) - freqs.get(b));
        PriorityQueue<Integer> pQueue = new PriorityQueue<>(Comparator.comparingInt(freqs::get));


//        Pack items in the queue
        for (int keyItem : freqs.keySet()){
            pQueue.add(keyItem);

//            if the size of the queue is greater than the required limit, remove the smallest values
            if(pQueue.size() > k){
                pQueue.poll();
            }
        }


//        Pack into an arr
        int[] result = new int[k];
        for (int i = 0 ; i < k  ; i++){
            result[i] = pQueue.poll();
        }
        return result;
    }
}
