
public class Moyenne {

	private int _sum;
	private double _mean;
	private double _length;
	
	public Moyenne(int[] values) {
		
		_sum = 0;
		_mean = 0;
		_length = values.length;
		
		_sum = calculateSum(values);
		_mean = calculateMean(_sum, _length);
		
	}
	
	public int calculateSum(int[] values) {
		
		int _localSum = 0;
		
		for(int i = 0; i < _length; i++)
			_localSum += values[i];
			
		return _localSum;
		
	}
	
	public double calculateMean(int sum, double _length) {
		
		double _localMean = 0;
		
		_localMean = (1/_length)*sum;		
		
		return _localMean;
		
	}
	
	public double getMean() {
		return _mean;
	}
	
	
}
