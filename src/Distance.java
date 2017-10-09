/**
 * Classe responsable de calculer la distance a partir de données calculées préalablement via les autres classes
 * de calculs statistiques.
 * 
 * @author Michael Gendron-Renaud
 *
 */
public class Distance {

	//Attributs
	private double[] _distanceGrid;
	private double _distance;
	private int _length;
	private double _distanceSum;
	
	//Constructeur
	public Distance(int[] values, Moyenne moyenne, MathUtils mth) {
		
		//Initialisation des attributs
		_distance = 0;
		_distanceSum = 0;
		_length = values.length;
		
		//Mise a jour des attributs
		_distanceGrid = calculateDistance(values, moyenne, mth);
		_distanceSum = calculateDistanceSum(_distanceGrid);
		
	}
	
	/**
	 * Méthode responsable de calculer la distance entre chaque valeur de la table et la moyenne.
	 * 
	 * @param int[] values : la table des valeurs
	 * @param Moyenne moyenne : attribut de la classe Moyenne
	 * @return double[] _localDistanceGrid : Une nouvelle table construite avec les distances calculées pour toutes 
	 * 										 les valeurs
	 */
	public double[] calculateDistance(int[] values, Moyenne moyenne, MathUtils mth) {
		
		//Initialisation
		double[] _localDistanceGrid = new double[_length];		
		
		//Calcul
		for(int i = 0; i < _length; i++)
			_localDistanceGrid[i] = mth.square(values[i] - moyenne.getMean());
		
		//Retour
		return _localDistanceGrid;
		
	}
	
	/**
	 * Méthode qui calcule la somme de toutes les distances dans la table des distances
	 * 
	 * @param double[] distanceGrid : la table des distances
	 * @return double _localDistanceSum : la somme de toutes les distances
	 */
	public double calculateDistanceSum(double[] distanceGrid) {
		
		//Initialisation
		double _localDistanceSum = 0;
		
		//Calcul
		for(int i = 0; i < _length; i++)
			_localDistanceSum += distanceGrid[i];
				
		//Retour
		return _localDistanceSum;		
		
	}
		
	/**
	 * Accesseur permettant d'obtenir la valeur stockée dans l'attribut de la distance.
	 * @return double _distance : l'attribut de la _distance
	 */
	public double getDistance() {
		//Retour
		return _distance;
	}
	/**
	 * Accesseur permettant d'obtenir la table stockée dans l'attribut _distanceGrid.
	 * @return double _distanceGrid : l'attribut de la _distanceGrid, la table des distances
	 */
	public double[] getDistanceGrid() {
		//Retour
		return _distanceGrid;
	}
	/**
	 * Accesseur permettant d'obtenir la valeur stockée dans une case spécifique de la table des distances 
	 * _distanceGrid.
	 * @return double _distanceGrid[idx] : la distance stockée dans un emplacement spécifique de la table
	 */
	public double getDistanceAt(int idx) {
		//Retour
		return _distanceGrid[idx];
	}
	/**
	 * Accesseur permettant d'obtenir la valeur stockée dans l'attribut de la somme des distances.
	 * @return double _distanceSum : l'attribut de la somme des distances
	 */
	public double getDistanceSum() {
		//Retour
		return _distanceSum;
	}
}
