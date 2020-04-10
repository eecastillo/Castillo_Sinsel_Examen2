import java.util.Arrays;

public class Examen2e {
	
	public static void merge(int[] A, int[] B, int N) {
		int []aux =new int[N];
		for(int i = 0; i < N ; i++)	//Theta(N)
			aux[i] = A[i];
		
		int auxindex = 0;
		int bindex = 0;
		
		for(int i = 0; i<A.length ; i++)  //Theta(A.length)
		{
			if(bindex == B .length || (auxindex < N && aux[auxindex] < B[bindex])) {
				A[i] = aux[auxindex];
				auxindex ++ ;
			}
			else {
				A[i] = B[bindex];
				bindex ++ ;
			}
				
		}
		
	}
	
	public static int random(int min, int max) {
		return min + (int) ((max - min + 1) * Math.random());
	}
	
	public static int[] randomArray(int N, int min, int max) {
		int[] a = new int[N];
		for(int i = 0; i < N; i ++) {
			a[i] = random(min, max);
		}
		return a;
	}
	
	public static boolean isSorted(int[] a) {
		for(int i = 0; i < a.length - 1; i ++) {
			if(a[i] > a[i + 1]) return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		int[] A = { 3, 5, 7, 8, 9, 10, 0, 0, 0, 0, 0 };
		int[] B = { 1, 2, 4, 5, 6 };
		merge(A, B, 6);	
		System.out.println(Arrays.toString(A));
		System.out.println(isSorted(A));
		
		/*for(int n = 100_000; n<=500_000; n+=100_000){
            int A[] = randomArray(n, 0, n);
            int B[] = randomArray(n/2,0,n);
            Arrays.sort(A);
            Arrays.sort(B);
            merge(A,B,n/2);
            System.out.println(isSorted(A));
        }*/

	}


}
