//EDUARDO ETHANDRAKE CASTILLO PULIDO
//ANDRE SINSEL AYALA
import java.util.Arrays;


public class Examen2a{
    static class BucketNode {
        Producto producto;
        BucketNode next = null;
        BucketNode previous = null;
        public BucketNode(Producto producto) {
            this.producto = producto;
        }

    }
    static class Bucket {
        BucketNode first = null;
        BucketNode last = null;
        int size = 0; // opcional
    }
    
    static void insertion(Bucket bucket){
        BucketNode pivotBucket = null;
        Producto pivotProduct = null;
        BucketNode bucketj = null;
        BucketNode bucketj_Plus1 = null;
       
        if(bucket != null){
            if(bucket.first != null){
                pivotBucket = bucket.first.next;
                pivotProduct = (pivotBucket != null) ? pivotBucket.producto : null;
            }
            while(pivotBucket != null){
                bucketj = pivotBucket.previous;
                bucketj_Plus1 = bucketj.next;
                while(bucketj != null && bucketj.producto.getPrecio() > pivotProduct.getPrecio()){
                    
                    bucketj.next.producto = bucketj.producto;
                    bucketj_Plus1 = bucketj;
                    bucketj = bucketj.previous;
                }
                bucketj_Plus1.producto = pivotProduct;
                pivotBucket = pivotBucket.next;
                pivotProduct = (pivotBucket != null) ? pivotBucket.producto : null;
            }
        }
    }

    static void ordenarPorPrecio(Producto[] productos){
        Bucket bucketList[] = new Bucket[(int)(Producto.PRECIO_MAX-Producto.PRECIO_MIN+1)];

        for(int i = 0;i < bucketList.length; i++){
            bucketList[i] = new Bucket();
        }
        for(int i = 0; i< productos.length; i++){
            BucketNode nodo = new BucketNode(productos[i]);
            int code = (int)(nodo.producto.getPrecio()-Producto.PRECIO_MIN);
            if(bucketList[code].size == 0){
                bucketList[code].first = nodo;
                bucketList[code].last = nodo;
            }else{
                nodo.previous = bucketList[code].last;
                bucketList[code].last.next = nodo;
                bucketList[code].last = nodo;
            }
            bucketList[code].size++;
        }
        int index = 0;
        for(Bucket bucket : bucketList){
            insertion(bucket);
            while(bucket.first != null){
                productos[index] = bucket.first.producto;
                bucket.first = bucket.first.next;
                index++;
            }
        }
    }

    static boolean isProductSorted(Producto productos[]){
        if(productos != null){
            double pastPrice = productos[0].getPrecio();
            for(int i = 1; i<productos.length;i++){
                if(pastPrice > productos[i].getPrecio()){
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    public static void main(String[] args){
        Producto p1 = new Producto("Producto 1", 22, 32);
        Producto p2 = new Producto("Producto 2", 10, 6);
        Producto p3 = new Producto("Producto 3", 15, 6);
        Producto p4 = new Producto("Producto 4", 200, 30);
        Producto p5 = new Producto("Producto 5", 190, 13);
        Producto p6 = new Producto("Producto 6", 22, 25);
        Producto productList[] = {p1,p2,p3,p4,p5,p6};
        ordenarPorPrecio(productList);
        System.out.println(Arrays.toString(productList));
        System.out.println(isProductSorted(productList));
        /*
        for(int n = 100_000; n<=500_000; n+=100_000){
            Producto productList[] = new Producto[n];
            for(int i = 0; i<n; i++){
                productList[i] = new Producto();
            }
            ordenarPorPrecio(productList);
            System.out.println(isProductSorted(productList));
        }
       */
    }
}

