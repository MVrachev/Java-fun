## A 2D game with a single hero finding he's way to the exit of a map. ##

Here is an example of a map:

  S . # # . . . . . T <br/>
 \# T # # . . # # # .<br/>
 \# . # # # E # # # E <br/>
 \# . E . . . # # # . <br/>
 \# # # T # # # # # G

where 

'S - starting position of your hero

'H' - current position of your hero

'#' - osbsticle where your hero cant go.<br/>

'T' - Treasure.

'.' - A free position. Nothing happens if you go there.

'Е' - An enemy.

'G' - The end goal.

The hero and the enemy has a wepon and a spell at their disposal.

The treasures have three types:
Mana potion - gives mana to the hero
Health potion - gives a health to the hero
Weapon - the hero takes the weapon if the weapon is stronger than the current hero weapon
Spell - the hero takes the spell if the weapon is stronger than the current heros spell

Heroes and enemies are defined by what is more powerful: the weapon or the spell. 
If the spell is more powerful they attack the spell otherwise with the weapon.
