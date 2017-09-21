/**
 * Classe responsable de calculer l'�cart-type de la variance calcul�e pr�alablement
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
	 * @param double variance : la variance calcul�e et pass�e en param�tre
	 * @return double _localEcartType : l'�cart-type calcul� dans la m�thode
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
	 * Accesseur pour l'�cart-type afin d'acc�der a sa valeur sans �tre directement dans la classe
	 * @return double _ecartType : l'attribut �cart-type
	 */
	public double getEcartType() {
		//Retour
		return _ecartType;
	}
	
}
