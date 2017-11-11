package bg.uni.sofia.fmi.mjt.dungeon.actor;

import bg.uni.sofia.fmi.mjt.dungeon.treasure.Spell;
import bg.uni.sofia.fmi.mjt.dungeon.treasure.Weapon;

public class Hero extends LivingCreatures{

	private Position position;
	
	
	public Hero(String name, int health, int mana, Position position){
		this.name = name;
		this.health = health;
		this.MAX_HEALTH = health;
		this.mana = mana;
		this.MAX_MANA = mana;
		this.position = position;
	}
	
	
	public Position getPosition() {
		return position;
	}
	
	// Setters
	
	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}
	
	public void setSpell(Spell spell) {
		this.spell = spell;
	}
	
	
	// Some more special functions
	
	
	
	public void takeHealing(int healingPoints) {
		if(isAlive() == true)
		{
			health+=healingPoints;
			health = health > MAX_HEALTH ? MAX_HEALTH : health;
		}
	}
	
	public void takeMana(int manaPoints) {
		mana+=manaPoints;
		mana = mana > MAX_MANA ? MAX_MANA : mana;
	}
	
	
	public void equip(Weapon weapon){
		
		if(weapon == null)
			return;
		if(this.weapon == null)
		{
			this.setWeapon(weapon);
			return;
		}
		if(this.weapon.getDamage() < weapon.getDamage())
		{
			this.setWeapon(weapon);
		}
	}
	
	public void learn(Spell spell) {
		if(spell == null)
			return;
		if(this.spell == null)
		{
			this.setSpell(spell);
			return;
		}
		if(this.spell.getDamage() <= spell.getDamage())
		{
			this.setSpell(spell);
		}
	}
	
	
}
