import java.util.Random;

public class Player {
	String name;
	int avgPoints;

	public Player (String name , int avgPoints) {
		this.name = name ;
		this.avgPoints = avgPoints;
	}
	public int simulatePoints(Random rand) {
		return avgPoints + rand.nextInt(11) - 5;
	}
}
