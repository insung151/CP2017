package Assign4;

public class Assignment4_1 {
    public Node4_1 root;
    public Assignment4_1(String line1, String line2) {
        char[] charArr = line1.toCharArray();
        constructor(line1, line2);
//        consHelper(charArr, line2);
    }
    public Node4_1 getRoot() {
        return root;
    }

    private void constructor(String line1, String line2){
        int internal=0, j=0 ;
        if (line1.length() == 0)
            return;
        root = new Node4_1();
        Queue4_1 queue = new Queue4_1();
        queue.insert(root);
        while(!queue.empty()){
            Node4_1 node = (Node4_1)queue.remove();
            if (line1.charAt(j) == '0'){
                node.character = line2.charAt(internal);
                node.label = line1.charAt(j);
                node.left = new Node4_1();
                node.right = new Node4_1();
                queue.insert(node.left);
                queue.insert(node.right);
                internal++;
            }
            else{
                node.label= line1.charAt(j);
            }
            j++;
        }
    }
    /*
    private void consHelper(char[] charArr, String line2){
        if (charArr.length == 0)
            return ;
        if (charArr[0] == '0') {
            root = new Node4_1();
            root.character = charArr[0];
            root.label = line2.charAt(0);
        }
        else {
            root.character = charArr[0];
            root.label = '1';
        }

        Node4_1[] nodeArr = {root};
        int k = 0;
        int j = 0;
        while (nodeArr.length != 0){
            if (charArr[k] == '0'){
                nodeArr[0].character = line2.charAt(j);
                nodeArr[0].label = charArr[k];
                nodeArr[0].right = new Node4_1();
                nodeArr[0].left = new Node4_1();
                nodeArr = append(nodeArr, nodeArr[0].left);
                nodeArr = append(nodeArr, nodeArr[0].right);
                j++;
            }else{
                nodeArr[0].label = charArr[k];
                nodeArr[0].character = '1';
            }
            k++;
            nodeArr = pop(nodeArr);
        }
    }

    private Node4_1[] append(Node4_1[] nodes ,Node4_1 node){
        Node4_1[] newNodes = new Node4_1[nodes.length+1];
        for (int i=0; i<nodes.length; i++){
            newNodes[i] = nodes[i];
        }
        newNodes[nodes.length] = node;
        return newNodes;
    }

    private Node4_1[] pop(Node4_1[] nodes){
        Node4_1[] newNodes = new Node4_1[nodes.length-1];
        for (int i=0; i<nodes.length-1; i++){
            newNodes[i] = nodes[i+1];
        }
        return newNodes;
    }
    */
}