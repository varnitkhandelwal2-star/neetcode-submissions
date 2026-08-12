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
         HashMap<Node, Node> oldtocopy = new HashMap<>();   
        oldtocopy.put(null, null);                        
        Node curr = head;                                  
        while(curr!= null){
        Node copy = new Node(curr.val);
            oldtocopy.put(curr ,copy );
            curr = curr.next ; 
        }
        curr = head ;
        while (curr!= null){
            Node copy = oldtocopy.get(curr) ;
            copy.next =oldtocopy.get(curr.next) ;
            copy.random = oldtocopy.get(curr.random) ;
            curr = curr.next ;
        }
        return oldtocopy.get(head) ;
    }
}
