package geometria;

public class Rectangulo extends Figura {
	
	int x1, x2, y1, y2;

	
	public Rectangulo(int x1, int x2, int y1, int y2){
		this.x1=x1;
		this.x2=x2;
		this.y1=y1;
		this.y2=y2;
	}
	
	public double getArea() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public double getPerimetro(){
		return x1+x2+y1+y2;
	}

}
