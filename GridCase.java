// classe pour definir une case 
// du jeu de morpion

public class GridCase {
  // la case inclus un enteir/char
  public int ident;
  public char content;

  // Constructeurs
  public GridCase(int casid){
	this.ident = casid;
	this.content = ' ';
	
  }
  
  public GridCase(int casid, char c){
	this.ident = casid;
	this.content = c;
	
  }
}