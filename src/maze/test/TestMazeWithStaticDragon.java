package maze.test;
import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;
import maze.logic.*;

public class TestMazeWithStaticDragon {
	char [][] m1 = {{'X', 'X', 'X', 'X', 'X'},
			{'X', ' ', ' ', 'H', 'S'},
			{'X', ' ', 'X', ' ', 'X'},
			{'X', 'E', ' ', 'D', 'X'},
			{'X', 'X', 'X', 'X', 'X'}};
			
	@Test
	public void testMoveHeroToFreeCell() {
	Maze maze = new Maze(m1);
	assertEquals(new Coord(1, 3), maze.getHeroPosition());
	maze.moveHeroLeft();
	assertEquals(new Coord(1, 2), maze.getHeroPosition());
	}
			
	@Test
	public void testHeroDies() {
	Maze maze = new Maze(m1);
	assertEquals(MazeStatus.HeroUnarmed, maze.getStatus());
	maze.moveHeroDown();
	assertEquals(MazeStatus.HeroDied, maze.getStatus());
			}
}
