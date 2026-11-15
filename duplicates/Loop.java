package duplicates;

public class Loop {
    // using the loop approach
    public  boolean checkDuplicatewithLoop(String inpuString){
        for (int i = 0 ; i < inpuString.length() ; i++){
            for (int j = i ; j < inpuString.length() ; j++){
                if(i == j ) return true;
            }
        }
        return false;
    }
}
