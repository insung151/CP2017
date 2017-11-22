package Assign4;

public class Assignment4_2 {
    public Node4_1 root;
    public Assignment4_2(String s1, String s2) {
        consHelper1(root, s1.toCharArray());
    }
    public String report_bits_preorder() {
        return bits_preorder(root);
    }
//    public String report_bits_levelorder() {
//
//    }
//    public String report_preorder() {
//
//    }
//    public String report_levelorder() {
//
//    }

    private String bits_preorder(Node4_1 node){
        String s = "";
        s += node.label;
        if (node.left != null)
            s += bits_preorder(node.left);
        if (node.right != null)
            s += bits_preorder(node.right);
        return s;
    }

    private Node4_1 consHelper1(Node4_1 node, char[] s1){
        if (s1.length == 0)
            return null;
        int k = 0;
        for (k=0; k<s1.length; k++){
            if (s1[k] != 'x')
                break;
        }

        Node4_1 newNode = new Node4_1();
        newNode.label = s1[k] + s1[k+1];
        if (s1[k] == '1') {
            s1[k] = 'x';
            newNode.right = consHelper1(node.left, s1);
        }
        else
            s1[k] = 'x';

        if (s1[k+1] == '1'){
            s1[k+1] = 'x';
            newNode.left = consHelper1(node.right, s1);
        }
        else
            s1[k+1] = 'x';
        return newNode;
    }
}