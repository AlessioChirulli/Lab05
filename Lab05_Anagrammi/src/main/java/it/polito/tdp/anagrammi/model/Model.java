package it.polito.tdp.anagrammi.model;

	import java.util.ArrayList;
	import java.util.List;

	public class Model {
	List<String> risultato;

		public List<String> anagrammi(String parola){
			
			risultato=new ArrayList<String>();
			permuta("",parola,0,risultato);// LANCIA la ricorsione
			//cancella dalla lista le parole non valide(leggendo il dizionario)
			return risultato;
			
		}
		
		//livello=lunghezza della soluzione parziale
		//livello iniziale=0
		//parziale= stringa che contiene l'anagramma incompleto in fase di costruzione
		//lettere=le lettere della parola iniziale che ancora non abbiamo utilizzato
		//         (=== il sotto problema che dobbiamo risolvere)
		
		private void permuta(String parziale,String lettere,int livello,List<String> risultato) {
			if(lettere.length()==0) { //caso terminale
				// la soluzione parziale è anche una soluzione completa
				//System.out.println(parziale);
				
				//if(parziale è una parola valida?)
				risultato.add(parziale);
			}
			else {
				//fai ricorsione
				//sottoproblema == una lettera(un singolo carattere) di 'lettere'
				for(int pos=0;pos<lettere.length();pos++) {
					char tentativo= lettere.charAt(pos);
					
					String nuovaParziale=parziale + tentativo;
					String nuovaLettere= lettere.substring(0,pos)+lettere.substring(pos+1);//togli il carattere pos da lettere;
				     // togli il carattere pos da lettere
					//if (nuovaParziale è un PREFISSO valido di almeno una parola nel dizionario)
					//"aqz -> no; "car" -> si (carro,carrello,carta...)
					permuta(nuovaParziale,nuovaLettere,livello+1,risultato);
					
					
					//Backtracking(NON SERVE)
					//rimetti a posto 'parziale'
					//rimetti a posto 'lettere'
					
				}
			}
		}
	}


