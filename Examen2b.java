//EDUARDO ETHANDRAKE CASTILLO PULIDO
//ANDRE SINSEL AYALA
import java.util.Arrays;

class Producto {
    private String nombre;
    private double precio;
    private int existencias;
    public static final double PRECIO_MIN = 3;
    public static final double PRECIO_MAX = 2000;
    public static final int EXISTENCIAS_MIN = 5;
    public static final int EXISTENCIAS_MAX = 50;
    private static int productId = 0;

    public Producto(String n, double p, int e) {
        this.nombre = n;
        this.precio = p;
        this.existencias = e;
    }
    public Producto() {
        this.nombre = String.format("Producto %3d", ++ productId);
        this.precio = PRECIO_MIN + (PRECIO_MAX - PRECIO_MIN) * Math.random();
        this.existencias = EXISTENCIAS_MIN + (int) ((EXISTENCIAS_MAX - EXISTENCIAS_MIN + 1) * Math.random());
    }
    public String getNombre() {
        return nombre;
    }
    public double getPrecio() {
        return precio;
    }
    public int getExistencias() {
        return existencias;
    }
    public String toString() {
        return String.format("(%s, $%7.2f, %2d)", nombre, precio, existencias);
    }
}

public class Examen2b {
    static void ordenarPorExistencias(Producto[] productos){
        int conteo[] = new int[Producto.EXISTENCIAS_MAX-Producto.EXISTENCIAS_MIN+1];
        for(Producto producto:productos){
            conteo[producto.getExistencias()-Producto.EXISTENCIAS_MIN]++;
        }
        for(int i = 1; i< conteo.length;i++){
            conteo[i] += conteo[i-1];
        }
        Producto productosTemp[] = new Producto[productos.length];
        for(int i = productos.length-1 ; i>=0 ; i--){
            Producto x = productos[i];
            int xnum = x.getExistencias()-Producto.EXISTENCIAS_MIN;
            int j = conteo[xnum] - 1;
            productosTemp[j] = x;
            conteo[xnum]--;
        }
        for(int i = 0; i<productos.length; i++){
            productos[i] = productosTemp[i];
        }
    }
    static boolean isProductSorted(Producto productos[]){
        if(productos != null){
            double pastExistence = productos[0].getExistencias();
            for(int i = 1; i<productos.length;i++){
                if(pastExistence > productos[i].getExistencias()){
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
        ordenarPorExistencias(productList);
        System.out.println(Arrays.toString(productList));
        System.out.println(isProductSorted(productList));
        /*
        for(int n = 100_000; n<=500_000; n+=100_000){
            Producto productList[] = new Producto[n];
            for(int i = 0; i<n; i++){
                productList[i] = new Producto();
            }
            ordenarPorExistencias(productList);
            System.out.println(isProductSorted(productList));
        }*/
    }
}