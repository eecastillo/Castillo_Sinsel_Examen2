public class BinarySearchTreeInt {

	private class IntNode {
		int key;
		int height;
		IntNode left, right;
		public IntNode(int key) {
			this.key = key;
		}
	}
	
	private IntNode root = null;

	private void print(IntNode node, String spaces) {
		if(node != null) {
			System.out.println(spaces + "" + node.key);
			print(node.left,  spaces + " ");
			print(node.right, spaces + " ");
		}
	}
	
	public void print() {
		print(this.root, "");
		System.out.println("-------");
	}
	
	public boolean add(int key) {
		if(this.root == null) {
			this.root = new IntNode(key);
			return true;
		} else {
			IntNode ite = this.root;
			boolean added = false, found = false;
			while(!found && !added) {
				int res = key-ite.key;
				if(res == 0) {
					found = true;
				} else if(res < 0) {
					if(ite.left != null) {
						ite = ite.left;
					} else {
						ite.left = new IntNode(key);
						added = true;
					}					
				} else {
					if(ite.right != null) {
						ite = ite.right;
					} else {
						ite.right = new IntNode(key);
						added = true;
					}
				}
			}
			return added;
		}
	}
	public boolean existsPath(int L) {
		return existsPath(root, L);
	}
	private static boolean existsPath(IntNode node, int L) {
		IntNode left = node.left;
		IntNode right = node.right;
		boolean leftb = false;
		boolean rightb = false;
		L -= node.key;
		if(left == null & right == null) {
			if(L == 0)
				return true;
		}
		if(L < 0)
			return false;
		if(left != null) {
			leftb = existsPath(left,L);
			if(leftb == true)
				return true;
		}
		if(right != null) {
			rightb = existsPath(right,L);
			if(rightb == true)
				return true;
		}
		
		return false;
		
	}
}
