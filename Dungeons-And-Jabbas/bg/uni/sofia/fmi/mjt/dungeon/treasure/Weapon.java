package bg.uni.sofia.fmi.mjt.dungeon.treasure;

import bg.uni.sofia.fmi.mjt.dungeon.actor.Hero;

public class Weapon implements Treasure {

	private String name;
	private int damage = 0;
	
	
	public Weapon(String name, int damage){
		this.name = name;
		this.damage = damage;
		if(damage < 0)
			this.damage = 0;
	}
	
	public String getName() {
		return name;
	}
	
	public int getDamage() {
		return damage;
	}
	
	// If hereoes weapon damage is smaller than this weapon damage
	// then change it
	public String collect(Hero hero) {
		if(hero == null)
			return null;
		if(hero.getWeapon() == null)
		{
			hero.setWeapon(this);
			return "Weapon found! Damage points: " + this.damage;
		}
		
		if(hero.getWeapon().getDamage() < damage)
		{
			hero.setWeapon(this);
			return "Weapon found! Damage points: " + this.damage;
		}
		return null;
	}
	
	public void setWeapon(String name, int damage) {
		this.name = name;
		this.damage = damage;
		if(damage < 0)
			this.damage = 0;
	}

}
