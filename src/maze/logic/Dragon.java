package maze.logic;

import java.util.Random;

public class Dragon extends Element{
	protected boolean isDead;
	protected boolean isAsleep;
	TipoDragao type;
	
	public Dragon(){
		symbol='D';
		isDead=false;
		//posx=3;
		//posy=1;
	}
	
	public boolean getStat(){
		return isDead;
	}
	
	/*
	 * Verifica se a nova posicao nao e um X
	 */
	public boolean validMove(Maze maz, int x, int y){
		if(maz.getSymbol(x, y)=='X'){
			return false;
		}
		return true;
	} 
	
	public void move(Maze maz, Hero luke){
		Random pos=new Random();
		boolean hasMoved=false;
		int r = pos.nextInt(4);
		//apenas sai do ciclo qd o dragao se tiver mexido
		while(!hasMoved){
			r = pos.nextInt(4);
			if(r == 0 && validMove(maz, getPos().getX()+1,getPos().getY())){
				maz.setSymbol(getPos().getX(), getPos().getY(), ' ');
				getPos().translate(1, 0);
				hasMoved=true;
			}
			if(r == 1 && validMove(maz, getPos().getX()-1,getPos().getY())){
				maz.setSymbol(getPos().getX(), getPos().getY(), ' ');
				getPos().translate(-1, 0);
				hasMoved=true;
			}
			if(r == 2 && validMove(maz, getPos().getX(),getPos().getY()+1)){
				maz.setSymbol(getPos().getX(), getPos().getY(), ' ');
				getPos().translate(0, 1);
				hasMoved=true;
			}
			if(r == 3 && validMove(maz, getPos().getX(),getPos().getY()-1)){
				maz.setSymbol(getPos().getX(), getPos().getY(), ' ');
				getPos().translate(0, -1);
				hasMoved=true;
			}
		}
		if(getPos().getX()==luke.getPos().getX() && getPos().getY()==luke.getPos().getY() && luke.getSymbol()=='H'){
			luke.setDead(true);
			return;
		}
		else if(getPos().getX()==luke.getPos().getX() && getPos().getY()==luke.getPos().getY() && luke.getSymbol()=='A'){
			luke.setWon(true);
			symbol=' ';
			isDead=true;
			System.out.println("You killed the dragon! Now you can exit the maze.");
			return;
		}
	}
}