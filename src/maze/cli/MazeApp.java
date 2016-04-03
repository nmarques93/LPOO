package maze.cli;

import java.util.Scanner;
import maze.logic.*;

public class MazeApp{
	
	/*public Maze newGame(String[][] lo){
		Maze myMaze = null;
		myMaze.setLayout(lo);
		return myMaze;
	}*/
	
	//Retirar estas variaveis e deixa-las apenas no maze.java
	static Hero luke=new Hero();
	static Dragon smaug=new Dragon();
	static Sword excalibur=new Sword();
	
	
	public static void main(String[] args){
		char[][] lo={{'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'},
				{'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
				{'X', ' ', 'X', 'X', ' ', 'X', ' ', 'X', ' ', 'X'},
				{'X', ' ', 'X', 'X', ' ', 'X', ' ', 'X', ' ', 'X'},
				{'X', ' ', 'X', 'X', ' ', 'X', ' ', 'X', ' ', 'X'},
				{'X', ' ', ' ', ' ', ' ', ' ', ' ', 'X', ' ', 'S'},
				{'X', ' ', 'X', 'X', ' ', 'X', ' ', 'X', ' ', 'X'},
				{'X', ' ', 'X', 'X', ' ', 'X', ' ', 'X', ' ', 'X'},
				{'X', ' ', 'X', 'X', ' ', ' ', ' ', ' ', ' ', 'X'},
				{'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'}		
		};
		
		Maze myMaze=new Maze(lo);
		
		myMaze.printMaze(luke, smaug, excalibur);	
		
		char movement;
		
		
		/* Ciclo do jogo
		 * 
		 */
		while(true){
			Scanner input=new Scanner(System.in);
			movement = input.next().charAt(0);
			luke.move(myMaze, excalibur, smaug, movement);
			smaug.move(myMaze, luke);
			if(luke.getDead()){
				System.out.print("You Died!!!");
				break;
			}
			if(myMaze.getEnded()){
				System.out.print("You won the game!!!");
				break;
			}
			myMaze.printMaze(luke, smaug, excalibur);

		}
	}
	
	
}

