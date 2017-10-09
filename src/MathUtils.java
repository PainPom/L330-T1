/**
 * Classe utilitaire regroupant les différentes fonctions mathématiques n'ayant pas un lien
 * direct avec les principales fonctions mathématiques recherchées.
 * 
 * @author Michael Gendron-Renaud
 *
 */
public class MathUtils {

	//Constructeur par défaut
	public MathUtils(){
		
		
	}
	
	/**
	 * Méthode mathématique qui effectue l'élévation au carré d'une valeur fournie
	 * 
	 * @param double value : la valeur a élever au carré
	 * @return double _localSquare : la valeur élevée au carré
	 */
	public double square(double value) {
		
		//Initialisation
		double _localSquare = 0;
		
		//Calcul
		_localSquare = value*value;
		
		//Retour
		return _localSquare;
	}
	
	
}
