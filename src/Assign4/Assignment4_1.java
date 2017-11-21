package Assign4;

import javax.xml.soap.Node;

/**
 * Created by insung151 on 11/21/17.
 */
public class Assignment4_1 {
    public Node4_1 root;
    public Assignment4_1(String line1, String line2) {
        char[] charArr = line1.toCharArray();
        root = consHelper(0,charArr, line2, charArr);

    }
    public Node4_1 getRoot() {
        return root;
    }

    private Node4_1 consHelper(int i, char[] charArr, String line2){
        int[] arr = {0};
        int cnt = 0;
        while (arr.length == 0){
            String s = "";
            int tmp = 0;
            while (tmp == 0) {
                if (tmp % 2 == 0) {
                    tmp = tmp / 2;
                    s = "r" + s;
                } else {
                    tmp = (tmp - 1) / 2;
                    s = "l" + s;
                }
            }
            Node4_1 tmpNode = root;
            for (int j = 0; j<s.length()-1; j++){
                if (s.charAt(j) == 'r')
                    tmpNode = tmpNode.right;
                else
                    tmpNode = tmpNode.left;
            }

            if (s.length() == 0){
                if (charArr[0] == '0'){
                    root = new Node4_1(line2.charAt(0),charArr[0]);
                    int[] new
                }

                else
                    root = new Node4_1('1', charArr[0])
            }
        }
    }

    private Node4_1[] resize(Node4_1[] nodes, int n){
        Node4_1[] newArr = new Node4_1[n];
        for (int i=0; i<nodes.length; i++){
            newArr[i] = nodes[i];
        }
        return newArr;
    }
}