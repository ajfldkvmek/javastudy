package collection.link;

public class NodeMain3 {

    public static void main(String[] args) {

        Node node = new Node("A");
        node.next = new Node("B");
        node.next.next = new Node("C");

        System.out.println("모든 노드 탐색");
        System.out.println("모든 노드 탐색");
        System.out.println(node);

        Node lastNode = getLastNode(node);
        System.out.println("lastNode: " + lastNode);

        int index = 2;
        Node index2Node = getNode(node, index);
        System.out.println(index + " Node item: " + index2Node);

    }

    public static void add(Node node, String param){
        Node lastNode = getLastNode(node);
        lastNode.item = new Node(param);
    }

    private static Node getNode(Node node, int index) {

        Node x = node;
        for(int i = 0; i < index; i++){
            x = x.next;
        }
        return x;
    }

    private static Node getLastNode(Node node){
        Node x = node;
        while(x.next != null){
            x = x.next;
        }
        return x;
    }



}
