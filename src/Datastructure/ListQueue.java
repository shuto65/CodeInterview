package Datastructure;

public class ListQueue {
	//int head=0;
//	int tail=0;
	Node head=null;
	Node tail=null;

	public class Node{
		int d;
		Node next;
		
		public Node(int d){
			this.d = d;
			this.next = null;
		}
		
		public int getItem(){
			return this.d;
		}
		
		@Override
		public boolean equals(Object obj){
			if(this == obj){
				return true;
			}
			if(!(obj instanceof Node)){
				return false;
			}
			Node node = (Node)obj; 
			if(this.d == node.d){
				return true;
			}
			return false;	  
		}
	}
	public void make_head(){
		
	}
	public void enqueue(int d){
		if(this.tail == null)
			this.head = new Node(d);
		else{
			Node prevtail = this.tail;
			prevtail.next = new Node(d);
		}
	}
	
	public void dequeue(){
		Node tmp_head = this.head;
		this.head = tmp_head.next;
		System.out.print(tmp_head.d);
	}
	
}