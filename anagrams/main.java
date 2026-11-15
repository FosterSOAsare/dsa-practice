package anagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//Given two words , check to see if the words contain the same characters
public class main {
    public void main(String[] args){
//        Anagrams
        System.out.println(loopMethod("cat" , "atcs"));
        System.out.println(loopMethod("cssat" , "atcss"));

        System.out.println(freqMethodMaps("cssat" , "atcss"));
        System.out.println(freqMethodMaps("cat" , "atcs"));
        System.out.println(freqMethodMaps("catf" , "atcs"));

        System.out.println(freqMethodArrays("cat" , "atc"));
        System.out.println(freqMethodMaps("csgat" , "atcss"));
    }

    public boolean loopMethod(String input1 , String input2){
        if(input1.length() != input2.length()) return false;
        String tracker = input2;
        for (int i = 0 ; i < input1.length() ; i++){
//          if it exists remove it
            char c = input1.charAt(i);
            int index = tracker.indexOf(c);
            if(index  == -1) return false;

    //      Remove from input 2
            tracker  = tracker.substring(0 , index) + input2.substring(index + 1);

        }
        return true;
    }

    public boolean freqMethodMaps(String input1 , String input2){
        if (input1.length() != input2.length()) return false;

//        Create key to hold values
        HashMap<Character , Integer> frequencies = new HashMap<Character, Integer>();

        for (int i = 0 ; i < input1.length() ; i++){
//            String one adds to frequency and string 2 subtracts
            Character input1char = input1.charAt(i);
            Character input2char = input2.charAt(i);
            Integer freq1 = frequencies.getOrDefault( input1char , 0);
            frequencies.put(input1char , freq1 + 1);

            Integer freq2 = frequencies.getOrDefault( input2char , 0);
            frequencies.put(input2char , freq2 -1) ;
        }
//        make sure all entries are 0
        return frequencies.keySet().stream().allMatch(k ->frequencies.get(k)== 0);
    }

    public boolean freqMethodArrays(String input1 , String input2){
        if (input1.length() != input2.length()) return false;

//        Initialize array to 0 for all 26 characters
        int[] freqs = new int[26];
        for (int i = 0 ; i < input1.length() ; i++){
//            Add and sub as expected
//            get the character and the index from array

//            Convert character to a number
            int index1 = (int) (input1.charAt(i) - 'a');
            int index2 = (int) (input2.charAt(i) - 'a');
            freqs[index1] += 1;
            freqs[index2] -= 1;
        }
        return Arrays.stream(freqs).allMatch(i -> i== 0);
    }
}
