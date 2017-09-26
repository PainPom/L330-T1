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

	//Attribut regroupant toutes les données considérées dans les calculs
	//private static int[] _data = {186,699,132,272,291,331,199,1890,788,1601};
	private static int[] _data = new int[10];
	private static int _length = 0;
	private static BufferedReader _bReader;
	
	/**
	 * Méthode principale servant a l'affichage des résultats des calculs de moyenne, distance, somme des distances,
	 * variance et écart-type
	 * @param String[] args : les arguments du main s'il y en a
	 */
	public static void main(String[] args) {
		
		readFile();
		
		//Calcul d'une moyenne par un attribut de la classe Moyenne et affichage
		Moyenne moyenne = new Moyenne(_data);
		System.out.printf("Moyenne : %.1f", moyenne.getMean());
		System.out.println();
		
		//Calcul d'une distance pour toutes les valeurs par un attribut de la classe Distance 
		//puis affichage
		Distance distance = new Distance(_data, moyenne);
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
		
	}
	
	/**
	 * Méthode qui accède au fichier pour lire les données de test et les stocker dans un tableau
	 */
	public static void readFile() {
		
		String _fileName = "C:\\Users\\AM47480\\eclipse-workspace\\L330-T1\\TP1 - Données de test - Calcul de la variance.csv";
		String _line = "";
		int index = 0;
		
		try {
			_bReader = new BufferedReader(new FileReader(_fileName));
			while((_line = _bReader.readLine()) != null) {
				System.out.println("Index i : " + index + " et ligne : " + _line);
				
				if(index == 0)
					_length = Integer.parseInt(_line);
				else
					_data[index-1] = Integer.parseInt(_line);
				
				index++;
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
