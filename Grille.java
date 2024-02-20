

// Cette classe pour definir la grille du jeu de 
public class Grille {
	
	// taille de la grille
	int TAILLE_GRILLE=3; 
	GridCase [] cases ;
	
	// constructeur de la grille par defaut
	public Grille(){	
		cases = new GridCase[TAILLE_GRILLE*TAILLE_GRILLE];
		
		// initilisation des cases
	    for (int i=0; i< this.cases.length; i++){
		  this.cases[i] = new GridCase(i);
		  this.cases[i].ident = 0;
		  this.cases[i].content = ' ';
	    }
	}
	
	//  initiliaser la grille
	// ---------------------
	// la fonction revoi un tuple de grille
	//
	// la fonction initialise les 2 grilles
	// 1a grillea jouer
	// la grille coup double
	//
	public Grille []  initialiserGrille() {	
		
		Grille [] g = new Grille[2];
		g[0] = new Grille();
		
		//creation grille coup double
		g[1]= new Grille();
		
		// init & met a jour la grille coupdouble 
		g[1]= placerCoupDouble(g[1]);
		
		return(g);
	}
	
	// cette fonction place 2 cases de la grille au MAXIMUM en coup double
	// aleatoirement
	// @ la grille coup double initialisée
	// return la grille mis a jour ident = 12 pour coup double
	//
	public Grille placerCoupDouble(Grille coupdouble) {
		
		int value, 
			j, 
			nbre_coup_double = 2 ; // NOMRE COUP DOUBLE DEFINI COMME CONSTANTE =2
	    
		// Place 999 dans les cases coup double de la grille coupdouble
		for (j = 0 ; j < nbre_coup_double ; j ++ ){
			value = ( int )(Math.random()*(coupdouble.cases.length));
			
			// positionne les coup double
			coupdouble.cases[ value].ident = 999; 
			
			//System.out.println("coup double :"+coupdouble.cases.length+"      "+ value);
		}
	return(coupdouble);
	}
	
	
	// La fonction coupdouble
	// qui prend en paramètres une ligne, une colonne, une grille et retourne un 
	// booléen qui indique si la case coup double 
	// @ grille, int ligne, int colomne
    // return Boolean
		
	public boolean coupDouble( int ligne,int colomne, Grille g ) {
		
		boolean b=false;
		if (g.cases[3*ligne+colomne].ident == 999) b= true;
		
	return(b);	
	}
	
	// afficher la grille a l'ecran
	// @ objet grille a afficher
	public void afficherGrille(Grille g){
		StringBuilder resultat= new StringBuilder(" ");
		int i ,j;
		
		for (j = 0 ; j < 3; j ++ ) resultat.append( " "+ j );
		resultat.append( "\n");
		resultat.append( "-------\n");
		for (j = 0 ; j < 3; j ++ ){
		
			
			resultat.append(j+ "|" ).append( g.cases[3*j].content).append("|").append( g.cases[3*j+1].content).append("|").append( g.cases[3*j+2].content).append("|\n");
			resultat.append( "-------\n");
		}	
		
		System.out.println(resultat.toString());
		
			
		}
		
		


	// La fonction  grillePleine
	// qui prend une grille en paramètre et retourne un booléen indiquant si 
	// la grille est pleine. 
	// @ grille
	// return Boolean
	
	public boolean grillePleine( Grille g ) {
		boolean b=false;
		int i, somme =0;
		for (i = 0 ; i < 9; i ++ ){
			somme = somme + g.cases[i].ident;
		}
		if (somme == 9) b = true;
	return(b);	
	}
	
	// La fonction estLibre
	// qui prend en paramètres une ligne, une colonne, une grille et retourne un 
	// booléen qui indique si la case en disponible. 
	// @ grille, int ligne, int colomne
    // return Boolean
		
	public boolean estLibre( int ligne,int colomne, Grille g ) {
		
		boolean b=true;
		if (g.cases[3*ligne+colomne].ident == 1) b= false;
		
	return(b);	
	}
	
	// La fonction  placerPion
	// qui prend en paramètres le type de symbole à déposer, une ligne, une 
	// colonne, une grille et qui retourne une grille modifiée. 
	// @ grille, int ligne, int colomne, symbole char
    // return Boolean
	public Grille placerPion(  char symbol, int ligne, int colomne, Grille gr ) {
		int i;
		
		gr.cases[3*ligne+colomne].content = symbol;
		gr.cases[3*ligne+colomne].ident = 1;
		//for (i = 0 ; i < 9; i ++ ) System.out.println(i+" case:"+ gr.cases[i].content);
		
	return(gr);	
	}
	
	//-La fonction coupGagnant qui  prend  en  paramètre  une  ligne,  une  colonne  et  la  grille  et  qui 
	// retourne un booléen indiquant si le coup est gagnant. 
	// @ grille, int ligne, int colomne, 
    // return Boolean
	public boolean coupGagnant( int ligne, int colomne, Grille gr) {
		boolean b=false;
		int i;
		
		
		//on test la ligne horizontale & verticale
		for ( i=0 ; i<3;i++) {
          if((gr.cases[3*i].content ==  gr.cases[3*i +1].content ) && (gr.cases[3*i].content ==  gr.cases[3*i +2].content ) && (gr.cases[3*i].content != ' ' ) )
          {
        	//System.out.println(i+" case:"+ gr.cases[3*i].content+gr.cases[3*i+1].content+gr.cases[3*i+2].content);
            return true;
          }  
          if((gr.cases[i].content ==  gr.cases[i+3].content ) && (gr.cases[i].content ==  gr.cases[i +6].content ) && (gr.cases[i].content != ' ' ) )
          {
        	System.out.println(i+" case:"+ gr.cases[i].content+gr.cases[i+3].content+gr.cases[i+6].content);
            return true;
          } 
		}
		//on test les diagonales
        if  ((gr.cases[0].content ==  gr.cases[4].content ) && (gr.cases[0].content ==  gr.cases[8].content ) && (gr.cases[0].content != ' ' ) )
          {
            return true;
          }
        if  ((gr.cases[2].content ==  gr.cases[4].content ) && (gr.cases[2].content ==  gr.cases[6].content ) && (gr.cases[2].content != ' ' ) )
        {
          return true;
        }
        
        
   
	return(b);	
	}
	
}
