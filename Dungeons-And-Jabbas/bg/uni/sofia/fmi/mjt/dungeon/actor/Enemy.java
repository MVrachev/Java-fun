package bg.uni.sofia.fmi.mjt.dungeon.actor;

import bg.uni.sofia.fmi.mjt.dungeon.treasure.Spell;
import bg.uni.sofia.fmi.mjt.dungeon.treasure.Weapon;

public class Enemy extends LivingCreatures {
	
	
	public Enemy(String name, int health, int mana, Weapon weapon, Spell spell){
		this.name = name;
		this.health = health;
		this.MAX_HEALTH = health;
		this.mana = mana;
		this.MAX_MANA = mana;
		this.weapon = weapon;
		this.spell = spell;
	}
	
}
