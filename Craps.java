import java.util.Random;

/**
 * This program simulates a craps game. It rolls two dice by picking a random number from 1 to 6 and adds the dice together.
 * It then determines the game status based off if the first sum is equal to any common rolls significant to a Craps game.
 * If the player does not win or lose on the first try, their initial sum is recorded.
 * The game repeats until either the sum of the player's dice is rolled again and the player wins, or the sum equals seven and the player loses.
 */



public class Craps extends Main{
    static final Random randomNumbers = new Random();
    private enum Status { CONTINUE, WON, LOST };
    private static final int SNAKE_EYES = 2;
    private static final int TREY = 3;
    private static final int SEVEN = 7;
    private static final int YO_LEVEN = 11;
    private static final int BOX_CARS = 12;
    public static int[] winArray = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    public static int[] lossArray = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    //plays one game of craps
    public static void playCraps() {
        int myPoint = 0;
        Status gameStatus;
        int sumOfDice = rollDice();
        int roll = 1;


        switch (sumOfDice) {
            case SEVEN:
            case YO_LEVEN:
                gameStatus = Status.WON;
                break;
            case SNAKE_EYES:
            case TREY:
            case BOX_CARS:
                gameStatus = Status.LOST;
                break;
            default:
                gameStatus = Status.CONTINUE;
                myPoint = sumOfDice;
                break;
        }

        while (gameStatus == Status.CONTINUE) {
            sumOfDice = rollDice();
            roll += 1;

            if (sumOfDice == myPoint) {
                gameStatus = Status.WON;
            }
            else if (sumOfDice == SEVEN) {
                gameStatus = Status.LOST;
            }
        }

        if (gameStatus == Status.WON) {
            if (roll <= 20) {
                winArray[roll] += 1;
            } else {
                lossArray[21] += 1;
            }
        } else {
            if (roll <= 20) {
                lossArray[roll] += 1;
            } else {
                lossArray[21] += 1;
            }
        }
    }

    //rolls two dice by randomly generating a number from 1 to 6 and adds the values together
    public static int rollDice() {
        int die1 = 1 + randomNumbers.nextInt( 6 );
        int die2 = 1 + randomNumbers.nextInt( 6 );
        int sum = die1 + die2;
        return sum;
    }
}
