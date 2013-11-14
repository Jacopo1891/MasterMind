package MetodiGioco;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class MasterMind {
	
	String file="MasterMind.stat";
	String path="C:\\Users\\Jacopo\\Desktop\\";
	File fileOut= new File(path+file);
	Store Store=null;
	
	public MasterMind(){
		
		if(!fileOut.exists()){
			fileOut = new File(path+file);
		} 
		else{
			try {
				Store=openMMStat();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}

	public void addStore(Store s){
		Store=s;
	}
	
	public Store openMMStat() throws FileNotFoundException{
		
		Store myStore=null;
		try(			
			InputStream lett = new FileInputStream(path+file);
			InputStream buffer = new BufferedInputStream(lett);
			ObjectInputStream input = new ObjectInputStream(buffer);
			){
			try {
				myStore= (Store) input.readObject();
			} catch (ClassNotFoundException e) {
				System.out.println("Nessuno Store trovato");
			}			
		} 
		catch (IOException e) {	
			e.printStackTrace();
		}
		Store=myStore;
		return Store;
	}
	
	public void saveMMStat(){
		
		try (
			 OutputStream fileS = new FileOutputStream(path+file);
			 OutputStream buffer = new BufferedOutputStream(fileS);
			 ObjectOutput output = new ObjectOutputStream(buffer);
			){
			  output.writeObject(Store);
		}  
		catch(IOException ex){
			  ex.printStackTrace();
		}
	}
	
}
