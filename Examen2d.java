//EDUARDO ETHANDRAKE CASTILLO PULIDO
//ANDRE SINSEL AYALA
public class Examen2d {
    static int valueOf(char c){
        if(c >= 'A' && c<='Z'){
            return c-'A';
        }else if(c >= 'a' && c<='z'){
            return c-'a'+26;
        }else if(c == '.'){
            return 52;
        }else if(c == ','){
            return 53;
        }
        return 0;
    }
    static void hashCode(String phrase, int M) {
        //Base = 26+26+1+1=54
        int base = 54;
        int hash = valueOf(phrase.charAt(0));
        for(int i = 1;i<phrase.length();i++){
            hash = (hash * base + valueOf(phrase.charAt(i))) % M;
        } 
        System.out.println(hash);
    }
    public static void main(String[] args){
        String phrase = "Prueba,numero.5";
        int M = 55;
        hashCode(phrase, M);
        phrase="MoScAs";
        M=20;
        hashCode(phrase, M);
        phrase="ElectroEncefAlografista.";
        M=560;
        hashCode(phrase, M);
        phrase="Si,conseguiTrabajo.";
        M=201;
        hashCode(phrase, M);
        phrase="StarWars";
        M=30;
        hashCode(phrase, M);
    }
}