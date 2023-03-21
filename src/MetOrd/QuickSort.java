/*****************************************************
 * Autor: Cristopher Alexis Zarate Valencia			 *
 * Fecha de creación: 18/03/2023					 *
 * Fecha de actualización: 19/03/2023				 *
 * Descripción: Clase para hacer el método QuickSort *
 *****************************************************/

package MetOrd;

public class QuickSort {
	private int Array[];
	
	private static int particion(int arreglo[], int izquierda, int derecha) {
        int pivote = arreglo[izquierda];
        
        while (true) {
            while (arreglo[izquierda] < pivote) {
                izquierda++;
            }
            
            while (arreglo[derecha] > pivote) {
                derecha--;
            }
    
            if (izquierda >= derecha) {
                return derecha;
            } else {      
                int temporal = arreglo[izquierda];
                arreglo[izquierda] = arreglo[derecha];
                arreglo[derecha] = temporal;
      
                izquierda++;
                derecha--;
            }
        }
    }

    public static void quicksort(int arreglo[], int izquierda, int derecha) {
        if (izquierda < derecha) {
            int indiceParticion = particion(arreglo, izquierda, derecha);
            quicksort(arreglo, izquierda, indiceParticion);
            quicksort(arreglo, indiceParticion + 1, derecha);
        }
    }
}
