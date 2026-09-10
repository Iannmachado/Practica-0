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
    //Implementar un algoritmo que dados una matriz de N x N elementos y un arreglo de N elementos,
    //ambos con elementos enteros >=0, verifique usando acumuladores booleanos que para toda fila i
    //de la matriz se cumpla que sus elementos son múltiplos del elemento i del arreglo, y que alguna
    //columna sea igual al arreglo elemento a elemento.
    public static boolean filaMultiplosDeArregloColumnaIgualArreglo (int [][] mat, int[] arreglo){
        if (arreglo.length == 0){
            return false;
        }
        if (mat.length == 0){
            return true;
        }
        if (mat.length != arreglo.length){
            return false;
        }

        return elementoDelArregloMultiploDeFila(mat, arreglo) && columnaIgualArregloElementoAElemento(mat, arreglo);
    }
    public static boolean elementoDelArregloMultiploDeFila (int [][] mat, int[] arreglo){
        boolean TodasSonMultiplo = true;
        for (int f = 0; f < mat.length; f++){
            boolean esMultiplo = true;
            for (int c = 0; c < mat[0].length; c++){
                    esMultiplo = esMultiplo && (mat[f][c]%arreglo[f]==0);
            }
            TodasSonMultiplo = TodasSonMultiplo && esMultiplo;
        }
        return TodasSonMultiplo;
    }
    public static boolean columnaIgualArregloElementoAElemento (int [][] mat, int[] arreglo){
        boolean coincideElArreglo = false;
        for (int c = 0; c < mat[0].length; c++){
            boolean coincideElElemento = true;
            for (int f = 0; f < mat.length; f++){
                coincideElElemento = coincideElElemento && (mat[f][c]==arreglo[f]);
            }
            coincideElArreglo = coincideElArreglo || coincideElElemento;
        }
        return coincideElArreglo;
    }
    public static boolean perteneceAlgunaColumnaYDiagonalEsMultiplo(int [][] mat, int[] arr){
        if(mat.length==0){
            return false;
        }
        if(arr.length==0){
            return false;
        }
        if(arr.length<mat.length || mat.length != mat[0].length){
            return false;
        }
        return (elemmentosColumnaPertenecenArreglo(mat, arr)&&elementosDiagonalMultiplo(mat, arr));
    }
    public static boolean elemmentosColumnaPertenecenArreglo(int [][] mat,int [] arr){
        boolean CoincideEnAlgunaColumna = false;
        for(int c=0; c<mat[0].length;c++){
            boolean CoincidenTodos=true;
            for(int f=0; f<mat.length; f++){
                boolean pertenece = false;
                for (int i = 0; i < arr.length; i++) {
                    pertenece = pertenece || (arr[i] == mat[f][c]);
                }
                CoincidenTodos = CoincidenTodos && pertenece;
            }
            CoincideEnAlgunaColumna = CoincideEnAlgunaColumna || CoincidenTodos;
        }
        return CoincideEnAlgunaColumna;
    }
    public static boolean elementosDiagonalMultiplo(int [][] mat,int [] arr){
        boolean todosSonMultiplos = true;
        for (int i = 0; i < mat.length; i++) {
            todosSonMultiplos = todosSonMultiplos
                && arr[i] != 0
                && mat[i][i] % arr[i] == 0;
        }
        return todosSonMultiplos;
    }
    public static boolean esRaraYDiagonalEsIgualAVector(int[][] mat,int[] vec){
        boolean todasLasColumnasElementoMultiplo5 = true;
        boolean AlgunaFilaTodosElementosPares = false;
        boolean AscendenteIgualAVector = false;
        if(vec.length==0){
            return false;
        }
        if(mat.length!=mat[0].length){
            return false;
        }
        if(mat.length!=vec.length){
            return false;
        }
        return elementosColumnaMultiplo(mat) && filaConElementosPares (mat) && diagonalIgualAVector(mat, vec);
    }
    public static  boolean elementosColumnaMultiplo(int[][]mat){
        boolean todasLasColumnasElementoMultiplo5 = true;
        for(int c=0; c < mat[0].length; c++){
            boolean hayElementoEnColumna = false;
            for(int f=0; f < mat.length; f++){
                hayElementoEnColumna = hayElementoEnColumna || (mat[f][c]%5==0);
            }
            todasLasColumnasElementoMultiplo5 = todasLasColumnasElementoMultiplo5 && hayElementoEnColumna;
        }
        return todasLasColumnasElementoMultiplo5;
    }
    public static boolean filaConElementosPares(int[][]mat){
        boolean AlgunaFilaTodosElementosPares = false;
        for (int f = 0; f < mat.length; f++){
            boolean hayElementoPar = true;
            for(int c = 0; c < mat[0].length; c++){
                hayElementoPar = hayElementoPar && (mat[f][c]%2==0);
            }
            AlgunaFilaTodosElementosPares = AlgunaFilaTodosElementosPares || hayElementoPar;
        } 
        return AlgunaFilaTodosElementosPares;
        
    }
    public static boolean diagonalIgualAVector(int[][]mat,int[] vec){
        boolean todosLosVectoresIguales = true;
        for(int f = 0; f < mat.length; f++){
            todosLosVectoresIguales = todosLosVectoresIguales && (mat[f][mat.length-1-f]==vec[f]);
        }
        return todosLosVectoresIguales;
    }

}
