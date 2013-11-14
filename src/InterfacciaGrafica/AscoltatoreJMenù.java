package InterfacciaGrafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.JOptionPane;

import MetodiGioco.Store;

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
					Store s= new Store(false, g.match.numMosse);
					g.MM.addStore(s);
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
				
				if(g.match.resa()){
					Store s= new Store(false, g.match.numMosse);
					g.MM.addStore(s);
				}
				
				if(g.match.vittoria()){
					Store s= new Store(true, g.match.numMosse);
					g.MM.addStore(s);
				}
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
					Store s= new Store(false, g.match.numMosse);
					g.MM.addStore(s);
					g.tentativo.setText(g.testo);
				}
			}	
		}
		
		if(pressione.equals("Statistiche")){
			
			try{
				g.salvataggi=g.MM.openMMStat();
				g.salvataggi.getStat();
				String vitt="Numero di vittorie=	"+g.salvataggi.getVittorie();
				String sconf="Numero di sconfitte=	"+g.salvataggi.getSconfitte();
				String tot="Numero di partite=	"+g.salvataggi.getTot();
				String testo=vitt+"\n"+sconf+"\n"+tot;
//				String testo="";
				JOptionPane.showMessageDialog(g.home, testo, "Statistiche",JOptionPane.INFORMATION_MESSAGE);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}

		}
		
		if(pressione.equals("Esci")){

			if(!g.match.resa() && !g.match.vittoria()){
			
				String mess = "Vuoi vedere la soluzione?";
				String titolo="Esci";
				int reply = JOptionPane.showConfirmDialog(null, mess, titolo, JOptionPane.YES_NO_OPTION);
				if (reply == JOptionPane.YES_OPTION){
					String testo="La soluzione corretta era: "+g.match.getSoluzione();
					JOptionPane.showMessageDialog(g.home, testo, "Soluzione",JOptionPane.INFORMATION_MESSAGE);
				}	
			}
			g.home.dispose();
		}
		
		if(pressione.equals("Help")){
			
			String testo="Inserire i numeri fino ad indovinare la combinazione.\nO indica un numero giusto nel posto sbagliato.\nX indica un numero giusto al posto giusto.";
			JOptionPane.showMessageDialog(g.home, testo, "Help",JOptionPane.INFORMATION_MESSAGE);
		}	
	}
}
