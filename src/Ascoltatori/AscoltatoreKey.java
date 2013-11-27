package Ascoltatori;

import java.awt.KeyEventDispatcher;
import java.awt.event.KeyEvent;

import InterfacciaGrafica.Ascoltatore;
import InterfacciaGrafica.GuiMasterMind;

public class AscoltatoreKey extends Ascoltatore implements KeyEventDispatcher {

	
	public AscoltatoreKey(GuiMasterMind b){
		
		super(b);
	}
	
	public boolean dispatchKeyEvent(KeyEvent e) {

		if (e.getID() == KeyEvent.KEY_PRESSED){
			if (e.getKeyCode()==KeyEvent.VK_ENTER){
				mossa();
			}
		
			if (e.getKeyCode()==KeyEvent.VK_ESCAPE){
				esci();
			}
			
			if (e.getKeyCode()==KeyEvent.VK_F1){
				help();
			}
			
			if (e.getKeyCode()==KeyEvent.VK_F2){
				nuovaPartita();
			}
			
			if (e.getKeyCode()==KeyEvent.VK_F3){
				abbandona();
			}
		
			if (e.getKeyCode()==KeyEvent.VK_F4){
				statistiche();
			}
			
		}
	 
		return false;
	}
	
	
}
