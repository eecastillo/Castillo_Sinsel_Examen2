//EDUARDO ETHANDRAKE CASTILLO PULIDO
//ANDRE SINSEL AYALA
import java.util.Arrays;
import java.util.LinkedList;

public class Examen2c {
    static void radixSort(int[] array, int M) {
        LinkedList<Integer> digitList[] = new LinkedList[10];
        for(int i = 0; i<10 ; i++){
            digitList[i] = new LinkedList<Integer>();
        }
        //acomodar los elementos por primera vez

        for(int datum : array){
            int digit = datum%10;
            digitList[digit].offer(datum);
        }

        for(int i=1; i<=M ; i++){
            for(LinkedList<Integer> list: digitList) list.offer(-1);
            
            double exp = 1;
            for(int e=0;e<i;e++){
                exp *= 10;
            }
            for(LinkedList<Integer> list:digitList){
                int datum = list.poll();
                while(datum != -1){
                    int digit = (int)(datum/exp)%10;
                    digitList[digit].offer(datum);
                    datum = list.poll();
                }
            }            
        }
        int index=0;
        for(LinkedList<Integer> list: digitList){
            while(!list.isEmpty()){
                array[index++] = list.poll();
            }
        }
    }
    static boolean isSorted(int array[]){
        if(array != null){
            int pastDatum = array[0];
            for(int i = 1; i<array.length;i++){
                if(pastDatum > array[i]){
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    static int random(int min, int max) {
        return min + (int) ((max - min + 1) * Math.random());
    }

    static int[] randomArray(int N, int min, int max) {
        int[] a = new int[N];
        for(int i = 0; i < N; i ++) {
            a[i] = random(min, max);
        }
        return a;
    }
    public static void main(String[] args){
        /*int array[]={124,1,2,3151,36,58,46,95,26541,235,6984};
        radixSort(array, 5);
        System.out.println(Arrays.toString(array));
        System.out.println(isSorted(array));*/
        for(int n = 100_000; n<=500_000; n+=100_000){
            int array[] = randomArray(n, 0, n);
            radixSort(array, 6);
            System.out.println(isSorted(array));
        }
    }
}