package dupWithLimit;

import java.util.HashSet;

//Given a string , check if there exists a duplicate and in there make sure abs (i-j) <= k
public class main {
    public void main(String[] args){
        System.out.println(useLoop("astyware" , 3));
        System.out.println(useLoop("asrdare" , 3));

        System.out.println(useMaps("assware" , 3));
    }

    public boolean useMaps(String input , int limit){
        HashSet<Character> characters = new HashSet<>();
        for (int i = 0 ; i < input.length() ; i++){
//            Check to see if item already exists
            Character c = input.charAt(i);
            if(characters.contains(c)) return true;
            characters.add(c);

//            Remove the first item if the limit has been exceeded
            if(characters.size() > limit){
                characters.remove(input.charAt(i - limit));
            }

        }
         return false;
    }

    public boolean useLoop(String input , int limit ){
        for (int i = 0 ; i< input.length() - limit ; i++){
            for(int j = i + 1; j < i+limit ; j++ ){
                if(input.charAt(i) == input.charAt(j)) return true;
            }
        }
        return false;
    }
}
