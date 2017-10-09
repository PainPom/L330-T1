/**
 * Classe responsable de calculer la correlation d'une série de valeurs
 * 
 * @author Michael Gendron-Renaud
 *
 */
public class Correlation {
	
	//Attributs
	private double _correlation;
	private double _sumRowX;
	private double _sumRowY;
	private double _sumSquaredRowX;
	private double _sumSquaredRowY;
	private double _sumMultiplication;
	private double[][] _corData;
	private MathUtils _utilitaires;
	private double _length;
	
	//Constructeur
	public Correlation(double[][] correlationData, MathUtils mth){
		
		//Initialisation
		_correlation = 0;
		_sumRowX = 0;
		_sumRowY = 0;
		_sumSquaredRowX = 0;
		_sumSquaredRowY = 0;
		_length = 0;
		_corData = correlationData;
		_utilitaires = mth;
		
		//Calculs
		_length = calculateAndVerifyLength(_corData);
		_sumMultiplication = multiplyRowValues(_corData);
		_sumRowX = calculateRowX(_corData);
		_sumRowY = calculateRowY(_corData);
		_sumSquaredRowX = calculateRowXSquared(_corData);
		_sumSquaredRowY = calculateRowYSquared(_corData);
		_correlation = calculateCorrelation();
				
	}
	
	/**
	 * Méthode responsable de calculer la corrélation de plusieurs valeurs
	 * 
	 * @return double localCorrelation, la corrélation entre les valeurs selon l'indice de corrélation
	 */
	public double calculateCorrelation(){
		
		//Initialisation
		double localCorrelation = 0;
		double numerateur = 0;
		double denominateur = 0;
		
		//Calculs
		numerateur = ((_length * _sumMultiplication) - (_sumRowX * _sumRowY));
		denominateur = (Math.sqrt(((_length * _sumSquaredRowX) - 
						_utilitaires.square(_sumRowX))*((_length * _sumSquaredRowY) - 
						_utilitaires.square(_sumRowY))));
		localCorrelation = numerateur/denominateur;
		
		//Retour
		return localCorrelation;
		
	}
	
	public double calculateAndVerifyLength(double[][] correlationData){
		
		//Initialisation
		double localLength = 0;
		
		//Attribution selon les conditions
		//Si les deux longueurs sont égales, on considère leurs longueurs
		if(correlationData[Main.ROWX].length == correlationData[Main.ROWY].length){
			
			localLength = correlationData[Main.ROWX].length;
			
		//Sinon, on prend la plus petite pour ne pas causer d'erreur
		} else {
			
			if(correlationData[Main.ROWX].length > correlationData[Main.ROWY].length)
				localLength = correlationData[Main.ROWY].length;
			else if(correlationData[Main.ROWX].length < correlationData[Main.ROWY].length)
				localLength = correlationData[Main.ROWX].length;
			
		}
		
		//Retour
		return localLength;
	}
	
	/**
	 * Méthode mathématique qui calcule la somme de tous les éléments de la rangée X de la table et la retourne
	 * 
	 * @param double[][] correlationData : le tableau des données, séparées par leurs indices (X ou Y)
	 * @return double localSumRowX : la somme calculée est retournée
	 */
	public double calculateRowX(double[][] correlationData){
		
		//Initialisation
		double localSumRowX = 0;
		
		//Dans une boucle itérative, on additionne à la valeur précédente la nouvelle valeur de la table
		//créant la somme totale du même fait, pour toutes les valeurs de la table
		for(int i = 0; i < _length; i++){
			
			localSumRowX += correlationData[Main.ROWX][i];
			
		}

		//Retour
		return localSumRowX;
	}
	
	/**
	 * Méthode mathématique qui calcule la somme de tous les éléments de la rangée Y de la table et la retourne
	 * 
	 * @param double[][] correlationData : le tableau des données, séparées par leurs indices (X ou Y)
	 * @return double localSumRowY : la somme calculée est retournée
	 */
	public double calculateRowY(double[][] correlationData){
		
		//Initialisation
		double localSumRowY = 0;
		
		//Dans une boucle itérative, on additionne à la valeur précédente la nouvelle valeur de la table
		//créant la somme totale du même fait, pour toutes les valeurs de la table
		for(int i = 0; i < _length; i++){
			
			localSumRowY += correlationData[Main.ROWY][i];
					
		}
		
		//Retour
		return localSumRowY;
	}
	
	/**
	 * Méthode mathématique qui calcule la somme de tous les éléments de la rangée X, où tous les éléments sont élevés 
	 * au carré préalablement de la table et la retourne
	 * 
	 * @param double[][] correlationData : le tableau des données, séparées par leurs indices (X ou Y)
	 * @return double localSquaredSumRowX : la somme calculée est retournée
	 */
	public double calculateRowXSquared(double[][] correlationData){
		
		//Initialisation
		double localSquaredSumRowX = 0;
		
		//Dans une boucle itérative, on additionne à la valeur précédente la nouvelle valeur élevée au carré de la table
		//créant la somme totale du même fait, pour toutes les valeurs de la table
		for(int i = 0; i < _length; i++){
			
			localSquaredSumRowX += _utilitaires.square(correlationData[Main.ROWX][i]);
					
		}
		
		//Retour
		return localSquaredSumRowX;
		
	}
	
	/**
	 * Méthode mathématique qui calcule la somme de tous les éléments de la rangée Y, où tous les éléments sont élevés 
	 * au carré préalablement de la table et la retourne
	 * 
	 * @param double[][] correlationData : le tableau des données, séparées par leurs indices (X ou Y)
	 * @return double localSquaredSumRowY : la somme calculée est retournée
	 */
	public double calculateRowYSquared(double[][] correlationData){
	
		//Initialisation
		double localSquaredSumRowY = 0;
		
		//Dans une boucle itérative, on additionne à la valeur précédente la nouvelle valeur élevée au carré de la table
		//créant la somme totale du même fait, pour toutes les valeurs de la table
		for(int i = 0; i < _length; i++){
			
			localSquaredSumRowY += _utilitaires.square(correlationData[Main.ROWY][i]);
					
		}
		
		//Retour
		return localSquaredSumRowY;
	
	}
	
	/**
	 * Méthode mathématique qui calcule la somme de la multiplication de tous les éléments dans la table selon leur
	 * indice.
	 * 
	 * @param double[][] correlationData : le tableau des données, séparées par leurs indices (X ou Y)
	 * @return double localMultiplicationSum : la somme de la multiplication calculée est retournée
	 */
	public double multiplyRowValues(double[][] correlationData){
		
		//Initialisation
		double localMultiplicationSum = 0;
		
		//Dans une boucle itérative, on additionne à la valeur précédente la nouvelle valeur multipliée à l'autre valeur
		//de la table au même indice, créant la somme totale du même fait, pour toutes les valeurs de la table
		for(int i = 0; i < _length; i++){
			
			localMultiplicationSum+= correlationData[Main.ROWX][i]*correlationData[Main.ROWY][i];
			
		}

		//Retour
		return localMultiplicationSum;
		
	}
	
	/**
	 * Accesseur permettant de saisir la valeur de la corrélation calculée et stockée dans l'attribut
	 * 
	 * @return double _correlation, la valeur stockée dans l'attribut de la corrélation
	 */
	public double getCorrelation(){
		
		//Retour
		return _correlation;
		
	}
	
}
