package InterfacciaGrafica;

import javax.swing.*;
import MetodiGioco.Store;

/** 
 * @author Jacopo C.
 *	Classe astratta che definisce i metodi delle sottoclassi ascoltatrici.
 */

public abstract class Ascoltatore {
	
	GuiMasterMind g;
	
	public Ascoltatore(GuiMasterMind grafica){
		
		g=grafica;
	}
	
	public void mossa(){
		
		if(!g.match.vittoria() && !g.match.resa()){
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

	public void nuovaPartita(){
		if(!g.match.resa() && !g.match.vittoria()){
			String mess = "Vuoi iniziare una nuova partita senza finire questa?";
			String titolo="Nuova partita";
			int reply = JOptionPane.showConfirmDialog(null, mess, titolo, JOptionPane.YES_NO_OPTION);
			if (reply == JOptionPane.YES_OPTION){

				g.home.setVisible(false);
				g.match.newGame();
				g.tentativo.setText("");
				g.testo="";
				g.a.setValue(0);
				g.b.setValue(0);
				g.c.setValue(0);
				g.d.setValue(0);
				g.home.setVisible(true);
			}
		}
		else if(g.match.resa() || g.match.vittoria()){

			g.home.setVisible(false);
			g.match.newGame();
			g.match.numMosse=0;
			g.tentativo.setText("");
			g.testo="";
			g.a.setValue(0);
			g.b.setValue(0);
			g.c.setValue(0);
			g.d.setValue(0);
			g.home.setVisible(true);				
		}
	}
	
	public void abbandona(){
		if(!g.match.resa() && !g.match.vittoria()){
			String mess = "Vuoi abbandonare la partita?";
			String titolo="Abbandonare?";
			int reply = JOptionPane.showConfirmDialog(null, mess, titolo, JOptionPane.YES_NO_OPTION);
			if (reply == JOptionPane.YES_OPTION){
				g.testo+=" ~~~~~~~~~~~~~~ HAI PERSO!! ~~~~~~~~~~~~~~";
				g.testo+="\n\nLa soluzione corretta era: "+g.match.getSoluzione();
				g.match.setResa(true);
				g.tentativo.setText(g.testo);
				Store s= new Store(false,g.match.numMosse);
				g.salvataggi.addStore(s);				
			}
		}
	}
	public void statistiche(){
		
		g.salvataggi.getStat();
		String vitt="Numero di vittorie\t=   "+g.salvataggi.getVittorie()+"\n";
		String sconf="Numero di sconfitte\t=   "+g.salvataggi.getSconfitte()+"\n";
		String tot="Numero di partite\t=   "+g.salvataggi.getTot()+"\n";
		String spazio="-------------------------------------------------------------\n";
		String medV="Percentuale vittorie\t=   ";
		String medS="Percentuale sconfitte\t=   ";
		if(g.salvataggi.getTot()!=0){
			double media=(double)(g.salvataggi.getVittorie())*100/(g.salvataggi.getTot());
			medV+=Math.round(media)+"%\n";
			media=(double)(g.salvataggi.getSconfitte())*100/(g.salvataggi.getTot());
			medS+=Math.round(media)+"%\n";
		}
		else{
			medV+="0%\t\n";
			medS+="0%\t\n";
		}
		String testo=vitt+sconf+tot+spazio+medV+medS;
		JTextArea Stat = new JTextArea(testo);
		Stat.setEditable(false);
		JOptionPane.showMessageDialog(g.home, Stat, "Statistiche",JOptionPane.PLAIN_MESSAGE);
	}
	
	public void esci(){
		try {
			g.MM.saveStore(g.salvataggi);
		} catch (Exception e1) {e1.printStackTrace();}
		g.home.dispose();
		System.exit(0);
	}
	
	public void help(){	
		String testo1="Inserire i numeri fino ad indovinare la combinazione.\nO indica un numero giusto nel posto sbagliato.\nX indica un numero giusto al posto giusto.";
		String testo2="\n\n- Tasti funzione:\n	F1: Help\n	F2: Nuova partita\n	F3: Abbandona\n	F4: Statistiche\n\n	ESC: Esce dal gioco";
		String testo=testo1+testo2;
		JOptionPane.showMessageDialog(g.home, testo, "Help",JOptionPane.INFORMATION_MESSAGE);
	}
	
}
