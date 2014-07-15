package Datastructure;

public class Stack {

        public class Node{
            public int d;
            Node next;
            
            Node(int d, Node next){
                
                this.d = d;
                this.next = next;
                
            }
        }
        
        private Node top = null;
        int size;
        
        public Stack push(int d){
            if(top == null) {
                top = new Node(d, null);
            }
            top = new Node(d, top);
            return this;
        }
        
        public Node pop() {
            if(top == null) {
                return null;
            }
            Node node = top;
            top = top.next;
            return node;
        }
        
        
}
