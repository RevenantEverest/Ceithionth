# Acirhia
A fantasy RPG made using Java


### Technologies

- Java 8
- JavaFx

### Approach

Breaking down an RPG into more manageable aspects is key.
My first thought was to focus on the fight sequence. From there it was a thought of what does that sequence consist of? I came to the conclusion that there needs to be a obviously a player, an opponent, attacks and a win and lose aspect.
After that, I noticed that to spice up gameplay, more types of attacks would be needed. So I thought of ways to make those attacks different. Hard coded damage amounts aren't too pleasing and don't do well for scalability. That let me setup a player class with its own stats.
Now that every player would have their own stats, I presumed the enemy should use some stats as well, leading to the creation of the Enemy stats class.

### Bugs / Unsolved Problems

Every fight after the initial causes an error that doesn't stop the flow of gameplay, but it is an error nonetheless.