package productExceptSelf;

import java.util.Arrays;

public class main {
    public  void main(String[] args){
        int[] nums = {4,2,3,7,5};
        int[] products = getProductExceptSelf(nums);
        for (int p : products){
            System.out.println(p);
        }
    }

    public int[] getProductExceptSelf(int[] arr){

//        create a new array of the same length
        int[] products = new int[arr.length];
        Arrays.fill(products, 1);

        int prefix = 1 , postfix = 1;

        for (int i = 0 ; i < arr.length ; i++){
//          prefix for all except the first
            products[i] *=  prefix;
            prefix *= arr[i];

            int j = arr.length - 1 - i;
            products[j] *= postfix;
            postfix *= arr[j];
        }
        return products;
    }
}
