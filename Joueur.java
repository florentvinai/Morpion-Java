import java.util.Scanner;


public class Joueur {
	String name;
	char symbole ;
	
    // constructeur par default de l'objet Joueur
	public Joueur() {
		String n = "flo" ;
		char c = 'O';
		
		 Scanner sc = new Scanner(System.in);    
		 System.out.println("Creation du joueur  : ");
		 System.out.println("Nom du joueur  : ");
	     n = sc.nextLine(); 
	     System.out.println("Symbole joueur  : ");
	     c = sc.next().charAt(0); 
	            	        
		this.symbole = c;
		this.name = n;
	}
	
	//// constructeur de l'objet Joueur
	public Joueur (String n, char c) {
		
		this.symbole = c;
		this.name = n;
	}
	
	// accesseurs
	public String  getname() {
		return(this.name);
	}
	
	private boolean  setname(String s) {
		boolean b=true;
		this.name = s;
			return(b);
		}
	private char  getsymbole() {
		return(this.symbole);
	}
	
	private boolean  setsymbole(char s) {
		boolean b=true;
		this.symbole = s;
			return(b);
		}
	
	
	// methode pour entrer les coordonneer du pion a joouer
	public int start(Morpion m){
		
		int res=0 ;
		
		   Scanner sc = new Scanner(System.in);    
			 System.out.println("Joueur :"+this.name+ ", Entrez le Numero de la ligne ("+this.symbole+") : ");
			 m.ligne =sc.nextInt();
			 System.out.println("Joueur :"+this.name+ ", Entrez le Numero la colonne ("+this.symbole+") : ");
			 m.colomne =sc.nextInt();
			 
			// doit tester les valeurs entrer au clavier
			// sui OK res=1
			
			 if (m.ligne < m.TAILLE_GRILLE && m.colomne < m.TAILLE_GRILLE )  res=1; else 
				 System.out.println("Recommencer  car erreur de saisie ");
			
		   return(res);
		
	}
}
