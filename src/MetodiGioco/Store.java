package MetodiGioco;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;

public class Store implements Serializable{

	private static final long serialVersionUID = 1L;
	
	LinkedList<Store> Stat;
	boolean esito;
	private int numMosse;
	private int vittorie=0;
	private int sconfitte=0;
	private int tot=0;
	
	public Store(){
		Stat = new LinkedList<Store>();
	}
	
	public Store(boolean b, int m){
		esito=b;
		numMosse=m;
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
