
public class Node<T> {
	private T data;
	private Node<T> next;
	
	public Node() {
		next = null;
		data = null;
	}
	
	public Node(T data) {
		next = null;
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}
	
	

}
