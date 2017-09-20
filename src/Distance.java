
public class Distance {

	private double[] _distanceGrid;
	private double _distance;
	private int _length;
	private double _distanceSum;
	
	public Distance(int[] values, Moyenne moyenne) {
		
		_distance = 0;
		_distanceSum = 0;
		_length = values.length;
		
		_distanceGrid = calculateDistance(values, moyenne);
		_distanceSum = calculateDistanceSum(_distanceGrid);
		
	}
	
	public double[] calculateDistance(int[] values, Moyenne moyenne) {
		
		double[] _localDistanceGrid = new double[_length];		
		
		for(int i = 0; i < _length; i++)
			_localDistanceGrid[i] = square(values[i] - moyenne.getMean());
		
		return _localDistanceGrid;
		
	}
	
	public double calculateDistanceSum(double[] distanceGrid) {
		
		double _localDistanceSum = 0;
		
		for(int i = 0; i < _length; i++)
			_localDistanceSum += distanceGrid[i];
				
		return _localDistanceSum;		
		
	}
	
	public double square(double value) {
		
		double _localSquare = 0;
		
		_localSquare = value*value;
		
		return _localSquare;
	}
	
	public double getDistance() {
		return _distance;
	}
	
	public double[] getDistanceGrid() {
		return _distanceGrid;
	}
	
	public double getDistanceAt(int idx) {
		return _distanceGrid[idx];
	}
	
	public double getDistanceSum() {
		return _distanceSum;
	}
}
