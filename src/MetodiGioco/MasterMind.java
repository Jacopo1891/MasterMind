package MetodiGioco;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/** 
 * @author Jacopo C.
 *	Classe che gestisce la serializzazione di un oggetto di tipo Store
 *	contenente le statistiche delle partite precedentemente giocate.
 */

public class MasterMind{
	
	String file="MasterMind.stat";
	String path=System.getProperty("user.home")+"\\";
	File fileOut= new File(path+file);
	Store Store;
	
	public MasterMind(){
/**
 *  Costruttore. 
 *  Se esiste un file delle statistiche lo legge
 *  altrimenti ne crea uno nuovo.		
 */
		if(fileOut.exists()){
			try {
				Store=readStore();
			} catch (Exception e) {}
		}
		else{
			Store=new Store();
		}
	}
	
	public Store readStore() throws Exception{
/**
 * 	Legge le statistiche serializzate e restituisce un oggetto Store che le contiene.		
 */
		FileInputStream fileReader = new FileInputStream(path+file);
		ObjectInputStream objReader = new ObjectInputStream(fileReader);
		Store myStore = (Store)objReader.readObject();
		Store=myStore;
		objReader.close();
		return Store;
	}
	
	public void saveStore(Store s) throws Exception{
/**
 * 	Serializza un oggetto Store preso in ingresso.		
 */
		FileOutputStream fileWriter = new FileOutputStream(path+file);
		ObjectOutputStream objWriter = new ObjectOutputStream(fileWriter);
		objWriter.writeObject(Store);
		objWriter.close();
	}
	
}
