/**
 * Classe responsable de calculer la moyenne a partir d'une série de données de base
 * 
 * @author Michael Gendron-Renaud
 *
 */
public class Moyenne {

	//Attributs
	private int _sum;
	private double _mean;
	private double _length;
	
	//Constructeur
	public Moyenne(int[] values) {
		
		//Initialisation des attributs
		_sum = 0;
		_mean = 0;
		_length = values.length;
		
		//Mise a jour des attributs
		_sum = calculateSum(values);
		_mean = calculateMean(_sum, _length);
		
	}
	
	/**
	 * Méthode responsable de calculer la somme des valeurs dans la table des données
	 * 
	 * @param int[] values : la table des valeurs
	 * @return int _localSum : la somme des éléments de la table
	 */
	public int calculateSum(int[] values) {
		
		//Initialisation
		int _localSum = 0;
		
		//Calcul
		for(int i = 0; i < _length; i++)
			_localSum += values[i];
			
		//Retour
		return _localSum;
		
	}
	
	/**
	 * Méthode pour calculer la moyenne en se servant de la somme calculée par calculateSum et la longueur de la
	 * table qui représente la quantité d'éléments a considérer dans le calcul de la moyenne
	 * 
	 * @param int sum : la somme des éléments de la table des valeurs
	 * @param double _length : la longueur de la table, exprimée en double pour rendre le calcul possible (sinon cast (double))
	 * @return double _localMean : la moyenne
	 */
	public double calculateMean(int sum, double _length) {
		
		//Initialisation
		double _localMean = 0;
		
		//Calcul
		_localMean = (1/_length)*sum;		
		
		//Retour
		return _localMean;
		
	}
	
	/**
	 * Accesseur permettant d'obtenir la valeur stockée dans la variable de la moyenne
	 * @return double _mean : l'attribut de la moyenne
	 */
	public double getMean() {
		//Retour
		return _mean;
	}
	
	
}
