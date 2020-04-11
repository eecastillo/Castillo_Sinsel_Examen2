public class Examen2g {
	
	public static void main(String[] args) {
		BinarySearchTreeInt intBST    = new BinarySearchTreeInt();
		intBST.add(5);
		intBST.add(2);
		intBST.add(4);
		intBST.add(8);
		intBST.add(7);
		intBST.add(9);
		intBST.add(3);
		intBST.add(1);
		intBST.add(11);
		intBST.print();
		System.out.println(intBST.existsPath(11));
		System.out.println(intBST.existsPath(20));
		System.out.println(intBST.existsPath(22));
		System.out.println(intBST.existsPath(33));
		System.out.println(intBST.existsPath(8));
	}
}
