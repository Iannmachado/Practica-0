public class matrices {
    //Implementar una clase en Java que tenga métodos estáticos que reciban una matriz por
    //parámetro y muestre los elementos de la matriz por filas y otro que los muestre por columnas,
    //y un tercer método que sume todos sus elementos.
    public static void mostrarMatrizPorFilas (int [][] mat){
        for (int f = 0; f < mat.length; f++){
            for (int c = 0; c < mat[0].length; c++){
                System.out.println(mat[f][c] + " ");
            }
        }
    }
    public static void mostrarMatrizPorColumnas (int [][] mat){
        for (int c = 0; c < mat[0].length; c++){
             for (int f = 0; f < mat.length; f++){
                System.out.println(mat[f][c] + " ");
             }
        }
    }
    public static int sumaElementosDeMatriz (int [][] mat){
        int suma = 0;
        for (int f = 0; f < mat.length; f++){
            for (int c = 0; c < mat[0].length; c++){
                suma += mat[f][c];
            }
        }
        return suma ;
    }
    //Agregar a la clase anterior métodos estáticos que reciban por parámetro una matriz y devuelvan
    //un arreglo con la suma de cada fila de la matriz (cuya dimensión sea la cantidad de filas de la
    //matriz). Crear otro que haga lo mismo, pero con las columnas.
    public static int [] sumaDeCadaFila (int [][] mat){
        int[] valorFila = new int[mat.length];
        for (int f = 0; f < mat.length; f++){
            for (int c = 0; c < mat[0].length; c++){
                valorFila[f] += mat[f][c];
            }
        }
        return valorFila;
    }
    public static int [] sumaDeCadaColumna (int [][] mat){
        int[] valorColumna = new int[mat[0].length];
        for (int c = 0; c < mat[0].length; c++){
            for (int f = 0; f < mat.length; f++){
                valorColumna[c] += mat[f][c];
            }
        }
        return valorColumna;
    }
    // Implementar, utilizando acumuladores booleanos, una función que reciba una matriz de
    //enteros, y devuelva verdadero si y solo si en cada una de las filas, existe al menos un número negativo.
    public static boolean existeNumeroNegativoEnTodasLasFilas (int [][] mat){
        boolean HayEnTodasLasFilas = true;
        for (int f = 0; f < mat.length; f++){
            boolean HayNegativo = false;
            for (int c = 0; c < mat[0].length; c++){
                HayNegativo = HayNegativo || (mat[f][c]<0);
            }
            HayEnTodasLasFilas = HayEnTodasLasFilas && HayNegativo;
        }
        return HayEnTodasLasFilas;
    }
    //Implementar una función que, dada una matriz de enteros, verifique ambas condiciones:
    //a) todas las filas están en orden estrictamente ascendente.
    //b) todas las columnas tienen al menos un elemento impar, y otro par
    public static boolean filasCrecientesParImpar(int[][] mat){
       return todasLasFilasCrecientes(mat) && todasLasColumnasConUnElementoParEImpar(mat);
    }
    public static boolean todasLasFilasCrecientes (int [][] mat){
        boolean esCreciente = true;
        int sumador = 0;
        for(int f = 0; f < mat.length; f++){
            boolean encontreUnCreciente = true;
            for (int c = 0; c<mat[0].length; c++){
                encontreUnCreciente = encontreUnCreciente && (mat[f][c]>sumador);
                sumador = mat[f][c];
            }
            esCreciente = esCreciente && encontreUnCreciente;
        }
        return esCreciente;
    }
    public static boolean todasLasColumnasConUnElementoParEImpar (int [][] mat){
        boolean existenAmbasEnTodas = true;
        for (int c = 0; c < mat[0].length; c++){
            boolean existePar = false;
            boolean existeImpar = false;
            for (int f = 0; f < mat.length; f++){
                existePar = existePar || (mat[f][c]%2==0);
                existeImpar = existeImpar || (mat[f][c]%2!=0);
            }
            existenAmbasEnTodas = existenAmbasEnTodas && existePar&&existeImpar;
        }
        return existenAmbasEnTodas; 
    }
    //Implementar una función usando acumuladores booleanos, que dada una matriz de N x N
    //elementos enteros y un arreglo de N elementos enteros determine si el elemento i del arreglo se
    //encuentra en la fila i de la matriz:
    public static boolean arregloEnFilas(int[][] mat, int[] arreglo){
        if (arreglo.length==0){
            return true;
        }
        if (mat.length==0){
            return false;
        }
        boolean existeEnTodasLasFilas = true; 
        for(int f = 0; f < mat.length; f++){
            boolean existeEnFila = false; 
            for (int c = 0; c < mat[0].length; c++){
                existeEnFila = existeEnFila || (mat[f][c]==arreglo[f]);
            }
            existeEnTodasLasFilas = existeEnTodasLasFilas && existeEnFila;
        }
        return existeEnTodasLasFilas;
    }

}
