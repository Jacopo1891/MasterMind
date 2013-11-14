package MetodiGioco;

public class Partita{
	
	int[] numeri;
	int[] mossa;
	public int numMosse=1;
	private boolean vittoria=false, resa=false;
	
	public Partita(){
			
			numeri= new int[4];
			int i=0;
			while (i<numeri.length){
	
				int x = (int)(Math.random()*9);
				if (unico(x, i, numeri)){
					numeri[i]=x;
					i++;
				}
			}
		
	}
	
	public void newGame(){

		numeri= new int[4];
		int i=0;
		vittoria=false;
		resa=false;
		while (i<numeri.length){

			int x = (int)(Math.random()*9);
			if (unico(x, i, numeri)){
				numeri[i]=x;
				i++;
			}
		}
	}
	
	private boolean unico(int a, int posizione, int []v){
		boolean unico = true;
		for(int i=0; i<v.length; i++){
			if (a==v[i] && i!=posizione){
				unico = false;
				break;
			}
		}
		return unico;
	}
	
	public String getSoluzione(){
		
		String risultato="";
		for(int i=0; i<numeri.length; i++){
			risultato+=numeri[i]+" ";
		}
		
		return risultato;
	}
	
	public String mossa(int a, int b, int c, int d){
		
		mossa= new int[4];
		mossa[0]=a;
		mossa[1]=b;
		mossa[2]=c;
		mossa[3]=d;

		String s="";
		int sO=0;
		
		for(int i=0; i<numeri.length; i++){
			for(int j=0; j<mossa.length; j++){
				
				if(mossa[j]==numeri[i] && j==i && unico(mossa[j],j, mossa)){

					s+="X";
					break;
				}
				
				else if(mossa[j]==numeri[i] && unico(mossa[j], j, mossa)){
					
					sO++;
				}
				
				else if(mossa[j]==numeri[i] && !unico(mossa[j], j, mossa)){
					
					if(indPrimaOcc(mossa, mossa[j])==j){
						
						sO++;
					}
				}
				
			}
		}
		
		while(sO>0){
			s+="O";
			sO--;
		}
				
		
		if(s.equals("XXXX")){
			vittoria=true;
		}
		numMosse++;
		return s;	
	}
	
	public int indPrimaOcc(int a[], int n){
		
		int sol=0;
		
		for(int i=0; i<a.length; i++){
			
			if(a[i]==n){
				sol=i;
				break;
			}
		}
		
		return sol;
	}
	
	public boolean vittoria(){
		
		return vittoria;
	}
	
	public boolean resa(){
		
		return resa;
	}
	
	public void setResa(boolean b){
		
		resa=b;
	}

}
