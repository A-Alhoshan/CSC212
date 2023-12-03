public class Node<T> {
	public Node<T> prev;
	public Node<T> next;
	public T data;

	public Node() {
		this.prev = null;
		this.next = null;
	}

	public Node(T t) {
		this.data = t;
	}
}
