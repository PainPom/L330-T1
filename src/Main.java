
public class Main {

	private static int[] _data = {186,699,132,272,291,331,199,1890,788,1601};
	
	public static void main(String[] args) {
		
		Moyenne moyenne = new Moyenne(_data);
		System.out.println("Moyenne : " + moyenne.getMean());
		
		Distance distance = new Distance(_data, moyenne);
		for(int i = 0; i < distance.getDistanceGrid().length; i++)
			System.out.println("Distance " + i + " : " + distance.getDistanceAt(i));

		System.out.println("Somme des distances : " + distance.getDistanceSum());
		
		Variance variance = new Variance(distance);
		System.out.println(variance.getVariance());
	
	}
	
}
