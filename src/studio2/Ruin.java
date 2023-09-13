package studio2;
import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
System.out.println("input starting amount: ");
double initStartAmount = in.nextDouble();

System.out.println("input chance of winning : ");
double winChance = in.nextDouble()/ 100.0;

System.out.println("input win limit: ");
double winLimit = in.nextDouble();
System.out.println("days to play: ");
int totalSimulations = in.nextInt();
int totalWin = 0;

for(int i = 1; i < totalSimulations + 1; i++) {
	double startAmount = initStartAmount;
	int plays = 0; int totalLosses = 0;
	while (startAmount > 0 && startAmount < winLimit)
	{
		double gamble = Math.random();
				if (gamble <= winChance)
				{
					startAmount += 1;
					//System.out.println (gamble);
					//System.out.println(startAmount);
					//System.out.println ("winner");
				}
				else 
				{
					startAmount -=1;
					//System.out.println (gamble);
					//System.out.println(startAmount);
					//System.out.println("loser");
				}
			plays += 1;
			if(startAmount == winLimit) {
				System.out.println("Day " + i + ": Win");
				System.out.println("Total Plays: " + plays);
			}
			else if(startAmount == 0){
				totalLosses += 1;
				System.out.println("Day " + i + ": Loss");
				System.out.println("Total Plays: " + plays);
			}
			
	}
	double ruinPercent = (double)totalLosses/ i;
	System.out.println("Total Losses " + totalLosses);
	System.out.println("Ruin Percentage: " + ruinPercent);

}
	double winPercent = (1-winChance)/winChance;
	double expectedRuin = (Math.pow(winPercent,initStartAmount)- Math.pow(winPercent,winLimit) / (1- Math.pow(winPercent,winLimit)));
	System.out.println("Expected Ruin: " + (100 - Math.round(expectedRuin)) + "%");

}
	
}
