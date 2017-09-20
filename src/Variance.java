
public class Variance {

	private double _variance;
	private double _length;
	
	public Variance(Distance distance) {
		
		_variance = 0;		
		_length = distance.getDistanceGrid().length;
		
		_variance = calculateVariance(distance);
				
	}
	
	public double calculateVariance(Distance distance) {
		
		double _localVariance = 0;
		
		_localVariance = (1/(_length - 1))*distance.getDistanceSum();
		
		return _localVariance;
		
	}
	
	public double getVariance() {
		return _variance;
	}
	
}
