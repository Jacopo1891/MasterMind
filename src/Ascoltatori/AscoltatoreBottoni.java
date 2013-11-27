package Ascoltatori;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import InterfacciaGrafica.Ascoltatore;
import InterfacciaGrafica.GuiMasterMind;

/** 
 * @author Jacopo C.
 * 	Classe per l'ascolto dei pulsanti.
 */

public class AscoltatoreBottoni extends Ascoltatore implements ActionListener {
	
	public AscoltatoreBottoni(GuiMasterMind b){	
		super(b);
	}
	
	public void actionPerformed(ActionEvent evento){
		String pressione = evento.getActionCommand();
		
		if (pressione.equals("Controllo")){
			mossa();
		}
	}
}
