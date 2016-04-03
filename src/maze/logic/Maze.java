
package maze.logic;

import java.util.Scanner;
import java.util.Stack;
import java.util.Arrays;
import java.util.Random;

public class Maze {
	
	
	protected char [][] layout=new char[10][10];
	protected Hero luke=new Hero();
	protected Dragon smaug=new Dragon();
	protected Sword excalibur=new Sword();
	protected int size; //apenas precisa de uma dimensao por ser um labirinto quadrado
	
	protected boolean ended=false;
	
	/*
	 * construtor que usa uma matriz fornecida pelo user
	 */
	public Maze(char[][] lo){
		this.layout=lo;
		
		//faz o scan do labirinto e atribui a posicao dos simbolos as classes respetivas
		for (int i = 0; i < layout.length; i++) {
		    for (int j = 0; j < this.layout[0].length; j++){
		    	switch(layout[i][j]){
		    		case 'H':
		    			luke.getPos().move(i, j);
		    			break;
		    		case 'D':
		    			smaug.getPos().move(i, j);
		    			break;
		    		case 'S':
		    			excalibur.getPos().move(i, j);
		    			break;
		    	}
		    }
		}
	}
	
	public Maze(){
		
	}
	
	//Cria aleatoriamente uma saida no labirinto
	public Coord createExit(Random r){
		Coord exit = new Coord();

		// generating exit distance to corner
		int exitZ;
		do {
			exitZ = r.nextInt(size - 2) + 1;
		} while (exitZ % 2 == 0);

		// getting random border to place exit at
		switch (r.nextInt(4)) {
		// top
		case 0:
			exit.setX(exitZ);
			break;
		// right
		case 1:
			exit.setX(layout[0].length - 1);
			exit.setY(exitZ);
			break;
		// bottom
		case 2:
			exit.setX(exitZ);
			exit.setY(size - 1);
			break;
		// left
		case 3:
			exit.setY(exitZ);
			break;
		default:
			exit.setX(1);
			break;
		}

		// placing exit character at exit
		layout[exit.getY()][exit.getX()] ='S';
		return exit;
	}
	
	/*
	 * Construtor que gera aleatoriamente uma matriz
	 * TODO: Implementar tipo de dragao (enum)
	 */
	public Maze(int dimensao, int numDragoes, TipoDragao type){
		
		Maze myMaze=new Maze();
		size=dimensao;
		char[][] lab=new char[size][size];
		boolean[][] visitedCells=new boolean[(dimensao-1)/2][(dimensao-1)/2];
		Stack<Coord> history=new Stack<Coord>();
		Coord guideCell, exit, exitAdjacent;
		Random r=new Random();
		
		
		Arrays.fill(lab, 'X'); //preenche o labirinto com X
		Arrays.fill(visitedCells, false);
		exit=createExit(r);
		
		//atribui a guideCell uma posicao adjacente a exit
		exitAdjacent=new Coord(exit.getX(), exit.getY());
		if (exit.getX() == 0)
			exitAdjacent.setX(exitAdjacent.getX() + 1);
		else if (exit.getX() == size - 1)
			exitAdjacent.setX(exitAdjacent.getX() - 1);
		else if (exit.getY() == 0)
			exitAdjacent.setY(exitAdjacent.getY() + 1);
		else
			exitAdjacent.setY(exitAdjacent.getY() - 1);

		int guideCellX = (exitAdjacent.getX() - 1) / 2;
		int guideCellY = (exitAdjacent.getY() - 1) / 2;

		guideCell = new Coord(guideCellX, guideCellY);
		visitedCells[guideCell.getY()][guideCell.getX()] = true;
		history.push(new Coord(guideCell.getX(), guideCell.getY()));
		
		Direction direction;
		do {
			direction = Direction.values()[r.nextInt(4)];
		} while (!validMove(visitedCells, guideCell, direction));

		// updating maze
		switch (direction) {
		case Up:
			layout[guideCell.getY() * 2][guideCell.getX() * 2 + 1] = ' ';
			break;
		case Right:
			layout[guideCell.getY() * 2 + 1][(guideCell.getX() + 1) * 2] = ' ';
			break;
		case Down:
			layout[(guideCell.getY() + 1) * 2][guideCell.getX() * 2 + 1] = ' ';
			break;
		case Left:
			layout[guideCell.getY() * 2 + 1][guideCell.getX() * 2] = ' ';
			break;
		}

		moveGuideCell(direction);
		visitedCells[guideCell.getY()][guideCell.getX()] = true;
		history.push(new Coord(guideCell.getX(), guideCell.getY()));

	// creating labyrinth
	return new Maze(width, height, maze);
		
}
	
	protected boolean validMove(boolean[][] visitedCells, Coord guideCell, Direction direction){
		switch (direction) {
		case Right:
			if (guideCell.getX() + 1 >= (layout[0].length - 1) / 2)
				return false;
			break;
		case Down:
			if (guideCell.getY() + 1 >= (size - 1) / 2)
				return false;
			break;
		case Left:
			if (guideCell.getX() - 1 < 0)
				return false;
			break;
		case Up:
			if (guideCell.getY() - 1 < 0)
				return false;
			break;
		default:
			break;
		}

		return !adjacentVisited(visitedCells, guideCell, direction);
	}
	
	protected boolean adjacentVisited(boolean[][] visitedCells, Coord guideCell, Direction direction){
		switch (direction) {
		case Right:
			return visitedCells[guideCell.getY()][guideCell.getX() + 1];
		case Down:
			return visitedCells[guideCell.getY() + 1][guideCell.getX()];
		case Left:
			return visitedCells[guideCell.getY()][guideCell.getX() - 1];
		case Up:
			return visitedCells[guideCell.getY() - 1][guideCell.getX()];
		}
		return false;
	}
	
	public boolean getEnded(){
		return this.ended;
	}
	
	public void setEnded(boolean x){
		this.ended=x;
	}
	
	public char getSymbol(int x, int y){
		return this.layout[x][y];
	}
	
	public void setSymbol(int x, int y, char s){
		this.layout[x][y]=s;
	}
	
	public char[][] getLayout(){
		return this.layout;
	}
	
	public void printMaze(Hero luke, Dragon smaug, Sword excalibur){
		
		this.layout[excalibur.getPos().getX()][excalibur.getPos().getY()]=excalibur.getSymbol();
		this.layout[smaug.getPos().getX()][smaug.getPos().getY()]=smaug.getSymbol();
		this.layout[luke.getPos().getX()][luke.getPos().getY()]=luke.getSymbol();
		
		for (int i = 0; i < 10; i++) {
		    for (int j = 0; j < this.layout[0].length; j++) {
		        System.out.print(layout[i][j]+ " ");
		    }
		    System.out.print('\n');
		}
		
		
	}
	
	public void printField(){
		for (int i = 0; i < 10; i++) {
		    for (int j = 0; j < this.layout[0].length; j++) {
		    	if(this.layout[i][j]=='H' || this.layout[i][j]=='D' || this.layout[i][j]=='E')
		    		this.layout[i][j]=' ';
		        System.out.print(this.layout[i][j] + ' ');
		    }
		    System.out.print('\n');
		}
	}
	
	
}