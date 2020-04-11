public class Examen2f {
	
	public static int findMin(int[] array) {
		return  findMin(array,0,array.length -1);
	}
	
	static int findMin (int[] array, int left, int right) {
		int m = (left + right) / 2;
		if(m == 0 && array[m] > array[right])
			return array[right];
		if(m == array.length-1 && array[m] > array[left])
			return array[left];
		if(m == right || array[m] < array[m-1] && (array[m] < array[m+1])) {
			return array[m];
		}
			
		if((array[left]< array[m] && array[m]<array[right]) ||
				(array[left]>array[m] && array[left]>array[m]))
			return findMin(array, left, m - 1);
		else 
			return findMin(array, m + 1, right);
	}
	
	public static void main(String[] args) {
		int[] arraya = {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 13};	
		System.out.println(findMin(arraya));
		int[] arrayb = {25, 1, 3, 4, 5, 7, 10, 14, 15, 16, 19, 20};	
		System.out.println(findMin(arrayb));
		int[] arrayc = {4, 5, 7, 10, 14, 15, 16, 19, 20, 23, 25, 1};
		System.out.println(findMin(arrayc));
	}
}
