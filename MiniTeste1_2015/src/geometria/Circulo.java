package geometria;

public class Circulo extends Figura{
	Ponto centro;
	int raio;
	
	public Circulo(){}
	
	public Circulo(Ponto p, int r) throws IllegalArgumentException{
		centro=p;
		if(r<0) throw new IllegalArgumentException();
		raio=r;
	}
	
	public Ponto getCentro(){
		return centro;
	}
	
	public int getRaio(){
		return raio;
	}
	
	public double getArea(){
		return Math.PI*raio*raio;
	}
	
	public double getPerimetro(){
		return 2*Math.PI*raio;
	}
}
