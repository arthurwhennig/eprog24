public class SquareGrid {

	public static int getWidth(Node origin) {
		int width = 1;
		Node right = origin.getRight();
		while (right != null) {
			right = right.getRight();
			width++;
		}
		return width;
	}

	public static int getHeight(Node origin) {
		int height = 1;
		Node down = origin.getDown();
		while (down != null) {
			down = down.getDown();
			height++;
		}
		return height;
	}

	public static Node moveRight(int k, Node start) {
		Node curr = start;
		int i = 0;
		while (curr != null && i < k) {
			curr = curr.getRight();
			i++;
		}
		return curr;
	}

	public static boolean isSquare(int m, Node start) {
		Node first = start;
		Node second = start.getDown();

		for (int i = 1; i < m && first != null && second != null; i++) {
			for (int j = 1; j < m; j++) {
				Node upper = moveRight(j, first);
				Node lower = moveRight(j - 1, second);
				if (upper == null || lower == null)
					return false;
				if (upper.getDown() == null && lower.getRight() == null || upper.getDown() != lower.getRight())
					return false;
			}
			first = second;
			second = second.getDown();
		}
		return true;
	}

	public static int analyzeSquareGrid(Node origin) {
		// get dimensions of a possible
		int width = getWidth(origin), height = getHeight(origin);
		int dim = Math.min(width, height);
		System.out.println(width + " " + height);
		// find the largest possible square within the dimension bound 
		int maxDim = 1;
		for (int i = 2; i <= dim; i++) {
			if (isSquare(i, origin))
				maxDim = i;
		}
		return maxDim;
	}
}
