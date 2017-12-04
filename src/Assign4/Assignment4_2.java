package Assign4;

public class Assignment4_2 {
    public Node4_1 root;
    public Assignment4_2(String s1, String s2) {
        root = consHelper1(root, s1.toCharArray());
        Queue4_1 queue = new Queue4_1();
        if (root != null) {
            queue.insert(root);
            constructorHelper2(s2, queue, 0);
        }
    }

    public String report_bits_preorder() {
        return bits_preorder(root);
    }
    public String report_bits_levelorder() { return bits_levelorder(root); }
    public String report_preorder() {
        return preorder(root);
    }
    public String report_levelorder() {
        return levelorder(root);
    }

    private String bits_preorder(Node4_1 node){
        if (node == null)
            return "";
        String s = "";
        if (node.left != null)
            s+= "1";
        else
            s+= "0";
        if (node.right != null)
            s+= "1";
        else
            s+= "0";
        if (node.left != null)
            s += bits_preorder(node.left);
        if (node.right != null)
            s += bits_preorder(node.right);
        return s;
    }

    private String bits_levelorder(Node4_1 node){
        if (node == null)
            return "";
        Queue4_1 queue = new Queue4_1();
        queue.insert(node);
        String s = "";
        while(!queue.empty()){
            Node4_1 cur = (Node4_1)queue.remove();
            if (cur.left != null){
                queue.insert(cur.left);
                s += "1";
            }
            else{
                s += "0";
            }
            if (cur.right != null){
                queue.insert(cur.right);
                s += "1";
            }
            else{
                s += "0";
            }
        }
        return s;
    }

    private String preorder(Node4_1 node){
        if (node == null)
            return "";
        String s = "";
        s += node.label;
        if (node.left != null)
            s += preorder(node.left);
        if (node.right != null)
            s += preorder(node.right);
        return s;
    }

    private String levelorder(Node4_1 node){
        if (node == null)
            return "";
        String s = "";
        Queue4_1 queue = new Queue4_1();
        queue.insert(node);
        while (!queue.empty()){
            Node4_1 cur = (Node4_1) queue.remove();
            s += cur.label;
            if(cur.left != null)
                queue.insert(cur.left);
            if(cur.right != null)
                queue.insert(cur.right);
        }
        return s;
    }

    private Node4_1 consHelper1(Node4_1 node, char[] s1){
        if (s1.length == 0)
            return null;
        if (s1[s1.length-1] == 'x')
            return null;
        int k;
        for (k =0; k<s1.length; k++){
            if (s1[k] != 'x')
                break;
        }
        Node4_1 newNode = new Node4_1();
        char c1 = s1[k];
        char c2 = s1[k+1];
        s1[k] = 'x';
        s1[k+1] = 'x';
        if (c1 == '1')
            newNode.left = consHelper1(node, s1);

        if (c2 == '1')
            newNode.right = consHelper1(node, s1);

        return newNode;
    }

    private void constructorHelper2(String s2, Queue4_1 queue, int k){
        if (queue.empty())
            return ;
        Node4_1 cur = (Node4_1)queue.remove();
        cur.label = s2.charAt(k);
        k++;
        if (cur.left != null)
            queue.insert(cur.left);
        if (cur.right != null)
            queue.insert(cur.right);
        constructorHelper2(s2, queue, k);
    }
}