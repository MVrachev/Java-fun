package bg.uni.sofia.fmi.mjt.dungeon.actor;

import bg.uni.sofia.fmi.mjt.dungeon.treasure.Spell;

import bg.uni.sofia.fmi.mjt.dungeon.treasure.Weapon;

public abstract class LivingCreatures implements Actor {
	
	protected String name;
	protected int health;
	protected int mana;
	protected Weapon weapon;
	protected Spell spell;
	protected int MAX_HEALTH;
	protected int MAX_MANA;
	
	public int getMAXhealth() {
		return this.MAX_HEALTH;
	}
	
	public int getMAXmana() {
		return this.MAX_MANA;
	}
		
	public String getName() {
		return name;
	}
	
	public int getHealth() {
		return health;
	}
	
	public int getMana() {
		return mana;
	}
	
	public Weapon getWeapon() {
		return weapon;
	}
	
	public Spell getSpell() {
		return spell;
	}
	
	public boolean isAlive() {
		return health > 0 ? true : false;
	}
	
	public void takeDamage(int damagePoints) {
		health-=damagePoints;
		health = health < 0 ? 0 : health;
	}
	
	public int attack() {
		if(spell == null || weapon == null)
		{
			if(spell == null)
			{
				if(weapon == null)
					return 0;
				return weapon.getDamage();
			}
			if(spell.getManaCost() <= this.mana)
			{
				mana-=spell.getManaCost();
				mana = mana < 0 ? 0 : mana;
				return spell.getDamage();
			}
			return 0;
		}
		
		if(spell.getDamage() >= weapon.getDamage())
		{
			if(mana >= spell.getManaCost())
			{
				mana-=spell.getManaCost();
				mana = mana < 0 ? 0 : mana;
				return spell.getDamage();
			}
		}
		return weapon.getDamage();
	}
}
	
	
