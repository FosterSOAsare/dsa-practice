package twoSum;

import java.util.HashMap;

//Given an array and a target. Find two indexes such that the sum of the two is equal the target
public class main {
    public  void main(String[] args){
        int[] nums = {-3,4,3,90};
       int[] indexes =  getIndexes(nums , 0);
       for (int i : indexes){
           System.out.println(i);
       }
    }

    public int[] getIndexes(int[] nums, int target){
//        Create a map that holds the results
        HashMap<Integer , Integer> tracker = new HashMap<>();

        for (int i = 0 ; i < nums.length ; i++){
             if(tracker.containsKey(nums[i])) {
    //                 return indexes
                 System.out.println(tracker.get(nums[i])+ " " +  i);
                 return new int[]{tracker.get(nums[i]), i};
             }
//             if it doesn't exist store it.  Remainder , index
             tracker.put(target - nums[i] , i);
        }
        return nums;
    }
}
