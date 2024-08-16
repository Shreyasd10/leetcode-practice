import java.util.Stack;

public class ImplementQueueUsingStacks {

    class MyQueue {

        Stack<Integer> stack = new Stack<>();
        Stack<Integer> helperStack = new Stack<>();

        public void push(int x) {
            stack.push(x);
        }

        public int pop() {
            if(helperStack.isEmpty()){
                while(!stack.isEmpty()){
                    helperStack.push(stack.pop());
                }
            }
            return helperStack.pop();
        }

        public int peek() {
            if(helperStack.isEmpty()){
                while(!stack.isEmpty()){
                    helperStack.push(stack.pop());
                }
            }
            return helperStack.peek();
        }

        public boolean empty() {
            return stack.isEmpty() && helperStack.empty();
        }
    }

    public static void main(String[] args) {
        ImplementQueueUsingStacks obj = new ImplementQueueUsingStacks();
        MyQueue queue = obj.new MyQueue();

        // Testing the push operation
        queue.push(1);
        queue.push(2);
        queue.push(3);

        // Testing peek operation
        System.out.println("Peek: " + queue.peek()); // Should print 1

        // Testing pop operation
        System.out.println("Pop: " + queue.pop()); // Should print 1

        // Testing if the queue is empty
        System.out.println("Is queue empty? " + queue.empty()); // Should print false

        // Popping the remaining elements
        System.out.println("Pop: " + queue.pop()); // Should print 2
        System.out.println("Pop: " + queue.pop()); // Should print 3

        // Checking if the queue is empty after popping all elements
        System.out.println("Is queue empty? " + queue.empty()); // Should print true
    }
}
