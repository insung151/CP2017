package Assign4;

public class LinkedList4_3 {
    private Node4_3 head;
    public int size ;
    public class Node4_3{
        public Object data;
        private Node4_3 next;

        public Node4_3(Object input) {
            this.data = input;
            this.next = null;
        }

    }
    public LinkedList4_3(){
        head = null;
        size = 0;
    }
    public Node4_3 get(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        Node4_3 cur = head;
        for (int i=0; i<index; i++){
            cur = cur.next;
        }
        return cur;
    }

    public void add(int index, Object data){
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException();

        Node4_3 cur = head;
        if (index == 0){
            Node4_3 newNode = new Node4_3(data);
            if (size == 0)
                head = newNode;
            else{
                newNode.next = head;
                head = newNode;
            }
        }
        else {
            Node4_3 tmp = get(index-1).next;
            get(index-1).next = new Node4_3(data);
            get(index-1).next.next = tmp;
        }
        size ++;
    }

    public void add(Object data){
        add(size, data);
    }

    public void remove(int index){
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        if (index == 0){
            head = head.next;
        }
        else{
            get(index-1).next = get(index-1).next.next;
        }
        size--;
    }

    @Override
    public String toString() {
        if (size == 0)
            return "[]";
        else{
            String s = "[";
            for (int i=0; i<size; i++){
                s += get(i).data + ",";
            }
            if (s.endsWith(",")){
                s = s.substring(0, s.length()-1);
            }
            return s+"]";
        }
    }
}
