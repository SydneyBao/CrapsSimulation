/**
 * This program calls on the Craps class 1000000 times and outputs how many games were won or loss per roll,
 * the chances of winning based on the simulation data, and the average number of rolls it took to win
 */



public class Main {

    public static void main(String[] args) {

        int rollFrequency = 0;
        int totalRolls = 0;
        int wins = 0;
        double winPercentage;
        double averageRolls;

        for (int i = 0; i < 1000000; i++) {
            Craps obj = new Craps();
            Craps.playCraps();
        }

        for ( int i = 1; i < Craps.winArray.length; i++) {
            if (i <= 20) {
                System.out.println(Craps.winArray[i] + " games won and " + Craps.lossArray[i] + " games lost on roll #" + i);
            } else {
                System.out.println(Craps.winArray[i] + " games won and " + Craps.lossArray[i] + " games lost on rolls after the 20th roll");
            }

            wins += Craps.winArray[i];
            rollFrequency += i * (Craps.winArray[i] + Craps.lossArray[i]);
            totalRolls += (Craps.winArray[i] + Craps.lossArray[i]);
        }

        winPercentage = Double.valueOf(wins) * 100 / 1000000;
        averageRolls = Double.valueOf(rollFrequency) * 100 / totalRolls;
        System.out.println("\nThe chances of winning are " + wins + " / 1000000 = " + Math.round(winPercentage * 100.0) / 100.0 + "%");
        System.out.println("The average game length is " + Math.round(averageRolls * 100.0) / 100.0 + " rolls");
    }

}