package numerics;


public class NormalDistribution extends ProbabilityDistribution{
	double mean, stddev;
	
	public NormalDistribution(){
		mean=0.0;
		stddev=1.0;
	}
	
	public NormalDistribution(double mean, double stddev) throws IllegalArgumentException{
		if(stddev==0.0) throw new IllegalArgumentException();
		this.mean=mean;
		this.stddev=stddev;
		
	}
	
	double getMean(){
		return mean;
	}
	
	double getStddev(){
		return stddev;
	}
	
	double probabilityDensityFunction(double x){
		double f;
		f=(1/(stddev*Math.sqrt(2*Math.PI)))*Math.exp(-Math.pow((x-mean), 2)/(2*stddev*stddev));
		return f;
	}
}
