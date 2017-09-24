package stack;

import java.util.LinkedList;

public class ImplementWithLinkedList {

	LinkedList<Integer> queue = new LinkedList<Integer>();
//	LinkedList<object>
//	add(), offer()=addLast()  |  addFirst()
//  peek() = getFirst()       |  getLast()
//	remove() = removeFirst()  |  removeLast()
	public void push(int x){
		if(queue.isEmpty()){
			queue.offer(x);
		}else{
			queue.add(x);
		}
	}

	public void pop(){
		if(!queue.isEmpty()){
			queue.removeLast();
		}
	}
	public int top(){
		if(queue.isEmpty()){
			throw new NullPointerException();
		}
		return queue.getLast();
	}
	
	public boolean isEmpty(){
		return queue.isEmpty();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ImplementWithLinkedList t = new ImplementWithLinkedList();
		t.queue.offer(1);
		t.queue.addLast(2);
		t.queue.offer(3);
		t.push(4);
		System.out.println(t.queue);
		t.pop();
		System.out.println(t.queue);
		System.out.println(t.top());
		System.out.println(t.isEmpty());
		

	}
	
	
}
