package pyramid;

public class Pyramid {
	
	public static boolean isSubPyramid(Node node) {
		if (node == null || node.getRight() == null && node.getLeft() == null) return true;
		if (node.getRight() != null && node.getLeft() != null) {
			Node right = node.getRight(), left = node.getLeft();
			if (left.getLeft() == null && left.getRight() == null && right.getLeft() == null && right.getRight() == null) return true;
			if (left.getRight() != right.getLeft()) return false;
			if (right.getLeft() == null && right.getRight() != null || right.getLeft() != null && right.getRight() == null) return false;
			if (left.getLeft() == null && left.getRight() != null || left.getLeft() != null && left.getRight() == null) return false;
			if (left.getLeft() == left.getRight() || left.getLeft() == right.getLeft() || left.getLeft() == right.getRight() || left.getRight() == right.getRight()) return false;
			if (right.getRight() == right.getLeft() || right.getRight() == left.getRight() || right.getRight() == left.getLeft() || right.getLeft() == left.getLeft()) return false;
		}
		return isSubPyramid(node.getRight()) && isSubPyramid(node.getLeft());
	}
	
	public static boolean isPyramid(Node node) {
		if (node == null) throw new IllegalArgumentException("Pyramid: root cannot be null.");
	
		return isSubPyramid(node);
	}

	public static void main(String[] args) {
		Node pyramid = new Node(
			new Node(null, null),
			new Node(null, null));
        System.out.println("result: " + isPyramid(pyramid));
	}

}
