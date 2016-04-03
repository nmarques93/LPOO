package numerics;

public abstract class ProbabilityDistribution{
	
	abstract double getMean();
	
	abstract double getStddev();
	
	abstract double probabilityDensityFunction(double x);

}
