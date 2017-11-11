package bg.uni.sofia.fmi.mjt.dungeon.treasure;

import bg.uni.sofia.fmi.mjt.dungeon.actor.Hero;

public class Spell implements Treasure{
	
	private String name;
	private int damage;
	private int manaCost;
	
	public Spell(String name, int damage, int manaCost){
		this.name = name;
		this.damage = damage;
		this.manaCost = manaCost;
		if(damage < 0)
		{	
			this.damage = 0;
			this.manaCost = 0;
		}
	}
	
	public void setSpell(String name, int damage, int manaCost){
		this.name = name;
		this.damage = damage;
		this.manaCost = manaCost;
		if(damage < 0)
		{	
			this.damage = 0;
			this.manaCost = 0;
		}
	}
	
	public String getName() {
		return name;
	}
	
	public int getDamage() {
		return damage;
	}
	
	public int getManaCost() {
		return manaCost;
	}

	
	// If hereoes spell damage is smaller than this spell damage
	// then change it
	
	public String collect(Hero hero) {
		if(hero == null)
			return null;
		if(hero.getSpell() == null)
		{
			hero.setSpell(this);
			return "Spell found! Damage points: " + this.damage + ", Mana cost: " + this.manaCost;
		}
		
		if(hero.getSpell().getDamage() < damage)
		{
			hero.setSpell(this);
			return "Spell found! Damage points: " + this.damage + ", Mana cost: " + this.manaCost;
		}
		return null;
	}

	

}
