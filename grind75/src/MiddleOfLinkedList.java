public class MiddleOfLinkedList {

    public class ListNode {

        int val;
        ListNode next ;

        ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }

    public ListNode middleMode(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        MiddleOfLinkedList solution = new MiddleOfLinkedList();

        // Creating a sample linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = solution.new ListNode(1);
        head.next = solution.new ListNode(2);
        head.next.next = solution.new ListNode(3);
        head.next.next.next = solution.new ListNode(4);
        head.next.next.next.next = solution.new ListNode(5);

        // Finding the middle node
        ListNode middleNode = solution.middleMode(head);

        // Printing the value of the middle node
        System.out.println("The middle node's value is: " + middleNode.val);
    }
}
