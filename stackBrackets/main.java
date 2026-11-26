package stackBrackets;

public class main {

    public void main(String[] args) {
        System.out.println(isValidStack("[{}]"));
        System.out.println(isValidStack("(()())"));
        System.out.println(isValidStack("{]"));
        System.out.println(isValidStack("[()]))()"));
        System.out.println(isValidStack("[]{}({})"));
    }



    public boolean isValidStack(String stackList){
        Stack stack = new Stack();
        for (char c : stackList.toCharArray()){
            if(!stack.decideAction(c)) return false;
        }
        return true;
    }
}
