package maze.logic;

public class Coord {
	protected int x, y;
	
	public Coord(){
		x=0;
		y=0;
	}
	
	public Coord(int x, int y){
		this.x=x;
		this.y=y;
	}
	
	public void setX(int x){
		this.x=x;
	}
	
	public void setY(int y){
		this.y=y;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public void translate(int dx, int dy){
		x+=dx;
		y+=dy;
	}
	
	public void move(int x, int y){
		this.x=x;
		this.y=y;
	}
	
	
}
