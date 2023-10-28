import java.util.Random;
import java.util.Scanner;

public class GameGuessing {
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        Random random=new Random();
        int minRange=1;
        int maxRange=100;
        int maxAttempts=10;
        int score=0;

        System.out.println("Welcome to the Number Guessing Game!");
        boolean playAgain=true;

        while(playAgain)
        {
            int targetNumber= random.nextInt(maxRange-minRange)+minRange;
            int attempts=0;
            boolean correctGuess=false;

            System.out.println("I have Selected a number between "+minRange+ "and" +maxRange+".Try to guess it!");

            while(attempts<maxAttempts && !correctGuess)
            {
                System.out.println("Enter your guess");
                int userGuess= scanner.nextInt();
                attempts++;

                if (userGuess==targetNumber)
                {
                    System.out.println("Congratulations!You've guessed the correct number in "+attempts+"attempts.");
                    score++;
                    correctGuess=true;
                }
                else if (userGuess<targetNumber) {

                    System.out.println("Too low! Try again.");
                }
                else {
                    System.out.println("Too high! Try again");
                }
            }

            if (!correctGuess)
            {
                System.out.println("Sorry,you've used all your attempts. The Correct Number was" +targetNumber+".");
            }
            System.out.println("Play again? (yes/no)");
            String playAgainResource=scanner.next().toLowerCase();

            if(!playAgainResource.equals("yes"))
            {
                playAgain=false;
                System.out.println("Thanks for Playing! Your total score is: "+score);
            }
        }
        scanner.close();

    }
}
