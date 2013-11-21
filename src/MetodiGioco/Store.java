package MetodiGioco;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author Jacopo C.
 * 	Classe che definisce gli oggetti contenenti le statistiche.
 */

public class Store implements Serializable{

	private static final long serialVersionUID = 1L;	
	LinkedList<Store> Stat;
	boolean esito;
	private int numMosse;
	private int vittorie=0;
	private int sconfitte=0;
	private int tot=0;
	
	public Store(){
/**
 * 	Il costruttore vuoto inizializza la LinkedList.		
 */
		Stat = new LinkedList<Store>();
	}
	
	public Store(boolean b, int m){
/**
 * 	Il costruttore con parametri in ingresso crea gli oggetti con le vere e proprie statistiche.
 * 	NON inizializza la LinkedList.		
 */
		esito=b;
		numMosse=m;
	}
	
	public void addStore(Store s){
		this.Stat.add(s);
	}
	
	public int getNumMosse() {
		return numMosse;
	}

	public int getVittorie() {
		return vittorie;
	}

	public int getSconfitte() {
		return sconfitte;
	}

	public int getTot() {
		return tot;
	}

	public boolean getEsito(){
		return esito;
	}
	
	public void getStat(){
/**
 * 	Aggiorna le variabili scorrendo la lista grazie ad un iteratore.		
 */
		vittorie=0;
		sconfitte=0;
		if(Stat.size()!=0){
			tot=Stat.size();
			Iterator<Store> i = Stat.iterator();
			while(i.hasNext()){
				if((((Store) i.next()).getEsito())){
					vittorie++;
				}
				else{
					sconfitte++;
				}
			}
		}
	}
	
}
