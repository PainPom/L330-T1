/**
 * Classe responsable de calculer la variance a partir de données calculées préalablement via les autres classes
 * de calculs statistiques
 * 
 * @author Michael Gendron-Renaud
 *
 */
public class Variance {

	//Attributs
	private double _variance;
	private double _length;
	
	//Constructeur
	public Variance(Distance distance) {
		
		//Initialisation des attributs
		_variance = 0;		
		_length = distance.getDistanceGrid().length;
		
		//Mise a jour des attributs
		_variance = calculateVariance(distance);
				
	}
	
	/**
	 * Méthode responsable de calculer la variance a partir d'une distance fournie
	 * 
	 * @param Distance distance : la distance calculée préalablement
	 * @return double _localVariance : le résultat du calcul de la variance
	 */
	public double calculateVariance(Distance distance) {
		
		//Initialisation
		double _localVariance = 0;
		
		//Calcul
		_localVariance = (1/(_length - 1))*distance.getDistanceSum();
		
		//Retour
		return _localVariance;
		
	}
	
	/**
	 * Accesseur permettant d'aller chercher la valeur de la variance en étant a l'extérieur de la classe
	 * 
	 * @return double _variance : l'attribut de la variance
	 */
	public double getVariance() {
		//Retour
		return _variance;
	}
	
}
