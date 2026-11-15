package duplicates;
import java.util.HashSet;


// Check if a given string contains duplicates
public class main {

    public static void main(String[] args){
       System.out.println( hasDuplicates("Test"));

     Loop lp = new Loop();
       System.out.println(lp.checkDuplicatewithLoop("Seat"));
    }
    public static boolean hasDuplicates(String input){
        HashSet<Character> charSet = new HashSet<>();

        for (int i = 0 ; i< input.length() ; i++ ){
            // Find out if the value already exists 
            if(charSet.contains(input.charAt(i))) return  true;
            charSet.add(input.charAt(i));
        }
        return false;
    }
    
}
