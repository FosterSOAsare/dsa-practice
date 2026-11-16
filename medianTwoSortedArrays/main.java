package medianTwoSortedArrays;

//Find the median of two sorted arrays
public class main {


    public  void main(){
        int[] arr1 = {1,2} , arr2 = {3 , 4};
        System.out.println(getMedian( arr1 , arr2));
    }

//    works for odd but not even
    public double getMedian(int[] arr1 , int[] arr2){
    int pointer1  = 0  , pointer2 = 0 ;
    int totalLength = arr1.length + arr2.length;

//    This is the exact index of the middle item
    boolean isEven = totalLength % 2 == 0;

//    All minus 1 because if 3 items median Pos will be 2 but index 1.
    int medianPos = (isEven ? totalLength / 2 : ((totalLength - 1) / 2));
    double median = 0;

//    Populate for odds.
    for (int i = 0 ; i <= medianPos ; i++){
//      For even , we need the last two values and for odd , we need just the last value
        boolean isLast = i == medianPos;
        boolean isLastButOne = isEven && i == medianPos - 1;
        System.out.println(pointer1 + "" + pointer2);
        if(arr1[pointer1] < arr2[pointer2]){
            pointer1 += 1;
//            Minus 1 because pointer starts from 0
            if(isLastButOne) median = arr1[pointer1 - 1 ] ;
            if(isLast) {
                int val =  arr1[pointer1 - 1];
                median = isEven ? (median + val ) / 2 : val;
            };
        }else{
            pointer2 += 1;
            if(isLastButOne) median = arr2[pointer2 - 1 ] ;
            if(isLast) {
                int val =  arr2[pointer2 - 1];
                median = isEven ? (median + val ) / 2 : val;
            };
        }

    }

        return median;
    }
}
