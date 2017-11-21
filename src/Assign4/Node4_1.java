package Assign4;

public class Node4_1 {
    public char character; //where A~Z
    public char label;//where 0 or 1
    public Node4_1 left;
    public Node4_1 right;

    Node4_1(){}

    Node4_1(char character, char label){
        this.character = character;
        this.label = label;
    }
}