package InterfacciaGrafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
					//SI EFFETTUA LA MOSSA E SI AGGIUNGE ALLA STRINGA PER LA STAMPA A SCHERMO
			g.testo +=g.match.numMosse+".	"+a+b+c+d+"                                                              "+g.match.mossa(a,b,c,d)+"\n";
			if(g.match.vittoria()){
				
				g.testo+=" ~~~~~~~~~~~~~~ HAI VINTO!! ~~~~~~~~~~~~~~";
			}
			g.tentativo.setText(g.testo);

		}
	}
}
