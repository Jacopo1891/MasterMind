package InterfacciaGrafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import MetodiGioco.Store;

/** 
 * @author Jacopo C.
 *	Classe che gestisce il JMenù.
 */

public class AscoltatoreJMenù implements ActionListener{
	
	Grafica g;
	
	public AscoltatoreJMenù(Grafica b) {
		g=b;
	}

	public void actionPerformed(ActionEvent e) {
		String pressione = e.getActionCommand();
			
		if(pressione.equals("Nuova partita")){
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
		
		if(pressione.equals("Abbandona")){
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
		
		if(pressione.equals("Statistiche")){
			
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
		
		if(pressione.equals("Esci")){
			try {
				g.MM.saveStore(g.salvataggi);
			} catch (Exception e1) {e1.printStackTrace();}
			g.home.dispose();
			System.exit(0);
		}
		
		if(pressione.equals("Help")){
			
			String testo="Inserire i numeri fino ad indovinare la combinazione.\nO indica un numero giusto nel posto sbagliato.\nX indica un numero giusto al posto giusto.";
			JOptionPane.showMessageDialog(g.home, testo, "Help",JOptionPane.INFORMATION_MESSAGE);
		}	
	}
}
