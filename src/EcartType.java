/**
 * Classe responsable de calculer l'écart-type de la variance calculée préalablement
 * 
 * @author Michael Gendron-Renaud
 *
 */
public class EcartType {

	//Attributs
	private double _ecartType;
	
	//Constructeur
	public EcartType(Variance variance) {
	
		//Initialisation et mise a jour des attributs
		_ecartType = 0;
		_ecartType = calculateEcartType(variance);
				
	}
	
	/**
	 * 
	 * @param double variance : la variance calculée et passée en paramètre
	 * @return double _localEcartType : l'écart-type calculé dans la méthode
	 */
	public double calculateEcartType(Variance variance) {
		
		//Initialisation
		double _localEcartType = 0;
		
		//Calcul
		_localEcartType = Math.sqrt(variance.getVariance());
		
		//Retour
		return _localEcartType;
		
	}
	
	/**
	 * Accesseur pour l'écart-type afin d'accéder a sa valeur sans être directement dans la classe
	 * @return double _ecartType : l'attribut écart-type
	 */
	public double getEcartType() {
		//Retour
		return _ecartType;
	}
	
}
