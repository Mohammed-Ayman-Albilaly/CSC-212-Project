
public class LinkedList<T> {
	private Node<T> head;
	private Node<T> current;

	public LinkedList() {
		head = current = null;
	}

	public void findFirst() {
		current = head;
	}

	public void findNext() {
		current = current.getNext();
	}

	public T retrieve() {
		return current.getData();

	}

	public void update(T data) {
		current.setData(data);
	}

	public void insert(T data) {
		Node<T> temp;
		if (empty())
			head = current = new Node<T>(data);
		else {
			temp = current.getNext();
			current.setNext(new Node<T>(data));
			current = current.getNext();
			current.setNext(temp);
		}
	}

	public void remove() {
		if (current == head)
			head = head.getNext();
		else {

			Node<T> temp = head;
			while (temp.getNext() != current)
				temp = temp.getNext();

			temp.setNext(current.getNext());

			if (current.getNext() == null)
				current = head;
			else
				current.setNext(current.getNext());
		}

	}

	public boolean full() {
		return false;
	}

	public boolean empty() {
		return head == null;
	}

	public boolean last() {
		return current.getNext() == null;
	}

	public int size() {
		int counter = 0;
		if (empty())
			return counter;
		else {
			findFirst();
			while (!last()) {
				counter++;
				findNext();
			}
			counter++;
		}
		return counter;
	}

	public void print() {
		if (empty())
			return;
		else {
			findFirst();
			while (!last()) {
				System.out.print(current.getData()+" ");
				findNext();
			}
			System.out.print(current.getData());
		}
	}

	public boolean search(T data) {
		if (!empty()) {
			findFirst();
			while (!last()) {
				if (data.equals(current.getData()))
					return true;
				findNext();
			}
			if (data.equals(current.getData()))
				return true;
			return false;
		}
		return false;
	}

}
