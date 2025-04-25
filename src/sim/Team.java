package sim;

import java.util.*;

public class Team {
	String name;
	int strength;
	List<Player> players;

	public Team(String name, int strength, List<Player> players) {
		this.name = name; 
		this.strength = strength;
		this.players = players;
	}

	public int simulateScore(Random rand, boolean homeGame) {
		int total = 0;
		for (Player p : players) {
			total += p.simulatePoints(rand);
		}

		int base = rand.nextInt(20);
		total += base + (strength / 10);
		if (homeGame) total += 5;
		return total;
	}

	public String topScorer(Random rand) {
		Player top = null;
		int max =-1;
		for (Player p: players ) { 
			int points = p.simulatePoints (rand);
			if (points > max) { 
				max = points;
				top = p;
			}
		}
		return top.name + " (" + max + " pts)";
	}
}
