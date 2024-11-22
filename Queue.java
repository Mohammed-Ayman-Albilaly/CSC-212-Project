public class Queue<T> {
	private Node<T> head, tail;
	private int size;
	
	/** Creates a new instance of LinkedQueue */
	public Queue() {
		head = tail = null;
		size = 0;
	}
	
	public boolean empty() {
		return head == null;
	}

    
	public boolean full() {
		return false;
	}

	
	public int length (){
		return size;
	}


    public void enqueue(T e) {
		if(tail == null){
			head = tail = new Node<T>(e);
		}
		else {
			tail.setNext(new Node<T>(e));
			tail = tail.getNext();
		}
		size++;
	}


    
	public T serve() {
		T x = head.getData();
		head = head.getNext();
		size--;
		if(size == 0)
			tail = null;
		return x;
	}

}



