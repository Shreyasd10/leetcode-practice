import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LinkedListCycle {

    public class ListNode {

        int val;
        ListNode next ;

        ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        Set<ListNode> visited = new HashSet<>();
        ListNode curr = head;
        while(curr.next != null){
            if(visited.contains(curr)){
                return true;
            }
            visited.add(curr);
            curr = curr.next;
        }
        return false;
    }

    public boolean hasCycleV2(ListNode head) {
       ListNode slow  = head;
       ListNode fast = head;

       while(fast != null && fast.next != null){
           fast = fast.next.next;
           slow = slow.next;
           if(fast == slow) {
               return true;
           }
       }
       return false;
    }


    public static void main(String[] args) {
        LinkedListCycle list = new LinkedListCycle();

        // Create a linked list: 1 -> 2 -> 3 -> 4 -> 2 (cycle)
        ListNode head = list.new ListNode(1);
        ListNode node2 = list.new ListNode(2);
        ListNode node3 = list.new ListNode(3);
        ListNode node4 = list.new ListNode(4);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2; // Creates a cycle pointing back to node2

        // Check for a cycle
        boolean hasCycle = list.hasCycle(head);

        // Print the result
        System.out.println("Does the linked list have a cycle? " + hasCycle);
    }
}
