
public class Node2 {
	public String key;
	public Contact data;
	public Node2 left, right;

	public Node2(Contact C) {
		key = C.getName();
		data = C;
		left = right = null;
	}

}
