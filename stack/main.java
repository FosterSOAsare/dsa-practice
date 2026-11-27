package stack;

public class main {
    public void main(String[] args){

       Stack<String> st = new Stack<>("First");
       st.enqueue("Second");
       st.enqueue("Third");

       st.traverse();

       try {
          st.dequeue();
          st.dequeue();
          st.dequeue();
       }catch(Exception e){
          System.out.println(e.getMessage());
          System.exit(0);
       }

       st.enqueue("Start Over");
       st.traverse();
    }
}
