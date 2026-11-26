package stackBrackets;

public class Stack {
//    Use a linkedlist
    Node head;

    public boolean decideAction(char value){
        String starts = "[({";

        int valueIndex = starts.indexOf(value);
        if (valueIndex != -1){
//            Then it is a push
            push(value);
            return true;
        }

//            The ending should always match the start
        String ends = "])}";
        int headIndex = head == null ? -1 : starts.indexOf(head.value);
        int endIndex = ends.indexOf(value);
        if(headIndex == endIndex) {
            pop();
            return true;
        };
        return false;
    }

    public void push (char value){
        Node nod = new Node(value);
        nod.next = head;
        head = nod;
    }

    public void pop(){
        head = head.next;
    }


}
