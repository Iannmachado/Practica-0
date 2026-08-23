public class main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        int[] lista = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] lista1 = {11, 20, 30, 40, 50, 60, 70, 80, 90, 111};
        int[] lista2 = {10, 20, 30, 40, 50, 60, 70, 80, 90, 110};
        int[] lista3 = {1,2,4,1};
        int[] lista4 = {3,2,1};
        System.out.println("la lista es mayor a 10: "+mayor10(lista));
        System.out.println("la lista 1 es mayor a 10: "+mayor10(lista1));
        System.out.println("la lista es: "+multiplo5AlgunoMayor100(lista));
        System.out.println("la lista 1 es: "+multiplo5AlgunoMayor100(lista1));
        System.out.println("la lista 2 es: "+multiplo5AlgunoMayor100(lista2));
        System.out.println("la lista 1 es subconjutno de la lista 2: "+pertenecenTodos(lista3, lista4));

        int[][] matriz1 = {{1, 2, 3}, {4, 5, 6}};
        int[][] matriz2 = {{1, 2, 3}, {4, 5, 5}};
        int[][] matriz3 = {{1, 2, 3}, {2, 4, 6}};

        System.out.println("Matriz 1: " + matrices.filasCrecientesParImpar(matriz1)
            + " (esperado: true)");
        System.out.println("Matriz 2: " + matrices.filasCrecientesParImpar(matriz2)
            + " (esperado: false)");
        System.out.println("Matriz 3: " + matrices.filasCrecientesParImpar(matriz3)
            + " (esperado: false)");

        int[][] matriz4 = {
            {9, 2, 4, 5},
            {6, 7, 1, 7},
            {3, 5, 9, 11},
            {12, 8, 5, 1}
        };
        int[] arreglo1 = {4, 7, 5, 1};

        int[][] matriz5 = {
            {4, 2, 13, 5},
            {6, 7, 1, 3},
            {3, 7, 9, 11},
            {12, 8, 5, 10}
        };
        int[] arreglo2 = {4, 7, 5, 1};

        System.out.println("Arreglo en filas, caso 1: "
            + matrices.arregloEnFilas(matriz4, arreglo1)
            + " (esperado: true)");
        System.out.println("Arreglo en filas, caso 2: "
            + matrices.arregloEnFilas(matriz5, arreglo2)
            + " (esperado: false)");
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
    public static boolean pertenecenTodos(int[] elems, int[] arreglo){
        if (elems.length==0){
            return true;
        }
        if (arreglo.length==0){
            return false;
        }
        boolean esSubconjunto = true;
        
        for(int i = 0; i < elems.length ; i++){
            boolean elementosIguales = false;
            for(int j = 0; j < arreglo.length; j++){
                 elementosIguales = elementosIguales || (elems[i]==arreglo[j]);
            }
            esSubconjunto = esSubconjunto && elementosIguales;
        }
        return esSubconjunto;
    }
    

    
}