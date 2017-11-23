package Assign4;

public class Queue4_1 {
    private class Node{

        private Object  data;
        private Node nextNode;

        Node(Object data){
            this.data = data;
            this.nextNode = null;
        }
    }

    private Node front;
    private Node rear;

    public Queue4_1(){
        this.front = null;
        this.rear = null;
    }

    public boolean empty(){
        return (front==null);
    }

    public void insert(Object item){

        Node node = new Node(item);
        node.nextNode = null;

        if(empty()){

            rear = node;
            front = node;

        }else{

            rear.nextNode = node;
            rear = node;

        }
    }

    public Object peek(){
        if(empty()) throw new ArrayIndexOutOfBoundsException();
        return front.data;
    }

    public Object remove(){

        Object item = peek();
        front = front.nextNode;

        if(front == null){
            rear = null;
        }

        return item;
    }

}
