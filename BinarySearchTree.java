public class BinarySearchTree<T extends Comparable<T>> {

	private class TreeNode {
		T key;
		TreeNode left, right, parent;
		public TreeNode(T key) {
			this.key = key;
		}
	}
	
	private TreeNode root = null;

	private void print(TreeNode node, String spaces) {
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
	
	public boolean add(T key) {
		if(this.root == null) {
			this.root = new TreeNode(key);
			return true;
		} else {
			TreeNode ite = this.root;
			boolean added = false, found = false;
			while(!found && !added) {
				int res = key.compareTo(ite.key);
				if(res == 0) {
					found = true;
				} else if(res < 0) {
					if(ite.left != null) {
						ite = ite.left;
					} else {
						ite.left = new TreeNode(key);
						ite.left.parent = ite;
						added = true;
					}					
				} else {
					if(ite.right != null) {
						ite = ite.right;
					} else {
						ite.right = new TreeNode(key);
						ite.right.parent = ite;
						added = true;
					}
				}
			}
			return added;
		}
	}
	
	private TreeNode search(T key, TreeNode current) {
		if(current == null) return null;
		int res = key.compareTo(current.key);
		if(res == 0) {			// key = current.key
			return current;
		} else if(res < 0) {	// key < current.key
			return search(key, current.left);
		} else {				// key > current.key
			return search(key, current.right);
		}
	}
	
	public boolean contains(T key) {
		return search(key, this.root) != null;
	}
	
	private TreeNode minimum(TreeNode current) {
		if(current.left == null) {	// current contiene a la clave m�nima
			return current;
		} else {					// current no contiene a la clave m�nima
			return minimum(current.left);
		}
	}
	
	public T minimum() {
		if(this.root == null) return null;
		return minimum(this.root).key;
	}
	
	private TreeNode maximum(TreeNode current) {
		if(current.right == null) {
			return current;
		} else {
			return maximum(current.right);
		}
	}
	
	public T maximum() {
		if(this.root == null) return null;
		return maximum(this.root).key;
	}
	
	private TreeNode predecessor(TreeNode current) {
		if(current.left != null) {
			return maximum(current.left);
		} else {
			TreeNode parent = current.parent;
			while(parent != null && current == parent.left) {
				current = parent;
				parent  = parent.parent;
			}
			return parent;
		}
	}
	
	public T predecessor(T key) {
		TreeNode node = search(key, this.root);
		if(node == null) return null;
		TreeNode preNode = predecessor(node);
		if(preNode == null) return null;
		else return preNode.key;
	}
	public boolean delete(T key) {
		TreeNode node;
		node =  search(key, this.root);
		if(node == null)
			return false;
		else {
			delete(node);
			return true;
		}
	}
	
	private void delete(TreeNode node) {
		
		if(node.left == null & node.right == null) {
			if(node == this.root)
				this.root = null;
			else if(node.parent.left == node)
				node.parent.left = null;
			else
				node.parent.right = null;
		}
		
		else if(node.left != null && node.right == null) {
			if(node == this.root) {
				this.root = node.left;
				this.root.parent = null;
			}
			else if(node.parent.left == node) {
				node.parent.left = node.left;
				node.left.parent = node.parent;
			}
			else {
				node.parent.right = node.left;
				node.left.parent = node.parent;
			}
		}
		
		else if(node.left == null && node.right != null) {
			if(node == this.root) {
				this.root = node.right;
				this.root.parent = null;
			}
			else if(node.parent.left == node) {
				node.parent.left = node.right;
				node.right.parent = node.parent;
			}
			else {
				node.parent.right = node.right;
				node.right.parent = node.parent;
			}
		}
		
		else {
			TreeNode pre = predecessor(node);
			node.key = pre.key;
			delete(pre);
		}
	}
	public static void main(String[] args) {
		BinarySearchTree<Integer> intBST    = new BinarySearchTree<>();
		intBST.add(5);	
		intBST.add(3);	intBST.add(8);	
		intBST.add(4);	intBST.add(7);	intBST.add(2);	intBST.add(9);
		intBST.add(1);	intBST.add(10);
		System.out.println("�rbol Inicial");
		intBST.print();
		System.out.println("Eliminar clave que no existe: 20");
		intBST.delete(20);
		intBST.print();
		System.out.println("Eliminar clave que es hoja: 1");
		intBST.delete(1);
		intBST.print();
		System.out.println("Eliminar clave con 1 hijo: 9");
		intBST.delete(9);
		intBST.print();
		System.out.println("Eliminar clave con 2 hijos: 3");
		intBST.delete(3);
		intBST.print();
		System.out.println("Eliminar clave que es ra�z con 2 hijos: 5");
		intBST.delete(5);
		intBST.print();
		System.out.println("Eliminar clave que es hoja: 2");
		intBST.delete(2);
		intBST.print();
		System.out.println("Eliminar clave que es ra�z con 1 hijo: 4");
		intBST.delete(4);
		intBST.print();
		System.out.println("Eliminar clave que es hoja: 7");
		intBST.delete(7);
		intBST.print();
		System.out.println("Eliminar clave que es hoja: 10");
		intBST.delete(10);
		intBST.print();
		System.out.println("Eliminar clave que es ra�z sin hijos: 8");
		intBST.delete(8);
		intBST.print();
		
	}

}
