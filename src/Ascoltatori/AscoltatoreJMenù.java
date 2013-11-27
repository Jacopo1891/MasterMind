package Ascoltatori;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import InterfacciaGrafica.Ascoltatore;
import InterfacciaGrafica.GuiMasterMind;

/** 
 * @author Jacopo C.
 *	Classe che gestisce il JMen�.
 */

public class AscoltatoreJMen� extends Ascoltatore implements ActionListener{
	
	public AscoltatoreJMen�(GuiMasterMind b) {
		super(b);
	}

	public void actionPerformed(ActionEvent e) {
		String pressione = e.getActionCommand();
			
		if(pressione.equals("Nuova partita")){
			nuovaPartita();
		}
		
		if(pressione.equals("Abbandona")){
			abbandona();
		}
		
		if(pressione.equals("Statistiche")){
			statistiche();
		}
		
		if(pressione.equals("Esci")){
			esci();
		}
		
		if(pressione.equals("Help")){
			help();
		}	
	}
}
