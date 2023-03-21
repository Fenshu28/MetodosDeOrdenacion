/*****************************************************
 * Autor: Cristopher Alexis Zarate Valencia			 *
 * Fecha de creación: 18/03/2023					 *
 * Fecha de actualización: 19/03/2023				 *
 * DEscripción: Clase principal para un menú, de 	 *
 * 				los métodos de ordenación.			 *
 *****************************************************/

package mainWin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import MetOrd.Burbuja;
import MetOrd.QuickSort;
import PlaceHolder.TextPrompt;

public class MainMenu extends JFrame implements ActionListener {
	int Arr[], numElem;
	private JButton btnMetodo1,btnMetodo2;
	private JPanel pnlMain;
	private JTextField txtArray;
	private JLabel lbTextoArray,lbResultBurbuja,lbResultQuick;
	
	public MainMenu(){
		// Instanciando los elementos.
		txtArray = new JTextField();
		btnMetodo1 = new JButton("Ordenación por burbuja"); 
		btnMetodo2 = new JButton("Ordenación por Quicksort");
		pnlMain = new JPanel();
		lbTextoArray = new JLabel("Ordenación de arreglos");
		lbResultBurbuja = new JLabel();
		lbResultQuick = new JLabel();
		
		// Propiedades a la ventana
		setSize(500, 400);
		setLocationRelativeTo(null);
		setTitle("Metodos de ordenación");
		setResizable(false);
		
		// Propiedad del panel.
		pnlMain.setLayout(null);
		
		// Agregando propiedades a la caja de texto
		txtArray.setToolTipText("Escriba los elementos desordenados separados por comas.");
		txtArray.setBounds(this.getWidth()/2-150,50,300,30);
		TextPrompt Prompt = new TextPrompt("Introduzca solo números", txtArray); // PlaceHolder de la caja de texto
		
		// Agregando propiedades de las etiquetas
		lbTextoArray.setBounds(100, 5, 400, 40);
		lbResultBurbuja.setBounds(50, 200, 400, 20);
		lbResultQuick.setBounds(50, 250, 400, 20);
		
		// Agregando propiedades a los botones
		btnMetodo1.setBounds(this.getWidth()/2-150,90,300,30);
		btnMetodo2.setBounds(this.getWidth()/2-150,130,300,30);
		
		ActionListener evtBurbuja = new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				llenarArr(txtArray.getText());
				Burbuja.OrdBurbuja(Arr,numElem);
				System.out.println(Arrays.toString(Arr));
				
				lbResultBurbuja.setText(Arrays.toString(Arr));
			}
		};
		ActionListener evtQuick = new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				llenarArr(txtArray.getText());
				QuickSort.quicksort(Arr, 0, numElem-1);
				System.out.println(Arrays.toString(Arr));
				
				lbResultQuick.setText(Arrays.toString(Arr));
			}
		};
		
		btnMetodo1.addActionListener(evtBurbuja);
		btnMetodo2.addActionListener(evtQuick);
		
		// Agregando los métodos al panel
		pnlMain.add(btnMetodo1);
		pnlMain.add(btnMetodo2);
		pnlMain.add(txtArray);
		pnlMain.add(lbTextoArray);
		pnlMain.add(lbResultBurbuja);
		pnlMain.add(lbResultQuick);
		this.add(pnlMain);
		
		// Evento para cerrar la ventana
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// Hacemos visible
		setVisible(true);		
	}
	
	public static void main(String[] args) {
		MainMenu wn = new MainMenu();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
//	void llenarArr(String text) {
//		String[] obj = text.split(",");
//		Arr = new int[obj.length];
//		
//		for (int i = 0; i < obj.length; i++) {
//			Arr[i] = Integer.parseInt(obj[i].trim());
//		}
//	}
	
	void llenarArr(String texto) {
		String temp = "";
		int ArrTemp[] = new int[9999];
		
		numElem = 0;
		//|| i == texto.length()
		for (int i = 0; i < texto.length() ; i++) {
			if(texto.charAt(i) == ',' || texto.length() == i) {
				ArrTemp[numElem] = Integer.parseInt(temp);
				numElem ++;
				temp = "";
			}else {
				temp += texto.charAt(i);
			}
		}
		
		Arr = new int[numElem];
		
		for (int j = 0; j < Arr.length; j++) {
			Arr[j] = ArrTemp[j];
		}
		
	}
}
