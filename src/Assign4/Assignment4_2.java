package Assign4;

public class Assignment4_2 {
    public Node4_1 root;
    public Assignment4_2(String s1, String s2) {

    }
    public String report_bits_preorder() {

    }
    public String report_bits_levelorder() {

    }
    public String report_preorder() {

    }
    public String report_levelorder() {

    }

    private Node4_1 consHelper1(Node4_1 node, char[] s1){
        if (s1.length == 0)
            return null;
        int k = 0;
        for (k=0; k<s1.length; k++){
            if (s1[k] != 'x')
                break;
        }

        if (s1[k] == '1') {
            s1[k] = 'x';
            node.left = consHelper1(node.left, s1);
        }
        else
            s1[k] = 'x';

        if (s1[k+1] == '1'){
            s1[k+1] = 'x';
            node.right = consHelper1(node.right, s1);
        }
        else
            s1[k+1] = 'x';

        return node;
    }
}