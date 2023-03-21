/*****************************************************
 * Autor: Cristopher Alexis Zarate Valencia			 *
 * Fecha de creación: 18/03/2023					 *
 * Fecha de actualización: 19/03/2023				 *
 * Descripción: Clase para hacer el método burbuja	 *
 *****************************************************/

package MetOrd;

import javax.swing.JFrame;
import mainWin.MainMenu;

public class Burbuja{
	public static void OrdBurbuja(int arr[],int len) {
		for (int i = 0; i < len; i++) {	        
	        for (int j = 0; j < len - 1; j++) {
	            int eAct = arr[j],
	                    eSig = arr[j + 1];
	            if (eAct > eSig) {
	                arr[j] = eSig;
	                arr[j + 1] = eAct;
	            }
	        }
	    }
		
	}
}
