package Assign4;

public class Queue4_1 {
    private class Node{

        private Object data;
        private Node next;

        Node(Object data){
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;

    public Queue4_1(){
        this.head = null;
        this.tail = null;
    }

    public boolean empty(){
        return (head==null);
    }

    public void insert(Object item){

        Node node = new Node(item);
        node.next = null;

        if(empty()){
            tail = node;
            head = node;
        }else{
            tail.next = node;
            tail = node;
        }
    }

    public Object peek(){
        if(empty()) throw new ArrayIndexOutOfBoundsException();
        return head.data;
    }

    public Object remove(){

        Object item = peek();
        head = head.next;

        if(head == null){
            tail = null;
        }
        return item;
    }

}
