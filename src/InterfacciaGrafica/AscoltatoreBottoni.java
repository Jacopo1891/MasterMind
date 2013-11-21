package InterfacciaGrafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import MetodiGioco.Store;

/** 
 * @author Jacopo C.
 * 	Classe per l'ascolto dei pulsanti.
 */

public class AscoltatoreBottoni implements ActionListener {
	
	Grafica g;
	
	public AscoltatoreBottoni(Grafica b){
		
		g=b;
	}
	
	public void actionPerformed(ActionEvent evento){
		String pressione = evento.getActionCommand();
		
		if (pressione.equals("Controllo") && !g.match.vittoria() && !g.match.resa()){
			
			int a= (Integer) g.a.getValue();
			int b= (Integer) g.b.getValue();
			int c= (Integer) g.c.getValue();
			int d= (Integer) g.d.getValue();
			g.testo +=g.match.numMosse+".\t"+a+b+c+d+"\t\t"+g.match.mossa(a,b,c,d)+"\n";
			if(g.match.vittoria()){		
				g.testo+=" ~~~~~~~~~~~~~~ HAI VINTO!! ~~~~~~~~~~~~~~";
			}
		
			if(g.match.vittoria()){
				Store s= new Store(true,g.match.numMosse);
				g.salvataggi.addStore(s);
			}
			
			g.tentativo.setText(g.testo);
		}
	}
}
