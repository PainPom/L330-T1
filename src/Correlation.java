/**
 * Classe responsable de calculer la correlation d'une s�rie de valeurs
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
	 * M�thode responsable de calculer la corr�lation de plusieurs valeurs
	 * 
	 * @return double localCorrelation, la corr�lation entre les valeurs selon l'indice de corr�lation
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
		//Si les deux longueurs sont �gales, on consid�re leurs longueurs
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
	 * M�thode math�matique qui calcule la somme de tous les �l�ments de la rang�e X de la table et la retourne
	 * 
	 * @param double[][] correlationData : le tableau des donn�es, s�par�es par leurs indices (X ou Y)
	 * @return double localSumRowX : la somme calcul�e est retourn�e
	 */
	public double calculateRowX(double[][] correlationData){
		
		//Initialisation
		double localSumRowX = 0;
		
		//Dans une boucle it�rative, on additionne � la valeur pr�c�dente la nouvelle valeur de la table
		//cr�ant la somme totale du m�me fait, pour toutes les valeurs de la table
		for(int i = 0; i < _length; i++){
			
			localSumRowX += correlationData[Main.ROWX][i];
			
		}

		//Retour
		return localSumRowX;
	}
	
	/**
	 * M�thode math�matique qui calcule la somme de tous les �l�ments de la rang�e Y de la table et la retourne
	 * 
	 * @param double[][] correlationData : le tableau des donn�es, s�par�es par leurs indices (X ou Y)
	 * @return double localSumRowY : la somme calcul�e est retourn�e
	 */
	public double calculateRowY(double[][] correlationData){
		
		//Initialisation
		double localSumRowY = 0;
		
		//Dans une boucle it�rative, on additionne � la valeur pr�c�dente la nouvelle valeur de la table
		//cr�ant la somme totale du m�me fait, pour toutes les valeurs de la table
		for(int i = 0; i < _length; i++){
			
			localSumRowY += correlationData[Main.ROWY][i];
					
		}
		
		//Retour
		return localSumRowY;
	}
	
	/**
	 * M�thode math�matique qui calcule la somme de tous les �l�ments de la rang�e X, o� tous les �l�ments sont �lev�s 
	 * au carr� pr�alablement de la table et la retourne
	 * 
	 * @param double[][] correlationData : le tableau des donn�es, s�par�es par leurs indices (X ou Y)
	 * @return double localSquaredSumRowX : la somme calcul�e est retourn�e
	 */
	public double calculateRowXSquared(double[][] correlationData){
		
		//Initialisation
		double localSquaredSumRowX = 0;
		
		//Dans une boucle it�rative, on additionne � la valeur pr�c�dente la nouvelle valeur �lev�e au carr� de la table
		//cr�ant la somme totale du m�me fait, pour toutes les valeurs de la table
		for(int i = 0; i < _length; i++){
			
			localSquaredSumRowX += _utilitaires.square(correlationData[Main.ROWX][i]);
					
		}
		
		//Retour
		return localSquaredSumRowX;
		
	}
	
	/**
	 * M�thode math�matique qui calcule la somme de tous les �l�ments de la rang�e Y, o� tous les �l�ments sont �lev�s 
	 * au carr� pr�alablement de la table et la retourne
	 * 
	 * @param double[][] correlationData : le tableau des donn�es, s�par�es par leurs indices (X ou Y)
	 * @return double localSquaredSumRowY : la somme calcul�e est retourn�e
	 */
	public double calculateRowYSquared(double[][] correlationData){
	
		//Initialisation
		double localSquaredSumRowY = 0;
		
		//Dans une boucle it�rative, on additionne � la valeur pr�c�dente la nouvelle valeur �lev�e au carr� de la table
		//cr�ant la somme totale du m�me fait, pour toutes les valeurs de la table
		for(int i = 0; i < _length; i++){
			
			localSquaredSumRowY += _utilitaires.square(correlationData[Main.ROWY][i]);
					
		}
		
		//Retour
		return localSquaredSumRowY;
	
	}
	
	/**
	 * M�thode math�matique qui calcule la somme de la multiplication de tous les �l�ments dans la table selon leur
	 * indice.
	 * 
	 * @param double[][] correlationData : le tableau des donn�es, s�par�es par leurs indices (X ou Y)
	 * @return double localMultiplicationSum : la somme de la multiplication calcul�e est retourn�e
	 */
	public double multiplyRowValues(double[][] correlationData){
		
		//Initialisation
		double localMultiplicationSum = 0;
		
		//Dans une boucle it�rative, on additionne � la valeur pr�c�dente la nouvelle valeur multipli�e � l'autre valeur
		//de la table au m�me indice, cr�ant la somme totale du m�me fait, pour toutes les valeurs de la table
		for(int i = 0; i < _length; i++){
			
			localMultiplicationSum+= correlationData[Main.ROWX][i]*correlationData[Main.ROWY][i];
			
		}

		//Retour
		return localMultiplicationSum;
		
	}
	
	/**
	 * Accesseur permettant de saisir la valeur de la corr�lation calcul�e et stock�e dans l'attribut
	 * 
	 * @return double _correlation, la valeur stock�e dans l'attribut de la corr�lation
	 */
	public double getCorrelation(){
		
		//Retour
		return _correlation;
		
	}
	
}
