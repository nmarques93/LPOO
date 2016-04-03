package maze.logic;

import java.awt.Point;

public class Element {
	//protected int posx, posy;
	protected Coord pos;
	protected char symbol;
	
	public char getSymbol(){
		return this.symbol;
	}
	
	public Coord getPos(){
		return pos;
	}
	
	public void setSymbol(char s){
		symbol=s;
	}
	
	/*public int getX(){
		return posx;
	}
	
	public int getY(){
		return posy;
	}
	
	public void setX(int x){
		this.posx=x;
	}
	
	public void setY(int y){
		this.posy=y;
	}*/
	
	public boolean validMove(Maze maz, int x, int y){
		if(maz.getSymbol(x, y)=='X'){
			return false;
		}
		return true;
	}
}
