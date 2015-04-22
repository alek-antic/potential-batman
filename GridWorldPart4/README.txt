SeizureCritter

A SeizureCritter counts how many different colors for each actor are around it. If there are 
c or more different colors, the SeizureCritter changes to a random direction and random color
and if there is an actor immediately in front of it, the actor is pushed up to two away. This is
a seizure. If there are less than c different colors, it acts like a critter but it drops random 
colored flowers. Here, c is a value that indicates the stability of the critter. It should be 
set in the constructor. If SeizureCritter reaches 10 consecutive seizures, it dies horribly.
 