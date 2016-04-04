package maze.cli;

import java.util.Scanner;
import maze.logic.*;

public class MazeApp{
	
	
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
		
		//myMaze.printMaze(luke, smaug, excalibur);	
		
		char movement;
		
		
		/* Ciclo do jogo
		 * 
		 */
		while(true){
			Scanner input=new Scanner(System.in);
			movement = input.next().charAt(0);
			myMaze.moveElements(Direction direction);
			if(luke.getDead()){
				System.out.print("You Died!!!");
				break;
			}
			if(myMaze.getEnded()){
				System.out.print("You won the game!!!");
				break;
			}
			myMaze.printMaze();

		}*/
	}
	
	
}

