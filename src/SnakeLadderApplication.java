import model.Game;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class SnakeLadderApplication {
        public static void main(String[] args) throws InterruptedException {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter board size");
            int boardSize = sc.nextInt();
            System.out.println("Enter number of players");
            int numOfPlayers = sc.nextInt();
            System.out.println("Enter number of snakes");
            int numOfSnakes = sc.nextInt();
            System.out.println("Enter number of ladders");
            int numOfLadders = sc.nextInt();
            System.out.println("Enter maximum number on die");
            int dieMax = sc.nextInt();
            Game game = new Game(numOfPlayers, numOfLadders, numOfSnakes, boardSize, dieMax);
            game.playGame();
        }
}
