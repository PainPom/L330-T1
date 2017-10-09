/**
 * Classe utilitaire regroupant les diff�rentes fonctions math�matiques n'ayant pas un lien
 * direct avec les principales fonctions math�matiques recherch�es.
 * 
 * @author Michael Gendron-Renaud
 *
 */
public class MathUtils {

	//Constructeur par d�faut
	public MathUtils(){
		
		
	}
	
	/**
	 * M�thode math�matique qui effectue l'�l�vation au carr� d'une valeur fournie
	 * 
	 * @param double value : la valeur a �lever au carr�
	 * @return double _localSquare : la valeur �lev�e au carr�
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
