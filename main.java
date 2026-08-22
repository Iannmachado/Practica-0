public class main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        int[] lista = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] lista1 = {11, 20, 30, 40, 50, 60, 70, 80, 90, 111};
        int[] lista2 = {10, 20, 30, 40, 50, 60, 70, 80, 90, 110};
        System.out.println("la lista es mayor a 10: "+mayor10(lista));
        System.out.println("la lista 1 es mayor a 10: "+mayor10(lista1));
        System.out.println("la lista es: "+multiplo5AlgunoMayor100(lista));
        System.out.println("la lista 1 es: "+multiplo5AlgunoMayor100(lista1));
        System.out.println("la lista 2 es: "+multiplo5AlgunoMayor100(lista2));
    }

    // Implementar con acumuladores booleanos una función booleana “mayor10” que recibe una
    // lista de números enteros, y devuelve True si todos los elementos son mayores a 10.
    public static boolean mayor10(int[] lista) {
        boolean ret = true;
        for (int i = 0; i < lista.length; i++) {
            ret = ret && (lista[i] > 10);
        }
        return ret;
    }
    /*Implementar con acumuladores booleanos una función booleana “multiplo5AlgunoMayor100”
    que recibe una lista de números enteros, y devuelve True si todos los elementos son múltiplo
    de 5 y alguno de ellos es mayor a 100.
    */
    public static boolean multiplo5AlgunoMayor100(int[] lista){
        boolean multiplo5 = true;
        boolean AlgunoMayorA100 = false;
        for (int i = 0; i<lista.length; i++){
            multiplo5 = multiplo5 && (lista[i]%5==0);
            AlgunoMayorA100 = AlgunoMayorA100 || (lista[i] > 100);
        }
        return multiplo5&&AlgunoMayorA100;
    }
    //Implementar una función que determine si un arreglo es subconjunto de otro
    
}