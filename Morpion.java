import java.util.Scanner;



/*  IUT R&T : Reussite universitaire S2
 * ---------------------------------
 * 
 * ELEVE : TP2 / Florent VINAI  
 * 
 * 
 *  Le jeu du Morpion peut se decomposer avec les etapes suivantes
 * 
 *
 *   1- Creation et initialisation d’un plateau de jeu (grille+ 2joueurs)
 *   
 *   2- Affichage du tableau initial -> vide
 *   
 *   3.  Assignation d’un symbole pour chaque joueur
 *   
 *   4.  Decision du joueur qui commence -> start jeu
 *   
 *   5.  Boucle d’interaction avec les joueurs :
 *   
 *    (a)  On fait jouer le joueur actif (choix de X,Y)
 *         On verifie si la case est jouable
 *    (b)  On affiche le plateau modifie avec le coup du joueur (X,Y)
 *    (c)  On teste la fin du jeu et sinon c’est au tour de l’autre joueur (goto 5)
 *   
 *   6.  Affichage du gagnant  ´eventuel
 * 
 * 
 * 
 * 
 * Ici On a implementer aussi une variante du jeu d emorpion ou on a 2 grilles
 * 
 * 1- la grille de jeu
 * 2  la grille de coup double
 * 
 * les methodes ont ete definie avec les consignes
 * 
 * 
 * La gestion des erreur n'est pas finalisée car pas demande dans le TP, il faudrait ameliorer le code
 * pour gerer les erreur de saisie de clavier...avec l'objet scanner
 */

 public class Morpion {
	
	Joueur joueurA;
	Joueur joueurB;
	
	Joueur joueurquijoue;
	
	int depart = 0; // celui qui joue 1 ou 2
	int ligne =0;
	int colomne=0;
	
	Grille grid ;
	Grille coupdouble;
	
	int TAILLE_GRILLE=3;
	
	// constructeur
	Morpion(){
		
		Grille [] g = new Grille[1]; // tuple de grilles
		
		joueurA = new Joueur();
		joueurB = new Joueur();
		
		joueurquijoue = new Joueur("toto",'x');
	
		grid = new Grille();
		coupdouble = new Grille();
		
		// initilise les 2 grilles
		// la grille de jeu + la grille de coup double
		
		g = grid.initialiserGrille();
		
		grid = g[0];
		coupdouble = g[1];
		
		
	}
	
   // Methode pour definir les joueurs
   public int initJoueur() {
	   int res=0 ;
	   Scanner sc = new Scanner(System.in);    
		 System.out.println("Quel joueur commence ? : 1 ou 2 : ");
		 depart= sc.nextInt();
	   return(depart);
		
	}
   // Methode pour definir qui demarre
   public int start() {
	   
	   if(depart == 1 ) {
		   
		   //saisie des coordonnee tant que pas erreur
		   while ( this.joueurA.start(this) != 1)
		   joueurquijoue = this.joueurA;
		   joueurquijoue.symbole = this.joueurA.symbole;
		   
		   
	   }
	   else {
		   //saisie des coordonnee tant que pas erreur
		   while (this.joueurB.start(this) !=1 )
		   joueurquijoue = this.joueurB;
		   joueurquijoue.symbole = this.joueurB.symbole;
	   }
	   
	   return depart;
	}
   
   // Prg principal 
   public static  void  main(String[] args) {
 
   boolean findejeu = false;
   char c = ' ';
   Grille gr;
   Grille [] g = new Grille[1];
   
   //creation objet classe morpion
   Morpion m = new Morpion(); 
   
   // initialise joueurs 1 ou 2
   while (true) {
	  int res=  m.initJoueur() ;
	  if (res == 1 || res == 2) break;
   }
   
   // boucle d'interactiuon avec les joueurs
   while (findejeu == false) {
	   
	   m.grid.afficherGrille(m.grid);
	   m.start();
	   
	   if (m.grid.estLibre( m.ligne,m.colomne, m.grid ) == true){
		   
		   //System.out.println("Placerpion " + m.joueurquijoue.symbole+ "   "+ m.ligne+ "  "+m.colomne);
		   gr =  m.grid.placerPion(m.joueurquijoue.symbole, m.ligne, m.colomne, m.grid ); 
		   
		   m.grid = gr;
		   
		   if (m.grid.coupDouble(m.ligne,m.colomne, m.coupdouble) == false) {
		   
		   // on change de joueur si pas coup double
		   m.depart = (m.depart + 1)%2;
		   
		   }
		   else {
			   
			   // on affiche le coup double et le joueur doit rejouer
			   System.out.println("\n");
			   System.out.println("Coup Double !! Le meme joueur rejoue");
			   System.out.println("\n"); 
			   //m.grid.afficherGrille(gr);
		   }
		   
		   
		   // Teste si la grille est plein
		   if (gr.grillePleine(gr)) {
			   System.out.println("\n");
			   System.out.println("Partie Finie : Grille Pleine !!");
			   System.out.println("\n"); 
			   findejeu = true;
			   break;
		   }
		   // Teste si lale coup est gagnant
		   if (gr.coupGagnant(m.ligne,m.colomne, gr)) {
			   System.out.println("\n");
			   System.out.println("Partie Finie : Joueur "+ m.joueurquijoue.getname()+" A GAGNE !!!!!!");
			   System.out.println("\n");
		       Scanner quest = new Scanner(System.in);    
				 System.out.println("On recommence une partie ? o/n : ");
				 System.out.println("\n");
				 
				 c = quest.next().charAt(0); 
				 if (c == 'q' || c != 'o')  { findejeu= true ; break;}
				 else {
					g = m.grid.initialiserGrille();
						
					m.grid = g[0];
					m.coupdouble = g[1];
					// m.grid = m.grid.initialiserGrille();
					 
				 }
	
	   
	       }
		   
		
	   } else {
		   
		 System.out.println("Case n 'est pas libre, Choisissez une autre");
	   }
   }
	   
   }
}