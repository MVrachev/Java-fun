package bg.uni.sofia.fmi.mjt.dungeon;

import bg.uni.sofia.fmi.mjt.dungeon.actor.Enemy;
import bg.uni.sofia.fmi.mjt.dungeon.actor.Hero;
import bg.uni.sofia.fmi.mjt.dungeon.treasure.Treasure;

public class GameEngine {

	private char [][]map;
	private Hero hero;
	private Enemy[] enemies;
	private Treasure[] treasures;
	private int currEnemy;
	private int currTreasure;
	private boolean gameOver = false;
	
	public GameEngine(char[][]map, Hero hero, Enemy[] enemies, 
			Treasure[] treasures){
		this.map = map;
		this.hero = hero;
		this.enemies = enemies;
		this.treasures = treasures;
	}
	
	public char[][]getMap(){
		return map;
	}
	
	public boolean getGameOver() {
		return gameOver;
	}
	
	public String makeMove(int command) {
		
		int nextRow = hero.getPosition().getX(), 
				nextColumn = hero.getPosition().getY();
		switch(command) {
		case 0: 
			nextColumn -=1; break;
		case 1:
			nextRow -=1; break;
		case 2:
			nextColumn += 1; break;
		case 3:
			nextRow += 1; break;
		default:
			return "Unknown command entered.";
		}
		
		/*
		// Could be an exception!!
		if( nextRow > numRows || nextColumn >= numColumns ) {
			return "Unavailble move on the map!";
		}
		*/
		
		String result = null;
		if(map[nextRow][nextColumn] == '#') {
			return "Wrong move. "
					+ "There is an obstacle and you cannot bypass it.";
		}
		else if(map[nextRow][nextColumn] == 'T') {
			map[hero.getPosition().getX()][hero.getPosition().getY()] = '.';
			map[nextRow][nextColumn] = 'H';
			hero.getPosition().setPosition(nextRow, nextColumn);
			result = treasures[currTreasure].collect(this.hero);
			++currTreasure;
			return result;
		}
		else if(map[nextRow][nextColumn] == 'E') {
			while (hero.isAlive() && enemies[currEnemy].isAlive()) {
				enemies[currEnemy].takeDamage(hero.attack());
				if(enemies[currEnemy].isAlive()) {
					hero.takeDamage(enemies[currEnemy].attack());
				}
			}
			if(hero.isAlive())
			{
				map[hero.getPosition().getX()][hero.getPosition().getY()] = '.';
				map[nextRow][nextColumn] = 'H';
				hero.getPosition().setPosition(nextRow, nextColumn);
				++currEnemy;
				return "Enemy died.";
			}
			else
				return "Hero is dead! Game over!";
		}
		else if(map[nextRow][nextColumn] == 'G') {
			gameOver = true;
			return "You have successfully "
					+ "passed through the dungeon. Congrats!";
		}
		else {
			map[hero.getPosition().getX()][hero.getPosition().getY()] = '.';
			hero.getPosition().setPosition(nextRow, nextColumn);
			map[nextRow][nextColumn] = 'H';
			return "You moved successfully to the next position.";
		}
			
		
		
	}
	
	
}
