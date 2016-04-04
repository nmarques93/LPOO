package maze.logic;

import java.awt.Point;

public class Hero extends Element{
	protected boolean hasSword;
	protected boolean hasWon;
	protected boolean hasDied;
	
	public Hero(){
		symbol='H';
		//posx=1;
		//posy=1;
	}
	
	
	public void setDead(boolean b){
		hasDied=b;
	}
	
	public boolean getDead(){
		return hasDied;
	}
	
	public void setWon(boolean b){
		hasWon=b;
	}
	
	public boolean getWon(){
		return hasWon;
	}
	
	//verifica se o proximo move é permitido
	public boolean validMove(Maze maz, int x, int y){
		
		if(!super.validMove(maz, x, y)) System.out.println("Invalid move!!");
		
		return super.validMove(maz, x, y);
	}
	
	public void move(Maze maz, Sword excalibur, Direction direction){
		if(direction ==Direction.Down && validMove(maz, getPos().getX()+1, getPos().getY())){
			maz.setSymbol(getPos().getX(), getPos().getY(), ' ');
			getPos().translate(1, 0);
		}
		if(direction ==Direction.Up && validMove(maz, getPos().getX()-1, getPos().getY())){
			maz.setSymbol(getPos().getX(), getPos().getY(), ' ');
			getPos().translate(-1, 0);
		}
		if(direction ==Direction.Right && validMove(maz, getPos().getX(), getPos().getY()+1)){
			maz.setSymbol(getPos().getX(), getPos().getY(), ' ');
			getPos().translate(0, 1);
		}
		if(direction ==Direction.Left && validMove(maz, getPos().getX(), getPos().getY()-1)){
			maz.setSymbol(getPos().getX(), getPos().getY(), ' ');
			getPos().translate(0, -1);
		}
		
		if(maz.getSymbol(getPos().getX(), getPos().getY())=='S'){
			maz.setEnded(true);
		}
		
		if(getPos().getX()==excalibur.getPos().getX() && getPos().getY()==excalibur.getPos().getY()){
			this.symbol='A';
			excalibur.setSymbol(' ');
		}
	}
	
}
