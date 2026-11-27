package stack;

public class Stack<T> {
    Node<T> head;
    Node<T> tail;
    int size = 0 ;
    public Stack(T start){
        Node<T> startNode = new Node<>(start);
        this.head = startNode;
        this.tail = startNode;
        size++;
    }


    public void enqueue (T item){
//        Check if the head exists
        Node<T> node = new Node<>(item);
        size++;
        if(this.head == null) {
            this.tail = this.head = node;
            return;
        };

//        Change the tail to point to the next one
        this.tail.next = new Node<>(item);
        this.tail = this.tail.next;
    }

    public void dequeue () throws IllegalAccessException {
//       Change the head to point to the next one.
        if(this.head == null ) throw new IllegalAccessException("There is nothing in the queue");
        Node<T> removed = this.head;
        this.head = this.head.next;
        System.out.println("removed " + removed.value);
        size--;
    }

    public Node<T> peek (){
        return this.head;
    }

    public int size(){
        return this.size;
    }

    public void traverse(){
        Node<T> current = head;
        while(current != null){
            System.out.println(current.value);
            current = current.next;
        }

        System.out.println("The size of the queue is " + this.size());
    }
}
