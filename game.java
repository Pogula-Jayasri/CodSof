import java.util.Random;
import java.util.Scanner;

public class game{
    public static void main(String[] args)
    {
        int min=1,max=100,score=0,no_of_attempts=0,max_attempts=5;
        Scanner sc=new Scanner(System.in);
        //Using random function to generate random number
        Random rand=new Random();
        int randNum=rand.nextInt(max-min+1)+min;
        boolean playAgain=true;
        System.out.println("***WELCOME TO THE NEW GAME***");
        System.out.println(" Enter your guess Number between (1-100) :");
        while(playAgain)
        {
            System.out.println("PLEASE GUESS THE NUMBER:");
            int guessNum=sc.nextInt();
            no_of_attempts++;
            if(guessNum==randNum)
            {
                System.out.println("CONGRATULATIONS!!!! you won and you guessed the number in "+ no_of_attempts +"attempts");
                score++;
                break;
            }
            else if(guessNum < randNum)
            {
                System.out.println("The guessed number is tooo small...Please try again");
            }
            else
                System.out.println("The guessed number is too high....Please try again");
            if(no_of_attempts==max_attempts)
            {
                System.out.println("Out of attempts!!! The number is "+randNum);
                break;
            }
            //Asking user whether they want to continue or not
            System.out.println("Do you want to play again??(y/n):");
        String input=sc.next();
        if(input.equalsIgnoreCase("n"))
            break;

        }
        
        sc.close();
        System.out.println("Game Over !!! Your score is "+ score);//printing total score after maximum attempts
        System.out.println("***THANKS FOR PLAYING........***");
        
    }
}