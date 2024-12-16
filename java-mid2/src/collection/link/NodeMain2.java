package collection.link;

public class NodeMain2 {

    public static void main(String[] args) {

        Node node = new Node("A");
        node.next = new Node("B");
        node.next.next = new Node("C");

        System.out.println("모든 노드 탐색");
        System.out.println("모든 노드 탐색");
        System.out.println(node);

    }
}
