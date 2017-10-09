import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Classe responsable de l'affichage des résultats pour les différents calculs statistiques
 * 
 * @author Michael Gendron-Renaud
 *
 */
public class Main {

	//Constantes
	public static final int ROWX = 0;
	public static final int ROWY = 1;
	
	//Attribut regroupant toutes les données considérées dans les calculs
	//private static int[] _data = {186,699,132,272,291,331,199,1890,788,1601};
	private static int[] _data = new int[10];
	private static int _length = 0;
	private static BufferedReader _bReader;
	private static BufferedReader _readerToCount;
	private static double[][] _correlationData;
	private static MathUtils _mth;
	
	/**
	 * Méthode principale servant a l'affichage des résultats des calculs de moyenne, distance, somme des distances,
	 * variance et écart-type
	 * @param String[] args : les arguments du main s'il y en a
	 */
	public static void main(String[] args) {
		
		MathUtils _mth = new MathUtils();
		
		readLab1File();
		readLab2File();
		
		//Calcul d'une moyenne par un attribut de la classe Moyenne et affichage
		Moyenne moyenne = new Moyenne(_data);
		System.out.printf("Moyenne : %.1f", moyenne.getMean());
		System.out.println();
		
		//Calcul d'une distance pour toutes les valeurs par un attribut de la classe Distance 
		//puis affichage
		Distance distance = new Distance(_data, moyenne, _mth);
		for(int i = 0; i < distance.getDistanceGrid().length; i++)
			System.out.println("Distance [" + i + "] : " + distance.getDistanceAt(i));

		//Calcul d'une somme des distances par un attribut de la classe Distance puis affichage
		System.out.println("Somme des distances : " + distance.getDistanceSum());
		
		//Calcul d'une variance par un attribut de la classe Variance 
		//et affichage
		Variance variance = new Variance(distance);
		System.out.printf("Variance : %.4f", variance.getVariance());
		System.out.println();
		
		//Calcul de l'écart-type par un attribut de la classe EcartType et affichage
		EcartType ecartType = new EcartType(variance);
		System.out.printf("Écart-type : %.2f", ecartType.getEcartType());
		System.out.println();
		
		//Calcul de la corrélation
		Correlation correlation = new Correlation(_correlationData, _mth);
		System.out.printf("R : %.8f", correlation.getCorrelation());
		System.out.println();
		System.out.printf("R au carré : %.8f", _mth.square(correlation.getCorrelation()));
	}
	
	/**
	 * Méthode qui accède au fichier pour lire les données de test et les stocker dans un tableau
	 */
	public static void readLab1File() {
		
		//Initialisation des variables
		String _fileName = System.getProperty("user.dir") + "/TP1 - Données de test - Calcul de la variance.csv";
		String _line = "";
		int index = 0;
		
		//Lecture des données du laboratoire 1
		try {
			//Création du lecteur
			_bReader = new BufferedReader(new FileReader(_fileName));
			
			//Lecture des données pour toutes les lignes des données
			while((_line = _bReader.readLine()) != null) {
				
				//Si l'index est nul, on regarde la longueur de la colonne qu'on stocke
				if(index == 0){
					_length = Integer.parseInt(_line);				
				} else {
					_data[index-1] = Integer.parseInt(_line);
				}
				
				//Incrémentation de l'index de navigation
				index++;
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Méthode qui accède au fichier pour lire les données de test et les stocker dans un tableau
	 */
	public static void readLab2File() {
		
		//Initialisation des variables
		String _fileName = System.getProperty("user.dir") + "/TP2 - Calcul de la corrélation.csv";
		String _line = "";
		int index = 0;
		int columnCounter = 0;
		int rowCounter = 1;
		int tempCounter = 1;
		
		//Lecture des données
		try {
			
			//Création du reader pour les données
			_bReader = new BufferedReader(new FileReader(_fileName));
			
			//Création d'un reader pour compter les dimensions des données pour le tableau
			_readerToCount = new BufferedReader(new FileReader(_fileName));
			
			//On compte les colonnes et les lignes et on les compare pour vérifier les dimensions
			while((_line = _readerToCount.readLine()) != null){
				tempCounter = 1;
				if(_line.contains(";") && (tempCounter != rowCounter || tempCounter >= 1))
					tempCounter++;
				columnCounter++;
				rowCounter = tempCounter;
			}

			//Création du tableau selon les dimensions trouvées par les compteurs
			_correlationData = new double[rowCounter][columnCounter-1];
			
			//Lecture des données dans les tableaux
			while((_line = _bReader.readLine()) != null) {

				//Initialisation des variables
				boolean separatorEncountered = false;
				String lineRead1 = "";
				String lineRead2 = "";
				
				//Pour toutes les lettres trouvées dans les chaînes de caractères, pour chaque ligne du fichier
				for(int i = 0; i < _line.length(); i++){
					
					//Si on ne rencontre par de séparateur (le point-virgule)
					if(!separatorEncountered){
						
						//Si on trouve un séparateur, on passe par-dessus la condition
						if(_line.charAt(i) == ';'){
							separatorEncountered = true;
							continue;
						}
						//On ajoute le caractère à la ligne lue
						lineRead1 += _line.charAt(i);
					
					//Sinon, si on a rencontré un séparateur, on stocke les caractères dans une autre chaîne
					//Et on sépare le contenu des cellules de cette manière
					} else {
						lineRead2 += _line.charAt(i);
					}				
					
				}
			
				//Si l'index est à 0, on regarde la longueur de la colonne, indiquée par le CSV, qu'on stocke
				if(index == 0){
					_length = Integer.parseInt(lineRead1);
					
				//Sinon, on stocke les valeurs dans les bonnes parties du tableau 2D et on remplace les virgules par
				//des points pour conserver le bon format de données
				} else {
					_correlationData[ROWX][index-1] = Double.parseDouble(lineRead1);
					_correlationData[ROWY][index-1] = Double.parseDouble(lineRead2.replaceAll(",","."));
					
				}
				
				//On augmente l'index de navigation
				index++;
				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
