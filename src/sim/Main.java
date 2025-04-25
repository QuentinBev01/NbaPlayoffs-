package sim;

import java.util.Random;
import java.util.*;

public class Main { 
	public static void main(String[] args) {
		Random rand = new Random();

		Team Warriors = new Team("Warriors", 90, Arrays.asList(
			new Player("Stephen Curry", 30),
			new Player("Jimmy Butler", 25),
			new Player("Draymond green", 18)
		));

		Team Rockets = new Team("Rockets", 87, Arrays.asList(
			new Player("Alperen Sengun",25),
			new Player("Jalen Green", 24),
			new Player("Amen Thompson",20)
		));

		simulateSeries(Warriors, Rockets, rand);
	}

	public static void simulateSeries(Team t1, team t2, Random rand) { 
		int t1Wins = 0, t2Wins = 0;
		int game = 1;

		System.out.println("** NBA Playoff Simulation **");
		System.out.println(t1.name + " vs " + t2.name);
		System.out.println("---------------------------\n");

		while (t1Wins < 4 && t2Wins < 4) { 
			boolean t1Home = (game % 2 != 0);
	
			int t1Score = t1.simulateScore(rand, t1Home);
		    int t2Score = t2.simulateScore(rand, !t1Home);

			System.out.println("Game " + game + " (" + (t1Home ? t1.name : t2.name) + " home):");
			System.out.println(t1.name + " - " + t1Score + " | Top Scorer: " + t1.topScorer(rand));
			System.out.println(t2.name + " - " + t2Score + " | Top Scorer: " + t2.topScorer(rand));

			if (t1Score > t2Score) { 
				t1Wins++;
				System.out.println("Winner: " +t1.name + "\n");
			}     else {
				t2Wins ++ ;
				System.out.println("Winner: " +t2.name + "\n");
			}
															
			game++;
		}
		System.out.println ("Series Over!");
		if (t1Wins == 4) {
			System.out.println(t1.name + " wins the series " +t1Wins + "-" + t2Wins);
		}     else {
			System.out.println(t2.name + "wins the series " + t2Wins + "-" + t1Wins);
		}	
	}
}
