public class Node<T> {
    public Contact contact;
    public Event event;
    public Node<T> prev;
    public Node<T> next;
    
    public Node(){
        this.prev=null;
        this.next=null;
    }
    public Node(Contact c){
      this.contact = c;
    }
    public Node(Event e){
        this.event=e;
    }
}
