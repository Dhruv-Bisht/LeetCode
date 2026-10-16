/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> m = new HashMap<>();

        for(Node curr = head; curr != null; curr = curr.next){
            m.put(curr, new Node(curr.val));
        }

        for(Node curr = head; curr!= null; curr = curr.next){
            Node clone = m.get(curr);
            clone.next = m.get(curr.next);
            clone.random = m.get(curr.random);
        }
        return m.get(head);
    }
}