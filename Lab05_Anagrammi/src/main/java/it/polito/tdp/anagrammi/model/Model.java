package it.polito.tdp.anagrammi.model;

	import java.util.ArrayList;
	import java.util.List;

import it.polito.tdp.anagrammi.DAO.AnagrammaDAO;

	public class Model {
	List<List<String>> risultato;
	List<String>corretti;
	List<String> errate;
	AnagrammaDAO anagramma;
	
	public Model() {
		anagramma=new AnagrammaDAO();
	}

		public List<List<String>> anagrammi(String parola){
			
			risultato=new ArrayList<List<String>>();
			errate=new ArrayList<String>();
			corretti=new ArrayList<String>();
			permuta("",parola,0,corretti,errate);// LANCIA la ricorsione
			//cancella dalla lista le parole non valide(leggendo il dizionario)
			risultato.add(corretti);
			risultato.add(errate);
			return risultato;
			
		}
		
		//livello=lunghezza della soluzione parziale
		//livello iniziale=0
		//parziale= stringa che contiene l'anagramma incompleto in fase di costruzione
		//lettere=le lettere della parola iniziale che ancora non abbiamo utilizzato
		//         (=== il sotto problema che dobbiamo risolvere)
		
		private void permuta(String parziale,String lettere,int livello,List<String>corretti,List<String>errate) {
			if(lettere.length()==0) { //caso terminale
				// la soluzione parziale è anche una soluzione completa
				//System.out.println(parziale);
				
				//if(parziale è una parola valida?)
				if(anagramma.IsCorrect(parziale) && !corretti.contains(parziale))
					corretti.add(parziale);
				else if(!anagramma.IsCorrect(parziale) && !errate.contains(parziale)) {
					errate.add(parziale);
				}
				
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
					if(anagramma.rootIsCorrect(nuovaParziale))
						permuta(nuovaParziale,nuovaLettere,livello+1,corretti,errate);
					
					
					//Backtracking(NON SERVE)
					//rimetti a posto 'parziale'
					//rimetti a posto 'lettere'
					
				}
			}
		}
	}


