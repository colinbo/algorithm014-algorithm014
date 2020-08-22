import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TreeNodes {

    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<Integer>();
        LinkedList<Node> stack = new LinkedList<Node>();
        if (root == null)
            return list;

        stack.addFirst(root);
        while (!stack.isEmpty()){
            Node node = stack.pollLast();
            list.add(node.val);
            if (node.children != null){
                for (int i = node.children.size() -1; i >= 0; i--){
                    stack.add(node.children.get(i));
                }
            }

        }

        return list;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        List<Node> list1 = new LinkedList<>();
        list1.add(node2);
        list1.add(node3);
        node1.children = list1;
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        List<Node> list2 = new LinkedList<>();
        list2.add(node4);
        list2.add(node5);
        node2.children = list2;
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        List<Node> list3 = new LinkedList<>();
        list3.add(node6);
        list3.add(node7);
        list3.add(node8);
        node3.children = list3;


        List result = new TreeNodes().preorder(node1);
        System.out.println(result);
    }

}

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public  Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
