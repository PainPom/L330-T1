/**
 * Classe responsable de l'affichage des r�sultats pour les diff�rents calculs statistiques
 * 
 * @author Michael Gendron-Renaud
 *
 */
public class Main {

	//Attribut regroupant toutes les donn�es consid�r�es dans les calculs
	private static int[] _data = {186,699,132,272,291,331,199,1890,788,1601};
	
	/**
	 * M�thode principale servant a l'affichage des r�sultats des calculs de moyenne, distance, somme des distances,
	 * variance et �cart-type
	 * @param String[] args : les arguments du main s'il y en a
	 */
	public static void main(String[] args) {
		
		//Calcul d'une moyenne par un attribut de la classe Moyenne et affichage
		Moyenne moyenne = new Moyenne(_data);
		System.out.println("Moyenne : " + moyenne.getMean());
		
		//Calcul d'une distance pour toutes les valeurs par un attribut de la classe Distance 
		//puis affichage
		Distance distance = new Distance(_data, moyenne);
		for(int i = 0; i < distance.getDistanceGrid().length; i++)
			System.out.println("Distance " + i + " : " + distance.getDistanceAt(i));

		//Calcul d'une somme des distances par un attribut de la classe Distance puis affichage
		System.out.println("Somme des distances : " + distance.getDistanceSum());
		
		//Calcul d'une variance par un attribut de la classe Variance 
		//et affichage
		Variance variance = new Variance(distance);
		System.out.println(variance.getVariance());
	
		//Calcul de l'�cart-type par un attribut de la classe EcartType et affichage
		EcartType ecartType = new EcartType(variance);
		System.out.println(ecartType.getEcartType());
		
	}
	
}
