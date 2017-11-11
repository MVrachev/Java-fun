import java.util.Scanner;

import bg.uni.sofia.fmi.mjt.dungeon.GameEngine;
import bg.uni.sofia.fmi.mjt.dungeon.actor.Enemy;
import bg.uni.sofia.fmi.mjt.dungeon.actor.Hero;
import bg.uni.sofia.fmi.mjt.dungeon.actor.Position;
import bg.uni.sofia.fmi.mjt.dungeon.treasure.HealthPotion;
import bg.uni.sofia.fmi.mjt.dungeon.treasure.ManaPotion;
import bg.uni.sofia.fmi.mjt.dungeon.treasure.Spell;
import bg.uni.sofia.fmi.mjt.dungeon.treasure.Treasure;
import bg.uni.sofia.fmi.mjt.dungeon.treasure.Weapon;

public class Main {

	
	public static void print(char[][] map, int rows, int columns) {
		for(int i = 0; i < rows; ++i) {
			for (int j = 0; j < columns; ++j) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String [] args) {
		
		//System.out.println("Hiii");
		//System.out.println(LEFT);
		
		/*
		Scanner sc = new Scanner(System.in);
		String input = new String();
		char[] next = null; 
		int rows = 0, columns = 0;
		*/
		
		/*
		System.out.println("Enter rows and columns: ");
		input = sc.nextLine();
		rows = sc.nextInt();
		columns = sc.nextInt();
		/*
		char map[][] = null;
		map = new char[rows][];
		for(int i = 0; i < rows; ++i) {
			map[i] = new char[columns];
		}
		
        */
        
		/*
		char[][] map = {{'S','.','#','#','.','.','.','.','.','T'},
				  {'#','T','#','#','.','.','#','#','#','.'},
				  {'#','.','#','#','#','E','#','#','#','E'}, 
				  {'#','.','E','.','.','.','#','#','#','.'}, 
				  {'#','#','#','T','#','#','#','#','#','G'}};
		
		rows = 5;
		columns = 10;
		
		
		// 0 left; 1 up; 2 right; 3 down
		
		int numberEnemies = 3, numberTreasures = 3, hp = 9999, manna = 9999, command = 0;
		//Enemy [] enemies = null;
		Enemy[]enemies = new Enemy[numberEnemies];
		hp = 300;
		manna = 300;
		Weapon weapon = new Weapon("axe", 200);
		Spell spell = new Spell("fireball", 100, 100);
		enemies[0] = new Enemy("Gosho",hp, manna, weapon, spell);
		weapon.setWeapon("little sword", 200);
		spell.setSpell("cool spell", 150, 200);
		enemies[1] = new Enemy("Steve", 500, 1000, weapon, spell);
		weapon.setWeapon("sword", 300);
		spell.setSpell("cool spell", 200, 200);
		enemies[2] = new Enemy("Fichak", 500, 1000, weapon, spell);
		
		Treasure[] treasures = new Treasure[numberTreasures];
		weapon.setWeapon("Cool Sword", 300);
		
		treasures[0] = new Weapon("Cool Sword", 300);
		treasures[1] = new HealthPotion(400);
		treasures[2] = new ManaPotion(300);
		
		Position position = new Position(0,0);
		Hero hero = new Hero("Martin", hp, manna, position); 
		weapon.setWeapon("Great Knight Sword", 1000);
		hero.setWeapon(weapon);
		
		GameEngine game = new GameEngine(map,hero, enemies, treasures);
		print(map, rows,columns);
		while(hero.isAlive() && game.getGameOver() == false) {
			System.out.println("Enter command between 0 and 3");
			command = sc.nextInt();
			System.out.println(game.makeMove(command));
			print(game.getMap(), rows,columns);
		}
		
		
		sc.close();
		*/
		
		/*
		Scanner sc = new Scanner(System.in);
		String input = new String();
		
		char[][] map = { {'S', 'T', '#'}, {'#', 'E', '#'}, {'#', 'T', 'G'}};
		int rows = 3, columns = 3;

		int numberEnemies = 1, numberTreasures = 2, hp = 9999, manna = 9999, command = 0;
		//Enemy [] enemies = null;
		Enemy[]enemies = new Enemy[numberEnemies];
		hp = 1000;
		manna = 300;
		Weapon weapon = new Weapon("axe", 6000);
		Spell spell = new Spell("fireball", 100, 100);
		enemies[0] = new Enemy("Gosho",hp, manna, weapon, spell);
		
		
		Treasure[] treasures = new Treasure[numberTreasures];
		weapon.setWeapon("Cool Sword", 300);
		
		treasures[0] = new HealthPotion(400);
		treasures[1] = new ManaPotion(300);
		
		Position position = new Position(0,0);
		Hero hero = new Hero("Martin", hp, manna, position); 
		weapon.setWeapon("Great Knight Sword", 500);
		hero.setWeapon(weapon);
		spell.setSpell("FIREBALL", 600, 3);
		hero.setSpell(spell);
		
		GameEngine game = new GameEngine(map,hero, enemies, treasures);
		print(map, rows,columns);
		while(hero.isAlive() && game.getGameOver() == false) {
			System.out.println("Enter command between 0 and 3");
			command = sc.nextInt();
			System.out.println(game.makeMove(command));
			print(game.getMap(), rows,columns);
		}
		
		sc.close();
		*/
	}
}

