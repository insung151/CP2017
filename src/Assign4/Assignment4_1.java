package Assign4;

/**
 * Created by insung151 on 11/21/17.
 */
public class Assignment4_1 {
    public Node4_1 root;
    public Assignment4_1(String line1, String line2) {
        char[] charArr = line1.toCharArray();
        consHelper(charArr, line2);
//        System.out.println(line1);
    }
    public Node4_1 getRoot() {
        return root;
    }

    private void consHelper(char[] charArr, String line2){
        if (charArr.length == 0)
            return ;
        if (charArr[0] == '0')
            root = new Node4_1(charArr[0], line2.charAt(0));
        else
            root = new Node4_1(charArr[0],'1' );

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
}